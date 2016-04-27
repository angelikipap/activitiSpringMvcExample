package com.examples.activitiSpringMvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examples.activitiSpringMvc.dao.RequestInfoDao;
import com.examples.activitiSpringMvc.dao.StatusRequestDto;
import com.examples.activitiSpringMvc.model.RequestInfoEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class StatusRequestService.
 */
@Service
public class StatusRequestService {

	/** The request info dao. */
	@Autowired
	RequestInfoDao requestInfoDao;
	
	/** The activiti runtime service. */
	@Autowired
	ActivitiRuntimeService activitiRuntimeService;


	/**
	 * Find request.
	 *
	 * @param id the id
	 * @return the request info entity
	 */
	@Transactional("asmTransactionManager")
	public RequestInfoEntity findRequest(long id) {
		return (RequestInfoEntity) requestInfoDao.find(id);

	}
}
