package lk.ijse.gdse66.shoeManagement.app.service;

import lk.ijse.gdse66.shoeManagement.app.auth.request.SingInRequest;
import lk.ijse.gdse66.shoeManagement.app.auth.request.SingUpRequest;
import lk.ijse.gdse66.shoeManagement.app.auth.response.JwtAuthResponse;

public interface AuthenticationService {

    JwtAuthResponse signIn(SingInRequest signInRequest);
    JwtAuthResponse signUp(SingUpRequest signUpRequest);
}
