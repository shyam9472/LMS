package com.hexaware.ftp85.model;

import com.hexaware.ftp85.persistence.DbConnection;
import com.hexaware.ftp85.persistence.EmployeeDAO;

import java.util.Objects;
import java.util.List;
import java.util.Date;

/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class Employee {

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

  /**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * list all employee details.
   * @return all employees' details
   */
  public static Employee[] listAll() {

    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  }

  /**
   * Update employee LeaveBalance.
   * @param empId id to get employee id.
   * @param leaNdays to get employee leavenoofdays.
   * @return String.
   */
  public static String increment(final int empId, final int leaNdays) {
    dao().increment(empId, leaNdays);
    return "Leave Balance Updated";
  }

/**
  * Method for Approve or Deny the Leave.
  * @param argLeaNdays to enter LeaveId to approve/deny.
  * @param argEmpId to enter status to approve/deny.
  * @return a string value.
  */
  public static String decrementBalance(final int argLeaNdays, final int argEmpId) {
    int ndays = argLeaNdays;
    int id = argEmpId;
    dao().decrement(id, ndays);
    return "Leave Balance Updated";
  }

}
