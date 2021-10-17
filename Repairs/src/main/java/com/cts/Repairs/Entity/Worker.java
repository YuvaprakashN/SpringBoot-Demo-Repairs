package com.cts.Repairs.Entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Worker {

	
	@Id
	@GeneratedValue
	private Integer id;

	@Size(min = 3, max = 30, message = "Name size should be 3 - 30 chracters")
	private String name;

	@Size(min = 8, max = 30, message = "password size should be 8 - 30 chracters")
	@Pattern(regexp = "((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6,16})",message = "Password should contain atleast one digit,one capital letter,one small letter,one special character")
	private String password;

	@Size(min = 8, max = 30, message = "password size should be 8 - 30 chracters")
	@Pattern(regexp = "((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6,16})",message = "Password should contain atleast one digit,one capital letter,one small letter,one special character")
	private String confirmPassword;
	
	@NotEmpty(message = "Please Enter the Address Field")
	private String address;
	
	@NotEmpty(message = "Enter Contact Number")
	@Size(min = 10 , max = 10, message = "Contact Number should contain exactly 10 digits")
	@Pattern(regexp = "^\\d{10}$",message = "Only Numbers")
	private String phone;

	
	@NotEmpty(message = "Please Enter the Email Field")
	private String email;
	
	private Integer rating;
	

	@Positive(message = "Should contain only Numbers")
	
	private Integer costPerHour;
	
	@CreationTimestamp
	private Date createdDate;
	
	@UpdateTimestamp
	private Date updatedDate;
	@ManyToOne
	private City city;
	
	@ManyToOne
	private Profession profession;

	@OneToMany(mappedBy = "worker",fetch = FetchType.EAGER)
	private List<Booking> bookings=new ArrayList<>();
	
	//===========================================  Worker Constructos  ==================================================
	
	public Worker() {
		super();
	}









	public Worker(Integer id, @Size(min = 3, max = 30, message = "Name size should be 3 - 30 chracters") String name,
			@Size(min = 8, max = 30, message = "password size should be 8 - 30 chracters") String password,
			@Size(min = 8, max = 30, message = "password size should be 8 - 30 chracters") String confirmPassword,
			@NotEmpty(message = "Please Enter the Address Field") String address,
			@NotEmpty(message = "Enter Contact Number") @Size(min = 10, max = 10, message = "Contact Number should contain exactly 10 digits") @Pattern(regexp = "^\\d{10}$", message = "Only Numbers") String phone,
			@NotEmpty(message = "Please Enter the Email Field") String email, Integer rating,
			@NotEmpty(message = "Please Enter the Cost/Hour") @Pattern(regexp = "^\\d{}$", message = "Only Numbers Allowed") Integer costPerHour,
			Date createdDate, Date updatedDate, City city, Profession profession) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.rating = rating;
		this.costPerHour = costPerHour;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.city = city;
		this.profession = profession;
	}









	//======================================  Getters and Setters  ===================

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Booking> getBookings() {
		return bookings;
	}









	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public void addBooking(Booking booking) {
		this.bookings.add(booking);
	}









	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public Integer getRating() {
		return rating;
	}





	public void setRating(Integer rating) {
		this.rating = rating;
	}





	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Integer getCostPerHour() {
		return costPerHour;
	}



	public void setCostPerHour(Integer costPerHour) {
		this.costPerHour = costPerHour;
	}



	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Date getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	public City getCity() {
		return city;
	}


	public void setCity(City city) {
		this.city = city;
	}

	
	
	//================================  toString()   ============================================

	public Profession getProfession() {
		return profession;
	}


	public void setProfession(Profession profession) {
		this.profession = profession;
	}





	@Override
	public String toString() {
		return "Worker [id=" + id + ", name=" + name + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", address=" + address + ", phone=" + phone + ", email=" + email + ", costPerHour=" + costPerHour
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", city=" + city + ", profession="
				+ profession + "]";
	}



	
	
	
	
	
	
	
	
}
