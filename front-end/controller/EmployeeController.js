$('#employeeSaveBtn').click(function (){

    let employeeCode = $('#txtEmployeeCode').val();
    let employeeName = $('#txtEmployeeName').val();
    let gender = $('#txtEmployeeGender').find(':selected').val();
    let status = $('#txtEmployeeStatus').val();
    let designation = $('#txtEmployeeDesignation').val();
    let accessRole = $('#txtAccessRole').find(':selected').val();
    let dob = $('#txtEmployeeDateOfBirth').val();
    let dateOfJoin = $('#txtEmployeeDateOfJoin').val();
    let attachedBranch=$('#txtAttachedBranch').val();
    let address=$('#txtAddress').val();
    let contactNo=$('#txtContactNo').val();

    var employee = {
        employeeCode:employeeCode,
        employeeName:employeeName,
        gender:gender,
        status:status,
        designation:designation,
        accessRole:accessRole,
        dob:dob,
        dateOfJoin:dateOfJoin,
        attachedBranch:attachedBranch,
        address:address,
        contactNo:contactNo

    }

    $.ajax({
        url: 'http://localhost:8080/app1/employee/save',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(employee),
        success: function (response) {
            alert('Employee information saved successfully!');
            console.log(employee);
            getAll();
        },
        error: function (xhr, status, error) {
            console.error('Error saving employee information:', error);
            alert('Employee Not Found!');
        }
    });

});



$('#btnEmUpdate').click(function (){

    let employeeCode = $('#txtEmployeeCode').val();
    let employeeName = $('#txtEmployeeName').val();
    let gender = $('#txtEmployeeGender').find(':selected').val();
    let status = $('#txtEmployeeStatus').val();
    let designation = $('#txtEmployeeDesignation').val();
    // let accessRole = $('#txtAccessRole').find(':selected').val();
    // let dob = $('#txtEmployeeDateOfBirth').val();
    // let dateOfJoin = $('#txtEmployeeDateOfJoin').val();
    let attachedBranch=$('#txtAttachedBranch').val();
    let address=$('#txtAddress').val();
    let contactNo=$('#txtContactNo').val();

    var employee={
        employeeCode:employeeCode,
        employeeName:employeeName,
        gender:gender,
        status:status,
        designation:designation,
        attachedBranch:attachedBranch,
        address:address,
        contactNo:contactNo
    }


    $.ajax({
        url: 'http://localhost:8080/app1/employee/update',
        type: 'PATCH',
        contentType: 'application/json',
        data: JSON.stringify(employee),
        success: function (response) {
            alert('Customer information updated successfully!');
            console.log(employee);
            getAll();
        },
        error: function (xhr, status, error) {
            console.error('Error updating employee information:', error);
            alert('Employee Not Found!');
        }
    });

});



$('#btnEmDelete').click(function (){
     let  employeeCode=$('#txtEmployeeCode').val();

    $.ajax({
        url: 'http://localhost:8080/app1/employee/' + employeeCode,
        type: 'DELETE',
        success: function (response) {
            alert('Employee information deleted successfully!');
            console.log('Deleted employee with code:', employeeCode);
            getAll();
        },
        error: function (xhr, status, error) {
            console.error('Error deleting employee information:', error);
            alert('Employee Not Found!');
        }
    });
});




////////////////////////////////getAll////////////////////////////////////
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