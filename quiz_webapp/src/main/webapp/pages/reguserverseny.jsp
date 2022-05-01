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


    <div style="display: flow-root" class="container-fluid bg-dark overflow-auto main-box-height text-white">
        <table class="table table-borderless text-white">
            <h1>RegUserVerseny</h1>
            <thead>
            <th>regID</th>
            <th>userID</th>
            <th>versenyID</th>
            </thead>
            <c:forEach var="item" items="${requestScope.allRegUserVerseny}">
                <tr style="cursor: pointer" class="tabletr">
                    <td class='clickable-reguserverseny' data-href='${item.regID}'>${item.regID}</td>
                    <td class='clickable-reguserverseny' data-href='${item.regID}'>${item.userID}</td>
                    <td class='clickable-reguserverseny' data-href='${item.regID}'>${item.versenyID}</td>
                    <td class="rowdeleteRegUserVerseny" data-href='${item.regID}'><button class="deletebtn" id="deleteRegUserVerseny"><i class="bi bi-trash3-fill text-white"></i></button></td>
                </tr>
            </c:forEach>
        </table>
        <button id="addRegUserVerseny" type="submit" class="btn btn-primary">Add new</button>
    </div>
</body>
</html>
