package com.cts.Repairs.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.Repairs.Entity.Booking;
import com.cts.Repairs.Entity.User;
import com.cts.Repairs.Entity.Worker;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer>{

	List<Booking> findByUserOrderByBookedDateAsc(User user);

	List<Booking> findByWorkerOrderByBookedDateAsc(Worker worker);

}
