package com.devbymarcos.grm.modulos.User.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devbymarcos.grm.modulos.User.dto.AuthUserRequestDTO;
import com.devbymarcos.grm.modulos.User.useCase.AuthUserUseCase;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    @Autowired
    private AuthUserUseCase authUserUseCase;

    @PostMapping
    public ResponseEntity<Object> auth(@RequestBody AuthUserRequestDTO authUserRequestDTO) {
        System.out.println(authUserUseCase);
        try {
            var token = this.authUserUseCase.execute(authUserRequestDTO);
            return ResponseEntity.ok().body(token);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
