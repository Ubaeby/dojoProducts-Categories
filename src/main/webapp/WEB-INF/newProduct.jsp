<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>New Product</h1>
<a href="/">Home</a>

<br/>

<form:form action="/products/new" method="post" modelAttribute="newProduct">
	<form:label path="name">Name: </form:label>
	<form:errors path="name"/>
	<form:input path="name"/>
	
	<form:label path="description">Description: </form:label>
	<form:errors path="description"/>
	<form:input path="description"/>
	
	<form:label path="price">Price: </form:label>
	<form:errors path="price"/>
	<form:input type="numbers" path="price"/>
	
	<button>Submit</button>

</form:form>
</body>
</html>