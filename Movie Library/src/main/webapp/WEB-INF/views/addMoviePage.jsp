<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Add</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
</head>
<body>
<a href="allmovies" class="btn btn-primary" role="button">BACK</a>

<div class="container">

	<h2>Add Movie</h2>
	<form:form class="form-horizontal" action="addmovie" modelAttribute="movie" method="POST">
 	
 	<div class="form-group">
      <label class="control-label col-sm-2" for="movieId">Movie ID</label>
      <div class="col-sm-7">
        <form:input path="movieId" class="form-control" id="movieId" 
        name="movieId" value="${upMovie.movieId}" readonly="true"/>
      </div>
    </div>
    
 	<div class="form-group">
      <label class="control-label col-sm-2" for="movieName">Movie Name</label>
      <div class="col-sm-7">
        <form:input path="movieName" class="form-control" id="movieName" 
        placeholder="Enter movieName" name="movieName" value="${upMovie.movieName}" required="required"/>
      </div>
    </div>
	
	<div class="form-group">
      <label class="control-label col-sm-2" for="Year">Movie Year</label>
      <div class="col-sm-7">          
        <form:input path="year" class="form-control" id="year" 
        placeholder="Enter year" name="year" value="${upMovie.year}" required="required"/>
      </div>
    </div>
    
	<div class="form-group">
      <label class="control-label col-sm-2" for="genre">Movie_Genre</label>
      <div class="col-sm-7">          
        <form:input path="genre" class="form-control" id="genre" 
        placeholder="Enter genre" name="genre" value="${upMovie.genre}" required="required"/>
      </div>
    </div>
    
	<div class="form-group">
      <label class="control-label col-sm-2" for="describetion">Movie Describe</label>
      <div class="col-sm-7">          
        <form:input path="describetion" class="form-control" id="describetion" 
        placeholder="Enter describe" name="describetion" value="${upMovie.describetion}"/>
      </div>
    </div>
    
    
	<div class="form-group">
      <label class="control-label col-sm-2" for="media">Movie Media</label>
      <div class="col-sm-7">          
        <form:input path="media" class="form-control" id="media" 
        placeholder="Enter media" name="media" value="${upMovie.media}" required="required"/>
      </div>
    </div>
       
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <form:button class="btn btn-default">SEND</form:button>
      </div>
    </div>
    
	</form:form>
  
</div>

</body>
</html>