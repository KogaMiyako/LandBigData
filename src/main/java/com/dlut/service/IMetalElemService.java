package com.dlut.service;

import com.dlut.pojo.Metalelem;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IMetalElemService {
    // 获取最新时间的元素
    Metalelem getNewestElem();
    // 获取前五个最新的元素
    List<Metalelem> getFiveNewestElems();
}
