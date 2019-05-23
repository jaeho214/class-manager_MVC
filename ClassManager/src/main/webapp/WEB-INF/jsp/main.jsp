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
		function timeTable(){
			location.href="/timetable";
		}
		function logout(){
			location.href="/logout";
		}	
		
	</script> 
</head>
<body>
	Main Page
	<button onclick="timeTable()">시간표 등록</button>
	<%
		out.println(member.getName());
	%>
	
	<form action="/modify" method="post">
		<input type="submit" value="회원정보"/>
	</form>
	
	<button onclick="logout()">로그아웃</button>
</body>
</html>