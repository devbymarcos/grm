package com.devbymarcos.grm.modulos.User.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devbymarcos.grm.modulos.User.entities.UserEntity;
import com.devbymarcos.grm.modulos.User.useCase.CreateUserUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class CreateUserController {

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @PostMapping
    public ResponseEntity<Object> userCreate(@Valid @RequestBody UserEntity userEntity) {
        try {
            var result = this.createUserUseCase.execute(userEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());

        }
    }

}
