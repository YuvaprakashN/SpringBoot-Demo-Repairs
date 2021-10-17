package com.cts.Repairs.CustomValidation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cts.Repairs.Entity.User;
import com.cts.Repairs.Service.UserService;

@Component
public class CustomUserValidation implements Validator {

	@Autowired
	UserService userService;

	// =========== Validating User Registration Details ==============

	/**
	 * This method used to check User registration email is already exist or not and it also
	 * check password and confirm password are same
	 * @param target Object instance
	 * @param errors Errors instance
	 */
	public void validateRegistrationDetails(Object target, Errors errors) {
		User user = (User) target;

		String email = user.getEmail();
		List<User> users = userService.findAll();
		if (!(user.getPassword().equals(user.getConfirmPassword()))) {
			errors.rejectValue("password", "errors.password", "Password and ConfirmPassword Not equal");
		}

		for (User user2 : users) {
			if (email.equals(user2.getEmail())) {
				errors.rejectValue("email", "errors.email", "User with email is Already exsit");
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
	 * This method used to check User Login credentials 
	 * @param target Object instance
	 * @param errors Errors instance
	 */
	public void userLoginValidation(Object target, Errors errors) {

		User user = (User) target;

		String email = user.getEmail();
		String password = user.getPassword();

		User findByEmailAndPassword = userService.findByEmailAndPassword(email, password);
		
		//List<User> findAll = userService.findAll();
		boolean err = true;
		/*
		for (User user2 : findAll) {
			if (email.equals(user2.getEmail()) && password.equals(user2.getPassword())) {
				err = false;
				break;
			}
		}*/
		if(findByEmailAndPassword!=null)
		{
			err=false;
		}
		if (err) {
			errors.rejectValue("email", "errors.email", "Invalid Email or Password");
		}

	}

	/**
	 * This method used to check User edited details password and confirm password are same and email id is already exist or not
	 * @param target Object instance
	 * @param errors Errors instance
	 */
	public void validateUserEdit(Object object, Errors errors) {
		User user = (User) object;
		String email = user.getEmail();
		Integer id = user.getId();

		if (!(user.getPassword().equals(user.getConfirmPassword()))) {
			errors.rejectValue("password", "errors.password", "Password and ConfirmPassword Not equal");
		}
		List<User> findAll = userService.findAll();
		boolean err = false;
		for (User user2 : findAll) {
			if (email.equals(user2.getEmail()) && id != user2.getId()) {
				err = true;
				break;
			}
		}
		if (err) {
			errors.rejectValue("email", "errors.email", "Email Already Exist");
		}

	}

}
