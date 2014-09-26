package skyfly33.board.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import skyfly33.board.config.Config;

public class JdbcUtil {
	static Logger logger = LoggerFactory.getLogger(JdbcUtil.class);
	private static JdbcUtil util;

	private DataSource ds;
	private Connection conn;
	
	final String DATASOURCE = Config.getInstance().getProperties("DATASOURCE");
//	final String DATASOURCE = "orcl";

	private JdbcUtil() {
		this.ds = null;
		this.conn = null;	
	}

	public static JdbcUtil getInstance() {
		if (util == null) {
			util = new JdbcUtil();
		}
		return util;
	}

	public Connection getConnection() {

		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup(DATASOURCE);
			conn = ds.getConnection();
			logger.info("Database DataSource Connection Success!!");
		} catch (SQLException e) {
			logger.info("SQLException : " + e.getMessage());
		} catch (NamingException e) {
			logger.info("NamingException : " + e.getMessage());
		}
		return conn;
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.info("SQLException : " + e.getMessage());
			}
		}
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.info("SQLException : " + e.getMessage());
			}
		}
	}

	public static void close(PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				logger.info("SQLException : " + e.getMessage());
			}
		}
	}

	public static void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				logger.info("SQLException : " + e.getMessage());
			}
		}
	}
}
