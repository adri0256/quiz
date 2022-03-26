<%--
  Created by IntelliJ IDEA.
  User: Tear
  Date: 2022. 03. 26.
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/IQ" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <caption>IQ</caption>
    <thead>
    <th>ID</th>
    <th>userID</th>
    <th>score</th>
    </thead>
    <c:forEach var="item" items="${requestScope.allIQ}">
        <tr>
            <td>${item.id}</td>
            <td>${item.userID}</td>
            <td>${item.score}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
