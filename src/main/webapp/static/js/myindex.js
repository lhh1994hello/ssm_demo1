$(function(){
	var contextPath=$.trim($("#contextPath").val());
	$("#btn1").click(
			function() {
				//************************
				$("#btn1").removeClass("btn btn-default").addClass("btn btn-danger");						
				
				 var pathName = document.location.pathname;
				 var index = pathName.substr(1).indexOf("/");
				 var result = pathName.substr(0,index+1);
				 console.log("pathName:"+pathName);
				 console.log("result:"+result);
				$.ajax({
					url : contextPath+"/user/fun1",
					data : {"a" : "A"},										
					type : "GET",
					success : function() {
						$("#btn1").removeClass("btn btn-danger").addClass("btn btn-default");		
						console.log("请求成功....");
					}
				});
			});
	
	
	$(document).on('change','#file_URL',function(){
		ajaxFileUpload();
		console.log("改变了...");
	});
	
	//头像上传
	function ajaxFileUpload(){
		$.ajaxFileUpload({
			url:contextPath+"/ftpfile/fileUpload",
			secureuri: false, //是否需要安全协议，一般设置为false
			 fileElementId: 'file_URL', //文件上传域的ID
			 type:"POST",
			 dataType: 'json', //返回值类型 一般设置为json
			 success: function (data, status) {
				 var code=data.code;
				 console.log("返回码code:"+code);
			 },
			 error: function (data, status, e)//服务器响应失败处理函数
             {
                 alert(e);
             }
		});
	}
});