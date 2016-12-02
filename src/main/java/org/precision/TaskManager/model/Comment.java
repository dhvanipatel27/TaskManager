package org.precision.TaskManager.model;

import java.util.Date;

public class Comment {
	
	private int comment_id;
	private String comment_detail;
	private Date created_date;
	private Date updated_date;
	
	public Comment () {
		
	}

	public Comment(int comment_id, String comment_detail) {
		super();
		this.comment_id = comment_id;
		this.comment_detail = comment_detail;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public String getComment_detail() {
		return comment_detail;
	}

	public void setComment_detail(String comment_detail) {
		this.comment_detail = comment_detail;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}
	
	
}
