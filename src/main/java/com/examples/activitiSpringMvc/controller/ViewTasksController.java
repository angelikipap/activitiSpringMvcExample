package com.examples.activitiSpringMvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.activiti.engine.task.Task;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.examples.activitiSpringMvc.dtos.TaskDto;
import com.examples.activitiSpringMvc.service.ActivitiTaskService;

@Controller
@RequestMapping("/viewTasks")
public class ViewTasksController {

	@Autowired
	private ActivitiTaskService activitiTaskService;

	private static Logger log = Logger.getLogger(ViewTasksController.class);

	/*
	 * This method will serve as default GET handler for /viewTasks.
	 */

	@RequestMapping(method = RequestMethod.GET)
	public String getViewTasks(ModelMap model) {
		
		log.info("Rendering viewTasks GET");
		List<String> assignees = new ArrayList<String>();
		assignees.add("firstApprover");
		assignees.add("secondApprover");
		model.addAttribute("tasksDtos", activitiTaskService.getTasksByAssignees(assignees));

		return "tasks/viewTasks";
	}

	/*
	 * This method will serve as default POST handler for /viewTasks.
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String postViewTasks(HttpServletRequest request) {
		log.info("Rendering viewTasks POST");
		return "tasks/viewTasks";
	}

	@RequestMapping(value = { "/workTask-{id}" }, method = RequestMethod.GET)
	public String getWorkTask(@PathVariable String id, ModelMap model) {

		log.info("Working on task with id: " + id);
		model.addAttribute("taskDto", activitiTaskService.getTaskDtoById(id));

		return "tasks/workTask";
	}

	@RequestMapping(value = {"/workTask-{id}"}, method = RequestMethod.POST)
	public String postWorkTask(@PathVariable String id, @Valid TaskDto taskDto, BindingResult bindingResult,
			ModelMap model) {

		log.info("taskDto is:" + taskDto);
		try {
			activitiTaskService.workTaskById(taskDto);
			model.addAttribute("message", "The task has been completed successfully");
			return "common/success";
		} catch (Exception e) {
			model.addAttribute("message", "An error has occurred while processing task with id " + taskDto.getId()+ "Exception message is: "+ e.getMessage());
			return "common/error";
		}

	}

}