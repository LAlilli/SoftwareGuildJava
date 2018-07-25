$(document).ready(function () {
    $('#akronInfoDiv, #minneapolisInfoDiv, #louisvilleInfoDiv').hide();
    $('#akronButton').on("click", function() {
        $('#akronInfoDiv').show();
        $('#akronWeather').hide();
        $('#akronWeatherButton').on("click", function() {
            $("#akronWeather").toggle();
        })
    })
    $('#minneapolisButton').on("click", function() {
        $('#minneapolisInfoDiv').show();
        $('#minneapolisWeather').hide();
        $('#minneapolisWeatherButton').on("click", function() {
            $("#minneapolisWeather").toggle();
        })
    })
    $('#louisvilleButton').on("click", function() {
        $('#louisvilleInfoDiv').show();
        $('#louisvilleWeather').hide();
        $('#louisvilleWeatherButton').on("click", function() {
            $("#louisvillenWeather").toggle();
        })
    })
    $('tr').not(":first").hover(function() {
        $(this).css("background-color", "WhiteSmoke");
    },
        function() {
            $(this).css("background-color", "");
        }
    );
});