package com.dlut.util;

import java.util.HashMap;
import java.util.Map;

public class HeavyMetalConstant {
    public static int metalType = 8;
    public static int Cr = 0;
    public static int Ni = 1;
    public static int Cu = 2;
    public static int Zn = 3;
    public static int As = 4;
    public static int Cd = 5;
    public static int Hg = 6;
    public static int Pb = 7;
    public static int Cr_poison = 2;        //Hakanson毒素因子
    public static int Ni_poison = 5;
    public static int Cu_poison = 5;
    public static int Zn_poison = 1;
    public static int As_poison = 10;
    public static int Cd_poison = 30;
    public static int Hg_poison = 40;
    public static int Pb_poison = 5;
    public static int[] Metal_poisons = {2,5,5,1,10,30,40,5};
    public static double[][] standards = {{250,40,50,200,40,0.3,0.3,80},{300,50,100,250,30,0.3,0.5,80},{350,60,100,300,25,0.6,1.0,80}};

    //Hakanson 单项污染指数范围
    public static int E_level1 = 40;    //轻度生态危害（安全）
    public static int E_level2 = 79;    //中等生态危害
    public static int E_level3 = 159;    //强生态危害
    public static int E_level4 = 320;    //很强生态危害
    // E_level5 为大于320                   极强生态危害

    //总污染指数RI
    public static int R_level1 = 150;   //轻微生态危害
    public static int R_level2 = 300;   //中等生态危害
    public static int R_level3 = 600;   //强生态危害
    //R_level5 为大于600                   很强生态危害

    //默认double提升为int时的小数点后位数
    public static int precision = 4;


    public static double MetalModelThreshold = 0.8;
    //金属是否超标按阈值计算，污染样本数超过该阈值数量的金属归为超标金属
    public static double threshold = 0.4;

    public static Map<Integer,String>   int2StringMetal;
    public static Map<String,Integer>   String2intMetal;
    static{
        int2StringMetal = new HashMap<>();
        String2intMetal = new HashMap<>();

        int2StringMetal.put(Cr,"Cr");
        int2StringMetal.put(Zn,"Zn");
        int2StringMetal.put(Cd,"Cd");
        int2StringMetal.put(Ni,"Ni");
        int2StringMetal.put(Pb,"Pb");
        int2StringMetal.put(Hg,"Hg");
        int2StringMetal.put(As,"As");
        int2StringMetal.put(Cu,"Cu");

        String2intMetal.put("Cr",Cr);
        String2intMetal.put("Zn",Zn);
        String2intMetal.put("Cd",Cd);
        String2intMetal.put("Ni",Ni);
        String2intMetal.put("Pb",Pb);
        String2intMetal.put("Hg",Hg);
        String2intMetal.put("As",As);
        String2intMetal.put("Cu",Cu);
    }
}
