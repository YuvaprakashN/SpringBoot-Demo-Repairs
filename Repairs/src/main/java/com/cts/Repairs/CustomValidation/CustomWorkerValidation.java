package com.cts.Repairs.CustomValidation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cts.Repairs.Entity.User;
import com.cts.Repairs.Entity.Worker;
import com.cts.Repairs.Service.WorkerService;

@Component
public class CustomWorkerValidation implements Validator {

	@Autowired
	WorkerService workerService;

	/*
	 * 
	 * public void userLoginValidation(Object target, Errors errors) {
	 * 
	 * User user = (User) target;
	 * 
	 * String email = user.getEmail(); String password = user.getPassword();
	 * 
	 * List<User> findAll = userService.findAll(); boolean err = true; for (User
	 * user2 : findAll) { if (email.equals(user2.getEmail()) &&
	 * password.equals(user2.getPassword())) {
	 * System.out.println("Validation Success=================================");
	 * err = false; break; } } if (err) {
	 * System.out.println("Validation Fail=================================");
	 * errors.rejectValue("email", "errors.email", "Invalid Email or Password"); }
	 * 
	 * }
	 * 
	 * 
	 * 
	 */

	/**
	 * This method validate User Login credentials
	 * 
	 * @param target Object instance
	 * @param errors Errors instance
	 */
	public void WorkerLoginValidation(Object target, Errors errors) {

		Worker worker = (Worker) target;

		String email = worker.getEmail();
		String password = worker.getPassword();

		Worker findByEmailAndPassword = workerService.findByEmailAndPassword(email, password);
		
		//List<Worker> findAll = workerService.findAll();
		boolean err = true;
		/*for (Worker worker2 : findAll) {
			if (email.equals(worker2.getEmail()) && password.equals(worker2.getPassword())) {
				err = false;
				break;
			}
		}*/
		
		if(findByEmailAndPassword!=null)
			err=false;
		
		if (err) {
			errors.rejectValue("email", "errors.email", "Invalid Email or Password");
		}

	}

	// =========== Validating Worker Registration Detail ===========

	/**
	 * This method used to check the worker registration details password and
	 * confirm password are same and email id is already exist or not
	 * @param target Object instance
	 * @param errors Errors instance
	 */
	public void validateRegistrationDetails(Object target, Errors errors) {
		Worker worker = (Worker) target;

		String email = worker.getEmail();
		List<Worker> workers = workerService.findAll();
		if (!(worker.getPassword().equals(worker.getConfirmPassword()))) {
			errors.rejectValue("password", "errors.password", "Password and ConfirmPassword Not equal");
		}

		for (Worker worker2 : workers) {
			if (email.equals(worker2.getEmail())) {
				errors.rejectValue("email", "errors.email", "Worker with email is Already exsit");
				break;
			}
		}

	}

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {

	}

	/**
	 * This method used to check the worker edited details password and confirm
	 * password are same and email id is already exist or not
	 * @param target Object instance
	 * @param errors Errors instance
	 */
	public void validateWorkerEdit(Object target, Errors errors) {

		Worker worker = (Worker) target;
		String email = worker.getEmail();
		Integer id = worker.getId();

		if (!(worker.getPassword().equals(worker.getConfirmPassword()))) {
			errors.rejectValue("password", "errors.password", "Password and ConfirmPassword Not equal");
		}
		List<Worker> workers = workerService.findAll();
		boolean err = false;
		for (Worker worker2 : workers) {
			if (email.equals(worker2.getEmail()) && id != worker2.getId()) {
				err = true;
				break;
			}
		}
		if (err) {
			errors.rejectValue("email", "errors.email", "Email Already Exist");
		}

	}

}
