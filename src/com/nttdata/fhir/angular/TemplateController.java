package com.nttdata.fhir.angular;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MapMessage;
import org.apache.logging.log4j.message.Message;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("angularjs/templates")
public class TemplateController {
		
    // Field used for programmer logging
	private static final Logger LOG = LogManager.getLogger(TemplateController.class);
	
	@RequestMapping(value = "/{section}/{subsection}/{file}", method = RequestMethod.GET)
	public String getTemplate(HttpServletRequest request, @PathVariable String section, @PathVariable String subsection, @PathVariable String file, Model model) {
	
		/*//MethodContext context = new MethodContext("getTemplate");
		Map map = new HashMap<String, String>();
		Message msg = new MapMessage().newInstance(map).put("section", section).put("subsection", subsection).put("file", file);
		//msg.
		LOG.info(Message);*/
		return getTemplateInternal(request, section + "/" +  subsection + "/" + file, model);
	}
	
	
	@RequestMapping(value = "/{section}/{file}", method = RequestMethod.GET)
	public String getTemplate(HttpServletRequest request, @PathVariable String section, @PathVariable String file, Model model) {
		
		return getTemplateInternal(request, section + "/" + file, model);
	}
	
	
	@RequestMapping(value = "/{file}", method = RequestMethod.GET)
	public String getTemplate(HttpServletRequest request, @PathVariable String file,  Model model) {
		
		return getTemplateInternal(request, file, model);
	}
	

	/**
	 * Private common getTemplate implementation that can be used for all forms of the public getTemplate() overloaded methods supported.
	 * 
	 * @param request HttpServletRequest the request
	 * @param assetName String name of request template
	 * @param model Model 
	 * 
	 * @return String path to template jsp file (Note:  does not include suffix .jsp)
	 */
	private String getTemplateInternal(HttpServletRequest request, String assetName, Model model) {

		String path = "/angularjs/templates/" + assetName;
		
		return path;
	}

}

