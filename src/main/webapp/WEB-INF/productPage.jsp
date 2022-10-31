<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1><c:out value="${products.name}"/></h1>

<a href="/">Home</a>
<br/> 

<p>Categories: </p>

<ul>
	<c:forEach var = "added" items="${aCategories}" >
		<li>
			<c:out value="${added.name}"/>
		</li>
	</c:forEach>
</ul>
<br/>

<p>Add Category:</p>

<!-- 	Since There is no modelAttribute in your postRequest, you'll have to use a normal form -->

<form action="/products/${products.id}" method="post">
	<select name="categoryId" id="categoryId">
		<c:forEach var="uCat" items="${uCategories}">
			<option value="${uCat.id}">
				<c:out value="${uCat.name}"/>
			</option>
		</c:forEach>
	</select>
	<button>Submit</button>
</form>
</body>
</html>