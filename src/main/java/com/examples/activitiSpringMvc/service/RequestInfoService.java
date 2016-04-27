package com.examples.activitiSpringMvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import com.examples.activitiSpringMvc.dao.RequestInfoDao;
import com.examples.activitiSpringMvc.model.RequestInfoEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestInfoService.
 */
@Service
public class RequestInfoService {

	/** The request info dao. */
	@Autowired
	RequestInfoDao requestInfoDao;
	
	/** The activiti runtime service. */
	@Autowired
	ActivitiRuntimeService activitiRuntimeService;

	/**
	 * Submit request.
	 *
	 * @param requestInfo the request info
	 */
	@Transactional("asmTransactionManager")
	public void submitRequest(RequestInfoEntity requestInfo) {
		String processInstanceId = activitiRuntimeService.startProcessInstanceByKey("approveRequestProcess");
		requestInfo.setProcessInstanceId(processInstanceId);
		requestInfoDao.save(requestInfo);
	}

	/**
	 * Find a request.
	 *
	 * @param id the id
	 * @return the request info entity
	 */
	@Transactional("asmTransactionManager")
	public RequestInfoEntity findRequest(long id) {
		return (RequestInfoEntity) requestInfoDao.find(id);

	}

	/**
	 * Find all requests.
	 *
	 * @return the list
	 */
	@Transactional("asmTransactionManager")
	public List<RequestInfoEntity> findAllRequests() {
		return requestInfoDao.findAll();
	}

	/**
	 * Find a request and set it on model.
	 *
	 * @param model the model
	 * @param id the id
	 */
	@Transactional("asmTransactionManager")
	public void findRequest(ModelMap model, long id) {
		RequestInfoEntity requestInfoEntity = requestInfoDao.find(id);
		model.addAttribute("requestInfoEntity", requestInfoEntity);
	}

}
