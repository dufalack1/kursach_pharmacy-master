$(document).ready(function() {
    // Load drugs list on page load
    loadDrugsList();

    // Submit form
    $('#drugsForm').submit(function(event) {
        event.preventDefault();

        // Get form data
        var formData = {
            commercy_name: $('#commercy_name').val(),
            mnn_name: $('#mnn_name').val(),
            country: $('#country').val(),
            release_form: $('#release_form').val(),
            quntity_in_primary_pack: parseInt($('#quantity_in_primary_pack').val())
        };

        // Save drug
        saveDrug(formData);
    });
});

// Load drugs list
function loadDrugsList() {
    $.ajax({
        url: '/drugs',
        type: 'GET',
        success: function(data) {
            // Clear table body
            $('#drugsTable tbody').empty();

            // Populate table with drugs data
            data.forEach(function(drug) {
                var row = '<tr>' +
                    '<td>' + drug.id + '</td>' +
                    '<td>' + drug.commercy_name + '</td>' +
                    '<td>' + drug.mnn_name + '</td>' +
                    '<td>' + drug.country + '</td>' +
                    '<td>' + drug.release_form + '</td>' +
                    '<td>' + drug.quntity_in_primary_pack + '</td>' +
                    '<td class="actions">' +
                '<button onclick="editDrug(' + drug.id + ')">Edit</button>' +
                '<button onclick="deleteDrug(' + drug.id + ')">Delete</button>' +
                '</td>' +
                '</tr>';

                $('#drugsTable tbody').append(row);
            });
        }
    });
}

// Save drug
function saveDrug(formData) {
    $.ajax({
        url: '/drugs',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(formData),
        success: function(data) {
            // Clear form inputs
            $('#drugsForm')[0].reset();

            // Reload drugs list
            loadDrugsList();
        }
    });
}

// Edit drug
function editDrug(drugId) {
    // Fetch drug data by ID
    $.ajax({
        url: '/drugs/' + drugId,
        type: 'GET',
        success: function(data) {
            // Populate form with drug data
            $('#commercy_name').val(data.commercy_name);
            $('#MNN_name').val(data.MNN_name);
            $('#country').val(data.country);
            $('#release_form').val(data.release_form);
            $('#quantity_in_primary_pack').val(data.quntity_in_primary_pack);

            // Change submit button to update button
            $('#drugsForm button[type="submit"]').text('Update');

            // Update drug on form submit
            $('#drugsForm').off('submit').submit(function(event) {
                event.preventDefault();

                // Update drug
                updateDrug(drugId, {
                    commercy_name: $('#commercy_name').val(),
                    mnn_name: $('#mnn_name').val(),
                    country: $('#country').val(),
                    release_form: $('#release_form').val(),
                    quntity_in_primary_pack: parseInt($('#quantity_in_primary_pack').val())
                });
            });
        }
    });
}

// Update drug
function updateDrug(drugId, formData) {
    $.ajax({
        url: '/drugs',
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify({ id: drugId, ...formData }),
        success: function(data) {
            // Clear form inputs
            $('#drugsForm')[0].reset();

            // Change submit button back to save button
            $('#drugsForm button[type="submit"]').text('Save');

            // Reload drugs list
            loadDrugsList();
        }
    });
}

// Delete drug
function deleteDrug(drugId) {
    if (confirm('Are you sure you want to delete this drug?')) {
        $.ajax({
            url: '/drugs/' + drugId,
            type: 'DELETE',
            success: function() {
                // Reload drugs list
                loadDrugsList();
            }
        });
    }
}