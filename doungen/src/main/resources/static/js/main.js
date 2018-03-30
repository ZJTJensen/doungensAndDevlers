$(document).ready(function() {
    $("#level").change(function(){
        $.ajax({
            method: 'post', /* Which HTTP verb? */
            data: $(this).serialize(), 
            success: fuction(serverResponce){

            }
        })
    })
})