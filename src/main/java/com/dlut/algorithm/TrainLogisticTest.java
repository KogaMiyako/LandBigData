package com.dlut.algorithm;

import com.dlut.util.ExcelUtil;
import com.dlut.util.PathHelper;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.google.common.io.Resources;
import org.apache.mahout.classifier.AbstractVectorClassifier;
import org.apache.mahout.classifier.sgd.*;
import org.apache.mahout.math.DenseVector;
import org.apache.mahout.math.MahoutTestCase;
import org.apache.mahout.math.Vector;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;

public class TrainLogisticTest extends MahoutTestCase {

  public TrainLogisticTest() {
  }

  public static void main(String[] args) {
    TrainLogisticTest test = new TrainLogisticTest();
//    try {
//      test.example131();
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
    String[] predictors = new String[]{"pH", "T_Ca", "T_Cr", "T_Mn", "T_Ni", "T_Cu", "T_Zn", "T_As", "T_Cd", "T_Pb"};

    try {
      test.example132("/home/liuyu/mahoutdata/data_1.csv","/home/liuyu/mahoutdata/data_1_test.csv","C_Cd",predictors,"20","50","100");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void example131() throws Exception {
    String outputFile = "/home/liuyu/mahoutdata/model";

    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw, true);
    TrainLogistic.mainToOutput(new String[]{
        "--input", "/home/liuyu/mahoutdata/data_1.csv",
        "--output", "/home/liuyu/mahoutdata/model",
        "--target", "C_Cd", "--categories", "2",
        "--predictors", "pH", "T_Ca", "T_Cr", "T_Mn", "T_Ni", "T_Cu", "T_Zn", "T_As", "T_Cd", "T_Pb",
        "--types", "numeric",
        "--features", "20",
        "--passes", "100",
        "--rate", "50"
    },pw);
    String trainOut = sw.toString();
      System.out.println(trainOut);
//    assertTrue(trainOut.contains("x -0.7"));
//    assertTrue(trainOut.contains("y -0.4"));

    LogisticModelParameters lmp = TrainLogistic.getParameters();
//    assertEquals(1.0e-4, lmp.getLambda(), 1.0e-9);
//    assertEquals(20, lmp.getNumFeatures());
//    assertTrue(lmp.useBias());
//    assertEquals("color", lmp.getTargetVariable());
    CsvRecordFactory csv = lmp.getCsvRecordFactory();
//    assertEquals("[1, 2]", new TreeSet<>(csv.getTargetCategories()).toString());
//    assertEquals("[Intercept Term, x, y]", Sets.newTreeSet(csv.getPredictors()).toString());

    // verify model by building dissector
    AbstractVectorClassifier model = TrainLogistic.getModel();

//    List<String> data = Resources.readLines(Resources.getResource("/home/liuyu/mahoutdata/data_1.csv"), Charsets.UTF_8);
//    Map<String, Double> expectedValues = ImmutableMap.of("x", -0.7, "y", -0.43, "Intercept Term", -0.15);
//    verifyModel(lmp, csv, data, model, expectedValues);

    // test saved model
    try (InputStream in = new FileInputStream(new File(outputFile))){
//      LogisticModelParameters lmpOut = LogisticModelParameters.loadFrom(in);
//      CsvRecordFactory csvOut = lmpOut.getCsvRecordFactory();
//      csvOut.firstLine(data.get(0));
//      OnlineLogisticRegression lrOut = lmpOut.createRegression();

//      verifyModel(lmpOut, csvOut, data, lrOut, expectedValues);
    }

    sw = new StringWriter();
    pw = new PrintWriter(sw, true);
    RunLogistic.mainToOutput(new String[]{
        "--input", "/home/liuyu/mahoutdata/data_1_test.csv",
        "--model", "/home/liuyu/mahoutdata/model",
        "--auc",
        "--confusion",
        "--scores"
    },pw);
    trainOut = sw.toString();
    System.out.println(trainOut);
//    assertTrue(trainOut.contains("AUC = 0.57"));
//    assertTrue(trainOut.contains("confusion: [[27.0, 13.0], [0.0, 0.0]]"));
  }


  public void example132(String trainFileName,String testFileName,String target,String[] predictors,String features,String passes,String rate) throws Exception {
//    String modelFile = "/home/liuyu/mahoutdata/model";
    String modelFile = PathHelper.TEMP_PATH+"/model";

    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw, true);
    String[] trainArgs = convertToTrainArgs(trainFileName,modelFile,target,predictors,features,passes,rate);
    TrainLogistic.mainToOutput(trainArgs,pw);
//    TrainLogistic.main(trainArgs);
    String trainOut = sw.toString();
    System.out.println(trainOut);


    String[] runArgs = convertToRunArgs(testFileName,modelFile);
    RunLogistic.mainToOutput(runArgs,pw);
//    RunLogistic.main(runArgs);
    trainOut = sw.toString();
    System.out.println(trainOut);

  }

  /**
   *             "--input", "/home/liuyu/mahoutdata/data_1.csv",
   *             "--output", "/home/liuyu/mahoutdata/model",
   *             "--target", "C_Cd", "--categories", "2",
   *             "--predictors", "pH", "T_Ca", "T_Cr", "T_Mn", "T_Ni", "T_Cu", "T_Zn", "T_As", "T_Cd", "T_Pb",
   *             "--types", "numeric",// 用于预测的向量的类型
   *      *      "--features", "20",  //特征向量的值的大小
   *      *      "--passes", "100",   //对入数据的复核次数
   *      *      "--rate", "50"       //初始学习率，如果数据量很大或者复核次数很高，这个值可以设高一些
   * @param input
   * @param output
   * @param target
   * @param predictors
   * @param features
   * @param passes
   * @param rate
   * @return
   */
  public static String[] convertToTrainArgs(String input,String output,String target,String[] predictors,String features,String passes,String rate){
    List<String> list = new ArrayList<>();
    list.add("--input");
    list.add(input);
    list.add("--output");
    list.add(output);
    list.add("--target");
    list.add(target);
    list.add("--categories");
    list.add("2");


    list.add("--predictors");
    arrAddToList(list,predictors);

    list.add("--types");
    list.add("numeric");
    list.add("--features");
    list.add(features);
    list.add("--passes");
    list.add(passes);
    list.add("--rate");
    list.add(rate);

    String[] strs = new String[1];
    return list.toArray(strs);

  }

  /**
   *             "--input", "/home/liuyu/mahoutdata/data_1_test.csv",
   *             "--model", "/home/liuyu/mahoutdata/model",
   *             "--auc",
   *             "--confusion",
   *             "--scores"
   * @param input
   * @param model
   * @return
   */
  public static String[] convertToRunArgs(String input,String model){
    List<String> list = new ArrayList<>();

    list.add("--input");
    list.add(input);
    list.add("--model");
    list.add(model);
    list.add("--auc");
    list.add("--confusion");
    list.add("--scores");

    String[] strs = new String[1];
    return list.toArray(strs);
  }

  public static <T> void arrAddToList(List<T> list,T[] t){
    for(int i=0;i<t.length;i++){
      list.add(t[i]);
    }
  }

}
