package com.devbymarcos.grm.modulos.report.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devbymarcos.grm.modulos.report.dto.CreateReportDTO;
import com.devbymarcos.grm.modulos.report.entities.ReportEntity;
import com.devbymarcos.grm.modulos.report.useCase.CreateReportUseCase;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private CreateReportUseCase createReportUseCase;

    @PostMapping("/create")
    public ReportEntity create(@Valid @RequestBody CreateReportDTO createReportDTO, HttpServletRequest request) {

        var userId = request.getAttribute("user_id");

        var reportEntity = ReportEntity.builder()
                .content(createReportDTO.getContent())
                .userId(UUID.fromString(userId.toString()))
                .build();
        return this.createReportUseCase.execute(reportEntity);

    }

}
