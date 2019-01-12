<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页欢迎页</title>
 
<%-- <script src="${APP_PATH}/static/js/jquery-1.12.4.js"></script>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script> --%>
 
<script type="text/javascript"	src="${APP_PATH}/static/js/jquery-1.12.4.js"></script>
<script src="${APP_PATH}/static/js/ajaxfileupload.js"  type="text/javascript"></script>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"	rel="stylesheet">
<script	src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<script src="${APP_PATH}/static/js/myindex.js"  type="text/javascript"></script>

</head>
<body>
	<h2>首页AAA</h2>
	<h4>欢迎页Hello World</h4>
	<input type="hidden" id="contextPath" name="contextPath" value=<%= request.getContextPath() %> > 
	<button id="btn1" class="btn btn-default">测试重定向</button> &nbsp;&nbsp;
	<a href="${APP_PATH}/user/fun1">点击跳转user</a> &nbsp;&nbsp;
	<a href="${APP_PATH}/book/fun1">点击跳转book</a> &nbsp;&nbsp;
	<a href="${APP_PATH}/thread/threadFun1">测试线程</a><br/><br/>
	

	<!-- <input  type="file"  id="file_URL"  name="file" value="ftp文件上传" /> -->
	<input class="fileInput" id="file_URL" type="file" name="file" title="修改头像">
	

</body>
</html>