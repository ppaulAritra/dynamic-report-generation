package com.aritra.report.domain.dto;

import java.util.List;

public class QueryDTO {
    private Long reportId;
    private List<ParameterDTO> parameters;

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public List<ParameterDTO> getParameters() {
        return parameters;
    }

    public void setParameters(List<ParameterDTO> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "QueryDTO{" +
                "reportId=" + reportId +
                ", parameters=" + parameters +
                '}';
    }
}
