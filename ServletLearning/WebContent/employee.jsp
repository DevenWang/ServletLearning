<html>
<head>
<title>Employee</title>
</head>
<body>
	accept-language: ${header['accept-language']}
	<br /> session id: ${pageContext.session.id}
	<br /> employee: ${employee.name},${employee.address.city}
	<br /> capital: ${capitals["Canada"]}
	<br /> requestURL: ${pageContext.request.requestURL}
	<br /> requestURI: ${pageContext.request.requestURI}
	<br /> servletPath: ${pageContext.request.servletPath}
	<br /> pathInfo: ${pageContext.request.pathInfo}
</body>
</html>