<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.dev.domain.Classes"%>
<%@page import="com.dev.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("euc-kr"); %>

<%
	Member member = (Member)session.getAttribute("member");
	String name = (String)session.getAttribute("name");
	//List<Classes> classes = (List<Classes>)session.getAttribute("classes");
	long num = 0L;
	
%>
<!DOCTYPE html>
<html>
<head>
<script>
		function logout(){
			location.href="/logout";
		}

</script>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Main</title>


<link href="resource/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">


<link href="resource/css/sb-admin-2.min.css" rel="stylesheet">

<title>Insert title here</title>
</head>
<body id="page-top">


	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a class="sidebar-brand d-flex align-items-center justify-content-center" href="/main">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">ClassManager</div>
			</a>
			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Menu</div>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <span>시간표</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">시간표 목록</h6>
						<c:forEach var="timetable" items="${timetableList}">
							<a class="collapse-item" href="/timetable?id=${timetable.tno}">${timetable.name} </a> 					
						</c:forEach>
					</div>
				</div>
			</li>

			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item">
			<a class="nav-link collapsed" href="/assignment"> <span>과제 관리</span>
			</a>
			</li>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item">
			<a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapsePages"
				aria-expanded="true" aria-controls="collapsePages"> <span>일정 관리</span>
			</a>
				<div id="collapsePages" class="collapse"
					aria-labelledby="headingPages" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Login Screens:</h6>
						<a class="collapse-item" href="login.html">Login</a> 
						<a class="collapse-item" href="register.html">Register</a> 
						<a class="collapse-item" href="forgot-password.html">Forgot Password</a>
						<div class="collapse-divider"></div>
						<h6 class="collapse-header">Other Pages:</h6>
						<a class="collapse-item" href="404.html">404 Page</a> 
						<a class="collapse-item" href="blank.html">Blank Page</a>
					</div>
				</div></li>


			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow">
						<a class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 
							<span class="mr-2 d-none d-lg-inline text-gray-600 small">
									<%out.println(member.getName());%> 님
							</span>
						</a> <!-- Dropdown - User Information -->
							<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="/memberInfo"> 
									<i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="/logout" data-toggle="modal" data-target="#logoutModal"> 
									<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
								</a>
							</div>
						</li>

					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<h1 class="h3 mb-0 text-dark">시간표 등록</h1><br>
						<c:if test="${name == null}">
								<form action="/inputTitle" method="get" name="form1">
									<input type="text" name="name" class="form-control-lg" placeholder="시간표 제목"> 
									<input type="submit" class = "text-dark btn btn-lg btn-primary" value="확인">
								</form>
						</c:if> <br>
						<c:if test="${name != null}">
								<p>
								<h1>
									${name }
								</h1>
								</p>
						</c:if>

					<br>
					<table>
						수업 목록↓<br><br>
						<c:forEach var="item" items="${classes}">
							<tr>
								<td>${item.subject} => ${item.date }  ${item.startTime } ~ ${item.endTime }</td>
								<td></td>
								<td><a href="/deleteClass?subject=${item.subject }" class="font-weight-bold text-white btn btn-primary btn-sm btn-block"> 
									삭제
								</a></td>
							</tr>
						</c:forEach>
					</table>
					<br>
						<h3>* 총 학점 : ${credit }</h3><br>
						<a data-toggle="modal" data-target="#timeTableModal" class="h5 mb-0 font-weight-bold text-white btn btn-primary"> 
							수업 추가
						</a>
						<br><br>


						<a href="/makeTimeTable?name=${name}" class="col-md-3 btn btn-success" style="height: 90px; float: none; margin: 0 auto"> 
							<i class="fas fa-sm text-white-500"></i>
							<h3>시간표 생성</h3>
						</a>		
				</div>

				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; ClassManager (YoungJae) 2019</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- TimeTable Insert Modal -->
	<div class="modal fade" id="timeTableModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<form action="inputClass.do" method="post" name="form2">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">시간표 생성</h5>
						<button class="close" type="button" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">

						<input type="text" class="form-control form-control-user" name="number" placeholder="학수번호"> <br>
						<input type="text" class="form-control form-control-user" name="subject" placeholder="과목명"> <br>
						시간 : <input type="time" class="form-control form-control-user" name="startTime" placeholder="시간"> <br> <h3>~</h3>
						<input type="time" class="form-control form-control-user" name="endTime" placeholder="시간"> <br>
						
						요일 : 
						<input type="checkbox" name="date" value="MON">월요일
						<input type="checkbox" name="date" value="TUE">화요일
						<input type="checkbox" name="date" value="WED">수요일
						<input type="checkbox" name="date" value="THU">목요일
						<input type="checkbox" name="date" value="FRI">금요일
						<br>
						<input type="text" class="form-control form-control-user" name="professor" placeholder="교수명"> <br>
						<input type="text" class="form-control form-control-user" name="room" placeholder="강의실"> <br>
						<input type="text" class="form-control form-control-user" name="credit" placeholder="학점"> <br>
						<input type="hidden" name="table_no" value="<%out.print(num);%>"> <select name="kinds" class="form-control form-control-user">
							<option value="전공">전공</option>
							<option value="교양">교양</option>
						</select>
					</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>
						<input type="submit" class="btn btn-secondary" value="추가">
					</div>
				</div>
			</form>
		</div>
	</div>
	
	<!-- TimeTable Delete Modal -->
	<div class="modal fade" id="timeTableDeleteModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">시간표 삭제</h5>
						<button class="close" type="button" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">
						수업을 삭제하시겠습니까?
					</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>
						<a href="/deleteClass?subject=${deleteSubject}" class="btn btn-secondary">삭제</a>
					</div>
				</div>
		</div>
	</div>
	

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">로그아웃 하시겠습니까?</h5>
					<button class="close" type="button" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">로그아웃 하시겠습니까?</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>
					<a class="btn btn-primary" href="/logout">로그아웃</a>
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

	<!-- Page level plugins -->
	<script src="resource/vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="resource/js/demo/chart-area-demo.js"></script>
	<script src="resource/js/demo/chart-pie-demo.js"></script>

</body>

</html>