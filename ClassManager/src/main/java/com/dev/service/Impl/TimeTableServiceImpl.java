package com.dev.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.domain.TimeTable;
import com.dev.mapper.TimeTableMapper;
import com.dev.service.TimeTableService;

@Service
public class TimeTableServiceImpl implements TimeTableService {
	
	private TimeTableMapper timeTableMapper;
	
	public TimeTableServiceImpl(TimeTableMapper timeTableMapper) {
		this.timeTableMapper = timeTableMapper;
	}
	
	@Override
	public List<TimeTable> selectAllTimeTable() {
		List<TimeTable> timeTables = timeTableMapper.selectAllTimeTable(); 
		return timeTables;
	}
	
	@Override
	public void insertName(String name, String user_id) {
		timeTableMapper.insertName(name,user_id);
	}
	
	@Override
	public long selectRecentNo() {
		long maxNo = timeTableMapper.selectRecentNo();
		return maxNo;
	}
}
