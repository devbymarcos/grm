package com.devbymarcos.grm.modulos.report.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.devbymarcos.grm.modulos.report.entities.ReportEntity;

public interface ReportRepository extends JpaRepository<ReportEntity, UUID> {

}
