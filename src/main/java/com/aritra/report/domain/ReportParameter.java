package com.aritra.report.domain;

import javax.persistence.Entity;

@Entity
public class ReportParameter extends BaseEntity{
    private String parameterName;
    private String parameterType;

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    @Override
    public String toString() {
        return "ReportParameter{" +
                "parameterName='" + parameterName + '\'' +
                ", parameterType='" + parameterType + '\'' +
                '}';
    }
}
