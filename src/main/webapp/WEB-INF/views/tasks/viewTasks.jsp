<%@ include file="/WEB-INF/views/common/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Activiti Spring MVC Example - View Tasks</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="<c:url value='/static/js/common.js'/>"></script>
	<link href="<c:url value='/static/css/lavish-bootstrap.css' />" rel="stylesheet"></link>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.11/css/jquery.dataTables.css">
  	<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.11/js/jquery.dataTables.js"></script>
	<script src="https://cdn.datatables.net/responsive/1.0.4/js/dataTables.responsive.js"></script>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/responsive/1.0.4/css/dataTables.responsive.css"></link>
	<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
</head>

<body>
<!-- Start of initialization of taskTable datatable -->
	
	<script>
		$(document).ready(function() {
		    $('#tasksTable').dataTable({
		    	"responsive": true,
		    	"columns" : [ {
						"orderable" : true
						}, {
						"orderable" : true
						}, {
						"orderable" : true
						}, {
						"orderable" : true
						}, {
						"orderable" : false
						} ],
				"aaSorting" : [],
		    	
		    });
		} );				
	</script>
	
<!-- End of initialization of taskTable datatable -->	

<%@ include file="/WEB-INF/views/common/mainMenu.jsp"%>
<div class="container">
	<h3>View Tasks</h3>
	<p>Here you can see and work on the pending tasks</p>
	<div class="container">
	<table id="tasksTable" class="table table-responsive table-hover">
		<thead>
			<tr>
		        <th class="col-md-3"><spring:message code="form.viewTasks.taskId"/></th>
		        <th class="col-md-3"><spring:message code="form.viewTasks.createdDate"/></th>
		        <th class="col-md-4"><spring:message code="form.viewTasks.taskName"/></th>
		        <th class="col-md-4"><spring:message code="form.viewTasks.taskAssignee"/></th>
				<th class="col-md-3"><spring:message code="form.viewTasks.workTask"/></th>
			</tr>
		</thead>
		<tbody>
	        <c:forEach var="task" items="${tasksDtos}">
	        
				<tr>
					<td class="col-md-3">${task.id}</td>
					<td class="col-md-4">${task.createdDate}</td>
					<td class="col-md-4">${task.name}</td>
					<td class="col-md-4">${task.assignee}</td>
					<td class="col-md-3"><a href="<c:url value='/viewTasks/workTask-${task.id}'/>" class="btn btn-primary btn-sm">Work</a></td> 
				</tr>
	        </c:forEach>
        </tbody>
    </table>
    </div>
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
