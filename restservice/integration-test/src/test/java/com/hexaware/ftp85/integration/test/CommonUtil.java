package com.hexaware.ftp85.integration.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Date;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
public class CommonUtil {
    public static final String host;
    public static final String port;
    public static final String webapp;
    public static final String uri_prefix;
    static {
        host = System.getProperty("service.host", "localhost");
        port = System.getProperty("service.port", "8080");
        webapp = System.getProperty("service.webapp", "ftp85new");
        uri_prefix = "http://" + host + ":" + port + "/" + webapp;
    }
    public static URI getURI(String path) throws URISyntaxException {
        return new URI(uri_prefix + path);
    }
}

class Employee {
   
  /**
   * empId to store employee id.
   */
  private int empId;
  private String empName;
  private String empEmail;
  private String empGender;
  private String empMob;
  private Date empDob;
  private Date empJdate;
  private String empDept;
  private int empLbal;
  private int empMgrId;

  /**
   * Constructor.
   */
  public Employee() {

  }
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId)
        && Objects.equals(empName, emp.empName)
        && Objects.equals(empEmail, emp.empEmail)
        && Objects.equals(empGender, emp.empGender)
        && Objects.equals(empMob, emp.empMob)
        && Objects.equals(empDob, emp.empDob)
        && Objects.equals(empJdate, emp.empJdate)
        && Objects.equals(empDept, emp.empDept)
        && Objects.equals(empLbal, emp.empLbal)
        && Objects.equals(empMgrId, emp.empMgrId)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, empName, empEmail, empGender, empMob, empDob, empJdate, empDept, empLbal, empMgrId);
  }

  /**
   * @param argEmpId to initialize employee id.
   * @param argEmpName to initialize employee name.
   * @param argEmpEmail to initialize employee email.
   * @param argEmpGender to initialize employee gender.
   * @param argEmpMob to initialize employee mobile.no.
   * @param argEmpDob to initialize employee date of birth.
   * @param argEmpJdate to initialize employee joining date.
   * @param argEmpDept to initialize employee department.
   * @param argEmpLbal to initialize employee leave balance.
   * @param argEmpMgrId to initialize employee manager id.
   */
  public Employee(final int argEmpId, final String argEmpName, final String argEmpEmail, final String argEmpGender,
                  final String argEmpMob, final Date argEmpDob, final Date argEmpJdate, final String argEmpDept,
                  final int argEmpLbal, final int argEmpMgrId) {
    this.empId = argEmpId;
    this.empName = argEmpName;
    this.empEmail = argEmpEmail;
    this.empGender = argEmpGender;
    this.empMob = argEmpMob;
    this.empDob = argEmpDob;
    this.empJdate = argEmpJdate;
    this.empDept = argEmpDept;
    this.empLbal = argEmpLbal;
    this.empMgrId = argEmpMgrId;
  }

  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
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
   *
   * @param argsEmpName to set employee name.
   */
  public final void setEmpName(final String argsEmpName) {
    this.empName = argsEmpName;
  }

  /**
   * Gets the EmployeeNAME.
   * @return this Employee's NAME.
   */
  public final String getEmpName() {
    return empName;
  }

  /**
   * Gets the EmployeeEmail.
   * @return this Employee's Email.
   */
  public final String getEmpEmail() {
    return empEmail;
  }

  /**
   *
   * @param argEmpEmail to set employee mail id.
   */
  public final void setEmpEmail(final String argEmpEmail) {
    this.empEmail = argEmpEmail;
  }

  /**
   * Gets the EmployeeGender.
   * @return this Employee's Gender.
   */
  public final String getEmpGender() {
    return empGender;
  }

  /**
   *
   * @param argEmpGender to set employee Gender.
   */
  public final void setEmpGender(final String argEmpGender) {
    this.empGender = argEmpGender;
  }

  /**
   * Gets the EmployeeMobile no.
   * @return this Employee's Mobile no.
   */
  public final String getEmpMob() {
    return empMob;
  }

  /**
   *
   * @param argEmpMob to set employee Mobile no.
   */
  public final void setEmpMob(final String argEmpMob) {
    this.empMob = argEmpMob;
  }

  /**
   * Gets the Employee Date of Birth.
   * @return this Employee's Date of Birth.
   */
  public final Date getEmpDob() {
    return empDob;
  }

  /**
   *
   * @param argEmpDob to set employee Date of Birth..
   */
  public final void setEmpDob(final Date argEmpDob) {
    this.empDob = argEmpDob;
  }

  /**
   * Gets the Employee Joining Date.
   * @return this Employee's Joining date.
   */
  public final Date getEmpJdate() {
    return empJdate;
  }

  /**
   *
   * @param argEmpJdate to set employee Joining date.
   */
  public final void setEmpJdate(final Date argEmpJdate) {
    this.empJdate = argEmpJdate;
  }

  /**
   * Gets the Employee Department.
   * @return this Employee's Department.
   */
  public final String getEmpDept() {
    return empDept;
  }

  /**
   *
   * @param argEmpDept to set employee Department.
   */
  public final void setEmpDept(final String argEmpDept) {
    this.empDept = argEmpDept;
  }

  /**
   * Gets the Employee leave balance.
   * @return this Employee's leave balance.
   */
  public final int getEmpLbal() {
    return empLbal;
  }

  /**
   *
   * @param argEmpLbal to set employee leave balance.
   */
  public final void setEmpLbal(final int argEmpLbal) {
    this.empLbal = argEmpLbal;
  }

  /**
   * Gets the Employee Manager Id.
   * @return this Employee's Manager Id.
   */
  public final int getEmpMgrId() {
    return empMgrId;
  }

  /**
   *
   * @param argEmpMgrId to set employee Manager id.
   */
  public final void setEmpMgrId(final int argEmpMgrId) {
    this.empMgrId = argEmpMgrId;
  }

    public String toString() {
      try {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
      } catch(Exception e) {
        throw new RuntimeException(e);
      }
    }
}

class LeaveDetails {

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
  public final void setleatype(final LeaveType argleatype) {
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
}

enum LeaveStatus {
  /**
   * Pending status.
   */
  PENDING,

  /**
   * Approved Status.
   */
  APPROVED,

  /**
   * Denied Status.
   */
  DENIED
}

enum LeaveType {
  /**
   * Earned Leave.
   */
  EL,

   /**
   * Casual Leave.
   */
  CL,

   /**
   * Sick Leave.
   */
  SL,

  /**
   * Maternity Leave.
   */
  ML,

  /**
   * Paternity Leave.
   */
  PL
}
