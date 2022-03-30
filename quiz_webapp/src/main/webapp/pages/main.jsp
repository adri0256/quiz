<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 2022. 03. 30.
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% currentPage = "main"; %>

<jsp:include page="/MainController" />
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@ include file="common/navbar.jsp" %>
    <div class="container-fluid vh-100 bg-dark">

    </div>
</body>
</html>
