<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<%
	pageContext.setAttribute("socketPath", 
			request.getServerName()+':'+request.getServerPort()+request.getContextPath()+'/');
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
<title>websocket练习2</title>
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
			<h4>websocket测试2</h4>
		</div>
		<div class="row">
				<h3>这里是聊天室 ， 欢迎 ${sessionScope.user}进入聊天</h3>
				<div   id="content"  style="background-color: aqua; width: 500px; height:400px; float:left;" >
				</div>
				<div  id="userList"  style="background-color: olive; width: 200px; height:400px; float: left;" >
				</div>
		
				<div  style="margin-top: 10px;  clear: both;"  >
					<input id="msg"/>
					<button onclick="ws_send();">发送</button>
				</div>
		</div>
		
	 
	</div>
	
	<script type="text/javascript">
		var ws; 
		var user='${sessionScope.user }';
		$(function(){
			init();
		});
	    function   ws_send(){
			var  msg= $("#msg").val();
	    	var  temp="{from:'"+user+"',content:'"+msg+"'}";    					
	    	ws.send(temp);
	    	$("#msg").val("");
	    }
	    
		//初始化方法
		function init(){
			 var target="ws://localhost:8088/ssm_demo1/chat?nickName="+user;
			 //var  target="ws://${socketPath}echo";
	   		  if ('WebSocket' in window) {
	                 ws = new WebSocket(target);
	             } else if ('MozWebSocket' in window) {
	                 ws = new MozWebSocket(target);
	             } else {
	                 alert('WebSocket不支持该浏览器');
	                 return;
	             }
	   		  ws.onopen=function(){
    			 console.log("websocket管道建立成功了");
	   		  };
	   		  ws.onmessage=function(event){
	   			  console.log("onmessage方法执行了...");
  			  	  eval("var msg="+event.data+";");
				  console.info(msg);	
	   		  }
		}
	</script>
</body>
</html>