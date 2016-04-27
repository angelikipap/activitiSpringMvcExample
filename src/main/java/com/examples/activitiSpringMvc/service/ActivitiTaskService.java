package com.examples.activitiSpringMvc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.activiti.engine.FormService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.TaskUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examples.activitiSpringMvc.dao.RequestInfoDao;
import com.examples.activitiSpringMvc.dtos.TaskDto;
import com.examples.activitiSpringMvc.model.RequestInfoEntity;
import com.examples.activitiSpringMvc.utils.TaskCommonUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class ActivitiTaskService.
 */
@Service
public class ActivitiTaskService {

	/** The task service. */
	@Autowired
	private TaskService taskService;

	/** The request info dao. */
	@Autowired
	RequestInfoDao requestInfoDao;

	/** The form service. */
	@Autowired
	FormService formService;

	/** The log. */
	Logger log = Logger.getLogger(ActivitiTaskService.class);

	/**
	 * Gets the tasks by assignee.
	 *
	 * @param assignee the assignee
	 * @return the tasks by assignee
	 */
	@Transactional(value = "activitiTransactionManager")
	public List<Task> getTasksByAssignee(String assignee) {

		List<Task> tasks = taskService.createTaskQuery().taskAssigneeLikeIgnoreCase(assignee).orderByTaskCreateTime()
				.desc().list();

		return tasks;
	}

	/**
	 * Gets the tasks by a list of assignees.
	 *
	 * @param assignees the assignees
	 * @return the tasks by assignees
	 */
	@Transactional(value = "activitiTransactionManager")
	public List<TaskDto> getTasksByAssignees(List<String> assignees) {
		List<Task> tasks = new ArrayList<Task>();

		// append the tasks of each assignee to the list
		Iterator<String> assigneesIter = assignees.iterator();

		while (assigneesIter.hasNext()) {

			String assignee = assigneesIter.next();
			tasks.addAll(taskService.createTaskQuery().taskAssigneeLikeIgnoreCase(assignee).orderByTaskCreateTime()
					.desc().list());
		}

		List<TaskDto> tasksDtos = new ArrayList<TaskDto>();

		// discard the tasks that are not correlated with a requestInfoEntity
		// object
		Iterator<Task> tasksIter = tasks.iterator();

		while (tasksIter.hasNext()) {
			Task task = tasksIter.next();
			RequestInfoEntity requestInfo = requestInfoDao.findByProcessInstanceId(task.getProcessInstanceId());
			if (null != requestInfo) {
				TaskDto taskDto = new TaskDto();
				taskDto = TaskCommonUtils.convertTaskToDto(task, requestInfo);
				tasksDtos.add(taskDto);
			}
		}

		return tasksDtos;

	}

	/**
	 * Gets the task dto by id.
	 *
	 * @param taskId the task id
	 * @return the task dto by id
	 */
	@Transactional
	public TaskDto getTaskDtoById(String taskId) {
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		RequestInfoEntity requestInfo = requestInfoDao.findByProcessInstanceId(task.getProcessInstanceId());
		log.info("requestInfo" + requestInfo);
		return TaskCommonUtils.convertTaskToDto(task, requestInfo.getId());
	}

	/**
	 * Work a task by it's id.
	 *
	 * @param taskDto the task dto
	 * @throws Exception the exception
	 */
	@Transactional
	public void workTaskById(TaskDto taskDto) throws Exception {

		Map<String, String> properties = new HashMap<String, String>();
		switch (taskDto.getDefinitionKey()) {
		case "approveFirst":
			properties.put("isApprovedFirst", taskDto.getIsApprovedFirst().toString());
			properties.put("needsSecondApproval", taskDto.getNeedsSecondApproval().toString());
			break;
		case "approveSecond":
			properties.put("isApprovedSecond", taskDto.getIsApprovedSecond().toString());
			break;
		default:
			log.info("An error hasccurred on switching to task type");
			throw new Exception("An error has occurred on switching to task type");
		}
		formService.saveFormData(taskDto.getId(), properties);
		taskService.complete(taskDto.getId());

	}

}
