package com.devbymarcos.grm.modulos.User.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devbymarcos.grm.modulos.User.dto.AuthUserDTO;
import com.devbymarcos.grm.modulos.User.dto.AuthUserRequestDTO;
import com.devbymarcos.grm.modulos.User.useCase.AuthUserUseCase;

import jakarta.validation.Valid;

@RequestMapping("/auth")
public class AuthUserController {

    @Autowired
    private AuthUserUseCase authUserUseCase;

    @PostMapping
    public void auth(@RequestBody AuthUserRequestDTO authUserRequestDTO) {
        try {
            var token = this.authUserUseCase.execute(authUserRequestDTO);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
