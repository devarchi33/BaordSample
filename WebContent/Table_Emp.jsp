<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="java.util.regex.Pattern"%>
<%@ page import="skyfly33.board.dao.oracle.*"%>
<%@ page import="skyfly33.board.util.JdbcUtil"%>

<%
	Connection conn = JdbcUtil.getInstance().getConnection();
	try {
		request.setCharacterEncoding("UTF-8");

		OracleDao boardDao = new OracleDao();

		String sql = "select * from emp";

		ResultSet rs = boardDao.selectList(conn, sql);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/main.css" />
<style type="text/css">
table,td,th {
	border: 1px solid blue;
}

th {
	background-color: blue;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Donghoon's BoardSample - Emp_List</title>

</head>

<body>
	<h1>
		<p>Emp List</p>
	</h1>
	<table>

		<tr>
			<th>EMPNO</th>
			<th>ENAME</th>
			<th>JOB</th>
			<th>MGR</th>
			<th>HIREDATE</th>
			<th>SAL</th>
			<th>COMM</th>
			<th>DEPTNO</th>
		</tr>

		<%
			while (rs.next()) {
					out.print("<tr>");
					out.print("<td>" + rs.getString(1) + "</td>");
					out.print("<td>" + rs.getString(2) + "</td>");
					out.print("<td>" + rs.getString(3) + "</td>");
					out.print("<td>" + rs.getString(4) + "</td>");
					out.print("<td>" + rs.getString(5) + "</td>");
					out.print("<td>" + rs.getString(6) + "</td>");
					out.print("<td>" + rs.getString(7) + "</td>");
					out.print("<td>" + rs.getString(8) + "</td>");
					out.print("</tr>");
				}
			} finally {
				JdbcUtil.close(conn);
			}
		%>

	</table>

	<p>
		<a href="Table_Board.jsp">Board</a><br /> <a href="Table_Dept.jsp">Dept
			List</a><br /> <a href="Table_Salgrade.jsp">Salgrade List</a>
	</p>
</body>
</html>