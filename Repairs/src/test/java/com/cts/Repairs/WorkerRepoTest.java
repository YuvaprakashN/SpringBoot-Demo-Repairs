package com.cts.Repairs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DecimalFormat; 
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.Repairs.Dao.CityRepositary;
import com.cts.Repairs.Dao.ProfessionRepo;
import com.cts.Repairs.Dao.WorkerRepositary;
import com.cts.Repairs.Entity.City;
import com.cts.Repairs.Entity.Profession;
import com.cts.Repairs.Entity.Worker;

@SpringBootTest(classes = RepairsApplication.class)
public class WorkerRepoTest {

	
	@Autowired
	WorkerRepositary repo;
	@Autowired
	ProfessionRepo professionRepo;
	@Autowired
	CityRepositary cityRepositary;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void filterByCostPerHour()
	{
		List<Worker> findByCostPerHourBetween = repo.findByCostPerHourBetweenOrderByRatingDesc(450, 550);
		
		logger.info("Workers=========>{}"+findByCostPerHourBetween);
		
 
		//Worker [id=14, name=Arun, password=arunarun, confirmPassword=arunarun, address=23,Larry Layout St,Saravanampatti, phone=9090745328, email=arun@plumber.com, costPerHour=450, createdDate=2020-09-06, updatedDate=2020-09-06, city=City [id=2, cityName=Coimbatore], profession=Profession [id=3, professionName=Plumber]], 
		//Worker [id=15, name=Yogesh, password=yogeshyo, confirmPassword=yogeshyo, address=23,B1arni St,Killer, phone=9097609342, email=yogesh@electric.com, costPerHour=550, createdDate=2020-09-06, updatedDate=2020-09-06, city=City [id=3, cityName=Madurai], profession=Profession [id=1, professionName=Electrician]]]
		//[Worker [id=13, name=Meshub, password=meshubme, confirmPassword=meshubme, address=23,Rahuman St,Saravanampatti, phone=9090787856, email=meshub@plumber.com, costPerHour=500, createdDate=2020-09-06, updatedDate=2020-09-06, city=City [id=2, cityName=Coimbatore], profession=Profession [id=3, professionName=Plumber]],
	}

	
	@Test
	public void filterByCostPerHourAndProfession()
	{
	 Profession profession = professionRepo.findById(3).get();	
		List<Worker> findByProfessionAndCostPerHourBetween = repo.findByProfessionAndCostPerHourBetweenOrderByRatingDesc(profession,300, 650);
		
		logger.info("Workers=========>{}"+findByProfessionAndCostPerHourBetween);
		
		//Workers=========>{}[Worker [id=14, name=Arun, password=arunarun, confirmPassword=arunarun, address=23,Larry Layout St,Saravanampatti, phone=9090745328, email=arun@plumber.com, costPerHour=450, createdDate=2020-09-06, updatedDate=2020-09-06, city=City [id=2, cityName=Coimbatore], profession=Profession [id=3, professionName=Plumber]], 
		//Worker [id=35, name=Plumber, password=zxcvzxcv, confirmPassword=zxcvzxcv, address=plumber address, phone=0987654321, email=plumber@worker.com, costPerHour=300, createdDate=2020-09-09, updatedDate=2020-09-09, city=City [id=2, cityName=Coimbatore], profession=Profession [id=3, professionName=Plumber]]]
	
	}

	
	@Test
	public void filterByCostPerHourAndLocation()
	{

		City city = cityRepositary.findById(2).get();
		List<Worker> findByCityAndCostPerHourBetween = repo.findByCityAndCostPerHourBetweenOrderByRatingDesc(city,300, 650);
		
		logger.info("Workers=========>{}"+findByCityAndCostPerHourBetween);
		
		//Worker [id=13, name=Meshub, password=meshubme, confirmPassword=meshubme, address=23,Rahuman St,Saravanampatti, phone=9090787856, email=meshub@plumber.com, costPerHour=500, createdDate=2020-09-06, updatedDate=2020-09-06, city=City [id=2, cityName=Coimbatore], profession=Profession [id=3, professionName=Plumber]], 
		                    //Worker [id=14, name=Arun, password=arunarun, confirmPassword=arunarun, address=23,Larry Layout St,Saravanampatti, phone=9090745328, email=arun@plumber.com, costPerHour=450, createdDate=2020-09-06, updatedDate=2020-09-06, city=City [id=2, cityName=Coimbatore], profession=Profession [id=3, professionName=Plumber]], 
		                    //Worker [id=35, name=Plumber, password=zxcvzxcv, confirmPassword=zxcvzxcv, address=plumber address, phone=0987654321, email=plumber@worker.com, costPerHour=300, createdDate=2020-09-09, updatedDate=2020-09-09, city=City [id=2, cityName=Coimbatore], profession=Profession [id=3, professionName=Plumber]],
		                    //Worker [id=36, name=Builder, password=zxcvzxcv, confirmPassword=zxcvzxcv, address=builder address, phone=0987654321, email=builder@worker.com, costPerHour=500, createdDate=2020-09-09, updatedDate=2020-09-09, city=City [id=2, cityName=Coimbatore], profession=Profession [id=4, professionName=Builder]]]
	}
	
	@Test
	public void filterByCostPerHourAndLocationAndProfession()
	{

		City city = cityRepositary.findById(2).get();
		Profession profession = professionRepo.findById(3).get();
		List<Worker> findByCityAndCostPerHourBetween = repo.findByProfessionAndCityAndCostPerHourBetweenOrderByRatingDesc(profession,city,300, 470);
		
		logger.info("Workers=========>{}"+findByCityAndCostPerHourBetween);
		
		//Worker [id=14, name=Arun, password=arunarun, confirmPassword=arunarun, address=23,Larry Layout St,Saravanampatti, phone=9090745328, email=arun@plumber.com, costPerHour=450, createdDate=2020-09-06, updatedDate=2020-09-06, city=City [id=2, cityName=Coimbatore], profession=Profession [id=3, professionName=Plumber]], 
		//Worker [id=35, name=Plumber, password=zxcvzxcv, confirmPassword=zxcvzxcv, address=plumber address, phone=0987654321, email=plumber@worker.com, costPerHour=300, createdDate=2020-09-09, updatedDate=2020-09-09, city=City [id=2, cityName=Coimbatore], profession=Profession [id=3, professionName=Plumber]]
		
	}	

	
	
	
	
	@Test
	public void doublee()
	{
		double g=56.898998;
		DecimalFormat df=new DecimalFormat("#.#");   //56.9
		g=Double.valueOf(df.format(g));
		System.out.println(g);
	}

	@Test
	public void getWorkerByEmailAndPassword()
	{
		Worker findByEmail = repo.findByEmail("worker1@worker.com");
		 Worker findByEmailAndPassword = repo.findByEmailAndPassword("worker1@worke.com", "worker1password");
		logger.info("actual--->"+findByEmailAndPassword);
		logger.info("expected--->"+findByEmail);
		 assertEquals(findByEmail, findByEmailAndPassword);
		
	}
	
}
