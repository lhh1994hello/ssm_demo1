<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<%
	pageContext.setAttribute("socketPath",
			request.getServerName() + ':' + request.getServerPort() + request.getContextPath() + '/');
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>聊天室1</title>
<script src="${APP_PATH}/static/js/jquery-1.12.4.js" type="text/javascript"></script>
<script src="${APP_PATH}/static/js/ajaxfileupload.js"  type="text/javascript"></script>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"	rel="stylesheet">
<script	src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<h4>聊天室1</h4>
		</div>
		<div class="row" >
			<div class="col-md-6">
				<div id="content" style="background:#ffffcc"></div>
			</div>
		</div>
		<div class="row" style="margin-top:20px;">
			<%--style="background:#ff99cc"--%>
			<div class="col-md-6" >
				信息:<input type="text" id="msg"/>
				<button id="send" class="btn btn-default" onclick="javascript:subSend();">发送</button>
				<br/><font style="color: red;display: none;" id="empty_tip" >信息不能为空!</font>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var ws;
		var randomNumber = Math.ceil(Math.random() * 100); 
		var target="ws://${socketPath}chatroom?nickName=zhangsan"+randomNumber;
	 	console.log(target);
		$(function(){
		    $("#empty_tip").css("display","none");
			subConnect();
		});
		
		//建立连接
		function subConnect(){
			//debugger;
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
                subOpen();
  		    }; 
           //用于接收服务端发送过来的信息
    		ws.onmessage=function(event){
                subMessage(event);
    		};
		}
		//方法在连接建立后执行
		function subOpen() {
            console.log("onopen方法..连接建立啦");
        }
        //接收服务端发送过来的信息
		function  subMessage(event) {
            console.log(event);
            eval("var msg="+event.data+";");
            console.log(msg);
            console.log("类型:"+typeof msg.welcome+"");
            if( msg.welcome!=undefined){
                var font_ele=$("<font style='color:#3366ff;'></font>").append(msg.welcome);
                $("#content").append(font_ele).append($("<br>"));
            }else {
                $("#content").append(msg.from+":"+msg.date+"<br/>"+msg.content+"<br/>");
            }
        }
		//用于向服务端发送信息
		function subSend(){
			var msg=$("#msg").val();
            $("#empty_tip").css("display","none");
			if (msg==''||msg==undefined){
                $("#empty_tip").css("display","inline-block");
				return;
			}
			if(ws==undefined||ws==''){
				subConnect();
			}
			ws.send(msg);	
			$("#msg").val("");
		}
		
	</script>
</body>
</html>