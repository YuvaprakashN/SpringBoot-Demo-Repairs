package com.cts.Repairs.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller("error")
public class ErrorController {

	
	@ExceptionHandler(Exception.class)
	public String handleAllException(HttpServletRequest request,Exception ex,ModelMap map)
	{
		map.addAttribute("message", ex.getMessage());
		return "error";
	}
}
