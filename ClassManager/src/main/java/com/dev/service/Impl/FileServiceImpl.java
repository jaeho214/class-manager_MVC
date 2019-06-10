package com.dev.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.domain.FileDTO;
import com.dev.mapper.FileMapper;
import com.dev.service.FileService;

@Service
public class FileServiceImpl implements FileService {
	
	private FileMapper fileMapper;
	
	public FileServiceImpl(FileMapper fileMapper) {
		this.fileMapper = fileMapper;
	}
	
	
	@Override
	public void insertFile(FileDTO fileVO) {
		fileMapper.insertFile(fileVO);
	}
	
	@Override
	public long selectRecentNo() {
		long fno = fileMapper.selectRecentNo();
		return fno;
	}
	
	@Override
	public void updateFile(FileDTO fileVO) {
		fileMapper.updateFile(fileVO);
	}
	
	@Override
	public void deleteFile(long fno) {
		fileMapper.deleteFile(fno);
		
	}
	
	@Override
	public FileDTO selectFile(long fno) {
		FileDTO fileVO = fileMapper.selectFile(fno);
		return fileVO;
	}
}
