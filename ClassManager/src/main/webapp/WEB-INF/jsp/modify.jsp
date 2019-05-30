<%@page import="com.dev.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<% request.setCharacterEncoding("euc-kr"); %>

<%
	Member member = (Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function cancel(){
			history.back();
		}
		
	</script>
</head>
<body>
		<form action="modify.do" method="post" ">
			아이디 <% out.println(member.getId()); %> </br>
			<input type="hidden" name="id" value="<% out.print(member.getId()); %>">
			비밀번호<input type="password" name="password" maxlength="50"> </br> 
			이름<input type="text" name="name" maxlength="50" value="<%out.print(member.getName());%>"> </br>
			이메일<input type="text" name="email" maxlength="50" value="<%out.print(member.getEmail());%>"> </br>
			대학교<input type="text" name="univ" value="<%out.print(member.getUniv());%>" /> </br>
			전공<input type="text" name="major" value="<%out.print(member.getMajor());%>"/> </br>
			전화번호<input type="text" name="phone" value="<%out.print(member.getPhone());%>"/> </br>
		<input type="submit" value="수정완료" /> 
		<input type="button" value="취소" onclick="cancel()">
	</form>
</body>
</html>