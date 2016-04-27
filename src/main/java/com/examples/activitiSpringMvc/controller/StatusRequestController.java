package com.examples.activitiSpringMvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.examples.activitiSpringMvc.model.RequestInfoEntity;
import com.examples.activitiSpringMvc.service.RequestInfoService;

@Controller
@RequestMapping("/statusRequest")
public class StatusRequestController {
	
	@Autowired
	RequestInfoService requestInfoService;

	private static Logger log = Logger.getLogger(StatusRequestController.class);

	/*
	 * This method will serve as default GET handler for /statusRequest.
	 */

	@RequestMapping(method = RequestMethod.GET)
	public String getStatusRequest() {
		log.info("Rendering statusRequest GET");
		return "request/statusRequest";
	}

	/*
	 * This method will serve as default POST handler for /statusRequest.
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String postStatusRequest(ModelMap model,HttpServletRequest request) {
		log.info("Rendering statusRequest POST");
		model.addAttribute("requestInfoEntities",requestInfoService.findAllRequests());
		return "request/statusRequest";
	}
	
	/*
	 * Method used to populate the requestInfoEntities list in view.
	 */
	@RequestMapping(value="viewRequests",method = RequestMethod.GET)
	public String viewRequests(HttpServletRequest request) {
		log.info("Rendering viewRequests");
		return "request/viewRequests";
	}
	
	@ModelAttribute("requestInfoEntities")
	public List<RequestInfoEntity> getRequestInfoEntities() {
		return requestInfoService.findAllRequests();
	}

}