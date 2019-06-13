<%@page import="java.util.ArrayList"%>
<%@page import="java.awt.print.Printable"%>
<%@page import="com.dev.domain.Schedule"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.dev.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   request.setCharacterEncoding("euc-kr");
%>

<%
   Member member = (Member) session.getAttribute("member");
   Long ssno = 0L;
   String sstart_date = "";
   String send_date = "";
   String stitle = "";
   String scontent = "";
   String suser_id = "";

   List<String> lists = new ArrayList<String>();
   List<Schedule> schedulelist = (List<Schedule>) session.getAttribute("schedulelist");

   Calendar cal = Calendar.getInstance();
   String strYear = request.getParameter("year");
   String strMonth = request.getParameter("month");

   int year = cal.get(Calendar.YEAR);
   int month = cal.get(Calendar.MONTH);
   int date = cal.get(Calendar.DATE);

   if (strYear != null) {
      year = Integer.parseInt(strYear);
      month = Integer.parseInt(strMonth);
   } else {
   }

   //년도/월 셋팅
   cal.set(year, month, 1);
   int startDay = cal.getMinimum(java.util.Calendar.DATE);
   int endDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
   int start = cal.get(java.util.Calendar.DAY_OF_WEEK);
   int newLine = 0;

   //오늘 날짜 저장.
   Calendar todayCal = Calendar.getInstance();
   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
   int intToday = Integer.parseInt(sdf.format(todayCal.getTime()));
%>

<!DOCTYPE html>
<html>
<head>
<script>
        function cancel(){
            location.href="/main"
        }

         function modal_view(sno,title,content,start,end){
            $("#scheduleDetails").click(function(event){
               $(".modal-body #sno").val(sno);    
               $(".modal-body #title").val(title);
               $(".modal-body #content").val(content);
               $(".modal-body #start_date").val(start);
               $(".modal-body #end_date").val(end);
            })
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
         <a
            class="sidebar-brand d-flex align-items-center justify-content-center"
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
         <li class="nav-item"><a class="nav-link collapsed"
            href="/assignment"> <span>과제 관리</span>
         </a></li>

         <!-- Nav Item - Pages Collapse Menu -->
         <li class="nav-item"><a class="nav-link collapsed"
            href="/schedule"> <span>일정 관리</span>
         </a></li>


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
                  <li class="nav-item dropdown no-arrow"><a
                     class="nav-link dropdown-toggle" href="#" id="userDropdown"
                     role="button" data-toggle="dropdown" aria-haspopup="true"
                     aria-expanded="false"> <span
                        class="mr-2 d-none d-lg-inline text-gray-600 small"> <%
    out.println(member.getName());
 %>
                           님
                     </span>
                  </a> <!-- Dropdown - User Information -->
                     <div
                        class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                        aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="/memberInfo"> <i
                           class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
                        </a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/logout" data-toggle="modal"
                           data-target="#logoutModal"> <i
                           class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                           Logout
                        </a>
                     </div></li>

               </ul>

            </nav>
            <!-- End of Topbar -->


            <div class="container-fluid">

               <!--Page Heading
               <div
                  class="d-sm-flex align-items-center justify-content-between mb-4">
                  <h1 class="h3 mb-0 text-gray-800">과제 관리</h1>
               </div> -->

            <a data-toggle="modal" data-target="#scheduleModal"
               class="h5 mb-0 font-weight-bold text-white btn btn-primary">
               스케줄 등록 </a>

            <!-- 스케줄등록 Modal -->
            <div class="modal fade" id="scheduleModal" tabindex="-1"
               role="dialog" aria-labelledby="exampleModalLabel"
               aria-hidden="true">
               <div class="modal-dialog" role="document">

                  <form action="schedule.do" method="post" name="form1">
                     <div class="modal-content">
                        <div class="modal-header">
                           <h5 class="modal-title" id="exampleModalLabel">스케줄 등록</h5>
                           <button class="close" type="button" data-dismiss="modal"
                              aria-label="Close">
                              <span aria-hidden="true">×</span>
                           </button>
                        </div>
                        <div class="modal-body">

                           시작 날짜<input type="date" class="form-control form-control-user"
                              name="start_date"> <br> 종료 날짜<input type="date"
                              class="form-control form-control-user" name="end_date">
                           <br> <input type="text"
                              class="form-control form-control-user" name="title"
                              placeholder="제목"> <br> <input type="text"
                              class="form-control form-control-user" name="content"
                              placeholder="내용"> <br>

                        </div>
                        <div class="modal-footer">
                           <button class="btn btn-secondary" type="button"
                              data-dismiss="modal">취소</button>
                           <input type="submit" class="btn btn-secondary" value="추가">
                        </div>
                     </div>
                  </form>

               </div>
            </div>

            <!-- 달력 화면에 나타내기 -->
            <form name="calendarFrm" id="calendarFrm" action="" method="post" name="form2">
               <DIV id="content" >
                  <table width="100%" border="0" cellspacing="1" cellpadding="1" align="center">
                     <tr>
                        <!--  오늘로 가는 버튼 생성 -->
                        <td align="center"><input type="button"
                           onclick="javascript:location.href='<c:url value='/schedule' />'"
                           value="오늘" /></td>
                     </tr>
                  </table>
               </DIV>
            </form>

            <!--날짜 네비게이션  -->
            <table width="100%" border="0" cellspacing="1" cellpadding="1"
               id="KOO" bgcolor="#F3F9D7" style="border: 1px solid #CED99C">
               <tr>
                  <td height="60">

                     <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                           <td height="10"></td>
                        </tr>
                        <tr>
                           <td align="center">
                              <!-- 전년도 로 가는 버튼--> <a
                              href="<c:url value='/schedule' />?year=<%=year - 1%>&amp;month=<%=month%>"
                              target="_self"> <b>&lt;&lt;</b>
                           </a> <%
    if (month > 0) {
 %> <a
                              href="<c:url value='/schedule' />?year=<%=year%>&amp;month=<%=month - 1%>"
                              target="_self"> <b>&lt;</b>
                              <!-- 이전달 -->
                           </a> <%
    } else {
 %> <b>&lt;</b> <%
    }
 %> &nbsp;&nbsp; <%=year%>년 <%=month + 1%>월

                              &nbsp;&nbsp; <%
    if (month < 11) {
 %> <a
                              href="<c:url value='/schedule' />?year=<%=year%>&amp;month=<%=month + 1%>"
                              target="_self"> <!-- 다음달 -->
                                 <b>&gt;</b>

                           </a> <%
    } else {
 %> <b>&gt;</b> <%
    }
 %> <a
                              href="<c:url value='/schedule' />?year=<%=year + 1%>&amp;month=<%=month%>"
                              target="_self"> <!-- 다음해 -->
                                 <b>&gt;&gt;</b>
                           </a>
                           </td>
                        </tr>
                     </table>
                  </td>
               </tr>
            </table>
            <br>
            <table border="0" cellspacing="1" cellpadding="1" bgcolor="#FFFFFF">
               <THEAD>
                  <table width="910" cellpadding="2" cellspacing="0" border="1"
                     align="center">
                     <tr height="30">
                        <td width="130"><font size="2">일</font></td>
                        <td width="130"><font size="2">월</font></td>
                        <td width="130"><font size="2">화</font></td>
                        <td width="130"><font size="2">수</font></td>
                        <td width="130"><font size="2">목</font></td>
                        <td width="130"><font size="2">금</font></td>
                        <td width="130"><font size="2">토</font></td>
                     </tr>
                     <%
                        //처음 빈공란 표시
                        int index;
                        for (index = 1; index < start; index++) {
                           out.println("<TD >&nbsp;</TD>");
                           newLine++;
                        }

                        for (index = 1; index <= endDay; index++) {
                           String color = "";

                           // 각 라인의 첫번째 칸 날자 빨간색 처리
                           if (newLine == 0) {
                              color = "RED";
                              // 각 라인의 6번쨰 칸 토요일 파란색 처리
                           } else if (newLine == 6) {
                              color = "#529dbc";
                              // 나머지 칸 검은색
                           } else {
                              color = "BLACK";
                           }
                           ;

                           String sUseDate = Integer.toString(year);

                           sUseDate += Integer.toString(month + 1).length() == 1 ? "0" + Integer.toString(month + 1)
                                 : Integer.toString(month + 1);

                           sUseDate += Integer.toString(index).length() == 1 ? "0" + Integer.toString(index)
                                 : Integer.toString(index);

                           int iUseDate = Integer.parseInt(sUseDate);

                           String backColor = "#EFEFEF";

                           // 오늘 날짜 기준 배경색 진한색 처리
                           if (iUseDate == intToday) {
                              backColor = "#c9c9c9";
                           }
                           out.println("<TD valign='top' align='left' height='92px' bgcolor='" + backColor + "' nowrap>");
                     %>
                     <font color='<%=color%>'> <!-- 일자 찍기 --> 
                     <%
                         out.println(index);
                            out.println("<BR>");

                            out.println("<html><body>");
                            for (int i = 0; i < schedulelist.size(); i++) {
                               Schedule schedule = schedulelist.get(i);
                               String std = schedule.getStart_date();
                               String edd = schedule.getEnd_date();
                               String start_date = std.replace("-", "");
                               String end_date = edd.replace("-", "");

                               ssno = schedule.getSno();
                               sstart_date = schedule.getStart_date();
                               send_date = schedule.getEnd_date();
                               stitle = schedule.getTitle();
                               scontent = schedule.getContent();
                               suser_id = schedule.getUser_id();

                               if (start_date.equals(sUseDate)) {
                                  out.print(
                                        "<a href='#' data-toggle='modal' data-target='#scheduleDetails'"
                                  +" onclick='modal_view(\""+schedule.getSno()+"\",\""+schedule.getTitle()+"\",\""+schedule.getContent()+"\",\""+start_date+"\", \""+end_date+"\")'>"
                                              + schedule.getTitle() + "</a>");
                                  
                                  //out.println("<button type='button' class='btn btn-info btn-lg' onclick='show('stitle')''>++button>");
                               }
                               
                            }
                            out.println("</body></html>");
                            out.println("<BR>");
                            //기능 제거 
                            out.println("</TD>");
                            newLine++;
                            if (newLine == 7) {
                               out.println("</TR>");
                               if (index <= endDay) {
                                  out.println("<TR>");
                               }
                               newLine = 0;
                            }
                         }
                         //마지막 공란 LOOP
                         while (newLine > 0 && newLine < 7) {
                            out.println("<TD>&nbsp;</TD>");
                            newLine++;
                         }
                      %>
                     </font>
                  </table>
               </THEAD>

            </TABLE>
         </DIV>

               <!-- 스케줄 상세보기 Modal -->
               <div class="modal fade" id="scheduleDetails" tabindex="-1" 
               role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                  <div class="modal-dialog" role="document">
                     <form action="scheduleDelete" method="post" name="form3">
                        <div class="modal-content">
                           <div class="modal-header">
                              <h5 class="modal-title" id="exampleModalLabel">과제 상세보기</h5>
                              <button class="close" type="button" data-dismiss="modal"
                                 aria-label="Close">
                                 <span aria-hidden="true">×</span>
                              </button>
                           </div>
                           <div class="modal-body">
                 <input type="hidden" id="sno" name="sno" > <br>   
                              제목 : <input type="text" class="form-control" id="title" name="title" readonly> <br>
                              내용 :<input type="text" class="form-control" id="content" name="content" readonly> <br>
                              시작날짜<input type="text" class="form-control" id="start_date" name="start_date" readonly>
             <h2>~</h2> 
                종료날짜<input type="text" class="form-control" id="end_date" name="end_date" readonly> <br>
                           
             
                           </div>
                           <div class="modal-footer">
                              <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>
                              <input type="submit" class="btn btn-secondary" value="삭제">
                           </div>
                        </div>
                     </form>
                  </div>
               </div>



      </div>
      <!-- End of Main Content -->
      <div>
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