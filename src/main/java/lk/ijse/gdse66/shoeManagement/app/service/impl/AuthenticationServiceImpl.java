package lk.ijse.gdse66.shoeManagement.app.service.impl;

import lk.ijse.gdse66.shoeManagement.app.auth.request.SingInRequest;
import lk.ijse.gdse66.shoeManagement.app.auth.request.SingUpRequest;
import lk.ijse.gdse66.shoeManagement.app.auth.response.JwtAuthResponse;
import lk.ijse.gdse66.shoeManagement.app.dto.UserDTO;
import lk.ijse.gdse66.shoeManagement.app.entity.UserEntity;
import lk.ijse.gdse66.shoeManagement.app.repository.UserRepo;
import lk.ijse.gdse66.shoeManagement.app.service.AuthenticationService;
import lk.ijse.gdse66.shoeManagement.app.service.JwtService;
import lk.ijse.gdse66.shoeManagement.app.util.AccessRole;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {


    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    private final ModelMapper mapper;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthResponse signIn(SingInRequest signInRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));
        UserEntity user = userRepo.findByEmail(signInRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
        String generatedToken = jwtService.generateToken(user);
        return JwtAuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public JwtAuthResponse signUp(SingUpRequest signUpRequest) {
        UserDTO userDTO = UserDTO.builder()
                .id(UUID.randomUUID().toString())
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .role(AccessRole.valueOf(signUpRequest.getRole()))
                .build();
        UserEntity savedUser = userRepo.save(mapper.map(userDTO, UserEntity.class));
        String generatedToken = jwtService.generateToken(savedUser);
        return JwtAuthResponse.builder().token(generatedToken).build();
    }
}
