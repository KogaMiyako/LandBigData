/**
 * Random-Forest implementation with JAVA 
 * @Author EDGIS
 * @Contact guoxianwhu@foxmail.com
 */

package com.dlut.algorithm.RandomForest;

import com.dlut.util.ExcelUtil;

import java.util.ArrayList;

public class MainRun {
    @SuppressWarnings("static-access")
    public static void main(String args[]) throws Exception {

        String trainPath = "D:/RFProject/src/randomForest/Data.txt";
        String testPath = "D:/RFProject/src/randomForest/Test.txt";
        String trainPath1 = "D:/testData/data_1.xlsx";
        String testPath1 = "D:/testData/data_1_test.xlsx";
        int numTrees = 100;

//        DescribeTrees DT = new DescribeTrees(trainPath1);
        ArrayList<int[]> Train = new ArrayList<>();
        double[][] TrainArr = ExcelUtil.getData(trainPath1,4);
        int [][] TrainIntArr = ExcelUtil.convertDoublePrecisionToInt(TrainArr,4);
        for(int[] a : TrainIntArr){
            Train.add(a);
        }

        ArrayList<int[]> Test = new ArrayList<>();
        double[][] TestArr = ExcelUtil.getData(testPath1,4);
        int [][] TestIntArr = ExcelUtil.convertDoublePrecisionToInt(TestArr,4);
        for(int[] a : TestIntArr){
            Test.add(a);
        }

        int categ = 0;

        //the num of labels 找到目标分类值最大的一行样本，将其记在categ中
        int trainLength = Train.get(0).length;
        for(int k=0; k<Train.size(); k++){
            if(Train.get(k)[trainLength-1] < categ)
                continue;
            else{
                categ = Train.get(k)[trainLength-1];
            }
        }

        RandomForest Rf = new RandomForest(numTrees, Train, Test);
        Rf.C = categ;//the num of labels
        Rf.M = Train.get(0).length-1;//the num of Attr
        //属性扰动，每次从M个属性中随机选取Ms个属性，Ms = ln(m)/ln(2)
        Rf.Ms = (int)Math.round(Math.log(Rf.M)/Math.log(2) + 1);//随机选择的属性数量
        Rf.Start();
    }
}
