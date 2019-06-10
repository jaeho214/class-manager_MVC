package com.dev.domain;

public class Assignment {
	private Long ano;
 	private String user_id;
    private String title;
    private String content;
    private String deadline;
    private Long fno;
    private String fileoriname;
 
    public Assignment(Long ano, String title, String content, String deadline,long fno, String fileoriname) {
    	this.ano = ano;
    	this.title = title;
        this.content = content;
        this.deadline = deadline;
        this.fno = fno;
        this.fileoriname = fileoriname;
    }
    
//    public Assignment(Long ano, String title, String content, String deadline, long fno) {
//    	this.ano = ano;
//    	this.title = title;
//    	this.content = content;
//    	this.deadline = deadline;
//    	
//    }
    
    public Assignment() {
    	
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

	public long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	public Long getFno() {
		return fno;
	}

	public void setFno(long fno) {
		this.fno = fno;
	}

	public String getFileoriname() {
		return fileoriname;
	}

	public void setFileoriname(String fileoriname) {
		this.fileoriname = fileoriname;
	}
	
	


}
