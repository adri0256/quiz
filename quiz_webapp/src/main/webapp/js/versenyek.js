jQuery(document).ready(function($) {
    $("#addVersenyek").click(function() {
        window.location = "addVersenyek.jsp";
    });
});

jQuery(document).ready(function($) {
    $(".clickable-versenyek").click(function() {
        window.location = "editVersenyek.jsp?id=" + $(this).data("href");
    });
});


$(document).ready(function (){
    $('#postVersenyek').click(function (e) {
        postVersenyek(e);
    });
});

$(document).ready(function (){
    $('#updateVersenyek').click(function (e) {
        updateVerseny(e);
    });

});

jQuery(document).ready(function($) {
    $(".rowdeleteVerseny").click(function(e) {
            deleteVersenyek(e, $(this).data("href"));

    });
});

function postVersenyek(e){
    e.preventDefault();
    const Idopont = document.getElementById("Idopont").value;
    const TemakorID = document.getElementById("temakorID").value;
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../Versenyek",
        data: {
            type: "AddVerseny",
            addIdopont: Idopont,
            addTemakorID: TemakorID,
        },
        success: function (result){
            window.location = "versenyek.jsp";
        },
        error: function (result){
            window.location.reload();
        }
    });
}

function updateVerseny(e){
    e.preventDefault();

    const updateID = document.getElementById("ID").innerText;
    const updateIdopont = document.getElementById("Idopont").value;
    const updateTemakorID = document.getElementById("temakorID").value;

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../Versenyek",
        data: {
            type: "updateVerseny",
            updateID: updateID,
            updateIdopont: updateIdopont,
            updateTemakorID: updateTemakorID,
        },
        success: function (result){
            window.location = "versenyek.jsp";
        },
        error: function (result){
            window.location.reload();
        }
    });
}

function deleteVersenyek(e, versenyek) {
    console.log(versenyek+": bye");

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "../Versenyek",
        data: {
            type: "deleteVerseny",
            deleteID: versenyek
        },
        success: function (result){
            window.location.reload();
        },
        error: function (result){
            window.location.reload();
        }
    });
}