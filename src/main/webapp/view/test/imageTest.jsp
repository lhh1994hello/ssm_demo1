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
<script src="${APP_PATH}/static/js/jquery-1.10.2.js"></script>
<%-- <script src="${APP_PATH}/static/js/jquery.dataTables.min.js"></script> --%>
<script	src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<%-- <link href="${APP_PATH}/static/css/jquery.dataTables.min.css"> --%>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css">
<title>小图标</title>
</head>
<body>
	<h1>小图标123</h1>
	<table class="table table-striped table-hover success table-bordered">
		 <thead>
            <tr>
                <th>
                	<span>姓名</span>
                	<span><img alt="图标" src="${APP_PATH}/image/sort_asc.png"></span>
                </th>
                <th>位置</th>
                <th>Office</th>
                <th>年龄</th>
                <th>开始时间</th>
                <th>薪水</th>
            </tr>
        </thead>
        <tbody>
        	 <tr>
                <td>Tiger Nixon</td>
                <td>System Architect</td>
                <td>Edinburgh</td>
                <td>61</td>
                <td>2011/04/25</td>
                <td>$320,800</td>
            </tr>
             <tr>
                <td>Tiger Nixon</td>
                <td>System Architect</td>
                <td>Edinburgh</td>
                <td>61</td>
                <td>2011/04/25</td>
                <td>$320,800</td>
            </tr>
        
        </tbody>
	</table>
</body>
</html>