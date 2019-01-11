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
<!-- 引入jquery  -->
<script src="${APP_PATH}/static/js/jquery-1.12.4.js"></script>
<!-- 引入bootstrap样式-->
<link
	href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script
	src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>首页AAA</h1>
	<h1>欢迎页Hello World</h1>
	<button id="btn1" class="btn btn-default">测试重定向</button>
	<hr>
	<a href="${APP_PATH}/user/fun1">点击跳转user</a><br/><br/>
	<hr>
	<a href="${APP_PATH}/book/fun1">点击跳转book</a><br><br/>
	<a href="${APP_PATH}/thread/threadFun1">测试线程</a><br/>

	<script type="text/javascript">
		$(function() {
			$("#btn1").click(
					function() {
						//************************
						$("#btn1").removeClass("btn btn-default").addClass(
								"btn btn-danger");
						$.ajax({
							url : "${APP_PATH}/user/fun1",
							data : {
								"a" : "A"
							},
							type : "GET",
							success : function() {
								$("#btn1").removeClass("btn btn-danger")
										.addClass("btn btn-default");
								console.log("请求成功....");
							}
						});
					});
		});
	</script>
</body>
</html>