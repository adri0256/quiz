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

    <div style="display: flow-root" class="container-fluid bg-dark overflow-auto main-box-height text-white">
        <h1>Versenyek</h1>
        <table class="table table-borderless text-white">
                <thead>
                <th>ID</th>
                <th>Idopont</th>
                <th>TemakorID</th>
                </thead>
            <c:forEach var="item" items="${requestScope.allVersenyek}">
                <tr style="cursor: pointer" class="tabletr">
                    <td class='clickable-versenyek' data-href='${item.id}'>${item.id}</td>
                    <td class='clickable-versenyek' data-href='${item.id}'>${item.idopont}</td>
                    <td class='clickable-versenyek' data-href='${item.id}'>${item.temakorID}</td>
                    <td class="rowdeleteVerseny" data-href='${item.id}' ><button class="deletebtn" id="deleteVersenyek" ><i class="bi bi-trash3-fill text-white"></i></button></td>
                </tr>
            </c:forEach>
        </table>

        <button id="addVersenyek" type="submit" class="btn btn-primary">Add new</button>
    </div>

</body>
</html>
