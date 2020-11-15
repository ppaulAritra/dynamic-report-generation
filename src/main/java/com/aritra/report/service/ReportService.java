package com.aritra.report.service;

import com.aritra.report.domain.ReportParameter;
import com.aritra.report.domain.dto.ParameterDTO;
import com.aritra.report.domain.dto.ReportDTO;

import java.util.List;

public interface ReportService {
    ReportDTO saveReport(ReportDTO reportDTO);
    ReportDTO getReport(Long reportId);
    List<ParameterDTO> getReportParameters(Long reportId);
}
