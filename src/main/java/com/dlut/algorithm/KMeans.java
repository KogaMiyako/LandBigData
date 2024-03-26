package com.dlut.algorithm;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

public class KMeans {

    public int k;
    public int dim;
    public double shold;
    public ArrayList<double[]> centers;

    public KMeans(int k, int dim, double shold) {
        this.k = k;
        this.dim = dim;
        this.shold = shold;
        this.centers = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        /*double[] v1 = {1.1, 1.1, 1.1};
        double[] v2 = {1.2, 1.2, 1.2};
        double[] v3 = {1.3, 1.3, 1.3};
        double[] v4 = {4.1, 4.1, 4.1};
        double[] v5 = {4.2, 4.2, 4.2};
        double[] v6 = {4.3, 4.3, 4.3};

        ArrayList<double[]> points = new ArrayList<>();
        points.add(v1);
        points.add(v2);
        points.add(v3);
        points.add(v4);
        points.add(v5);
        points.add(v6);*/
        ArrayList<double[]> points = new ArrayList<>();

        KMeans kMeans = new KMeans(3, 3, 0.0000000001);
        points = kMeans.runKMeans("D:\\kmeans_data.txt");
        kMeans.initialCenters2(points);
        kMeans.kmeans(points);
        kMeans.printResult(points);

        // test closest
        /*double[] res = kMeans.closestCenter(v1);
        System.out.println("closest centser");
        System.out.println(res[0]);*/



    }

    public ArrayList<double[]> runKMeans(String path) throws IOException{
        File file = new File(path); //""

        if (file.isFile() && file.exists()){
            InputStreamReader reader = new InputStreamReader(Files.newInputStream(file.toPath()));
            BufferedReader bufferedReader = new BufferedReader(reader);
            String lineText = null;

            ArrayList<double[]> points = new ArrayList<>();

            while ((lineText = bufferedReader.readLine())!=null){
                double[] point = new double[dim];
//                System.out.println(lineText);
                String[] elems = lineText.split(" ");
                for (int i = 0; i<dim;i++){
                    String item = elems[i];
                    point[i] = Double.parseDouble(item);
                }
                points.add(point);
            }

//            System.out.println(points.size());

            return points;
        }
        return null;
    }

    // 初始化聚类中心
    public void initialCenters(ArrayList<double[]> points){
        int pointsNum = points.size();
        // random n
        Random random = new Random();
        int randn = random.nextInt(pointsNum);
        int[] centerIndex = new int[k];
        int pace = pointsNum / k;

        // 获得center下标
        for (int i = 0; i < k; i++){
            centerIndex[i] = (randn + i * pace) % pointsNum;
        }
        // 初始化中心
        for (int i : centerIndex) {
            centers.add(points.get(i));
        }
        // test
        /*System.out.println("centers:");
        for (double[] v: centers){
            System.out.println(v[0]);
        }*/
    }

    public void initialCenters2(ArrayList<double[]> points){
        int pointsNum = points.size();
        // random n
        Random random = new Random();
        int randn = random.nextInt(pointsNum);
        ArrayList<Integer> centerIndex = new ArrayList<>();
        centerIndex.add(randn);

        // 获得center下标 找k个点
        for (int i = 0; i < k - 1; i++){
            double maxDis = 0.0;
            int maxIndex = -1;
            // 遍历所有点
            for (int j = 0; j<pointsNum;j++){
                double dis = 0.0;
                // 遍历已选择的点
                for (int index : centerIndex){
                    dis += vectorDis(points.get(index), points.get(j));
                }
                if (dis > maxDis){
                    maxDis = dis;
                    maxIndex = j;
                }
            }
            // 找到最大的点 命名中心
            centerIndex.add(maxIndex);
        }
        // 初始化中心
        for (int i : centerIndex) {
            centers.add(points.get(i));
        }

        System.out.println("centers:");
        for (double[] v: centers){
            System.out.println(v[0]);
        }
    }

    //---------------------------迭代做聚类-------------------------------------
    public void kmeans(ArrayList<double[]> points){
        double currentCost = 0.0;
        double newCost = 0.0;
        ArrayList<double[]> newCenters = new ArrayList<>();

        double[][] newCenter = new double[k][dim];
        int[] newCenterCount = new int[k];


        while (true){
            System.out.println("start");
            for (int i=0;i<k;i++){
                for (int j = 0; j < dim; j ++){
                    newCenter[i][j] = 0.0;
                }
            }
            for (int i = 0; i < k; i++) {
                newCenterCount[i] = 0;
            }

            // 计算当前损失
            currentCost = computeCost(points);
            // 遍历所有点 找到点的中心点 所有一类的点坐标加起来
            for (double[] point: points){
                int centerIndex = closestCenter(point);
                for (int i = 0; i<dim;i++){
                    newCenter[centerIndex][i] += point[i];
                }
                newCenterCount[centerIndex] += 1;
            }
            // 计算新中心点
            for (int i=0;i<k;i++){
                double[] currCenter = centers.get(i);
                for (int j = 0; j < dim; j ++){
                    newCenter[i][j] = newCenter[i][j] / ((double)newCenterCount[i]);
                    currCenter[j] = newCenter[i][j];
                }

                centers.set(i, currCenter);
            }

            newCost = computeCost(points);

            // 判断迭代结束
            if (currentCost - newCost < shold){
                System.out.println("end");
                for (double[] center : centers){
                    System.out.println(center[0]);
                }
                break;
            }
        }
    }

    //--------------------------输出聚类结果-----------------------------
    public void printResult(ArrayList<double[]> points){
        for (double[] point: points){
            int centerIndex = closestCenter(point);
            for (int i = 0; i<dim; i++){
                System.out.printf(" %.1f ", point[i]);
            }
            System.out.printf(" center:%d \n", centerIndex);
        }
    }

    //--------------------------返回聚类结果（中心）-----------------------------
    public ArrayList<double[]> centerResult(){
        /*StringBuffer str = new StringBuffer();

        int count = 0;
        for (double[] center : centers){
            count++;
            System.out.println(center[0]);
            str.append("center: ");
            str.append(count);
            str.append("\n");
            for (int i=0; i<dim;i++){
                str.append(center[i]);
            }
        }

        System.out.println(str);

        return str;*/
        return centers;
    }

    //--------------------------计算代价函数-----------------------------
    public double computeCost(ArrayList<double[]> points){
        if (centers == null){
            System.out.println("no centers");
            return -1.0;
        }
        double dis = 0.0;
        for (double[] point: points){
            int centerIndex = closestCenter(point);
            double[] center = centers.get(centerIndex);
            dis += vectorDis(center, point);
        }
        return dis;
    }

    //--------------------------找到某样本点所属的聚类中心-----------------------------
    public int closestCenter(double[] v){
        double[] closestCenter = centers.get(0);
        int index = 0;
        double minDis = vectorDis(closestCenter, v);

        for (int i = 0 ; i < centers.size(); i++){
            double[] center = centers.get(i);
            double currDis = vectorDis(center, v);
            if (currDis < minDis){
                minDis = currDis;
                closestCenter = center;
                index = i;
            }
        }

        return index;
    }

    //--------------------------自定义向量间的运算-----------------------------
    //--------------------------向量间的欧式距离-----------------------------
    public double vectorDis(double[] v1, double[] v2){
        double distance = 0.0d;
        for (int i = 0; i < dim; i++) {
            distance += (v1[i] - v2[i]) * (v1[i] - v2[i]);
        }
        distance = Math.sqrt(distance);
        return distance;
    }

    //--------------------------向量加法-----------------------------
    public double[] vectorAdd(double[] v1, double[] v2){
        for (int i = 0; i < dim; i++) {
            v1[i] += v2[i];
        }
        return v1;
    }

    //--------------------------向量除法-----------------------------
    public double[] vectorDivide(double[] v, int num){
        for (int i = 0; i < dim; i++) {
            v[i] = v[i] / num;
        }
        return v;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

    public double getShold() {
        return shold;
    }

    public void setShold(double shold) {
        this.shold = shold;
    }

    public ArrayList<double[]> getCenters() {
        return centers;
    }

    public void setCenters(ArrayList<double[]> centers) {
        this.centers = centers;
    }
}
