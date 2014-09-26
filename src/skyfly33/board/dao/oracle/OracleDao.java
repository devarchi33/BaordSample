package skyfly33.board.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import skyfly33.board.dao.AbstractDao;
import skyfly33.board.model.Board;
import skyfly33.board.util.JdbcUtil;

public class OracleDao extends AbstractDao {

	static Logger logger = LoggerFactory.getLogger(OracleDao.class);

	public int insert(Connection conn, Board board, String sql) {
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
	public ResultSet selectList(Connection conn, String sql){
		// TODO Auto-generated method stub
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			return rs;			
		} catch (SQLException e) {
			logger.info("SQLException : " + e.getMessage());
		} catch (NullPointerException e) {
			logger.info("NullPointerException : " + e.getMessage());
		}
		
		if(conn != null){
			JdbcUtil.close(conn);
			logger.info("Connection closing is success!!");
		}
		return null;
	}

}
