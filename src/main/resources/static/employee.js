$(document).ready(function() {
    // Load drugs list on page load
    loadEmployeeList();

    // Submit form
    $('#drugsForm').submit(function(event) {
        event.preventDefault();

        // Get form data
        var formData = {
            phone: $('#phone').val(),
            FIO: $('#FIO').val(),
            place: $('#place').val(),
            passport: $('#passport').val(),
        };

        // Save drug
        saveEmployee(formData);
    });
});

// Load drugs list
function loadEmployeeList() {
    $.ajax({
        url: '/employee',
        type: 'GET',
        success: function(data) {
            // Clear table body
            $('#employeeTable tbody').empty();

            // Populate table with drugs data
            data.forEach(function(employee) {
                var row = '<tr>' +
                    '<td>' + employee.id + '</td>' +
                    '<td>' + employee.phone + '</td>' +
                    '<td>' + employee.FIO + '</td>' +
                    '<td>' + employee.place + '</td>' +
                    '<td>' + employee.passport + '</td>' +
                    '<td class="actions">' +
                    '<button onclick="editEmployee(' + employee.id + ')">Edit</button>' +
                    '<button onclick="deleteEmployee(' + employee.id + ')">Delete</button>' +
                    '</td>' +
                    '</tr>';

                $('#drugsTable tbody').append(row);
            });
        }
    });
}

// Save drug
function saveEmployee(formData) {
    $.ajax({
        url: '/employee',
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
function editEmployee(drugId) {
    // Fetch drug data by ID
    $.ajax({
        url: '/employee/' + drugId,
        type: 'GET',
        success: function(data) {
            // Populate form with drug data
            $('#phone').val(data.phone);
            $('#FIO').val(data.FIO);
            $('#place').val(data.place);
            $('#country').val(data.country);

            // Change submit button to update button
            $('#employeeForm button[type="submit"]').text('Update');

            // Update drug on form submit
            $('#employeeForm').off('submit').submit(function(event) {
                event.preventDefault();

                // Update drug
                updateEmployee(employeeId, {
                    phone: $('#phone').val(),
                    FIO: $('#FIO').val(),
                    place: $('#place').val(),
                    passport: $('#passport').val(),
                });
            });
        }
    });
}

// Update drug
function updateEmployee(employeeId, formData) {
    $.ajax({
        url: '/employee',
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify({ id: employeeId, ...formData }),
        success: function(data) {
            // Clear form inputs
            $('#employeeForm')[0].reset();

            // Change submit button back to save button
            $('#employeeForm button[type="submit"]').text('Save');

            // Reload drugs list
            loadEmployeeList();
        }
    });
}

// Delete drug
function deleteEmployee(employeeId) {
    if (confirm('Are you sure you want to delete this employee?')) {
        $.ajax({
            url: '/employee/' + employeeId,
            type: 'DELETE',
            success: function() {
                // Reload drugs list
                loadEmployeeList();
            }
        });
    }
}