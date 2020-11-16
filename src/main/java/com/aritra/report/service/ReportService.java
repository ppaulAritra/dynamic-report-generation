package com.aritra.report.service;

import com.aritra.report.domain.ReportParameter;
import com.aritra.report.domain.dto.ParameterDTO;
import com.aritra.report.domain.dto.QueryDTO;
import com.aritra.report.domain.dto.ReportDTO;

import java.util.List;

public interface ReportService {
    ReportDTO saveReport(ReportDTO reportDTO);
    ReportDTO getReport(Long reportId);
    List<ReportDTO> getAllReport();
    List<ParameterDTO> getReportParameters(Long reportId);
    QueryDTO getQueryRequirements(Long reportId);
}
