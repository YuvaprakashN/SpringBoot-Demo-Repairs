package com.cts.Repairs.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class City {

	@Id
	@GeneratedValue
	private Integer id;

	private String cityName;

	@OneToMany(mappedBy = "city")
	private List<User> users;
	
	

	//=================================  Constructors===========================
	public City() {
		super();
	}

	public City(Integer id, String cityName) {
		super();
		this.id = id;
		this.cityName = cityName;
	}

	//==========================  Getters and Setters  =========================
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}
	
	
	
	//=============================  toString()  ======================================

	@Override
	public String toString() {
		return "City [id=" + id + ", cityName=" + cityName + "]";
	}
	
	

	
	
}
