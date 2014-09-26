package bak;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class BoardDaoProviderInit extends HttpServlet {

	public void init(ServletConfig config) {
		String dbms = config.getInitParameter("dbms");
		if (dbms != null) {
			BoardDaoProvider.getInstance().setDbms(dbms);
		}
	}
}
