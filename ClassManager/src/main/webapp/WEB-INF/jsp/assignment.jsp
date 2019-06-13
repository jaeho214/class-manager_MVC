<%@page import="com.dev.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("euc-kr"); %>

<%
	Member member = (Member)session.getAttribute("member");
	long fno = 0L;
%>

<!DOCTYPE html>
<html>
<head>
<script>
        function cancel(){
            location.href="/main"
        }
</script>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Main</title>

<!-- Custom fonts for this template-->
<link href="resource/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="resource/css/sb-admin-2.min.css" rel="stylesheet">

<title>Insert title here</title>
</head>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a class="sidebar-brand d-flex align-items-center justify-content-center"
				href="/main">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">C M</div>
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
							<a class="collapse-item" href="/timetable?id=${timetable.tno}">${timetable.name}</a> 					
						</c:forEach>
					</div>
				</div></li>

			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item">
			<a class="nav-link collapsed" href="/assignment"> <span>과제 관리</span>
			</a>
			</li>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item">
			<a class="nav-link collapsed" href="/schedule"> <span>일정 관리</span>
			</a>
			</li>


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
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow">
						<a class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">
						<span class="mr-2 d-none d-lg-inline text-gray-600 small">
									<% out.println(member.getName()); %> 님
						</span>
						</a> <!-- Dropdown - User Information -->
							<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="/memberInfo"> 
								<i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile </a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="/logout" data-toggle="modal"
									data-target="#logoutModal"> 
									<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
								</a>
							</div>
						</li>

					</ul>

				</nav>
				<!-- End of Topbar -->

   					 &nbsp;
   					 <a data-toggle="modal" data-target="#assignmentModal" class="h5 mb-0 font-weight-bold text-white btn btn-primary"> 
							과제 등록
					 </a>	 
					 </br>
					 </br>
					 </br>
					 <h3>&nbsp;과제 목록</h3>
    <table class="table table-hover">
      <thead>  
        <tr>
        	
            &nbsp;
           <th>제목</th>
            <th>내용</th>
            <th>기한</th>
            <th>파일</th>
            <th>수정 / 삭제</th>
            
        </tr>
      </thead>
        
        <c:forEach var="assignmentList" items="${assignmentList}">
        	<tr>
            
            <td>${assignmentList.title}</td>
            <td>${assignmentList.content}</td>
            <td>${assignmentList.deadline}</td>
            <td><a href="/fileDown?fno=${assignmentList.fno}">${assignmentList.fileoriname }</a></td>
            <td>
            	<div class="btn-group">
            			 
					<button name="update" onclick="location.href='/assignmentUpdate?ano=${assignmentList.ano}'" 
            			class="btn btn-xs btn-warning ">수정</button>  
            		
            		&nbsp;
            		<button name="delete" onclick="location.href='/assignmentDelete?ano=${assignmentList.ano}'" 
            			class="btn btn-xs btn-danger " >삭제</button> 
            	
            	</div>
  
        </tr>
        </c:forEach>
    </table>

		<!-- 과제등록 Modal -->
	<div class="modal fade" id="assignmentModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
		
			<form action="assignment.do" method="post" enctype="multipart/form-data">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">과제 등록</h5>
						<button class="close" type="button" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">

						<input type="text" class="form-control form-control-user" name="title" placeholder="제목"> <br>
						<input type="text" class="form-control form-control-user" name="content" placeholder="내용"> <br>
					    <input type="date" class="form-control form-control-user" name="deadline" placeholder="기한"> <br>
					    <input type="hidden" name="fno" value=<%out.print(fno); %>>
						<input type="file" name="files"> <!-- 추가 -->

					</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>
						<input type="submit" class="btn btn-secondary" value="추가">
					</div>
				</div>
			</form>
			
		</div>
	</div>
	

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

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">로그아웃 하시겠습니까?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">로그아웃 하시겠습니까?</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">취소</button>
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