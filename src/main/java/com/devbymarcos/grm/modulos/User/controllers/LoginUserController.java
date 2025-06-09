package com.devbymarcos.grm.modulos.User.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devbymarcos.grm.modulos.User.dto.LoginUserDTO;

import jakarta.validation.Valid;

@RequestMapping("/login")
public class LoginUserController {

    @PostMapping
    public void login(@Valid @RequestBody LoginUserDTO loginUserDTO) {

    }
}
