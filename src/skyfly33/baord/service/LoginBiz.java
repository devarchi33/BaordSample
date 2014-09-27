package skyfly33.baord.service;

import java.sql.Connection;

import skyfly33.board.beans.Member;
import skyfly33.board.dao.oracle.OracleDao;
import skyfly33.board.util.JdbcUtil;

public class LoginBiz {

	public Member getMemberLogin(Connection conn, String id, String pass) {
		OracleDao loginDao = new OracleDao();
		Member member = loginDao.getMemberLogin(conn, id, pass);
		JdbcUtil.close(conn);
		return member;
	}
}
