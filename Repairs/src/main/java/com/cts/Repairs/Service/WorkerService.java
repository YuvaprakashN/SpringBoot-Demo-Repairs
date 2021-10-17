package com.cts.Repairs.Service;

import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.cts.Repairs.CustomValidation.CustomWorkerValidation;
import com.cts.Repairs.Dao.WorkerRepositary;
import com.cts.Repairs.Entity.City;
import com.cts.Repairs.Entity.Profession;
import com.cts.Repairs.Entity.Worker;

@Service
public class WorkerService {

	@Autowired
	WorkerRepositary workerRepositary;

	@Autowired
	CustomWorkerValidation customWorkerValidation;

	/**
	 * @param workerlog Worker instance
	 * @param br        BindingResult holds the result of a validation
	 */
	public void validateWorkerRegistration(Worker workerlog, BindingResult br) {
		customWorkerValidation.validateRegistrationDetails(workerlog, br);

	}

	/**
	 * @return List of all Worker instance
	 */
	public List<Worker> findAll() {
		return workerRepositary.findAll();
	}

	/**
	 * @param workerlog Worker instance
	 * @return Worker instance
	 */
	public Worker save(Worker workerlog) {
		return workerRepositary.save(workerlog);
	}

	/**
	 * @return List of worker instance
	 */
	public List<Worker> findByOrderByRatingDesc() {
		return workerRepositary.findByOrderByRatingDesc();
	}

	/**
	 * @param location Location name
	 * @return List of workers instance
	 */
	public List<Worker> findByCityOrderByRatingDesc(City location) {
		return workerRepositary.findByCityOrderByRatingDesc(location);
	}

	/**
	 * @param professionId profession instance
	 * @return List of workers instance
	 */
	public List<Worker> findByProfessionOrderByRatingDesc(Profession professionId) {
		return workerRepositary.findByProfessionOrderByRatingDesc(professionId);
	}

	/**
	 * @param profession Profession instance
	 * @param city       City instance
	 * @return List of workers instance
	 */
	public List<Worker> findByProfessionAndCityOrderByRatingDesc(Profession profession, City city) {
		return workerRepositary.findByProfessionAndCityOrderByRatingDesc(profession, city);
	}

	/**
	 * @param worker Worker instance
	 * @param br     BindingResult holds the result of a validation
	 */
	public void WorkerLoginValidation(Worker worker, BindingResult br) {
		customWorkerValidation.WorkerLoginValidation(worker, br);

	}

	/**
	 * @param email It has Email id
	 * @return Worker instance
	 */
	public Worker findByEmail(String email) {
		return workerRepositary.findByEmail(email);
	}
	
	
	public Worker findByEmailAndPassword(String email,String password)
	{
		return workerRepositary.findByEmailAndPassword(email,password);
	}
	

	/**
	 * @param cityName City instance
	 * @param cost     cost integer
	 * @return List of Workers instance
	 */
	public List<Worker> findByCityAndCostPerHourOrderByRatingAsc(City cityName, int cost) {
		return workerRepositary.findByCityAndCostPerHourOrderByRatingAsc(cityName, cost);
	}

	/**
	 * @param id       Profession instance
	 * @param cityName City instance
	 * @param cost     cost integer
	 * @return List of Workers instance
	 */
	public List<Worker> findByProfessionAndCityAndCostPerHourOrderByRatingAsc(Profession id, City cityName, int cost) {
		return workerRepositary.findByProfessionAndCityAndCostPerHourOrderByRatingAsc(id, cityName, cost);
	}

	/**
	 * @param id   Profession instance
	 * @param cost cost integer
	 * @return List of Workers instance
	 */
	public List<Worker> findByProfessionAndCostPerHourOrderByRatingAsc(Profession id, int cost) {
		return workerRepositary.findByProfessionAndCostPerHourOrderByRatingAsc(id, cost);
	}

	/**
	 * @param workeredit Worker instance
	 * @param br         BindingResult holds the result of a validation
	 */
	public void validateWorkerEdit(Worker workeredit, BindingResult br) {
		customWorkerValidation.validateWorkerEdit(workeredit, br);
	}

	/**
	 * @param min minimum cost
	 * @param max maximum cost
	 * @return List of Workers instance
	 */
	public List<Worker> findByCostPerHourBetweenOrderByRatingDesc(int min, int max) {
		return workerRepositary.findByCostPerHourBetweenOrderByRatingDesc(min, max);
	}

	/**
	 * @param profession Profession instance
	 * @param min        minimum cost
	 * @param max        maximum cost
	 * @return List of Workers instance
	 */
	public List<Worker> findByProfessionAndCostPerHourBetweenOrderByRatingDesc(Profession profession, int min,
			int max) {
		return workerRepositary.findByProfessionAndCostPerHourBetweenOrderByRatingDesc(profession, min, max);
	}

	/**
	 * @param city City instance
	 * @param min  minimum cost
	 * @param max  maximum cost
	 * @return List of Workers instance
	 */
	public List<Worker> findByCityAndCostPerHourBetweenOrderByRatingDesc(City city, int min, int max) {
		return workerRepositary.findByCityAndCostPerHourBetweenOrderByRatingDesc(city, min, max);
	}

	/**
	 * @param profession Profession instance
	 * @param city       City instance
	 * @param min        minimum cost
	 * @param max        maximum cost
	 * @return List of Workers instance
	 */
	public List<Worker> findByProfessionAndCityAndCostPerHourBetweenOrderByRatingDesc(Profession profession, City city,
			int min, int max) {
		return workerRepositary.findByProfessionAndCityAndCostPerHourBetweenOrderByRatingDesc(profession, city, min,
				max);
	}

	/**
	 * @param workerlog Worker instance
	 * @return Worker instance
	 */
	public Worker setWorkerRating(@Valid Worker workerlog) {
		Random random = new Random();

		workerlog.setRating(1 + random.nextInt(5));

		return save(workerlog);
	}

}
