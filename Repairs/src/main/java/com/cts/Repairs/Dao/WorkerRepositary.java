package com.cts.Repairs.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.Repairs.Entity.City;
import com.cts.Repairs.Entity.Profession;
import com.cts.Repairs.Entity.Worker;

@Repository
public interface WorkerRepositary extends JpaRepository<Worker, Integer>{

	List<Worker> findAllByOrderByRating();

	List<Worker> findByOrderByRatingDesc();


	List<Worker> findByCityOrderByRatingDesc(City location);

//	List<Worker> findByProfessionAndCityAndRatingOrderByCostPerHourAsc(Profession profession, City city, int rating);

//	List<Worker> findByCityAndRatingOrderByCostPerHourAsc(City cityName, int ratingId);

	List<Worker> findByProfessionOrderByRatingDesc(Profession professionId);

//	List<Worker> findByProfessionAndRatingOrderByCostPerHourAsc(Profession profession, int rating);

	List<Worker> findByProfessionAndCityOrderByRatingDesc(Profession profession, City city);

	Worker findByEmail(String email);
	
	
	

	//List<Worker> findByCostPerHourOrderByRatingAsc(int parseInt);

	List<Worker> findByCityAndCostPerHourOrderByRatingAsc(City cityName, int cost);

	List<Worker> findByProfessionAndCityAndCostPerHourOrderByRatingAsc(Profession id, City cityName, int cost);

	List<Worker> findByProfessionAndCostPerHourOrderByRatingAsc(Profession id, int cost);

	
	List<Worker> findByCostPerHourBetweenOrderByRatingDesc(int min,int max);

	List<Worker> findByProfessionAndCostPerHourBetweenOrderByRatingDesc(Profession profession, int min, int max);

	List<Worker> findByCityAndCostPerHourBetweenOrderByRatingDesc(City city, int min, int max);

	List<Worker> findByProfessionAndCityAndCostPerHourBetweenOrderByRatingDesc(Profession profession, City city, int min, int max);

	Worker findByEmailAndPassword(String email, String password);
	
}
