// $("#btnSingUp").click(function() {
//     let value = {
//         email: $("#upUser_Name").val(),
//         password: $("#upPassword").val(),
//         role: $('#role_Type').val()
//     };
//     console.log(value);
//     $.ajax({
//         url:  "http://localhost:8080/app1/api/v1/auth/signup",
//         method: "POST",
//         data: JSON.stringify(value),
//         contentType: "application/json",
//         success: function (res, textStatus, jsXH) {
//             localStorage.setItem('accessToken', res.token);
//             Swal.fire({
//                 icon: "success",
//                 title: "User Added Successfully",
//                 showConfirmButton: true,
//                 timer: 1500
//             });
//         },
//         error: function (ob, textStatus, error) {
//             Swal.fire({
//                 icon: "error",
//                 title: "Error User Not Added",
//                 showConfirmButton: false,
//                 timer: 1500
//             });
//         }
//     });
// });
//
// ////////////////////////////////////////////////////////////////////////
// $("#btnLogin").click(function() {
//     let value = {
//         email: $("#user_Name").val(),
//         password: $("#password").val(),
//     };
//     console.log(value);
//     $.ajax({
//         url: "http://localhost:8080/app1/api/v1/auth/signin",
//         method: "POST",
//         data: JSON.stringify(value),
//         contentType: "application/json",
//         success: function (res, textStatus, jsXH) {
//             localStorage.setItem('email', value.email);
//             localStorage.setItem('password', value.password);
//             localStorage.setItem('accessToken', res.token);
//             console.log("User SignIn Successfully " + res.token);
//             fetchUserDetails(value.email, res.token);
//         },
//         error: function (ob, textStatus, error) {
//             Swal.fire({
//                 icon: "error",
//                 title: "Error Sign in",
//                 showConfirmButton: false,
//                 timer: 1500
//             });
//         }
//     });
// });
//
// /////////////////////////////////////////////////////////////////
// function isTokenExpired(token) {
//     const jwtPayload = JSON.parse(atob(token.split('.')[1]));
//     const expiryTime = jwtPayload.exp * 1000;
//     return Date.now() >= expiryTime;
// }
//
// function performAuthenticatedRequest() {
//     const accessToken = localStorage.getItem('accessToken');
//     if (!accessToken || isTokenExpired(accessToken)) {
//         $.ajax({
//             url:  "http://localhost:8080/app1/api/v1/auth/signin",
//             method: "POST",
//             data: JSON.stringify({
//                 email: localStorage.getItem('email'),
//                 password: localStorage.getItem('password'),
//             }),
//             contentType: "application/json",
//             success: function (res, textStatus, jsXH) {
//                 localStorage.setItem('accessToken', res.token);
//                 console.log("Sign in successfully, new token: " + res.token);
//             },
//             error: function (ob, textStatus, error) {
//                 console.log("Token renew sign in error " + error);
//             }
//         });
//     }
// }
//
// ///////////////////////////////////////////////////////////////////
// function fetchUserDetails(email, token) {
//     $.ajax({
//         url: "http://localhost:8080/app1/api/v1/auth/search/" + email,
//         method: "GET",
//         headers: {
//             'Authorization': 'Bearer ' + token
//         },
//         dataType: "json",
//         success: function (res, textStatus, xhr) {
//             localStorage.setItem('role', res.role);
//             localStorage.setItem('cashier', email);
//
//             Swal.fire({
//                 icon: "success",
//                 title: "Fetched user details",
//                 showConfirmButton: true
//             }).
//             then((result) => {
//                 if (result.isConfirmed) {
//                     if (res.role === "ADMIN") {
//                         window.location.href = "homepageAdmin.html";
//                     } else if(res.role === "USER"){
//                         window.location.href = "homepageUser.html";
//                     }
//                 }
//             });
//         },
//         error: function (ob, textStatus, error) {
//             Swal.fire({
//                 icon: "error",
//                 title: "Error fetching user details",
//                 showConfirmButton: false,
//                 timer: 1500
//             });
//         }
//     });
// }




// $("#btnSingUp").click(function() {
//     let value = {
//         email: $("#upUser_Name").val(),
//         password: $("#upPassword").val(),
//         role: $('#role_Type').val()
//     };
//     console.log(value);
//     $.ajax({
//         url: "http://localhost:8080/app1/api/v1/auth/signup",
//         method: "POST",
//         data: JSON.stringify(value),
//         contentType: "application/json",
//         success: function (res, textStatus, jsXH) {
//             localStorage.setItem('accessToken', res.token);
//             Swal.fire({
//                 icon: "success",
//                 title: "User Added Successfully",
//                 showConfirmButton: true,
//                 timer: 1500
//             });
//         },
//         error: function (jqXHR, textStatus, errorThrown) {
//             if (jqXHR.status === 403) {
//                 Swal.fire({
//                     icon: "error",
//                     title: "Forbidden",
//                     text: "You don't have permission to access this resource.",
//                     showConfirmButton: true
//                 });
//             } else {
//                 Swal.fire({
//                     icon: "error",
//                     title: "Error User Not Added",
//                     text: "An error occurred while processing your request.",
//                     showConfirmButton: true
//                 });
//             }
//         }
//     });
// });




$("#btnSignUp").click(function() {
    let value = {
        email: $("#upUser_Name").val(),
        password: $("#upPassword").val(),
        role: $('#role_Type').val()
    };
    console.log("Sending request with data:", value);

    $.ajax({
        url: "http://localhost:8080/app1/api/v1/auth/signup",
        method: "POST",
        data: JSON.stringify(value),
        contentType: "application/json",
        success: function (res, textStatus, jqXHR) {
            console.log("Response received:", res);
            localStorage.setItem('accessToken', res.token);
            Swal.fire({
                icon: "success",
                title: "User Added Successfully",
                showConfirmButton: true,
                timer: 1500
            });
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.error("Error response:", jqXHR);
            if (jqXHR.status === 403) {
                Swal.fire({
                    icon: "error",
                    title: "Forbidden",
                    text: "You don't have permission to access this resource.",
                    showConfirmButton: true
                });
            } else {
                Swal.fire({
                    icon: "error",
                    title: "Error User Not Added",
                    text: "An error occurred while processing your request.",
                    showConfirmButton: true
                });
            }
        }
    });
});