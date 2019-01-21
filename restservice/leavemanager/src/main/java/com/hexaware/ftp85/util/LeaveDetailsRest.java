package com.hexaware.ftp85.util;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import com.hexaware.ftp85.model.LeaveDetails;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//import java.util.Date;



/**
 * rest class for leave details.
 */
@Path("/LeaveDetailsRest")
public class LeaveDetailsRest {

/**
   * Returns a list of all the LeaveDetails.
   * @return a list of all the employees
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] employeesList() {
    System.out.println("Employees List");
    final LeaveDetails[] employees = LeaveDetails.listAll();
    return employees;
  }

  /**
   * Returns a specific employee's details.
   * @param leaId the id of the employee
   * @return the employee details
   */
  @GET
  @Path("{leaId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails leaveListById(@PathParam("leaId") final int leaId) {
    final LeaveDetails l2 = LeaveDetails.listById(leaId);
    if (l2 == null) {
      throw new NotFoundException("No such Employee ID: " + leaId);
    }
    return l2;
  }

  /**
   * Returns a specific employee's details.
   * @param mgrId gives the manager id.
   * @return the leave details.
   */
  @GET
  @Path("/pending/{mgrId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] listPending(@PathParam("mgrId") final int mgrId) {
    final LeaveDetails[] l1 = LeaveDetails.listPending(mgrId);
    if (l1 == null) {
      throw new NotFoundException("No such manager id = " + mgrId);
    }
    return l1;
  }

  /**
   * Returns a specific employee's details.
   * @param empId the id of the employee
   * @return the employee details
   */
  @GET
  @Path("/history/{empId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] leaveHis(@PathParam("empId") final int empId) {
    final LeaveDetails[] l1 = LeaveDetails.leaveHis(empId);
    if (l1 == null) {
      throw new NotFoundException("No such Employee ID: " + empId);
    }
    return l1;
  }

 /**
 * This is rest sevice for approveDeny.
 * @param empId Manager Id of Employee.
 * @param ld object of class LeaveDetails.
 * @return result in a string.
 */
  @POST
  @Path("/LeaveDetailsApproveDeny/{empid}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final String approveDenyRest(final LeaveDetails ld, @PathParam("empid") final int empId) {
    String result = null;
    String status = null;
    String staE = ld.getLeaSta().toString();
    if (staE.equals("APPROVED")) {
      status = "YES";
    } else if (staE.equals("DENIED")) {
      status = "NO";
    }
    try {
      result = LeaveDetails.approveDeny(empId, ld.getLeaId(), status, ld.getLeaMgrCom());
    } catch (NullPointerException e) {
      result = "No such leave data available";
    }
    return result;
  }

 /**
 * This is rest sevice for applyLeave.
 * @param ld object of class LeaveDetails.
 * @param empId employees id.
 * @throws ParseException to handle parse exception.
 * @return result in a string.
 */
  @POST
  @Path("/LDApplyLeave/{empId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final String applyLeaveRest(final LeaveDetails ld, @PathParam("empId") final int empId) throws ParseException {
    String result = null;
    String type = ld.getLeatype().toString();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String sDate = sdf.format(ld.getSdate());
    String eDate = sdf.format(ld.getEdate());
    String appon = sdf.format(ld.getleaAppOn());
    result = LeaveDetails.applyLeave(empId, sDate, eDate, ld.getNdays(),
                                     type, ld.getleaRea(), appon);
    return result;
  }

 /**
 * This is rest sevice for applyLeave.
 * @param ld object of class LeaveDetails.
 * @param empId employees id.
 * @throws ParseException to handle parse exception.
 * @return result in a string.
 */
  @POST
  @Path("/LDApplySSLeave/{empId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final String applyssLeaveRest(final LeaveDetails ld, @PathParam("empId") final int empId)
                                        throws ParseException {
    String result = null;
    String type = ld.getLeatype().toString();
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    String sDate = sdf1.format(ld.getSdate());
    String eDate = sdf1.format(ld.getEdate());
    String appon = sdf1.format(ld.getleaAppOn());
    result = LeaveDetails.applySslLeave(empId, sDate, eDate, ld.getNdays(),
                                     type, ld.getleaRea(), appon);
    return result;
  }
}
