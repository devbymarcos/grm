package com.devbymarcos.grm.modulos.report.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.devbymarcos.grm.modulos.User.entities.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "REPORTS")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String idTicket;
    @Lob
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private LocalDateTime dateClose;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity user;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updateAt;
}
