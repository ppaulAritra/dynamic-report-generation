package com.aritra.report.mapper;

import com.aritra.report.domain.Employee;
import com.aritra.report.domain.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {
    public  Employee requestMapper(EmployeeDTO dto){
        Employee employee=new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setDesignation(dto.getDesignation());
        employee.setBirthDate(dto.getBirthDate());
        employee.setEmail(dto.getEmail());
        employee.setGender(dto.getGender());
        employee.setJoiningDate(dto.getJoiningDate());
        return employee;
    }
    public  EmployeeDTO responseMapper(Employee entity){
        EmployeeDTO employee=new EmployeeDTO();
        employee.setFirstName(entity.getFirstName());
        employee.setLastName(entity.getLastName());
        employee.setDesignation(entity.getDesignation());
        employee.setBirthDate(entity.getBirthDate());
        employee.setEmail(entity.getEmail());
        employee.setGender(entity.getGender());
        employee.setJoiningDate(entity.getJoiningDate());
        return employee;
    }
}
