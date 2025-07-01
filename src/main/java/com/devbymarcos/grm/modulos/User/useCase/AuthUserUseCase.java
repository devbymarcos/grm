package com.devbymarcos.grm.modulos.User.useCase;

import java.time.Duration;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.devbymarcos.grm.modulos.User.dto.AuthUserRequestDTO;
import com.devbymarcos.grm.modulos.User.dto.AuthUserResponseDTO;
import com.devbymarcos.grm.modulos.User.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;

@Service
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
                                .withClaim("id", user.getId().toString())
                                .withClaim("email", user.getEmail())
                                .withClaim("role", user.getRole())
                                .sign(algorithm);

                var authUserResponse = AuthUserResponseDTO.builder()
                                .token(token)
                                .success(true)
                                .message("token criado com sucesso")
                                .build();

                return authUserResponse;

        }

}
