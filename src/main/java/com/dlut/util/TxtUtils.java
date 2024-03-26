package com.dlut.util;

import com.dlut.pojo.GeoPoint;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by febiven on 2019/5/3
 **/
public class TxtUtils {
    public static String[][] readTxtToArr(String filename){
        String[][] result = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            List<String[]> list = new ArrayList<>();
            String line = br.readLine();
            String[] datas = line.split(",");
            list.add(datas);
            line = br.readLine();
            while(line != null){
                list.add(line.split(","));
                line = br.readLine();
            }
            String[][] a =new String[1][2];
            result = list.toArray(a);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

//    public static void main(String[] args) {
//        String[][] s = readTxtToArr("D:/wuqing.txt");
//        List<GeoPoint> list = new ArrayList<>();
//        for(int i=1;i<s.length;i++){
//            double longitude = Double.parseDouble(s[i][5]);
//            double latitude = Double.parseDouble(s[i][6]);
//            String[] areas = new String[4];
//            areas[0] = s[i][8];
//            areas[1] = s[i][9];
//            areas[2] = s[i][10];
//            areas[3] = s[i][11];
//            double[] metalArr = new double[8];
//            //  Cr  Ni  Cu  Zn  As  Cd  Hg  Pb
//            metalArr[0] = Double.parseDouble(s[i][35]);
//            metalArr[1] = Double.parseDouble(s[i][37]);
//            metalArr[2] = Double.parseDouble(s[i][32]);
//            metalArr[3] = Double.parseDouble(s[i][33]);
//            metalArr[4] = Double.parseDouble(s[i][39]);
//            metalArr[5] = Double.parseDouble(s[i][36]);
//            metalArr[6] = Double.parseDouble(s[i][38]);
//            metalArr[7] = Double.parseDouble(s[i][34]);
//            list.add(new GeoPoint(longitude,latitude,metalArr,areas));
//        }
//        Object arr[][] = new Object[list.size()][15];
//        for(int i=0;i<list.size();i++){
//            GeoPoint point = list.get(i);
//            arr[i][0] = 6.68;
//            arr[i][1] = point.getCr();
//            arr[i][2] = point.getNi();
//            arr[i][3] = point.getCu();
//            arr[i][4] = point.getZn();
//            arr[i][5] = point.getAs();
//            arr[i][6] = point.getCd();
//            arr[i][7] = point.getHg();
//            arr[i][8] = point.getPb();
//            arr[i][9] = point.getLongitude();
//            arr[i][10] = point.getLatitude();
//            arr[i][11] = point.getAreaRank1();
//            arr[i][12] = point.getAreaRank2();
//            arr[i][13] = point.getAreaRank3();
//            arr[i][14] = point.getAreaRank4();
//        }
//        try {
//            ExcelUtil.exportArrayToXlsx(arr,"D:/wuqing.xlsx",new String[]{"pH","Cr","Ni","Cu","Zn","As","Cd","Hg","Pb","longitude","latitude","省市","区县","乡镇","村"});
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
