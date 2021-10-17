package com.cts.Repairs.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.Repairs.Entity.Booking;
import com.cts.Repairs.Entity.User;
import com.cts.Repairs.Entity.Worker;
import com.cts.Repairs.Service.BookingService;
import com.cts.Repairs.Service.CityService;
import com.cts.Repairs.Service.ProfessionService;
import com.cts.Repairs.Service.UserService;
import com.cts.Repairs.Service.WorkerService;

@Controller
public class UserController {

	@Autowired
	CityService cityService;

	@Autowired
	UserService userService;

	@Autowired
	ProfessionService professionService;

	@Autowired
	WorkerService workerService;

	@Autowired
	BookingService bookingService;

	/**
	 * @param session
	 * @return index webpage
	 */
	@GetMapping("/")
	public String Home(HttpSession session) {
//		session.invalidate();

		return "index";
	}

	// ======================== LoginPage GET>REQUEST======================
	/**
	 * @param user    User instance bind to userLog
	 * @param session HttpSession instance
	 * @return UserLogin webpage
	 */
	@GetMapping("/loginPage")
	public String showLoginPage(@ModelAttribute("userLog") User user, HttpSession session) {
		// session.invalidate();
		return "UserLogin";

	}

	// ====================== LginPage Validation ===============================

	/**
	 * @param userlog User instance
	 * @param br      BindingResult instance used to check userlog satisfies
	 *                validations
	 * @param session HttpSession instance
	 * @param map     ModelMap instance adding attributes to the model
	 * @return redirect to userHome webpage
	 */
	@PostMapping("/loginPage")
	public String userLoginValidation(@Valid @ModelAttribute("userLog") User userlog, BindingResult br,
			HttpSession session, ModelMap map) {
		userService.validateLogin(userlog, br);
		if (br.hasErrors()) {
			return "UserLogin";
		}
		User user = userService.findByEmail(userlog.getEmail());
		session.setAttribute("user", user);
		return "redirect:/userHome";
	}

	// ===================== User Registration GET.REQUEST ==================
	/**
	 * @param user    User instance used to store user detais
	 * @param session HttpSeesion instance
	 * @return UserRegistration web page
	 */
	@GetMapping("/userRegistrationPage")
	public String userRegistrationPage(@ModelAttribute("userreg") User user, HttpSession session) {
		session.invalidate();
		return "UserRegistrationPage";
	}

//================================  User Registration page Validation  POST.REQUEST  =======================	
	/**
	 * @param user    User instance used to store in database
	 * @param br      BindingResult instance used to check user satisfies
	 *                validations
	 * @param session HttpSession instance
	 * @param map     ModelMap instance adding attributes to the model
	 * @return It redirect to userHome
	 */
	@PostMapping("/userRegistrationPage")
	public String userRegistrationValidation(@Valid @ModelAttribute("userreg") User user, BindingResult br,
			HttpSession session, ModelMap map) {
		userService.validateUserRegistration(user, br);
		if (br.hasErrors()) {
			return "UserRegistrationPage";
		}

		User usersaved = userService.save(user);

		if (usersaved != null) {
			session.setAttribute("user", usersaved);
		}

		return "redirect:/userHome";

	}

	// ================= User Home page GET.Request ==============================
	/**
	 * @param map         ModelMap instance adding attributes to the model
	 * @param profession  It used to select profession
	 * @param location    It used to select location
	 * @param costPerHour It used to select cost range
	 * @return UserHome web page
	 */
	@GetMapping("/userHome")
	public String userHome(ModelMap map, @RequestParam(required = false, defaultValue = "select") String profession,
			@RequestParam(required = false, defaultValue = "select") String location,
			@RequestParam(required = false, defaultValue = "0") String costPerHour) {
		int min = 0;
		int max = 0;
		switch (costPerHour) {
		case "0": {
			costPerHour = "0";
			break;
		}
		case "1": {
			min = 0;
			max = 200;
			break;
		}
		case "2": {
			min = 201;
			max = 400;
			break;
		}
		case "3": {
			min = 401;
			max = 600;
			break;
		}
		case "4": {
			min = 601;
			max = 800;
			break;
		}
		case "5": {
			min = 801;
			max = 1000;
			break;
		}
		default:
			break;
		}

		System.out.println(costPerHour);

		profession = profession.equalsIgnoreCase("select") ? null : profession;

		location = location.equalsIgnoreCase("select") ? null : location;

		costPerHour = costPerHour.equalsIgnoreCase("0") ? null : costPerHour;

		System.out.println(profession);
		System.out.println(location);
		System.out.println(costPerHour);

		List<Worker> workers = new ArrayList<>();

		if (profession == null && location == null && costPerHour == null) {
			workers = workerService.findByOrderByRatingDesc();
		} else if (profession == null && location == null && costPerHour != null) {
			workers = workerService.findByCostPerHourBetweenOrderByRatingDesc(min, max);
		} else if (profession == null && location != null && costPerHour == null) {
			workers = workerService.findByCityOrderByRatingDesc(cityService.findByCityName(location));
		} else if (profession == null && location != null && costPerHour != null) {
			workers = workerService
					.findByCityAndCostPerHourBetweenOrderByRatingDesc(cityService.findByCityName(location), min, max);
		} else if (profession != null && location == null && costPerHour == null) {
			workers = workerService
					.findByProfessionOrderByRatingDesc(professionService.findById(Integer.parseInt(profession)));
		} else if (profession != null && location == null && costPerHour != null) {
			workers = workerService.findByProfessionAndCostPerHourBetweenOrderByRatingDesc(
					professionService.findById(Integer.parseInt(profession)), min, max);
		} else if (profession != null && location != null && costPerHour == null) {
			workers = workerService.findByProfessionAndCityOrderByRatingDesc(
					professionService.findById(Integer.parseInt(profession)), cityService.findByCityName(location));
		}

		else if (profession != null && location != null && costPerHour != null) {
			workers = workerService.findByProfessionAndCityAndCostPerHourBetweenOrderByRatingDesc(
					professionService.findById(Integer.parseInt(profession)), cityService.findByCityName(location), min,
					max);
		}

		map.addAttribute("workers", workers);
		return "UserHome";
	}

	/**
	 * @param map     ModelMap instance adding attributes to the model
	 * @param session HttpSession
	 * @return EditUserProfile web page
	 */
	@GetMapping("/editUserDetails")
	public String editUserProfile(ModelMap map, HttpSession session) {
		User useredit = (User) session.getAttribute("user");
		map.addAttribute("useredit", useredit);
		return "EditUserProfile";
	}

	/**
	 * @param useredit User instance used to store edited details
	 * @param br       BindingResult holds the result of a validation
	 * @param map      ModelMap instance adding attributes to the model
	 * @param session  HttpSession
	 * @return It redirect to UserHome
	 */
	@PostMapping("/editUserDetails")
	public String saveEditUser(@Valid @ModelAttribute("useredit") User useredit, BindingResult br, ModelMap map,
			HttpSession session) {
		userService.validateUserEdit(useredit, br);
		if (br.hasErrors()) {
			return "EditUserProfile";
		}

		User save = userService.save(useredit);
		session.setAttribute("user", save);
		return "redirect:/userHome";
	}

	/**
	 * @param worker Worker instance
	 * @param user   User instance used to store user details
	 * @param map    ModelMap instance adding attributes to the model
	 * @return BookWorker web page
	 */
	@GetMapping("/bookWorker")
	public String bookWorker(@RequestParam Worker worker, @RequestParam User user, ModelMap map) {
		map.addAttribute("bookedworker", worker);
		map.addAttribute("book", new Booking());

		return "BookWorker";
	}

	/**
	 * @param book Booking instance used to store Booking details
	 * @param br   BindingResult holds the result of a validation
	 * @param map  ModelMap instance adding attributes to the model
	 * @return redirect to user's booking table
	 */
	@PostMapping("/bookWorker")
	public String saveBooking(@Valid @ModelAttribute("book") Booking book, BindingResult br, ModelMap map) {
		if (br.hasErrors()) {
			System.out.println("has error");
			return "BookWorker";
		}
		System.out.println("checked");
		Booking booking = bookingService.save(book);
		System.out.println("save");
		User user = booking.getUser();
		Worker worker = booking.getWorker();

		user.addBookings(booking);
		worker.addBooking(booking);
		userService.save(user);
		workerService.save(worker);

		map.addAttribute("book", book);

		map.addAttribute("bookuser", book.getUser());
		map.addAttribute("bookworker", book.getWorker());

		return "redirect:/BookingTable";
	}

	/**
	 * @param map         Booking instance used to store Booking details
	 * @param httpSession HttpSession instance
	 * @return ViewBook web page
	 */
	@GetMapping("/BookingTable")
	public String showBookingTable(ModelMap map, HttpSession httpSession) {

		List<Booking> bookings = bookingService.findByUserOrderByBookedDateAsc((User) httpSession.getAttribute("user"));

		map.addAttribute("bookings", bookings);

		return "ViewBook";

	}

	/**
	 * logout() used to logout
	 * 
	 * @param session HttpSession instance
	 * @return redirect to /
	 */
	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "index";
	}

	

	@GetMapping("/errorhandle")
	public String errorhandle(HttpSession session)
	{
		session.invalidate();
		return "redirect:/";
	}
	
}
