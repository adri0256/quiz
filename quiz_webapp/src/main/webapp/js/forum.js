jQuery(document).ready(function($) {
    $(".clickable-row").click(function() {
        window.location = "forumPostDetails.jsp?id=" + $(this).data("href");
    });
});

$(document).ready(function (){
    $('#postComment').click(function (e) {
        post(e);
    });
    $('#deleteComment').click(function (e) {
        deleteComment(e);
    });
    $('#modifyCommentBtn').click(function (e) {
        modify(e);
    });
});

function post(e){
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