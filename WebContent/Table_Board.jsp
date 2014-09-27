<%@page import="skyfly33.board.util.JdbcUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="skyfly33.board.beans.Board"%>
<%@ page import="skyfly33.board.dao.oracle.OracleDao"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Connection"%>


<%
	Connection conn = JdbcUtil.getInstance().getConnection();
	try {
		request.setCharacterEncoding("UTF-8");

		OracleDao boardDao = new OracleDao();

		String sql = "select * from board2";

		ResultSet rs = boardDao.selectList(conn, sql);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Donghoon's BoardSample - Board_List</title>
<link rel="stylesheet" type="text/css" href="css/main.css" />
</head>
<body>
	<div id="header">
		<form action="logout" method="get">
			<input type="submit" value="로그아웃" /><br>
		</form>
	</div>

	<!-- HTML문서의 주 내용이 들어가는 부분입니다. -->

	<h1>
		<p>게시글 리스트</p>
	</h1>
	<!-- 헤드라인 글씨를 표현하는 태그입니다. -->

	<table>
		<!-- 표 형식의 데이터를 표현하는 태그입니다. -->

		<tr>
			<!-- table태그 내에서 행을 정의할때 쓰는 태그입니다. -->

			<th>번호</th>
			<!-- Table Header의 약자로 table태그 내에서 -->

			<th>제목</th>
			<!-- 강조하고싶은 컬럼을 나타낼때 쓰는 태그입니다. -->

			<th>작성자</th>

			<th>날짜</th>

			<th>조회수</th>

		</tr>

		<%
			while (rs.next()) {

					out.print("<tr>");

					out.print("<td>" + rs.getInt("idx") + "</td>");

					out.print("<td> <a href = 'content.jsp?idx="
							+ rs.getInt("idx") + "'>" + rs.getString("title")
							+ "</a></td>");

					out.print("<td>" + rs.getString("writer") + "</td>");

					out.print("<td>" + rs.getString("regdate") + "</td>");

					out.print("<td>" + rs.getInt("count") + "</td>");

					out.print("</tr>");

				}
			} finally {
				JdbcUtil.close(conn);
			}
		%>

	</table>
	<p>

		<a href="Form_Board_Write.jsp">글쓰기</a><br /> <a href="Table_Emp.jsp">직원리스트</a><br />
		<a href="Table_Dept.jsp">부서리스트</a><br /> <a href="Table_Member.jsp">회원리스트</a><br />
		<a href="Table_Salgrade.jsp">salgrade</a>

	</p>

</body>
</html>