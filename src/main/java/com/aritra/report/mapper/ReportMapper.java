package com.aritra.report.mapper;

import com.aritra.report.domain.Report;
import com.aritra.report.domain.dto.ParameterDTO;
import com.aritra.report.domain.dto.ReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ReportMapper {
    @Autowired
    ParameterMapper parameterMapper;
    public  Report requestMapper(ReportDTO reportDTO){
        Report report= new Report();
        report.setTitle(reportDTO.getTitle());
        report.setDescription(reportDTO.getDescription());
        report.setTableName(reportDTO.getTableName());
        report.setQuery(reportDTO.getSqlQuery());
        if(reportDTO.getParameters().isEmpty())
        {
            ParameterDTO parameterDTO= new ParameterDTO();
            parameterDTO.setParameterType("Empty");
            reportDTO.getParameters().add(parameterDTO);
        }
        report.setReportParameters(reportDTO.getParameters().stream().map(p->parameterMapper.requestMapper(p)).collect(Collectors.toList()));
        return report;
    }
    public ReportDTO responseMapper(Report entity){
        ReportDTO reportDTO=new ReportDTO();
        reportDTO.setId(entity.getId());
        reportDTO.setTitle(entity.getTitle());
        reportDTO.setDescription(entity.getDescription());
        reportDTO.setSqlQuery(entity.getQuery());
        reportDTO.setTableName(entity.getTableName());
        if(entity.getReportParameters()!=null)
        reportDTO.setParameters(entity.getReportParameters().stream().map(p->parameterMapper.responseMapper(p)).collect(Collectors.toList()));
        //System.out.println(reportDTO);
        return reportDTO;
    }
}
