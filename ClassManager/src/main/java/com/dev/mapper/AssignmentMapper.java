package com.dev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dev.domain.Assignment;

public interface AssignmentMapper {
		// 아이디 받아서 과제 등록했던거 나타내주기
		@Select("Select a.ano, a.title, a.content, a.deadline, a.fno, f.fileoriname from assignment a Left Join file f ON a.fno=f.fno where user_id = #{user_id} ")
		public List<Assignment> selectAssignment(String id);
		
		@Select("SELECT title, content, deadline, fno FROM assignment WHERE ano = #{ano}")
		public Assignment selectFno(long ano);
		
		// 과제 추가 (파일포함)
	    @Insert("Insert into assignment (title,content,deadline,user_id,fno) values(#{title},#{content},#{deadline},#{user_id},#{fno})")
	    public void InsertNewAssignementIncludeFile(Assignment assignment);
	    
	    // 과제 추가 (파일 미포함)
	    @Insert("Insert into assignment (title,content,deadline,user_id) values(#{title},#{content},#{deadline},#{user_id})")
	    public void InsertNewAssignement(Assignment assignment);
	    


	    // 과제 업데이트
	    @Update("UPDATE assignment SET title = #{title}, content = #{content}, deadline = #{deadline}, fno=#{fno} where ano = #{ano}")
	    public void assignmentUpdate(Assignment assignment);
	    
	    // 과제 삭제
	    @Delete("Delete from assignment where ano = #{ano}")
	    public void deleteAssignment(Long ano);
	    
	    // 업데이트할 게시글(게시글 번호 기준) 찾기
	    @Select("Select a.ano, a.title, a.content, a.deadline, f.fno, f.fileoriname from assignment a Left Join file f ON a.fno=f.fno where ano = #{ano}")
	    public Assignment selectAnoAssignment(Long ano);
}
