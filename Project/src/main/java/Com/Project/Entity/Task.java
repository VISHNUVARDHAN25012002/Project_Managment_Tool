package Com.Project.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Task {
	
	@Id
	private int id;
	private String title;
	private String description;
	private String status;
	private String assignee;
	private Date created_Date;
	private Date Due_Date;
	private Date completed_Date;
	
	public  Task () {}
	
	public Task(int id, String title, String description, String status, String assignee, Date created_Date,
			Date due_Date, Date completed_Date) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.assignee = assignee;
		this.created_Date = created_Date;
		this.Due_Date = due_Date;
		this.completed_Date = completed_Date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public Date getCreated_Date() {
		return created_Date;
	}

	public void setCreated_Date(Date created_Date) {
		this.created_Date = created_Date;
	}

	public Date getDue_Date() {
		return Due_Date;
	}

	public void setDue_Date(Date due_Date) {
		Due_Date = due_Date;
	}

	public Date getCompleted_Date() {
		return completed_Date;
	}

	public void setCompleted_Date(Date completed_Date) {
		this.completed_Date = completed_Date;
	}

}
