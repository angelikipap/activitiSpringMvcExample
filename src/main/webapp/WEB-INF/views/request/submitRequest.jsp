<%@ include file="/WEB-INF/views/common/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Activiti Spring MVC Example - Submit Request</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="<c:url value='/static/css/lavish-bootstrap.css' />" rel="stylesheet"></link>
  <script src="<c:url value='/static/js/common.js'/>"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
</head>
<body>
<!---------------------------------------------------- START OF HEADER ---------------------------------------------------------------------->	
	
	<%@ include file="/WEB-INF/views/common/mainMenu.jsp"%>
	<div class="container">
	  <h3>Submit Request</h3>
	  <p>Here you can submit a new request</p>
	</div>
	
<!---------------------------------------------------- END OF HEADER ---------------------------------------------------------------------->
		
<!------- START OF SUBMIT REQUEST FORM -->	
	<div class="container">	 		 	
		<form:form method="POST" modelAttribute="requestInfoEntity" class="form-horizontal">
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName"><spring:message code="form.submitRequest.firstName"/>:</label>
					<div class="col-md-7">
						<form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="firstName" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="lastName"><spring:message code="form.submitRequest.lastName"/>:</label>
					<div class="col-md-7">
						<form:input type="text" path="lastName" id="lastName" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="lastName" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="email"><spring:message code="form.submitRequest.email"/>:</label>
					<div class="col-md-7">
						<form:input type="text" path="email" id="email" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="email" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="requestBody"><spring:message code="form.submitRequest.requestBody"/>:</label>
					<div class="col-md-7">
						<form:textarea rows="10" path="requestBody" id="requestBody" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="requestBody" class="help-inline"/>
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
						<a title="Back" class="btn btn-primary btn-sm" onclick="goBack()"><spring:message code="form.common.goBack" /></a>
						<input type="submit" value='<spring:message code="form.common.submit" />' class="btn btn-primary btn-sm pull-right">
						<input type="reset" value='<spring:message code="form.common.reset" />' class="btn btn-primary btn-sm floatRightMargin">					
					</div>
				</div>
			</div>
<!---------------------------------------------------- END OF FOOTER ------------------------------------------------------------------------>
		</form:form>
	</div>
<!------- END OF SUBMIT REQUEST FORM -->		

</body>
</html>
