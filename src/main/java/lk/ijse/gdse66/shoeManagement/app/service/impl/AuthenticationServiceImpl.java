package lk.ijse.gdse66.shoeManagement.app.service.impl;

import lk.ijse.gdse66.shoeManagement.app.auth.request.SignInRequest;
import lk.ijse.gdse66.shoeManagement.app.auth.request.SignUpRequest;
import lk.ijse.gdse66.shoeManagement.app.auth.response.JwtAuthResponse;
import lk.ijse.gdse66.shoeManagement.app.dto.UserDTO;
import lk.ijse.gdse66.shoeManagement.app.entity.UserEntity;
import lk.ijse.gdse66.shoeManagement.app.repository.EmployeeRepo;
import lk.ijse.gdse66.shoeManagement.app.repository.UserRepo;
import lk.ijse.gdse66.shoeManagement.app.service.AuthenticationService;
import lk.ijse.gdse66.shoeManagement.app.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final JWTService jwtService;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired

    private EmployeeRepo employeeRepo;

    private final PasswordEncoder passwordEncoder;


    @Override
    public JwtAuthResponse signIn(SignInRequest signInRequest) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));
        UserEntity user = userRepo.findByEmail(signInRequest.getEmail()).orElseThrow(()->new UsernameNotFoundException("User Not Found"));
        String generatedToken = jwtService.generateToken((UserDetails) user);
        String role = user.getAccessRole().name();

        return JwtAuthResponse.builder().token(generatedToken).accessRole(role).build();
    }

    @Override
    public JwtAuthResponse signUp(SignUpRequest signUpRequest) {
        System.out.println(signUpRequest);


        UserEntity savedUser;
        UserDTO userDTO = UserDTO.builder()
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .accessRole(signUpRequest.getAccessRole())
                .build();
        savedUser = userRepo.save(mapper.map(userDTO, UserEntity.class));

        String generatedToken = jwtService.generateToken( savedUser);
        return JwtAuthResponse.builder().token(generatedToken).build();
    }
}