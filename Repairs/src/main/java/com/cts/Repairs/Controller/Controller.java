package com.cts.Repairs.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cts.Repairs.Entity.City;
import com.cts.Repairs.Entity.Profession;
import com.cts.Repairs.Service.CityService;
import com.cts.Repairs.Service.ProfessionService;

@ControllerAdvice
public class Controller {

	@Autowired
	CityService cityService;

	@Autowired
	ProfessionService professionService;

	// =================================== adding City to modelAttributes======================
	/*
	 * It retrieve all the city object
	 * @return List of all City
	 */
	@ModelAttribute("city")
	public List<City> city() {
		
		List<City> findAll = cityService.findAll();
		System.out.println("All Cities: "+findAll);
		return findAll;
	}

	
	
	/*
	 * It retrieve all the profession objects
	 * @return List of all profession
	 */
	@ModelAttribute("professions")
	public List<Profession> profession() {
		return professionService.findAll();
	}

	// ================================ init Binder ========================
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	
	

}
