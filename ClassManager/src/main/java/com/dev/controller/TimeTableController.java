package com.dev.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.domain.SessionClass;
import com.dev.domain.Classes;
import com.dev.domain.Member;
import com.dev.domain.TimeTable;
import com.dev.service.Impl.ClassesServiceImpl;
import com.dev.service.Impl.TimeTableServiceImpl;

@Controller
public class TimeTableController {

	private ClassesServiceImpl classesServiceImpl;
	private TimeTableServiceImpl timeTableServiceImpl;
	private int credit;
	private Classes deleteClass;

	private String date[] = { "MON", "TUE", "WED", "THU", "FRI" };
	private String time[] = { "0900", "1030", "1200", "1330", "1500", "1630" };
	private List<Classes> classList = new ArrayList<Classes>();
//===================================================================================
	private List<SessionClass> mon = new ArrayList<SessionClass>();
	private List<SessionClass> tue = new ArrayList<SessionClass>();
	private List<SessionClass> wed = new ArrayList<SessionClass>();
	private List<SessionClass> thu = new ArrayList<SessionClass>();
	private List<SessionClass> fri = new ArrayList<SessionClass>();

	private Date classTime;
	private Date endClassTime;

	

//===================================================================================
	public TimeTableController(ClassesServiceImpl classesServiceImpl, TimeTableServiceImpl timeTableServiceImpl) {
		this.classesServiceImpl = classesServiceImpl;
		this.timeTableServiceImpl = timeTableServiceImpl;
	}

	// 시간표 등록 페이지로 이동
	@GetMapping("/inputClass")
	public String inputClass(HttpSession session) {
		clearTableSession(session);
		menuTimeTableList(session);

		return "inputClass";
	}

	// 시간표에 수업 추가
	@PostMapping("/inputClass.do")
	public String titmetableComplete(Classes classes, HttpSession session) {
		credit = 0;
		classList.add(classes);
		autoDrawTimeTable(session);

		return "classInputComplete";
	}

	// 수업을 하나 입력을 완료
	@GetMapping("/inputComplete")
	public String inputComplete(HttpSession session) {
		session.setAttribute("classes", classList);

		return "inputClass";
	}

	// 시간표 제목 삽입
	@GetMapping("/inputTitle")
	public String inputTitle(@RequestParam(name = "name") String name, HttpSession session) {
		session.removeAttribute("credit");
		session.setAttribute("name", name);
		menuTimeTableList(session);

		return "inputClass";
	}

	// 여러 수업들이 추가된 시간표를 생성
	@GetMapping("/makeTimeTable")
	public String makeTimeTable(@RequestParam(value = "name") String name, HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		timeTableServiceImpl.insertName(name, member.getId());

		long maxNo = timeTableServiceImpl.selectRecentNo(); // 방금 제목을 삽입하면서 생성된 no를 fk로 사용하기 위해 select
		classList.forEach((classes) -> {
			classes.setUser_id(member.getId());
			classes.setTable_no(maxNo);
			classesServiceImpl.insertClass(classes);
		});
		classList.clear();

		session.removeAttribute("credit");
		session.removeAttribute("name");
		session.removeAttribute("classes");

		return "makeTimeTableComplete";
	}

//==============================================================================================================
	// 시간표 페이지
	@GetMapping("/timetable")
	public String timetable(@RequestParam(value = "id") long id, HttpSession session) {
		clearDateSession(session);
		clearDateList(mon);
		clearDateList(tue);
		clearDateList(wed);
		clearDateList(thu);
		clearDateList(fri);
		List<Classes> classes = classesServiceImpl.selectAllClasses(id);
		classes.forEach((item) -> {
			try {
				SessionClass sessionClass = new SessionClass();
				DateFormat dateFormat = new SimpleDateFormat("H:mm");
				classTime = dateFormat.parse(item.getTime());

				if (item.getCredit() == 3) {
					String str[] = item.getDate().split(",");
					for (int i = 0; i < str.length; i++) {
						if (str.length == 1) {
							DateFormat transFormat = new SimpleDateFormat("H:mm");
							String startTime = transFormat.format(classTime);
							classTime.setMinutes(classTime.getMinutes() + 165);
							endClassTime = classTime;
							String endTime = transFormat.format(endClassTime);

							sessionClass.setStartClassTime(startTime);
							sessionClass.setEndClassTime(endTime);
							sessionClass.setSubject(item.getSubject());


							if (str[i].equals("MON")) {
								mon.add(sessionClass);
							} 
							if (str[i].equals("TUE")) {
								tue.add(sessionClass);
							}
							if (str[i].equals("WED")) {
								wed.add(sessionClass);
							}
							if (str[i].equals("THU")) {
								thu.add(sessionClass);
							}
							if (str[i].equals("FRI")) {
								fri.add(sessionClass);
							}

						} else {
							DateFormat transFormat = new SimpleDateFormat("H:mm");

							String startTime = transFormat.format(classTime);
							classTime.setMinutes(classTime.getMinutes() + 75);
							endClassTime = classTime;
							String endTime = transFormat.format(endClassTime);

							sessionClass.setStartClassTime(startTime);
							sessionClass.setEndClassTime(endTime);
							sessionClass.setSubject(item.getSubject());

							if (str[i].equals("MON")) {
								mon.add(sessionClass);
							} else if (str[i].equals("TUE")) {
								tue.add(sessionClass);
							} else if (str[i].equals("WED")) {
								wed.add(sessionClass);
							} else if (str[i].equals("THU")) {
								thu.add(sessionClass);
							} else if (str[i].equals("FRI")) {
								fri.add(sessionClass);
							}
						}
					}

				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		});
		
		

		session.setAttribute("mon", mon);
		session.setAttribute("tue", tue);
		session.setAttribute("wed", wed);
		session.setAttribute("thu", thu);
		session.setAttribute("fri", fri);

		return "timetable";
	}

//==============================================================================================================
	@GetMapping("/deleteClass")
	public String deleteClass(@RequestParam(value = "subject") String subject, HttpSession session) {
		classList.forEach((item) -> {
			if (item.getSubject().equals(subject)) {
				deleteClass = item;
			}
		});
		classList.remove(deleteClass);
		session.removeAttribute("classes");
		session.setAttribute("classes", classList);

		return "classDeleteComplete";
	}

	@GetMapping("/deleteComplete")
	public String deleteComplete(HttpSession session) {
		clearTableSession(session);
		autoDrawTimeTable(session);
		return "inputClass";
	}

	@GetMapping("/test")
	public String test() {
		return "test";
	}

//===================================메소드 생성
	// 테이블의 session 비워주기
	public void clearTableSession(HttpSession session) {
		credit = 0;
		session.removeAttribute("credit");
		for (int i = 0; i < date.length; i++) {
			for (int j = 0; j < time.length; j++) {
				session.removeAttribute(date[i] + time[j]);
			}
		}
	}

	// 수업을 분석해서 session을 채워주는 파트
	public void autoDrawTimeTable(HttpSession session) {
		classList.forEach((item) -> {
			if (item.getDate().contains(",")) {
				String str[] = item.getDate().split(",");
				for (int i = 0; i < str.length; i++) {
					session.setAttribute(str[i] + item.getTime().replace(":", ""), item.getSubject());
				}
				credit += item.getCredit();
			} else {
				session.setAttribute(item.getDate() + item.getTime().replace(":", ""), item.getSubject());
				credit += item.getCredit();
			}
		});
		session.setAttribute("credit", credit);
	}

	// timetable 페이지에서 시간표를 보여주는 파트
	public void drawSelectedTimeTable(long id, HttpSession session) {
		List<Classes> classes = classesServiceImpl.selectAllClasses(id);
		Member member = (Member) session.getAttribute("member");
		classes.forEach((item) -> {
			if (item.getUser_id().equals(member.getId())) {
				if (item.getDate().contains(",")) {
					String str[] = item.getDate().split(",");
					for (int i = 0; i < str.length; i++) {
						session.setAttribute(str[i] + item.getTime().replace(":", ""), item.getSubject());
					}
					credit += item.getCredit();
				} else {
					session.setAttribute(item.getDate() + item.getTime().replace(":", ""), item.getSubject());
					credit += item.getCredit();
				}
			}
		});
		session.setAttribute("credit", credit);
	}

	// 메뉴에 timetable의 리스트를 가져오는 파트
	public void menuTimeTableList(HttpSession session) {
		List<TimeTable> list = new ArrayList<TimeTable>();
		// timetable리스트 가져오기
		List<TimeTable> timetableList = timeTableServiceImpl.selectAllTimeTable();
		Member nowMember = (Member) session.getAttribute("member");
		timetableList.forEach((item) -> {
			if (item.getUser_id().equals(nowMember.getId())) {
				list.add(item);
			}
		});
		session.setAttribute("timetableList", list);
	}
	//========================================================================
	public void clearDateSession(HttpSession session) {
		session.removeAttribute("mon");
		session.removeAttribute("tue");
		session.removeAttribute("wed");
		session.removeAttribute("thu");
		session.removeAttribute("fri");
	}
	
	public void clearDateList(List<SessionClass> sessionClass) {
		sessionClass.clear();
	}
}
