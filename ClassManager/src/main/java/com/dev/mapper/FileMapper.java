package com.dev.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dev.domain.FileDTO;

public interface FileMapper {
	@Insert("Insert into file (filename, fileoriname, fileurl) values (#{filename}, #{fileoriName}, #{fileUrl})")
	public void insertFile(FileDTO fileDto);
	
	@Select("Select max(fno) from file")
	public long selectRecentNo();
	
	@Select("Select * from file where fno=#{fno}")
	public FileDTO selectFile(long fno);
	
	
	@Update("Update file set filename=#{filename}, fileoriname=#{fileoriName}, fileurl=#{fileUrl} where fno=#{fno}")
	public void updateFile(FileDTO fileDto);
	
	@Delete("Delete from file where fno=#{fno}")
	public void deleteFile(long fno);
}
