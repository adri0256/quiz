jQuery(document).ready(function($) {
    $(".clickable-row").click(function() {
        window.location = "forumPostDetails.jsp?id=" + $(this).data("href");
    });
});

$(document).ready(function (){
    $('#postComment').click(function (e) {
        postComment(e);
    });

    $('#postBtn').click(function (e) {
        createPost(e);
    })

    let btns = document.getElementsByClassName("deleteCommentBtn");

    for (let i = 0; i < btns.length; i++) {
        btns[i].addEventListener("click", deleteComment);
    }

    $('#modifyCommentBtn').click(function (e) {
        modify(e);
    });

    $('#deletePostBtn').click(function (e) {
        deletePost(e);
    })
});

function postComment(e){
    e.preventDefault();

    const commentText = document.getElementById("comment").value;

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../ForumController",
        data: {
            type: "create",
            comment: commentText
        },
        success: function (result){
            window.location.reload();
        },
        error: function (result){
            window.location.reload();
        }
    });
}
function deleteComment(e){
    e.preventDefault();

    const commentIdText = document.getElementById("commentId").value;

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../ForumController",
        data: {
            type: "delete",
            commentId: commentIdText
        },
        success: function (result){
            window.location.reload();
        },
        error: function (result){
            window.location.reload();
        }
    });
}
function modify(e){
    e.preventDefault();

    const commentIdText = document.getElementById("commentId").value;
    const newCommentText = document.getElementById("modifyComment").value;

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../ForumController",
        data: {
            type: "modify",
            commentId: commentIdText,
            newComment: newCommentText
        },
        success: function (result){
            window.location.reload();
        },
        error: function (result){
            window.location.reload();
        }
    });
}
function createPost(e){
    e.preventDefault();

    const postTitleVal = document.getElementById("postTitle").value;
    const postTextVal = document.getElementById("postText").value;

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../ForumController",
        data: {
            type: "createPost",
            postTitle: postTitleVal,
            postText: postTextVal
        },
        success: function (result){
            window.location.reload();
        },
        error: function (result){
            window.location.reload();
        }
    });
}
function deletePost(e){
    e.preventDefault();

    const postIdText = document.getElementById("currentPostId").value;

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../ForumController",
        data: {
            type: "deletePost",
            postId: postIdText
        },
        success: function (result){
            window.location.href = "../pages/forum.jsp";
        },
        error: function (result){
            window.location.reload();
        }
    });
}