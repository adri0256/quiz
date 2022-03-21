<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 2022. 03. 21.
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/ScoreboardController" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <caption>Scoreboard</caption>
    <thead>
        <th>ID</th>
        <th>userID</th>
        <th>score</th>
        <th>difficulty</th>
    </thead>
    <c:forEach var="item" items="${requestScope.scores}">
        <tr>
            <td>${item.id}</td>
            <td>${item.userId}</td>
            <td>${item.score}</td>
            <td>${item.difficulty}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
