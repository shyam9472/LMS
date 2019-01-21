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

public class EmployeeRestTest {

    @Test
    public void testEmployeesList() throws AssertionError, URISyntaxException {
        Employee[] res = given().accept(ContentType.JSON).when()
                .get(CommonUtil.getURI("/api/employees")).getBody().as(Employee[].class);
        for (Employee e: res) {
            switch (e.getEmpId()) {
                case 1000:
                    assertEquals(1000, e.getEmpId());
                    break;
                case 2000:
                    assertEquals(2000, e.getEmpId());
                    break;              
                case 3000:
                    assertEquals(3000, e.getEmpId());
                    break;              
                case 4000:
                    assertEquals(4000, e.getEmpId());
                    break;              
                case 5000:
                    assertEquals(5000, e.getEmpId());
                    break;          
                default:
                    fail("Unknown employee with id:" + e);  
            }
        }
    }

    @Test
    public void testEmployeeById() throws AssertionError, URISyntaxException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Employee res = given().accept(ContentType.JSON).when()
                .get(CommonUtil.getURI("/api/employees/1000")).getBody().as(Employee.class);
        assertEquals(1000, res.getEmpId());
        assertEquals("KOMAL LOKE", res.getEmpName());
        assertEquals("KOMALL@HEXAWARE.COM", res.getEmpEmail());
        assertEquals("FEMALE", res.getEmpGender());
        assertEquals("98784543210", res.getEmpMob());
		assertEquals(sdf.parse("1996-09-15"), res.getEmpDob());
		assertEquals(sdf.parse("2008-10-03"), res.getEmpJdate());
		assertEquals("FTP", res.getEmpDept());
		assertEquals(21, res.getEmpLbal());
		assertEquals(0, res.getEmpMgrId());

  }
  
   @Test
    public void testEmployeeById404() throws AssertionError, URISyntaxException {
        given().accept(ContentType.JSON).when()
                .get(CommonUtil.getURI("/api/employees/9999")).then().assertThat().statusCode(404);
    }
}
