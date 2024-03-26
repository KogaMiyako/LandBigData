package com.dlut.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhonghua on 2015/8/16.
 */
public class TimeFormat {

    private static SimpleDateFormat sdf1=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
    private static SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String timeFormat(Date time){
        return sdf1.format(time);
    }

    public static String dateToString(Date time){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
    }

    public static Date stringToDate(String time){
        Date date=null;
        try{
            date=sdf2.parse(time);
        }catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }

    public static String stringFormat(String time){
        Date date=null;
        try{
            date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sdf1.format(date);
    }
}
