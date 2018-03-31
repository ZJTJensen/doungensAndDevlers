$(document).ready(function() {
    // $("#level").change(function(){
    //     var points;
    //     var total = document.getElementById("level").value;
    //     total = parseInt(total);
    //     if (total == 1){
    //         points = total * 10;
    //     }
    //     document.getElementById("points").innerHTML = points;
    //     document.getElementsByClassName("stats").value = 10;
    // })
    $("#level").keyup(function(){
        $.ajax({
            url: '/stat',
            method: 'post', /* Which HTTP verb? */
            data: $(this).parent().serialize(),
            success: function(serverResponse) {  /* What code should we run when the server responds? */
               $('#ajaxPlaceholder').html(serverResponse)
            }
        });
    })
})