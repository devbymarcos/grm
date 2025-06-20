package com.devbymarcos.grm.modulos.report.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CreateReportDTO {
    private String idTicket;
    private String content;
    private LocalDateTime dateClose;
}
