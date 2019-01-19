<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<%
	pageContext.setAttribute("socketPath", 
			request.getServerName()+':'+request.getServerPort()+request.getContextPath()+'/');
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>websocket练习1</title>
<script src="${APP_PATH}/static/js/jquery-1.12.4.js" type="text/javascript"></script>
<script src="${APP_PATH}/static/js/ajaxfileupload.js"  type="text/javascript"></script>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"	rel="stylesheet">
<script	src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>

</head>
<body>
	<input type="hidden" value="${APP_PATH}"/>
	<input type="hidden" value="${socketPath}"/>	
	
	<div class="container">
		<div class="row">
			<h4>websocket测试1</h4>
		</div>
		<div class="row">
			<div class="col-md-6" style="background:#ffcccc">
				<button class="btn btn-success" onclick="javascript:subConnect();">连接</button>	
			</div>
		</div>
		
		<div class="row" style="margin-top:20px;">
			<div class="col-md-6" style="background:#ff99cc">
				信息:<input type="text" id="msg"/>
				<button id="send" class="btn btn-default" onclick="javascript:subSend();">发送</button>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		var ws;
		 
		var target="ws://${socketPath}echo";
	 
		$(function(){
			subConnect();
		});
		
		//建立连接
		function subConnect(){
			debugger;
            if (target == '') {
                alert('请求路径为空');
                return;
            }
            if ('WebSocket' in window) {
                ws = new WebSocket(target);
            } else if ('MozWebSocket' in window) {
                ws = new MozWebSocket(target);
            } else {
                alert('WebSocket不支持该浏览器');
                return;
            }
            //该方法在连接建立后执行
            ws.onopen = function () {
  			  console.log("onopen方法..连接建立啦");
  		    }; 
           //用于接收服务端发送过来的信息
    		ws.onmessage=function(event){
    			console.log("服务端来信息啦");
    			console.log(event);
    			var msg=event.data;
    			console.log(msg);
    			console.log("类型:"+typeof msg);
    		};
		}
		
		
		//用于向服务端发送信息
		function subSend(){
			var msg=$("#msg").val();
			console.log("发送信息:"+msg);
			debugger;
			if(ws==undefined||ws==''){
				subConnect();
			}
			debugger;
			ws.send(msg);	
			$("#msg").val("");
		}
		
	</script>
</body>
</html>