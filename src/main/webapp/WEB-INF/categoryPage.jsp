<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> <c:out value="${categories.name}"/> </h1>
<a href="/">Home</a>

<p>Products</p>
<ul>
	<c:forEach var="p" items="${aProducts}">
		<li>
			<c:out value="${p.name}"/>
		</li>
	</c:forEach>
</ul> <br/>

<p>Add Product:</p>

<form action="/categories/${categories.id}" method ="post" >
	<select name="productId" id="productId">
		<c:forEach var ="uProd" items="${uProducts}">
			<option value="${uProd.id}">
				<c:out value="${uProd.name}"/>
			</option>
		</c:forEach>
	</select>
	<button>Submit</button>
</form>

</body>
</html>