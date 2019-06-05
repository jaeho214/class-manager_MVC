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
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Login</title>

  <!-- Custom fonts for this template-->
  <link href="resource/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="resource/css/sb-admin-2.min.css" rel="stylesheet">

<title>Insert title here</title>

	<script>
		function modify(){
			location.href="/modify";
		}
		function cancel(){
			history.back();
		}
		
	</script>
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
                    <h1 class="h4 text-gray-900 mb-4">회원 정보</h1>
                  </div>
                  <form action="/pwCheck" method="post" class="user">
                    <div class="form-group">
                      ID :  <% out.println(member.getId()); %>
                    </div>
                    <div class="form-group">
                                      이름 :  <% out.println(member.getName()); %>
                    </div>
                    <div class="form-group">
                                      전화번호 :  <% out.println(member.getPhone()); %>
                    </div>
                    <div class="form-group">
                                      메일 주소 :  <% out.println(member.getEmail()); %>
                    </div>
                    <div class="form-group">
                                      학교명 :  <% out.println(member.getUniv()); %>
                    </div>
                    <div class="form-group">
                                      학과명 :  <% out.println(member.getMajor()); %>
                    </div>
                    <%-- <input type="hidden" name="id" value="<%out.println(member.getId());%>"> </br>
			        <input type="hidden" name="name" value="<%out.println(member.getName());%>"> </br>
			        <input type="hidden" name="email" value="<%out.println(member.getEmail());%>"> </br>
			        <input type="hidden" name="univ" value="<%out.println(member.getUniv());%>" /> </br>
			        <input type="hidden" name="major" value="<%out.println(member.getMajor());%>"/> </br>
			        <input type="hidden" name="phone" value="<%out.println(member.getPhone());%>"/> </br> --%>
			        <input type="button" value="정보 수정" class="btn btn-primary btn-user btn-block" onClick="modify()">
                    <input type="submit" value="회원 탈퇴" class="btn btn-primary btn-user btn-block">
			        <input type="button" value="취소" class="btn btn-primary btn-user btn-block" onClick="cancel()">
                    
                  </form>
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