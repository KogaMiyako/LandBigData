package com.dlut.algorithm;

import Jama.Matrix;
import com.dlut.util.ExcelUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

/**
 * Created by febiven on 2019/5/5
 **/
public class PCA {
    private static final double NUM = 0.99999D;
    public double[] eigenvaluesPercent; //各个特征值的百分比
    public double[] eigenvalues;        //各个特征值
    public Object[][] formatResult;     //最后的格式化数组结果
    DecimalFormat df = new DecimalFormat("0.0000 ");
    private FileWriter writer = null;

    public PCA(String filePath) {
        try {
            this.writer = new FileWriter(filePath);
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }

    public void PrintArray(double[][] array) {
        int row = array.length;
        int column = array[0].length;
        System.out.println("数组大小：" + row + "*" + column);

        try {
            for(int i = 0; i < row; ++i) {
                for(int j = 0; j < column; ++j) {
                    System.out.printf(array[i][j] + "\t\t");
                    this.writer.write(array[i][j] + "\t\t");
                }

                System.out.println();
                this.writer.write("\r\n");
            }
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }

    private void ShowVariance(double[][] array) {
        int row = array.length;
        int column = array[1].length;
        double[] average = new double[column];
        double[] variance = new double[column];

        int j;
        double temp;
        int i;
        for(j = 0; j < column; ++j) {
            temp = 0.0D;

            for(i = 0; i < row; ++i) {
                temp += array[i][j];
            }

            average[j] = temp / (double)row;
        }

        for(j = 0; j < column; ++j) {
            temp = 0.0D;

            for(i = 0; i < row; ++i) {
                temp += Math.pow(array[i][j] - average[j], 2.0D);
            }

            variance[j] = temp / (double)(row - 1);
        }

        double[] var13 = variance;
        int var14 = variance.length;

        for(int var8 = 0; var8 < var14; ++var8) {
            double x = var13[var8];
            System.out.println(x);

            try {
                this.writer.write(x + "\r\n");
            } catch (IOException var12) {
                var12.printStackTrace();
            }
        }

    }

    private double[][] HandleArray(double[][] array) {
        int row = array.length;
        int column = array[1].length;
        double[] temp = new double[column];
        double[] average = new double[column];
        double[][] handledArray = new double[row][column];

        int i;
        int j;
        for(i = 0; i < column; ++i) {
            for(j = 0; j < row; ++j) {
                temp[i] += array[j][i];
            }

            average[i] = temp[i] / (double)row;
        }

        for(i = 0; i < column; ++i) {
            for(j = 0; j < row; ++j) {
                handledArray[j][i] = Double.parseDouble(this.df.format(array[j][i] - average[i]));
            }
        }

        return handledArray;
    }

    private double[][] Covariance(double[][] array) {
        int row = array.length;
        int column = array[1].length;
        double[][] handledArray = new double[column][column];

        for(int i = 0; i < column; ++i) {
            for(int j = 0; j < column; ++j) {
                double temp = 0.0D;

                for(int k = 0; k < row; ++k) {
                    temp += array[k][i] * array[k][j];
                }

                handledArray[i][j] = temp / (double)(row - 1);
            }
        }

        return handledArray;
    }

    private Matrix Eigenvalue(double[][] array) {
        Matrix A = new Matrix(array);
        return A.eig().getD();
    }

    private Matrix Eigenvector(double[][] array) {
        Matrix A = new Matrix(array);
        return A.eig().getV();
    }

    private Matrix MainComponent(double[][] eigenvalue, Matrix eigenvectorMatrix) {
        double[][] TEigenVectors = eigenvectorMatrix.transpose().getArray();
        double[] eigenvalueArray = new double[eigenvalue.length];
        int arrayLength = TEigenVectors.length - 1;
        int MainComponentnums = 0;
        double sum = 0.0D;
        double temp = 0.0D;

        int i;
        for(i = 0; i < eigenvalue.length; ++i) {
            eigenvalueArray[i] = eigenvalue[i][i];
        }
        this.eigenvalues = eigenvalueArray;
        for(i = 0; i < eigenvalue.length; ++i) {
            sum += eigenvalueArray[i];
        }

        System.out.println("特征值之和:" + sum);
        eigenvaluesPercent = new double[eigenvalueArray.length];
        for(i = eigenvalueArray.length - 1; i > 0; --i) {
            if (temp / sum <= 0.99999D) {
                System.out.println("每个主成分所占比例" + eigenvalueArray[i] / sum);
                eigenvaluesPercent[i] = eigenvalueArray[i] / sum;
                temp += eigenvalueArray[i];
                ++MainComponentnums;
            }
        }

        System.out.println("主成分个数：" + MainComponentnums);
        double[][] mainComponentArray = new double[MainComponentnums][];

        for(i = 0; i < MainComponentnums; ++i) {
            mainComponentArray[i] = TEigenVectors[arrayLength];
            --arrayLength;
            System.out.println(i);
        }

        Matrix mainComponentMatrix = new Matrix(mainComponentArray);
        return mainComponentMatrix;
    }

    private Matrix ReturnResult(double[][] handledArray, Matrix matrix) {
        Matrix primaryMatrix = new Matrix(handledArray);
        return primaryMatrix.times(matrix.transpose());
    }

    public void PCAMethod(double[][] array) throws IOException {
        this.allPrint("--------------------------------------------\r\n");
        this.allPrint("原始数据: \r\n");
        this.PrintArray(array);
        this.allPrint("--------------------------------------------\r\n");
        this.allPrint("方差数据: \r\n");
        this.ShowVariance(array);
        this.allPrint("--------------------------------------------\r\n");
        this.allPrint("去均值处理后的矩阵数据: \r\n");
        double[][] gethandledArray = this.HandleArray(array);
        this.PrintArray(gethandledArray);
        this.allPrint("--------------------------------------------\r\n");
        this.allPrint("协方差矩阵: \r\n");
        double[][] getCovariance = this.Covariance(gethandledArray);
        this.PrintArray(getCovariance);
        this.allPrint("--------------------------------------------\r\n");
        this.allPrint("特征值矩阵: \r\n");
        Matrix getEigenvalueMatrix = this.Eigenvalue(getCovariance);
        getEigenvalueMatrix.getArray();
        getEigenvalueMatrix.print(new PrintWriter(this.writer), 8, 4);
        getEigenvalueMatrix.print(8, 4);
        this.allPrint("--------------------------------------------\r\n");
        this.allPrint("特征向量矩阵: \r\n");
        Matrix getEigenvectorMatrix = this.Eigenvector(getCovariance);
        getEigenvectorMatrix.print(new PrintWriter(this.writer), 8, 4);
        getEigenvectorMatrix.print(8, 4);
        this.allPrint("--------------------------------------------\r\n");
        Matrix getPComponentMatrix = this.MainComponent(getEigenvalueMatrix.getArray(), getEigenvectorMatrix);
        this.allPrint("主成分矩阵: \r\n");
        getPComponentMatrix.print(8, 4);
        getPComponentMatrix.print(new PrintWriter(this.writer), 8, 4);
        this.allPrint("--------------------------------------------\r\n");
        this.allPrint("当前阈值维：0.99999\t");
        this.allPrint("降维后的矩阵: \r\n");
        Matrix resultMatrix = this.ReturnResult(gethandledArray, getPComponentMatrix);
        resultMatrix.print(6, 3);
        resultMatrix.print(new PrintWriter(this.writer), 6, 3);
        String[] names = ExcelUtil.getElementNames();
        this.allPrint("--------------------------------------------\r\n");
        this.allPrint("主成份分析表：\r\n");
        Object[][] formatResultMatrix = getFormatNeededResult(getEigenvalueMatrix.getArray(), getEigenvectorMatrix.getArray(), names);
        formatResult = formatResultMatrix;
        PrintWriter pw = new PrintWriter(this.writer);

        for(int i = 0; i < formatResultMatrix.length; ++i) {
            for(int j = 0; j < formatResultMatrix[0].length; ++j) {
                if (formatResultMatrix[i][j] instanceof Double) {
                    Double.parseDouble(this.df.format(formatResultMatrix[i][j]));
                    System.out.printf("%-10.10s", Double.parseDouble(this.df.format(formatResultMatrix[i][j])));
                    pw.printf("%-10.10s", Double.parseDouble(this.df.format(formatResultMatrix[i][j])));
                } else {
                    System.out.printf("%-10.10s", formatResultMatrix[i][j]);
                    pw.printf("%-10.10s", formatResultMatrix[i][j]);
                }
            }

            this.allPrint("\r\n");
        }

        this.writer.flush();
        this.writer.close();
    }

    public void allPrint(String str) {
        System.out.println(str);

        try {
            this.writer.write(str);
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }

    public static Object[][] getFormatNeededResult(double[][] eigenvalueMatrix, double[][] eigenvectorMatrix, String[] elementNames) {
        int rowSum = eigenvectorMatrix.length + 2;
        int columeSum = eigenvectorMatrix[0].length + 1;
        Object[][] formatResultMatrix = new Object[rowSum][columeSum];
        formatResultMatrix[0][0] = "特征值：";

        int i;
        for(i = 1; i < formatResultMatrix[0].length; ++i) {
            formatResultMatrix[0][i] = eigenvalueMatrix[i - 1][i - 1];
        }

        for(i = 0; i < formatResultMatrix[0].length; ++i) {
            formatResultMatrix[1][i] = " ";
        }

        for(i = 2; i < formatResultMatrix.length; ++i) {
            formatResultMatrix[i][0] = elementNames[i - 2];

            for(int j = 1; j < formatResultMatrix[0].length; ++j) {
                formatResultMatrix[i][j] = eigenvectorMatrix[i - 2][j - 1];
            }
        }

        return formatResultMatrix;
    }
    public void doPCA(String inputFilePath)throws Exception{
        PCAMethod(ExcelUtil.getData(inputFilePath));
    }
    public static void main(String[] args) throws Exception {
        PCA pca = new PCA("D:/testResult.txt");
        pca.PCAMethod(ExcelUtil.getData("D:/test.xlsx"));
        double[] result = pca.eigenvaluesPercent;
        System.out.println(result);
    }
}
