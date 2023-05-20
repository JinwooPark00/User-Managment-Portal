$(document).ready(function(){
    $("#search-form").submit(function (event){
        event.preventDefault();
        ajax_submit();
    });

});

function ajax_submit(){
    var search = {}
    search["username"] = $("#username").val();

    $("btn-search").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/search",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            document.getElementById("feedback").innerHTML = JSON.stringify(data, null, 4);
            console.log("SUCCESS: ", data);
            $("btn-search").prop("disabled", false);
        },
        error: function (e) {
            document.getElementById("feedback").innerHTML = JSON.stringify(e.responseText);
                        console.log("not success: ", e);
            $("btn-search").prop("disabled", false);
        }
    });
}