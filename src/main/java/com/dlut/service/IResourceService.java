package com.dlut.service;

import com.dlut.pojo.Pollutionstandard;
import com.dlut.pojo.Sourcetable;

import java.util.List;
import java.util.Map;

public interface IResourceService {
    // 数据库交互 获得所有污染源
    List<Sourcetable> getPollutionResource();

    // 数据库交互 根据ph获得标准
    Pollutionstandard getStandardByPH(float ph);

    // 获得元素的相关矩阵 matlab混合编程
    double[][] getMatrix(String filePath, int startCol, int endCol);

    // 计算某个元素的超标率
    float calculateOverRate(float[] elemData,float standard);

    // 计算主要 污染元素 后两个参数已废弃 随便填入
    Map<String, Double> getMainElem(String filePath, int startCol, int endCol);

    // 计算两个与输入元素最相关的两个元素
    // 改为返回与输入元素相关元素数据 后两个参数已废弃 随便填入
    Map<Double, String> getMostRelevantElem(String elemName, String filePath, int startCol, int endCol);

    Sourcetable getSourcePollution(String mainElem, String relElem1, String relElem2);
}
