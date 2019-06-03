package com.dev.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.domain.Classes;
import com.dev.domain.Member;
import com.dev.domain.TimeTable;
import com.dev.service.Impl.ClassesServiceImpl;
import com.dev.service.Impl.TimeTableServiceImpl;

@Controller
public class TimeTableController {	

	private ClassesServiceImpl classesServiceImpl;
	private TimeTableServiceImpl timeTableServiceImpl;
	
	private String date[] = {"MON","TUE","WED","THR","FRI"};
	private String time[] = {"0900","1030","1200","1330","1500","1630"};
	
	
	public TimeTableController(ClassesServiceImpl classesServiceImpl, TimeTableServiceImpl timeTableServiceImpl) {
		this.classesServiceImpl = classesServiceImpl;
		this.timeTableServiceImpl = timeTableServiceImpl;
	}
	
	//시간표 등록 페이지로 이동
	@GetMapping("/inputClass")
	public String inputClass(HttpSession session) {
		List<TimeTable> list = new ArrayList<TimeTable>();
		//timetable리스트 가져오기
		List<TimeTable> timetableList = timeTableServiceImpl.selectAllTimeTable();
		Member nowMember = (Member) session.getAttribute("member");
		timetableList.forEach((item)->{
			if(item.getUser_id().equals(nowMember.getId())) {
				list.add(item);
			}
		});
		session.setAttribute("timetableList", list);
		return "inputClass";
	}
	
	//시간표에 수업 추가
	@PostMapping("/inputClass.do")
	public String titmetableComplete(Classes classes, HttpSession session) {
		long maxNo = timeTableServiceImpl.selectRecentNo(); //방금 제목을 삽입하면서 생성된 no를 fk로 사용하기 위해 select
		Member member = (Member) session.getAttribute("member");
		classes.setUser_id(member.getId());
		classes.setTable_no(maxNo);
		classesServiceImpl.insertClass(classes);
		return "classInputComplete";
	}
	
	//수업을 하나 입력을 완료
	@GetMapping("/inputComplete")
	public String inputComplete(HttpSession session) {
		long maxNo = timeTableServiceImpl.selectRecentNo();
		List<Classes> classes = classesServiceImpl.selectAllClasses(maxNo);
		session.setAttribute("classes", classes);
		return "inputClass";
	}
	
	//시간표 제목 삽입
	@GetMapping("/inputTitle")
	public String inputTitle(@RequestParam(name="name") String name, HttpSession session) {
		Member member = (Member)session.getAttribute("member");
		timeTableServiceImpl.insertName(name,member.getId());
		session.setAttribute("name", name);
		return "inputClass";
	}
	
	//여러 수업들이 추가된 시간표를 생성
	@GetMapping("/makeTimeTable")
	public String makeTimeTable(HttpSession session) {
		session.removeAttribute("name");
		session.removeAttribute("classes");

		List<TimeTable> list = new ArrayList<TimeTable>();
		//timetable리스트 가져오기
		List<TimeTable> timetableList = timeTableServiceImpl.selectAllTimeTable();
		Member nowMember = (Member) session.getAttribute("member");
		timetableList.forEach((item)->{
			if(item.getUser_id().equals(nowMember.getId())) {
				list.add(item);
			}
		});
		session.setAttribute("timetableList", list);
		return "main";
	}
	
	//시간표 페이지
	@GetMapping("/timetable")
	public String timetable(@RequestParam(value="id") long id, HttpSession session) {
		//session 비워주기
		for(int i=0;i<date.length;i++) {
			for(int j=0;j<time.length;j++) {
				session.removeAttribute(date[i]+time[j]);
			}
		}
		
		List<Classes> classes = classesServiceImpl.selectAllClasses(id);
		Member member = (Member)session.getAttribute("member");
		classes.forEach((item)->{
			if(item.getUser_id().equals(member.getId())) {
				session.setAttribute(item.getDate()+item.getTime().replace(":",""), item.getSubject());
			}
		});
		return "timetable";
	}
	
	
	
	@GetMapping("/updateClass")
	public String updateClass() {
		System.out.println("오나?");
		return "inputClass";
	}
	
	@GetMapping("/deleteClass")
	public String deleteClass() {
		return "inputClass";
	}
	
	@GetMapping("/date")
	public String manageDate() {
		return "date";
	}


}
