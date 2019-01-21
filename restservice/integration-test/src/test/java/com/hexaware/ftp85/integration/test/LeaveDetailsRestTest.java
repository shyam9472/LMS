package com.hexaware.ftp85.integration.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;
import java.text.ParseException;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class LeaveDetailsRestTest {

    @Test
    public void testLeaveDetailsList() throws AssertionError, URISyntaxException {
        LeaveDetails[] res = given().accept(ContentType.JSON).when()
                .get(CommonUtil.getURI("/api/LeaveDetailsRest")).getBody().as(LeaveDetails[].class);
        for (LeaveDetails ld: res) {
            switch (ld.getEmpId()) {
                case 1000:
                    assertEquals(1000, ld.getEmpId());
                    break;
                case 2000:
                    assertEquals(2000, ld.getEmpId());
                    break;              
                case 3000:
                    assertEquals(3000, ld.getEmpId());
                    break;              
                case 4000:
                    assertEquals(4000, ld.getEmpId());
                    break;              
                case 5000:
                    assertEquals(5000, ld.getEmpId());         
                default:
                    fail("Unknown employee with id:" + ld);  
            }
        }
    }

    @Test
    public void testLeaveDetailsById() throws AssertionError, URISyntaxException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        LeaveDetails res = given().accept(ContentType.JSON).when()
                .get(CommonUtil.getURI("/api/LeaveDetailsRest/1")).getBody().as(LeaveDetails.class);
        assertEquals(5000, res.getEmpId());
        assertEquals(LeaveStatus.valueOf("APPROVED"), res.getLeaSta());
        assertEquals("HOME", res.getleaRea());
        assertEquals(sdf.parse("2019-01-02"), res.getleaAppOn());
        assertEquals(null, res.getLeaMgrCom());
        assertEquals(sdf.parse("2018-11-21"), res.getSdate());
        assertEquals(sdf.parse("2018-11-22"), res.getEdate());
        assertEquals(LeaveType.valueOf("SL"), res.getLeatype());
        assertEquals(2, res.getNdays());

  }
  
   @Test
    public void testLeaveDetailsById404() throws AssertionError, URISyntaxException {
        given().accept(ContentType.JSON).when()
                .get(CommonUtil.getURI("/api/LeaveDetails/9999")).then().assertThat().statusCode(404);
    }

    @Test
    public void testPendingLeaveDetails() throws AssertionError, URISyntaxException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        LeaveDetails[] res = given().accept(ContentType.JSON).when()
                .get(CommonUtil.getURI("/api/LeaveDetailsRest/pending/1000")).getBody().as(LeaveDetails[].class);
        if(res.length == 0) {
            assertEquals(0, res.length);
        }
    }

    @Test
    public void testLeaveDetailsHistory() throws AssertionError, URISyntaxException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        LeaveDetails[] res = given().accept(ContentType.JSON).when()
                .get(CommonUtil.getURI("/api/LeaveDetailsRest/history/3000")).getBody().as(LeaveDetails[].class);
        if(res.length == 0) {
            assertEquals(0, res.length);
        }
    }

    @Test
    public void testLeaveDetailsApplyLeave() throws AssertionError, URISyntaxException, ParseException {
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // LeaveDetails[] res = given().accept(ContentType.JSON).when()
        //         .get(CommonUtil.getURI("/api/LeaveDetailsRest/LDApplyLeave/2000")).getBody().as(LeaveDetails[].class);
        // if(res.length == 0) {
        //     assertEquals(0, res.length);
        // }
        // String res1 = given().accept(ContentType.JSON).contentType("application/json").body("{\"empId\":\"2000\",\"sdate\":\"2028-02-24\",\"edate\":\"2028-02-25\",\"ndays\":\"2\",\"leatype\":\"EL\",\"leaRea\":\"Going Out\",\"leaAppOn\":\"2018-11-29\"}")
        // .when().post(CommonUtil.getURI("/api/LeaveDetailsRest/LDApplyLeave/2000")).getBody().asString();

        // assertEquals("Leave Applied Successfully", res1);

        // String res2 = given().accept(ContentType.JSON).contentType("application/json").body("{\"empId\":\"3000\",\"sdate\":\"2019-04-25\",\"edate\":\"2019-04-25\",\"ndays\":\"3\",\"leatype\":\"EL\",\"leaRea\":\"Christmas\",\"leaAppOn\":\"2018-11-29\"}")
        // .when().post(CommonUtil.getURI("/api/LeaveDetailsRest/LDApplyLeave/3000")).getBody().asString();

        // assertEquals("The Number of days entered does not match with days entered.", res2);

        // String res3 = given().accept(ContentType.JSON).contentType("application/json").body("{\"empId\":\"5000\",\"sdate\":\"2019-12-25\",\"edate\":\"2019-12-25\",\"ndays\":\"1\",\"leatype\":\"EL\",\"leaRea\":\"Christmas\",\"leaAppOn\":\"2018-11-29\"}")
        // .when().post(CommonUtil.getURI("/api/LeaveDetailsRest/LDApplyLeave/5000")).getBody().asString();

        // assertEquals("Already applied on given Date...", res3);

        // String res4 = given().accept(ContentType.JSON).contentType("application/json").body("{\"empId\":\"3000\",\"sdate\":\"2019-12-25\",\"edate\":\"2019-12-25\",\"ndays\":\"1\",\"leatype\":\"EL\",\"leaRea\":\"Christmas\",\"leaAppOn\":\"2018-11-29\"}")
        // .when().post(CommonUtil.getURI("/api/LeaveDetailsRest/LDApplyLeave/3000")).getBody().asString();

        // assertEquals("Available leave balance is less or not sufficient", res4);

        // String res5 = given().accept(ContentType.JSON).contentType("application/json").body("{\"empId\":\"7000\",\"sdate\":\"2019-12-25\",\"edate\":\"2019-12-25\",\"ndays\":\"1\",\"leatype\":\"EL\",\"leaRea\":\"Christmas\",\"leaAppOn\":\"2018-11-29\"}")
        // .when().post(CommonUtil.getURI("/api/LeaveDetailsRest/LDApplyLeave/7000")).getBody().asString();

        // assertEquals("Employ Id Not Found", res5);

        // String res6 = given().accept(ContentType.JSON).contentType("application/json").body("{\"empId\":\"2000\",\"sdate\":\"2018-11-25\",\"edate\":\"2018-11-25\",\"ndays\":\"1\",\"leatype\":\"EL\",\"leaRea\":\"Christmas\",\"leaAppOn\":\"2018-11-29\"}")
        // .when().post(CommonUtil.getURI("/api/LeaveDetailsRest/LDApplyLeave/2000")).getBody().asString();

        // assertEquals("Apply for a leave for today or any duration in future", res6);

        String res7 = given().accept(ContentType.JSON).contentType("application/json").body("{\"empId\":\"2000\",\"sdate\":\"2019-12-25\",\"edate\":\"2019-12-24\",\"ndays\":\"2\",\"leatype\":\"EL\",\"leaRea\":\"Christmas\",\"leaAppOn\":\"2018-11-29\"}")
        .when().post(CommonUtil.getURI("/api/LeaveDetailsRest/LDApplyLeave/2000")).getBody().asString();

        assertEquals("Since start date is greater than end date you cannot apply for a leave", res7);

    }

    @Test
    public void testLeaveDetailsApplyssLeave() throws AssertionError, URISyntaxException, ParseException { 
        String res7 = given().accept(ContentType.JSON).contentType("application/json").body("{\"empId\":\"2000\",\"sdate\":\"2019-12-01\",\"edate\":\"2019-12-29\",\"ndays\":\"30\",\"leatype\":\"EL\",\"leaRea\":\"Christmas\",\"leaAppOn\":\"2018-11-29\"}")
        .when().post(CommonUtil.getURI("/api/LeaveDetailsRest/LDApplyssLeave/2000")).getBody().asString();

        assertEquals("Leave Applied Successfully", res7);
    }

//     @Test
//     public void testLeaveDetailsApproveDeny() throws AssertionError, URISyntaxException, ParseException {

//        String res1=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaId\":\"8\",\"leaSta\":\"APPROVED\",\"leaMgrCom\":\"Enjoy\",\"empId\":\"3000\"}").
//         when().post(CommonUtil.getURI("/api/LeaveDetailsRest/LeaveDetailsApproveDeny/3000")).getBody().asString();
//         assertEquals("Leave Approved Successfully", res1);
//     //    String res2=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaveId\":\"14\",\"leaveStatus\":\"DENIED\",\"leaveMgrComment\":\"Sorry\",\"leaveEmpId\":\"3000\"}").
//     //     when().post(CommonUtil.getURI("/api/leaves/approvedeny/1000")).getBody().asString();
//     //     assertEquals("Leave Rejected", res2);
//     //    String res3=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaveId\":\"40\",\"leaveStatus\":\"APPROVED\",\"leaveMgrComment\":\"Enjoy\",\"leaveEmpId\":\"5000\"}").
//     //     when().post(CommonUtil.getURI("/api/leaves/approvedeny/2000")).getBody().asString();
//     //     assertEquals("LeaveId Not Found", res3);
//     //    String res4=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaveId\":\"14\",\"leaveStatus\":\"APPROVED\",\"leaveMgrComment\":\"Enjoy\",\"leaveEmpId\":\"3000\"}").
//     //     when().post(CommonUtil.getURI("/api/leaves/approvedeny/2000")).getBody().asString();
//     //     assertEquals("You are not authorised to access this employee.", res4);
//    }
// //    @Test
// //    public void testapproveDenyById404() throws AssertionError, URISyntaxException {
// //        given().accept(ContentType.JSON).when()
// //                .get(CommonUtil.getURI("/api/leaves/approvedeny/9999")).then().assertThat().statusCode(405);
    
// //     }
}
