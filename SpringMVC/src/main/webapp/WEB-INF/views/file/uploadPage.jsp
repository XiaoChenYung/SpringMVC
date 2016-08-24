<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传文件</title>
</head>
<body>
	<form action="<c:url value="/file/upload"/>" enctype="multipart/form-data" method="post">
		<input type="text" name="name">
		<input type="file" name="file">
		<input type="submit" value="提交">
		<input type="reset" value="重置">
	</form>
	<img alt="图片" src="../resources/img/694323.jpg" width="80px" height="80px">
	<a href="/myresources/demo2.docx" download="test.docx">链接下载</a>
	<a href="<c:url value="/file/download"/>">第二张文件下载</a>
</body>
</html>