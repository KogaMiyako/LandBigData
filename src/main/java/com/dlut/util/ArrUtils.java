package com.dlut.util;

/**
 * Created by febiven on 2019/5/3
 **/
public class ArrUtils {
    public static void fillArrayByOriginValueIfBlank(Object[][] origin,Object[][] des){
        if(origin.length < des.length || origin[0].length < des[0].length){
            throw new ArrayIndexOutOfBoundsException("原始矩阵长宽小于目标矩阵");
        }
        for(int i=0;i<des.length;i++){
            for(int j=0;j<des[0].length;j++){
                Object des1 = des[i][j];
                if(des1 == null)
                    des[i][j] = origin[i][j];
            }
        }
    }
    public static double[][] getSubArr(double[][] data,int row,int cloumn){
        double[][] result = new double[row][cloumn];
        for(int i=0;i<row;i++){
            for(int j=0;j<cloumn;j++){
                result[i][j] = data[i][j];
            }
        }
        return result;
    }

    /**
     *
     *
     * @param data
     * @param beginRow
     * @param endRow
     * @param beginCloumn
     * @param endCloumn
     *
     * @return
     */
    public static double[][] getSubArr(double[][] data,int beginRow,int endRow,int beginCloumn,int endCloumn){
        if(beginRow>endRow || beginCloumn>endCloumn)
            return null;
        double[][] result = new double[endRow-beginRow][endCloumn-beginCloumn];
        for(int i=beginRow;i<endRow;i++){
            for(int j=beginCloumn;j<endCloumn;j++){
                result[i][j-beginCloumn] = data[i][j];
            }
        }
        return result;
    }
    public static Object[][] reserveArrByCloumn(Object[][] data){
        for(int i=1;i<data[0].length/2;i++){
            for(int j=0;j<data.length;j++){
                Object temp = data[j][i];
                data[j][i] = data[j][data[0].length-i];
                data[j][data[0].length-i] = temp;
            }
        }
        return data;
    }
    public static int getPrecisionResult(int pow){
        int ori=1;
        for(int i=0;i<pow;i++){
            ori *= 10;
        }
        return ori;
    }
}
