<%--
  Created by IntelliJ IDEA.
  User: Tear
  Date: 2022. 03. 26.
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% currentPage = "reguserverseny"; %>

<jsp:include page="/RegUserVerseny" />
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@ include file="common/navbar.jsp" %>

<table>
    <caption>RegUserVerseny</caption>
    <thead>
    <th>userID</th>
    <th>versenyID</th>
    </thead>
    <c:forEach var="item" items="${requestScope.allRegUserVerseny}">
        <tr>
            <td>${item.userID}</td>
            <td>${item.versenyID}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
