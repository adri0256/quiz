jQuery(document).ready(function($) {
    $(".clickable-row").click(function() {
        window.location = "forumPostDetails.jsp?id=" + $(this).data("href");
    });
});

$(document).ready(function (){
    $('#postComment').click(function (e) {
        post(e);
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