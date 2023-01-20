package com.example.demo.appuser;


import com.example.demo.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping
@AllArgsConstructor
public class loginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtProvider;

    @PostMapping("/login")
    public AuthenticationResponse authenticate(@RequestBody LoginRequest request) {
            String email = request.getEmail();
            String password = request.getPassword();

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            return AuthenticationResponse.builder()
                    .authenticationToken(jwt)
                    .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMs()))
                    .username(request.getEmail())
                    .build();
    }


    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody RefreshTokenRequest refreshTokenRequest) {
//        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(OK).body("Refresh Token Deleted Successfully!!");
    }

}
