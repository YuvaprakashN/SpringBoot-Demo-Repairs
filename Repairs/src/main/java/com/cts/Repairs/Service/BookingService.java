package com.cts.Repairs.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.Repairs.Dao.BookingRepo;
import com.cts.Repairs.Entity.Booking;
import com.cts.Repairs.Entity.User;
import com.cts.Repairs.Entity.Worker;

@Service
public class BookingService {

	@Autowired
	BookingRepo bookingRepo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	WorkerService workerService;
	

	/**
	 * This method is used to save Booking details
	 * @param book Booking instance
	 * @return Booking instance
	 */
	public Booking save(Booking book) {
		return bookingRepo.save(book);
	}

	/**
	 * his method is used to find list of user's booking details
	 * @param user User instance
	 * @return User instance
	 */
	public List<Booking> findByUserOrderByBookedDateAsc(User user) {
		return bookingRepo.findByUserOrderByBookedDateAsc(user);
	}

	/**
	 * This method used to find Booking details using booking integer
	 * @param bookId It is used to find Booking instance
	 * @return Booking instance
	 */
	public Booking findById(Integer bookId) {
		return bookingRepo.findById(bookId).get();
	}

	
	/**
	 * This method is used to update booking details(booking status)
	 * @param booking Booking instance
	 */
	public void removeReplaceBooking(Booking booking) {
		
		User user = booking.getUser();
		Worker worker = booking.getWorker();
		
		user.getBookings().remove(booking);
		user.getBookings().add(booking);
		worker.getBookings().remove(booking);
		worker.getBookings().add(booking);
		userService.save(user);
		workerService.save(worker);
		
	}

	/**
	 * @param worker Worker instance
	 * @return It used to return list of worker's booking
	 */
	public List<Booking> findByWorkerOrderByBookedDateAsc(Worker worker) {
		// TODO Auto-generated method stub
		return bookingRepo.findByWorkerOrderByBookedDateAsc(worker);
	}
	
}
