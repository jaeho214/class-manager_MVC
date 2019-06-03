package com.dev.domain;

public class Assignment {
	 	private String user_id;
	    private String title;
	    private String content;
	    private String deadline;

	    public Assignment(String user_id,String title, String content, String deadline) {
	        this.title = title;
	        this.content = content;
	        this.deadline = deadline;
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

}
