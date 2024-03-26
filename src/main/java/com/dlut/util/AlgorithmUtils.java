package com.dlut.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlgorithmUtils {
    public static double[][] factor_1_1;    //存放判断因素真实数值
    public static String[] factorName_1_1;  //存放判断因素的名称
    public static boolean[] factorDo_1_1;   //表示是用大于号一直往下判断还是用小于号一直往下判断
    public static String[] judgeName1_1;    //权重计算对应的金属名称
    public static double[][] judge_1_1;     //权重计算的权重数值
    public static double[][] score_1_1;     //各金属元素分数评级表
    public static void init1_1(){
        try {
            BufferedReader readerFactor = new BufferedReader(new FileReader(ExcelUtil.class.getResource("").getPath()+"/factor1_1.txt"));
            BufferedReader readerJudge = new BufferedReader(new FileReader(ExcelUtil.class.getResource("").getPath()+"/judge1_1.txt"));
            BufferedReader readerScore = new BufferedReader(new FileReader(ExcelUtil.class.getResource("").getPath()+"/score1_1.txt"));

            //factor1_1  factorDo1_1  factorName1_1初始化
            List<String> list = new ArrayList<>();
            String line = readerFactor.readLine();
            while(!line.trim().equals("")){
                list.add(line);
                line = readerFactor.readLine();
            }
            factorName_1_1 = new String[list.size()];
            factor_1_1 = new double[list.size()][3];
            factorDo_1_1 = new boolean[list.size()];
            String str = null;
            for(int i=0;i<list.size();i++){
                str = list.get(i);
                String[] strs = str.split("\\s+");
                factorName_1_1[i] = strs[0];
                if("+".equals(strs[1]))
                    factorDo_1_1[i] = true;
                else
                    factorDo_1_1[i] = false;

                for(int j=2;j<strs.length;j++){
                    factor_1_1[i][j-2] = Double.parseDouble(strs[j]);
                }
            }

            //judgeName1_1  judge1_1初始化
            list = new ArrayList<>();
            line = readerJudge.readLine();//第一行不计
            line = readerJudge.readLine();
            while(!line.trim().equals("")){
                list.add(line);
                line = readerJudge.readLine();
            }
            judgeName1_1 = new String[list.size()];
            judge_1_1 = new double[list.size()][factor_1_1.length];
            str = null;
            for(int i=0;i<list.size();i++){
                str = list.get(i);
                String[] strs = str.split("\\s+");
                judgeName1_1[i] = strs[0];
                for(int j=1;j<strs.length;j++){
                    judge_1_1[i][j-1] = Double.parseDouble(strs[j]);
                }
            }

            //score1_1初始化
            list = new ArrayList<>();
            line = readerScore.readLine();//第一行不计
            line = readerScore.readLine();
            while(!line.trim().equals("")){
                list.add(line);
                line = readerScore.readLine();
            }
            score_1_1 = new double[list.size()][3]; //四个等级，三个分界
            str = null;
            for(int i=0;i<list.size();i++){
                str = list.get(i);
                String[] strs = str.split("\\s+");
                for(int j=1;j<strs.length;j++){
                    score_1_1[i][j-1] = Double.parseDouble(strs[j]);
                }
            }
            readerFactor.close();
            readerJudge.close();
            readerScore.close();
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("文件数据格式不正确");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static double[][] al1_1(double[][] data){
    /**
     *  1.得到原始数据，通过factor得到分数
     *  2.通过judge对分数进行综合得到每个点上的5中金属各自得分
     */
        double originScore[][] = new double[data.length][data[0].length];
        //判断每一个位置的分值
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[0].length;j++){
                originScore[i][j] = getSingleScore(data[i][j],factorDo_1_1[j],factor_1_1[j]);
            }
        }

        //判断每一条样本的五种金属的分数
        double score[][] = new double[data.length][judgeName1_1.length];
        for(int i=0;i<data.length;i++){
            score[i] = getPerLineScore(originScore[i]);
        }
        return score;
    }

    public static double getSingleScore(double data,boolean flag,double[] factor){
        if(flag){
            if(data>factor[0])
                return 100;
            else if(data>factor[1])
                return 80;
            else if(data>factor[2])
                return 60;
            else
                return 40;

        } else {
            if(data<factor[0])
                return 100;
            else if(data<factor[1])
                return 80;
            else if(data<factor[2])
                return 60;
            else
                return 40;
        }
    }

    public static double[] getPerLineScore(double[] data){
        double[] score = new double[judgeName1_1.length];
        double curr;
        for(int i=0;i<judgeName1_1.length;i++){
            curr = 0.0;
            for(int j=0;j<data.length;j++){
                curr += data[j] * judge_1_1[i][j];
            }
            score[i] = curr;
        }
        return score;
    }

    public static List<Map<String,Object>> data2FormatTeamAl1_1(double[][] data, String[] elements){
        List<Map<String,Object>> result = new ArrayList<>();
        //第一列为pH，不做记录
        for(int i=0;i<data[0].length;i++){
            Map<String,Object> map = new HashMap<>();
            String name = elements[i];
            map.put("name",name);
            map.put("score",score_1_1[i]);
            Object[][] pair = new Object[data.length][2];
            for(int j=0;j<data.length;j++){
                double curr = data[j][i];
                pair[j][0] = j+1;
                pair[j][1] = curr;
            }
            map.put("data",pair);
            result.add(map);
        }
        return result;
    }
    public static double[] al2_1(double temperature,double ozone,double Hg){
        double[] result = new double[4];
        result[0] = al2_1Spring(temperature,ozone,Hg);
        result[1] = al2_1Summer(temperature,ozone,Hg);
        result[2] = al2_1Autumn(temperature,ozone,Hg);
        result[3] = al2_1Winter(temperature,ozone,Hg);
        return result;
    }
    public static double al2_1Spring(double temperature,double ozone,double Hg){

        return 17.38*temperature - 0.95*ozone - 0.76*Hg - 1.09*Math.pow(temperature,2) - 0.01*Math.pow(ozone,2) - 1.5*Math.pow(Hg,2) + 0.18*temperature*ozone + 2.03*temperature*Hg - 0.1*ozone*Hg - 79.05;
    }
    public static double al2_1Summer(double temperature,double ozone,double Hg){
        return  -18*temperature + 1.03*ozone + 16.9*Hg + 0.75*Math.pow(temperature,2) + 0.002*Math.pow(ozone,2) + 0.39*Math.pow(Hg,2) - 0.1*temperature*ozone - 1.04*temperature*Hg + 0.12*ozone*Hg + 164.6;
    }
    public static double al2_1Autumn(double temperature,double ozone,double Hg){
        return -44.79*temperature + 2.55*ozone + 25.08*Hg + 1.15*Math.pow(temperature,2) - 0.002*Math.pow(ozone,2) + 0.02*Math.pow(Hg,2) - 0.06*temperature*ozone - 0.78*temperature*Hg - 0.02*ozone*Hg + 403;
    }
    public static double al2_1Winter(double temperature,double ozone,double Hg){
        return 31.08*temperature + 1.17*ozone - 10.46*Hg + 1.55*Math.pow(temperature,2) + 0.01*Math.pow(ozone,2) + 4.66*Math.pow(Hg,2) - 0.37*temperature*ozone - 1.89*temperature*Hg - 0.26*ozone+Hg - 38.78;
    }

}
