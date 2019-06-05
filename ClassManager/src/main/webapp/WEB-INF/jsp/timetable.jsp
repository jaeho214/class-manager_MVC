<%@page import="com.dev.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% request.setCharacterEncoding("euc-kr"); %>

<%
  Member member = (Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">

	<script src="https://code.jquery.com/jquery-2.2.1.js"></script>
	<link rel="stylesheet" href="resource/timetable/css/style.css">
	<script>document.getElementsByTagName("html")[0].className += " js";</script>
	    



<!-- Custom fonts for this template-->
<link href="resource/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<!-- Custom styles for this template-->
<link href="resource/css/sb-admin-2.min.css" rel="stylesheet">


</head>
<body id="page-top">

  <!-- Page Wrapper -->
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
              <a class="collapse-item" href="/timetable?id=${timetable.tno}">${timetable.name}</a>          
            </c:forEach>
          </div>
        </div></li>

      <!-- Nav Item - Utilities Collapse Menu -->
      <li class="nav-item"><a class="nav-link collapsed" href="#"
        data-toggle="collapse" data-target="#collapseUtilities"
        aria-expanded="true" aria-controls="collapseUtilities"> <span>과제 관리</span>
      </a>
        <div id="collapseUtilities" class="collapse"
          aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Custom Utilities:</h6>
            <a class="collapse-item" href="utilities-color.html">Colors</a> 
            <a class="collapse-item" href="utilities-border.html">Borders</a> 
            <a class="collapse-item" href="utilities-animation.html">Animations</a>
            <a class="collapse-item" href="utilities-other.html">Other</a>
          </div>
        </div>
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
        </div>
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
        <div class="cd-schedule cd-schedule--loading margin-top--lg margin-bottom--lg js-cd-schedule">
    <div class="cd-schedule__timeline">
      <ul>
        <li><span>09:00</span></li>
        <li><span>09:30</span></li>
        <li><span>10:00</span></li>
        <li><span>10:30</span></li>
        <li><span>11:00</span></li>
        <li><span>11:30</span></li>
        <li><span>12:00</span></li>
        <li><span>12:30</span></li>
        <li><span>13:00</span></li>
        <li><span>13:30</span></li>
        <li><span>14:00</span></li>
        <li><span>14:30</span></li>
        <li><span>15:00</span></li>
        <li><span>15:30</span></li>
        <li><span>16:00</span></li>
        <li><span>16:30</span></li>
        <li><span>17:00</span></li>
        <li><span>17:30</span></li>
        <li><span>18:00</span></li>
      </ul>
    </div> <!-- .cd-schedule__timeline -->
  
    <div class="cd-schedule__events">
      <ul>
        <li class="cd-schedule__group" id="mon">
          <div class="cd-schedule__top-info" ><span>Monday</span></div>
  
          <ul>
          	<c:forEach var="item" items="${mon}">
          		<li class="cd-schedule__event">
              		<a data-start="${item.startClassTime}" data-end="${item.endClassTime}"  data-content="event-rowing-workout" data-event="event-1" href="#0">
                		<em class="cd-schedule__name">${item.subject} ${item.startClassTime} ${item.endClassTime}</em>
              		</a>
				</li>
          	</c:forEach>
          </ul>
        </li>
  
        <li class="cd-schedule__group" id="tue">
          <div class="cd-schedule__top-info" ><span>Tuesday</span></div>
  
          <ul>
          	<c:forEach var="item" items="${tue}">
          		<li class="cd-schedule__event">
              		<a data-start="${item.startClassTime}" data-end="${item.endClassTime}"  data-content="event-rowing-workout" data-event="event-2" href="#0">
                		<em class="cd-schedule__name">${item.subject} ${item.startClassTime} ${item.endClassTime}</em>
              		</a>
				</li>
          	
          	</c:forEach>
          </ul>
        </li>
  
        <li class="cd-schedule__group" id="wed">
          <div class="cd-schedule__top-info"><span>Wednesday</span></div>
  
          <ul>
          	<c:forEach var="item" items="${wed}">
          		<li class="cd-schedule__event">
              		<a data-start="${item.startClassTime}" data-end="${item.endClassTime}"  data-content="event-rowing-workout" data-event="event-3" href="#0">
                		<em class="cd-schedule__name">${item.subject} ${item.startClassTime} ${item.endClassTime}</em>
              		</a>
				</li>
          	</c:forEach>
          </ul>
        </li>
  
        <li class="cd-schedule__group" id="thu">
          <div class="cd-schedule__top-info"><span>Thursday</span></div>
  
          <ul>
          	<c:forEach var="item" items="${thu}">
          		<li class="cd-schedule__event">
              		<a data-start="${item.startClassTime}" data-end="${item.endClassTime}"  data-content="event-rowing-workout" data-event="event-4" href="#0">
                		<em class="cd-schedule__name">${item.subject} ${item.startClassTime} ${item.endClassTime}</em>
              		</a>
				</li>
          	</c:forEach>
          </ul>
        </li>
  
        <li class="cd-schedule__group" id="fri">
          <div class="cd-schedule__top-info"><span>Friday</span></div>
  
          <ul>
          	<c:forEach var="item" items="${fri}">
          		<li class="cd-schedule__event">
              		<a data-start="${item.startClassTime}" data-end="${item.endClassTime}"  data-content="event-rowing-workout" data-event="event-1" href="#0">
                		<em class="cd-schedule__name">${item.subject} ${item.startClassTime} ${item.endClassTime}</em>
              		</a>
				</li>
          	</c:forEach>
          </ul>
        </li>
      </ul>
    </div>
  
    <div class="cd-schedule-modal">
      <header class="cd-schedule-modal__header">
        <div class="cd-schedule-modal__content">
          <span class="cd-schedule-modal__date"></span>
          <h3 class="cd-schedule-modal__name"></h3>
        </div>
  
        <div class="cd-schedule-modal__header-bg"></div>
      </header>
  
      <div class="cd-schedule-modal__body">
        <div class="cd-schedule-modal__event-info"></div>
        <div class="cd-schedule-modal__body-bg"></div>
      </div>
  
      <a href="#0" class="cd-schedule-modal__close text--replace">Close</a>
    </div>
  
    <div class="cd-schedule__cover-layer"></div>
  </div> <!-- .cd-schedule -->
        

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

  <script src="resource/timetable/js/util.js"></script> <!-- util functions included in the CodyHouse framework -->
  <script src="resource/timetable/js/main.js"></script>
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