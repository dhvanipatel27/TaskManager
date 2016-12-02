package org.precision.TaskManager.model;


import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Task {

	private int tId;
	private String priority;
	private String type;
	private String processing_by;
	private String employee_name;
	private String task_subject;
	private String requested_by;
	private String task_owner;
	private Date requested_recieved_date;
	private Date internal_due_date;
	private Date uscis_due_date;
	private Date uscis_delivery_date;
	private Date uscis_decision_date;
	private String status;
	private String project_name;
	private String pending_documents;
	private String active;
	private Date created_date = new Date();
	private Date updated_date = new Date();
	
	private String comment_detail;
	private List<String> allComments;

		
	public Task() {
	
	}

		
	public Task(int tId, String priority, String type, String processing_by, String employee_name, String task_subject,
			String requested_by, String task_owner, Date requested_recieved_date, Date internal_due_date,
			Date uscis_due_date, Date uscis_delivery_date, Date uscis_decision_date, String status, String project_name,
			String pending_documents, String active, Date created_date, Date updated_date, String comment_detail,
			List<String> allComments) {
		super();
		this.tId = tId;
		this.priority = priority;
		this.type = type;
		this.processing_by = processing_by;
		this.employee_name = employee_name;
		this.task_subject = task_subject;
		this.requested_by = requested_by;
		this.task_owner = task_owner;
		this.requested_recieved_date = requested_recieved_date;
		this.internal_due_date = internal_due_date;
		this.uscis_due_date = uscis_due_date;
		this.uscis_delivery_date = uscis_delivery_date;
		this.uscis_decision_date = uscis_decision_date;
		this.status = status;
		this.project_name = project_name;
		this.pending_documents = pending_documents;
		this.active = active;
		this.created_date = created_date;
		this.updated_date = updated_date;
		this.comment_detail = comment_detail;
		this.allComments = allComments;
	}

	@Override
	public String toString() {
		return "Task [tId=" + tId + ", priority=" + priority + ", type=" + type + ", processing_by=" + processing_by
				+ ", employee_name=" + employee_name + ", task_subject=" + task_subject + ", requested_by="
				+ requested_by + ", task_owner=" + task_owner + ", requested_recieved_date=" + requested_recieved_date
				+ ", internal_due_date=" + internal_due_date + ", uscis_due_date=" + uscis_due_date
				+ ", uscis_delivery_date=" + uscis_delivery_date + ", uscis_decision_date=" + uscis_decision_date
				+ ", status=" + status + ", project_name=" + project_name + ", pending_documents=" + pending_documents
				+ ", active=" + active + ", created_date=" + created_date + ", updated_date=" + updated_date
				+ ", comment_detail=" + comment_detail + ", allComments=" + allComments + "]";
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

	public Date getUscis_due_date() {
		return uscis_due_date;
	}


	public void setUscis_due_date(Date uscis_due_date) {
		this.uscis_due_date = uscis_due_date;
	}


	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProcessing_by() {
		return processing_by;
	}

	public void setProcessing_by(String processing_by) {
		this.processing_by = processing_by;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getTask_subject() {
		return task_subject;
	}

	public void setTask_subject(String task_subject) {
		this.task_subject = task_subject;
	}

	public String getRequested_by() {
		return requested_by;
	}

	public void setRequested_by(String requested_by) {
		this.requested_by = requested_by;
	}

	public String getTask_owner() {
		return task_owner;
	}

	public void setTask_owner(String task_owner) {
		this.task_owner = task_owner;
	}

	public Date getRequested_recieved_date() {
		return requested_recieved_date;
	}

	public void setRequested_recieved_date(Date requested_recieved_date) {
		this.requested_recieved_date = requested_recieved_date;
	}

	public Date getInternal_due_date() {
		return internal_due_date;
	}

	public void setInternal_due_date(Date internal_due_date) {
		this.internal_due_date = internal_due_date;
	}

	public Date getUscis_delivery_date() {
		return uscis_delivery_date;
	}

	public void setUscis_delivery_date(Date uscis_delivery_date) {
		this.uscis_delivery_date = uscis_delivery_date;
	}

	public Date getUscis_decision_date() {
		return uscis_decision_date;
	}

	public void setUscis_decision_date(Date uscis_decision_date) {
		this.uscis_decision_date = uscis_decision_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getPending_documents() {
		return pending_documents;
	}

	public void setPending_documents(String pending_documents) {
		this.pending_documents = pending_documents;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getComment_detail() {
		return comment_detail;
	}

	public void setComment_detail(String comment_detail) {
		this.comment_detail = comment_detail;
	}

	public List<String> getAllComments() {
		return allComments;
	}

	public void setAllComments(List<String> allComments) {
		this.allComments = allComments;
	}
	 		
}
