package com.example.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.entity.User;
import com.example.service.UserService;
import com.example.service.UserServiceImpl;
import com.example.util.Config;
import com.google.gson.Gson;
import com.mindtree.exceptions.ServiceException;

@EnableAutoConfiguration
@RestController

public class HomeController {

	public HomeController() {
		Config.loadData();
	}

	@RequestMapping(value = "/")
	public String serveBase() {
		String result = "Hello World!";

		return result;
	}

	@RequestMapping(value = "/home", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public String serveHome() {

		String result = "";

		result = "{\"message\":\"Hello World!\"}";

		return result;
	}

	@RequestMapping(value = "/sendData", method = RequestMethod.POST)
	public String addSomeData(@RequestParam("username") String username, @RequestParam("password") String password) {

		System.out.println("Inside controller : " + username + " " + password);
		String result = "{\"message\":\"Hello World!\"}";
		User user = new User(username, password);
		// Insert into DB and return proper message
		UserService service = new UserServiceImpl();
		Boolean inserted = false;
		try {
			inserted = service.insertUser(user);
		} catch (ServiceException e) {
			result = "{\"message\":\"Some unknown error\"}";
		}
		if (inserted) {
			result = "{\"message\":\"Data inserted\"}";
		} else {
			result = "{\"message\":\"Data not inserted!\"}";
		}
		// Gson gson = new Gson();
		// result = gson.toJson(user);

		return result;
	}

	// @RequestMapping(value = "/myname")
	// public String Helloworld(){
	// return "Gaurav Sharan";
	// }

}
