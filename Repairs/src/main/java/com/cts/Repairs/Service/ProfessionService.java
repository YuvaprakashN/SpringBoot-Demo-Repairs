package com.cts.Repairs.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.Repairs.Dao.ProfessionRepo;
import com.cts.Repairs.Entity.Profession;

@Service
public class ProfessionService {

	@Autowired
	ProfessionRepo professionRepo;
	
	/**
	 * This method used to return List of all Profession instance
	 * @return List of all Profession
	 */
	public List<Profession> findAll() {
		return professionRepo.findAll();
	}

	/**
	 * @param id It find Profession instance using id
	 * @return profession instance
	 */
	public Profession findById(int id) {
		return professionRepo.findById(id).get();
	}

}
