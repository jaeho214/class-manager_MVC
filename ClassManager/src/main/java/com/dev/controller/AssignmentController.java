package com.dev.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dev.domain.Assignment;
import com.dev.domain.Member;
import com.dev.domain.TimeTable;
import com.dev.service.Impl.AssignmentServiceImpl;
import com.dev.service.Impl.TimeTableServiceImpl;

@Controller
public class AssignmentController {
	private AssignmentServiceImpl assignmentService;
	private TimeTableServiceImpl timeTableServiceImpl;

    public AssignmentController(AssignmentServiceImpl assignmentService,TimeTableServiceImpl timeTableServiceImpl){
        this.assignmentService = assignmentService;
        this.timeTableServiceImpl = timeTableServiceImpl;
    }

    @GetMapping("/assignment")
    public String assignment(){
        return "assignment";
    }

    @PostMapping("/assignment.do")
    public String assignment_do(Assignment assignment,HttpSession session){
        Member member = (Member)session.getAttribute("member");
        System.out.println(member.getId());
        assignment.setUser_id(member.getId());
        assignmentService.InsertNewAssignment(assignment);
        
//        List<TimeTable> list = new ArrayList<TimeTable>();
//		//timetable리스트 가져오기
//		List<TimeTable> timetableList = timeTableServiceImpl.selectAllTimeTable();
//		Member nowMember = (Member) session.getAttribute("member");
//		timetableList.forEach((item)->{
//			if(item.getUser_id().equals(nowMember.getId())) {
//				list.add(item);
//			}
//		});
//		
//		session.setAttribute("timetableList", list);
        return "assignment";
    }
}
