jQuery(document).ready(function($) {
    $("#addIQ").click(function() {
        window.location = "addIQ.jsp";
    });
});

jQuery(document).ready(function($) {
    $(".clickable-IQ").click(function() {
        window.location = "editIQ.jsp?id=" + $(this).data("href");
    });
});

$(document).ready(function (){
    $('#postIQ').click(function (e) {
        postIQ(e);
    });
});

$(document).ready(function (){
    $('#updateIQ').click(function (e) {
        updateIQ(e);
    });

});

jQuery(document).ready(function($) {
    $(".rowdeleteIQ").click(function(e) {
        deleteIQ(e, $(this).data("href"));

    });
});

function postIQ(e){
    e.preventDefault();
    const IQUserID = document.getElementById("userID").value;
    const IQscore = document.getElementById("score").value;
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../IQ",
        data: {
            type: "AddIQ",
            addIQUserID: IQUserID,
            addIQScore: IQscore,
        },
        success: function (result){
            window.location = "iq.jsp";
        },
        error: function (result){
            window.location.reload();
        }
    });
}

function updateIQ(e){
    e.preventDefault();

    const updateIQID = document.getElementById("ID").innerText;
    const updateIQUserID = document.getElementById("userID").value;
    const updateIQscore = document.getElementById("score").value;

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../IQ",
        data: {
            type: "updateIQ",
            updateIQID: updateIQID,
            updateIQUserID: updateIQUserID,
            updateIQscore: updateIQscore,
        },
        success: function (result){
            window.location = "iq.jsp";
        },
        error: function (result){
            window.location.reload();
        }
    });
}

function deleteIQ(e, IQ) {

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../IQ",
        data: {
            type: "deleteIQ",
            deleteIQID: IQ
        },
        success: function (result){
            window.location.reload();
        },
        error: function (result){
            window.location.reload();
        }
    });
}