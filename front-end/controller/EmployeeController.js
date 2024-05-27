
$(document).ready(function () {
    generateEmployeeID();
    getAll();

    $('#employeeSaveBtn').click(function () {
        let employee = getEmployeeDataFromForm();

        $.ajax({
            url: 'http://localhost:8080/app1/employee/save',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(employee),
            success: function (response) {
                alert('Employee information saved successfully!');
                console.log(employee);
                clearFields();
                getAll();
            },
            error: function (xhr, status, error) {
                console.error('Error saving employee information:', error);
                alert('Employee Not Found!');
            }
        });
    });

    $('#btnEmUpdate').click(function () {
        let employee = getEmployeeDataFromForm();

        $.ajax({
            url: 'http://localhost:8080/app1/employee/update',
            type: 'PATCH',
            contentType: 'application/json',
            data: JSON.stringify(employee),
            success: function (response) {
                alert('Employee information updated successfully!');
                console.log(employee);
                clearFields();
                getAll();
            },
            error: function (xhr, status, error) {
                console.error('Error updating employee information:', error);
                alert('Employee Not Found!');
            }
        });
    });

    $('#btnEmDelete').click(function () {
        let employeeCode = $('#txtEmployeeCode').val();

        $.ajax({
            url: 'http://localhost:8080/app1/employee/' + employeeCode,
            type: 'DELETE',
            success: function (response) {
                alert('Employee information deleted successfully!');
                console.log('Deleted employee with code:', employeeCode);
                clearFields();
                getAll();
            },
            error: function (xhr, status, error) {
                console.error('Error deleting employee information:', error);
                alert('Employee Not Found!');
            }
        });
    });

    // $('#txtEmployeePicture').change(function() {
    //     var fileInput = $('#txtEmployeePicture')[0];
    //     var file = fileInput.files[0];

    //     if (file && (file.type.includes('image') || file.type === 'image/gif')) {
    //         var reader = new FileReader();
    //         reader.onload = function (e) {
    //             $('#img').attr('src', e.target.result);
    //         };
    //         reader.readAsDataURL(file);
    //         $(this).val("");
    //     } else {
    //         // Handle error scenario
    //     }
    // });

    $('#btnSearchEmployee').click(function (){

    });

    //////////////////////////////////methods////////////////////////////////////



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
            let accessRole = $(this).children(':nth-child(6)').text();
            let dob = $(this).children(':nth-child(7)').text();
            let dateOfJoin = $(this).children(':nth-child(8)').text();
            let attachedBranch = $(this).children(':nth-child(9)').text();
            let address = $(this).children(':nth-child(10)').text();
            let contactNo = $(this).children(':nth-child(11)').text();

            $('#txtEmployeeCode').val(employeeCode);
            $('#txtEmployeeName').val(employeeName);
            $('#txtEmployeeGender').val(gender);
            $('#txtEmployeeStatus').val(status);
            $('#txtEmployeeDesignation').val(designation);
            $('#txtAccessRole').val(accessRole);
            $('#txtEmployeeDateOfBirth').val(dob);
            $('#txtEmployeeDateOfJoin').val(dateOfJoin);
            $('#txtAttachedBranch').val(attachedBranch);
            $('#txtAddress').val(address);
            $('#txtContactNo').val(contactNo);
        });
    }

    function clearFields() {
        $('#txtEmployeeCode').val('');
        $('#txtEmployeeName').val('');
        $('#txtEmployeeGender').val('');
        $('#txtEmployeeStatus').val('');
        $('#txtEmployeeDesignation').val('');
        $('#txtAccessRole').val('');
        $('#txtEmployeeDateOfBirth').val('');
        $('#txtEmployeeDateOfJoin').val('');
        $('#txtAttachedBranch').val('');
        $('#txtAddress').val('');
        $('#txtContactNo').val('');

        $("#txtEmployeeCode").focus();
    }

    function generateEmployeeID() {
        $("#txtEmployeeCode").val("EMP00-001");
        $.ajax({
            url: "http://localhost:8080/app1/employee/employeeGenerate",
            method: "GET",
            contentType: "application/json",
            dataType: "json",
            success: function (resp) {
                let id = resp.value;
                if (id) {
                    let tempId = parseInt(id.split("-")[1]) + 1;
                    let newId = "EMP00-" + tempId.toString().padStart(3, '0');
                    $("#txtEmployeeCode").val(newId);
                }
            },
            error: function (ob, statusText, error) {
                console.error("Error generating employee ID:", statusText, error);
            }
        });
    }


    function getEmployeeDataFromForm() {
        return {
            employeeCode: $('#txtEmployeeCode').val(),
            employeeName: $('#txtEmployeeName').val(),
            gender: $('#txtEmployeeGender').find(':selected').val(),
            status: $('#txtEmployeeStatus').val(),
            designation: $('#txtEmployeeDesignation').val(),
            accessRole: $('#txtAccessRole').find(':selected').val(),
            dob: $('#txtEmployeeDateOfBirth').val(),
            dateOfJoin: $('#txtEmployeeDateOfJoin').val(),
            attachedBranch: $('#txtAttachedBranch').val(),
            address: $('#txtAddress').val(),
            contactNo: $('#txtContactNo').val()
        };
    }
});
