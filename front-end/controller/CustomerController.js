
$('#btnSave').click(function () {

    let customerCode = $('#txtCustomerCode').val();
    let customerName = $('#txtCustomerName').val();
    let gender = $('#txtGender').find(':selected').val();
    let joinDateLoyaltyCustomer = $('#txtJoinDateLoyaltyCustomer').val();
    let level = $('#txtLevel').find(':selected').val();
    let totalPoints = $('#txtTotalPoints').val();
    let dateOfBirth = $('#txtDateOfBirth').val();
    let address = $('#txtAddress').val();

    var customer = {
        customerCode: customerCode,
        customerName: customerName,
        gender: gender,
        joinDateLoyaltyCustomer: joinDateLoyaltyCustomer,
        level: level,
        totalPoints: totalPoints,
        dateOfBirth: dateOfBirth,
        address: address
    };

    $.ajax({
        url: 'http://localhost:8080/app1/cust/save',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(customer),
        success: function (response) {
            alert('Customer information saved successfully!');
            console.log(customer);
            getAll();
        },
        error: function (xhr, status, error) {
            console.error('Error saving customer information:', error);
            alert('Customer Not Found!');
        }
    });


});


$('#btnUpdate').click(function (){
    let customerCode = $('#txtCustomerCode').val();
    let customerName = $('#txtCustomerName').val();
    let gender = $('#txtGender').find(':selected').val();
    // let joinDateLoyaltyCustomer = $('#txtJoinDateLoyaltyCustomer').val();
    let level = $('#txtLevel').find(':selected').val();
    let totalPoints = $('#txtTotalPoints').val();
    // let dateOfBirth = $('#txtDateOfBirth').val();
    let address = $('#txtAddress').val();


    var customer = {
        customerCode: customerCode,
        customerName: customerName,
        gender: gender,
        // joinDateLoyaltyCustomer: joinDateLoyaltyCustomer,
        level: level,
        totalPoints: totalPoints,
        // dateOfBirth: dateOfBirth,
        address: address
    };


    $.ajax({
        url: 'http://localhost:8080/app1/cust/update',
        type: 'PATCH',
        contentType: 'application/json',
        data: JSON.stringify(customer),
        success: function (response) {
            alert('Customer information updated successfully!');
            console.log(customer);
            getAll();
        },
        error: function (xhr, status, error) {
            console.error('Error updating customer information:', error);
            alert('Customer Not Found!');
        }
    });
});


$('#btnDelete').click(function () {
    let customerCode = $('#txtCustomerCode').val();

    $.ajax({
        url: 'http://localhost:8080/app1/cust/' + customerCode,
        type: 'DELETE',
        success: function (response) {
            alert('Customer information deleted successfully!');
            console.log('Deleted customer with code:', customerCode);
            getAll();
        },
        error: function (xhr, status, error) {
            console.error('Error deleting customer information:', error);
            alert('Customer Not Found!');
        }
    });
});




$('#btnGetAll').click(function () {
    getAll();

});
////////////////////////////////////////////getAllMethod///////////////////////////////////////

function getAll() {
    $.ajax({
        url: "http://localhost:8080/app1/cust/getAllCustomers",
        method: "GET",
        success: function (resp) {
            console.log("Success: ", resp);
            $('#tblCustomers tbody').empty();

            for (const customer of resp) {
                console.log(customer.customerCode);
                console.log(customer.customerName);
                console.log(customer.gender);
                console.log(customer.joinDateLoyaltyCustomer);
                console.log(customer.level);
                console.log(customer.totalPoints);
                console.log(customer.dateOfBirth);
                console.log(customer.address);

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
        },
        error: function (error) {
            console.log("Error: ", error);
        }
    });
}
