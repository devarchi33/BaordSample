package skyfly33.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import skyfly33.baord.service.LoginBiz;
import skyfly33.board.beans.Member;
import skyfly33.board.dao.oracle.OracleDao;
import skyfly33.board.util.JdbcUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Logger logger = LoggerFactory.getLogger(OracleDao.class);

	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		LoginBiz loginBiz = new LoginBiz();
		Member member = loginBiz.getMemberLogin(JdbcUtil.getInstance()
				.getConnection(), id, pass);

		if (member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("Table_Board.jsp");
			dispatcher.forward(request, response);
			
			logger.info("id : '"+id + "' login success!!");
		}
	}
}
