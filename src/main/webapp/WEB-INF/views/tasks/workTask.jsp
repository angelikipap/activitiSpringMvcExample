<%@ include file="/WEB-INF/views/common/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Activiti Spring MVC Example - Work Task</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="<c:url value='/static/js/common.js'/>"></script>
  <link href="<c:url value='/static/css/lavish-bootstrap.css' />" rel="stylesheet"></link>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
</head>
<body>
<!---------------------------------------------------- START OF HEADER ---------------------------------------------------------------------->	
	<%@ include file="/WEB-INF/views/common/mainMenu.jsp"%>
	<div class="container">
	  <h3>Work Task</h3>
	  <p><br></p>
	</div>
	<div class="container">
	 	<br> 
<!---------------------------------------------------- END OF HEADER ---------------------------------------------------------------------->
<!------- START OF WORKT TASK FORM -->				 			 	
		<form:form method="POST" modelAttribute="taskDto" class="form-horizontal">
	<!------- START OF  TASK INFO FIELDS -->				
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="id"><spring:message code="form.workTask.id"/></label>
					<div class="col-md-7">
						<form:input type="text" path="id" id="id" class="form-control input-sm" readonly="true"/>
						<div class="has-error">
							<form:errors path="id" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="name"><spring:message code="form.workTask.name"/></label>
					<div class="col-md-7">
						<form:input type="text" path="name" id="name" class="form-control input-sm"  readonly="true"/>
						<div class="has-error">
							<form:errors path="name" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="assignee"><spring:message code="form.workTask.assignee"/></label>
					<div class="col-md-7">
						<form:input type="text" path="assignee" id="assignee" class="form-control input-sm" readonly="true"/>
						<div class="has-error">
							<form:errors path="assignee" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="createdDate"><spring:message code="form.workTask.createdDate"/></label>
					<div class="col-md-7">
						<form:input type="text" path="createdDate" id="createdDate" class="form-control input-sm" readonly="true"/>
						<div class="has-error">
							<form:errors path="createdDate" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="viewRequest"><spring:message code="form.workTask.request"/></label>
					<div class="col-md-7">
						<a  href="<c:url value='/viewRequest-${taskDto.requestId}'/>"  class="btn btn-primary btn-sm"><spring:message code='form.workTask.viewRequest'/></a>
					</div>
				</div>
			</div>
			
		    <div class="row">
				<div class="form-group col-md-10">
					<hr>
				</div>
			</div>
			<!------- END OF  TASK INFO FIELDS -->
			<!------- START OF  INPUT FIELDS USED IN WORKING THE TASK -->
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-12 control-lable"><spring:message code="form.workTask.fillOutMessage"/></label>
				</div>
			</div>
		<!-- Start of fields for First Approval Task -->
			<c:if test = "${'approveFirst' == taskDto.definitionKey}">			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="isApprovedFirst"><spring:message code="form.workTask.approveRequestMsg"/>:</label>
					<div class="col-md-7" class="form-control input-sm">
						<form:checkbox path="isApprovedFirst" value="true" />
						<div class="has-error">
							<form:errors path="isApprovedFirst" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="needsSecondApproval"><spring:message code="form.workTask.needsSecondApproval"/>:</label>
					<div class="col-md-7" class="form-control input-sm">
						<form:checkbox path="needsSecondApproval" value="true" />
						<div class="has-error">
							<form:errors path="needsSecondApproval" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		<!------- END OF  INPUT FIELDS USED IN WORKING THE TASK -->
		</c:if>
		<!-- End of fields for Second Approval Task -->
		<!-- Start of fields for Second Approval Task -->
		<c:if test = "${'approveSecond' == taskDto.definitionKey}">	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="isApprovedSecond"><spring:message code="form.workTask.approveRequestMsg"/>:</label>
					<div class="col-md-7" class="form-control input-sm">
						<form:checkbox path="isApprovedSecond" value="true" />
						<div class="has-error">
							<form:errors path="isApprovedSecond" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		</c:if>
	<!-- End of fields for Second Approval Task -->
	<!-- Start of hidden fields -->
	<form:input type="hidden" path="definitionKey" id="definitionKey" class="form-control input-sm"/>


	<!-- End of hidden fields -->
<!---------------------------------------------------- START OF FOOTER ---------------------------------------------------------------------->			
		<div class="row">
			<div class="form-group col-md-10">
				<hr>
			</div>
		</div>
			
		<div class="row">
			<div class="form-group col-md-12">
				<div class="col-md-10">
				<a title="Back" class="btn btn-primary btn-sm" onclick="goBack()"> <spring:message code="form.common.goBack" /></a>
				<input type="submit" value='<spring:message code="form.common.submit" />' class="btn btn-primary btn-sm pull-right">
				<input type="reset" value='<spring:message code="form.common.reset" />' class="btn btn-primary btn-sm floatRightMargin">					
				</div>
			</div>
		</div>
<!---------------------------------------------------- END OF FOOTER ---------------------------------------------------------------------->
<!------- END OF WORKT TASK FORM -->		
		</form:form>
		</div>

</body>
</html>
