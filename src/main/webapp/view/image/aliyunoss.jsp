<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>7牛云测试</title>
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-1.12.4.js"></script>
    <script src="${APP_PATH}/static/js/ajaxfileupload.js" type="text/javascript"></script>
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <style>
        img {
            width: 228px;
            height: 140px;
        }

    </style>
</head>
<body>
<div class="container-fluid">
    <h4>7牛云测试</h4>
    <form action="${APP_PATH}/qiniuyun/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file"/><br/><br/>
        <button type="submit" class="btn btn-success">上传</button>
    </form>

    <br/>
    <span>异步上传图片:</span>
    <input class="fileInput" id="file_URL" type="file" name="file" title="修改头像">
    <br/>
    <img id="imgId" alt="测试七牛云" title="测试七牛云" src="http://lhh1994.xyz/9a829e8e02b3409d9c2cad78dac6b86e.jpg">

</div>

<script type="text/javascript">
    $(function () {

        $(document).on('change', '#file_URL', function () {
            debugger;
            ajaxFileUpload();
            console.log("改变了...");
        });

        //头像上传
        function ajaxFileUpload() {
            $.ajaxFileUpload({
                url: "${APP_PATH}/aliyunoss/upload",
                secureuri: false, //是否需要安全协议，一般设置为false
                fileElementId: 'file_URL', //文件上传域的ID
                type: "POST",
                dataType: 'json', //返回值类型 一般设置为json
                success: function (data, status) {
                    console.log("data:", data);
                    var code = data.code;
                    console.log("返回码code:" + code);
                    var imageUrl = data.extend.imageUrl;
                    var test_url = data.extend.test_url;
                    console.log("imageUrl:" + imageUrl)
                    console.log("test_url:" + test_url)
                    if (imageUrl == null || imageUrl == undefined || imageUrl == "") {
                        console.log("图片路径错误Q");
                        return;
                    }
                    if (imageUrl.indexOf("amp;") > -1) {
                        imageUrl = imageUrl.replace(/amp;/g, "");
                        console.log("替换url中转译的字符");
                    }
                    $("#imgId").attr("src", imageUrl);
                },
                error: function (data, status, e)//服务器响应失败处理函数
                {
                    alert(e);
                }
            });
        }
    });

</script>
</body>
</html>