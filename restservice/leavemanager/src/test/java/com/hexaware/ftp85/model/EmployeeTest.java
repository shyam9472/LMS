package com.hexaware.ftp85.model;

import com.hexaware.ftp85.persistence.EmployeeDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static org.junit.Assert.assertFalse;

//import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.util.ArrayList;
/**
 * Unit test for simple App.
 */
@RunWith(JMockit.class)
public class EmployeeTest {
  /**
   * Tests the CEO GETTER Data.
   * @throws ParseException for parse ex handelling.
   */
  @Test
  public final void testEmployee1() throws ParseException {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
    Employee e1 = new Employee(1000, "KOMALIKA KRISHAN", "KOMALIKAK@HEXAWARE.COM", "FEMALE", "9878874321",
                               sdf1.parse("1996-09-15"), sdf1.parse("2008-10-03"), "FTP", 22, 10);
    assertEquals(1000, e1.getEmpId());
    assertEquals("KOMALIKA KRISHAN", e1.getEmpName());
    assertEquals("KOMALIKAK@HEXAWARE.COM", e1.getEmpEmail());
    assertEquals("FEMALE", e1.getEmpGender());
    assertEquals("9878874321", e1.getEmpMob());
    assertEquals(sdf1.parse("1996-09-15"), e1.getEmpDob());
    assertEquals(sdf1.parse("2008-10-03"), e1.getEmpJdate());
    assertEquals("FTP", e1.getEmpDept());
    assertEquals(22, e1.getEmpLbal());
    assertEquals(10, e1.getEmpMgrId());
  }

  /**
   * Tests the Employee GETTER Data.
   * @throws ParseException for parse ex handelling.
   */
  @Test
  public final void testEmployee2() throws ParseException {
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-mm-dd");
    Employee e2 = new Employee(6000, "SANJAY MADESHA", "SANJAYM@HEXAWARE.COM", "MALE", "9823244321",
                               sdf2.parse("1995-13-11"), sdf2.parse("2008-10-03"), "FTP", 29, 1000);
    assertEquals(6000, e2.getEmpId());
    assertEquals("SANJAY MADESHA", e2.getEmpName());
    assertEquals("SANJAYM@HEXAWARE.COM", e2.getEmpEmail());
    assertEquals("MALE", e2.getEmpGender());
    assertEquals("9823244321", e2.getEmpMob());
    assertEquals(sdf2.parse("1995-13-11"), e2.getEmpDob());
    assertEquals(sdf2.parse("2008-10-03"), e2.getEmpJdate());
    assertEquals("FTP", e2.getEmpDept());
    assertEquals(29, e2.getEmpLbal());
    assertEquals(1000, e2.getEmpMgrId());
  }

  /**
   * Tests the Employee SETTER Data.
   * @throws ParseException for parse ex handelling.
   */
  @Test
  public final void testEmployeeSetters() throws ParseException {
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-mm-dd");
    Employee e3 = new Employee();
    e3.setEmpId(5786);
    e3.setEmpName("VIKRANT SHAH");
    e3.setEmpEmail("VIKRANTS@HEXAWARE.COM");
    e3.setEmpGender("MALE");
    e3.setEmpMob("9892264713");
    e3.setEmpDob(sdf3.parse("1997-06-08"));
    e3.setEmpJdate(sdf3.parse("2014-03-19"));
    e3.setEmpDept("JAVA");
    e3.setEmpLbal(05);
    e3.setEmpMgrId(2000);

    assertEquals(5786, e3.getEmpId());
    assertEquals("VIKRANT SHAH", e3.getEmpName());
    assertEquals("VIKRANTS@HEXAWARE.COM", e3.getEmpEmail());
    assertEquals("MALE", e3.getEmpGender());
    assertEquals("9892264713", e3.getEmpMob());
    assertEquals(sdf3.parse("1997-06-08"), e3.getEmpDob());
    assertEquals(sdf3.parse("2014-03-19"), e3.getEmpJdate());
    assertEquals("JAVA", e3.getEmpDept());
    assertEquals(05, e3.getEmpLbal());
    assertEquals(2000, e3.getEmpMgrId());
    Employee e1 = null;
    assertFalse(e3.equals(e1));
    LeaveDetails ld = new LeaveDetails();
    assertFalse(e3.equals(ld));

  }

  /**
   * Tests the NonEquality  of Employee Data .
   * @throws ParseException for parse ex handelling.
   */
  @Test
  public final void testEquals() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    Employee e4 = new Employee(6000, "SANJAY MADESHA", "SANJAYM@HEXAWARE.COM", "MALE", "9823244321",
                               sdf.parse("1995-13-11"), sdf.parse("2008-10-03"), "FTP", 29, 1000);
    Employee e5 = new Employee(6000, "SANJAY MADESHA", "SANJAYM@HEXAWARE.COM", "MALE", "9823244321",
                               sdf.parse("1995-13-11"), sdf.parse("2008-10-03"), "FTP", 29, 1000);
    Employee e6 = new Employee(5786, "VIKRANT SHAH", "VIKRANTS@HEXAWARE.COM", "MALE", "9892264713",
                               sdf.parse("1997-06-08"), sdf.parse("2014-03-19"), "JAVA", 05, 2000);
    assertEquals(e4, e5);
    assertNotEquals(e4, e6);
    assertNotEquals(e5, e6);
  }

  /**
   * Tests the NonEquality of hashcode of Employee Data.
   * @throws ParseException for parse ex handelling.
   */
  @Test
  public final void testhashCode() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    Employee e4 = new Employee(6000, "SANJAY MADESHA", "SANJAYM@HEXAWARE.COM", "MALE", "9823244321",
                               sdf.parse("1995-13-11"), sdf.parse("2008-10-03"), "FTP", 29, 1000);
    Employee e5 = new Employee(6000, "SANJAY MADESHA", "SANJAYM@HEXAWARE.COM", "MALE", "9823244321",
                               sdf.parse("1995-13-11"), sdf.parse("2008-10-03"), "FTP", 29, 1000);
    Employee e6 = new Employee(5786, "VIKRANT SHAH", "VIKRANTS@HEXAWARE.COM", "MALE", "9892264713",
                               sdf.parse("1997-06-08"), sdf.parse("2014-03-19"), "JAVA", 05, 2000);
    assertEquals(e4.hashCode(), e5.hashCode());
    assertNotEquals(e4.hashCode(), e6.hashCode());
    assertNotEquals(e5.hashCode(), e6.hashCode());
  }

/**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.list(); result = new ArrayList<Employee>();
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(0, es.length);
  }

  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException  throws the parse exception.
   */
  @Test
  public final void testListAllSome(@Mocked final EmployeeDAO dao) throws ParseException {
    new Expectations() {
      {
        ArrayList<Employee> es = new ArrayList<Employee>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        es.add(new Employee(6000, "SANJAY MADESHA", "SANJAYM@HEXAWARE.COM", "MALE", "9823244321",
                            sdf.parse("1995-13-11"), sdf.parse("2008-10-03"), "FTP", 29, 1000));
        es.add(new Employee(5786, "VIKRANT SHAH", "VIKRANTS@HEXAWARE.COM", "MALE", "9892264713",
                            sdf.parse("1997-06-08"), sdf.parse("2014-03-19"), "JAVA", 05, 2000));
        es.add(new Employee(1000, "KOMALIKA KRISHAN", "KOMALIKAK@HEXAWARE.COM", "FEMALE", "9878874321",
                            sdf.parse("1996-09-15"), sdf.parse("2008-10-03"), "FTP", 22, 10));
        dao.list(); result = es;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(3, es.length);
  }

  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class.
   * @throws ParseException Throws the parse Exception.
   */
  @Test
  public final void testListById(@Mocked final EmployeeDAO dao) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    final Employee e1 = new Employee(1, "SANJAY MADESHA", "SANJAYM@HEXAWARE.COM", "MALE", "9823244321",
                                        sdf.parse("1995-13-11"), sdf.parse("2008-10-03"), "FTP", 29, 1000);
    new Expectations() {
      {
        dao.find(1); result = e1;
        dao.find(-1); result = null;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e = Employee.listById(1);
    assertEquals(e1, e);

    e = Employee.listById(-1);
    assertNull(e);
  }

  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   * @throws ParseException for parsing errors.
   */
  @Test
  public final void testIncrement(@Mocked final EmployeeDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final Employee e1 = new Employee(2, "SANJAY MADESHA", "SANJAYM@HEXAWARE.COM", "MALE", "9823244321",
        sdf.parse("1995-13-11"), sdf.parse("2008-10-03"), "FTP", 29, 1);
    new Expectations() {
      {
        dao.find(2); result = e1;
      }
    };
    new Expectations() {
      {
        dao.increment(2, 6);
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e2 = Employee.listById(2);
    assertEquals(e2, e1);
    String result = Employee.increment(2, 6);
    assertEquals("Leave Balance Updated", result);
  }

  /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   * @throws ParseException for parsing errors.
   */
  @Test
  public final void testDecrement(@Mocked final EmployeeDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final Employee e1 = new Employee(2, "SANJAY MADESHA", "SANJAYM@HEXAWARE.COM", "MALE", "9823244321",
        sdf.parse("1995-13-11"), sdf.parse("2008-10-03"), "FTP", 29, 1);
    new Expectations() {
      {
        dao.find(2); result = e1;
      }
    };
    new Expectations() {
      {
        dao.decrement(2, 6);
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e2 = Employee.listById(2);
    assertEquals(e2, e1);
    String result = Employee.decrementBalance(6, 2);
    assertEquals("Leave Balance Updated", result);
  }
}
