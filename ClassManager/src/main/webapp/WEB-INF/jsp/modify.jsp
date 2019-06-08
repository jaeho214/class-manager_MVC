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

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Login</title>

<!-- Custom fonts for this template-->
<link href="resource/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="resource/css/sb-admin-2.min.css" rel="stylesheet">
<script>
    function cancel(){
      history.back();
    }
    
  </script>

<title>Insert title here</title>
</head>
<body class="bg-gradient-primary">

	<div class="container">

		<!-- Outer Row -->
		<div class="row justify-content-center">

			<div class="col-xl-7 col-lg-12 col-md-9">

				<div class="card o-hidden border-0 shadow-lg my-5">
					<!-- Nested Row within Card Body -->
					<div class="col-lg-12">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">ClassManager</h1>
							</div>
							<form action="modify.do" method="post" class="user">
								<div class="form-group">
									아이디
									<% out.println(member.getId()); %>
									</br> <input type="hidden" name="id"
										value="<% out.print(member.getId()); %>">
								</div>
								<div class="form-group">
									비밀번호 <input type="password" name="password" maxlength="50">
									</br>
								</div>
								<div class="form-group">
									이름 <input type="text" name="name" maxlength="50"
										value="<%out.print(member.getName());%>"> </br>
								</div>
								<div class="form-group">
									이메일 <input type="text" name="email" maxlength="50"
										value="<%out.print(member.getEmail());%>"> </br>
								</div>
								<div class="form-group">
									대학교 <input type="text" name="univ"
										value="<%out.print(member.getUniv());%>" /> </br>
								</div>
								<div class="form-group">
									전공 <input type="text" name="major"
										value="<%out.print(member.getMajor());%>" /> </br>
								</div>
								<div class="form-group">
									전화번호 <input type="text" name="phone"
										value="<%out.print(member.getPhone());%>" /> </br>
								</div>
								<input type="submit" value="수정 완료" class="btn btn-primary btn-user btn-block"> 
								<input type="button" value="취소" onclick="cancel()" class="btn btn-primary btn-user btn-block">
							</form>
							<hr>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="resource/vendor/jquery/jquery.min.js"></script>
	<script src="resource/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="resource/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="resource/js/sb-admin-2.min.js"></script>

</body>

</html>