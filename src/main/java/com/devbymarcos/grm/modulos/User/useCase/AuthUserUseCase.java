package com.devbymarcos.grm.modulos.User.useCase;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.devbymarcos.grm.modulos.User.dto.AuthUserRequestDTO;
import com.devbymarcos.grm.modulos.User.dto.AuthUserResponseDTO;
import com.devbymarcos.grm.modulos.User.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;

public class AuthUserUseCase {

    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private UserRepository userRepository;

    public AuthUserResponseDTO execute(AuthUserRequestDTO authUserRequestDTO) {
        var user = this.userRepository.findByEmail(authUserRequestDTO.email())
                .orElseThrow(() -> new UsernameNotFoundException("Email/passsword  incorrect"));

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var token = JWT.create()
                .withIssuer("grm-api")
                .withSubject(user.getId().toString())
                .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                .withClaim("roles", Arrays.asList("user"))
                .sign(algorithm);

        var authUserResponse = AuthUserResponseDTO.builder()
                .access_token(token)
                .build();

        return authUserResponse;

    }

}
