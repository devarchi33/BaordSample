package skyfly33.board.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import skyfly33.board.beans.Member;
import skyfly33.board.dao.AbstractDao;
import skyfly33.board.util.JdbcUtil;

public class OracleDao extends AbstractDao {

	static Logger logger = LoggerFactory.getLogger(OracleDao.class);

	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;
	private Member member;

	public int insert(Connection conn, String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			logger.info("SQLException : " + e.getMessage());
			return 0;
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	@Override
	public ResultSet selectList(Connection conn, String sql) {
		// TODO Auto-generated method stub
		stmt = null;
		rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			logger.info("SQLException : " + e.getMessage());
		} catch (NullPointerException e) {
			logger.info("NullPointerException : " + e.getMessage());
		}

		if (conn != null) {
			JdbcUtil.close(conn);
			logger.info("Connection closing is success!!");
		} else {
			logger.info("Connection closing isn't success!!");
		}
		return null;
	}

	public Member getMemberLogin(Connection conn, String id, String pass) {
		
		pstmt = null;
		rs = null;
		try {
			String sql = "select * from scott.member3 where scott.member3.\"id\" = ? and scott.member3.\"pass\" = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setName(rs.getString("name"));
				member.setId(rs.getString("id"));
				member.setPass(rs.getString("pass"));
				member.setGender(rs.getString("gender"));
				member.setHobby(rs.getString("hobby"));
				member.setEmail(rs.getString("edu"));

			}
		} catch (Exception e) {
			logger.info("Exception : " + e.getMessage());
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return member;
	}
}
