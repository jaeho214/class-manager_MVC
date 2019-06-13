package com.dev.service;

import com.dev.domain.FileDTO;

public interface FileService {
	public long selectRecentNo();
	public FileDTO selectFile(long fno);
	public void insertFile(FileDTO fileDto);
	public void updateFile(FileDTO fileDto);
	public void deleteFile(long fno);
}
