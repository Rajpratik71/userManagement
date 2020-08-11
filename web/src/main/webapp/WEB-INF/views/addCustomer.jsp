<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: chenbojian
  Date: 15-6-26
  Time: 下午1:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Customer</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/css/bootstrap.min.css" />

</head>
<body>
<div class="container">
  <h1>新增Customer</h1>

  <form:form method="post" commandName="customer" role="form">
  <div class="form-group">
    <label for="name">Name:</label>
    <form:input path="name" class="form-control"/>
  </div>
  <div class="form-group">
    <label for="email">Email:</label>
    <form:input path="email" class="form-control" />
  </div>
  <div class="form-group">
    <label for="age">Age:</label>
    <form:input path="age" class="form-control"/>
  </div>
  <div class="form-group">
    <input class="btn btn-primary" type="submit" value="新增" />
    <a href="${pageContext.request.contextPath}/customer/">返回</a>
  </div>
  </form:form>
</body>
</html>
