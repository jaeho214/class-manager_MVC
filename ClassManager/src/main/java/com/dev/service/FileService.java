package com.dev.service;

import java.util.List;

import com.dev.domain.FileVO;

public interface FileService {
	public void insertFile(FileVO fileVO);
	public long selectRecentNo();
	public void updateFile(FileVO fileVO);
	public void deleteFile(long fno);
	public FileVO selectFile(long fno);
}
