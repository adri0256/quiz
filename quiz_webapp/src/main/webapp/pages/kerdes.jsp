<%--
  Created by IntelliJ IDEA.
  User: Feke
  Date: 2022. 03. 21.
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/KerdesController" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <caption>Posts</caption>
    <thead>
    <th>ID</th>
    <th>kerdesName</th>
    </thead>
    <c:forEach var="item" items="${requestScope.kerdes}">
        <tr>
            <td>${item.id}</td>
            <td>${item.kerdesName}</td>
            <td>${item.difficulty}</td>
        </tr>
    </c:forEach>
</table>
<table>
    <caption>Posts</caption>
    <thead>
    <th>ID</th>
    <th>kerdesID</th>
    <th>valaszName</th>
    </thead>
    <c:forEach var="item" items="${requestScope.valasz}">
        <tr>
            <td>${item.id}</td>
            <td>${item.kerdesID}</td>
            <td>${item.valaszName}</td>
        </tr>
    </c:forEach>
</table>
<table>
    <caption>Posts</caption>
    <thead>
    <th>ID</th>
    <th>name</th>
    </thead>
    <c:forEach var="item" items="${requestScope.temakor}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
