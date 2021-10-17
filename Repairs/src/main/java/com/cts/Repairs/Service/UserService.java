package com.cts.Repairs.Service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.cts.Repairs.CustomValidation.CustomUserValidation;
import com.cts.Repairs.Dao.UserRepositary;
import com.cts.Repairs.Entity.User;

@Service
public class UserService {

	@Autowired
	UserRepositary userRepositary;
	
	@Autowired
	CustomUserValidation customUserValidation;
	
	/**
	 * @return List of all User instance
	 */
	public List<User> findAll() {
		return userRepositary.findAll();
	}

	/**
	 * @param user User instance
	 * @param br BindingResult holds the result of a validation
	 */
	public void validateUserRegistration(@Valid User user, BindingResult br) {
		customUserValidation.validateRegistrationDetails(user, br);
	}

	/**
	 * @param user User instance
	 * @return User instance
	 */
	public User save(User user) {
		return userRepositary.save(user);
	}

	/**
	 * @param userlog User instance
	 * @param br BindingResult holds the result of a validation
	 */
	public void validateLogin(User userlog, BindingResult br) {
		customUserValidation.userLoginValidation(userlog,br);
		
	}

	/**
	 * @param email It has Email id 
	 * @return User instance
	 */
	public User findByEmail(String email) {
		return userRepositary.findByEmail(email);
	}

	/**
	 * @param email It has Email id 
	 * @param password It has Password 
	 * @return User instance
	 */
	public User findByEmailAndPassword(String email,String password) {
		return userRepositary.findByEmailAndPassword(email,password);
	}

	
	/**
	 * @param useredit User instance
	 * @param br BindingResult holds the result of a validation
	 */
	public void validateUserEdit(User useredit, BindingResult br) {
		customUserValidation.validateUserEdit(useredit,br);
	}

	
	
}
