<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Single file upload</title>
</head>
<body>
	<h1>单个文件上传</h1>
	<form action="singleUpload" method="post" enctype="multipart/form-data">
		作者：<input type="text" name="author" /><br /> 
		选择上传文件：<input type="file" name="fileName" /><br />
		<input type="submit" value="上传">
	</form>
</body>
</html>