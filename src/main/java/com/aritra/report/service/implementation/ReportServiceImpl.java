package com.aritra.report.service.implementation;

import com.aritra.report.common.EntityNotFoundException;
import com.aritra.report.domain.Report;
import com.aritra.report.domain.ReportParameter;
import com.aritra.report.domain.dto.ParameterDTO;
import com.aritra.report.domain.dto.QueryDTO;
import com.aritra.report.domain.dto.ReportDTO;
import com.aritra.report.mapper.ParameterMapper;
import com.aritra.report.mapper.ReportMapper;
import com.aritra.report.repository.ReportRepository;
import com.aritra.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {
    ReportMapper reportMapper;
    ReportRepository reportRepository;
    ParameterMapper parameterMapper;

    @Autowired
    public ReportServiceImpl(ReportMapper reportMapper, ReportRepository reportRepository, ParameterMapper parameterMapper) {
        this.reportMapper = reportMapper;
        this.reportRepository = reportRepository;
        this.parameterMapper = parameterMapper;
    }

    @Override
    public ReportDTO saveReport(ReportDTO reportDTO) {
        Report report=reportMapper.requestMapper(reportDTO);
        return reportMapper.responseMapper(reportRepository.save(report));
    }

    @Override
    public ReportDTO getReport(Long reportId) {
    Report report= reportRepository.findFirstById(reportId);
    if(report==null)
        throw new EntityNotFoundException("No such report record found");
        return reportMapper.responseMapper(report);
    }

    @Override
    public List<ReportDTO> getAllReport() {
        List<Report> reportList=reportRepository.findAll();
        return reportList.stream().map(p->reportMapper.responseMapper(p)).collect(Collectors.toList());
    }

    @Override
    public List<ParameterDTO> getReportParameters(Long reportId) {
        Report report= reportRepository.findFirstById(reportId);
        if(report==null)
            throw new EntityNotFoundException("No such report record found");
        return report.getReportParameters().stream().map(p->parameterMapper.responseMapper(p)).collect(Collectors.toList());
    }

    @Override
    public QueryDTO getQueryRequirements(Long reportId) {
        List<ParameterDTO> parameters=this.getReportParameters(reportId);
        if(parameters.size()==1 && parameters.get(0).getParameterType().equalsIgnoreCase("empty"))
        return null;
        else
        {
            QueryDTO queryDTO= new QueryDTO();
            queryDTO.setReportId(reportId);
            queryDTO.setParameters(parameters);
            return queryDTO;
        }

    }
}
