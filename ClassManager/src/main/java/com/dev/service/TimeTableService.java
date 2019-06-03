package com.dev.service;

import java.util.List;

import com.dev.domain.TimeTable;

public interface TimeTableService {
	public List<TimeTable> selectAllTimeTable();
	public void insertName(String name,String user_id);
	public long selectRecentNo();
}
