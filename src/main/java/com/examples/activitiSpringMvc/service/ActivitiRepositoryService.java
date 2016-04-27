package com.examples.activitiSpringMvc.service;

import org.activiti.engine.RepositoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


// TODO: Auto-generated Javadoc
/**
 * The Class ActivitiRepositoryService.
 */
@Service
public class ActivitiRepositoryService {
	
	/** The repository service. */
	@Autowired
	RepositoryService repositoryService;
	
	/** The log. */
	private static Logger log = Logger.getLogger(ActivitiRepositoryService.class);

	/**
	 * Deploys approveRequestProcess.
	 */
	@Transactional(value = "activitiTransactionManager")
	public void deployApproveRequestProcess() {
		log.info("Starting deployment of approveRequestProcess");
		repositoryService.createDeployment().addClasspathResource("diagrams/ApproveRequest.bpmn").name("approveRequestProcess").deploy();
	}

}
