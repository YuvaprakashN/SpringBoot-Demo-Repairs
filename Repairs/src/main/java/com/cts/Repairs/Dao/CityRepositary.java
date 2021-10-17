package com.cts.Repairs.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.Repairs.Entity.City;

@Repository
public interface CityRepositary extends JpaRepository<City, Integer>{

	City findByCityName(String location);

}
