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

		String sql = "select * from member3";

		ResultSet rs = boardDao.selectList(conn, sql);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/main.css" />
<style type="text/css">
table,td,th {
	border: 1px solid purple;
}

th {
	background-color: purple;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Donghoon's BoardSample - Member_List</title>

</head>

<body>
	<h1>
		<p>Member List</p>
	</h1>
	<table>

		<tr>
			<th>Name</th>
			<th>ID</th>
			<th>Gender</th>
			<th>Hobby</th>
			<th>Edu</th>
		</tr>

		<%
			while (rs.next()) {

					out.print("<tr>");
					out.print("<td>" + rs.getString(1) + "</td>");
					out.print("<td>" + rs.getString(2) + "</td>");
					out.print("<td>" + rs.getString(3) + "</td>");
					out.print("<td>" + rs.getString(4) + "</td>");
					out.print("<td>" + rs.getString(5) + "</td>");
					out.print("</tr>");
				}
			} finally {
				JdbcUtil.close(conn);
			}
		%>

	</table>

	<p>
		<a href="login.jsp">login</a><br />
	</p>
</body>
</html>