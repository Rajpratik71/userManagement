<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chenbojian
  Date: 15-6-24
  Time: 下午1:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list all customers</title>
    <link rel="stylesheet" href="../lib/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">
    <%--<small>${message}</small>--%>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th><input type="checkbox"/></th>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Age</th>
            <th>privateCoach</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td><input type="checkbox" name="selected_customer_id" value="${customer.id}"/></td>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.email}</td>
                <td>${customer.age}</td>
                <td>${customer.privateCoach == null ? "null" : customer.privateCoach.user.name}</td>
                <td>
                    <a class="btn btn-default" href="${pageContext.request.contextPath}/customer/${customer.id}}/edit">修改</a>
                    <a class="btn btn-default" href="${pageContext.request.contextPath}/customer/${customer.id}/delete">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="../lib/js/jquery-1.11.1.min.js"></script>
<script src="../lib/js/bootstrap.min.js"></script>
</body>
</html>
