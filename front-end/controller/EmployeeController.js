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


});