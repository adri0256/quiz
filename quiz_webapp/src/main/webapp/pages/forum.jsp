<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 2022. 03. 21.
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% currentPage = "forum"; %>

<jsp:include page="/ForumController" />
<html>
<head>
    <title>Forum Posts</title>
</head>
<body>
    <%@ include file="common/navbar.jsp" %>

    <table class="table table-borderless">
        <caption class="caption-top">Forum Posts</caption>
        <thead>
            <th>Username</th>
            <th>Title</th>
            <th>Text</th>
            <th>Creation Date</th>
        </thead>
        <tbody>
        <c:forEach var="item" items="${requestScope.allPost}">
            <tr style="cursor: pointer" class='clickable-row' data-href='${item.id}'>
                <td style="width: 10px">${item.userName}</td>
                <td>${item.title}</td>
                <td>${item.text}</td>
                <td>${item.createdDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
