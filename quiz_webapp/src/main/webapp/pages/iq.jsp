<%--
  Created by IntelliJ IDEA.
  User: Tear
  Date: 2022. 03. 26.
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% currentPage = "IQ"; %>

<jsp:include page="/IQ" />
<html>
<head>
    <title>IQ</title>
</head>
<body>
    <%@ include file="common/navbar.jsp" %>

    <div style="display: flow-root" class="container-fluid bg-dark overflow-auto main-box-height text-white">
        <h1>IQ</h1>
        <table class="table table-borderless text-white">
            <thead>
            <th>ID</th>
            <th>userID</th>
            <th>score</th>
            </thead>
            <c:forEach var="item" items="${requestScope.allIQ}">
                <tr style="cursor: pointer" class="tabletr">
                    <td class='clickable-IQ' data-href='${item.id}'>${item.id}</td>
                    <td class='clickable-IQ' data-href='${item.id}'>${item.userID}</td>
                    <td class='clickable-IQ' data-href='${item.id}'>${item.score}</td>
                    <td class="rowdeleteIQ" data-href='${item.id}' ><button class="deletebtn" id="deleteIQ" ><i class="bi bi-trash3-fill text-white"></i></button></td>
                </tr>
            </c:forEach>
        </table>

        <button id="addIQ" type="submit" class="btn btn-primary">Add new</button>
    </div>


</body>
</html>
