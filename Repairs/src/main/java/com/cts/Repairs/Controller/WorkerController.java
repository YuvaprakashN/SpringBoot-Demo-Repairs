package com.cts.Repairs.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.Repairs.Entity.Worker;
import com.cts.Repairs.Service.CityService;
import com.cts.Repairs.Service.ProfessionService;
import com.cts.Repairs.Service.WorkerService;

@Controller
public class WorkerController {

	@Autowired
	WorkerService workerService;

	@Autowired
	CityService cityService;

	@Autowired
	ProfessionService professionService;

	/**
	 * @param worker  Worker instance
	 * @param session HttpSession instance
	 * @return WorkerRegistrationPage web page
	 */
	@GetMapping("/workerRegistrationPage")
	public String workerRegistrationPage(@ModelAttribute("workerreg") Worker worker, HttpSession session) {
		session.invalidate();
		return "WorkerRegistrationPage";
	}

	// ============== Worker Registration page Validation
	// POST.REQUEST=====================
	/**
	 * @param workerlog Worker instance
	 * @param br        BindingResult holds the result of a validation
	 * @param session
	 * @param map       ModelMap instance adding attributes to the model
	 * @return It redirect to workerHome web page
	 */
	@PostMapping("/workerRegistrationPage")
	public String workerRegistrationValidation(@Valid @ModelAttribute("workerreg") Worker workerlog, BindingResult br,
			HttpSession session, ModelMap map) {
		System.out.println(workerlog.getPassword());
		System.out.println(workerlog.getConfirmPassword());
		workerService.validateWorkerRegistration(workerlog, br);
		if (br.hasErrors()) {
			return "WorkerRegistrationPage";
		}

	//	System.out.println("=====================>>>>>" + workerlog.getProfession());
		Worker worker = workerService.setWorkerRating(workerlog);
		session.setAttribute("worker", worker);

		return "redirect:/workerHome";

	}

	// ============================= Worker Login Page ==========================
	/**
	 * @param worker  Worker instance
	 * @param session HttpSession
	 * @return WorkerLogin web page
	 */
	@GetMapping("/showWorkerLogin")
	public String workerLoginPage(@ModelAttribute("workerLog") Worker worker, HttpSession session) {
		// session.invalidate();

		return "WorkerLogin";
	}

	/**
	 * @param workerlog Worker instance
	 * @param br        BindingResult holds the result of a validation
	 * @param session   HttpSession
	 * @return It redirect to WorkerHome
	 */
	@PostMapping("/showWorkerLogin")
	public String workerLogin(@Valid @ModelAttribute("workerLog") Worker workerlog, BindingResult br,
			HttpSession session) {
		workerService.WorkerLoginValidation(workerlog, br);
		if (br.hasErrors()) {
			System.out.println("has Error");
			return "WorkerLogin";
		}
		System.out.println("no error");
		Worker worker = workerService.findByEmail(workerlog.getEmail());
		session.setAttribute("worker", worker);

		return "redirect:/workerHome";
	}

	/**
	 * @param session HttpSession instance
	 * @param map     ModelMap instance adding attributes to the model
	 * @return WorkerHome web page
	 */
	@GetMapping("/workerHome")
	public String workerHomePage(HttpSession session, ModelMap map) {
		Worker worker = (Worker) session.getAttribute("worker");

		Worker worker1 = workerService.findByEmail(worker.getEmail());

		// map.addAttribute("worker", worker);
		map.addAttribute("bookingList", worker1.getBookings());
		return "WorkerHome";
	}

	/**
	 * @param map     ModelMap instance adding attributes to the model
	 * @param session HttpSession instance
	 * @return EditWorkerProfile web page
	 */
	@GetMapping("/editWorkerDetails")
	public String editUserProfile(ModelMap map, HttpSession session) {
		Worker workeredit = (Worker) session.getAttribute("worker");
		map.addAttribute("workeredit", workeredit);
		return "EditWorkerProfile";
	}

	/**
	 * @param workeredit Worker instance
	 * @param br         BindingResult holds the result of a validation
	 * @param map        ModelMap instance adding attributes to the model
	 * @param session    HttpSession
	 * @return EditWorkerProfile web page
	 */
	@PostMapping("/editWorkerDetails")
	public String saveEditUser(@Valid @ModelAttribute("workeredit") Worker workeredit, BindingResult br, ModelMap map,
			HttpSession session) {
		workerService.validateWorkerEdit(workeredit, br);
		if (br.hasErrors()) {
			return "EditWorkerProfile";
		}

		Worker save = workerService.save(workeredit);
		session.setAttribute("worker", save);
		return "redirect:/workerHome";
	}

}
