/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.deajcesar.judisafese.presentation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author jairo
 */
public class DateTime {
    private static Calendar date;
    
    public static String getDateTime(){
        date= Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd - MMMMM - yyyy  hh:mm:ss");
        return sdf.format(date.getTime());
    }
    
    public static String getDate(Date d){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy");
        return sdf.format(d);
    }
    
    public static String getTime(Date d){
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        return sdf.format(d);
    }
}
