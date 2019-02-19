<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>员工列表：AJAX方式</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- 引入jquery  -->
<script type="text/javascript"
	src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>
<!-- 引入bootstrap样式-->
<link
	href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>
<body>
<!--  -->

	<!--模态框，员工修改信息 -->
<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改员工</h4>
      </div>
      <div class="modal-body">
    	   
		<form class="form-horizontal">
			  <div class="form-group">
			    <label for="empName_add_input" class="col-sm-2 control-label">员工修改</label>
			    <div class="col-sm-10">
			    	<!-- <p class="form-control-static" id="empName_update_static"></p> -->
			      <input type="text" name="empName" class="form-control" id="empName_update_input" placeholder="员工名称">
			      <span id="empName_add_span"  class="help-block"></span>
			    </div>
			  </div>
			  
			   <div class="form-group">
				    <label for="email_add_input" class="col-sm-2 control-label">邮&nbsp;&nbsp;箱</label>
				    <div class="col-sm-10" id="div_email_update_input">
				      <input type="text" name="email" class="form-control" id="email_update_input" placeholder="邮&nbsp;&nbsp;箱">
				      <span  id="email_add_span" class="help-block"></span>
				    </div>
			  </div>
			  <!--  性别-->
			    <div class="form-group">
				    <label  class="col-sm-2 control-label">性&nbsp;&nbsp;别</label>
				    <div class="col-sm-10">
				       <label class="radio-inline">
						  <input type="radio" name="gender" id="gender1_update_input" value="男" checked="checked"> 男
					</label>
					<label class="radio-inline">
						  <input type="radio" name="gender" id="gender2_update_input" value="女"> 女
					</label>
				    </div>
			  </div>
			
			  <!-- 部门选项 -->
			  <div class="form-group">
				    <label  class="col-sm-2 control-label">部门名称</label>
				    <div class="col-sm-4">
				      	<select  class="form-control" name="dId" id="dept_update_select">
						 	<!-- 提交部门ID即可，外键 -->
						</select>				      	
				    </div>
			  </div>						
			</form>    	       	          	   
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关&nbsp;闭</button>
        <button type="button" class="btn btn-primary" id="emp_update_btn">更 &nbsp;新</button>
      </div>
    </div>
  </div>
</div>
<!--  #####################################################3-->
<!--模态框，员工添加信息 -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加员工</h4>
      </div>
      <div class="modal-body">
    	   
		<form class="form-horizontal">
			  <div class="form-group">
			    <label for="empName_add_input" class="col-sm-2 control-label">员工名称</label>
			    <div class="col-sm-10">
			      <input type="text" name="empName" class="form-control" id="empName_add_input" placeholder="员工名称">
			      <span id="empName_add_span"  class="help-block"></span>
			    </div>
			  </div>
			  
			   <div class="form-group">
				    <label for="email_add_input" class="col-sm-2 control-label">邮&nbsp;&nbsp;箱</label>
				    <div class="col-sm-10">
				      <input type="text" name="email" class="form-control" id="email_add_input" placeholder="邮&nbsp;&nbsp;箱">
				      <span  id="email_add_span" class="help-block"></span>
				    </div>
			  </div>
			  <!--  性别-->
			    <div class="form-group">
				    <label  class="col-sm-2 control-label">性&nbsp;&nbsp;别</label>
				    <div class="col-sm-10">
				       <label class="radio-inline">
						  <input type="radio" name="gender" id="gender1_add_input" value="男" checked="checked"> 男
					</label>
					<label class="radio-inline">
						  <input type="radio" name="gender" id="gender2_add_input" value="女"> 女
					</label>
				    </div>
			  </div>
			
			  <!-- 部门选项 -->
			  <div class="form-group">
				    <label  class="col-sm-2 control-label">部门名称</label>
				    <div class="col-sm-4">
				      	<select  class="form-control" name="dId" id="dept_add_select">
						 	<!-- 提交部门ID即可，外键 -->
						</select>				      	
				    </div>
			  </div>						
			</form>    	       	          	   
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关&nbsp;闭</button>
        <button type="button" class="btn btn-primary" id="emp_save_btn">保 &nbsp;存</button>
      </div>
    </div>
  </div>
</div>
<!--  #####################################################3-->
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>SSM_CRUD</h1>
			</div>
		</div>
		<!--  按钮-->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary" id="emp_add_modal_btn">新增</button>
				||
				<button class="btn btn-danger" id="emp_delete_all_btn">删除</button>
			</div>

		</div>
		<!-- 显示数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-striped table-hover success"
					id="emps_table">
					<!--  tr：一行-->
					<thead>
						<tr>
							<th>
								<input type="checkbox" id="checkAll"/>
							</th>
							<th>#</th>
							<th>empName</th>
							<th>gender</th>
							<th>email</th>
							<th>deptName</th>
							<!-- 操作 -->
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<!-- 表格体 -->
					</tbody>
				</table>
			</div>

		</div>
		<!-- 显示分页信息 -->
		<div class="row" >
			<!--  分页文字信息-->
			<div class="col-md-6" id="page_info_area"></div>
			<!-- 分页条 -->
			<div class="col-md-6" id="page_info_nav">
				
				
			</div>

		</div>
	</div>
<!--  ##################################################################################-->
	<script type="text/javascript">
		var totalRecord,currentPage;
					//页面加载完成之后直接发送一个AJAX请求
					//是$(document).ready(function(){}) 的简写，用来在DOM加载完成之后执行一系列预先定义好的函数。
					$(function() {
						//去首页
						to_page(1);
					});
			      //当输入框失去焦点的时候执行这个方法，判断用户名是否已经存在了
					$("#empName_add_input").change(function(){
						var empName=this.value;
						$.ajax({
							url:"${APP_PATH}/checkuser",
							type:"POST",
							data:"empName="+empName,
							success:function(result){
								if(result.code==100){
									show_validate_msg("#empName_add_input","success","用户名可用");
									$("#emp_save_btn").attr("ajax-value","success");
								}else{
									show_validate_msg("#empName_add_input","error",result.extend.va_msg);
									$("#emp_save_btn").attr("ajax-value","fail");
								}
							}
						});
					});
					//校验邮箱是否存在
					$("#email_update_input").change(function(){
						var email=this.value;
						$.ajax({
							url:"${APP_PATH}/checkemail",
							type:"POST",
							data:"empName="+email,
							success:function(result){
								if(result.code==100){
									show_validate_msg("#email_update_input","success","邮箱可用");
									$("#emp_save_btn").attr("ajax-value","success");
								}else{
									show_validate_msg("#email_update_input","error",result.extend.va_msg);
									$("#emp_save_btn").attr("ajax-value","fail");
								}
							}
						});
					});
					//校验表单数据
					function validate_add_form(){
						//校验用户名
					 var empName=$("#empName_add_input").val();
					 var regName=/(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
					 
					 if(!regName.test(empName)){
						 //失败
						 show_validate_msg("#empName_add_input","error","用户名可以是2-5位中文或者6-16位英文和数字的组合");
						 return false;
					 }else{
						 show_validate_msg("#empName_add_input","success","");
					 }
					 //校验邮箱
					 var email=$("#email_add_input").val();
					 var regEmail=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
					 if(!regEmail.test(email)){
						 //alert("邮箱格式不正确");
						 show_validate_msg("#email_add_input","error","邮箱格式不正确");
						 return false;
					 }else{
						 show_validate_msg("#email_add_input","success","");
					 }
					 return true;
					}
					
					//显示校验结果的提示信息
					function show_validate_msg(ele,status,msg){
						//每次清除之前都先清除父元素的样式
						$(ele).parent().removeClass("has-success has-error");
						//提示内容默认是空
						$(ele).next("span").text("");
						if("success"==status){
							$(ele).parent().addClass("has-success");
							 $(ele).next("span").text(msg);
						}else if("error"==status){
							console.log($(ele));
							 $(ele).parent().addClass("has-error");
							 $(ele).next("span").text(msg);							
						}
					}
				//给保存按钮绑定点击事件,点击保存，保存员工信息
					$("#emp_save_btn").click(function(){
						//alert($("#empAddModal form").serialize());
						//进行前端校验，不用查询数据库
						  if(!validate_add_form()){
							return false;
						}  
						//查询数据库校验，用户名是否已经存在
						if($(this).attr("ajax-value")=="fail"){
							//如果这里执行，就不能关闭模态框了。
							return false;
						}
						 $.ajax({
							url:"${APP_PATH}/emp",
							type:"POST",
							data:$("#empAddModal form").serialize(),
							success:function(result){
								if(result.code==100){
									//alert(result.message);
									//员工保存成功之后，模态框应该关闭，然后自动跳转到最后一页，因为主键自增的添加之后会在最后一页
									//关闭模态框
									$("#empAddModal").modal('hide');
									to_page(totalRecord+1);
								}else{
									//显示失败信息
									console.log(result);
									if(result.extend.errorFields.email!=undefined){
										show_validate_msg("#email_add_input","error",result.extend.errorFields.email);
									}
									if(result.extend.errorFields.empName!=undefined){
										show_validate_msg("#empName_add_input","error",result.extend.errorFields.empName);
									}				
								}
								
								
							}
						});
					});
					//清除表单数据，每次弹出模态框都把输入框的内容清空
				function reset_form(ele){
					//[0]使用dom对象的方法
					$(ele)[0].reset();
					$(ele).find("*").removeClass("has-error has-success");
					$(ele).find(".help-block").text("");
				}
				
			//点击新增按钮，发送AJAX请求，查处所有的部门信息，然后再弹出模态框，
			$("#emp_add_modal_btn").click(function(){
				//清除表单数据，每次弹出模态框都把输入框的内容清空。
				reset_form("#empAddModal form");
				//发送AJAX请求，查出部门信息，显示在下拉列表中
				getDept("#dept_add_select");
				//
				$("#empAddModal").modal({
					backdrop:"static"
				
				});
			});
			//查出部门信息
			function getDept(ele){
				//清空下拉列表的记忆选择
				$(ele).empty();
				$.ajax({
					url:"${APP_PATH}/depts",
					type:"GET",
					success:function(result){
						console.log(result);
						//遍历
						$.each(result.extend.depts,function(index,item){
							var optionEle=$("<option ></option>").append(item.deptName).attr("value",item.deptId);
							//把这个变量添加到这个id指向的标签
							optionEle.appendTo(ele);
						});
					}
				});
			}
	
		
		//抽取出来的方法，发送请求得到数据
		function to_page(pn){
			$.ajax({
				url : "${APP_PATH}/emps2",
				data : "pn="+pn,
				type : "GET",
				success : function(result) {
					console.log(result);
					bulid_emps_table(result);
					//解析并显示员工信息
					//解析并显示分页信息
					bulid_page_info(result);
					//解析并显示分页条信息
					bulid_page_nav(result);
				}

			});
		}
		//解析并显示员工信息
		function bulid_emps_table(result) {
			//清空table表数据
			$("#emps_table tbody").empty();
			//javabean导航
			var emps = result.extend.pageInfo.list;
			//遍历员工信息
			$.each(emps, function(index, item) {
				//alert(item.empName);
				var checkBoxTd=$("<td><input type='checkbox' class='check_item'></input></td>");
				var empIdTd = $("<td></td>").append(item.empId);
				var empNameTd = $("<td></td>").append(item.empName);
				var genderTd = $("<td></td>").append(item.gender);
				var genderTd = $("<td></td>").append(item.gender);
				var emailTd = $("<td></td>").append(item.email);
				var deptNameTd = $("<td></td>")
						.append(item.department.deptName);
				var editbtn = $("<button></button>").addClass("btn btn-primary  btn-sm edit_btn").append($("<span></span>")
						.addClass("glyphicon glyphicon-pencil")).append("编 辑");
				
				editbtn.attr("edit-id",item.empId);
				
				var delbtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn").append($("<span></span>")
						.addClass("glyphicon glyphicon glyphicon-trash")).append("  删 除");
				//给删除按钮添加一个属性用来记住id
				delbtn.attr("delete-id",item.empId);
				var btnTd=$("<td></td>").append(editbtn).append("||").append(delbtn);
				$("<tr></tr>").append(checkBoxTd).append(empIdTd).append(empNameTd).append(
						genderTd).append(emailTd).append(deptNameTd).append(btnTd).appendTo(
						"#emps_table tbody");
			});
		}
		//解析并显示分页信息
		function bulid_page_info(result){
			$("#page_info_area").empty();
			var temp=result.extend.pageInfo;
			$("#page_info_area").append("当前第"+temp.pageNum+"页,"+"总共"+temp.pages+"页,"+"总共"+temp.total+"条记录");
			totalRecord=temp.pages;
			currentPage=temp.pageNum;
		}
		//解析并显示分页条
		function bulid_page_nav(result) {
			$("#page_info_nav").empty();
			var temp=result.extend.pageInfo;
			var ul=$("<ul></ul>").addClass("pagination");
			var firstPageLi=$("<li></li>").append($("<a></a>").append("首 页").attr("href","#"));
			var prePageLi=$("<li></li>").append($("<a></a>").append("&laquo;").attr("href","#"));
			//如果还有前一页
            if(!temp.hasPreviousPage){
            	firstPageLi.addClass("disabled");
            	prePageLi.addClass("disabled");
			}else{//没有前一页了，就不绑定点击事件了，点击页不会发请求了
			    firstPageLi.click(function(){
	            	to_page(1);
	            });
	            prePageLi.click(function(){
	            	to_page(temp.pageNum-1);
	            });
			}
        
			/*  遍历*/
			ul.append(firstPageLi).append(prePageLi).append();
			$.each(temp.navigatepageNums,function(index,item){
				var numLi=$("<li></li>").append($("<a></a>").append(item).attr("href","#"));
				if(temp.pageNum==item){
					numLi.addClass("active");
				}
				numLi.click(function(){
					to_page(item);
				});
				//页码号再填进去
				ul.append(numLi);
			});
			var nextPageLi=$("<li></li>").append($("<a></a>").append("&raquo;").attr("href","#"));
			var lastPageLi=$("<li></li>").append($("<a></a>").append("尾 页").attr("href","#"));
			
			if(!temp.hasNextPage){
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			}else{
				//下一页点击事件鼠标点击事件,当有下一页的时候才绑定
				nextPageLi.click(function(){
					to_page(temp.pageNum+1);
				});
				lastPageLi.click(function(){
					to_page(temp.pages);
				});
			}
			ul.append(nextPageLi).append(lastPageLi);
			//把ul加入到nav元素中
			var navEle=$("<nav></nav>").append(ul);
			//把这个元素添加到这个id为这个的地方
			navEle.appendTo("#page_info_nav");
		}
		//给编辑按钮绑定事件
		$(document).on("click",".edit_btn",function(){
			$("#email_add_span").empty();
			$("#div_email_update_input").removeClass("has-error");
			getDept("#dept_update_select");
			//2.查询员工信息,放到输入框中
			getEmp($(this).attr("edit-id"));
			//把员工的id传给模态框的更新按钮,点哪个员工对应的编辑按钮，就把该员工的ID传给更新按钮的一个属性
			$("#emp_update_btn").attr("update-id",$(this).attr("edit-id"));
			$("#empUpdateModal").modal({
				backdrop:"static"
			
			});
		});
		//获得员工信息，发送AJAX请求
		function getEmp(id){
			$.ajax({
				url:"${APP_PATH}/emp/"+id,
				type:"GET",
				success:function(result){
					console.log(result);
					var empData=result.extend.emp;
					//给input框赋值，直接用val()
					$("#empName_update_input").val(empData.empName);
					$("#email_update_input").val(empData.email);
					$("#empUpdateModal input[name=gender]").val([empData.gender]);
					$("#empUpdateModal select").val([empData.dId]);
				}
			});
		}
		
		//给更新按钮绑定点击事件
		$("#emp_update_btn").click(function(){
			//校验邮箱
			 var email=$("#email_update_input").val();
			 var regEmail=/^([a-zA-Z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			 if(!regEmail.test(email)){
				//alert("邮箱格式不正确");
				 show_validate_msg("#email_update_input","error","邮箱格式不正确");
				 return false;
			 }else{
				 show_validate_msg("#email_update_input","success","");
			 }
			 //发送Ajax去请求，保存
			 var id=$("#emp_update_btn").attr("update-id");
			 $.ajax({
				 url:"${APP_PATH}/emp/"+$(this).attr("update-id"),
				 type:"PUT",
				 data:$("#empUpdateModal form").serialize(),
				 success:function(result){
					
					 $("#empUpdateModal").modal('hide');
					 to_page(currentPage);
				 }
			 });
		});
		
		//当点击删除按钮的时候触发执行，单个删除
		$(document).on("click",".delete_btn",function(){
			//alert($(this).parents("tr").find("td:eq(1)").text());
			var empName=$(this).parents("tr").find("td:eq(2)").text();
			if(confirm("确认删除【"+empName+"】吗")){
				//确认就发送ajax请求
				var empId=$(this).attr("delete-id");
				//alert("要删除的ID："+empId);
				$.ajax({
					url:"${APP_PATH}/emp/"+empId,
					type:"DELETE",
					success:function(result){
						to_page(currentPage);
					}
				});
				
			}
		});
		//当点击表格头的复选框的时候
		$("#checkAll").click(function(){
			//alert("全选");
			//check_item
		   var flag=$(this).prop("checked");
			//设置选中状态和表头的一致
			$(".check_item").prop("checked",flag);
		});
		//判断复选框被选中了几个
		$(document).on("click",".check_item",function(){
		    var num=$(".check_item:checked").length;
		   	if(num==$(".check_item").length){
		   		$("#checkAll").prop("checked",true);
		   	}else{
		   		$("#checkAll").prop("checked",false);
		   	}
		});
		//点击全部删除 emp_delete_all_btn
		$("#emp_delete_all_btn").click(function(){
			var empNames=""; 
			var del_idstr="";
			//遍历
			$.each($(".check_item:checked"),function(){
			     empNames+=$(this).parents("tr").find("td:eq(2)").text()+",";
			     del_idstr+=$(this).parents("tr").find("td:eq(1)").text()+"-";
			});
			empNames=empNames.substring(0,empNames.length-1);
			del_idstr=del_idstr.substring(0,del_idstr.length-1);
			alert(del_idstr);
			//alert("员工姓名："+empNames);
			if(confirm("确认删除【"+empNames+"】吗？")){
				$.ajax({
					url:"${APP_PATH}/emp/"+del_idstr,
					type:"DELETE",
					success:function(result){
						//alert(result);
						//回到当前页
						$("#checkAll").prop("checked",false);
						to_page(currentPage);
					}
				});
			}
		});
		
		
	</script>

</body>
</html>