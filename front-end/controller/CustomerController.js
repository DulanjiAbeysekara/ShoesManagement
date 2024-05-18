
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

    $('btnDelete').click(function (){

    });

    $.ajax({
        url: 'http://localhost:8080/app1/cust/update',
        type: 'PATCH',
        contentType: 'application/json',
        data: JSON.stringify(customer),
        success: function (response) {
            alert('Customer information updated successfully!');
            console.log(customer);
        },
        error: function (xhr, status, error) {
            console.error('Error updating customer information:', error);
            alert('Customer Not Found!');
        }
    });
});


$('#btnGetAll').click(function (){
    for (var customer of customerArray) {

        $('#customerTable').empty();

        console.log(customer.customer_code);


      let row=  `<tr>  <td>${customer.customer_code}</td> <td>${customer. customer_name}</td>   <td>${customer.customer_gender}</td> <td>${customer. customer_joinDateLoyaltyCustomer}</td>  <td>${customer. customer_level}</td>  <td>${customer.  customer_totalPoints}</td> <td>${customer.customer_dateOfBirth}</td>  <td>${customer.customer_address}</td> </tr>`;

        $('#customerTable').append(row);


    }

});

