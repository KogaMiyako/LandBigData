package com.dlut.service.impl;

import com.dlut.dao.PollutionstandardMapper;
import com.dlut.dao.SourcetableMapper;
import com.dlut.pojo.Pollutionstandard;
import com.dlut.pojo.PollutionstandardExample;
import com.dlut.pojo.Sourcetable;
import com.dlut.pojo.SourcetableExample;
import com.dlut.service.IResourceService;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.*;

import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import fuzzyClustering.MatlabSimilarityMatrix;

@Service("pollutionResource")
public class ResourceServiceImpl implements IResourceService {

    @Resource
    private SourcetableMapper sourcetableMapper;

    @Resource
    private PollutionstandardMapper pollutionstandardMapper;

    @Override
    public List<Sourcetable> getPollutionResource() {
        SourcetableExample example = new SourcetableExample();
        return sourcetableMapper.selectByExample(example);
    }

    @Override
    public Pollutionstandard getStandardByPH(float ph) {
        PollutionstandardExample example = new PollutionstandardExample();
        PollutionstandardExample.Criteria criteria = example.createCriteria();

        criteria.andPhLowLessThan(ph);
        criteria.andPhHighGreaterThanOrEqualTo(ph);
        return pollutionstandardMapper.selectByExample(example).get(0);
    }

    @Override
    public double[][] getMatrix(String filePath, int startCol, int endCol) {
        try {
            MatlabSimilarityMatrix matlabSimilarityMatrix = new MatlabSimilarityMatrix();
            Object[] result = matlabSimilarityMatrix.fuzzyClustering(1, filePath, startCol, endCol);
            MWNumericArray data = (MWNumericArray) result[0];
            return (double[][]) data.toDoubleArray();
        }catch (MWException e){
            e.printStackTrace();
        }
        return new double[0][];
    }

    @Override
    public float calculateOverRate(float[] elemData, float standard) {
        int count = 0;
        for (float elemDatum : elemData) {
            if (elemDatum > standard) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Map<String, Double> getMainElem(String filePath, int startCol, int endCol) {


        List<String> elemList = new ArrayList<>();
        List<Integer> overCount = new ArrayList<>();
        List<Float> standardList = new ArrayList<>();
        Pollutionstandard pollutionstandard = getStandardByPH(6.68f);



        try {
            XSSFWorkbook workbook = new XSSFWorkbook(filePath);
            XSSFSheet sheet = workbook.getSheetAt(0);

            // 获取第一行 元素名
            XSSFRow firstRow = sheet.getRow(0);

            endCol = firstRow.getLastCellNum();
            System.out.println(endCol);

            // 初始化
            for (int i = 0; i < endCol; i++) {
                overCount.add(0);
            }

            for (int i = 0; i < endCol; i++) {
                XSSFCell cell = firstRow.getCell(i);
                System.out.println(cell.getStringCellValue());
                elemList.add(cell.getStringCellValue());
            }

            // 根据元素名 找到标准
            for(String elemName: elemList){
                switch (elemName){
                    case "Cr":
                        standardList.add(pollutionstandard.getCr());
                        break;
                    case "Ni":
                        standardList.add(pollutionstandard.getNi());
                        break;
                    case "Cu":
                        standardList.add(pollutionstandard.getCu());
                        break;
                    case "Zn":
                        standardList.add(pollutionstandard.getZn());
                        break;
                    case "As":
                        standardList.add(pollutionstandard.getAs());
                        break;
                    case "Cd":
                        standardList.add(pollutionstandard.getCd());
                        break;
                    case "Hg":
                        standardList.add(pollutionstandard.getHg());
                        break;
                    case "Pb":
                        standardList.add(pollutionstandard.getPb());
                        break;
                    default:
                        break;
                }
            }

            // 遍历每一行
            int lastRowNum = sheet.getLastRowNum();
//            System.out.println(lastRowNum);

            for(int i = 1; i<= lastRowNum; i++){
                // 从第二行开始遍历数据
                XSSFRow row = sheet.getRow(i);
                if (row != null){
                    for (int j = 0; j<endCol;j++){
                        XSSFCell cell = row.getCell(j);
                        // 元素的序号
//                        int elemIndex = j + 1 -startCol;
                        if(cell!=null){
                            double doubleCellValue = cell.getNumericCellValue();
                            float elemData = (float)doubleCellValue;
                            if (elemData > standardList.get(j)){
                                // 统计超标数
                                int nowCount = overCount.get(j);
                                overCount.set(j, nowCount+1);
                            }

                        }
                    }
                }
            }

            /*int maxElem = overCount.get(0);
            int maxIndex = 0;
            for (int i = 1; i < overCount.size(); i++) {
                if (overCount.get(i)>maxElem){
                    maxElem = overCount.get(i);
                    maxIndex = i;
                }
            }*/

//            workbook.close();

            Map<String, Double> resMap = new HashMap<>();
            for (int i = 0; i<elemList.size() ; i++){
                System.out.println(elemList.get(i)+" "+ overCount.get(i));
                resMap.put(elemList.get(i), ((double)overCount.get(i) / lastRowNum));
            }

            return resMap;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<Double, String> getMostRelevantElem(String elemName, String filePath, int startCol, int endCol){



        try {

            // xlsx

            XSSFWorkbook workbook = new XSSFWorkbook(filePath);

            XSSFSheet sheet = workbook.getSheetAt(0);

            // 获取第一行 元素名
            XSSFRow firstRow = sheet.getRow(0);

            endCol = firstRow.getLastCellNum();

            // 获得相关矩阵
            double[][] relevantMatrix = getMatrix(filePath, 1, endCol);
            List<String> elemList = new ArrayList<>();
            int maxIndex = 0;

            int maxRelevantIndex = 0;
            int secRelevantIndex = 0;
            double maxRelevantRate;
            double secRelevantRate;

            double[] maxElemRelevantRates;

            Map<Double, String> sortMap = new TreeMap<>();


            for (int i = 0; i < endCol; i++) {
                XSSFCell cell = firstRow.getCell(i);
                if (cell.getStringCellValue().equals(elemName)){
                    maxIndex = i;
                }
                elemList.add(cell.getStringCellValue());
            }

//            System.out.println(elemList.get(maxIndex));


            // 最主要元素相关系数数组
            // 改为往map中放入所有数据
            maxRelevantRate = 0;
            maxElemRelevantRates = relevantMatrix[maxIndex];
            for (int i = 0; i<maxElemRelevantRates.length;i++) {
                if (i == maxIndex){
                    continue;
                }
                /*if (maxElemRelevantRates[i]>maxRelevantRate){
                    maxRelevantIndex = i;
                    maxRelevantRate = maxElemRelevantRates[i];
                }*/
                // 放入Tree Map
                sortMap.put(maxElemRelevantRates[i], elemList.get(i));
            }

            /*// 修改最大数据
            System.out.println(maxRelevantIndex);
            System.out.println(maxRelevantRate);

            maxElemRelevantRates[maxRelevantIndex] = 0;
            secRelevantRate = 0;
            for (int i = 0; i<maxElemRelevantRates.length;i++) {
                if (i == maxIndex){
                    continue;
                }
                if (maxElemRelevantRates[i]>secRelevantRate){
                    secRelevantIndex = i;
                    secRelevantRate = maxElemRelevantRates[i];
                }
            }*/

            workbook.close();

            /*System.out.println(secRelevantIndex);
            System.out.println(secRelevantRate);

            Map<String, Double> resMap = new HashMap<>();
            resMap.put(elemList.get(maxRelevantIndex), maxRelevantRate);
            resMap.put(elemList.get(secRelevantIndex), secRelevantRate);*/

            return sortMap;

        }catch (IOException e) {
            e.printStackTrace();
        }

        /* test res
         * 0.7115051148664594
         * 0.7301484696442679
         * 1.0
         * 0.7395984034639497
         * 0.6513579790890716
         * 0.641497624690902
         * 0.5897333292291276
         * 0.6584377340679861
         */

        return null;
    }

    @Override
    public Sourcetable getSourcePollution(String mainElem, String relElem1, String relElem2) {
        List<Sourcetable> sourceList = getPollutionResource();
        String[] elemNames = new String[]{"Cr","Ni","Cu","Zn","As","Cd","Hg","Pb"};

        // 获取序号
        int[] indexArray = new int[3];
        for (int i = 0; i<elemNames.length;i++){
            if (mainElem.equals(elemNames[i])){
                indexArray[0] = i;
//                System.out.println(i);
            }else if (relElem1.equals(elemNames[i])){
                indexArray[1] = i;
//                System.out.println(i);
            }else if (relElem2.equals(elemNames[i])){
                indexArray[2] = i;
//                System.out.println(i);
            }
        }
//        System.out.println(indexArray[0]);
//        System.out.println(indexArray[1]);
//        System.out.println(indexArray[2]);


        int[] sourceDistance = new int[6];
        // 计算最相近污染源
        for (int i=0; i<sourceList.size();i++){
            int[] point = new int[8];
            Sourcetable item = sourceList.get(i);
            point[0] = item.getCr();
            point[1] = item.getNi();
            point[2] = item.getCu();
            point[3] = item.getZn();
            point[4] = item.getAs();
            point[5] = item.getCd();
            point[6] = item.getHg();
            point[7] = item.getPb();

            sourceDistance[i] += Math.abs(point[indexArray[0]] - 2);
            sourceDistance[i] += Math.abs(point[indexArray[1]] - 2);
            sourceDistance[i] += Math.abs(point[indexArray[2]] - 1);
//            System.out.println(sourceDistance[i]);

        }

        int minDisIndex = 0;
        int minDis = sourceDistance[0];
        for (int i = 1; i < sourceDistance.length; i++) {
            if (sourceDistance[i]<minDis){
                minDisIndex = i;
                minDis = sourceDistance[i];
            }
        }
        System.out.println(minDisIndex);
        return sourceList.get(minDisIndex);
    }
}
