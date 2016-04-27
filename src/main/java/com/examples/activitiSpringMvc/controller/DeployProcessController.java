package com.examples.activitiSpringMvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.examples.activitiSpringMvc.dtos.DeployProcessDto;
import com.examples.activitiSpringMvc.service.ActivitiRepositoryService;

@Controller
@RequestMapping("/deployProcess")
public class DeployProcessController {

	@Autowired
	ActivitiRepositoryService activitiRepositoryService;

	private static Logger log = Logger.getLogger(DeployProcessController.class);

	/*
	 * This method will serve as default GET handler for /deployProcess .
	 */

	@RequestMapping(method = RequestMethod.GET)
	public String getDeployProcess(ModelMap model) {
		
		log.info("Rendering deployProcess GET");
		DeployProcessDto deployProcessDto = new DeployProcessDto();
		model.addAttribute("deployProcessDto", deployProcessDto);
		
		return "deployProcess";
	}

	


	/*
	 * This method will serve as default POST handler for /deployProcess.
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String postDeployProcess(@Valid DeployProcessDto deployProcessDto, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "deployProcess";
		}
			log.info("Rendering deployProcess POST");
		try {
			switch (deployProcessDto.getProcessName()) {
			case "ApproveRequest Process":
				activitiRepositoryService.deployApproveRequestProcess();
				break;
			default:
				throw new Exception("The process is not available for deployment");
			}
			model.addAttribute("message", "ApproveRequest process has been deployed successfully");
			return "deployProcess";

		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			return "deployProcess";
		}
	}

	/*
	 * Method used to populate the processes list in view.
	 */
	@ModelAttribute("processes")
	public List<String> initializeProcesses() {

		List<String> processes = new ArrayList<String>();
		processes.add("ApproveRequest Process");
		processes.add("ApproveExpensesProcess");
		processes.add("ApprovePersonalLeave Process");

		return processes;
	}

}