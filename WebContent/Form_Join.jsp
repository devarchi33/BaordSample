<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Donghoon's Model1 Board - Board_Insert</title>
</head>
<body>

<!--  form의 오브젝트를 받을 주소를 action에 써준다. method="post"는 주소를 감춰준다. -->
<form action="joinInsert.jsp" method="post"> 
아이디 : <input type="text" name="id"><br/>
패스워드 : <input type="password" name="pass"><br />
이름 : <input type="text" name="name"><br/><br />

성별 : <input type="radio" value="male" name="gender">남자
	   <input type="radio" value="female" name="gender">여자<br/>
취미:
<input type="checkbox" value="excercise" name="hobby">운동
<input type="checkbox" value="movie" name="hobby">영화
<input type="checkbox" value="travel" name="hobby">여행
<input type="checkbox" value="game" name="hobby">게임
<input type="checkbox" value="reading" name="hobby">독서
<input type="checkbox" value="fishing" name="hobby">낚시<br/><br />

<select name="edu">
	<option value="">:: 선택 ::</option>
	<option value="university">대졸</option>
	<option value="highschool">고졸</option>
	<option value="middleschool">중졸</option>
	<option value="etc">기타</option>
</select><br/><br />

<!-- submit은 form의 action에 넘겨준다. 같은 기능 image -->
<input type="submit" value="보내기"/> 
<input type="reset" value="다시입력"/>

</form>

</body>
</html>