<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/MainController" />
<html>
<body>
<h2>Hello World!</h2>

<c:forEach var="item" items="${requestScope.users}">
    <tr>
        <td>${item.id}</td>
        <td>${item.username}</td>
        <td>${item.email}</td>
    </tr>
</c:forEach>
</body>
</html>
