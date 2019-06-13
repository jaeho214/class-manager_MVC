package com.dev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dev.domain.Schedule;

public interface ScheduleMapper {
	
	// 아이디 기준 리스트 형태로 일정 가져오기
	@Select("Select sno, start_date, end_date, title, content, user_id from schedule where user_id = #{user_id} ")
	public List<Schedule> selectSchedule(String id);
	
	// 스케줄 추가
	@Insert("Insert into schedule (start_date, end_date, title, content, user_id) values (#{start_date},#{end_date},#{title},#{content}, #{user_id})")
	public void InsertNewSchedule(Schedule schedule);
	
	// 스케줄 삭제
	@Delete("Delete from schedule where sno = #{sno}")
	public void deleteSchedule(Long sno);

}
