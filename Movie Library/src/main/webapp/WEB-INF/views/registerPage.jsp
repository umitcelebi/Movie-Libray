<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Register</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

	<h2>Register</h2>
	<form:form class="form-horizontal" action="register" modelAttribute="user" method="POST">
 	
 	<div class="form-group">
      <label class="control-label col-sm-2" for="userName">Username</label>
      <div class="col-sm-10">
        <form:input path="userName" class="form-control" id="useranme" 
        placeholder="Enter username" name="useranme" required="required"/>
      </div>
    </div>
	<label class="label label-danger">${mesaj}</label>
	<div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Password</label>
      <div class="col-sm-10">          
        <form:password path="password" class="form-control" id="password" 
        placeholder="Enter password" name="password" required="required"/>
      </div>
    </div>
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <form:button class="btn btn-default">Register</form:button>
      </div>
    </div>
    
	</form:form>
  
</div>

</body>
</html>