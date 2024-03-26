package com.dlut.service;

import com.dlut.pojo.AlgHistory;

import java.util.List;

public interface IAlgHistoryService {

    List<AlgHistory> getHistoryByUserId(int UserId);

    boolean addHistory(AlgHistory algHistory);
}
