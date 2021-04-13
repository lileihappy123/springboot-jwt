package com.springboot.jwt.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 随机6位数生成
 * @author lilei
 */
public class RandomTools {
    private RandomTools(){
    }

    /** 随机6位数 **/
    public static String randomCode(){
        Random rand = new Random();
        int r = rand.nextInt(10000);
        return r+"";
    }
    /** 时间捕捉 **/
    public static String curDate(String pattern){
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        return sdf.format(new Date());
    }
    public static String curDate(){
        return curDate("yyyy-MM-dd HH:mm:ss");
    }
}