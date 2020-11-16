package com.aritra.report.service.implementation;

import com.aritra.report.common.util.DateTimeUtils;
import com.aritra.report.common.util.DateUtil;
import com.aritra.report.domain.dto.ParameterDTO;
import com.aritra.report.domain.dto.QueryDTO;
import com.aritra.report.domain.dto.ReportDTO;
import com.aritra.report.service.QueryService;
import com.aritra.report.service.ReportService;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.DateUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.ParseException;
import java.util.List;

@Service
public class QueryServiceImpl implements QueryService {
    @PersistenceContext
    private EntityManager entityManager;
    ReportService reportService;

    @Autowired
    public QueryServiceImpl(ReportService reportService) {
        this.reportService = reportService;
    }
    @Override
    public List<Object> getQueryResult(QueryDTO queryDTO) throws ParseException {
        Session session = entityManager.unwrap(Session.class);
        ReportDTO reportDTO = reportService.getReport(queryDTO.getReportId());
        String hql = reportDTO.getSqlQuery();

        Query query = session.createQuery(hql);
        if (queryDTO.getParameters() == null) {

        } else {
            for (ParameterDTO param : queryDTO.getParameters()) {
                if (param.getParameterType().equalsIgnoreCase("string"))
                    query.setParameter(param.getParameterName(), param.getParameterValue());
                else if (param.getParameterType().equalsIgnoreCase("integer"))
                    query.setParameter(param.getParameterName(), Integer.valueOf(param.getParameterValue()));
                else if (param.getParameterType().equalsIgnoreCase("long"))
                    query.setParameter(param.getParameterName(), Long.valueOf(param.getParameterValue()));
                else if (param.getParameterType().equalsIgnoreCase("date"))
                    query.setParameter(param.getParameterName(), DateTimeUtils.toDate(param.getParameterValue()));

            }

        }
      //  session.flush();
       // session.clear();
        List<Object> result=query.list();

        return result;
    }
}
