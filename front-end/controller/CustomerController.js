


// $(document).ready(function () {
//
//     generateCustomerID();
//     getAll();
//
//     $('#btnSave').click(function () {
//
//         let customerCode = $('#txtCustomerCode').val();
//         let customerName = $('#txtCustomerName').val();
//         let gender = $('#txtGender').find(':selected').val();
//         let joinDateLoyaltyCustomer = $('#txtJoinDateLoyaltyCustomer').val();
//         let level = $('#txtLevel').find(':selected').val();
//         let totalPoints = $('#txtTotalPoints').val();
//         let dateOfBirth = $('#txtDateOfBirth').val();
//         let address = $('#txtAddress').val();
//
//         var customer = {
//             customerCode: customerCode,
//             customerName: customerName,
//             gender: gender,
//             joinDateLoyaltyCustomer: joinDateLoyaltyCustomer,
//             level: level,
//             totalPoints: totalPoints,
//             dateOfBirth: dateOfBirth,
//             address: address
//         };
//
//         $.ajax({
//             url: 'http://localhost:8080/app1/cust/save',
//             type: 'POST',
//             contentType: 'application/json',
//             data: JSON.stringify(customer),
//             success: function (response) {
//                 alert('Customer information saved successfully!');
//                 console.log(response);
//                 clearFields();
//                 getAll();
//             },
//             error: function (xhr, status, error) {
//                 console.error('Error saving customer information:', error);
//                 alert('Error saving customer information!');
//             }
//         });
//     });
//
//     $('#btnUpdate').click(function () {
//         let customerCode = $('#txtCustomerCode').val();
//         let customerName = $('#txtCustomerName').val();
//         let gender = $('#txtGender').find(':selected').val();
//         let joinDateLoyaltyCustomer = $('#txtJoinDateLoyaltyCustomer').val();
//         let level = $('#txtLevel').find(':selected').val();
//         let totalPoints = $('#txtTotalPoints').val();
//         let dateOfBirth = $('#txtDateOfBirth').val();
//         let address = $('#txtAddress').val();
//
//         var customer = {
//             customerCode: customerCode,
//             customerName: customerName,
//             gender: gender,
//             joinDateLoyaltyCustomer: joinDateLoyaltyCustomer,
//             level: level,
//             totalPoints: totalPoints,
//             dateOfBirth: dateOfBirth,
//             address: address
//         };
//
//         $.ajax({
//             url: 'http://localhost:8080/app1/cust/update',
//             type: 'PATCH',
//             contentType: 'application/json',
//             data: JSON.stringify(customer),
//             success: function (response) {
//                 alert('Customer information updated successfully!');
//                 console.log(response);
//                 clearFields();
//                 getAll();
//             },
//             error: function (xhr, status, error) {
//                 console.error('Error updating customer information:', error);
//                 alert('Error updating customer information!');
//             }
//         });
//     });
//
//     $('#btnDelete').click(function () {
//         let customerCode = $('#txtCustomerCode').val();
//
//         $.ajax({
//             url: 'http://localhost:8080/app1/cust/' + customerCode,
//             type: 'DELETE',
//             success: function (response) {
//                 alert('Customer information deleted successfully!');
//                 console.log('Deleted customer with code:', customerCode);
//                 clearFields();
//                 getAll();
//             },
//             error: function (xhr, status, error) {
//                 console.error('Error deleting customer information:', error);
//                 alert('Error deleting customer information!');
//             }
//         });
//     });
//
//     function getAll() {
//         $('#tblCustomers tbody').empty();
//
//         $.ajax({
//             url: "http://localhost:8080/app1/cust/getAllCustomers",
//             method: "GET",
//             success: function (resp) {
//                 for (const customer of resp) {
//                     let row = `<tr>
//                                     <td>${customer.customerCode}</td>
//                                     <td>${customer.customerName}</td>
//                                     <td>${customer.gender}</td>
//                                     <td>${customer.joinDateLoyaltyCustomer}</td>
//                                     <td>${customer.level}</td>
//                                     <td>${customer.totalPoints}</td>
//                                     <td>${customer.dateOfBirth}</td>
//                                     <td>${customer.address}</td>
//                                 </tr>`;
//                     $('#tblCustomers tbody').append(row);
//                 }
//                 bindClickEvents();
//             },
//             error: function (error) {
//                 console.log("Error: ", error);
//             }
//         });
//     }
//
//     function bindClickEvents() {
//         $('#tblCustomers tbody>tr').click(function () {
//             let customerCode = $(this).children(':nth-child(1)').text();
//             let customerName = $(this).children(':nth-child(2)').text();
//             let gender = $(this).children(':nth-child(3)').text();
//             let joinDateLoyaltyCustomer = $(this).children(':nth-child(4)').text();
//             let level = $(this).children(':nth-child(5)').text();
//             let totalPoints = $(this).children(':nth-child(6)').text();
//             let dateOfBirth = $(this).children(':nth-child(7)').text();
//             let address = $(this).children(':nth-child(8)').text();
//
//             $('#txtCustomerCode').val(customerCode);
//             $('#txtCustomerName').val(customerName);
//             $('#txtGender').val(gender);
//             $('#txtJoinDateLoyaltyCustomer').val(joinDateLoyaltyCustomer);
//             $('#txtLevel').val(level);
//             $('#txtTotalPoints').val(totalPoints);
//             $('#txtDateOfBirth').val(dateOfBirth);
//             $('#txtAddress').val(address);
//         });
//     }
//
//     function clearFields() {
//         $("#txtCustomerCode").val("");
//         $("#txtCustomerName").val("");
//         $("#txtGender").val("");
//         $("#txtJoinDateLoyaltyCustomer").val("");
//         $("#txtLevel").val("");
//         $("#txtTotalPoints").val("");
//         $("#txtDateOfBirth").val("");
//         $("#txtAddress").val("");
//         $("#txtCustomerCode").focus();
//     }
//
//     function generateCustomerID() {
//         $("#txtCustomerCode").val("C00-001");
//         $.ajax({
//             url: "http://localhost:8080/app1/cust/cusIdGenerate",
//             method: "GET",
//             contentType: "application/json",
//             dataType: "json",
//             success: function (resp) {
//                 let id = resp.value;
//                 console.log("id: " + id);
//                 if (id) {
//                     let tempId = parseInt(id.split("-")[1]) + 1;
//                     let newId = "C00-" + tempId.toString().padStart(3, '0');
//                     $("#txtCustomerCode").val(newId);
//                 }
//             },
//             error: function (ob, statusText, error) {
//                 console.error("Error generating customer ID:", statusText, error);
//             }
//         });
//     }
// });




$(document).ready(function () {

    generateCustomerID();
    getAll();

    $('#btnSave').click(function () {
        let customer = getCustomerDataFromForm();

        $.ajax({
            url: 'http://localhost:8080/app1/cust/save',
            type: 'POST',
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

        $.ajax({
            url: 'http://localhost:8080/app1/cust/update',
            type: 'PATCH',
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

        $.ajax({
            url: 'http://localhost:8080/app1/cust/' + customerCode,
            type: 'DELETE',
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

    // $('#serachCust').keypress(function(event) {
    //     if (event.keyCode === 13) {
    //         let customerCode = $('#serachCust').val();
    //
    //         $.ajax({
    //             url: 'http://localhost:8080/app1/cust/search' + customerCode,
    //             type: 'GET',
    //             success: function (customer) {
    //                 if (customer) {
    //                     setCustomerDataToForm(customer);
    //                 } else {
    //                     alert('Customer not found!');
    //                 }
    //             },
    //             error: function (xhr, status, error) {
    //                 console.error('Error fetching customer information:', error);
    //                 alert('Error fetching customer information!');
    //             }
    //         });
    //     }
    // });

    // $('#serachCust').keypress(function(event) {
    //     if (event.keyCode === 13) {
    //         let customerCode = $('#serachCust').val().trim();
    //
    //         $.ajax({
    //             url: 'http://localhost:8080/app1/cust/search?customer_code=' + customerCode,
    //             type: 'GET',
    //             success: function (customerList) {
    //                 if (customerList && customerList.length > 0) {
    //                     let customer = customerList[0]; // Assuming only one customer is returned
    //                     setCustomerDataToForm(customer);
    //                 } else {
    //                     alert('Customer not found!');
    //                 }
    //             },
    //             error: function (xhr, status, error) {
    //                 console.error('Error fetching customer information:', error);
    //                 alert('Error fetching customer information!');
    //             }
    //         });
    //     }
    // });
    //

//////////////////////////////////Methods///////////////////////////////////////////
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
        $.ajax({
            url: "http://localhost:8080/app1/cust/cusIdGenerate",
            method: "GET",
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

    function setCustomerDataToForm(customer) {
        $('#txtCustomerCode').val(customer.customerCode);
        $('#txtCustomerName').val(customer.customerName);
        $('#txtGender').val(customer.gender);
        $('#txtJoinDateLoyaltyCustomer').val(customer.joinDateLoyaltyCustomer);
        $('#txtLevel').val(customer.level);
        $('#txtTotalPoints').val(customer.totalPoints);
        $('#txtDateOfBirth').val(customer.dateOfBirth);
        $('#txtAddress').val(customer.address);
    }
});
