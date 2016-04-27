package com.examples.activitiSpringMvc.utils;

import org.activiti.engine.task.Task;

import com.examples.activitiSpringMvc.dtos.TaskDto;
import com.examples.activitiSpringMvc.model.RequestInfoEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class TaskCommonUtils.
 */
public final class TaskCommonUtils {

	/**
	 * Convert a task to a taskdto.
	 *
	 * @param task the task
	 * @param requestId the request id
	 * @return the task dto
	 */
	public static TaskDto convertTaskToDto(Task task, long requestId) {
		TaskDto taskDto = new TaskDto();
		
		taskDto.setId(task.getId());
		taskDto.setName(task.getName());
		taskDto.setCreatedDate(task.getCreateTime());
		taskDto.setAssignee(task.getAssignee());
		taskDto.setProcessInstanceId(task.getProcessInstanceId());
		taskDto.setRequestId(requestId);
		taskDto.setDefinitionKey(task.getTaskDefinitionKey());
		return taskDto;
	}
	
	/**
	 * Convert a task to a taskdto.
	 *
	 * @param task the task
	 * @param requestInfo the request info
	 * @return the task dto
	 */
	public static TaskDto convertTaskToDto(Task task, RequestInfoEntity requestInfo) {
		TaskDto taskDto = new TaskDto();
		
		taskDto.setId(task.getId());
		taskDto.setName(task.getName());
		taskDto.setCreatedDate(task.getCreateTime());
		taskDto.setAssignee(task.getAssignee());
		taskDto.setProcessInstanceId(task.getProcessInstanceId());
		taskDto.setRequestId(requestInfo.getId());
		taskDto.setDefinitionKey(task.getTaskDefinitionKey());
		taskDto.setRequestorFirstname(requestInfo.getFirstName());
		taskDto.setRequestorLastname(requestInfo.getLastName());
		return taskDto;
	}

}
