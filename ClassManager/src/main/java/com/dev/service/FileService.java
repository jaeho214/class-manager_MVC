package com.dev.service;

import java.util.List;

import com.dev.domain.FileDTO;

public interface FileService {
	public void insertFile(FileDTO fileVO);
	public long selectRecentNo();
	public void updateFile(FileDTO fileVO);
	public void deleteFile(long fno);
	public FileDTO selectFile(long fno);
}
