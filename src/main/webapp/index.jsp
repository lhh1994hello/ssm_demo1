<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页欢迎页</title>
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-1.12.4.js"></script>
    <script src="${APP_PATH}/static/js/ajaxfileupload.js" type="text/javascript"></script>
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${APP_PATH}/static/js/myindex.js" type="text/javascript"></script>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="static/img/common/mk-logo.png">
                <img src="static/img/common/mk-logo.png" alt="logo" style="height: 30px;width: 30px;">
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
                <li><a href="#">Link</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">功能测试 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${APP_PATH}/view/websocket/chatroom.jsp">websocket聊天室1</a></li>
                        <li><a href="${APP_PATH}/view/image/aliyunoss.jsp">阿里云上传图片</a></li>
                        <li><a id="btn1" href="javascript:void(0)">测试重定向</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Link</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">测试 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class="container-fluid" style="margin-top: 60px;">
    <input type="hidden" id="contextPath" name="contextPath" value=<%= request.getContextPath() %>>
    <div class="container">
  <%--      <div class="row">
            <h4>欢迎页Hello World ,在线人数:${applicationScope.count}</h4>
        </div>--%>
        <div class="row">
            <%--<div class="col-md-6">
                <a href="${APP_PATH}/thread/threadFun1">测试线程</a><br/><br/>
                <input class="fileInput" id="file_URL" type="file" name="file" title="修改头像">
            </div>--%>
            <div class="col-md-3">
                <a href="${APP_PATH}/view/websocket/chatroom.jsp" class="btn btn-success">websocket聊天室1</a>
            </div>
        </div>
    </div>
</div>


</body>
</html>