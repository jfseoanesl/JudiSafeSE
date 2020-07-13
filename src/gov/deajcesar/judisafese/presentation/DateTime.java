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
    
    public static boolean isHoy(Date ingreso){
        Calendar fIngreso = Calendar.getInstance();
        fIngreso.setTime(ingreso);
        Calendar hoy = Calendar.getInstance();
        if((hoy.get(Calendar.YEAR)==fIngreso.get(Calendar.YEAR)) &&
           (hoy.get(Calendar.MONTH)==fIngreso.get(Calendar.MONTH)) &&
           (hoy.get(Calendar.DAY_OF_MONTH)==fIngreso.get(Calendar.DAY_OF_MONTH))){
            return true;
        }
        else
            return false;
    }
    
    public static int getEdad(Date fechaNac){
        Calendar fNac = Calendar.getInstance();
        fNac.setTime(fechaNac);
        Calendar fActual = Calendar.getInstance();
        int año = fActual.get(Calendar.YEAR)- fNac.get(Calendar.YEAR);
        int mes = fActual.get(Calendar.MONTH)- fNac.get(Calendar.MONTH);
        int dia = fActual.get(Calendar.DATE)- fNac.get(Calendar.DATE);
        //Se ajusta el año dependiendo el mes y el día
        if(mes<0 || (mes==0 && dia<0)){
            año--;
        }
        //Regresa la edad en base a la fecha de nacimiento
        return año;
        
    }
}
