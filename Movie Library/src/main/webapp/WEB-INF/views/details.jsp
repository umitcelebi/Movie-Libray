<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

<c:if test="${empty roles}">
 Kayıt yok.
 
 </c:if>
 
 <c:if test="${not empty roles}">   
 
  <h2><spring:message code="Details"/></h2>          
  <table class="table table-hover">
    <thead>
    <tbody>
      <tr>
        <td>
	        <ul class="list-group">
			  <li class="list-group-item"><c:out value="Movie Name: "/> <c:out value="${roles.get(0).movie.movieName}"/></li>
			  <li class="list-group-item"><c:out value="Movie Year: "/> <c:out value="${roles.get(0).movie.year}"/></li>
			  <li class="list-group-item"><c:out value="Movie Genre: "/> <c:out value="${roles.get(0).movie.genre}"/></li>
			  <li class="list-group-item"><c:out value="Movie Describe: "/> <c:out value="${roles.get(0).movie.describetion}"/></li>
			  <li class="list-group-item"><c:out value="Movie Media: "/> <c:out value="${roles.get(0).movie.media}"/></li>
			</ul>
        </td>
        <td>
	        <table class="table table-striped">
	        <thead>
	        <tr>
	        <th>Actor Name</th>
	        <th>Role</th>
	        </tr>
	        </thead>
	        <tbody>
		        <c:forEach items="${roles}" var="role">
				<tr>
				<td><c:out value="${role.actor.actorName}"/> </td>
				<td><c:out value="${role.role}"/> </td>
        		<td><a href="deleterolebymovie?id=<c:out value="${role.movie.movieId}"/><c:out value="${role.actor.id}"/>"><spring:message code="Delete"/></a></td>
				<td></td>
				</tr>
				</c:forEach>
	        </tbody>
	        </table>
        </td>
      </tr>
      
    </tbody>
  </table>
  
   </c:if>
   
</div>



</body>
</html>