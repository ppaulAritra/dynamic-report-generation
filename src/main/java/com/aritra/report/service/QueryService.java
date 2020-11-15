package com.aritra.report.service;

import com.aritra.report.domain.dto.QueryDTO;

import java.util.List;

public interface QueryService {
    List<Object> getQueryResult(QueryDTO queryDTO);
}
