
$(document).ready(function () {

    getAll();

    $('#btnSupSave').click(function () {
        let code = $('#txtSupplierCode').val();
        let name = $('#txtSupplierName').val();
        let category = $('#txtCategory').val();
        let address = $('#txtSupplierAddress').val();
        let contactNo1 = $('#txtContactNo1').val();
        let contactNo2 = $('#txtContactNo2').val();
        let email = $('#txtEmail').val();

        var supplier = {
            code: code,
            name: name,
            category: category,
            address: address,
            contactNo1: contactNo1,
            contactNo2: contactNo2,
            email: email,
        }


        $.ajax({
            url: 'http://localhost:8080/app1/supplier/save',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(supplier),
            success: function (response) {
                alert('Supplier information saved successfully!');
                console.log(supplier);
                clearFields();
                getAll();
            },
            error: function (xhr, status, error) {
                console.error('Error saving supplier information:', error);
                alert('Supplier Not Found!');
            }
        });
    });


    $('#btnSupUpdate').click(function () {
        let code = $('#txtSupplierCode').val();
        let name = $('#txtSupplierName').val();
        let category = $('#txtCategory').val();
        let address = $('#txtSupplierAddress').val();
        let contactNo1 = $('#txtContactNo1').val();
        let contactNo2 = $('#txtContactNo2').val();
        let email = $('#txtEmail').val();

        var supplier = {
            code: code,
            name: name,
            category: category,
            address: address,
            contactNo1: contactNo1,
            contactNo2: contactNo2,
            email: email,
        }

        $.ajax({
            url: 'http://localhost:8080/app1/supplier/update',
            type: 'PATCH',
            contentType: 'application/json',
            data: JSON.stringify(supplier),
            success: function (response) {
                alert('Supplier information updated successfully!');
                console.log(supplier);
                clearFields();
                getAll();
            },
            error: function (xhr, status, error) {
                console.error('Error updating supplier information:', error);
                alert('Supplier Not Found!');
            }
        });

    });


    $('#btnSupDlt').click(function () {

        let code = $('#txtSupplierCode').val();

        $.ajax({
            url: 'http://localhost:8080/app1/supplier/' + code,
            type: 'DELETE',
            success: function (response) {
                alert('Supplier information deleted successfully!');
                console.log('Deleted supplier with code:', code);
                clearFields();
                getAll();
            },
            error: function (xhr, status, error) {
                console.error('Error deleting Supplier information:', error);
                alert('Customer Not Found!');
            }
        });

    });


//////////////////////////methods//////////////////////////////////////////

    function getAll() {
        $('#tblSupplier tbody').empty();

        $.ajax({
            url: "http://localhost:8080/app1/supplier/getAllSupplier",
            method: "GET",
            success: function (resp) {
                for (const supplier of resp) {
                    let row = `<tr>
                                <td>${supplier.code}</td>
                                <td>${supplier.name}</td>
                                <td>${supplier.category}</td>
                                <td>${supplier.address}</td>
                                <td>${supplier.contactNo1}</td>
                                <td>${supplier.contactNo2}</td>
                                <td>${supplier.email}</td>
                                
                            </tr>`;
                    $('#tblSupplier tbody').append(row);
                }
                bindClickEvents();
            },
            error: function (error) {
                console.log("Error: ", error);
            }
        });
    }

    function bindClickEvents() {
        $('#tblSupplier tbody>tr').click(function () {
            let code = $(this).children(':nth-child(1)').text();
            let name = $(this).children(':nth-child(2)').text();
            let category = $(this).children(':nth-child(3)').text();
            let address = $(this).children(':nth-child(4)').text();
            let contactNo1 = $(this).children(':nth-child(5)').text();
            let contactNo2 = $(this).children(':nth-child(6)').text();
            let email = $(this).children(':nth-child(7)').text();


            $('#txtSupplierCode').val(code);
            $('#txtSupplierName').val(name);
            $('#txtCategory').val(category);
            $('#txtSupplierAddress').val(address);
            $('#txtContactNo1').val(contactNo1);
            $('#txtContactNo2').val(contactNo2);
            $('#txtEmail').val(email);

        });
    }

    function clearFields() {

        $('#txtSupplierCode').val("");
        $('#txtSupplierName').val("");
        $('#txtCategory').val("");
        $('#txtSupplierAddress').val("");
        $('#txtContactNo1').val("");
        $('#txtContactNo2').val("");
        $('#txtEmail').val("");

        $("#txtSupplierCode").focus();
    }

});