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
    <div class="container-fluid bg-dark text-white overflow-auto main-box-height">
        <div style="width: 80vw;" class="mx-auto">
            <c:if test="${sessionScope.loggedIn}">
                <div class="d-flex">
                    <div class="p-2">
                        Post írása:
                    </div>
                    <div class="p-2">
                        <!--button class="btn btn-primary" id="createPost" type="submit"><i class="bi bi-pencil-fill text-white"></i></button-->
                        <button class="btn" data-bs-toggle="modal" data-bs-target="#createPostModal"><i class="bi bi-pencil-fill text-white"></i></button>
                    </div>
                </div>
            </c:if>
            <table class="table table-bordered text-white">
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
                        <td><p class="overflow-hidden text-nowrap" style="text-overflow: ellipsis; width: 50vw;">${item.text}</p></td>
                        <td>${item.createdDate}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="modal fade" id="createPostModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="staticBackdropLabel">New Post</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="mb-3 mt-3 form-floating">
                            <input type="text" class="form-control" name="postTitle" placeholder="Title" id="postTitle">
                            <label for="postTitle">Title</label>
                        </div>
                        <div class="mb-3 mt-3 form-group">
                            <textarea class="form-control" id="postText" rows="3"></textarea>
                            <label for="postTitle">Comment</label>
                        </div>

                        <button id="postBtn" type="submit" class="btn btn-primary">Post</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
