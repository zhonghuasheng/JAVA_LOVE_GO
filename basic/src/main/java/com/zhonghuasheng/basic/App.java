package com.zhonghuasheng.basic;

import java.lang.String;
import java.lang.System;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2017-09-02");
        System.out.println(date);
    }
}
