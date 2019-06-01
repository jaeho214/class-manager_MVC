package com.dev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;



import com.dev.domain.TimeTable;

public interface TimeTableMapper {

	@Select("Select * from timetable")
	public List<TimeTable> selectAllTimeTable();
	
	@Select("Select max(tno) from timetable")
	public long selectRecentNo();
	
	@Insert("Insert into timetable (name) values (#{name})")
	public void insertName(String name);

}
