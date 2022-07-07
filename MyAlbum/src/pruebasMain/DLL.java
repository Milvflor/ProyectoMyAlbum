/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasMain;

import Clases.Album;
import Clases.MisAlbunes;
import Clases.Persona;
import Clases.Photo;
import Clases.Utilities;
import TDAs.ArrayList;
import TDAs.CircularDoublyLinkedList;
import TDAs.Nodes.NodeDoubly;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author milel
 */
public class DLL {
    
    
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
    
    
    public static void main(String[] args) throws Exception {
//        CircularDoublyLinkedList<Integer> d = new CircularDoublyLinkedList<>(1);
//        d.addLast(2);
//        d.addLast(3);
//        d.addLast(4);
//        d.addLast(5);
//        d.addLast(6);
//        d.addLast(7);
//        d.addLast(7);
//        d.addLast(7);
//        d.addLast(7);
//
//
//        System.out.println(d.size());
//        System.out.println(d.toString());
//        System.out.println(d.remove(0));
//        System.out.println(d.toString());
//        System.out.println(d.remove(8));
//        System.out.println(d.toString());
//        System.out.println(d.remove(4));
//        System.out.println(d.toString());
//        System.out.println(d.remove(2));
//        System.out.println(d.toString());
        
        
//        toDate("2020-24-08");
        
//        ArrayList<Persona> p = Utilities.toPersons("Camila Perez,Antonio,Gonzalez");
//        
//        for (int i = 0; i < p.size(); i++) {
//            System.out.println(p.get(i).toString());
//        }
       
//        File directoryPath = new File("./src/Resources/");
//        String contents[] = directoryPath.list();
//        
//        for (String content : contents) {
//            System.out.println(content);
//        }
//       
        MisAlbunes misAlbunes = new MisAlbunes();
        
        //Album example
        String[] ciudades = {"Guayaquil","Quito","Pedernales","Cayambe","Guayaquil","Quito","Pedernales","Cayambe"};

        Album album = new Album("Album_Default");
        File filesDir = new File(album.getPATH());
        String fotosString[] = filesDir.list();

        int i = 0;

        for (String f : fotosString) {
            Photo foto = new Photo(f,
                    Utilities.toDate("2022-08-24"),
                    ciudades[i++],
                    Utilities.toPersons("Diana Mendez,Eun Ho,Jean Simancas"),
                    "",
                    album.getPATH()+f
            );
            album.addPhoto(foto);
        }
        misAlbunes.addAlbum(album);
        
        System.out.println(album.getPhotos());
    }
    
}
