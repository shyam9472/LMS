package com.hexaware.ftp85.persistence;


import com.hexaware.ftp85.model.Employee;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * The DAO class for employee.
 */
public interface EmployeeDAO {
  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM EMPLOYEE_DETAILS")
  @Mapper(EmployeeMapper.class)
  List<Employee> list();

  /**
   * return all the details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE_DETAILS WHERE EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  Employee find(@Bind("empID") int empID);

  /**
   * Updated LeaveBalnce after Rejection for selected employee.
   * @param empID the id of the employee.
   * @param leaNdays for Leave Table of employee.
  */
  @SqlUpdate("UPDATE EMPLOYEE_DETAILS SET EMP_LBAL = EMP_LBAL + :leaNdays WHERE EMP_ID = :empID")
  void increment(@Bind("empID") int empID, @Bind("leaNdays") int leaNdays);

  /**
   * Updated LeaveBalnce after applying leave for selected employee.
   * @param empId the id of the employee.
   * @param ndays for Leave Table of employee.
  */
  @SqlUpdate("UPDATE EMPLOYEE_DETAILS SET EMP_LBAL = EMP_LBAL - :ndays WHERE EMP_ID = :empId")
  void decrement(@Bind("empId") int empId, @Bind("ndays") int ndays);
  /**
  * close with no args is used to close the connection.
  */
  void close();
}
