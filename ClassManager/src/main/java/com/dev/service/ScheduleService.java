package com.dev.service;

import java.util.List;

import com.dev.domain.Schedule;

public interface ScheduleService {
	
	// 스케줄 가져오기
	public List<Schedule> selectSchedule(String id);
	// 스케줄 추가
	public void InsertNewSchedule(Schedule schedule);
	// 스케줄 삭제
	public void deleteSchedule(Long sno);

}
