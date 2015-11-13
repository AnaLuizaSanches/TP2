package Administrador;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Data {
     private static final Calendar calendar = Calendar.getInstance();
     /*
     recebe uma string com data no formato dd/mm/yyyy e retorna um Date com 
     a data correspondente 
     */
    public static Date getDate(String str){
       int i=0, data[] = new int[3];
       for (String d: str.split("/")){
           data[i] = Integer.parseInt(d);
           i++;
       }
       calendar.set(data[2], data[1]-1, data[0], 0, 0, 0);
       return calendar.getTime();
    }
    
    public static String getString(Date data){
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");  
        return dataFormat.format(data);
    }
     
}
