<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%String path=request.getContextPath(); %>
<c:set value="${pageContext.request.contextPath}" var="mypath"/>
<body>
	 注册界面${pageContext.request.contextPath}
	<img alt="图片" src="../user/image" width="100px" height="100px">
	<img alt="图片" src="<%=path %>/user/image" width="200px" height="200px">
	<img alt="图片" src="${mypath}/user/image" width="250px" height="250px">
	<img alt="图片" src="${pageContext.request.contextPath}/user/imageOther" width="300px" height="300px">
	<br>
	${me.id};${me.username};${me.password}; ${hello};${xx}
	<iframe src="/res/test/test3.html" width="100%" height="500px">
	</iframe>
</body>
</html>