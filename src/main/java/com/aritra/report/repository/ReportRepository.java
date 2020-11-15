package com.aritra.report.repository;

import com.aritra.report.domain.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report,Long> {
    Report findFirstById(Long id);
}
