package com.dlut.algorithm;

import Jama.Matrix;
import com.dlut.pojo.wrapper.PollutionAnalysis;
import com.dlut.util.ArrUtils;
import com.dlut.util.EncodingHelper;
import com.dlut.util.ExcelUtil;


import java.util.*;

public class MetalCluster {
    public static void main(String[] args) {

//        MetalModel model  = createMetalModel("/home/liuyu/mahoutdata/kmeansdata/cluster_GD.xlsx");
//        Map<String,String> map = calculateScore(model);
//        double[][] result = calculateScore2Matrix(model);
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(25);
        list.add(6);
        list.add(52);
        list.add(11);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2)
                    return 1;
                else
                    return -1;
            }
        });
        System.out.println(list);
    }
    public static MetalModel createMetalModel(String filename){

        double[][] data = null;
        String[] elementName = new String[9];
        try {
            data = ExcelUtil.getData(filename,4);
            data = ArrUtils.getSubArr(data,data.length,9);
            String[] eleStrs = ExcelUtil.getElementNames();
            System.arraycopy(eleStrs,0,elementName,0,9);
            Matrix matrix = new Matrix(data);
            matrix = matrix.transpose();
            data = matrix.getArray();



        } catch (Exception e) {
            e.printStackTrace();
        }
        MetalModel model = new MetalModel(elementName,data);
        for(int i=0;i<elementName.length;i++){
            model.addMetalData(elementName[i],data[i]);
        }
        return model;
    }
    public static Map<String,String> calculateScore(MetalModel model){
        //此处矩阵是已经转置过的矩阵，行是金属，列是样本列
        double[][] data = model.getData();

        String[] elements = model.getElements();
        Map<String,String> map = new HashMap<>();
        for(int i=0;i<data.length-1;i++){
            for(int j=i+1;j<data.length;j++){
                String ele1 = elements[i];
                String ele2 = elements[j];
                double[] ele1Data = data[i];
                double[] ele2Data = data[j];
                int length = ele1Data.length*(ele1Data.length-1)/2;
                double score = 0;
                for(int k=0;k<ele1Data.length-1;k++){
                    for(int l=k+1;l<ele1Data.length;l++){
                        double ele11 = ele1Data[k]-ele1Data[l];
                        double ele22 = ele2Data[k]-ele2Data[l];
                        if(ele11/ele22>0)
                            score++;
                    }
//                  if((ele1Data[k+1]-ele1Data[k])/(ele2Data[k+1]-ele1Data[k])>0)
                }
                double result = score/length;
//                map.put(ele1+" ~ "+ele2,ExcelUtil.df.format(result*100)+"%");
                double re = model.getThreshold();
                if(result >= model.getThreshold())
                    map.put(ele1+" ~ "+ele2,ExcelUtil.df.format(result*100)+"%");
            }
        }
        return map;
    }
    public static Map<String,String> calculateAllScore(MetalModel model){
        //此处矩阵是已经转置过的矩阵，行是金属，列是样本列
        double[][] data = model.getData();
        String[] elements = model.getElements();
        Map<String,String> map = new HashMap<>();
        for(int i=1;i<data.length-1;i++){
            for(int j=i+1;j<data.length;j++){
                String ele1 = elements[i];
                String ele2 = elements[j];
                double[] ele1Data = data[i];
                double[] ele2Data = data[j];
                int length = ele1Data.length*(ele1Data.length-1)/2;
                double score = 0;
                for(int k=0;k<ele1Data.length-1;k++){
                    for(int l=k+1;l<ele1Data.length;l++){
                        double ele11 = ele1Data[k]-ele1Data[l];
                        double ele22 = ele2Data[k]-ele2Data[l];
                        if(ele11/ele22>0)
                            score++;
                    }
//                  if((ele1Data[k+1]-ele1Data[k])/(ele2Data[k+1]-ele1Data[k])>0)
                }
                double result = score/length;
                map.put(ele1+" ~ "+ele2,ExcelUtil.df.format(result*100)+"%");
            }

        }
        return map;
    }


    public static Object[][] calculateAllScoreMatrix(MetalModel model){
        //此处矩阵是已经转置过的矩阵，行是金属，列是样本列
        double[][] data = model.getData();
        Object[][] resultMartix = new Object[data.length][data.length];
        String[] elements = model.getElements();
        resultMartix[0][0] = EncodingHelper.gbk2utf_8( "相关系数");
        //矩阵中第一列与第一行进行元素名赋值，例如Cu Cr等等
        for(int i=1;i<data.length;i++){
            resultMartix[0][i] = elements[i];
            resultMartix[i][0] = elements[i];
        }

        for(int i=1;i<data.length-1;i++){
            for(int j=i+1;j<data.length;j++){
                double[] ele1Data = data[i];
                double[] ele2Data = data[j];
                int length = ele1Data.length*(ele1Data.length-1)/2;
                double score = 0;
                for(int k=0;k<ele1Data.length-1;k++){
                    for(int l=k+1;l<ele1Data.length;l++){
                        double ele11 = ele1Data[k]-ele1Data[l];
                        double ele22 = ele2Data[k]-ele2Data[l];
                        if(ele11/ele22>0)
                            score++;
                    }
//                  if((ele1Data[k+1]-ele1Data[k])/(ele2Data[k+1]-ele1Data[k])>0)
                }
                double result = score/length;
                resultMartix[i][j] = result;

            }
            resultMartix[i][i] = "/";
        }
        resultMartix[8][8] = "/";
        return resultMartix;
    }




    public static double[][] calculateScore2Matrix(MetalModel model){
        double[][] data = model.getData();

        String[] elements = model.getElements();
        double[][] result = new double[data.length-1][data.length-1];
        for(int i=1;i<data.length-1;i++){
            for(int j=i+1;j<data.length;j++){
                String ele1 = elements[i];
                String ele2 = elements[j];
                double[] ele1Data = data[i];
                double[] ele2Data = data[j];
                int length = ele1Data.length*(ele1Data.length-1)/2;
                double score = 0;
                for(int k=0;k<ele1Data.length-1;k++){
                    for(int l=k+1;l<ele1Data.length;l++){
                        double ele11 = ele1Data[k]-ele1Data[l];
                        double ele22 = ele2Data[k]-ele2Data[l];
                        if(ele11/ele22>0)
                            score++;
                    }
//                  if((ele1Data[k+1]-ele1Data[k])/(ele2Data[k+1]-ele1Data[k])>0)
                }
                result[i-1][j-1] = (double) Math.round(score/length * 100) / 100;
            }
        }

        //对称矩阵补全，对象线补1，其他位置镜像填充
        for(int i=0;i<data.length-1;i++){
            for(int j=0;j<=i;j++){
                if(j==i)
                    result[i][j] = 1;
                else{
                    result[i][j] = result[j][i];
                }

            }
        }
        return result;
    }
    public static List<PollutionAnalysis> levelPluSort(List<PollutionAnalysis> list){
        Collections.sort(list, new Comparator<PollutionAnalysis>() {
            @Override
            public int compare(PollutionAnalysis o1, PollutionAnalysis o2) {
                if(o1.getMain()>o2.getMain())
                    return -1;
                else if (o1.getMain()<o2.getMain())
                    return 1;
                else{
                    if(o1.getMainSimilar()>o2.getMainSimilar())
                        return -1;
                    else if(o1.getMainSimilar()<o2.getMainSimilar())
                        return 1;
                    else{
                        if(o1.getNotMain()>o2.getNotMain())
                            return -1;
                        else if(o1.getNotMain()<o2.getNotMain())
                            return 1;
                        else {
                            if(o1.getNotMainSimilar()>o2.getNotMainSimilar())
                                return -1;
                            else
                                return 1;
                        }
                    }
                }
            }
        });
        return list;
    }

}
