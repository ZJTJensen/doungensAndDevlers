$(document).ready(function() {
    $("#level").change(function(){
        var points;
        var total = document.getElementById("level").value;
        total = parseInt(total);
        if (total == 1){
            points = total * 10;
        }
        document.getElementById("points").innerHTML = points;
        document.getElementsByClassName("stats").value = 10;
    })
})