package com.devbymarcos.grm.modulos.report.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devbymarcos.grm.modulos.report.entities.ReportEntity;
import com.devbymarcos.grm.modulos.report.repositories.ReportRepository;

@Service
public class CreateReportUseCase {

    @Autowired
    private ReportRepository reportRepository;

    public ReportEntity execute(ReportEntity reportEntity) {

        return this.reportRepository.save(reportEntity);
    }
}
