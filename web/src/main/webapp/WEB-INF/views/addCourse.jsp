<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: chenbojian
  Date: 15-6-26
  Time: 下午4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Course</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">
    <h1>Add course</h1>

    <form:form method="post" commandName="course" role="form">
        <div class="form-group">
            <label for="courseName">CourseName:</label>
            <form:input path="courseName" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="coach.id">Coach Id:</label>
            <form:input path="coach.id" class="form-control"/>
        </div>
        <div class="form-group">
            <input class="btn btn-primary" type="submit" value="新增" />
            <a href="${pageContext.request.contextPath}/course/">返回</a>
        </div>
    </form:form>
</div>

</body>
</html>
