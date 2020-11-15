package com.aritra.report.service.implementation;

import com.aritra.report.domain.dto.QueryDTO;
import com.aritra.report.domain.dto.ReportDTO;
import com.aritra.report.service.QueryService;
import com.aritra.report.service.ReportService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class QueryServiceImpl implements QueryService {
    @PersistenceContext
    private EntityManager entityManager;
    ReportService reportService;
    @Autowired
    public QueryServiceImpl(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public List<Object> getQueryResult(QueryDTO queryDTO) {
        ReportDTO reportDTO=reportService.getReport(queryDTO.getReportId());
        String hql = reportDTO.getSqlQuery();
        Session session = entityManager.unwrap(Session.class);
        return null;
    }
}
