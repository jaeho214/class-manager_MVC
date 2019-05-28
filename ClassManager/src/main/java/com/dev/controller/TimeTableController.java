package com.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimeTableController {

	@GetMapping("/timetable")
	public String makeTimeTable() {
		return "timetable";
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
