package com.aritra.report.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class ReportDTO {
    private Long id;
    private String title;
    private String description;
    private String tableName;
    private String sqlQuery;
    private List<ParameterDTO> parameters=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getSqlQuery() {
        return sqlQuery;
    }

    public void setSqlQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }

    public List<ParameterDTO> getParameters() {
        return parameters;
    }

    public void setParameters(List<ParameterDTO> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "ReportDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", tableName='" + tableName + '\'' +
                ", sqlQuery='" + sqlQuery + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
