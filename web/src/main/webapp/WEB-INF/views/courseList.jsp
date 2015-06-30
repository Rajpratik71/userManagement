<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chenbojian
  Date: 15-6-26
  Time: 下午4:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Course</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">
    <div class="form-group input-group ">
        <a href="${pageContext.request.contextPath}/course/add" class="btn btn-primary ">添加Course</a>
    </div>
    <div class="form-group input-group ">
        <input type="search" class="form-control"/>
        <span class="input-group-btn ">
            <button class="btn btn-default" type="button">Search</button>
        </span>
    </div>
</div>
<div class="container">
    <small>${message}</small>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th><input type="checkbox" onchange="select_all_or_select_none(this)"/></th>
            <th>ID</th>
            <%--<th>CoachId</th>--%>
            <th>CourseName</th>
            <th>CourseDate</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td><input type="checkbox" value="${course.id}"/></td>
                <td>${course.id}</td>
                <%--<td>${course.coachId}</td>--%>
                <td>${course.courseName}</td>
                <td>
                    <c:forEach var="date" items="${course.courseDates}">
                        ${date.courseDate}+++
                    </c:forEach>
                </td>
                <td>
                    <a class="btn btn-default" href="${pageContext.request.contextPath}/course/${course.id}/edit">修改</a>
                    <a class="btn btn-default"
                       href="${pageContext.request.contextPath}/course/${course.id}/delete">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
