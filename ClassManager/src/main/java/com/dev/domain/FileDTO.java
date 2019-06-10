package com.dev.domain;

public class FileDTO {
	private long fno;
    private String filename;     //저장할 파일
    private String fileoriName;  //실제 파일
    private String fileUrl;
    
    
    public long getFno() {
        return fno;
    }
 
    public void setFno(long fno) {
        this.fno = fno;
    }
 
 
    public String getFilename() {
        return filename;
    }
 
    public void setFilename(String fileName) {
        this.filename = fileName;
    }
    
 
    public String getFileoriName() {
        return fileoriName;
    }
 
    public void setFileoriName(String fileoriName) {
        this.fileoriName = fileoriName;
    }
 
    public String getFileUrl() {
        return fileUrl;
    }
 
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

}
