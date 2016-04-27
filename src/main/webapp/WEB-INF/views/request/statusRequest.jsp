<%@ include file="/WEB-INF/views/common/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Activiti Spring MVC Example - Status Request</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="<c:url value='/static/js/common.js'/>"></script>
  <link href="<c:url value='/static/css/lavish-bootstrap.css' />" rel="stylesheet"></link>
  <script src="<c:url value='/static/js/common.js'/>"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

 <%@ include file="/WEB-INF/views/common/mainMenu.jsp"%>
<div class="container">
  <h3>Request Status</h3>
	<p>Here you can see and work on the pending tasks</p>
	<table id="tasksTable" class="table table-responsive table-hover">
		<thead>
			<tr class="row">
		        <th class="col-md-3"><spring:message code="form.viewTasks.taskId"/></th>
		        <th class="col-md-4"><spring:message code="form.viewTasks.taskName"/></th>
		        <th class="col-md-4"><spring:message code="form.viewTasks.taskAssignee"/></th>
				<th class="col-md-3"><spring:message code="form.viewTasks.workTask"/></th>
			</tr>
		</thead>
		<tbody>
	        <c:forEach var="task" items="${requestInfoEntities}">
	        
				<tr class="row">
					<td class="col-md-3">${requestInfoEntity.id}</td>
					<td class="col-md-4">${requestInfoEntity.firstName}</td>
					<td class="col-md-4">${requestInfoEntity.lastName}</td>
					<td class="col-md-3"><a href="<c:url value='/statusRequest/viewProcessStatus-${requestInfoEntity.id}'/>" class="btn btn-primary btn-sm">View</a></td> 
				</tr>
	        </c:forEach>
	        <c:if test="${empty tasks}">
	        	<tr>
	        		<td><spring:message code="form.viewTasks.noTasks"/></td>
	        	</tr>
	        </c:if>
        </tbody>
    </table>
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
