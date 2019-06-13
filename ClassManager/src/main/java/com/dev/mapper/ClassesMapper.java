package com.dev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dev.domain.Classes;

public interface ClassesMapper {
	
	@Select("Select number, subject, startTime, endTime, date, professor, room, credit, kinds, user_id, table_no from classes where table_no = #{no}")
	public List<Classes> selectAllClasses(long no);
	
	//시간표에서 과목을 눌렀을 때 그 과목에 대한 정보를 출력해주기 위한 select문
	@Select("Select number, subject, startTime, endTime, date, professor, room, credit, kinds, user_id, table_no "
			+ "from classes "
			+ "where table_no=#{table_no} and subject=#{subject}")
	public Classes selectSubjectInfo(long table_no, String subject);

	@Insert("Insert into classes (number,subject,startTime,endTime,date,professor,room,credit,kinds,user_id,table_no) "
			+ "values(#{number},#{subject},#{startTime},#{endTime},#{date},#{professor},#{room},#{credit},#{kinds},#{user_id},#{table_no})")
	public void insertClass(Classes classes);
	

	
}
