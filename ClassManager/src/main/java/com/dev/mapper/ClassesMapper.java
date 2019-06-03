package com.dev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dev.domain.Classes;

public interface ClassesMapper {
	
	@Select("Select number, subject, time, date, professor, room, credit, kinds, user_id, table_no from classes where table_no = #{no}")
	public List<Classes> selectAllClasses(long no);
	
	@Insert("Insert into classes (number,subject,time,date,professor,room,credit,kinds,user_id,table_no) "
			+ "values(#{number},#{subject},#{time},#{date},#{professor},#{room},#{credit},#{kinds},#{user_id},#{table_no})")
	public void insertClass(Classes classes);
	
	@Update("Update set number=#{number}, subject=#{subject}, time=#{time}, date=#{date}, professor=#{professor}, room=#{room}, credit=#{credit}"
			+ "kinds=#{kinds}")
	public void updateClass(Classes newClass);
	
	@Delete("Delete from Classes where tno=#{tno}")
	public void deleteClass(long tno);
	
}
