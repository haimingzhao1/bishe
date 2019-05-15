package com.bm.untils;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
    /**
     * 时间戳转换成日期格式字符串
     * @param seconds 精确到秒的字符串
     * @return
     */
    public static String stampToDate(String seconds) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(Long.valueOf(seconds+"000")));
    }
    /**
     * 日期格式字符串转换成时间戳
     * @param date_str 字符串日期
     * @return
     */
    public static String dateToStamp(String date_str){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return String.valueOf(sdf.parse(date_str).getTime()/1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    /**
     * 日期格式字符串转换成时间戳,不精确到秒
     * @param date_str 字符串日期
     * @return
     */
    public static String dateToStampNoSecond(String date_str){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return String.valueOf(sdf.parse(date_str).getTime()/1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    /**
     * 时间戳转换成日期格式字符串
     * @param seconds 不精确到秒
     * @return
     */
    public static String stampToDateNoSecond(String seconds) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date(Long.valueOf(seconds+"000")));
    }
    /**
     * 取得当前时间戳（精确到秒）
     * @return
     */
    public static String timeStamp(){
        long time = System.currentTimeMillis();
        String t = String.valueOf(time/1000);
        return t;
    }

//    public static void main(String[] args) {
//        System.out.println(timeStamp());
//        String t = stampToDate(timeStamp());
//        System.out.println(t);
//        String t1 = dateToStampNoSecond("2017-06-01");
//        System.out.println(t1);
//        System.out.println(stampToDateNoSecond(t1));
//    }
}
