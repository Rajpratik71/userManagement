<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Calendar</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/css/bootstrap.css"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/lib/js/bower_components/fullcalendar/dist/fullcalendar.css"/>
    <script src="${pageContext.request.contextPath}/lib/js/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/lib/js/bootstrap.js"></script>
    <%--<script src="${pageContext.request.contextPath}/lib/js/bower_components/moment/moment.js"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/lib/js/underscore.min.js"></script>--%>
    <script src="${pageContext.request.contextPath}/lib/js/bower_components/moment/moment.js"></script>
    <script src="${pageContext.request.contextPath}/lib/js/bower_components/fullcalendar/dist/fullcalendar.js"></script>
</head>
<body>
<div class="container">
    <div class="calendar">

    </div>
</div>

<script>
    $(document).ready(function () {
        $(".calendar").fullCalendar({
            dayClick: function () {
                alert("hello");
            },
            events:  "${pageContext.request.contextPath}/course/calendar/feed"

        });
    })
</script>
</body>
</html>