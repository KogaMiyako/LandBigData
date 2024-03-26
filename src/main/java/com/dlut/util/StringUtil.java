package com.dlut.util;

public class StringUtil {
    public static String SplitAndMergeFileName(String originFileName,String word){
        String[] strs = originFileName.split("\\.");
        return strs[0] + word + "." + strs[1];
    }
}
