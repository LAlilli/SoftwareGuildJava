$(document).ready(function () {
    $("h1, h2").css({'text-align' : 'center'});
    $("h1").removeClass('myBannerHeading');
    $("h1").addClass('page-header');
    $("#yellowHeading").text("Yellow Team").css({'background-color' : 'yellow'});
    $("#orangeHeading").css({'background-color' : 'orange'});
    $("#blueHeading").css({'background-color' : 'blue'});
    $("#redHeading").css({'background-color' : 'red'});
    $("#yellowTeamList").append('<li>Joseph Banks</li><li>Simon Jones</li>');
    $("#oops").hide();
    $("#footerPlaceholder").remove();
    $(".footer").append('p').text("LA Ryter").append(" example@gmail.com").css({'font-style' : 'Courier', 'font-size' : '24'});
});