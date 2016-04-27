	
	1. This is a demo project with:
		1.1 Spring Framework 4.2.5
		1.2 Activiti 5.18.0
		1.3 Hibernate 4.3.5
		1.4 Hibernate Validator 5.1.2
		1.5 Bootstrap 3 3.0.2


	2.Installation Prerequisites
		2.1 MySQL Server
		2.2 Maven
		2.3 Apache Tomcat or Pivotal tc Server

	3.	Installation instructions:
		3.1 create a schema with name "asm" and utf8 collation in MySQL Server
		3.2 create a schema with name "activiti" and utf8 collation in MySQL Server
		3.3 update application.properties files with appropriate username/password/jdbc url
		3.3 build the project with maven 
		3.4 deploy the war on Apache Tomcat or Pivotal tc Server
		
	4. Main Use case
		4.1 Open landing page
		4.2 Deploy a process
			4.2.1 Click on "Deploy Process" button.
			4.2.2 Select "ApproveRequest Process".
			4.2.3 Click "Deploy" Button.
			4.2.4 You should see "ApproveRequest process definition has been deployed successfully" message. The process has been now deployed on Activiti engine.
		4.3 Submit a Request
			4.3.1 Click on "Submit Request"  button.
			4.3.2 Fill in the fields of the request form.
			4.3.3 Click "Submit" button.
			4.3.4 You should see "Your request has been submitted successfully." message. The request has been submitted and a a process instance of "ApproveRequest process" has been started and correlated with this request.
		4.4 Work a task
			4.4.1 Click on "View Tasks" button.
			4.4.2 A task named "	approve First" should have been opened. Click on "Work task" button of this task.
			4.4.3 Check on "Approve request" checkbox.
			4.4.4 If the request needs a second approval as well check "The task need second approval?:" checkbox as well.
				  a) If  "task need second approval" checkbox is checked.
				  	4.4.5 Click "Submit" button. You should see "The task has been completed successfully." message.
					4.4.6 Click on "View Tasks" button.
					4.4.7 A task named "	approve Second" should have been opened. Click on "Work task" button of this task.
					4.4.8 Check on "Approve request" checkbox.
					4.4.9  Click "Submit" button. You should see "The task has been completed successfully." message. The process instance has been completed.
				  b)If  "task need second approval" checkbox is not checked.
				  	4.4.5 Click "Submit" button. You should see "The task has been completed successfully." message.The process instance has been completed.
			
			
			
			
		
			
			
		