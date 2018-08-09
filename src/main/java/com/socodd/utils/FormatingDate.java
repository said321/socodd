package com.socodd.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatingDate {
	
    public static Date stringToDate(String date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date dt = null;
        try {
            dt = sdf.parse(date);
        } catch (ParseException e) {
            System.err.println("Invalid date!");
        }

        return dt;
    }
	

}
