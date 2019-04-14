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
<script src="${APP_PATH}/static/js/jquery.dataTables.min.js"></script>
<script	src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link	href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link	href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/jquery.dataTables.min.css">
<title>dataTable测试</title>
</head>
<body>
	<div class="container">
		<div class="row">
		
		</div>
		
		<div class="row">
			<div class="col-md-12">
					<!--  -->		
				<h1 id="h1">dataTableTest.jsp,----dataTable测试</h1>
 				<div class="mr-20 ml-20">
					<table border="1" border="0" cellspacing="0" cellpadding="0" id="workBenchList_D1" class="table table-striped table-hover success">
						<thead>
							<tr>
								<th>交易日期</th>
								<th>交易时间</th>
								<th>交易流水号</th>
								<th>交易唯一标识</th>
								<th>渠道</th>
								<th>交易响应时间</th>
								<th>交易分类</th>
								<th>交易编码</th>
								<th>交易描述</th>
								<th>错误码</th>
								<th>错误描述</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th>交易日期1</th>
								<th>交易时间1</th>
								<th>交易流水号1</th>
								<th>交易唯一标识1</th>
								<th>渠道1</th>
								<th>交易响应时间1</th>
								<th>交易分类1</th>
								<th>交易编码1</th>
								<th>交易描述1</th>
								<th>错误码1</th>
								<th>错误描述1</th>
							</tr>
						</tbody>
					</table>
				</div>
					
					
					
					<!--  -->
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		$(function() {
			var a=$("#h1").text();
			debugger;
			$("#workBenchList_D1").DataTable({
					"oLanguage": {
						"sLengthMenu": "每页显示 _MENU_ 条记录",
						"sZeroRecords": "抱歉， 没有找到",
						"sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
						"sInfoEmpty": "没有数据",
						"sInfoFiltered": "(从 _MAX_ 条数据中检索)",
						"oPaginate": {
						"sFirst": "首页",
						"sPrevious": "前一页",
						"sNext": "后一页",
						"sLast": "尾页"
						},
						"sZeroRecords": "没有检索到数据",
						"sProcessing": "<img src='./loading.gif' />"
					},
					//请求数据
					"ajax":{
						url:"${APP_PATH}/dataTable/test1",
						dataType:"json",
						type:"POST",
						 data: function (param) {
			                    param.opportunityNO = "AAA";
			                    return param;
			              },
			              success:function(result){
			            	  console.log(result);
			              }
					},
					

				});

		});
	</script>
</body>
</html>