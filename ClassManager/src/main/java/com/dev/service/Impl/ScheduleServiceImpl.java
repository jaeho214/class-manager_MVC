package com.dev.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.domain.Schedule;
import com.dev.mapper.ScheduleMapper;
import com.dev.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	
	ScheduleMapper scheduleMapper;
	
	public ScheduleServiceImpl(ScheduleMapper scheduleMapper) {
		this.scheduleMapper = scheduleMapper;
	}
	
	// 스케줄 추가
	@Override
	public void InsertNewSchedule(Schedule schedule) {
		scheduleMapper.InsertNewSchedule(schedule);
	}

	// 스케줄 삭제
	@Override
	public void deleteSchedule(Long sno) {
		scheduleMapper.deleteSchedule(sno);
	}
	
	// 아이디 기준, 스케줄 리스트 형태로 검색 후 반환
	@Override
	public List<Schedule> selectSchedule(String id) {
		List<Schedule> scheduleList = scheduleMapper.selectSchedule(id);
		return scheduleList;
	}

}
