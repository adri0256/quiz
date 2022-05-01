<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 2022. 04. 23.
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/ForumController" />
<html>
<head>
    <title>Title</title>
</head>
<body class="overflow-hidden">
<%@ include file="common/navbar.jsp" %>
<div style="display: flow-root" class="container-fluid bg-dark text-white overflow-auto main-box-height">
    <div id="postDetails" class="mx-auto h-50 border border-2 rounded-3 border-light mt-5 px-2 py-2 postBorder">
        <div id="leftBox" style="width: 10%" class="float-start h-100 border border-1 border-light px-2 py-2">
            <div id="userPostBox" class="h-50 border border-1 border-light px-2 py-2">
                <p class="text-center">User:</p><br />
                <p class="text-center">${requestScope.currentPost.userName}</p>
            </div>
            <div id="datePostBox" class="h-50 border border-1 border-light px-2 py-2">
                <p class="text-center">Posted: </p><br />
                <p class="text-center">${requestScope.currentPost.createdDate}</p>
            </div>
        </div>
        <div id="rightBox" style="width: 90%" class="float-end h-100 border border-1 border-light px-2 py-2">
            <div id="postTitleBox" class="h-25 float-start w-100 border border-1 border-light px-2 py-2">
                <div style="width: 90%" class="float-start px-2 py-2">
                    <h1 class="text-center">${requestScope.currentPost.title}</h1>
                </div>
                <c:if test="${sessionScope.userId == requestScope.currentPost.userId && sessionScope.loggedIn}">
                    <div id="postOwnerBox" style="width: 5%" class="float-end px-2 py-2">
                        <input type="hidden" value="${requestScope.currentPost.id}" id="currentPostId" />
                        <button class="btn" data-bs-toggle="modal" data-bs-target="#modifyPostModal"><i class="bi bi-pencil-square text-white"></i></button>
                        <button class="btn" id="deletePostBtn"><i class="bi bi-trash3-fill text-white"></i></button>
                    </div>
                </c:if>
            </div>
            <div class="clearfix"></div>
            <div id="postTextBox" class="h-75 border border-1 border-light px-4 py-4">
                <p>${requestScope.currentPost.text}</p>
            </div>
        </div>
    </div>
    <div id="commentSeparator" class="border border-2 rounded-3 border-light">
    </div>
    <div class="w-75 mx-auto" style="height: 120px">
        <c:if test="${sessionScope.loggedIn}">
            <form>
                <div class="mb-3 mt-3 form-group float-start w-75 h-100">
                    <label for="comment">Write a Comment: </label>
                    <textarea class="form-control" id="comment" rows="3"></textarea>
                </div>
                <div class="float-end w-25 d-flex align-items-center h-100">
                    <button id="postComment" type="submit" class="btn btn-primary">Post</button>
                </div>
                <div class="clearfix"></div>
            </form>
        </c:if>
    </div>
    <div id="commentsBox" style="width: 80vw;" class="mx-auto mt-lg-5 mb-lg-5">
        <c:forEach var="item" items="${requestScope.currentPostsComments}">
            <div id="commentBox" class="d-flex bd-highlight border border-1 border-light">
                <div class="p-2 bd-highlight d-flex flex-column bd-highlight border-end border-1 border-light">
                    <div class="p-2 bd-highlight border-bottom border-1 border-light">${item.userName}</div>
                    <div class="p-2 bd-highlight fs-6">${item.createdDate}</div>
                </div>
                <div style="height: 100px;" class="p-2 flex-grow-1 bd-highlight border-end border-1 border-light d-flex align-items-center">
                    <p class="text-break">${item.text}</p>
                </div>
                <c:if test="${sessionScope.userId == item.userId}">
                    <div class="p-2 bd-highlight d-flex align-items-center">
                        <input type="hidden" value="${item.id}" id="commentId" />
                        <button class="btn" id="${item.id}" data-bs-toggle="modal" data-bs-target="#modifyCommentModal"><i class="bi bi-pencil-square text-white"></i></button>
                        <button class="btn deleteCommentBtn ${item.id}" id="deleteComment"><i class="bi bi-trash3-fill text-white"></i></button>
                    </div>
                </c:if>
            </div>
        </c:forEach>
    </div>
    <div class="modal fade" id="modifyCommentModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-dark" id="staticBackdropLabel">Comment</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="mb-3 mt-3 form-group">
                            <!--input type="text" class="form-control" name="comment" placeholder="Comment" id="modifyComment"-->
                            <label class="text-dark" for="modifyComment">Comment</label>
                            <textarea class="form-control" id="modifyComment" rows="3"></textarea>
                        </div>

                        <button id="modifyCommentBtn" type="submit" class="btn btn-primary">Save</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="modifyPostModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="">Modify Post</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="mb-3 mt-3 form-floating">
                            <input type="text" class="form-control" name="postTitle" placeholder="Title" id="modifiedPostTitle" value="${requestScope.currentPost.title}">
                            <label for="modifiedPostTitle">Title</label>
                        </div>
                        <div class="mb-3 mt-3 form-group">
                            <textarea class="form-control" id="modifiedPostText" rows="3">${requestScope.currentPost.text}</textarea>
                            <label for="modifiedPostText">Text</label>
                        </div>

                        <button id="modifyPostBtn" type="submit" class="btn btn-primary">Post</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
