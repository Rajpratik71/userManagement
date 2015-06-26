<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: chenbojian
  Date: 15-6-26
  Time: 下午1:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Customer Info</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">

    <h1>Edit customer page</h1>
    <form:form method="post" commandName="customer">
        <div class="form-group">
            <label for="name">Name:</label>
            <form:input path="name" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <form:input path="email" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <form:password path="password" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="age">Age:</label>
            <form:input path="age" class="form-control"/>
        </div>
        <div class="form-group">
            <input class="btn btn-primary" type="submit" value="更新"/>
            <a href="${pageContext.request.contextPath}/user/">返回</a>
        </div>
    </form:form>
</div>
</body>
</html>
