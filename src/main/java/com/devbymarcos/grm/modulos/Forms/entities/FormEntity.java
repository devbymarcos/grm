package com.devbymarcos.grm.modulos.Forms.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "forms")
public class FormEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String content;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updateAt;

}
