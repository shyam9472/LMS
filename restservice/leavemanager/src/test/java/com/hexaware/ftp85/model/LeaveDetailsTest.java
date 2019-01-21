package com.hexaware.ftp85.model;

import com.hexaware.ftp85.persistence.EmployeeDAO;
import com.hexaware.ftp85.persistence.LeaveDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import org.junit.runner.RunWith;
import java.util.ArrayList;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;


/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class LeaveDetailsTest {

  /**
   * Function for testing Constructor.
   * @ @throws ParseException throws the parse exception which might occur.
   */
  @Test
  public final void testLeaveDetails() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    LeaveDetails ld = new LeaveDetails(1000, 1, sdf.parse("2018-11-25"), sdf.parse("2018-12-01"),
                                           7, LeaveType.valueOf("EL"), LeaveStatus.valueOf("PENDING"),
                                           "It is Christmas", sdf.parse("2018-11-22"),
                                           "Merry Christmas", "NO");


    assertEquals(1000, ld.getEmpId());
    assertEquals(1, ld.getLeaId());
    assertEquals(sdf.parse("2018-11-25"), ld.getSdate());
    assertEquals(sdf.parse("2018-12-01"), ld.getEdate());
    assertEquals(7, ld.getNdays());
    assertEquals(LeaveType.valueOf("EL"), ld.getLeatype());
    assertEquals(LeaveStatus.valueOf("PENDING"), ld.getLeaSta());
    assertEquals("It is Christmas", ld.getleaRea());
    assertEquals(sdf.parse("2018-11-22"), ld.getleaAppOn());
    assertEquals("Merry Christmas", ld.getLeaMgrCom());
    assertEquals("NO", ld.getsslSta());
  }

  /**
   * Function for testing Constructor.
   * @ @throws ParseException throws the parse exception which might occur.
   */

  @Test
  public final void leaveDetailsSetter() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

    LeaveDetails ld = new LeaveDetails();

    ld.setEmpId(1000);
    ld.setLeaId(1);
    ld.setSdate(sdf.parse("2018-11-25"));
    ld.setEdate(sdf.parse("2018-12-01"));
    ld.setNdays(7);
    ld.setLeatype(LeaveType.valueOf("EL"));
    ld.setLeaSta(LeaveStatus.valueOf("PENDING"));
    ld.setLeaRea("It is Christmas");
    ld.setLeaAppOn(sdf.parse("2018-11-22"));
    ld.setLeaMgrCom("Merry Christmas");
    ld.setsslSta("NO");

    assertEquals(1000, ld.getEmpId());
    assertEquals(1, ld.getLeaId());
    assertEquals(sdf.parse("2018-11-25"), ld.getSdate());
    assertEquals(sdf.parse("2018-12-01"), ld.getEdate());
    assertEquals(7, ld.getNdays());
    assertEquals(LeaveType.valueOf("EL"), ld.getLeatype());
    assertEquals(LeaveStatus.valueOf("PENDING"), ld.getLeaSta());
    assertEquals("It is Christmas", ld.getleaRea());
    assertEquals(sdf.parse("2018-11-22"), ld.getleaAppOn());
    assertEquals("Merry Christmas", ld.getLeaMgrCom());
    assertEquals("NO", ld.getsslSta());
    Employee e1 = null;
    assertFalse(ld.equals(e1));
    LeaveDetails l1 = new LeaveDetails();
    Employee e = new Employee();
    assertFalse(l1.equals(e));
  }

  /**
   * Function for testing Hashcode.
   * @ @throws ParseException throws the parse exception which might occur.
   */
  @Test
   public final void testHashCode() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    LeaveDetails ld1 = new LeaveDetails(1000, 1, sdf.parse("2018-11-25"), sdf.parse("2018-12-01"),
                                           7,  LeaveType.valueOf("EL"), LeaveStatus.valueOf("PENDING"),
                                           "It is Christmas", sdf.parse("2018-11-22"),
                                           "Merry Christmas", "NO");
    LeaveDetails ld2 = new LeaveDetails(1000, 1, sdf.parse("2018-11-25"), sdf.parse("2018-12-01"),
                                           7,  LeaveType.valueOf("EL"), LeaveStatus.valueOf("PENDING"),
                                           "It is Christmas", sdf.parse("2018-11-22"),
                                           "Merry Christmas", "NO");

    assertEquals(ld1.hashCode(), ld2.hashCode());
  }
  /**
   * Function for testing Hashcode.
   * @ @throws ParseException throws the parse exception which might occur.
   */
  @Test
   public final void testToString() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    LeaveDetails ld1 = new LeaveDetails(1000, 1, sdf.parse("2018-11-25"), sdf.parse("2018-12-01"),
                                           7,  LeaveType.valueOf("EL"), LeaveStatus.valueOf("PENDING"),
                                           "It is Christmas", sdf.parse("2018-11-22"),
                                           "Merry Christmas", "NO");

    String s = "LeaveID" + ld1.getLeaId() + "\nLeave Start Date" + ld1.getSdate() + "\nLeave End Date" + ld1.getEdate()
                + "No of Leave Days" + ld1.getNdays() + "\nLeave Type" + ld1.getLeatype()
                + "\nLeave Status" + ld1.getLeaSta() + "\nLeave Applied on" + ld1.getleaAppOn()
                + "\nManager's comment" + ld1.getLeaMgrCom() + "\nEmployee Id" + ld1.getEmpId()
                + "\nSSL Status" + ld1.getsslSta();

    assertEquals(s, ld1.toString());
  }
  /**
   * Function for testing Equals Function.
   * @ @throws ParseException throws the parse exception which might occur.
   */
  @Test
  public final void testEquals() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    LeaveDetails ld1 = new LeaveDetails(1000, 1, sdf.parse("2018-11-25"), sdf.parse("2018-12-01"),
                                        7,  LeaveType.valueOf("EL"), LeaveStatus.valueOf("PENDING"),
                                        "It is Christmas", sdf.parse("2018-11-22"),
                                        "Merry Christmas", "NO");
    LeaveDetails ld2 = new LeaveDetails(1000, 1, sdf.parse("2018-11-25"), sdf.parse("2018-12-01"),
                                        7,  LeaveType.valueOf("EL"), LeaveStatus.valueOf("PENDING"),
                                        "It is Christmas", sdf.parse("2018-11-22"),
                                        "Merry Christmas", "NO");
    LeaveDetails ld3 = new LeaveDetails(2000, 5, sdf.parse("2018-11-26"), sdf.parse("2018-12-05"),
                                        10,  LeaveType.valueOf("ML"), LeaveStatus.valueOf("PENDING"),
                                        "Maternity leave", sdf.parse("2018-11-24"),
                                        "Be healthy.Be safe.Take care.", "NO");

    assertEquals(ld1, ld2);
    assertNotEquals(ld1, ld3);
    assertNotEquals(ld2, ld3);
  }

  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException  throws the parse exception.
   */
  @Test
  public final void testListAllSome(@Mocked final LeaveDAO dao) throws ParseException {
    new Expectations() {
      {
        ArrayList<LeaveDetails> ld = new ArrayList<LeaveDetails>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        ld.add(new LeaveDetails(2000, 5, sdf.parse("2018-11-26"), sdf.parse("2018-12-05"),
                                        10,  LeaveType.valueOf("ML"), LeaveStatus.valueOf("PENDING"),
                                        "Maternity leave", sdf.parse("2018-11-24"),
                                        "Be healthy.Be safe.Take care.", "NO"));
        ld.add(new LeaveDetails(1000, 1, sdf.parse("2018-11-25"), sdf.parse("2018-12-01"),
                                        7,  LeaveType.valueOf("EL"), LeaveStatus.valueOf("PENDING"),
                                        "It is Christmas", sdf.parse("2018-11-22"),
                                        "Merry Christmas", "NO"));
        ld.add(new LeaveDetails(3000, 1, sdf.parse("2018-11-28"), sdf.parse("2018-12-03"),
                                        6,  LeaveType.valueOf("EL"), LeaveStatus.valueOf("PENDING"),
                                        "Going Home", sdf.parse("2018-11-25"),
                                        "Go and Enjoy", "NO"));
        dao.list(); result = ld;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] ld = LeaveDetails.listAll();
    assertEquals(3, ld.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param edao mocking the EmployeeDAO class.
   * @param dao mocking the LeaveDAO class.
   * @throws ParseException for exceptions.
   * @throws NullPointerException for exceptions.
   */
  @Test
  public final void testApplyLeave(@Mocked final EmployeeDAO edao, @Mocked final LeaveDAO dao)
                    throws ParseException, NullPointerException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    new Expectations() {
      {
        edao.find(1);  result = new Employee(1, "SANJAY MADESHA", "SANJAYM@HEXAWARE.COM", "MALE", "9823244321",
                                              sdf.parse("1995-11-13"), sdf.parse("2008-10-03"), "FTP", 29, 1000);
        edao.find(2);  result = new Employee(2, "Shree Lakshmi", "shreel@HEXAWARE.COM", "FEMALE", "9823244321",
                                             sdf.parse("1995-11-13"), sdf.parse("2008-10-03"), "FTP", 29, 0);
        edao.find(3); result = null;
      }
    };
    new Expectations() {
      {
        dao.applyLeave(1, "2019-12-26", "2019-12-27", 2, "EL", "PENDING", "sick", "2018-11-22");
      }
    };
    new Expectations() {
      {
        dao.count(1, "2019-12-26", "2019-12-27"); result = 0;
        dao.count(1, "2018-12-30", "2018-12-30"); result = 1;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return edao;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    String str1 = LeaveDetails.applyLeave(1, "2019-12-26", "2019-12-27", 2, "EL", "sick", "2018-11-22");
    assertEquals("Leave Applied Successfully", str1);
    String str2 = LeaveDetails.applyLeave(1, "2018-12-25", "2019-01-26", 3, "EL", "sick", "2018-11-22");
    assertEquals("The Number of days entered does not match with days entered.", str2);
    String str4 = LeaveDetails.applyLeave(1, "2018-12-30", "2018-12-30", 1, "EL", "sick", "2018-11-22");
    assertEquals("Already applied on given Date...", str4);
    String str5 = LeaveDetails.applyLeave(1, "2020-01-01", "2020-02-29", 60, "EL", "sick", "2019-12-22");
    assertEquals("Available leave balance is less or not sufficient", str5);
    String str6 = LeaveDetails.applyLeave(3, "2018-12-26", "2018-12-27", 2, "EL", "sick", "2018-11-22");
    assertEquals("Employ Id Not Found", str6);
    String str3 = LeaveDetails.applyLeave(1, "2018-11-19", "2018-11-20", 2, "EL", "sick", "2018-11-22");
    assertEquals("Apply for a leave for today or any duration in future", str3);
    String str7 = LeaveDetails.applyLeave(1, "2018-11-25", "2018-11-24", 2, "EL", "sick", "2018-11-22");
    assertEquals("Since start date is greater than end date you cannot apply for a leave", str7);
    String str8 = LeaveDetails.applyLeave(2, "2020-12-19", "2020-12-20", 2, "EL", "sick", "2018-11-22");
    assertEquals("Leave Applied Successfully", str8);
  }

//________________________________________________________________________________________________________
/**
   * Tests that a list with some employees is handled correctly.
   * @param edao mocking the EmployeeDAO class.
   * @param dao mocking the LeaveDAO class.
   * @throws ParseException for exceptions.
   * @throws NullPointerException for exceptions.
   */
  @Test
  public final void testApplySslLeave(@Mocked final EmployeeDAO edao, @Mocked final LeaveDAO dao)
                    throws ParseException, NullPointerException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    new Expectations() {
      {
        edao.find(1);  result = new Employee(1, "SANJAY MADESHA", "SANJAYM@HEXAWARE.COM", "MALE", "9823244321",
                                              sdf.parse("1995-11-13"), sdf.parse("2008-10-03"), "FTP", 2, 1000);
        edao.find(2);  result = new Employee(2, "Shree Lakshmi", "shreel@HEXAWARE.COM", "FEMALE", "9823244321",
                                             sdf.parse("1995-11-13"), sdf.parse("2008-10-03"), "FTP", 7, 0);
        edao.find(4);  result = new Employee(4, "Shree Shakti", "shree@HEXAWARE.COM", "FEMALE", "9824214321",
                                             sdf.parse("1995-11-13"), sdf.parse("2008-10-03"), "FTP", 10, 0);
        edao.find(3); result = null;
      }
    };
    // new Expectations() {
    //   {
    //     dao.applyLeaveSSL(1, "2019-12-26", "2019-12-27", 2, "EL", "PENDING", "sick", "2018-11-22", "NO");
    //   }
    // };
    new Expectations() {
      {
        dao.checkSsl(1, "YES"); result = 1;
        dao.checkSsl(1, "NO"); result = 0;
        //dao.checkSsl(4, "YES"); result = 1;
        dao.checkSsl(4, "NO"); result = 0;
      }
    };
    new Expectations() {
      {
        dao.count(1, "2019-12-26", "2019-12-27"); result = 0;
        dao.count(1, "2018-12-30", "2018-12-30"); result = 1;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return edao;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    String str0 = LeaveDetails.applySslLeave(1, "2019-12-26", "2019-12-27", 2, "EL", "sick", "2018-11-22");
    assertEquals("Leave Applied Successfully", str0);
    String str1 = LeaveDetails.applySslLeave(1, "2018-12-30", "2018-12-30", 1, "EL", "sick", "2018-11-23");
    assertEquals("You have already applied for SSL leave. Sorry! cannot apply again.", str1);
    String str2 = LeaveDetails.applySslLeave(2, "2018-12-25", "2019-01-26", 3, "EL", "sick", "2018-11-22");
    assertEquals("The Number of days entered does not match with days entered.", str2);
    String str4 = LeaveDetails.applySslLeave(2, "2019-01-01", "2019-01-31", 32, "EL", "sick", "2018-11-22");
    assertEquals("You cannot apply an ssl for more than 30 days.", str4);
    //String str5 = LeaveDetails.applySslLeave(1, "2020-01-01", "2020-02-29", 60, "EL", "sick", "2019-12-22");
    // assertEquals("Available leave balance is less or not sufficient", str5);
    String str6 = LeaveDetails.applySslLeave(3, "2018-12-26", "2018-12-27", 2, "EL", "sick", "2018-11-22");
    assertEquals("Employ Id Not Found", str6);
    String str3 = LeaveDetails.applySslLeave(2, "2018-11-19", "2018-11-20", 2, "EL", "sick", "2018-11-22");
    assertEquals("Apply for a leave for today or any duration in future", str3);
    String str7 = LeaveDetails.applySslLeave(2, "2018-11-25", "2018-11-24", 2, "EL", "sick", "2018-11-22");
    assertEquals("Since start date is greater than end date you cannot apply for a leave", str7);
    String str8 = LeaveDetails.applySslLeave(4, "2019-01-07", "2019-01-11", 5, "EL", "sick", "2018-11-22");
    assertEquals("No Need to apply for the SSL. Already EL balance is available", str8);
    // String str9 = LeaveDetails.applySslLeave(4, "2019-01-07", "2019-01-26", 20, "EL", "sick", "2018-11-22");
    // assertEquals("Leave Applied Successfully", str9);
  }
//________________________________________________________________________________________________________

   /**
   * Function for testing pending Function.
   * @param dao for
   * @ @throws ParseException throws the parse exception which might occur.
   */
  @Test
  public final void testPending(@Mocked final LeaveDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    LeaveDetails ld1 = new LeaveDetails();
    final ArrayList<LeaveDetails> es = new ArrayList<LeaveDetails>();
    final ArrayList<LeaveDetails> es2 = new ArrayList<LeaveDetails>();
    new Expectations() {
      {
        es.add(new LeaveDetails(2, 1, sdf.parse("2018-12-01"), sdf.parse("2018-12-02"), 2,
            LeaveType.EL, LeaveStatus.PENDING, "sick", sdf.parse("2018-11-22"), "go", "NO"));
        es.add(new LeaveDetails(2, 1, sdf.parse("2018-12-01"), sdf.parse("2018-12-02"), 2,
            LeaveType.EL, LeaveStatus.PENDING, "sick", sdf.parse("2018-11-22"), "go", "NO"));
        es.add(new LeaveDetails(2, 1, sdf.parse("2018-12-01"), sdf.parse("2018-12-02"), 2,
            LeaveType.EL, LeaveStatus.PENDING, "sick", sdf.parse("2018-11-22"), "go", "NO"));
        es.add(new LeaveDetails(2, 1, sdf.parse("2018-12-01"), sdf.parse("2018-12-02"), 2,
            LeaveType.EL, LeaveStatus.PENDING, "sick", sdf.parse("2018-11-22"), "go", "NO"));
        dao.pending(1); result = es;
        dao.pending(2); result = es2;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] lds1 = LeaveDetails.listPending(1);
    assertEquals(4, lds1.length);
    LeaveDetails[] lds2 = LeaveDetails.listPending(2);
    assertEquals(0, lds2.length);
  }



/**
   * Function for testing leave history.
   * @param dao for
   * @throws ParseException throws the parse exception which might occur.
   */
  @Test
  public final void testHistory(@Mocked final LeaveDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final ArrayList<LeaveDetails> es1 = new ArrayList<LeaveDetails>();
    final ArrayList<LeaveDetails> es2 = new ArrayList<LeaveDetails>();
    final ArrayList<LeaveDetails> es3 = new ArrayList<LeaveDetails>();
    new Expectations() {
      {
        es1.add(new LeaveDetails(1000, 1, sdf.parse("2018-11-25"), sdf.parse("2018-12-01"), 7,
                              LeaveType.EL, LeaveStatus.PENDING, "It is Christmas",
                              sdf.parse("2018-11-22"), "Merry Christmas", "NO"));
        es1.add(new LeaveDetails(1000, 1, sdf.parse("2018-11-26"), sdf.parse("2018-12-05"), 10,
                              LeaveType.ML, LeaveStatus.PENDING, "Maternity leave",
                              sdf.parse("2018-11-24"), "Be healthy.Be safe.Take care.", "NO"));
        es1.add(new LeaveDetails(1000, 1, sdf.parse("2018-12-09"), sdf.parse("2018-12-10"), 2,
                              LeaveType.EL, LeaveStatus.PENDING, "sick",
                              sdf.parse("2018-11-26"), "go", "NO"));
        es2.add(new LeaveDetails(2000, 5, sdf.parse("2018-11-26"), sdf.parse("2018-12-05"), 10,
                              LeaveType.ML, LeaveStatus.PENDING, "Maternity leave",
                              sdf.parse("2018-11-24"), "Be healthy.Be safe.Take care.", "NO"));
        dao.empHistory(1000); result = es1;
        dao.empHistory(2000); result = es2;
        dao.empHistory(3000); result = es3;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] ld1 = LeaveDetails.leaveHis(1000);
    assertEquals(3, ld1.length);
    LeaveDetails[] ld2 = LeaveDetails.leaveHis(2000);
    assertEquals(1, ld2.length);
    LeaveDetails[] ld3 = LeaveDetails.leaveHis(3000);
    assertEquals(0, ld3.length);
  }

/**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the LeaveDAO class.
   * @throws ParseException for exceptions.
   */
  @Test
  public final void testApproveDeny(@Mocked final LeaveDAO dao) throws ParseException {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final LeaveDetails l1 = new LeaveDetails(7000, 1, sdf.parse("2018-11-25"), sdf.parse("2018-12-01"),
                                             7,  LeaveType.EL, LeaveStatus.PENDING,
                                             "It's Christmas", sdf.parse("2018-11-22"),
                                             "Merry Christmas", "NO");

    final LeaveDetails l2 = new LeaveDetails(7001, 5, sdf.parse("2018-11-25"), sdf.parse("2018-12-01"),
                                              7,  LeaveType.EL, LeaveStatus.PENDING,
                                              "It's Christmas", sdf.parse("2018-11-22"),
                                              "Merry Christmas", "NO");

    final LeaveDetails l3 = new LeaveDetails(8000, 4, sdf.parse("2018-12-19"), sdf.parse("2018-12-20"),
                                             2,  LeaveType.EL, LeaveStatus.APPROVED,
                                             "Simply", sdf.parse("2018-11-22"),
                                             "Ok Good", "NO");

    final LeaveDetails l4 = new LeaveDetails(9000, 7, sdf.parse("2018-12-19"), sdf.parse("2018-12-20"),
                                             2,  LeaveType.EL, LeaveStatus.DENIED,
                                             "Simply", sdf.parse("2018-11-22"),
                                             "Ok Good", "NO");

    new Expectations() {
      {
        dao.comment("Merry Christmas", "APPROVED", 1, "NO");
        dao.comment("Merry Christmas", "APPROVED", 5, "NO");
        //dao.comment("Ok Good", "APPROVED", 4);
      }
    };
    new Expectations() {
      {
        dao.find(1); result = l1;
        dao.find(5); result = l2;
        dao.find(4); result = l3;
        dao.find(7); result = l4;
      }
    };
    new Expectations() {
      {
        dao.showManager(1); result = 1000;
        dao.showManager(5); result = 2000;
        dao.showManager(4); result = 5000;
        dao.showManager(7); result = 9000;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDAO dao() {
        return dao;
      }
    };
    String str1 = LeaveDetails.approveDeny(1000, 1, "YES", "Merry Christmas");
    assertEquals("Leave Approved Successfully", str1);

    String str2 = LeaveDetails.approveDeny(5000, 5, "YES", "Sorry");
    assertEquals(" You're not authorized to access this employee's leave details", str2);

    String str4 = LeaveDetails.approveDeny(1000, 1, "NO", "Sorry");
    assertEquals("Leave Rejected", str4);

    String str5 = LeaveDetails.approveDeny(2000, 5, "YES", "Merry Christmas");
    assertEquals("Leave Approved Successfully", str5);

    String str6 = LeaveDetails.approveDeny(5000, 4, "YES", "Ok Good");
    assertEquals("You Cannot Approve an already approved leave. Please Check Again.", str6);

    String str7 = LeaveDetails.approveDeny(9000, 7, "NO", "Ok Good");
    assertEquals("You Cannot Deny an already denied leave. Please Check Again.", str7);

    String str8 = LeaveDetails.approveDeny(9000, 7, "YES", "Ok Good");
    assertEquals("Leave Approved Successfully", str8);

  }
}
