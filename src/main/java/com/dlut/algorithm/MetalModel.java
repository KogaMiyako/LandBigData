package com.dlut.algorithm;

import com.dlut.util.HeavyMetalConstant;

import java.util.HashMap;
import java.util.Map;

public class MetalModel{
private Map<String,double[]> table = new HashMap<>(16);
private String[] elements = null;
private double[][] data = null;
private double threshold = HeavyMetalConstant.MetalModelThreshold;    //得分总数的总体阈值

public MetalModel(String[] elements, double[][] data) {
        this.elements = elements;
        this.data = data;
        }

public MetalModel(String[] elements, double[][] data, double threshold) {
        this.elements = elements;
        this.data = data;
        this.threshold = threshold;
        }

public void addMetalData(String name, double[] data){
        table.put(name,data);
        }
public double[] getMetalData(String name){
        return table.get(name);
        }
public boolean removeMetalData(String name){
        if(table.remove(name) != null)
        return true;
        else
        return false;

        }
public void setThreshold(double num){
        if(num<0.5)
        this.threshold = 0.85;
        else
        this.threshold = num;
        }

public String[] getElements() {
        return elements;
        }

public void setElements(String[] elements) {
        this.elements = elements;
        }

public double[][] getData() {
        return data;
        }

public void setData(double[][] data) {
        this.data = data;
        }

public double getThreshold() {
        return threshold;
        }
}