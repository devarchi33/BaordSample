package skyfly33.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import skyfly33.board.beans.Board;
import skyfly33.board.util.JdbcUtil;

public abstract class AbstractDao {

	static Logger logger = LoggerFactory.getLogger(AbstractDao.class);

	public abstract int insert(Connection conn, String sql) throws SQLException;

	public abstract ResultSet selectList(Connection conn, String sql)
			throws SQLException;

	public Board contentSelect(Connection conn, String sql) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return makeMessageFromResultSet(rs);
			} else {
				return null;
			}
		} catch (SQLException e) {
			logger.info("SQLException : " + e.getMessage());
			return null;
		} catch (NullPointerException e) {
			logger.info("NullPointerException : " + e.getMessage());
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
	}

	public Board makeMessageFromResultSet(ResultSet rs) throws SQLException {
		Board board = new Board();

		board.setIdx(rs.getInt("idx"));
		board.setTitle(rs.getString("title"));
		board.setWriter(rs.getString("writer"));
		board.setRegdate(rs.getString("regdate"));
		board.setContent(rs.getString("content"));
		board.setCount(rs.getInt("count"));

		return board;
	}

	public int delete(Connection conn, String sql) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			logger.info("SQLException : " + e.getMessage());
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
}
