package bak;

import skyfly33.board.dao.AbstractDao;
import skyfly33.board.dao.oracle.OracleDao;

public class BoardDaoProvider {
	private static BoardDaoProvider bdp;

	private BoardDaoProvider() {
	}

	public static BoardDaoProvider getInstance() {
		if (bdp == null) {
			bdp = new BoardDaoProvider();
		}
		return bdp;
	}

	private OracleDao oracleDao = new OracleDao();
	private String dbms;

	void setDbms(String dbms) {
		this.dbms = dbms;
	}

	public AbstractDao getBoardDao() {
		if ("oracle".equals(dbms)) {
			return oracleDao;
		}

		return null;
	}

}
