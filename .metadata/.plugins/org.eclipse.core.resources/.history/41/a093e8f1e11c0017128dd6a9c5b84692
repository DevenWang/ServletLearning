<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ProductForm</title>
<style type="text/css">
@import url(CSS/main.css);
</style>
</head>
<body>
	<div id="global">
		<h3>Add a product</h3>

		<c:if test="${requestScope.errors != null }">
			<p id="errors">Error(s)!
			<ul>
				<c:forEach items="${requestScope.errors }" var="error">
					<li>${error }</li>
				</c:forEach>
			</ul>
			</p>
		</c:if>

		<form action="product_save" method="post">
			<table>
				<tr>
					<td>product name:</td>
					<td><input type="text" name="productName" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><input type="text" name="description" /></td>
				</tr>
				<tr>
					<td>price:</td>
					<td><input type="text" name="price" /></td>
				</tr>
				<tr>
					<td><input type="reset" value="reset" /></td>
					<td><input type="submit" value="add product" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>