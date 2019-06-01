package com.dev.controller;

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
	
	public TimeTableController(ClassesServiceImpl classesServiceImpl, TimeTableServiceImpl timeTableServiceImpl) {
		this.classesServiceImpl = classesServiceImpl;
		this.timeTableServiceImpl = timeTableServiceImpl;
	}
	
	//시간표 등록 페이지로 이동
	@GetMapping("/inputClass")
	public String inputClass() {
		return "inputClass";
	}
	
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
		timeTableServiceImpl.insertName(name);
		session.setAttribute("name", name);
		return "inputClass";
	}
	
	//시간표에 수업 추가
	@PostMapping("/timetable.do")
	public String titmetableComplete(Classes classes, HttpSession session) {
		long maxNo = timeTableServiceImpl.selectRecentNo(); //방금 제목을 삽입하면서 생성된 no를 fk로 사용하기 위해 select
		Member member = (Member) session.getAttribute("member");
		classes.setUser_id(member.getId());
		classes.setTable_no(maxNo);
		classesServiceImpl.insertClass(classes);
		return "classInputComplete";
	}
	
	@GetMapping("/makeTimeTable")
	public String makeTimeTable(HttpSession session) {
		session.removeAttribute("name");
		session.removeAttribute("classes");
		return "main";
	}
	
	@GetMapping("/date")
	public String manageDate() {
		return "date";
	}
	
	@GetMapping("/assignment")
	public String manageAssign() {
		return "assignment";
	}
	
}
