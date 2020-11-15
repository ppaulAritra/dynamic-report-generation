package com.aritra.report.service.implementation;

import com.aritra.report.domain.dto.EmployeeDTO;
import com.aritra.report.mapper.EmployeeMapper;
import com.aritra.report.repository.EmployeeRepository;
import com.aritra.report.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeMapper employeeMapper;
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository) {
        this.employeeMapper = employeeMapper;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        return employeeMapper.responseMapper(employeeRepository.save(employeeMapper.requestMapper(employeeDTO)));
    }
}
