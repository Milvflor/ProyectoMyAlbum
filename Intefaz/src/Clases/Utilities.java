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
import javafx.scene.control.Alert;

/**
 *
 * @author milel
 */
public class Utilities {
    
    
    public static String PersonasString(ArrayList<Persona> a) throws Exception {
        String s = "";
        for (int i = 0; i < a.size(); i++) {
            if(i<a.size()-2){
                s+=a.get(i).getNombre()+a.get(i).getApellido()+", ";
            }else{
                s+=a.get(i).getNombre()+a.get(i).getApellido();
            }
        }
        
        return s;
    }
    
    public static void alert(String alertaInfo) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(alertaInfo);
        alert.show();
    }
    
    public static Date toDate(String fecha){
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 

        Date t =null;
        try {
           t = ft.parse(fecha); 
        } catch (ParseException e) { 
           System.out.println("Unparseable using " + ft); 
        }
        return t;
    }
    
    public static String getNamePath(String path) {
        String[] s = path.split("/");
        String sr = ""+s[s.length-1];
        return sr;
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
    
    public static void main(String[] args) {
        System.out.println(Utilities.toDate("2010-08-24"));
    }
}
