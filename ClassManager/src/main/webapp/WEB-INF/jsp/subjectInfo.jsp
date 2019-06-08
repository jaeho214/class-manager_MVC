<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8">

<title>Schedule Template | CodyHouse</title>
</head>
<body>
	<div class="cd-schedule-modal__event-info">
	<div>
		<ul class="text-center font-italic">
			<li><h1>과목 정보</h1></li>
			<li><h3>- 학수번호 : ${content.number }</h3></li>
			<li><h3>- 요일 : ${content.date }</h3></li>
			<li><h3>- 교수명 : ${content.professor }</h3></li>
			<li><h3>- 강의실 : ${content.room }</h3></li>
			<li><h3>- 학점 : ${content.credit }</h3></li>
			<li><h3>- 분류 : ${content.kinds }</h3></li>
		</ul>
	</div>
	</div>
</body>
</html>