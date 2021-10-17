package com.cts.Repairs.Entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;

@Entity
public class Booking {

	@Id
	@GeneratedValue
	private Integer id;
	
@ManyToOne
private User user;
	
	@ManyToOne
	private Worker worker;

	@Future(message = "please enter future date")
	private Date bookedDate;

	@NotEmpty(message = "Please Enter he job summary")
	private String description;

	private String status;

	
	//================  Constructor   =========================
	
	
	




	public Booking() {
		super();
	}






public Booking(Integer id, User user, Worker worker, @Future Date bookedDate, @NotEmpty String description,String status) {
		super();
		this.id = id;
		this.user = user;
		this.worker = worker;
		this.bookedDate = bookedDate;
		this.description = description;
		this.status=status;
	}






//=========================  Getters and Setters ===========================
	


	public String getDescription() {
	return description;
}






public void setDescription(String description) {
	this.description = description;
}






	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public Worker getWorker() {
		return worker;
	}




	public void setWorker(Worker worker) {
		this.worker = worker;
	}








	public Date getBookedDate() {
		return bookedDate;
	}






	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}






	public String getStatus() {
		return status;
	}






	public void setStatus(String status) {
		this.status = status;
	}






	@Override
	public String toString() {
		return "Booking [id=" + id + ", user=" + user + ", worker=" + worker + ", bookedDate=" + bookedDate
				+ ", description=" + description + ", status=" + status + "]";
	}






	//=============================  toString()==================





}
