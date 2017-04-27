<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, tr, td {
	border: 1px solid brown;
}
</style>
</head>
<body>
	<dir>
		<table>
			<c:forEach items="${requestScope.infos }" var="info">
				<tr>
					<td>${info.key }:</td>
					<td>${info.value }</td>
				</tr>
			</c:forEach>
			<tr>
				<td><c:if test="${fileName!=null }">
				文件名：
				</c:if></td>
				<td>${fileName }</td>
			</tr>
			<tr>
				<td><c:if test="${size!=null}">
				文件大小：
				</c:if></td>
				<td>${size }</td>
			</tr>
			<tr>
				<td>上传作者：</td>
				<td>${requestScope.author }</td>
			</tr>
		</table>
	</dir>
</body>
</html>