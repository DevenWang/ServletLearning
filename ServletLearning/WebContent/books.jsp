<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>book list</title>
<style type="text/css">
table, tr, td {
	border: 1px solid brown;
}
</style>
</head>
<body>
	books in simple table
	<table>
		<tr>
			<td>ISBN</td>
			<td>Title</td>
		</tr>
		<c:forEach items="${requestScope.books}" var="book">
			<tr>
				<td>${book.isbn}</td>
				<td>${book.title}</td>
			</tr>
		</c:forEach>
	</table>
	<br /> books in style table
	<table>
		<tr style="background: #ababff">
			<td>ISBN</td>
			<td>Title</td>
		</tr>
		<c:forEach items="${books}" var="book" varStatus="status">
			<c:if test="${staus.count%2 == 0 }">
				<tr style="background: #eeeeff">
			</c:if>
			<c:if test="${status.count%2 != 0 }">
				<tr style="background: #dedeff">
			</c:if>
			<td>${book.isbn }</td>
			<td>${book.title }</td>
			</tr>
		</c:forEach>
	</table>

	<br /> ISBN only:
	<c:forEach items="${books}" var="book" varStatus="status">
		${book.isbn}
		<c:if test="${!status.last }">,</c:if>
	</c:forEach>

</body>
</html>