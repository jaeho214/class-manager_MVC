<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP TEST</title>
</head>
<body>
	JSP TEST!!
	<%
		Date date = new Date();
		out.println(date);
	%>
</body>
</html>