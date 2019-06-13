package com.dev.domain;

public class Schedule {
	private Long sno;
	private String start_date;
	private String end_date;
	private String title;
	private String content;
	private String user_id;
	
	public Schedule(Long sno, String start_date, String end_date, String title, String content, String user_id) {
		this.start_date = start_date;
		this.end_date = end_date;
		this.title = title;
		this.content = content;
		this.user_id = user_id;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Long getSno() {
		return sno;
	}

	public void setSno(Long sno) {
		this.sno = sno;
	}
	

}
