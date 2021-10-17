package com.cts.Repairs.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.Repairs.Dao.CityRepositary;
import com.cts.Repairs.Entity.City;

@Service
public class CityService {

	@Autowired
	CityRepositary cityRepositary;
	
	public List<City> findAll()
	{
		return cityRepositary.findAll();
	}

	/**
	 * This method used to return City instance 
	 * @param location Location name
	 * @return City instance
	 */
	public City findByCityName(String location) {
		return cityRepositary.findByCityName(location);
	}

	
}
