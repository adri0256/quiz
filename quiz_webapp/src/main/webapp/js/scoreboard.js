jQuery(document).ready(function($) {
    $("#addScoreboard").click(function() {
        window.location = "addScoreboard.jsp";
    });
});

jQuery(document).ready(function($) {
    $(".clickable-scoreboard").click(function() {
        window.location = "editScoreboard.jsp?id=" + $(this).data("href");
    });
});

$(document).ready(function (){
    $('#postScoreboard').click(function (e) {
        postScoreboard(e);
    });
});

$(document).ready(function (){
    $('#updateScoreboard').click(function (e) {
        updateScoreboard(e);
    });

});

jQuery(document).ready(function($) {
    $(".rowdeleteScoreboard").click(function(e) {
        deleteScoreboard(e, $(this).data("href"));

    });
});

function postScoreboard(e){
    e.preventDefault();
    const addScoreUserID = document.getElementById("userID").value;
    const addScoreScore = document.getElementById("score").value;
    const addScoreDifficulty = document.getElementById("difficulty").value;
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../ScoreboardController",
        data: {
            type: "AddScore",
            addScoreUserID: addScoreUserID,
            addScoreScore: addScoreScore,
            addScoreDifficulty: addScoreDifficulty
        },
        success: function (result){
            window.location = "scoreboard.jsp";
        },
        error: function (result){
            window.location.reload();
        }
    });
}

function updateScoreboard(e){
    e.preventDefault();

    const updateScoreID = document.getElementById("ID").innerText;
    const updateScoreUserID = document.getElementById("userID").value;
    const updateScoreScore = document.getElementById("score").value;
    const updateScoreDifficulty = document.getElementById("difficulty").value;

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../ScoreboardController",
        data: {
            type: "updateScore",
            updateScoreID: updateScoreID,
            updateScoreUserID: updateScoreUserID,
            updateScoreScore: updateScoreScore,
            updateScoreDifficulty: updateScoreDifficulty
        },
        success: function (result){
            window.location = "scoreboard.jsp";
        },
        error: function (result){
            window.location.reload();
        }
    });
}

function deleteScoreboard(e, scoreboard) {

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../ScoreboardController",
        data: {
            type: "deleteScore",
            deleteScoreID: scoreboard
        },
        success: function (result){
            window.location.reload();
        },
        error: function (result){
            window.location.reload();
        }
    });
}