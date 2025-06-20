package com.devbymarcos.grm.modulos.Organization.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
@Entity(name = "ORGANIZATION")
public class OrganizationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updateAt;

}
