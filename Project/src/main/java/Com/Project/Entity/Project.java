package Com.Project.Entity;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Project {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String projectName;
	private Date start_Date;
	private Date end_Date;
	private String priority;
	private String budget;
	private Date created_Date;
	private Date modified_Date;
	private int client_Id;

public Project () {
	
}

public Project(int id, String projectName, Date start_Date, Date end_Date, String priority, String budget,
		Date created_Date, Date modified_Date, int clientId) {
	super();
	this.id = id;
	this.projectName = projectName;
	this.start_Date = start_Date;
	this.end_Date = end_Date;
	this.priority = priority;
	this.budget = budget;
	this.created_Date = created_Date;
	this.modified_Date = modified_Date;
	this.client_Id = clientId;
}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getProjectName() {
			return projectName;
		}

		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}

		public Date getStart_Date() {
			return start_Date;
		}

		public void setStart_Date(Date start_Date) {
			this.start_Date = start_Date;
		}

		public Date getEnd_Date() {
			return end_Date;
		}

		public void setEnd_Date(Date end_Date) {
			this.end_Date = end_Date;
		}

		public String getPriority() {
			return priority;
		}

		public void setPriority(String priority) {
			this.priority = priority;
		}

		public String getBudget() {
			return budget;
		}

		public void setBudget(String budget) {
			this.budget = budget;
		}

		public Date getCreated_Date() {
			return created_Date;
		}

		public void setCreated_Date(Date created_Date) {
			this.created_Date = created_Date;
		}

		public Date getModified_Date() {
			return modified_Date;
		}

		public void setModified_Date(Date modified_Date) {
			this.modified_Date = modified_Date;
		}

		public int getClientId() {
			return client_Id;
		}

		public void setClientId(int clientId) {
			this.client_Id = clientId;
		}
		
	}


