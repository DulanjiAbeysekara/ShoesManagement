$('#btnSupSave').click(function (){
    let code=$('#txtSupplierCode').val();
    let name=$('#txtSupplierName').val();
    let category=$('#txtCategory').val();
    let  address=$('#txtSupplierAddress').val();
    let contactNo1=$('#txtContactNo1').val();
    let contactNo2=$('#txtContactNo2').val();
    let email=$('#txtEmail').val();

    var supplier={
        code:code,
        name:name,
        category:category,
        address:address,
        contactNo1:contactNo1,
        contactNo2:contactNo2,
        email:email,
    }


    $.ajax({
        url: 'http://localhost:8080/app1/supplier/save',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(supplier),
        success: function (response) {
            alert('Supplier information saved successfully!');
            console.log(supplier);
            getAll();
        },
        error: function (xhr, status, error) {
            console.error('Error saving supplier information:', error);
            alert('Supplier Not Found!');
        }
    });
});


$('#btnSupUpdate').click(function (){
    let code=$('#txtSupplierCode').val();
    let name=$('#txtSupplierName').val();
    let category=$('#txtCategory').val();
    let  address=$('#txtSupplierAddress').val();
    let contactNo1=$('#txtContactNo1').val();
    let contactNo2=$('#txtContactNo2').val();
    let email=$('#txtEmail').val();

    var supplier={
        code:code,
        name:name,
        category:category,
        address:address,
        contactNo1:contactNo1,
        contactNo2:contactNo2,
        email:email,
    }

    $.ajax({
        url: 'http://localhost:8080/app1/supplier/update',
        type: 'PATCH',
        contentType: 'application/json',
        data: JSON.stringify(supplier),
        success: function (response) {
            alert('Supplier information updated successfully!');
            console.log(supplier);
            getAll();
        },
        error: function (xhr, status, error) {
            console.error('Error updating supplier information:', error);
            alert('Supplier Not Found!');
        }
    });

});


$('#btnSupDlt')