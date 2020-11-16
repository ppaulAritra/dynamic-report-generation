package com.aritra.report.controller;

import com.aritra.report.domain.dto.EmployeeDTO;
import com.aritra.report.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping
    @ResponseBody
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        return employeeService.saveEmployee(employeeDTO);
    }
}
