package com.dev.service.Impl;

import org.springframework.stereotype.Service;

import com.dev.domain.TimeTable;
import com.dev.mapper.TimeTableMapper;
import com.dev.service.TimeTableService;

@Service
public class TimeTableServiceImpl implements TimeTableService {
	
	private TimeTableMapper timeTableMapper;
	
	public TimeTableServiceImpl(TimeTableMapper timeTableMapper) {
		this.timeTableMapper=timeTableMapper;
	}
	
	@Override
	public void insertTimeTable(TimeTable timeTable) {
		timeTableMapper.InsertNewTimetable(timeTable);
	}
	
	

}
