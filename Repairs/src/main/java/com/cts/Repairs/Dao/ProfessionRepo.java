package com.cts.Repairs.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.Repairs.Entity.Profession;

@Repository
public interface ProfessionRepo extends JpaRepository<Profession, Integer>{

}
