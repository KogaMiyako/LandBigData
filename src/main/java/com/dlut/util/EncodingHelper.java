package com.dlut.util;

import java.io.UnsupportedEncodingException;

public class EncodingHelper {
    public static String gbk2utf_8(String str){
        String result = null;
        try {
            result =  new String(str.getBytes("gbk"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static String utf_8_2gbk(String str){
        String result = null;
        try {
            result =  new String(str.getBytes("utf-8"),"gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
