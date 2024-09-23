package com.example.phr.PatientHospitalRecords;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final HospitalRepository hospitalRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var hospitaluser = HospitalUser.builder()
                .first_name(request.getFirst_name())
                .last_name(request.getLast_name())
                .email(request.getEmail())
                .user_password(passwordEncoder.encode(request.getUser_password()))
                .hospital_role(HospitalRole.DOCTOR)
                .build();
        hospitalRepository.save(hospitaluser);
        var jwtToken = jwtService.generateToken(hospitaluser);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticateRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getUser_password()));
        var hospitalUser = hospitalRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(hospitalUser);
         return AuthenticationResponse.builder().token(jwtToken).build();

    }
}
