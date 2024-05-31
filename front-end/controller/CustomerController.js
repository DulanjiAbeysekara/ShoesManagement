
$(document).ready(function () {

///////////////////////////////////////////Validation////////////////////////////////////////////////////
    $("#txtCustomerName").keyup(function (e) {
        const customerName = $(this).val();

        if (nameRegex.test(customerName)) {
            $('#txtCustomerName').css("border-color", "transparent");
            $('#nameError').hide();
        } else {
            $('#txtCustomerName').css("border-color", "red");
            $('#nameError').show();
        }
    });


    $("#txtAddress").keyup(function (e) {
        const customerAddress = $(this).val();

        if (addressRegex.test(customerAddress)) {
            $('#txtAddress').css("border-color", "transparent");
            $('#addressError').hide();
        } else {
            $('#txtAddress').css("border-color", "red");
            $('#addressError').show();
        }
    });



////////////////////////////////////////////////////////////////

    generateCustomerID();
    getAll();

    $('#btnSave').click(function () {
        let customer = getCustomerDataFromForm();

        // performAuthenticatedRequest();

        const accessToken = localStorage.getItem('accessToken')

        $.ajax({
            url: 'http://localhost:8080/app1/cust/save',
            type: 'POST',
            headers: {
                'Authorization': 'Bearer ' + accessToken
            },
            contentType: 'application/json',
            data: JSON.stringify(customer),
            success: function (response) {
                alert('Customer information saved successfully!');
                clearFields();
                getAll();
            },
            error: function (xhr, status, error) {
                console.error('Error saving customer information:', error);
                alert('Error saving customer information!');
            }
        });
    });

    $('#btnUpdate').click(function () {
        let customer = getCustomerDataFromForm();

        const accessToken = localStorage.getItem('accessToken');

        $.ajax({
            url: 'http://localhost:8080/app1/cust/update',
            type: 'PATCH',

            headers: {
                'Authorization': 'Bearer ' + accessToken
            },

            contentType: 'application/json',
            data: JSON.stringify(customer),
            success: function (response) {
                alert('Customer information updated successfully!');
                clearFields();
                getAll();
            },
            error: function (xhr, status, error) {
                console.error('Error updating customer information:', error);
                alert('Error updating customer information!');
            }
        });
    });

    $('#btnDelete').click(function () {
        let customerCode = $('#txtCustomerCode').val();

        const accessToken = localStorage.getItem('accessToken');

        $.ajax({
            url: 'http://localhost:8080/app1/cust/' + customerCode,
            type: 'DELETE',

            headers: {
                'Authorization': 'Bearer ' + accessToken
            },

            success: function (response) {
                alert('Customer information deleted successfully!');
                clearFields();
                getAll();
            },
            error: function (xhr, status, error) {
                console.error('Error deleting customer information:', error);
                alert('Error deleting customer information!');
            }
        });
    });

    $('#btnSearch').click(function () {
        let customerName = $('#txtSearchCustomer').val();
        searchCustomerByName(customerName);
    });






//////////////////////////////////Methods///////////////////////////////////////////
    function searchCustomerByName(customerName) {
        $('#tblCustomers tbody').empty();

        const accessToken = localStorage.getItem('accessToken');

        $.ajax({
            url: 'http://localhost:8080/app1/cust/search/' + customerName,
            method: 'GET',
            headers: {
                'Authorization': 'Bearer ' + accessToken
            },
            success: function (resp) {
                if (resp.length === 0) {
                    alert('No customer found with the given name');
                    return;
                }
                for (const customer of resp) {
                    let row = `<tr>
                                    <td>${customer.customerCode}</td>
                                    <td>${customer.customerName}</td>
                                    <td>${customer.gender}</td>
                                    <td>${customer.joinDateLoyaltyCustomer}</td>
                                    <td>${customer.level}</td>
                                    <td>${customer.totalPoints}</td>
                                    <td>${customer.dateOfBirth}</td>
                                    <td>${customer.address}</td>
                                </tr>`;
                    $('#tblCustomers tbody').append(row);
                }
                bindClickEvents();
            },
            error: function (error) {
                console.log('Error:', error);
                alert('Error searching for customer!');
            }
        });
    }


    function getAll() {
        $('#tblCustomers tbody').empty();

        const accessToken = localStorage.getItem('accessToken');

        $.ajax({
            url: "http://localhost:8080/app1/cust/getAllCustomers",
            method: "GET",
            headers: {
                'Authorization': 'Bearer ' + accessToken
            },

            success: function (resp) {
                for (const customer of resp) {
                    let row = `<tr>
                                    <td>${customer.customerCode}</td>
                                    <td>${customer.customerName}</td>
                                    <td>${customer.gender}</td>
                                    <td>${customer.joinDateLoyaltyCustomer}</td>
                                    <td>${customer.level}</td>
                                    <td>${customer.totalPoints}</td>
                                    <td>${customer.dateOfBirth}</td>
                                    <td>${customer.address}</td>
                                </tr>`;
                    $('#tblCustomers tbody').append(row);
                }
                bindClickEvents();
            },
            error: function (error) {
                console.log("Error: ", error);
            }
        });
    }

    function bindClickEvents() {
        $('#tblCustomers tbody>tr').click(function () {
            let customerCode = $(this).children(':nth-child(1)').text();
            let customerName = $(this).children(':nth-child(2)').text();
            let gender = $(this).children(':nth-child(3)').text();
            let joinDateLoyaltyCustomer = $(this).children(':nth-child(4)').text();
            let level = $(this).children(':nth-child(5)').text();
            let totalPoints = $(this).children(':nth-child(6)').text();
            let dateOfBirth = $(this).children(':nth-child(7)').text();
            let address = $(this).children(':nth-child(8)').text();

            $('#txtCustomerCode').val(customerCode);
            $('#txtCustomerName').val(customerName);
            $('#txtGender').val(gender);
            $('#txtJoinDateLoyaltyCustomer').val(joinDateLoyaltyCustomer);
            $('#txtLevel').val(level);
            $('#txtTotalPoints').val(totalPoints);
            $('#txtDateOfBirth').val(dateOfBirth);
            $('#txtAddress').val(address);
        });
    }

    function clearFields() {
        $("#txtCustomerCode").val("");
        $("#txtCustomerName").val("");
        $("#txtGender").val("");
        $("#txtJoinDateLoyaltyCustomer").val("");
        $("#txtLevel").val("");
        $("#txtTotalPoints").val("");
        $("#txtDateOfBirth").val("");
        $("#txtAddress").val("");

        $("#txtCustomerCode").focus();
    }

    function generateCustomerID() {
        $("#txtCustomerCode").val("C00-001");

        const accessToken = localStorage.getItem('accessToken');

        $.ajax({
            url: "http://localhost:8080/app1/cust/cusIdGenerate",
            method: "GET",
            headers: {
                'Authorization': 'Bearer ' + accessToken
            },
            contentType: "application/json",
            dataType: "json",
            success: function (resp) {
                let id = resp.value;
                if (id) {
                    let tempId = parseInt(id.split("-")[1]) + 1;
                    let newId = "C00-" + tempId.toString().padStart(3, '0');
                    $("#txtCustomerCode").val(newId);
                }
            },
            error: function (ob, statusText, error) {
                console.error("Error generating customer ID:", statusText, error);
            }
        });
    }

    function getCustomerDataFromForm() {
        return {
            customerCode: $('#txtCustomerCode').val(),
            customerName: $('#txtCustomerName').val(),
            gender: $('#txtGender').find(':selected').val(),
            joinDateLoyaltyCustomer: $('#txtJoinDateLoyaltyCustomer').val(),
            level: $('#txtLevel').find(':selected').val(),
            totalPoints: $('#txtTotalPoints').val(),
            dateOfBirth: $('#txtDateOfBirth').val(),
            address: $('#txtAddress').val()
        };
    }


});
