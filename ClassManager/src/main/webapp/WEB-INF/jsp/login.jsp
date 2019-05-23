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
		
/* 		
 		$(document).ready(function(){
			$("#login_btn").unbind("click").click(function(e){
				e.preventDefault();
			});
		}); 
*/
		
		function fn_login(){
			if($("userId").val().length < 1){
				alert("아이디를 입력해주세요");
			}
			else if($("#userPwd").val().length < 1){
				alert("비밀번호를 입력해주세요");
			}
			else{
				var comSubmit = new ComSubmit("frm");
				comSubmit.setUrl("/login.do");
				comSubmit.submit();
			}
		}
	</script> 
</head>
<body>
	<h1> Login </h1>
   	<form action="/login.do" method="post">
   		<input type="text" placeholder="ID" name="id"/> </br>
        <input type="password" placeholder="Password" name="password"/> </br>
        <input type="submit" value="로그인">
        <input type="button" value="회원가입" onclick="signUp()">
    </form>
	

</body>
</html>