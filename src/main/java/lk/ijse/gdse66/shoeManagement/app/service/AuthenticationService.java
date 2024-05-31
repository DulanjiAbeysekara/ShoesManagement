package lk.ijse.gdse66.shoeManagement.app.service;

import lk.ijse.gdse66.shoeManagement.app.auth.request.SignInRequest;
import lk.ijse.gdse66.shoeManagement.app.auth.request.SignUpRequest;
import lk.ijse.gdse66.shoeManagement.app.auth.response.JwtAuthResponse;

public interface AuthenticationService {
    JwtAuthResponse signIn(SignInRequest sIgnInRequest);

    JwtAuthResponse signUp(SignUpRequest signUpRequest);
}
