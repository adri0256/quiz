<%--
  Created by IntelliJ IDEA.
  User: Tear
  Date: 2022. 03. 26.
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% currentPage = "versenyek"; %>

<jsp:include page="/Versenyek" />
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@ include file="common/navbar.jsp" %>

<table>
    <caption>Versenyek</caption>
    <thead>
        <th>ID</th>
        <th>Idopont</th>
        <th>TemakorID</th>
    </thead>
<c:forEach var="item" items="${requestScope.allVersenyek}">
        <tr>
            <td>${item.id}</td>
            <td>${item.idopont}</td>
            <td>${item.temakorID}</td>
        </tr>
</c:forEach>
</table>
</body>
</html>
