package com.examples.activitiSpringMvc.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.examples.activitiSpringMvc.model.RequestInfoEntity;

@Repository
public class RequestInfoDao extends BaseDao<RequestInfoEntity, Long> {

	public RequestInfoDao() {
		setClazz(RequestInfoEntity.class);
	}

	public RequestInfoEntity findByProcessInstanceId(String processInstId) {
		Query q = em
				.createNamedQuery("RequestInfoEntity.findByProcessInstanceId");
		q.setParameter("processInstanceId", processInstId);
		q.setMaxResults(1);
		List<RequestInfoEntity> list = q.getResultList();
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);

	}

}
