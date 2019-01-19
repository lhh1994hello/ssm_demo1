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
 
<title>dataTable测试</title>
</head>
<body>
	 <table id="example" class="table table-striped table-hover success table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Age</th>
                <th>Start date</th>
                <th>Salary</th>
            </tr>
        </thead>
 
  <!--       <tfoot>
            <tr>
                <th>Name1</th>
                <th>Position1</th>
                <th>Office1</th>
                <th>Age1</th>
                <th>Start date1</th>
                <th>Salary1</th>
            </tr>
        </tfoot> -->
 
        <tbody id="example_tbody_id">

         
            <tr>
                <td>Tiger Nixon</td>
                <td>System Architect</td>
                <td>Edinburgh</td>
                <td>61</td>
                <td>2011/04/25</td>
                <td>$320,800</td>
            </tr>
            <tr>
                <td>Garrett Winters</td>
                <td>Accountant</td>
                <td>Tokyo</td>
                <td>63</td>
                <td>2011/07/25</td>
                <td>$170,750</td>
            </tr>
            <tr>
                <td>Ashton Cox</td>
                <td>Junior Technical Author</td>
                <td>San Francisco</td>
                <td>66</td>
                <td>2009/01/12</td>
                <td>$86,000</td>
            </tr>
            <tr>
                <td>Brielle Williamson</td>
                <td>Integration Specialist</td>
                <td>New York</td>
                <td>61</td>
                <td>2012/12/02</td>
                <td>$372,000</td>
            </tr>
            <tr>
                <td>Herrod Chandler</td>
                <td>Sales Assistant</td>
                <td>San Francisco</td>
                <td>59</td>
                <td>2012/08/06</td>
                <td>$137,500</td>
            </tr>
            <tr>
                <td>Rhona Davidson</td>
                <td>Integration Specialist</td>
                <td>Tokyo</td>
                <td>55</td>
                <td>2010/10/14</td>
                <td>$327,900</td>
            </tr>
            <tr>
                <td>Colleen Hurst</td>
                <td>Javascript Developer</td>
                <td>San Francisco</td>
                <td>39</td>
                <td>2009/09/15</td>
                <td>$205,500</td>
            </tr>
            <tr>
                <td>Sonya Frost</td>
                <td>Software Engineer</td>
                <td>Edinburgh</td>
                <td>23</td>
                <td>2008/12/13</td>
                <td>$103,600</td>
            </tr>
            <tr>
                <td>Jena Gaines</td>
                <td>Office Manager</td>
                <td>London</td>
                <td>30</td>
                <td>2008/12/19</td>
                <td>$90,560</td>
            </tr>
            <tr>
                <td>Haley Kennedy</td>
                <td>Senior Marketing Designer</td>
                <td>London</td>
                <td>43</td>
                <td>2012/12/18</td>
                <td>$313,500</td>
            </tr>
            <tr>
                <td>Tatyana Fitzpatrick</td>
                <td>Regional Director</td>
                <td>London</td>
                <td>19</td>
                <td>2010/03/17</td>
                <td>$385,750</td>
            </tr>
            <tr>
                <td>Michael Silva</td>
                <td>Marketing Designer</td>
                <td>London</td>
                <td>66</td>
                <td>2012/11/27</td>
                <td>$198,500</td>
            </tr>
            <tr>
                <td>Paul Byrd</td>
                <td>Chief Financial Officer (CFO)</td>
                <td>New York</td>
                <td>64</td>
                <td>2010/06/09</td>
                <td>$725,000</td>
            </tr>
            <tr>
                <td>Gloria Little</td>
                <td>Systems Administrator</td>
                <td>New York</td>
                <td>59</td>
                <td>2009/04/10</td>
                <td>$237,500</td>
            </tr>
        </tbody>
    </table>
 
<script type="text/javascript">
    
    $(function(){
        $('#example').dataTable({
       	 
       	 "ordering": true,//是否排序，默认为true
       	// "bServerSide" : true,//是否启动服务器端数据导入,开启后
       	// "serverSide": true,
       	 "aLengthMenu" : [5, 40, 60], //设置每页显示多少条记录得下拉列表选项
       	 "iDisplayLength" : 5, //默认显示的记录数  ,这个值和上面数组中第一个值相同最好
         "bInfo" : true, //是否显示页脚信息，DataTables插件左下角显示记录数   
       	 "sPaginationType" : "full_numbers", //显示首页和尾页按钮
       	 "searching": true, //是否显示搜索框 
       	 //"bSort" : false, //是否启动各个字段的排序功能  
       	 "aaSorting" : [[1, "desc"]], //默认的排序方式，第2列，升序排列  
       //	"sAjaxSource": "${APP_PATH}/dataTable/test3", //给服务器发请求的url
          "columns": [
    	        {"data": "Name", "bSortable": false,"mDataProp" : "USERID",  
    	            	   "bVisible" : true, "sTitle" : "用户名", "sDefaultContent" : "",},//这一列不进行排序
    		    {"data": "Position"},
    		    {"data": "Office","bSortable": false},
    		    {"data": "Age"},
    		    {"data": "Start date"},
    		    {"data": "Salary"}
          ],
          
          
        /* 
 		  "ajax": {
		        "url": "${APP_PATH}/dataTable/test3",
		         "type":"POST",
		         success:function(result){
		            console.log(result);
		            fillData(result);
		          }
		  }, */ 
       	 "oLanguage": {//国际化提示信息    		  
       		 "sLengthMenu": "每页显示 _MENU_ 条记录",
       		 "sZeroRecords": "抱歉， 没有找到",
       		 "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
       		 "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
       		 "sInfoEmpty": "",
       		 "sZeroRecords": "无数据",
       		 "sProcessing": "查询中...",
       		 "sSearch" : "搜索",  
       		 "oPaginate": {
   	                "sFirst": "首页",
   	                "sPrevious": "前一页",
   	                "sNext": "后一页",
   	                "sLast": "尾页"
   	            } 
       	 },
        });
        
        
        function fillData(result){
        	$("#example_tbody_id").html("");//清空数据
        	var listData=result.extend.listOfficeBean;
        	$.each(listData,function(index,data){
        		console.log(data);
        		var trObj1=$("<tr></tr>");
        		
        		var tdObj1=$("<td></td>").append(data.username);
        		var tdObj2=$("<td></td>").append(data.position);
        		var tdObj3=$("<td></td>").append(data.office);
        		var tdObj4=$("<td></td>").append(data.age);
        		var tdObj5=$("<td></td>").append(data.createTime);
        		var tdObj6=$("<td></td>").append(data.salary);
        		trObj1.append(tdObj1).append(tdObj2).append(tdObj3).append(tdObj4).append(tdObj5).append(tdObj6);
        		$("#example_tbody_id").append(trObj1);
        	});
        	
        }
        
    });
    	

 
</script>

 
</body>
</html>