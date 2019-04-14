<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
 <!--第一步：引入Javascript / CSS （CDN）-->
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.15/css/jquery.dataTables.css">

<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>

<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.js"></script>
 
 
<script	src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
  
<title>dataTable测试</title>
</head>
<body>
	<table id="table" class="display">
		<thead>
			<tr>
				<th>编号</th>
				<th>名称</th>
				<th>状态</th>
				<th>电话</th>
				<th>网址</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	<script type="text/javascript" src="js/constant.js"></script>
	<script type="text/javascript">
   	$(function(){
   		var $table = $("#table");
   		var _table = $table.dataTable($.extend(true,{},CONSTANT.DATA_TABLES.DEFAULT_OPTION, {
   			ajax : function(data, callback, settings) {
   				//封装请求参数
   				var param = userManage.getQueryCondition(data);
   				$.ajax({
   			            type: "GET",
   			         	url: "${APP_PATH}/dataTable/test3",
   			            cache : false,	//禁用缓存
   			            data: param,	//传入已封装的参数
   			            dataType: "json",
   			            success: function(result) {
 			            		//异常判断与处理
			            		if (result.errorCode) {
			            			alert("查询失败");
			            			return;
								}
   			            		//封装返回数据
   			            		var returnData = {};
   				            	returnData.draw = data.draw;//这里直接自行返回了draw计数器,应该由后台返回
   				            	returnData.recordsTotal = result.total;//总记录数
   				            	returnData.recordsFiltered = result.total;//后台不实现过滤功能，每次查询均视作全部结果
   				            	returnData.data = result.pageData;
   				            	//调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
   				            	//此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
  				            	callback(returnData);
   			            },
   			            error: function(XMLHttpRequest, textStatus, errorThrown) {
   			                alert("查询失败");
   			            }
   			        });
   			},
   			//绑定数据
   	        columns: [
   	            {
   	            	data: "carrierId",//字段名
   	            },
   	            {
   	            	data: "carrierName",//字段名
   	            },
   				{
   					data : "carrierStatus",//字段名
   					render : function(data,type, row, meta) {
   						return (data == 1? "可以查发":data == 2?"可以链接":data == 3?"仅供查询":"不可用");
   					}
   				},
   				{
   					data : "carrierPhone",//字段名
   				},
   				{
   					data : "carrierLink",//字段名
   					orderable : false,//禁用排序
   					render : CONSTANT.DATA_TABLES.RENDER.ELLIPSIS//alt效果
   				},
   				 {
   					data: null,//字段名
   					defaultContent:"",//无默认值
   					orderable : false//禁用排序
   				}
   	        ],
   	        "createdRow": function ( row, data, index ) {
   	        	//不使用render，改用jquery文档操作呈现单元格
   	            var $btnEdit = $('<button type="button" class="btn-edit">修改</button>');
   	            var $btnDel = $('<button type="button" class="btn-del">删除</button>');
   	            $('td', row).eq(5).append($btnEdit).append($btnDel);
   	        },
   	        "drawCallback": function( settings ) {
   	        	//渲染完毕后的回调
   	        	//默认选中第一行
   	        	//$("tbody tr",$table).eq(0).click();
   	        }
   		})).api();//此处需调用api()方法,否则返回的是JQuery对象而不是DataTables的API对象
   		//查询
	   	$("#btn_search").click(function(){
			_table.draw();
		});
   		//行点击事件
	   	$("tbody",$table).on("click","tr",function(event) {
			$(this).addClass("active").siblings().removeClass("active");
			//获取该行对应的数据
			var item = _table.row($(this).closest('tr')).data();
			userManage.showItemDetail(item);
	    });
   		//按钮点击事件
	   	$table.on("click",".btn-edit",function() {
	    	//点击编辑按钮
	        var item = _table.row($(this).closest('tr')).data();
			userManage.editItemInit(item);
		}).on("click",".btn-del",function() {
			//点击删除按钮
			var item = _table.row($(this).closest('tr')).data();
			userManage.deleteItem(item);
		});
   		//影藏列
	   	$('a').on( 'click', function (e) {
	   		var cut = $(this).text()
	   		if(cut.indexOf("显示")>-1){
	   			$(this).text("影藏"+cut.split("示")[1])
	   		}else{
	   			$(this).text("显示"+cut.split("藏")[1])
	   		}
	        e.preventDefault();
	        var column = _table.column( $(this).attr('data-column') );
	        column.visible( ! column.visible() );
	    } );
   		
   	});
   	
   	//----------------------------------------------------
   	var userManage = {
   			getQueryCondition : function(data) {
   				var param = {};
   				//组装排序参数
   				if (data.order&&data.order.length&&data.order[0]) {
   					switch (data.order[0].column) {
   					case 0:
   						param.orderColumn = "carrier_id";//数据库列名称
   						break;
   					case 1:
   						param.orderColumn = "carrier_name";//数据库列名称
   						break;
   					case 2:
   						param.orderColumn = "carrier_status";//数据库列名称
   						break;
   					case 3:
   						param.orderColumn = "carrier_phone";//数据库列名称
   						break;
   					default:
   						param.orderColumn = "carrier_id";//数据库列名称
   						break;
   					}
   					//排序方式asc或者desc
   					param.orderDir = data.order[0].dir;
   				}
				param.id = $("#id-search").val();//查询条件
				param.name = $("#name-search").val();//查询条件
				param.status = $("#status-search").val();//查询条件
   				//组装分页参数
   				param.startIndex = data.start;
   				param.pageSize = data.length;
   				param.draw = data.draw;
   				return param;
   			},
   			editItemInit : function(item) {
   				//编辑方法
   				alert("编辑"+item.carrierId+"  "+item.carrierName);
   			},
   			deleteItem : function(item) {
   				//删除
   				alert("删除"+item.carrierId+"  "+item.carrierName);	
   			},
   			showItemDetail: function(item){
   				//点击行
   				alert("点击"+item.carrierId+"  "+item.carrierName);
   			}
   		};
   	
   	/*常量*/
   	var CONSTANT = {
   			DATA_TABLES : {
   				DEFAULT_OPTION : { //DataTables初始化选项
   					language: {
   						"sProcessing":   "处理中...",
   						"sLengthMenu":   "每页 _MENU_ 项",
   						"sZeroRecords":  "没有匹配结果",
   						"sInfo":         "当前显示第 _START_ 至 _END_ 项，共 _TOTAL_ 项。",
   						"sInfoEmpty":    "当前显示第 0 至 0 项，共 0 项",
   						"sInfoFiltered": "(由 _MAX_ 项结果过滤)",
   						"sInfoPostFix":  "",
   						"sSearch":       "搜索:",
   						"sUrl":          "",
   						"sEmptyTable":     "表中数据为空",
   						"sLoadingRecords": "载入中...",
   						"sInfoThousands":  ",",
   						"oPaginate": {
   							"sFirst":    "首页",
   							"sPrevious": "上页",
   							"sNext":     "下页",
   							"sLast":     "末页",
   							"sJump":     "跳转"
   						},
   						"oAria": {
   							"sSortAscending":  ": 以升序排列此列",
   							"sSortDescending": ": 以降序排列此列"
   						}
   					},
   	                autoWidth: false,	//禁用自动调整列宽
   	                stripeClasses: ["odd", "even"],//为奇偶行加上样式，兼容不支持CSS伪类的场合
   	                order: [],			//取消默认排序查询,否则复选框一列会出现小箭头
   	                processing: false,	//隐藏加载提示,自行处理
   	                serverSide: true,	//启用服务器端分页
   	                searching: false	//禁用原生搜索
   				},
   				COLUMN: {
   	                CHECKBOX: {	//复选框单元格
   	                    className: "td-checkbox",
   	                    orderable: false,
   	                    width: "30px",
   	                    data: null,
   	                    render: function (data, type, row, meta) {
   	                        return '<input type="checkbox" class="iCheck">';
   	                    }
   	                }
   	            },
   	            RENDER: {	//常用render可以抽取出来，如日期时间、头像等
   	                ELLIPSIS: function (data, type, row, meta) {
   	                	data = data||"";
   	                	return '<span title="' + data + '">' + data + '</span>';
   	                }
   	            }
   			}
   		};

   </script>


</body>
</html>