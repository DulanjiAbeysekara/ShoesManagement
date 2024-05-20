

getAll();

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



////////////////////////////////////////////getAllMethod///////////////////////////////////////

// getAllCustomers();
//
// function getAllCustomers() {
//     $.ajax({
//         url: "http://localhost:8080/app1/cust/getAllCustomers",
//         method: "GET",
//         dataType: "json",
//         success: function (response) {
//             console.log(response);
//             console.log(response.length);
//             loadCustomerDataInTable(response);
//
//         },
//         error: function (xhr, status, err) {
//             console.log(err)
//         }
//     })
// }
//
//
// function loadCustomerDataInTable(customers) {
//     var tableBody = document.getElementById("tblCustomers");
//     tableBody.innerHTML = "";
//
//     customers.forEach(function(customer) {
//         var row = document.createElement("tr");
//
//         ["customerCode", "customerName", "gender", "joinDateLoyaltyCustomer", "level", "totalPoints", "dateOfBirth", "address"].forEach(function(property) {
//             var cell = document.createElement("td");
//             cell.textContent = customer[property];
//             row.appendChild(cell);
//         });
//
//         tableBody.appendChild(row);
//     });
// }

function getAll() {
    $('#tblCustomers tbody').empty();

    $.ajax({
        url: "http://localhost:8080/app1/cust/getAllCustomers",
        method: "GET",
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
