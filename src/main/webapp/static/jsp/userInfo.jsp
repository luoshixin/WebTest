<%--
  Created by IntelliJ IDEA.
  User: lsx
  Date: 2018/5/2
  Time: 下午1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户资料</title>
</head>
<body>
<%
    System.out.println("页面: " + request.getAttribute("user"));
%>

<p>名字：${user.username}</p>
<p>性别：${user.sex}</p>
<p>住址：${user.address}</p>
<p>头像：${user.headImgUrl}</p>
</body>
</html>
