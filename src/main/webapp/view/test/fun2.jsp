<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试2</title>
</head>
<body>
	<form action="${APP_PATH}/test/fun2?a=123" method="post">
		值1:<input  type="text" name="a"  /><br>
		值2:<input   type="text" name="a"/>
			<input  type="submit" value="提交"/>	
	</form>
</body>
</html>