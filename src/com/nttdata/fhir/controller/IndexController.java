package com.nttdata.fhir.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired private Environment env;	

	@RequestMapping(method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {
	   
		String serverInstanceName = env.getProperty("serverInstanceName", "fhirmapperui");
		String translatorApiURL = env.getProperty("translatorApiURL");
		model.addAttribute("translatorApiURL", translatorApiURL);
		model.addAttribute("serverInstanceName", serverInstanceName);
        return "index";
    }
  
	@RequestMapping(value = "/access_denied", method = RequestMethod.GET)
	public String accessDenied(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "access_denied";
	}

}