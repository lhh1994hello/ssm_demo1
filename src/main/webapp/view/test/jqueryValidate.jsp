<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="demoForm" action="#">
		<fieldset>
			<legend>用户登录</legend>
			<p>
				<label for="username">用户名</label> <input type="text" id="username"
					name="username" autocomplete="off" />
			</p>
			<p>
				<label for="password">密码</label> <input type="password"
					id="password" name="password" autocomplete="off" />
			</p>
			<p>
				<label for="password">邮箱</label> <input type="text" id="email"
					name="email" autocomplete="off" />
			</p>
			<p>
				<input type="submit" value="登录">
			</p>
		</fieldset>
	</form>
	<script type="text/javascript"
		src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript"
		src="${APP_PATH}/static/js/jquery.validate.min.js"></script>

	<script type="text/javascript">
		$(function() {
			$("#demoForm")
					.validate(
							{
								//设置规则
								//username 和password是input框的name属性值
								debug : true,//设置成true后，前台不会向后台发送请求
								rules : {
									username : {
										required : true,
										//minlength: 2,
										//maxlength: 12,
										rangelength : [ 2, 12 ]
										//remote : {
											//url : "http://localhost:8088/onlingOrderSys-former-web/testFun1",
										//}

									},
									password : {
										required : true,
										minlength : 2,
										maxlength : 12
									},
									email : {
										required : true,
										email : true
									}
								},
								//设置提示信息
								messages : {
									username : {
										required : "用户名必填",
										minlength : "用户名最小为2位",
										maxlength : "用户名最大为12位",
										//remote : "用户名不存在",
										rangelength : "长度必须在2到10之间"
									},
									password : {
										required : "密码必填",
										minlength : "密码最短为2位",
										maxlength : "密码最长为12位"
									},
									email : {
										required : "邮箱必填",
										email : "请输入正确的邮箱格式"
									}
								},
							//
								submitHandler:function(){
									alert("");
								}
							});

		});
	</script>
</body>
</html>