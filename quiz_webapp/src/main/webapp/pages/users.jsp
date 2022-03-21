<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 2022. 03. 21.
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/UsersController" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
<c:forEach var="item" items="${requestScope.users}">
    <tr>
        <td>${item.id}</td>
        <td>${item.username}</td>
        <td>${item.email}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
