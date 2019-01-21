package com.hexaware.ftp85.model;
import com.hexaware.ftp85.persistence.DbConnection;
import com.hexaware.ftp85.persistence.LeaveDAO;
import com.hexaware.ftp85.persistence.EmployeeDAO;
import java.util.Objects;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
//import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.concurrent.TimeUnit;
//import java.util.Calendar;

/**
 * LeaveDetails class to store employee leave details.
 * @author hexaware
 */
public class LeaveDetails {

  /**
   * leaId to store leave id.
   * sdate to store Starting date of leave.
   * edate to store ending date of leave.
   * ndays to store No. of days on leave.
   * leatype to store Type of leave.
   * leaSta to store Status of leave.
   * leaRea to store Reason for leave.
   * leaAppOn to store Applied date of leave.
   * leaMgrCom to store Manager comments.
   * empId to store employee id.
   */
  private int leaId;
  private Date sdate;
  private Date edate;
  private int ndays;
  private LeaveType leatype;
  private LeaveStatus leaSta;
  private String leaRea;
  private Date leaAppOn;
  private String leaMgrCom;
  private int empId;
  private String sslSta;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LeaveDetails lea = (LeaveDetails) obj;
    if (Objects.equals(leaId, lea.leaId) && Objects.equals(sdate, lea.sdate)
        && Objects.equals(edate, lea.edate) && Objects.equals(ndays, lea.ndays)
        && Objects.equals(leatype, lea.leatype) && Objects.equals(leaSta, lea.leaSta)
        && Objects.equals(leaRea, lea.leaRea) && Objects.equals(leaAppOn, lea.leaAppOn)
        && Objects.equals(leaMgrCom, lea.leaMgrCom) && Objects.equals(empId, lea.empId)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(leaId, sdate, edate, ndays, leatype, leaSta, leaRea, leaAppOn, leaMgrCom, empId, sslSta);
  }

  @Override
  public final String toString() {
    return "LeaveID" + leaId + "\nLeave Start Date" + sdate + "\nLeave End Date" + edate + "No of Leave Days"
            + ndays + "\nLeave Type" + leatype + "\nLeave Status" + leaSta + "\nLeave Applied on" + leaAppOn
            + "\nManager's comment" + leaMgrCom + "\nEmployee Id" + empId + "\nSSL Status" + sslSta;
  }

   /**
   * Gets the Leave Id.
   * @return this Leave's ID.
   */
  public final int getLeaId() {
    return leaId;
  }

  /**
   *
   * @param argLeaId to set employee id.
   */
  public final void setLeaId(final int argLeaId) {
    this.leaId = argLeaId;
  }

  /**
   *
   * @param argSdate to set leave start date.
   */
  public final void setSdate(final Date argSdate) {
    this.sdate = argSdate;
  }

  /**
   * Gets the leave start date.
   * @return this leave start date.
   */
  public final Date getSdate() {
    return sdate;
  }

  /**
  *
  * @param argEdate to set leave end date.
  */
  public final void setEdate(final Date argEdate) {
    this.edate = argEdate;
  }

  /**
  * Gets the leave end date.
  * @return this leave end date.
  */
  public final Date getEdate() {
    return edate;
  }

  /**
  *
  * @param argNdays to set no.of days on leave.
  */
  public final void setNdays(final int argNdays) {
    this.ndays = argNdays;
  }

  /**
  * Gets the no.of days on leave.
  * @return this no.of days.
  */
  public final int getNdays() {
    return ndays;
  }

  /**
  *
  * @param argleatype to set leave type.
  */
  public final void setLeatype(final LeaveType argleatype) {
    this.leatype = argleatype;
  }

  /**
  * Gets the leave type.
  * @return this leave type.
  */
  public final LeaveType getLeatype() {
    return leatype;
  }

  /**
   * Gets the LeaveStatus.
   * @return this leave status.
   */
  public final LeaveStatus getLeaSta() {
    return leaSta;
  }

  /**
   *
   * @param argLeaSta to set leave status.
   */
  public final void setLeaSta(final LeaveStatus argLeaSta) {
    this.leaSta = argLeaSta;
  }

  /**
   * Gets the reason for leave.
   * @return this reason for leave.
   */
  public final String getleaRea() {
    return leaRea;
  }

  /**
   *
   * @param argLeaRea to set reason for leave.
   */
  public final void setLeaRea(final String argLeaRea) {
    this.leaRea = argLeaRea;
  }

  /**
   * Gets the leave applied date.
   * @return this leave applied date.
   */
  public final Date getleaAppOn() {
    return leaAppOn;
  }

  /**
   *
   * @param argLeaAppOn to leave applied date.
   */
  public final void setLeaAppOn(final Date argLeaAppOn) {
    this.leaAppOn = argLeaAppOn;
  }

  /**
   * Gets the Manager comments.
   * @return this Manager comments.
   */
  public final String getLeaMgrCom() {
    return leaMgrCom;
  }

  /**
   * @param argLeaMgrCom to set manager comments.
   */
  public final void setLeaMgrCom(final String argLeaMgrCom) {
    this.leaMgrCom = argLeaMgrCom;
  }

    /**
   * Gets the SSl Status.
   * @return this SSl Status.
   */
  public final String getsslSta() {
    return sslSta;
  }

  /**
   * @param argSslSta to set manager comments.
   */
  public final void setsslSta(final String argSslSta) {
    this.sslSta = argSslSta;
  }

  /**
   * Gets the EmployeeId.
   * @return this Employee's Id.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   * Constructor.
   */
  public LeaveDetails() {

  }

  /**
   * @param argLeaId to initialize leave id.
   * @param argsdate to initialize Starting date of leave.
   * @param argedate to initialize ending date of leave.
   * @param argndays to initialize Number of days of leave.
   * @param argleatype to initialize leave type.
   * @param argLeaSta to initialize leave status.
   * @param argLeaRea to initialize reason for leave.
   * @param argLeaAppOn to initialize leave applied date.
   * @param argLeaMgrCom to initialize manager comments.
   * @param argEmpId to initialize employee id.
   * @param argSslSta to initialize SSL Status.
   */
  public LeaveDetails(final int argEmpId, final int argLeaId, final Date argsdate, final Date argedate,
      final int argndays, final LeaveType argleatype, final LeaveStatus argLeaSta,
      final String argLeaRea, final Date argLeaAppOn, final String argLeaMgrCom, final String argSslSta) {
    this.empId = argEmpId;
    this.leaId = argLeaId;
    this.sdate = argsdate;
    this.edate = argedate;
    this.ndays = argndays;
    this.leatype = argleatype;
    this.leaSta = argLeaSta;
    this.leaRea = argLeaRea;
    this.leaAppOn = argLeaAppOn;
    this.leaMgrCom = argLeaMgrCom;
    this.sslSta = argSslSta;
  }

  /**
   * The dao for leavedetails.
   */
  private static LeaveDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDAO.class);
  }

  /**
   * The edao for EmployeeDetails.
   */
  private static EmployeeDAO edao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

 /**
   * No of Overlapping Leaves.
   * @param empId id to get employee details.
   * @param sdate to get Start Date.
   * @param edate to get End Date.
   * @return count of no of days between leave.
   */
  public static int countNo(final int empId, final String sdate, final String edate) {
    int count = dao().count(empId, sdate, edate);
    return count;
  }

  /**
   * No of Overlapping Leaves.
   * @param leaId id to get employee manager details.
   * @return integer.
   */
  public static int showManager(final int leaId) {
    return dao().showManager(leaId);
  }

  /**
   * list all employee leave details.
   * @return all employees leave details
   */
  public static LeaveDetails[] listAll() {

    List<LeaveDetails> es = dao().list();
    return es.toArray(new LeaveDetails[es.size()]);
  }

  /**
   * list employee details by id.
   * @param leaId id to get employee details.
   * @return Employee
   */
  public static LeaveDetails listById(final int leaId) {
    return dao().find(leaId);
  }
  /**
   * Weekend calculation method.
   * @param sdate to store start date.
   * @param edate to store end date.
   * @return Number of days.
   * @throws ParseException throws the parse exception which might occur.
   */
  public static int weekEnd(final String sdate, final String edate) throws ParseException {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Date date1 = df.parse(sdate);
    Date date2 = df.parse(edate);
    Calendar cal1 = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
    cal1.setTime(date1);
    cal2.setTime(date2);

    int numberOfDays = 0;
    int count = 0;
    if (cal2.get(Calendar.DAY_OF_WEEK) == 1
        || cal2.get(Calendar.DAY_OF_WEEK) == 7) {
      count++;
    }
    while (cal1.before(cal2)) {
      if (cal1.get(Calendar.DAY_OF_WEEK) == 1
          || cal1.get(Calendar.DAY_OF_WEEK) == 7) {
        count++;
      }
      cal1.add(Calendar.DATE, 1);
    }
    System.out.println(count);
    System.out.println(numberOfDays);
    return count;
  }
  /**
   * AppplyLeave for employee.
   * @param sdate to give leave Startdate.
   * @param edate to give employee endDate.
   * @param ndays to give employee noOfdays.
   * @param leatype to give employee leaveType.
   * @param leaRea to give employee leaveReason.
   * @param leaAppOn to give employee leaveAppliedDate.
   * @param empId id to give employee id.
   * @return String
   * @throws ParseException throws the parse exception which might occur.
   * @throws NullPointerException throws the parse exception which might occur.
   */
  public static String applyLeave(final int empId,
                                  final String sdate,
                                  final String edate,
                                  final int ndays,
                                  final String leatype,
                                  final String leaRea,
                                  final String leaAppOn
                                  ) throws ParseException, NullPointerException {
    int count = weekEnd(sdate, edate);
    int ndays1 = ndays - count;
    System.out.println("no. of days : " + ndays1);
    Employee e = Employee.listById(empId);
    String r = null;
    if (e != null) {
      int argEmpLbal = e.getEmpLbal();
      int argMgrId = e.getEmpMgrId();
      String leaSta = "PENDING";
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      Date argsdate = sdf.parse(sdate);
      Date argedate = sdf.parse(edate);
      Date argLeaAppOn = sdf.parse(leaAppOn);
      int cheForApp = argsdate.compareTo(argLeaAppOn);
      long startDateTime = argsdate.getTime();
      long endDateTime = argedate.getTime();
      long diff = 1 + (endDateTime - startDateTime) / (1000 * 60 * 60 * 24);
      diff = diff - count;
      System.out.println("Difference is : " + diff);
      int overlap = LeaveDetails.countNo(empId, sdate, edate);
      if (overlap > 0) {
        r = "Already applied on given Date...";
      } else {
        if (argMgrId == 0) {
          leaSta = "APPROVED";
        }
        if (argedate.compareTo(argsdate) >= 0) {
          if (diff == ndays1) {
            if (cheForApp >= 0) {
              if (ndays1 <= argEmpLbal) {
                r = Employee.decrementBalance(ndays1, empId);
                dao().applyLeave(empId, sdate, edate, ndays1, leatype, leaSta, leaRea, leaAppOn);
                r = "Leave Applied Successfully";
              } else {
                r = "Available leave balance is less or not sufficient";
              }
            } else {
              r = "Apply for a leave for today or any duration in future";
            }
          } else {
            r = "The Number of days entered does not match with days entered.";
          }
        } else if (argedate.compareTo(argsdate) < 0) {
          r = "Since start date is greater than end date you cannot apply for a leave";
        }
      }
    } else if (e == null) {
      r = "Employ Id Not Found";
    }

    return r;
  }

    /**
   * AppplyLeave for employee.
   * @param sdate to give leave Startdate.
   * @param edate to give employee endDate.
   * @param ndays to give employee noOfdays.
   * @param leatype to give employee leaveType.
   * @param leaRea to give employee leaveReason.
   * @param leaAppOn to give employee leaveAppliedDate.
   * @param empId id to give employee id.
   * @return String
   * @throws ParseException throws the parse exception which might occur.
   * @throws NullPointerException throws the parse exception which might occur.
   */

  public static String applySslLeave(final int empId,
                                  final String sdate,
                                  final String edate,
                                  final int ndays,
                                  final String leatype,
                                  final String leaRea,
                                  final String leaAppOn) throws ParseException, NullPointerException {
    // int count = weekEnd(sdate, edate);
    int ndays1 = ndays;
    System.out.println("no. of days : " + ndays1);
    Employee e = Employee.listById(empId);
    String r = null;
    if (e != null) {
      int argEmpLbal = e.getEmpLbal();
      int argMgrId = e.getEmpMgrId();
      String leaSta = "PENDING";
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      Date argsdate = sdf.parse(sdate);
      Date argedate = sdf.parse(edate);
      Date argJdate = e.getEmpJdate();
      Date argLeaAppOn = sdf.parse(leaAppOn);
      int cheForApp = argsdate.compareTo(argLeaAppOn);
      long startDateTime = argsdate.getTime();
      long endDateTime = argedate.getTime();
      long jDateTime = argJdate.getTime();
      long appOnTime = argLeaAppOn.getTime();
      long diffSix = (appOnTime - jDateTime) / (1000 * 60 * 60 * 24);
      long diff = 1 + (endDateTime - startDateTime) / (1000 * 60 * 60 * 24);
      String sslSta1 = "YES";
      int sslCheck = checkForssl(empId, sslSta1);
      // diff = diff - count;
      //System.out.println("Difference is : " + diff);
      int overlap = LeaveDetails.countNo(empId, sdate, edate);
      if (ndays1 <= 30) {
        if (sslCheck == 0) {
          if (diffSix > 182) {
            if (overlap > 0) {
              r = "Already applied on given Date...";
            } else {
              if (argMgrId == 0) {
                leaSta = "APPROVED";
              }
              if (argedate.compareTo(argsdate) >= 0) {
                if (diff == ndays1) {
                  if (cheForApp >= 0) {
                    if (ndays1 > argEmpLbal) {
                      String sslSta = "YES";
                      r = Employee.decrementBalance(argEmpLbal, empId);
                      dao().applyLeaveSSL(empId, sdate, edate, argEmpLbal, leatype, leaSta, leaRea, leaAppOn, sslSta);
                      r = "Leave Applied Successfully";
                    } else {
                      r = "No Need to apply for the SSL. Already EL balance is available";
                    }
                  } else {
                    r = "Apply for a leave for today or any duration in future";
                  }
                } else {
                  System.out.println(diff);
                  r = "The Number of days entered does not match with days entered.";
                }
              } else if (argedate.compareTo(argsdate) < 0) {
                r = "Since start date is greater than end date you cannot apply for a leave";
              }
            }
          } else {
            r = "You are not eligible to Apply SSL.";
          }
        } else {
          r = "You have already applied for SSL leave. Sorry! cannot apply again.";
        }
      } else {
        r = "You cannot apply an ssl for more than 30 days.";
      }
    } else if (e == null) {
      r = "Employ Id Not Found";
    }
    return r;
  }
  /**
  * list all employee leave details.
  * @param empId Id to get employee leave details under the given Manager Id.
  * @param argSslSta Status for SSL
  * @return a check value for SSL leave.
  */
  public static int checkForssl(final int empId, final String argSslSta) {
    int cSsl = dao().checkSsl(empId, argSslSta);
    return cSsl;
  }


  /**
  * list all employee leave details.
  * @param mgrId Id to get employee leave details under the given Manager Id.
  * @return all Employee's Leave Details.
  */
  public static LeaveDetails[] listPending(final int mgrId) {
    List<LeaveDetails> es = dao().pending(mgrId);
    return es.toArray(new LeaveDetails[es.size()]);
  }

  /**
   * return all the details of the employee leaves.
   * @param empId the id of the LeaveDetails
   * @return the LeaveDetails Array object
   */

  /**
  * no of overlapping leaves.
  * @param empId id to get employee details.
  * @return employee leave history.
  */
  public static LeaveDetails[] leaveHis(final int empId) {
    List<LeaveDetails> es = dao().empHistory(empId);
    return es.toArray(new LeaveDetails[es.size()]);
  }

  /**
  * Method for Approve or Deny the Leave.
  * @param mgrId to enter mgrid to approve/deny.
  * @param leaId to enter LeaveId to approve/deny.
  * @param leaSta to enter status to approve/deny.
  * @param leaMgrCom to get manager comments.
  * @return String.
  * @throws NullPointerException for exception handelling.
  */
  public static String approveDeny(final int mgrId, final int leaId, final String leaSta, final String leaMgrCom)
    throws NullPointerException {
    LeaveDetails ld = LeaveDetails.listById(leaId);
    int ndays = ld.getNdays();
    int empId = ld.getEmpId();
    int m1 = LeaveDetails.showManager(leaId);
    String res = null;
    String dbStatus = null;
    String argSslSta = "NO";
    System.out.println(leaSta);



    if (mgrId != m1) {
      res = " You're not authorized to access this employee's leave details";
    } else {
      if (leaSta.equals("YES")) {
        if (ld.getLeaSta() == LeaveStatus.APPROVED) {
          if (ld.getsslSta().equals("YES")) {
            argSslSta = "YES";
          }
          dbStatus = "APPROVED";
          res = "You Cannot Approve an already approved leave. Please Check Again.";
        } else if (ld.getLeaSta() == LeaveStatus.DENIED) {
          dbStatus = "APPROVED";
          if (ld.getsslSta().equals("YES")) {
            argSslSta = "YES";
          }
          Employee.decrementBalance(ndays, empId);
          res = "Leave Approved Successfully";
        } else {
          if (ld.getsslSta().equals("YES")) {
            argSslSta = "YES";
          }
          dbStatus = "APPROVED";
          res = "Leave Approved Successfully";
        }
      } else if (leaSta.equals("NO")) {
        if (ld.getLeaSta() == LeaveStatus.DENIED) {
          dbStatus = "DENIED";
          argSslSta = "NO";
          res = "You Cannot Deny an already denied leave. Please Check Again.";
        } else {
          if (ld.getsslSta().equals("YES")) {
            // ld.setsslSta("NO");
            argSslSta = "NO";
          }
          edao().increment(empId, ndays);
          res = "Leave Rejected";
        }
        dbStatus = "DENIED";
      }
      dao().comment(leaMgrCom, dbStatus, leaId, argSslSta);
    }
    return res;
  }
}
