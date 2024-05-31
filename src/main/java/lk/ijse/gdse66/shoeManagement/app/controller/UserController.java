package lk.ijse.gdse66.shoeManagement.app.controller;

import lk.ijse.gdse66.shoeManagement.app.auth.request.SignInRequest;
import lk.ijse.gdse66.shoeManagement.app.auth.request.SignUpRequest;
import lk.ijse.gdse66.shoeManagement.app.auth.response.JwtAuthResponse;
import lk.ijse.gdse66.shoeManagement.app.dto.UserDTO;
import lk.ijse.gdse66.shoeManagement.app.service.AuthenticationService;
import lk.ijse.gdse66.shoeManagement.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationService authenticationService;



    //    @PostMapping("/save")
//    public UserDTO save(@RequestBody UserDTO userDTO){
//        System.out.println(userDTO);
//
//        return userService.(userDTO);
//    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> signIn(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authenticationService.signIn(signInRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthResponse> signUp(@RequestBody SignUpRequest signUpRequest){
        System.out.println(signUpRequest);
        return ResponseEntity.ok(authenticationService.signUp(signUpRequest));
    }
}