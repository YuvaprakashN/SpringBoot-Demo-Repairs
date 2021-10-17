package com.cts.Repairs.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Profession {

	@Id
	@GeneratedValue
	private Integer id;

	@NotEmpty(message = "Profession Should Not be Empty")
	private String professionName;

	@OneToMany(mappedBy = "profession")
	private List<Worker> workers;

	// ================================= Constructors===========================
	public Profession() {
		super();
	}

	public Profession(Integer id, String cityName) {
		super();
		this.id = id;
		this.professionName = cityName;
	}

	// ========================== Getters and Setters =========================

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProfessionName() {
		return professionName;
	}

	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}

	public List<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}

	public void addWorker(Worker worker) {
		this.workers.add(worker);
	}


	
	//============================  toString()  ==========================
	@Override
	public String toString() {
		return "Profession [id=" + id + ", professionName=" + professionName + "]";
	}


	
	
}
