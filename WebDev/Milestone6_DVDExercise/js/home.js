$(document).ready(function () {

    loadDVDs();

    $('#required-alert').hide();
    $('#single-dvd-div').hide();

    $('#search-button').click(function (event){
        //if(('#search-category').val not selected) then show alert
        //or if search-term is null then show alert
        //otherwise show single dvd table
        $('#dvd-details').hide();
        loadSingleDvd();
        $('#single-dvd-div').show();
        $('#back-button').click(function (event) {
            $('#dvd-details').show();
            $('#single-dvd-div').hide();
        });
    });

    $('#create-button').click(function (event) {
        
        //issues with requiring fields to be filled out without form showing
        //rating not registering when entered
        //show Edit Dvd: [title]  when form pops-up
        //when click add, should close out of create form dvd (same with edit) and go back to other screen
        var haveValidationErrors = checkAndDisplayValidationErrors($('#add-form').find('input'));

        if(haveValidationErrors) {
            return false;
        }

        $('#dvd-details').hide();
        $('#addFormDiv').show();

        $('#add-button').click(function (event) {
            $.ajax({
                type: 'POST',
                url: 'http://localhost:8080/dvd',
                data: JSON.stringify({
                    title: $('#add-title').val(),
                    releaseYear: $('#add-release-year').val(),
                    director: $('#add-director').val(),
                    rating: $('#add-rating').val(),
                    notes: $('#add-notes').val()
                }),
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                'datatype': 'json',
                success: function() {
                    $('#errorMessages').empty();
                    $('#add-title').val('');
                    $('#add-release-year').val('');
                    $('#add-director').val('');
                    $('#add-rating').val('');
                    $('#add-notes').val('');
                    loadDVDs();
                },
                error: function() {
                    $('#errorMessages')
                        .append($('<li>')
                        .attr({class: 'list-group-item list-group-item-danger'})
                        .text('Error calling web service. Please try again.'));
                }
            })
        });
    });

    $('#edit-button').click(function(event) {
        
        var haveValidationErrors = checkAndDisplayValidationErrors($('#edit-form').find('input'));
        
        if(haveValidationErrors) {
            return false;
        }

        $.ajax({
            type: 'PUT',
            url: 'http://localhost:8080/contact/' + $('#edit-contact-id').val(),
            data: JSON.stringify({
                contactId: $('#edit-contact-id').val(),
                firstName: $('#edit-first-name').val(),
                lastName: $('#edit-last-name').val(),
                company: $('#edit-company').val(),
                phone: $('#edit-phone').val(),
                email: $('#edit-email').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json',
            success: function() {
                $('#errorMessage').empty();
                hideEditForm();
                loadContacts();
            },
            error: function() {
                $('#errorMessages')
                    .append($('<li>')
                    .attr({class: 'list-group-item list-group-item-danger'})
                    .text('Error calling web service. Please try again.'));
            }
        })
    });
        
});

function loadSingleDvd(){
    var dvdContent = $('#single-dvd-div');

    $.ajax ({
        type: 'GET',
        url: 'http://localhost:8080/dvd' + dvdId,
        success: function (data, status) {
            $.each(data, function (index, dvd) {
                var title = dvd.title;
                var releaseYear = dvd.releaseYear;
                var director = dvd.director;
                var rating = dvd.rating;
                var notes = dvd.notes;
                var dvdId = dvd.dvdId;

                var row = '<div>';
                    row += '<h2>' + title + '</h2>';
                    row += '<hr/>';
                    row += '<p>' + 'Release Year: ' + releaseYear + '</p>';
                    row += '<p>' + 'Director: ' + director + '</p>';
                    row += '<p>' + 'Rating: ' + rating + '</p>';
                    row += '<p>' + 'Notes: ' + notes + '</p>';
                    row += '</div>';
                dvdContent.append(row);
            });
        },
        error: function() {
            $('#errorMessages')
                .append($('<li>')
                .attr({class: 'list-group-item list-group-item-danger'})
                .text('Error calling web service. Please try again.'));
        }
    });
}

function loadDVDs(){
    // we need to clear the previous content so we don't append to it
    clearDvdTable();
    
        // grab the the tbody element that will hold the rows of contact information
        var contentRows = $('#contentRows');
    
        $.ajax ({
            type: 'GET',
            url: 'http://localhost:8080/dvds',
            success: function (data, status) {
                $.each(data, function (index, dvd) {
                    var title = dvd.title;
                    var releaseYear = dvd.releaseYear;
                    var director = dvd.director;
                    var rating = dvd.rating;
                    var notes = dvd.notes;
                    var dvdId = dvd.dvdId;
    
                    var row = '<tr>';
                        row += '<td>' + title + '</td>';
                        row += '<td>' + releaseYear + '</td>';
                        row += '<td>' + director + '</td>';
                        row += '<td>' + rating + '</td>';
                        row += '<td>' + notes + '</td>';
                        row += '<td><a onclick="showEditForm(' +  dvdId + ')">Edit</a>' + ' | ' + '<a onclick="deleteDvd(' + dvdId + ')">Delete</a></td>';
                        row += '</tr>';
                    contentRows.append(row);
                });
            },
            error: function() {
                $('#errorMessages')
                    .append($('<li>')
                    .attr({class: 'list-group-item list-group-item-danger'})
                    .text('Error calling web service. Please try again.'));
            }
        });
}

function clearDvdTable() {
    $('#contentRows').empty();
}

function showEditForm(dvdId) {
    $('#errorMessages').empty();

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/dvd/' + dvdId,
        success: function(data, status) {
            $('#edit-title').val(data.title);
            $('#edit-release-year').val(data.releaseYear);
            $('#edit-director').val(data.director);
            $('#edit-rating').val(data.rating);
            $('#edit-notes').val(data.email);
            //$('#edit-dvd-id').val(data.dvdId);
        },
        error: function() {
            $('#errorMessages')
                .append($('<li>')
                .attr({class: 'list-group-item list-group-item-danger'})
                .text('Error calling web service. Please try again.'));
        }
    })

    $('#dvd-details').hide();
    $('#editFormDiv').show();
}

function hideEditForm() {
    $('#errorMessages').empty();

    $('#edit-title').val('');
    $('#edit-release-year').val('');
    $('#edit-director').val('');
    $('#edit-rating').val('');
    $('#edit-notes').val('');

    $('#editFormDiv').hide();
    $('#dvd-details').show();
}

function hideAddForm() {
    $('#errorMessages').empty();

    $('#add-title').val('');
    $('#add-release-year').val('');
    $('#add-director').val('');
    $('#add-rating').val('');
    $('#add-notes').val('');

    $('#addFormDiv').hide();
    $('#dvd-details').show();
}

//validation for whether they want to delete it or not
function deleteDvd(dvdId) {
    alert("Are your sure you want to delete this DVD from your collection?");
    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:8080/dvd/' + dvdId,
        success: function() {
            loadDVDs();
        }
    });
}

function checkAndDisplayValidationErrors(input){
    $('#errorMessages').empty();

    var errorMessages = [];

    input.each(function() {
        if(!this.validity.valid) {
            var errorField = $('label[for=' + this.id + ']').text();
            errorMessages.push(errorField + ' ' + this.validationMessage);
        }
    });

    if(errorMessages.length > 0) {
        $.each(errorMessages, function(index,message) {
            $('#errorMessages').append($('<li>').attr({class: 'list-group-item list-group-item-danger'}).text(message));
        });
        return true; //indicates there were errors
    } else {
        return false;
    }
}
