package com.hexaware.ftp85.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.ftp85.model.LeaveDetails;
import com.hexaware.ftp85.model.LeaveStatus;
import com.hexaware.ftp85.model.LeaveType;
/**
 * Mapper class to map from result set to Leavedetails object.
 */
public class LeaveMapper implements ResultSetMapper<LeaveDetails> {
  /**
   * @param idx the index
   * @param rs the resultset
   * @param ctx the context
   * @return the mapped Leavedetails object
   * @throws SQLException in case there is an error in fetching data from the resultset
   */
  public final LeaveDetails map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    String s = rs.getString("LEA_TYPE");
    LeaveType lt1 = LeaveType.valueOf(s);

    String s2 = rs.getString("LEA_STA");
    LeaveStatus lt2 = LeaveStatus.valueOf(s2);
    /**
     * @return Leavedetails
     */
    return new LeaveDetails(rs.getInt("EMP_ID"), rs.getInt("LEA_ID"),
              rs.getDate("LEA_SDATE"), rs.getDate("LEA_EDATE"),
              rs.getInt("LEA_NDAYS"), lt1,
              lt2, rs.getString("LEA_REA"),
              rs.getDate("LEA_APPON"), rs.getString("LEA_MGRCOM"), rs.getString("LEA_SSLAPPSTA"));
  }
}
