package com.devbymarcos.grm.modulos.Forms.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devbymarcos.grm.modulos.Forms.entities.FormEntity;
import com.devbymarcos.grm.modulos.Forms.repositories.FormRepository;

@Service
public class CreateFormUsecase {

    @Autowired
    private FormRepository formRepository;

    public FormEntity execute(FormEntity formEntity) {
        return this.formRepository.save(formEntity);
    }
}
