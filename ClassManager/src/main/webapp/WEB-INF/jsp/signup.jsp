<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function cancel(){
			location.href="/login";
		}
	</script>
</head>
<body>
	<form method="post" action="/signup.do">
		아이디 <input type="text" name="id" maxlength="50"> </br>
		비밀번호<input type="password" name="password" maxlength="50"> </br> 
		이름<input type="text" name="name" maxlength="50"> </br>
		이메일<input type="text" name="email" maxlength="50"> </br>
		대학교<input type="text" name="univ" /> </br>
		전공<input type="text" name="major" /> </br>
		전화번호<input type="text" name="phone" /> </br>
		
		<input type="submit" value="가입완료" /> 
		<input type="button" value="취소" onclick="cancel()">
	</form>

</body>
</html>