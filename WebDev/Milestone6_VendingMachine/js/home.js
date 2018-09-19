$(document).ready(function () {
    //on initial load, items should be loaded into panels on page
    loadVendingItems();
    moneyHandler();
    //purchaseItem();

    
});

function loadVendingItems() {
    
    $.ajax ({
        type: 'GET',
        url: 'http://localhost:8080/items',
        success: function (data, status) {

                var itemId = data[0].id;
                var itemName = data[0].name;
                var itemPrice = data[0].price;
                var numberOfItem = data[0].quantity;

                for(var i = 0; i < 9; i++){
                    if(i==0){
                        itemId = data[i].id;
                        itemName = data[i].name;
                        itemPrice = data[i].price;
                        numberOfItem = data[i].quantity;
                        var panel = '<div>';
                        panel += '<p>' + itemId + '</p>';
                        panel += '<p>' + itemName + '</p>';
                        panel += '<p>' + itemPrice + '</p>';
                        panel += '<p>' + numberOfItem + '</p>';
                        panel += '</div>';
                    $('#item1').append(panel);
                    }
                    if(i==1){
                        itemId = data[i].id;
                        itemName = data[i].name;
                        itemPrice = data[i].price;
                        numberOfItem = data[i].quantity;
                        var panel = '<div>';
                        panel += '<p>' + itemId + '</p>';
                        panel += '<p>' + itemName + '</p>';
                        panel += '<p>' + itemPrice + '</p>';
                        panel += '<p>' + numberOfItem + '</p>';
                        panel += '</div>';
                    $('#item2').append(panel);
                    }
                    if(i==2){
                        itemId = data[i].id;
                        itemName = data[i].name;
                        itemPrice = data[i].price;
                        numberOfItem = data[i].quantity;
                        var panel = '<div>';
                        panel += '<p>' + itemId + '</p>';
                        panel += '<p>' + itemName + '</p>';
                        panel += '<p>' + itemPrice + '</p>';
                        panel += '<p>' + numberOfItem + '</p>';
                        panel += '</div>';
                    $('#item3').append(panel);
                    }
                    if(i==3){
                        itemId = data[i].id;
                        itemName = data[i].name;
                        itemPrice = data[i].price;
                        numberOfItem = data[i].quantity;
                        var panel = '<div>';
                        panel += '<p>' + itemId + '</p>';
                        panel += '<p>' + itemName + '</p>';
                        panel += '<p>' + itemPrice + '</p>';
                        panel += '<p>' + numberOfItem + '</p>';
                        panel += '</div>';
                    $('#item4').append(panel);
                    }
                    if(i==4){
                        itemId = data[i].id;
                        itemName = data[i].name;
                        itemPrice = data[i].price;
                        numberOfItem = data[i].quantity;
                        var panel = '<div>';
                        panel += '<p>' + itemId + '</p>';
                        panel += '<p>' + itemName + '</p>';
                        panel += '<p>' + itemPrice + '</p>';
                        panel += '<p>' + numberOfItem + '</p>';
                        panel += '</div>';
                    $('#item5').append(panel);
                    }
                    if(i==5){
                        itemId = data[i].id;
                        itemName = data[i].name;
                        itemPrice = data[i].price;
                        numberOfItem = data[i].quantity;
                        var panel = '<div>';
                        panel += '<p>' + itemId + '</p>';
                        panel += '<p>' + itemName + '</p>';
                        panel += '<p>' + itemPrice + '</p>';
                        panel += '<p>' + numberOfItem + '</p>';
                        panel += '</div>';
                    $('#item6').append(panel);
                    }
                    if(i==6){
                        itemId = data[i].id;
                        itemName = data[i].name;
                        itemPrice = data[i].price;
                        numberOfItem = data[i].quantity;
                        var panel = '<div>';
                        panel += '<p>' + itemId + '</p>';
                        panel += '<p>' + itemName + '</p>';
                        panel += '<p>' + itemPrice + '</p>';
                        panel += '<p>' + numberOfItem + '</p>';
                        panel += '</div>';
                    $('#item7').append(panel);
                    }
                    if(i==7){
                        itemId = data[i].id;
                        itemName = data[i].name;
                        itemPrice = data[i].price;
                        numberOfItem = data[i].quantity;
                        var panel = '<div>';
                        panel += '<p>' + itemId + '</p>';
                        panel += '<p>' + itemName + '</p>';
                        panel += '<p>' + itemPrice + '</p>';
                        panel += '<p>' + numberOfItem + '</p>';
                        panel += '</div>';
                    $('#item8').append(panel);
                    }
                    if(i==8){
                        itemId = data[i].id;
                        itemName = data[i].name;
                        itemPrice = data[i].price;
                        numberOfItem = data[i].quantity;
                        var panel = '<div>';
                        panel += '<p>' + itemId + '</p>';
                        panel += '<p>' + itemName + '</p>';
                        panel += '<p>' + itemPrice + '</p>';
                        panel += '<p>' + numberOfItem + '</p>';
                        panel += '</div>';
                    $('#item9').append(panel);
                    }
                }
        },
        error: function() {
            $('#errorMessages')
                .append($('<li>')
                .attr({class: 'list-group-item list-group-item-danger'})
                .text('Error calling web service. Please try again.'));
        }
    });
}

//function to add money
function moneyHandler(id){

    //something with buttons is causing this to not pass correctly
    var total = 0;
    var id = 0;

    $('#add-dollar-button').click(function(){
        total += 1;
        $('#money-total').append('<p>').text(total);
        return total;
    })
    $('#add-quarter-button').click(function (){
        total += 0.25;
        $('#money-total').append('<p>').text(total);
    })
    $('#add-dime-button').click(function (){
        total += 0.10;
        $('#money-total').append('<p>').text(total);
    })
    $('#add-nickel-button').click(function (){
        total += 0.05;
        $('#money-total').append('<p>').text(total);
    })

    $('#item1').click(function() {
        id = 1;
        $('#item-id').append('<p>').text(id);
    })
    $('#item2').click(function() {
        id = 2;
        $('#item-id').append('<p>').text(id);
    })
    $('#item3').click(function() {
        id = 3;
        $('#item-id').append('<p>').text(id);
    })
    $('#item4').click(function() {
        id = 4;
        $('#item-id').append('<p>').text(id);
    })
    $('#item5').click(function() {
        id = 5;
        $('#item-id').append('<p>').text(id);
    })
    $('#item6').click(function() {
        id = 6;
        $('#item-id').append('<p>').text(id);
    })
    $('#item7').click(function() {
        id = 7;
        $('#item-id').append('<p>').text(id);
    })
    $('#item8').click(function() {
        id = 8;
        $('#item-id').append('<p>').text(id);
    })
    $('#item9').click(function() {
        id = 9;
        $('#item-id').append('<p>').text(id);
    })

    var numberOfItem = 2;
    $('#purchase-button').click(function (){
        if(total < 1.5){
            //response body 422 HTTP request
            $('#message-box').append('<p>').text("Please deposit more $$."); //update with amount of money needed to enter to purchase item
        } else if (numberOfItem == 0){
            //response body 422 HTTP request
            $('#message-box').append('<p>').text("SOLD OUT!!!");
        } else {
            numberOfItem -= 1;
            total -= 0.5; //update to price of item
            $('#money-total').append('<p>').text(total);
            $('#message-box').append('<p>').text("Thank you!!");
        }
    })

    var apiURL = 'http://localhost:8080/money/' + total + '/item/' + id;
    
    $('#return-change-button').click(function (){
        $.ajax ({
            type: 'GET',
            url: apiURL,
            success: function (data, status) {
    
                    quarters = data.quarters;
                    dimes = data.dimes;
                    nickels = data.nickels;
                    var pennies = data.pennies;

                    $('#change-returned-amount').append('<p>').text(total);
                    total = 0;
                    $('#money-total').append('<p>').text(total);
            },
            error: function() {
                $('#errorMessages')
                    .append($('<li>')
                    .attr({class: 'list-group-item list-group-item-danger'})
                    .text('Error calling web service. Please try again.'));
            }
        });
    });
}  

    //logic for selecting item and rendering item ID in message box
    //if panel selected
    //append item id to message box
    //this API url: localhost:8080/money/2/item/1
        //gives you how much should be return to user
        //or gives you the messages of SOLD OUT or "Please enter...."
        
   /* $('#item-panel').click(function(id) {
        $('#item-id').append('<p>').text(id);

        //CLEAR OLD DATA FIRST??
        //when panel clicked, get data from API
        $.ajax ({
            type: 'GET',
            url: 'http://localhost:8080/money' + total + '/item/' + id,
            success: function (data, status) {
    
                    quarters = data.quarters;
                    dimes = data.dimes;
                    nickels = data.nickels;
                    var pennies = data.pennies;
    
                    //use the above to determine how much change person gets back
                    $('#change-returned-amount').append('<p>').text(quarters + " quarters, " + dimes + " dimes, " + " nickels, " + pennies + " pennies");
                    //subtract from total if item purchased
                var numberOfItem = 2;
                $('#purchase-button').click(function (){
                    if(total < 1.5){
                        //response body 422 HTTP request
                        $('#message-box').append('<p>').text("Please deposit more $$."); //update with amount of money needed to enter to purchase item
                    } else if (numberOfItem == 0){
                        //response body 422 HTTP request
                        $('#message-box').append('<p>').text("SOLD OUT!!!");
                    } else {
                        numberOfItem -= 1;
                        total -= 0.5; //update to price of item
                        $('#money-total').append('<p>').text(total);
                    }
                }); 

                $('#return-change-button').click(function (){
                    $('#change-returned-amount').append('<p>').text(total);
                    total = 0;
                    $('#money-total').append('<p>').text(total);
                });
            },
            error: function() {
                $('#errorMessages')
                    .append($('<li>')
                    .attr({class: 'list-group-item list-group-item-danger'})
                    .text('Error calling web service. Please try again.'));
            }
        });
    });*/


//is not currently getting variable from previous function
/*function purchaseItem(){
    //determine how much money user has put in
    //verify:
        //1. there is enough of that item
        //2. user provided enough change
    //subtract number of item from selected item by user based on item ID
    
    var total = addMoney();
    
    var numberOfItem = 2;
    $('#purchase-button').click(function (event){
        if(total < 1.5){
            console.log(total);
            console.log("Please deposit more $$.");
        } else if (numberOfItem == 0){
            console.log("Sold out!");
            console.log(numberOfItem);
        } else {
            numberOfItem -= 1;
            console.log(numberOfItem);
            console.log(total);
        }
    });   
}*/
