package com.examples.activitiSpringMvc.dtos;

import java.util.Date;



public class TaskDto implements  Comparable<TaskDto> {

	private String id;
	private String name;
	private String assignee;
	private Date createdDate;
	private String processInstanceId;
	private String definitionKey;
	private Boolean needsSecondApproval;
	private Boolean isApprovedFirst;
	private Boolean isApprovedSecond;
	private long requestId;
	private String requestorFirstname;
	private String requestorLastname;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean getNeedsSecondApproval() {
		return needsSecondApproval;
	}

	public void setNeedsSecondApproval(Boolean needsSecondApproval) {
		this.needsSecondApproval = needsSecondApproval;
	}

	public Boolean getIsApprovedFirst() {
		return isApprovedFirst;
	}

	public void setIsApprovedFirst(Boolean isApprovedFirst) {
		this.isApprovedFirst = isApprovedFirst;
	}


	public Boolean getIsApprovedSecond() {
		return isApprovedSecond;
	}

	public void setIsApprovedSecond(Boolean isApprovedSecond) {
		this.isApprovedSecond = isApprovedSecond;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public String getDefinitionKey() {
		return definitionKey;
	}

	public void setDefinitionKey(String definitionKey) {
		this.definitionKey = definitionKey;
	}
	
	public String getRequestorFirstname() {
		return requestorFirstname;
	}

	public void setRequestorFirstname(String requestorFirstname) {
		this.requestorFirstname = requestorFirstname;
	}

	public String getRequestorLastname() {
		return requestorLastname;
	}

	public void setRequestorLastname(String requestorLastname) {
		this.requestorLastname = requestorLastname;
	}

	@Override
	public String toString() {
		return "TaskDto [id=" + id + ", name=" + name + ", assignee=" + assignee + ", createdDate=" + createdDate
				+ ", processInstanceId=" + processInstanceId + ", definitionKey=" + definitionKey
				+ ", needsSecondApproval=" + needsSecondApproval + ", isApprovedFirst=" + isApprovedFirst
				+ ", isApprovedSecond=" + isApprovedSecond + ", requestId=" + requestId + ", requestorFirstname="
				+ requestorFirstname + ", requestorLastname=" + requestorLastname + "]";
	}

	@Override
	public int compareTo(TaskDto o) {
		return getCreatedDate().compareTo(o.getCreatedDate());

	}





}
