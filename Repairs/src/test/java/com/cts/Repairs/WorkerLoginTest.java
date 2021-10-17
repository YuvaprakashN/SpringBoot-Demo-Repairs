package com.cts.Repairs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.Repairs.Dao.WorkerRepositary;
import com.cts.Repairs.Entity.Worker;
import com.cts.Repairs.Service.WorkerService;

@SpringBootTest
public class WorkerLoginTest {

	
	@Autowired
	WorkerRepositary workerRepositary;
	
	@Autowired
	WorkerService service;

	private Logger logger=org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void workerLogPresent()
	{
		Worker findByEmail = workerRepositary.findByEmail("worke@worker.com");
logger.info("worker --> {}"+findByEmail);
	}
	
}
