package com.firatcapin.stok.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BaseUtil {

    public static boolean isEmpty(Object o) {
        if (o == null)
            return true;

        if (o instanceof List) {
            return (((List) o).size() == 0);
        }
        if (o instanceof Object[]) {
            Object[] obj = (Object[]) o;
            return (obj.length == 0);
        }

        if (o instanceof String) {
            String str = (String) o;
            return str.equals("");
        }


        return false;
    }

    public static Date ConvertStringToSqlDate(String date)  throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date dateTimeUtil = formatter.parse(date);
        java.sql.Date dateTimeSql = new java.sql.Date(dateTimeUtil.getTime());
        return dateTimeSql;
    }


    public static Date ConvertDateToSqlDate(Date date)  throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date dateTimeSql = new java.sql.Date(date.getTime());
        return dateTimeSql;
    }

    public static String dateToString(Date tarih) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return formatter.format(tarih);
    }

    public static String dateToString(Date tarih, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(tarih);
    }

    public static Date stringToDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.parse(date);
    }

    public static Date stringToDate(String date , String format) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.parse(date);
    }


    public static String getSaatDakikaToString(String tarih) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:MM:SS");
        return formatter.format(tarih);
    }

    public static String getSaatDakikaToString(Date tarih) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:MM:SS");
        return formatter.format(tarih);
    }

}
