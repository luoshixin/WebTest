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
</head>
<body>

<form method="post" action="/user/addUser" enctype="multipart/form-data">
    <p>名字：<input type="text" name="username"></p>
    <p>性别：<input type="text" name="sex"></p>
    <p>住址：<input type="text" name="address"></p>
    <p>头像：<input type="file" name="headImgFile"></p>
    <p>头像：<input type="file" name="headImgFile"></p>
    <p>头像：<input type="file" name="headImgFile"></p>
    <input type="submit">
</form>

</body>
</html>
