<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Add Actor</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
</head>
<body>
<a href="allmovies" class="btn btn-primary" role="button">BACK</a>

<div class="container">

<table>
<tbody>
<tr>
<td>
<h2>Add Actor</h2>
	<form:form class="form-horizontal" action="addactor" modelAttribute="actor" method="POST">
 	
 	<div class="form-group">
      <label class="control-label col-sm-2" for="id">Actor ID</label>
      <div class="col-sm-7">
        <form:input path="id" class="form-control" id="id" 
        name="id" value="${upActor.id}" readonly="true"/>
      </div>
    </div>
    
 	<div class="form-group">
      <label class="control-label col-sm-2" for="actorName">Actor Name</label>
      <div class="col-sm-7">
        <form:input path="actorName" class="form-control" id="actorName" 
        placeholder="Enter Actor Name" name="actorName" value="${upActor.actorName}" required="required"/>
      </div>
    </div>


    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <form:button class="btn btn-success">SEND</form:button>
      </div>
    </div>
    
	</form:form>
</td>

<td>
<h2>Add Role</h2>
	<form:form class="form-horizontal" action="addrole" modelAttribute="role" method="POST">
 	
 	<div class="form-group">
      <label class="control-label col-sm-2" for="movieName">Movie</label>
      <div class="col-sm-7">
        <form:select path="movie.movieId" items="${movies}" itemValue="movieId" itemLabel="movieName"></form:select>
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="actorName">Actor</label>
      <div class="col-sm-7">
        <form:select path="actor.id" class="col-sm-12" items="${actors}" itemValue="id" itemLabel="actorName"></form:select>
      </div>
    </div>
    
 	<div class="form-group">
      <label class="control-label col-sm-2" for="actorName">Role</label>
      <div class="col-sm-7">
        <form:input path="role" class="form-control" id="role" 
        placeholder="Enter Role" name="role"/>
      </div>
    </div>


    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <form:button class="btn btn-success">SEND</form:button>
      </div>
    </div>
    
	</form:form>
</td>
</tr>
</tbody>
</table>

	
</div>


<div class="container">

<div class="container">
  <h2>Actors</h2>         
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Actor ID</th>
        <th>Actor Name</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${actors}" var="a">
      <tr>
        <td><c:out value="${a.id}"></c:out> </td>
        <td><c:out value="${a.actorName}"></c:out> </td>
        <td><a class="btn btn-danger" href="deleteactor?id=<c:out value="${a.id}"></c:out> ">Sil</a></td>
        <td><a href="updateactor?id=<c:out value="${a.id}"></c:out> ">Düzenle</a></td>
      </tr>
    </c:forEach> 
    </tbody>
  </table>
</div>

</div>



</body>
</html>