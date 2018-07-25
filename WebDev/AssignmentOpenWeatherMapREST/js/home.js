$(document).ready(function () {

    $('#zipcode-alert').hide();

    $('#weather-button').click(function(event) {
        //check if zipcode is numeric and 5 digits long
        if(!$.isNumeric($('#zipcode').val()) || $('#zipcode').val().length < 5 || $('#zipcode').val().length > 5){
            $('#zipcode-alert').show();
            return false;
        } else {
        
            // check for errors and display any that we have
            // pass the input associated with the add form to the validation function
            var haveValidationErrors = checkAndDisplayValidationErrors($('#weather-button').find('input'));
            
                // if we have errors, bail out by returning false
                if (haveValidationErrors) {
                    return false;
                }
    
            loadCurrentWeatherData();
            loadFiveDayWeatherData();
            $('#zipcode-alert').hide();                           
            return true;
        } 
    }); 
});

function loadCurrentWeatherData() {

    //clearCurrentWeatherData();  --not correctly clearing data
    var weatherDetails = $('#weather-details');
    var currentWeatherHeader = $('#city-weather-data');
    var zipcode = $('#zipcode').val();
    var units = $('#units').val().toLowerCase();
    
    var apiURL = 'http://api.openweathermap.org/data/2.5/weather?zip=' + zipcode + '&units=' + units + '&APPID=8068d2111bdda0492a92d99ab3ede180';

    $.ajax ({
        type: 'GET',
        url: apiURL,
        success: function (data, status) {
                var city = data.name;
                var icon = data.weather[0].icon;
                var iconurl = "http://openweathermap.org/img/w/" + icon + ".png";
                var iconDescription = data.weather[0].main;
                var temperature = data.main.temp;
                var wind = data.wind.speed;
                var humidity = data.main.humidity;

                $('#form').append('<hr/>');

                $('#current-weather-icon').attr('src', iconurl);
                $('#icon-area').append(iconDescription);

                var cityHeader = '<h2>' + 'Current weather in ' + city + '</h2>';
                currentWeatherHeader.prepend(cityHeader);

                var details = '<div>';
                    if(units == "imperial"){
                        details += '<p>' + 'Temperature: ' + temperature + " F" + '</p>';
                    } else if(units == "metric"){
                        details += '<p>' + 'Temperature: ' + temperature + " C" + '</p>';
                    }
                    details += '<p>' + 'Humidity: ' + humidity + "%" + '</p>'; 
                    if(units == "imperial"){
                        details += '<p>' + 'Wind: ' + wind + " miles/hour" + '</p>';
                    } else if(units == "metric"){
                        details += '<p>' + 'Wind: ' + wind + " kilometers/hour" + '</p>';
                    }
                    details += '</div>';
                weatherDetails.append(details);
        },
        error: function() {
            $('#errorMessages')
                .append($('<li>')
                .attr({class: 'list-group-item list-group-item-danger'})
                .text('Error calling web service.  Please try again later.'));
        }
    });
}

function loadFiveDayWeatherData() {
    
    var weatherForecastDay1 = $('#day1');
    var weatherForecastDay2 = $('#day2');
    var weatherForecastDay3 = $('#day3');
    var weatherForecastDay4 = $('#day4');
    var weatherForecastDay5 = $('#day5');
    var zipcode = $('#zipcode').val();
    var units = $('#units').val().toLowerCase();
    var forecastHeader = $('#forecast');
    
    var apiURL = 'http://api.openweathermap.org/data/2.5/forecast?zip=' + zipcode + '&units=' + units + '&APPID=8068d2111bdda0492a92d99ab3ede180';

    $('#forecast').prepend('<hr/>');

    var header = '<h2>' + "Five Day Forecast" + '</h2>';
    forecastHeader.prepend(header);

    $.ajax ({
        type: 'GET',
        url: apiURL,
        success: function (data, status) { 
            //get current date and format
            var d = new Date();
            var locale = "en-us";
            var month = d.toLocaleString(locale, {month: "long"});
            var date = d.getDate() + " " + month;

            //get other properties from JSON
            var icon = data.list[0].weather[0].icon;
            var iconurl = "http://openweathermap.org/img/w/" + icon + ".png";
            var iconDescription = data.list[0].weather[0].main;
            var lowTemp = data.list[0].main.temp_min;
            var highTemp = data.list[0].main.temp_max;           

            for(var i = 0; i < 5; i++){
                if(i == 0){
                    icon = data.list[i].weather[0].icon;
                    iconDescription = data.list[i].weather[0].main;
                    iconurl = "http://openweathermap.org/img/w/" + icon + ".png";
                    lowTemp = data.list[i].main.temp_min;
                    highTemp = data.list[i].main.temp_max;
                    $('#day1-weather-icon').attr('src', iconurl);
                    $('#day1').append(iconDescription);
                    
                    var details = '<div>';
                    details += '<h3>' + date + '</h3>';
                    if(units == "imperial"){
                        details += '<p>' + 'H: ' + highTemp + " F " + ' L: ' + lowTemp + " F" + '</p>';
                    } else if(units == "metric"){
                        details += '<p>' + 'H: ' + highTemp + " C " + ' L: ' + lowTemp + " C" + '</p>';
                    }
                    details += '</div>';

                    weatherForecastDay1.append(details); 
                }
                if(i==1){
                    //increment current date by 1 day
                    date = ((d.getDate() + 1) + " " + month);
                    icon = data.list[i].weather[0].icon;
                    iconDescription = data.list[i].weather[0].main;
                    iconurl = "http://openweathermap.org/img/w/" + icon + ".png";
                    lowTemp = data.list[i].main.temp_min;
                    highTemp = data.list[i].main.temp_max;
                    $('#day2-weather-icon').attr('src', iconurl);
                    $('#day2').append(iconDescription);

                    var details = '<div>';
                    details += '<h3>' + date + '</h3>';
                    if(units == "imperial"){
                        details += '<p>' + 'H: ' + highTemp + " F " + ' L: ' + lowTemp + " F" + '</p>';
                    } else if(units == "metric"){
                        details += '<p>' + 'H: ' + highTemp + " C " + ' L: ' + lowTemp + " C" + '</p>';
                    }
                    details += '</div>';

                    weatherForecastDay2.append(details); 
                }
                if(i==2){
                    //increment current date by 2 days
                    date = ((d.getDate() + 2) + " " + month);
                    icon = data.list[i].weather[0].icon;
                    iconDescription = data.list[i].weather[0].main;
                    iconurl = "http://openweathermap.org/img/w/" + icon + ".png";
                    lowTemp = data.list[i].main.temp_min;
                    highTemp = data.list[i].main.temp_max;
                    $('#day3-weather-icon').attr('src', iconurl);
                    $('#day3').append(iconDescription);

                    var details = '<div>';
                    details += '<h3>' + date + '</h3>';
                    if(units == "imperial"){
                        details += '<p>' + 'H: ' + highTemp + " F " + ' L: ' + lowTemp + " F" + '</p>';
                    } else if(units == "metric"){
                        details += '<p>' + 'H: ' + highTemp + " C " + ' L: ' + lowTemp + " C" + '</p>';
                    }
                    details += '</div>';

                    weatherForecastDay3.append(details); 
                }
                if(i==3){
                    //increment current date by 3 days
                    date = ((d.getDate() + 3) + " " + month);
                    icon = data.list[i].weather[0].icon;
                    iconDescription = data.list[i].weather[0].main;
                    iconurl = "http://openweathermap.org/img/w/" + icon + ".png";
                    lowTemp = data.list[i].main.temp_min;
                    highTemp = data.list[i].main.temp_max;
                    $('#day4-weather-icon').attr('src', iconurl);
                    $('#day4').append(iconDescription);

                    var details = '<div>';
                    details += '<h3>' + date + '</h3>';
                    if(units == "imperial"){
                        details += '<p>' + 'H: ' + highTemp + " F " + ' L: ' + lowTemp + " F" + '</p>';
                    } else if(units == "metric"){
                        details += '<p>' + 'H: ' + highTemp + " C " + ' L: ' + lowTemp + " C" + '</p>';
                    }
                    details += '</div>';

                    weatherForecastDay4.append(details); 
                }
                if(i==4){
                    //increment current date by 4 days
                    date = ((d.getDate() + 4) + " " + month);
                    icon = data.list[i].weather[0].icon;
                    iconDescription = data.list[i].weather[0].main;
                    iconurl = "http://openweathermap.org/img/w/" + icon + ".png";
                    lowTemp = data.list[i].main.temp_min;
                    highTemp = data.list[i].main.temp_max;
                    $('#day5-weather-icon').attr('src', iconurl);
                    $('#day5').append(iconDescription);

                    var details = '<div>';
                    details += '<h3>' + date + '</h3>';
                    if(units == "imperial"){
                        details += '<p>' + 'H: ' + highTemp + " F " + ' L: ' + lowTemp + " F" + '</p>';
                    } else if(units == "metric"){
                        details += '<p>' + 'H: ' + highTemp + " C " + ' L: ' + lowTemp + " C" + '</p>';
                    }
                    details += '</div>';

                    weatherForecastDay5.append(details); 
                }
            }
        },
        error: function() {
            $('#errorMessages')
                .append($('<li>')
                .attr({class: 'list-group-item list-group-item-danger'})
                .text('Error calling web service.  Please try again later.'));
        }
    });
}

function clearCurrentWeatherData() {
    $('#current-forecast-weather').empty();
}

function checkAndDisplayValidationErrors(input) {
    // clear displayed error message if there are any
    $('#errorMessages').empty();
    // check for HTML5 validation errors and process/display appropriately
    // a place to hold error messages
    var errorMessages = [];

    // loop through each input and check for validation errors
    input.each(function() {
        // Use the HTML5 validation API to find the validation errors
        if(!this.validity.valid)
        {
            var errorField = $('label[for='+this.id+']').text();
            errorMessages.push(errorField + ' ' + this.validationMessage);
        }
    });

    // put any error messages in the errorMessages div
    if (errorMessages.length > 0){
        $.each(errorMessages,function(index,message){
            $('#errorMessages').append($('<li>').attr({class: 'list-group-item list-group-item-danger'}).text(message));
        });
        // return true, indicating that there were errors
        return true;
    } else {
        // return false, indicating that there were no errors
        return false;
    }
}

