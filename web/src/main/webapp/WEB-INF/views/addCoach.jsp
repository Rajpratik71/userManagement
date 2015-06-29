<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: chenbojian
  Date: 15-6-26
  Time: 上午11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Coach</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/css/bootstrap.min.css"/>

</head>
<body>
<div class="container">
    <h1>Add Coach</h1>
    <form:form method="post" commandName="coach" role="form">
        <div class="form-group">
            <label for="user.name">Name:</label>
            <form:input class="form-control" path="user.name"></form:input>
        </div>
        <div class="form-group">
            <label for="user.age">Age:</label>
            <form:input class="form-control" path="user.age"></form:input>
        </div>
        <div class="form-group">
            <label for="user.email">Email:</label>
            <form:input class="form-control" path="user.email"></form:input>
        </div>
        <div class="form-group">
            <label for="user.password">Password:</label>
            <form:password class="form-control" path="user.password"></form:password>
        </div>
        <div class="form-group">
            <input class="btn btn-primary" type="submit" value="新增"/>
            <a href="${pageContext.request.contextPath}/coach/">返回</a>
        </div>
    </form:form>
</div>
</body>
</html>
