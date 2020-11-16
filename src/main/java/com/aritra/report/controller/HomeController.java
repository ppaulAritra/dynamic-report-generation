package com.aritra.report.controller;

import com.aritra.report.domain.Report;
import com.aritra.report.domain.dto.ParameterDTO;
import com.aritra.report.domain.dto.QueryDTO;
import com.aritra.report.domain.dto.ReportDTO;
import com.aritra.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {
    ReportService reportService;

    @Autowired
    public HomeController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping()
    public ModelAndView viewHome(){
        ModelAndView modelAndView = new ModelAndView("report");
        modelAndView.addObject("reportList",reportService.getAllReport());
        ReportDTO reportDTO= new ReportDTO();
        ParameterDTO parameterDTO= new ParameterDTO();
        reportDTO.getParameters().add(parameterDTO);
        modelAndView.addObject("report",reportDTO);
        modelAndView.addObject("parameter",new QueryDTO());
        return modelAndView;
    }
}
