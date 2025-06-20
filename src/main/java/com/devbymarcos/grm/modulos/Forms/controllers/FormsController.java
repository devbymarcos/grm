package com.devbymarcos.grm.modulos.Forms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devbymarcos.grm.modulos.Forms.entities.FormEntity;
import com.devbymarcos.grm.modulos.Forms.useCase.CreateFormUsecase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/forms")
public class FormsController {

    @Autowired
    private CreateFormUsecase createFormUsecase;

    @PostMapping()
    public ResponseEntity<Object> create(@Valid @RequestBody FormEntity formEntity) {
        try {
            var result = this.createFormUsecase.execute(formEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
