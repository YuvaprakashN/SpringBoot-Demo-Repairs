package com.cts.Repairs.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.Repairs.Entity.Booking;
import com.cts.Repairs.Service.BookingService;

@Controller
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	/*
	 * updateBookingStatus method used change the status of booking like confirm/cancel
	 * @parm bookId: Is used to retrive Booking object
	 * @parm statusUpdate: It has an current Booking Status
	 * @parm session: Httpsession obj
	 * @parm user: boolean variable used to check whether it called by user or not
	 * @return if it called by user it return to user's booking table else it return to worker home
	 * */
	
	@GetMapping("/bookingStatusUpdating")
	public String updateBookingStatus(@RequestParam Integer bookId,@RequestParam String statusUpdate,HttpSession session,@RequestParam boolean user)
	{
		Booking booking=bookingService.findById(bookId);               //Retrive the booking by using booking id
		
		if(statusUpdate.equalsIgnoreCase("cancel"))                    
		{
			booking.setStatus("Cancelled");
			bookingService.save(booking);
			bookingService.removeReplaceBooking(booking);
		}
		else {
		
			booking.setStatus("Confirmed");
			bookingService.save(booking);
			bookingService.removeReplaceBooking(booking);
		}
		
		
		
		if(user)
		{
			return "redirect:/BookingTable";                        	//Redirect to user's booking table
		}
		else
		{
			session.setAttribute("worker", booking.getWorker());        //saving worker updated obj in session
			return "redirect:/workerHome";								//Redirect to Worker's home page
		}
		
	}
	
}
