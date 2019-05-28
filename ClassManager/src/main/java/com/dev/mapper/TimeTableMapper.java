package com.dev.mapper;

import org.apache.ibatis.annotations.Insert;

import com.dev.domain.TimeTable;

public interface TimeTableMapper {
	  // 시간표추가
	   @Insert("INSERT INTO timetable (number,subject,time,professor,room,credit,kinds,member)VALUES (#{number},#{subject},#{time},#{professor},#{room},#{credit},#{kinds},#{member})")
	   public void InsertNewTimetable(TimeTable timetable);

}
