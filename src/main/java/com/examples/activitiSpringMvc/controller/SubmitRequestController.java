package com.examples.activitiSpringMvc.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.examples.activitiSpringMvc.model.RequestInfoEntity;
import com.examples.activitiSpringMvc.service.RequestInfoService;

@Controller
@RequestMapping("/submitRequest")
public class SubmitRequestController {

	@Autowired
	private RequestInfoService requestInfoService;


	private static Logger log = Logger.getLogger(SubmitRequestController.class);

	/*
	 * This method will serve as default GET handler for /submitRequest.
	 */

	@RequestMapping(method = RequestMethod.GET)
	public String getSubmitRequest(ModelMap model) {
		log.info("Rendering submitRequest GET");
		RequestInfoEntity requestInfoEntity = new RequestInfoEntity();
		model.addAttribute("requestInfoEntity", requestInfoEntity);
		return "request/submitRequest";
	}

	/*
	 * This method will serve as default POST handler for /submitRequest.
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String postSubmitRequest(@Valid RequestInfoEntity requestInfoEntity,
			BindingResult result, ModelMap model) {
		log.info("Rendering submitRequest POST");
		if (result.hasErrors()) {
			return "request/submitRequest";
		}
		requestInfoService.submitRequest(requestInfoEntity);
		model.addAttribute("message",
				"Your request has been submitted successfully");
		return "common/success";
	}

}