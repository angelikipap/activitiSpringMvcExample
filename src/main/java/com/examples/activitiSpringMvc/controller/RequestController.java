package com.examples.activitiSpringMvc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.examples.activitiSpringMvc.model.RequestInfoEntity;
import com.examples.activitiSpringMvc.service.RequestInfoService;

@Controller

public class RequestController {

	@Autowired
	private RequestInfoService requestInfoService;

	private static Logger log = Logger.getLogger(RequestController.class);

	/*
	 * This method will serve as handler for /viewRequest.
	 */

	@RequestMapping(value = { "/viewRequest-{id}" }, method = RequestMethod.GET)
	public String getRequestInfo(@PathVariable String id, ModelMap model) {
		log.info("Rendering viewRequest GET");
		requestInfoService.findRequest(model, Long.valueOf(id));

		return "request/viewRequest";
	}

}