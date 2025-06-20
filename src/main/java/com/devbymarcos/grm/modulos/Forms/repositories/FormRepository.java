package com.devbymarcos.grm.modulos.Forms.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devbymarcos.grm.modulos.Forms.entities.FormEntity;

public interface FormRepository extends JpaRepository<FormEntity, UUID> {

}