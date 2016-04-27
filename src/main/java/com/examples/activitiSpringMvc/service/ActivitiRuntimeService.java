package com.examples.activitiSpringMvc.service;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class ActivitiRuntimeService.
 */
@Service
public class ActivitiRuntimeService {
	
	/** The runtime service. */
	@Autowired
	private RuntimeService runtimeService;
	
	/** The log. */
	private final Logger log = Logger.getLogger(ActivitiRuntimeService.class);

	
	/**
	 * Start a process instance by process key.
	 *
	 * @param key the key
	 * @return the string
	 */
	public String startProcessInstanceByKey(String key){
		String processInstanceId= "noProcessStarted";
		try{
		ProcessInstance processInstance =runtimeService.startProcessInstanceByKey(key);
		processInstanceId =processInstance.getProcessInstanceId();
		}
		catch (Exception e){
			log.info("An exception occurred while starting process " + key);
		}
		return processInstanceId;
	}
}
