package com.aritra.report.mapper;

import com.aritra.report.domain.ReportParameter;
import com.aritra.report.domain.dto.ParameterDTO;
import org.springframework.stereotype.Service;

import java.lang.reflect.Parameter;

@Service
public class ParameterMapper {
    public  ReportParameter requestMapper(ParameterDTO dto){
        ReportParameter reportParameter= new ReportParameter();
        reportParameter.setParameterName(dto.getParameterName());
        reportParameter.setParameterType(dto.getParameterType());
        return reportParameter;
    }
    public  ParameterDTO responseMapper(ReportParameter entity)
    {
        ParameterDTO dto= new ParameterDTO();
        dto.setId(entity.getId());
        dto.setParameterName(entity.getParameterName());
        dto.setParameterType(entity.getParameterType());
        return dto;
    }
}
