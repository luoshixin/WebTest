<%@ page import="java.util.List" %>
<%@ page import="com.test.bean.Items" %><%--
  Created by IntelliJ IDEA.
  User: lsx
  Date: 2018/4/24
  Time: 上午11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
 pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="/user/editUserListSubmit">
<table border="1">
    <tr>
        <th>选择</th>
        <th>用户名</th>
        <th>性别</th>
        <th>地址</th>
    </tr>

    <c:forEach items="${userList}" var="user" varStatus="status">
        <tr>
            <td><input type="checkbox" name="map['id']" value="${user.id}"> </td>
            <td><input type="text" name="map['username']" value="${user.username}"></td>
            <%--<td><input type="text" name="birthday" id="">${user.birthday}</td>--%>
            <td><input type="text" name="map['sex']" value="${user.sex}"></td>
            <td><input type="text" name="map['address']" value="${user.address}"></td>
        </tr>
    </c:forEach>

</table>
    <input type="submit">
</form>


</body>
</html>
