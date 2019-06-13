package com.dev.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dev.domain.Member;
import com.dev.domain.Schedule;
import com.dev.service.Impl.ScheduleServiceImpl;

@Controller
public class ScheduleController {

   ScheduleServiceImpl scheduleServiceImpl;

   public ScheduleController(ScheduleServiceImpl scheduleServiceImpl) {
      this.scheduleServiceImpl = scheduleServiceImpl;
   }

   // 스케줄 메인
   @GetMapping("/schedule")
   public String schedule(HttpSession session) {
      // 로그인된 아이디를 기준으로 스케줄을 가져옴
      Member mem = (Member) session.getAttribute("member");
      List<Schedule> schedulelist = scheduleServiceImpl.selectSchedule(mem.getId());
      session.setAttribute("schedulelist", schedulelist);
      return "schedule";
   }

   // 스케줄 등록
   @PostMapping("/schedule.do")
   public String schedule_do(Schedule schedule, HttpSession session) {
      Member mem = (Member) session.getAttribute("member");
      schedule.setUser_id(mem.getId());
      scheduleServiceImpl.InsertNewSchedule(schedule);
      List<Schedule> schedulelist = scheduleServiceImpl.selectSchedule(mem.getId());
      session.setAttribute("schedulelist", schedulelist);
      return "schedule";
   }
     // 스케줄 삭제
    @PostMapping("/scheduleDelete")
    public String scheduleDelete(Schedule schedule,HttpSession session) {
        scheduleServiceImpl.deleteSchedule(schedule.getSno()); 
        Member mem = (Member)session.getAttribute("member"); List<Schedule> schedulelist =
        scheduleServiceImpl.selectSchedule(mem.getId());
        session.setAttribute("schedulelist", schedulelist);
       return "schedule";
    }
    
}