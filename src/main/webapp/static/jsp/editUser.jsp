<%--
  Created by IntelliJ IDEA.
  User: lsx
  Date: 2018/5/2
  Time: 下午1:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>填写用户资料</title>
    <script src="/static/js/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        function sendJson() {
            $.ajax({
                type: "POST",
                url: "/user/addUser",
                contentType: "application/json",
                data: JSON.stringify({'username': '张三', sex: '男', address: '四川省'}),
                dataType: "json",
                statusCode: {
                    404: function () {
                        alert('page not found');
                    }
                },
                success: function (data, textStatus) {
                }
            });
        }
    </script>
</head>
<body>

<p><input type="button" value="提交json" onclick="sendJson()"></p>

</body>
</html>
