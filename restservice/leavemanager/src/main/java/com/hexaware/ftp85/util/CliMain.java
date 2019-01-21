package com.hexaware.ftp85.util;
import java.util.Scanner;
import com.hexaware.ftp85.model.LeaveDetails;
import com.hexaware.ftp85.model.Employee;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;

/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");

  private void mainMenu() {
    System.out.println("Leave Management System");
    System.out.println("-----------------------");
    System.out.println("1. List All Employees Info");
    System.out.println("2. Display Employee Info");
    System.out.println("3. Apply Leave");
    System.out.println("4. Pending Leaves");
    System.out.println("5. Approve/Deny");
    System.out.println("6. Leave History");
    System.out.println("7. Apply for SSL Leave");
    System.out.println("8. Exit");
    System.out.println("Enter your choice:");
    int menuOption = option.nextInt();
    mainMenuDetails(menuOption);
  }
  private void mainMenuDetails(final int selectedOption) {
    switch (selectedOption) {
      case 1:
        listEmployeesDetails();
        break;
      case 2:
        listEmployeeDetail();
        break;
      case 3:
        applyLeave();
        break;
      case 4:
        pendingLeaves();
        break;
      case 5:
        approveDeny();
        break;
      case 6:
        leaveHistory();
        break;
      case 7:
        appForSsl();
        break;
      // case 8:
      //   listLeaveDetailsById();
      //   break;
      case 8:
        // halt since normal exit throws a stacktrace due to jdbc threads not responding
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Choose either 1, 2 or 3");
    }
    mainMenu();
  }


  /**
  * Method for Employee Id of the CEO.
  * @return the emp id of the ceo.
  */
  public static String applyLeave() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date dt = new Date();
    String argLeaAppOn = sdf.format(dt);
    //System.out.println(sdf.format(dt));
    LeaveDetails ld = new LeaveDetails();
    Scanner option = new Scanner(System.in, "UTF-8");
    int argEmpId = 0;
    while (true) {
      try {
        System.out.println("Enter an Employee Id  ");
        String id = option.next();
        argEmpId = Integer.parseInt(id);
        Employee e = Employee.listById(argEmpId);
        int argEmpId1 = e.getEmpId();
        if (argEmpId == argEmpId1) {
          break;
        }
      } catch (NumberFormatException e) {
        System.out.println("Use the correct format please.");
      } catch (InputMismatchException e) {
        System.out.println("Please Enter in Numbers only. Don't use Strings.");
      } catch (NullPointerException e) {
        System.out.println("No Employ Id as such found.");
      }
    }
    System.out.println("Enter StartDate (yyyy-MM-dd) ");
    String argLeaSdate = option.next();
    System.out.println("Enter EndDate (yyyy-MM-dd) ");
    String argLeaEdate = option.next();
    System.out.println("Enter No of Leave days ");
    int argLeaNdays = Integer.parseInt(option.next());
    System.out.println("Enter leave type : EL, SL, CL, ML, PL");
    String argLeaTypel = option.next();
    String argLeaType = argLeaTypel.toUpperCase();
    option.nextLine();
    System.out.println("Enter leave reason");
    String argLeaReal = option.nextLine();
    String argLeaRea = argLeaReal.toUpperCase();
    /*&
    System.out.println("Enter leave applied date (yyyy-mm-dd)");
    String argLeaAppOn = option.next();
    */
    try {
      String s = ld.applyLeave(argEmpId, argLeaSdate, argLeaEdate, argLeaNdays, argLeaType, argLeaRea, argLeaAppOn);
      System.out.println(s);
      // LeaveDetails.applyLeave(5000, "2019-02-05", "2019-02-07", 3,
      //                         "EL", "check leave addition validation",
      //                         "2018-11-15");
    } catch (ParseException e) {
      System.out.println(e.getMessage());
    } catch (NullPointerException e) {
      System.out.println("Entered Employee Id does not exist. Please try again.");
    } catch (NumberFormatException e) {
      System.out.println("The Values entered does not seems to be Integer. Please try Again.");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return "Successfull";
  }

//----------------------------------------------------------------------------------------------------
  /**
  * Method for Employee Id of the CEO.
  * @return the emp id of the ceo.
  */
  public static String appForSsl() {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    Date dt1 = new Date();
    String argLeaAppOn = sdf1.format(dt1);
    //System.out.println(sdf.format(dt));
    LeaveDetails ld1 = new LeaveDetails();
    Scanner op = new Scanner(System.in, "UTF-8");
    int argEmpId = 0;
    while (true) {
      try {
        System.out.println("Enter an Employee Id  ");
        String id1 = op.next();
        argEmpId = Integer.parseInt(id1);
        Employee e = Employee.listById(argEmpId);
        int argEmpId1 = e.getEmpId();
        if (argEmpId == argEmpId1) {
          break;
        }
      } catch (NumberFormatException e) {
        System.out.println("Use the correct format please.");
      } catch (InputMismatchException e) {
        System.out.println("Please Enter in Numbers only. Don't use Strings.");
      } catch (NullPointerException e) {
        System.out.println("No Employ Id as such found.");
      }
    }
    System.out.println("Enter StartDate (yyyy-MM-dd) ");
    String argLeaSdate = op.next();
    System.out.println("Enter EndDate (yyyy-MM-dd) ");
    String argLeaEdate = op.next();
    System.out.println("Enter No of Leave days ");
    int argLeaNdays = Integer.parseInt(op.next());
    System.out.println("Enter leave type : EL, SL, CL, ML, PL");
    String argLeaTypel = op.next();
    String argLeaType = argLeaTypel.toUpperCase();
    op.nextLine();
    System.out.println("Enter leave reason");
    String argLeaReal = op.nextLine();
    String argLeaRea = argLeaReal.toUpperCase();
    /*&
    System.out.println("Enter leave applied date (yyyy-mm-dd)");
    String argLeaAppOn = option.next();
    */
    try {
      String s = ld1.applySslLeave(argEmpId, argLeaSdate, argLeaEdate, argLeaNdays, argLeaType, argLeaRea, argLeaAppOn);
      System.out.println(s);
      /*LeaveDetails.applyLeave(5000, "2018-11-22", "2018-11-24", 3,
                              "EL", "check leave addition validation",
                              "2018-11-15"); */
    } catch (ParseException e) {
      System.out.println(e.getMessage());
    } catch (NullPointerException e) {
      System.out.println("Entered Employee Id does not exist. Please try again.");
    } catch (NumberFormatException e) {
      System.out.println("The Values entered does not seems to be Integer. Please try Again.");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return "Successfull";
  }
//----------------------------------------------------------------------------------------------------
  /**
  * Method for Employee Id of the CEO.
  */
  public static void pendingLeaves() {
    Scanner option = new Scanner(System.in);
    int argMgrId = 0;
    while (true) {
      try {
        System.out.println("Enter Manager Id.");
        String id = option.next();
        argMgrId = Integer.parseInt(id);
        Employee e = Employee.listById(argMgrId);
        int argEmpId1 = e.getEmpId();
        if (argMgrId == argEmpId1) {
          break;
        }
      } catch (NumberFormatException e) {
        System.out.println("Use the correct format please.");
      } catch (InputMismatchException e) {
        System.out.println("Please Enter in Numbers only. Don't use Strings.");
      } catch (NullPointerException e) {
        System.out.println("No Employ Id as such found.");
      }
    }
    //argMgrId = Integer.parseInt(option.next());
    LeaveDetails[] pending = LeaveDetails.listPending(argMgrId);
    for (LeaveDetails e : pending) {
      System.out.println(e.getEmpId() + " "
                        + e.getLeaId() + " "
                        + e.getNdays() + " "
                        + e.getSdate() + " "
                        + e.getEdate() + " "
                        + e.getleaRea() + " "
                        + e.getleaAppOn());
    }
  }

  /**
  * For Approval and Denial.
  */
  public static void approveDeny() {
    Scanner sc = new Scanner(System.in);
    String res = "Check";
    int argMgrId = 0;
    while (true) {
      try {
        System.out.println("Enter Manager Id.");
        String id = sc.next();
        argMgrId = Integer.parseInt(id);
        Employee e = Employee.listById(argMgrId);
        int argEmpId1 = e.getEmpId();
        if (argMgrId == argEmpId1) {
          break;
        }
      } catch (NumberFormatException e) {
        System.out.println("Use the correct format please.");
      } catch (InputMismatchException e) {
        System.out.println("Please Enter in Numbers only. Don't use Strings.");
      } catch (NullPointerException e) {
        System.out.println("No Employ Id as such found.");
      }
    }
    int argLeaId = 0;
    while (true) {
      try {
        System.out.println("Enter a leave ID:");
        String sLeaId = sc.next();
        argLeaId = Integer.parseInt(sLeaId);
        break;
      } catch (InputMismatchException e) {
        System.out.println("Please Enter in Numbers only. Don't use Strings.");
      } catch (NullPointerException e) {
        System.out.println("Leave Id as such not found.");
      } catch (NumberFormatException e) {
        System.out.println("Use the correct format please.");
      }
    }
    String ch;
    while (true) {
      System.out.println("Approve (yes/no):");
      String chL = sc.next();
      ch = chL.toUpperCase();
      if (ch.equals("YES") || ch.equals("NO")) {
        break;
      } else {
        System.out.println("Enter from either YES or No please.");
      }
    }
    System.out.println("Manager Comments  ");
    sc.nextLine();
    String argLeaMgrComl = sc.nextLine();
    String argLeaMgrCom = argLeaMgrComl.toUpperCase();
    try {
      res = LeaveDetails.approveDeny(argMgrId, argLeaId, ch, argLeaMgrCom);
    } catch (NullPointerException e) {
      System.out.println("Null Pointer in Leave Status found");
    }

    System.out.println(res);
  }
  /**
  * Method for Employee Id of the CEO.
  */
  public static void leaveHistory() {
    Scanner op = new Scanner(System.in, "UTF-8");
    int argEmpId = 0;
    while (true) {
      try {
        System.out.println("Enter an Employee Id  ");
        String id = op.next();
        argEmpId = Integer.parseInt(id);
        Employee e = Employee.listById(argEmpId);
        int argEmpId1 = e.getEmpId();
        if (argEmpId == argEmpId1) {
          break;
        }
      } catch (NumberFormatException e) {
        System.out.println("Use the correct format please.");
      } catch (InputMismatchException e) {
        System.out.println("Please Enter in Numbers only. Don't use Strings.");
      } catch (NullPointerException e) {
        System.out.println("No Employ Id as such found.");
      }
    }
    LeaveDetails[] leave = LeaveDetails.leaveHis(argEmpId);
    for (LeaveDetails e : leave) {
      System.out.println(e.getEmpId() + "  "
                         + e.getLeaId() + "  "
                         + e.getNdays() + "  "
                         + e.getSdate() + "  "
                         + e.getEdate() + "  "
                         + e.getleaRea() + "  "
                         + e.getleaAppOn() + "  "
                         + e.getLeaSta() + "  "
                         + e.getLeatype());
    }
  }
  /**
  * Method for Employee Id of the CEO.
  */
  public static void listEmployeeDetail() {
    Scanner op1 = new Scanner(System.in);
    int argEmpId = 0;
    while (true) {
      try {
        System.out.println("Enter an Employee Id  ");
        String id = op1.next();
        argEmpId = Integer.parseInt(id);
        Employee e = Employee.listById(argEmpId);
        int argEmpId1 = e.getEmpId();
        if (argEmpId == argEmpId1) {
          break;
        }
      } catch (NumberFormatException e) {
        System.out.println("Use the correct format please.");
      } catch (InputMismatchException e) {
        System.out.println("Please Enter in Numbers only. Don't use Strings.");
      } catch (NullPointerException e) {
        System.out.println("No Employ Id as such found.");
      }
    }
    Employee e = Employee.listById(argEmpId);
    if (e == null) {
      System.out.println("Sorry, No such employee");
    } else {
      System.out.println(e.getEmpId() + "  " + e.getEmpName() + "  " + e.getEmpEmail() + "  "
                         + e.getEmpGender() + "  " + e.getEmpMob() + "  " + e.getEmpDob() + "  "
                         + e.getEmpJdate() + "  " + e.getEmpDept() + "  "
                         + e.getEmpLbal() + "  " + e.getEmpMgrId());
    }
  }
  /**
  * Method for Employee Id of the CEO.
  */
  public static void listEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    for (Employee e : employee) {
      System.out.println(e.getEmpId() + "  " + e.getEmpName() + "  " + e.getEmpEmail() + "  "
                         + e.getEmpGender() + "  " + e.getEmpMob() + "  " + e.getEmpDob() + "  "
                         + e.getEmpJdate() + "  " + e.getEmpDept() + "  "
                         + e.getEmpLbal() + "  " + e.getEmpMgrId());
    }
  }

  // private void listLeaveDetails() {

  //   Scanner scd = new Scanner(System.in);
  //   System.out.println("Enter a Leave Id");
  //   int leaId = scd.nextInt();
  //   LeaveDetails ld = LeaveDetails.listById(leaId);
  //   if (ld == null) {
  //     System.out.println("Sorry, No such employee");
  //   } else {
  //     System.out.println(ld.getEmpId() + "  " + ld.getLeaId() + "  " + ld.getleaRea() + "  "
  //                        + ld.getleaAppOn() + "  " + ld.getLeaMgrCom() + "  " + ld.getLeaSta() + "  "
  //                        + ld.getLeatype() + " " + ld.getNdays() + " " + ld.getSdate() + " " + ld.getEdate());
  //   }
  // }
  // private void listLeaveDetailsById() {
  //   LeaveDetails[] ld1 = LeaveDetails.listAll();
  //   for (LeaveDetails ld : ld1) {
  //     System.out.println(ld.getEmpId() + "  " + ld.getLeaId() + "  " + ld.getleaRea() + "  "
  //                        + ld.getleaAppOn() + "  " + ld.getLeaMgrCom() + "  " + ld.getLeaSta() + "  "
  //                        + ld.getLeatype() + " " + ld.getNdays() + " " + ld.getSdate() + " " + ld.getEdate());
  //   }
  // }

  /**
   * The main entry point.
   * @param ar the list of arguments
   */
  public static void main(final String[] ar) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }

}
