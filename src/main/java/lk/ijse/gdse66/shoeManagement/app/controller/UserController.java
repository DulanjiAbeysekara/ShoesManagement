package lk.ijse.gdse66.shoeManagement.app.controller;


import lk.ijse.gdse66.shoeManagement.app.auth.request.SignInRequest;
import lk.ijse.gdse66.shoeManagement.app.auth.request.SignUpRequest;
import lk.ijse.gdse66.shoeManagement.app.auth.response.JwtAuthResponse;
import lk.ijse.gdse66.shoeManagement.app.dto.UserDTO;
import lk.ijse.gdse66.shoeManagement.app.service.AuthenticationService;
import lk.ijse.gdse66.shoeManagement.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final AuthenticationService authenticationService;
    private final UserService userService;


    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> signIn(
            @RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(
                authenticationService.signIn(signInRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthResponse> signUp(
            @RequestBody SignUpRequest signUpRequest){
        System.out.println(signUpRequest);
        return ResponseEntity.ok(
                authenticationService.signUp(signUpRequest));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/search/{id}")
    public UserDTO getUser(@PathVariable("id") String id) {
        return userService.searchUser(id);
    }



}