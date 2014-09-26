<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Donghoon's Model1 Board - login</title>
<script>
function formCheck() { 
		var id = document.forms[0].id;       
		var pass = document.forms[0].pass;

		if (id.value == null || id.value == ""){                                   
			alert('아이디를 입력하세요');                                  
			document.forms[0].id.focus();                          
			return false;                                                     
		}
		
		if (pass.value == null ||  pass.value  == ""){           
			alert('비밀번호를 입력하세요');  
			document.forms[0].pass.focus();                       
			return false;                
		}
		
	}
</script>
</head>
<body>
<form action="login_proc.jsp" method="get" enctype="multipart/form-data" onsubmit="return formCheck();">
		<table>							
							
			<tr>									
				<th>아이디</th>						
				<td><input type="text" name="id" size="20" /></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="pass" size="20" /></td>
			</tr>
			
		</table>
		<input type="submit" value="로그인" /><br>
		
	</form> 
	<a href="Form_Join.jsp" >회원가입</a>
</body>
</html>
