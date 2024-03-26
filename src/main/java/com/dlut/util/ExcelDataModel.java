package com.dlut.util;

import java.io.PrintStream;
import java.util.*;

public class ExcelDataModel {
    private double[][] data;
    private double[] U;//上四分之一点
    private double[] L;//下四分之一点
    private double[] IQR; // 四分位差
    private double[] Mid; //中位数
    private String[] elements; //每一列的名称

    private List<Point> errorPoints = new ArrayList<>();
    public class Point{
        protected int x;
        protected int y;
        protected String msg;
        protected boolean isGreat;
        public Point(int x,int y,String msg,boolean isGreat){
            this.x = x;
            this.y = y;
            this.msg = msg;
            this.isGreat = isGreat;
        }
        String getErrorInfo(){
            double value = isGreat?U[y]:L[y];
            return "x : "+ (x+2)+" , y : "+y+" , Error msg : "+msg+",will be fixed to "+value;
        }
    }

    public ExcelDataModel(double[][] data,String[] elements) {
        this.elements = elements;
        this.data = data;
        double[] U = new double[data[0].length];
        double[] L = new double[data[0].length];
        double[] IQR = new double[data[0].length];
        double[] Mid = new double[data[0].length];

        for(int i=0;i<data[0].length;i++){
            double[] arr = new double[data.length];
            for(int j=0;j<data.length;j++){
                arr[j] = data[j][i];

            }
            Arrays.sort(arr);
            Mid[i] = arr[arr.length/3];
            U[i] = arr[5*(arr.length/6)];
            L[i] = arr[arr.length/6];
            IQR[i] = U[i] - L[i];
        }
        this.U = U;
        this.L = L;
        this.IQR = IQR;
        this.Mid = Mid;
    }

    public ExcelDataModel(double[][] data) {
        this.data = data;
        double[] U = new double[data[0].length];
        double[] L = new double[data[0].length];
        double[] IQR = new double[data[0].length];
        double[] Mid = new double[data[0].length];

        for(int i=0;i<data[0].length;i++){
            double[] arr = new double[data.length];
            for(int j=0;j<data.length;j++){
                arr[j] = data[j][i];

            }
            Arrays.sort(arr);
            Mid[i] = arr[arr.length/3];
            U[i] = arr[5*(arr.length/6)];
            L[i] = arr[arr.length/6];
            IQR[i] = U[i] - L[i];
        }
        this.U = U;
        this.L = L;
        this.IQR = IQR;
        this.Mid = Mid;



    }

    public double[][] getData() {
        return data;
    }

    public void setData(double[][] data) {
        this.data = data;
    }

    public double[] getU() {
        return U;
    }

    public void setU(double[] u) {
        U = u;
    }

    public double[] getL() {
        return L;
    }

    public void setL(double[] l) {
        L = l;
    }

    public double[] getIQR() {
        return IQR;
    }

    public void setIQR(double[] IQR) {
        this.IQR = IQR;
    }

    public List<Point> getErrorPoints() {
        Collections.sort(errorPoints, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x>o2.x)
                    return 1;
                else if(o2.x>o1.x)
                    return -1;
                else{
                    if(o1.y>o2.y){
                        return 1;
                    }
                    else
                        return -1;
                }
            }
        });
        return errorPoints;
    }

    protected void addErrorPoint(int x,int y,String msg,boolean isGreat) {
        errorPoints.add(new Point(x,y,msg,isGreat));
    }




    /**
     * 请在修复异常点后再重新调用
     *  clear.Error.PointList()
     *  Excel.findErrorPoints()
     *
     *
     * @param x 异常点横坐标
     * @param y 异常点纵坐标
     * @param newValue  需要填入的新值
     * @return  修复是否成功
     */
    public boolean fixTheErrorPoint(int x,int y,double newValue){
        data[x][y] = newValue;
        return true;
    }

    public boolean fixAllErrorPoint(){
        List<Point> list = this.getErrorPoints();
        for(Point point : list){
           if(point.isGreat){
               data[point.x][point.y] = U[point.y] + 1.5*IQR[point.y];
           }
           else{
               data[point.x][point.y] = U[point.y] - 1.5*IQR[point.y];
           }
        }
        clearErrorPointList();
        findErrorPoints(this);
        return true;
    }
    public void clearErrorPointList(){
        errorPoints.clear();
    }



    /**
     * 箱型图找异常点，上界为 U+1.5IQR ，下界为： L - 1.5IQR
     */
    public static boolean findErrorPoints(ExcelDataModel model){
        try{
            double[][] data = model.getData();
            double[] U = model.getU();
            double[] L = model.getL();
            double[] IQR = model.getIQR();
            for(int i=0;i<data[i].length;i++){
                double up = U[i] + 1.5 * IQR[i];
                double down = L[i] - 1.5 * IQR[i];
                for(int j=0;j<data.length;j++){
                    if(data[j][i] < down)
                        model.addErrorPoint(j,i,"less",false);
                    else if(data[j][i] > up)
                        model.addErrorPoint(j,i,"great",true);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void printErrorInfo(PrintStream out){
        if(this.getErrorPoints().size() == 0)
            out.println("无异常点");
        else{
            for(ExcelDataModel.Point point : this.getErrorPoints()){
                out.println(point.getErrorInfo());
            }
        }
    }

    public String getErrorInfo(){
        if(this.getErrorPoints().size() == 0)
            return "无异常点";
        else{
            StringBuilder sb = new StringBuilder();
            for(ExcelDataModel.Point point : this.getErrorPoints()){
                sb.append(point.getErrorInfo());
            }
            return sb.toString();
        }
    }
    public String getErrorInfoFormat(){
        if(this.getErrorPoints().size() == 0)
            return "无异常点";
        else{
            StringBuilder sb = new StringBuilder();
            for(ExcelDataModel.Point point : this.getErrorPoints()){
                sb.append(point.getErrorInfo()+"\r\n");
            }
            return sb.toString();
        }
    }

    public double[] getMid() {
        return Mid;
    }

    public void setMid(double[] mid) {
        Mid = mid;
    }

    public String[] getElements() {
        return elements;
    }

    public void setElements(String[] elements) {
        this.elements = elements;
    }

}
