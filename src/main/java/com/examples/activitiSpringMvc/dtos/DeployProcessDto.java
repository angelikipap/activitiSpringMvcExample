package com.examples.activitiSpringMvc.dtos;

import org.hibernate.validator.constraints.NotEmpty;

public class DeployProcessDto {
	
	@NotEmpty
	private String processName;

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

}
