package com.dlut.service.impl;

import com.dlut.dao.ReportMapper;
import com.dlut.pojo.Report;
import com.dlut.pojo.ReportExample;
import com.dlut.service.IReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("reportService")
public class ReportServiceImpl implements IReportService {

    @Resource
    private ReportMapper reportMapper;

    @Override
    public List<Report> getAllReport() {
        ReportExample example = new ReportExample();
        return reportMapper.selectByExample(example);
    }

    @Override
    public boolean addReport(Report report) {
        reportMapper.insert(report);
        return true;
    }

    @Override
    public boolean delReport(Integer id) {
        reportMapper.deleteByPrimaryKey(id);
        return true;
    }
}

