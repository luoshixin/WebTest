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

<%
    List<Items> itemsList = (List<Items>) request.getAttribute("itemsList");
    System.out.println("数据3：" + itemsList);
%>

<table border="1">
    <tr>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品描述</th>
    </tr>

    <c:forEach items="${itemsList}" var="item">
        <tr>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.detail}</td>
        </tr>
    </c:forEach>

</table>


</body>
</html>
