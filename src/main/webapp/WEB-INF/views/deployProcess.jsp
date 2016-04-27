<%@ include file="/WEB-INF/views/common/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Activiti Spring MVC Example - Deploy Process</title>
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
  <h3>Deploy Process</h3>
  <p>Here you can select a process from the list and deploy it.</p>
  <div class="has-error">
  	<p class=>${message}</p>
  </div>
  
<!----------------------------------------------------END OF HEADER ---------------------------------------------------------------------->	  
  	<div class="container">
<!-- START OF DEPLOY PROCESS FORM -->	 		 	
		<form:form method="POST" modelAttribute="deployProcessDto" class="form-horizontal">
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="processes"><spring:message code="form.deployProcess.instructions"/>:</label>
					<div class="col-md-7">
						<form:select path="processName" class="form-control input-sm">
	    					<form:option value="" label="" />
	    					<form:options items="${processes}" />
						</form:select>
						<%-- <form:select path="processName" items="${processes}" class="form-control input-sm"/> --%>
						<div class="has-error">
							<form:errors path="processName" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
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
				<input type="submit" value='<spring:message code="form.deployProcess.deploy" />' class="btn btn-primary btn-sm pull-right">
				<input type="reset" value='<spring:message code="form.common.reset" />' class="btn btn-primary btn-sm floatRightMargin">					
				</div>
			</div>
		</div>
<!---------------------------------------------------- END OF FOOTER ---------------------------------------------------------------------->	
<!-- END OF DEPLOY PROCESS FORM -->	
		</form:form>
		</div>
  
</div>

</body>
</html>
