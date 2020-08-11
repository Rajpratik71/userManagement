<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>Edit Course</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">

    <h1>Edit Course page</h1>

    <form:form method="post" modelAttribute="courseBean">
        <div class="form-group">
            <label for="courseName">CourseName:</label>
            <form:input path="courseName" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="coachId">Coach Id:</label>
            <form:input path="coachId" class="form-control"/>
        </div>
        <c:forEach var="course" items="${courseBean.courseDates}" varStatus="loop">
            <div class="form-group">
                <label for="courseDates[${loop.index}]">Date:</label>
                <form:input path="courseDates[${loop.index}]" cssClass="form-control"/>
            </div>
        </c:forEach>
        <div class="form-group">
            <input type="submit" class="btn btn-primary" value="Edit"/>
            <a class="btn btn-primary">New Date</a>
            <a href="${pageContext.request.contextPath}/course/">返回</a>
        </div>
    </form:form>
</div>
<script src="${pageContext.request.contextPath}/lib/js/jquery-1.11.1.min.js"></script>
<script>
    $(document).ready(function () {
        var index = ${fn:length(courseBean.courseDates)};

        $("a.btn").click(function () {
            var html = '<div class="form-group">';
            html += '<label for="courseDates' + index + '">Date:</label>';
            html += '<input id="courseDates' + index + '" type="text" name = "courseDates[' + index + ']" class="form-control"/>';
            html += '</div>';
            $("div.form-group:last").before(html);
            index++;
        });
        $("input[name=courseDates]").val("1991-12-30");
    })
</script>
</body>
</html>
