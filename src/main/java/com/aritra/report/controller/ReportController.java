package com.aritra.report.controller;

import com.aritra.report.common.EntityNotFoundException;
import com.aritra.report.domain.dto.QueryDTO;
import com.aritra.report.domain.dto.ReportDTO;
import com.aritra.report.service.QueryService;
import com.aritra.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {
    ReportService reportService;
    QueryService queryService;

    @Autowired
    public ReportController(ReportService reportService, QueryService queryService) {
        this.reportService = reportService;
        this.queryService = queryService;
    }

    @PostMapping
    public ModelAndView saveReportDetails(@ModelAttribute ReportDTO reportDTO) {
        if (reportDTO == null)
            throw new EntityNotFoundException("Null dto received");
        reportService.saveReport(reportDTO);
        return new ModelAndView("redirect:/home");
    }


    @GetMapping()
    public ModelAndView getReportParamValues(@RequestParam Long reportId) {
        QueryDTO queryDTO = reportService.getQueryRequirements(reportId);
        ModelAndView modelAndView = new ModelAndView("report :: params");
        modelAndView.addObject("status", "modal");
        modelAndView.addObject("parameter", queryDTO);
        return modelAndView;
    }
    @PostMapping("/result")
    public ModelAndView viewResult(@ModelAttribute QueryDTO queryDTO) throws ParseException {
        ModelAndView modelAndView= new ModelAndView("view_result");
        List<Object> result=queryService.getQueryResult(queryDTO);
        System.out.println(result);
        modelAndView.addObject("resultData",result);
        return modelAndView;
    }

    @GetMapping("/param")
    @ResponseBody
    public String checkParam(@RequestParam Long reportId){
        QueryDTO queryDTO = reportService.getQueryRequirements(reportId);
        if (queryDTO==null)
            return "no";
        else
            return "yes";
    }

}
