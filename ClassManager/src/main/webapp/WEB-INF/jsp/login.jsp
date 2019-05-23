<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function signUp(){
			location.href="/signup";
		}
	</script> 
</head>
<body>
	<form action="/main" Method="post">
		아이디 : <input type = "text" name="strID"><br/>
		비밀번호 : <input type = "password" name="strPwd">
		<br/><br/>
		<input type = "submit" value="로그인">
		<input type = "button" value="회원가입" onclick="signUp()">
		
	</form>
	

</body>
</html>