<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 2022. 03. 21.
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/ForumController" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <caption>Posts</caption>
    <thead>
        <th>ID</th>
        <th>userId</th>
        <th>createdDate</th>
        <th>title</th>
        <th>text</th>
    </thead>
    <c:forEach var="item" items="${requestScope.allPost}">
        <tr>
            <td>${item.id}</td>
            <td>${item.userId}</td>
            <td>${item.createdDate}</td>
            <td>${item.title}</td>
            <td>${item.text}</td>
        </tr>
    </c:forEach>
</table>
<table>
    <caption>Posts</caption>
    <thead>
        <th>ID</th>
        <th>userId</th>
        <th>postId</th>
        <th>createdDate</th>
        <th>text</th>
    </thead>
    <c:forEach var="item" items="${requestScope.allComment}">
        <tr>
            <td>${item.id}</td>
            <td>${item.userId}</td>
            <td>${item.postId}</td>
            <td>${item.createdDate}</td>
            <td>${item.text}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
