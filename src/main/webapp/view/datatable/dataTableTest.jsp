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
<link	href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/jquery.dataTables.min.css">
<script	src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<!-- 引入bootstrap样式-->
<link	href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
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
					<table border="1" border="0" cellspacing="0" cellpadding="0" id="listDataTable" class="table table-striped table-hover success">
						<thead>
							<tr>
							    <th>id</th>
								<th>clusterName</th>
								<th>docNum</th>
								<th>date</th>
								 
							</tr>
						</thead>
						<tbody>
							<tr>
								<th>交易日期1</th>
								<th>交易时间1</th>
								<th>交易流水号1</th>
								<th>交易流水号1</th>
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
			 $('#listDataTable').dataTable({
		        "paging": true,
		        "ordering": true,
		        "info": true,
		        "searching": true,
		        "aLengthMenu": [10, 25, 50, 100],
		        "serverSide": true,
		        "processing": true,
 		        "oLanguage": {
		            "sLengthMenu": "每页显示 _MENU_ 条记录",
		            "sZeroRecords": "抱歉， 没有找到",
		            "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
		            "sInfoEmpty": "",
		            "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
		            "sZeroRecords": "无数据",
		            "sSearch": "",
		            "sProcessing": "查询中...",
		            "oPaginate": {
		                "sFirst": "首页",
		                "sPrevious": "前一页",
		                "sNext": "后一页",
		                "sLast": "尾页"
		            }
		 
		        },
		        "bProcessing": true,
		        "bServerSide": true,
		        "iDisplayLength": 10,
		        "iDisplayStart": 0,
		        /*"order": [[3, "desc"]],*/
		 
		        /*会弹出提示Cannot reinitialise DataTable 把提示关掉  http://datatables.club/faqs/  */
		        "retrieve": true,
		        "destroy": true,
		 
		        "drawCallback": function (settings) {
		            $('input[name="idCheck"]').iCheck({
		                checkboxClass: 'icheckbox_minimal-blue'
		            });
		        },
		        "ajax": {
		            "url": "${APP_PATH}/dataTable/test2",
		            "type":"POST",
		            "data":{
		                "beginTime":$("#beginTime").val("A"),
		                "endTime":$("#endTime").val("B")
		            }
		        },
		        "columnDefs": [
		            {
		                "targets": 0,
		                "orderable": false,
		                "render": function (data, type, full, meta) {
		                    return '<input type="checkbox" name="idCheck" value="' + data + '">'
		                }
		            },
		            {
		                "type": "date",
		                "targets": 3,
		                "orderData": [ 3, 0 ],
		                "render": function (data, type, full, meta) {
		                    if (data == null || data == '') {
		                        return '';
		                    }
		                    return new Date(data).Format('yyyy-MM-dd');
		                       
		                }
		            }
		        ],
		        "aoColumns": [
		            {"mData": "id", "bSortable": false},//"bSortable": false不进行排序
		            /*{"mData": "clusterId"},*/
		            {"mData": "clusterName","bSortable": false},
		            {"mData": "docNum"},
		            {"mData": "date"}
		        ],
		        "columns": [
	                 {"data": "id", "bSortable": false},
		             {"data": "clusterName"},
		             {"data": "docNum"},
		             {"data": "date"}
		         ]
		    });

		});
	</script>
</body>
</html>