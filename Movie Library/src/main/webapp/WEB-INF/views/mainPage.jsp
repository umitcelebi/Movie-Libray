<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title><spring:message code="Movies"/></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>

<div class="container">
<a href="allmovies" class="btn btn-success" role="button">All_Movies</a>
<a href="addmoviepage" class="btn btn-info" role="button">Add_Movie</a>
<a href="actors" class="btn btn-warning" role="button">Add_Actor</a>
</div>
<hr>
<div class="container">

<form:form class="form-inline" action="moviebyname" modelAttribute="movie" method="GET">
  <div class="form-group mb-2">
    <label for="movie.name" class="control-label col-sm-3">Name:</label>
    <form:input path="movieName" class="form-control" id="movie.name" name="movie.name"/>
  </div>
  <form:button class="btn btn-default">Search</form:button>
</form:form>

<form:form class="form-inline" action="moviebygenre" modelAttribute="movie" method="GET">
  <div class="form-group mb-2">
    <label for="movie.genre" class="control-label col-sm-3">Genre:</label>
    <form:input path="genre" class="form-control" id="movie.genre"/>
  </div>
  <button type="submit" class="btn btn-primary mb-2">Search</button>
</form:form>
</div>

<hr>

<div class="container">
  <h2>Movies</h2>            
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Movie ID</th>
        <th>Movie Name</th>
        <th><a href="orderbyyear">Movie Year</a></th>
        <th>Movie Genre</th>
        <th>Movie Describe</th>
        <th>Movie Media</th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach items="${movies}" var="m">
      <tr>
        <td><c:out value="${m.movieId}"></c:out> </td>
        <td><c:out value="${m.movieName}"></c:out> </td>
        <td><c:out value="${m.year}"></c:out> </td>
        <td><c:out value="${m.genre}"></c:out> </td>
        <td><c:out value="${m.describetion}"></c:out> </td>
        <td><c:out value="${m.media}"></c:out> </td>
        <td><a class="btn btn-danger" href="deletemovie?id=<c:out value="${m.movieId}"></c:out> "><spring:message code="Delete"/>Delete</a></td>
        <td><a href="updatemovie?id=<c:out value="${m.movieId}"></c:out> "><spring:message code="Edit"/>Edit</a></td>
        <td><a href="searchbymovie?id=<c:out value="${m.movieId}"></c:out> "><spring:message code="Details"/>Details</a></td>
      </tr>
    </c:forEach> 
    </tbody>
  </table>
</div>


</body>
</html>