
package com.hexaware.ftp85.persistence;

import com.hexaware.ftp85.model.LeaveDetails;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
//import java.util.Date;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * The DAO class for leavedetails.
 */
public interface LeaveDAO  {
  /**
   * return all the details of all the Leavedetails.
   * @return the Leavedetails array
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS")
  @Mapper(LeaveMapper.class)
  List<LeaveDetails> list();

  /**
   * return all the details of the selected Leavedetails.
   * @param leaId the id of the Leavedetails
   * @return the Leavedetails object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LEA_ID = :leaId")
  @Mapper(LeaveMapper.class)
  LeaveDetails find(@Bind("leaId") int leaId);

  /**
   * return all the details of the selected Leavedetails.
   * @param leaMgrCom The comments made by the manager.
   * @param leaSta The updated leave status after manager's review.
   * @param leaId The Id number of the leave Record.
   * @param argSslSta the status of SSL.
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET LEA_MGRCOM = :leaMgrCom, LEA_STA = :leaSta, "
      + " LEA_SSLAPPSTA = :sslSta WHERE LEA_ID = :leaId")
  void comment(@Bind("leaMgrCom") String leaMgrCom, @Bind("leaSta") String leaSta, @Bind("leaId") int leaId,
              @Bind("sslSta") String argSslSta);
  /**
  * returns all the details of the employee which comes under the given manager whom's mgrId is given.
  * @param empId The Id of the manager.
  * @return Leave Details array object.
  */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID IN "
           + " (SELECT E2.EMP_ID FROM "
           + " EMPLOYEE_DETAILS E1 INNER JOIN "
           + " EMPLOYEE_DETAILS E2 ON E1.EMP_ID = E2.EMP_MGRID WHERE E1.EMP_ID = :empId) AND "
           + " LEA_STA = 'PENDING' ORDER BY EMP_ID")
  @Mapper(LeaveMapper.class)
  List<LeaveDetails> pending(@Bind("empId") int empId);

  /**
   * return all the details of the selected employee.
   * @param empId the id of the employee
   * @param leaSdate leaveStartDate of employee
   * @param leaEdate leaveEndDate of employee.
   * @return the total record count
   */
  @SqlQuery("SELECT COUNT(*) FROM LEAVE_DETAILS "
      +    " WHERE EMP_ID = :empId AND (LEA_SDATE BETWEEN :leaSdate AND :leaEdate "
      +    " OR LEA_EDATE BETWEEN :leaSdate AND :leaEdate)")
  int count(@Bind("empId") int empId, @Bind("leaSdate") String leaSdate,
      @Bind("leaEdate") String leaEdate);

  /**
   * return all the details of the selected employee.
   * @param empId the id of the employee
   * @param sslSta the status for SSL
   * @return the total record count
   */
  @SqlQuery("SELECT COUNT(*) FROM LEAVE_DETAILS "
      +     " WHERE EMP_ID = :empId AND LEA_SSLAPPSTA = :sslSta")
  int checkSsl(@Bind("empId") int empId, @Bind("sslSta") String sslSta);

  /**
   * return all the details of the employee leaves.
   * @param leaId the id of the LeaveDetails.
   * @return the LeaveDetails under a manager.
   */
  @SqlQuery("SELECT E1.EMP_MGRID FROM EMPLOYEE_DETAILS E1 "
           + " JOIN EMPLOYEE_DETAILS E2 ON E1.EMP_MGRID = E2.EMP_ID WHERE E1.EMP_ID =(SELECT EMP_ID FROM LEAVE_DETAILS "
           + " WHERE LEA_ID = :leaId)")
    int showManager(@Bind("leaId") int leaId);

  /**
   * return all the details of the employee leaves.
   * @param empId the id of the LeaveDetails
   * @return the LeaveDetails Array object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID = :empId")
  @Mapper(LeaveMapper.class)
  List<LeaveDetails> empHistory(@Bind("empId") int empId);

  /**
  * @param empId the ID the employee.
  * @param leaSdate the start date of the employee.
  * @param leaEdate the end date of the employee.
  * @param leaNdays the number of days of the employee.
  * @param leaType the leaveType details of employee.
  * @param leaSta the LeaveStatus details of employee.
  * @param leaRea the reason for applying.
  * @param leaAppOn the applied date of the employee.
 */
  @SqlUpdate("INSERT INTO LEAVE_DETAILS  "
      +
      "             (EMP_ID, "
      +
      "              LEA_SDATE, "
      +
      "              LEA_EDATE, "
      +
      "              LEA_NDAYS, "
      +
      "              LEA_TYPE, "
      +
      "              LEA_STA, "
      +
      "              LEA_REA, "
      +
      "              LEA_APPON ) "
      +
      "VALUES       ( "
      +
      "              :empId, "
      +
      "              :leaSdate, "
      +
      "              :leaEdate, "
      +
      "              :leaNdays, "
      +
      "              :leaType, "
      +
      "              :leaSta, "
      +
      "              :leaRea, "
      +
      "              :leaAppOn ) ")
void applyLeave(@Bind("empId") int empId,
       @Bind("leaSdate") String leaSdate,
       @Bind("leaEdate") String leaEdate,
       @Bind("leaNdays") int leaNdays,
       @Bind("leaType") String leaType,
       @Bind("leaSta") String leaSta,
       @Bind("leaRea") String leaRea,
       @Bind("leaAppOn") String leaAppOn);


  /**
  * @param empId the ID the employee.
  * @param leaSdate the start date of the employee.
  * @param leaEdate the end date of the employee.
  * @param leaNdays the number of days of the employee.
  * @param leaType the leaveType details of employee.
  * @param leaSta the LeaveStatus details of employee.
  * @param leaRea the reason for applying.
  * @param leaAppOn the applied date of the employee.
  * @param sslSta the status for SSl
 */
  @SqlUpdate("INSERT INTO LEAVE_DETAILS  "
      +
      "             (EMP_ID, "
      +
      "              LEA_SDATE, "
      +
      "              LEA_EDATE, "
      +
      "              LEA_NDAYS, "
      +
      "              LEA_TYPE, "
      +
      "              LEA_STA, "
      +
      "              LEA_REA, "
      +
      "              LEA_APPON, "
      +
      "              LEA_SSLAPPSTA ) "
      +
      "VALUES       ( "
      +
      "              :empId, "
      +
      "              :leaSdate, "
      +
      "              :leaEdate, "
      +
      "              :leaNdays, "
      +
      "              :leaType, "
      +
      "              :leaSta, "
      +
      "              :leaRea, "
      +
      "              :leaAppOn,"
      +
      "              :sslSta )")
void applyLeaveSSL(@Bind("empId") int empId,
       @Bind("leaSdate") String leaSdate,
       @Bind("leaEdate") String leaEdate,
       @Bind("leaNdays") int leaNdays,
       @Bind("leaType") String leaType,
       @Bind("leaSta") String leaSta,
       @Bind("leaRea") String leaRea,
       @Bind("leaAppOn") String leaAppOn,
       @Bind("sslSta") String sslSta);


  /**
  * close with no args is used to close the connection.
  */
  void close();
}
