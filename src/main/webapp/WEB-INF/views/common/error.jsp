<%@ include file="/WEB-INF/views/common/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="<c:url value='/static/js/common.js'/>"></script>
	<link href="<c:url value='/static/css/lavish-bootstrap.css' />" rel="stylesheet"></link>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<body>

	 <%@ include file="/WEB-INF/views/common/mainMenu.jsp"%>
	<div class="container">
		<p>
			<br>${message}.
		</p>
<!---------------------------------------------------- START OF FOOTER ---------------------------------------------------------------------->			
		<div class="row">
			<div class="form-group col-md-12">
				<hr>
			</div>
		</div>
			
		<div class="row">
			<div class="form-group col-md-12">
				<a title="Back" class="btn btn-primary btn-sm" onclick="goBack()"> <spring:message code="form.common.goBack" /></a>			
			</div>
		</div>
<!---------------------------------------------------- END OF FOOTER ---------------------------------------------------------------------->							
					
	</div>

</body>
</html>
