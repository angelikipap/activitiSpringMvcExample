<%@ include file="/WEB-INF/views/common/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Activiti Spring MVC Example - View Request Info</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="<c:url value='/static/js/common.js'/>"></script>
  <link href="<c:url value='/static/css/lavish-bootstrap.css' />" rel="stylesheet"></link>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/mainMenu.jsp"%>
	<div class="container">
	  <h3>View Request info</h3>
	  <p></p>
	</div>
	<div class="container">
	 		 	
		<form:form method="POST" modelAttribute="requestInfoEntity" class="form-horizontal">
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="form.submitRequest.firstName"/></label>
					<div class="col-md-7">
						<form:input type="text" path="firstName" id="firstName" class="form-control input-sm" readonly="true"/>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="lastName"><spring:message code="form.submitRequest.lastName"/></label>
					<div class="col-md-7">
						<form:input type="text" path="lastName" id="lastName" class="form-control input-sm" readonly="true"/>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="email"><spring:message code="form.submitRequest.email"/></label>
					<div class="col-md-7">
						<form:input type="text" path="email" id="email" class="form-control input-sm" readonly="true"/>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="requestBody"><spring:message code="form.submitRequest.requestBody"/></label>
					<div class="col-md-7">
						<form:textarea  rows="10" path="requestBody" id="requestBody" class="form-control input-sm" readonly="true"/>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<div class="col-md-3">
						<a title="Back" class="btn btn-primary btn-sm" onclick="goBack()"><spring:message code="form.common.goBack" /></a>
					</div>
				</div>
			</div>
	
		</form:form>
		</div>

</body>
</html>
