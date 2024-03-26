package com.dlut.service;

import com.dlut.pojo.Report;

import java.util.List;

public interface IReportService {
    List<Report> getAllReport();

    boolean addReport(Report report);

    boolean delReport(Integer id);
}
