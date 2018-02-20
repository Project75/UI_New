package com.nttdata.fhir.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

	// Field used for programmer logging
	private static final Logger LOG = LogManager.getLogger(LoginController.class);

	@Autowired
	private Environment env;

	@RequestMapping(value = "/login.request", method = RequestMethod.GET)
	public String loginRequest(Model model) {
		
		return "login";
	}
}
