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

	<h1>Home Page</h1>

	<div>
		<a href="/products/new">New Product</a> <a href="/categories/new">New Category</a>
	</div>

	<br />

	<table>
		<thead>
			<tr>
				<td>Products</td>
				<td>Categories</td>
			</tr>
		</thead>

		<tbody>
			<!-- Place for:Each here -->
			<tr>
				<!-- First TD is for Products -->
				<td>
					<c:forEach var="p" items="${newProduct}">
						<ul>
							<li><a href="/products/${p.id}"> <c:out value="${p.name}"/> </a></li>
						</ul>
					</c:forEach>
				</td>
				<!-- Second TD is for Categories -->
				<td>
					<c:forEach var="c" items="${newCategory}">
						<ul>
							<li><a href="/categories/${c.id}"> <c:out value="${c.name}"/> </a></li>
						</ul>
					</c:forEach>
				</td>
			</tr>

		</tbody>

	</table>


</body>
</html>