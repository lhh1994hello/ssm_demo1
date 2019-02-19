<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引入jquery  -->
<script src="${APP_PATH}/static/js/jquery-1.12.4.js"></script>
<script	src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<!-- 引入bootstrap样式-->
<link	href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<title>ajax测试1</title>
</head>
<body>
	<h1 id="h1">ajax测试1</h1>
	<button type="button" id="btn1" class="btn btn-default">ajax测试1</button>
	<script type="text/javascript">
		$(function() {
			$("#btn1").click(function() {
				$.ajax({
					url: "${APP_PATH}/ajax/ajaxTest1",
					type:"GET",
					timeout:1000,//如果超时，就会调用error方法
					async:true,//true为异步，默认为true
					contentType:"application/x-www-form-urlencoded",//发送信息至服务器时内容编码类型
					data:{"a":"A","b":"B"},
					success:function(result){
						console.log(result);
						console.log("success方法...");
						$("#h1").append(",追加");
 					},
					complete:function(){
 						console.log("complete方法...");
					},
					beforeSend:function(){
 						console.log("beforeSend方法...");
					},
					error:function(){
						console.log("error方法....");
					}

				});
			});

		});
	</script>
</body>
</html>