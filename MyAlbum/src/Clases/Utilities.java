/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import TDAs.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author milel
 */
public class Utilities {
    
    
    public static Date toDate(String fecha){
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 

        Date t =null;
        try {
           t = ft.parse(fecha); 
//           System.out.println(t); 
        } catch (ParseException e) { 
           System.out.println("Unparseable using " + ft); 
        }
        return t;
    }
    
    public static ArrayList<Persona> toPersons(String personas){
        
        ArrayList<Persona> personasA = new ArrayList<>();
        String[] personas_ = personas.split(",");
        
        for (String p : personas_) {
            
            Persona p0;
            String[] p_ = p.split(" ");
            
            String n;
            String a;
            
            if(p_.length>1){
                n = p_[0];
                a= p_[1];
                
                p0 = new Persona(n,a);
                
            }else{
                n = p_[0];
                p0 = new Persona(n,"");
            }
            personasA.addLast(p0);
        }
        return personasA;
    }
}
