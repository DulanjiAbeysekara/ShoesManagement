getAll();

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
    $('#tblEmployee tbody').empty();

    $.ajax({
        url: "http://localhost:8080/app1/employee/getAllEmployee",
        method: "GET",
        success: function (resp) {
            for (const employee of resp) {
                let row = `<tr>
                                <td>${employee.employeeCode}</td>
                                <td>${employee.employeeName}</td>
                                <td>${employee.gender}</td>
                                <td>${employee.status}</td>
                                <td>${employee.designation}</td>
                                <td>${employee.accessRole}</td>
                                <td>${employee.dob}</td>
                                <td>${employee.dateOfJoin}</td>
                                <td>${employee.attachedBranch}</td>
                                <td>${employee.address}</td>
                                <td>${employee.contactNo}</td>
                           
                            </tr>`;
                $('#tblEmployee tbody').append(row);
            }
            bindClickEvents();
        },
        error: function (error) {
            console.log("Error: ", error);
        }
    });
}

function bindClickEvents() {
    $('#tblEmployee tbody>tr').click(function () {
        let employeeCode = $(this).children(':nth-child(1)').text();
        let employeeName = $(this).children(':nth-child(2)').text();
        let gender = $(this).children(':nth-child(3)').text();
        let status = $(this).children(':nth-child(4)').text();
        let designation = $(this).children(':nth-child(5)').text();
        let dob = $(this).children(':nth-child(6)').text();
        let dateOfJoin = $(this).children(':nth-child(7)').text();
        let accessRole = $(this).children(':nth-child(8)').text();
        let attachedBranch = $(this).children(':nth-child(9)').text();
        let address = $(this).children(':nth-child(10)').text();
        let contactNo = $(this).children(':nth-child(11)').text();

        $('#txtEmployeeCode').val(employeeCode);
        $('#txtEmployeeName').val(employeeName);
        $('#txtEmployeeGender').val(gender);
        $('#txtEmployeeStatus').val(status);
        $('#txtEmployeeDesignation').val(designation);
        $('#txtEmployeeDateOfBirth').val(dob);
        $('#txtEmployeeDateOfJoin').val(dateOfJoin);
        $('#txtAccessRole').val(accessRole);
        $('#txtAttachedBranch').val(attachedBranch);
        $('#txtAddress').val(address);
        $('#txtContactNo').val(contactNo);
    });
}