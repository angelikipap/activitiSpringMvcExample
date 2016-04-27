package com.examples.activitiSpringMvc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.examples.activitiSpringMvc.service.ActivitiRepositoryService;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	ActivitiRepositoryService activitiRepositoryService;

	private static Logger log = Logger.getLogger(MainController.class);

	/*
	 * This method will serve as default GET handler.
	 */

	@RequestMapping(method = RequestMethod.GET)
	public String returnIndex() {
		log.info("Rendering main page.");
		return "index";
	}

}