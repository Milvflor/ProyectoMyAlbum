/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ListResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author milel
 */
public class SerializableOutputStream {
//    
    String folder = "./src/data/";
    String filename = "albumes.dat";
    String pathfile = folder+filename;
    
    File fichero = new File(pathfile);
    ObjectOutputStream oos = null;

    Album albx;
    
    public SerializableOutputStream() {
    }
    
    
    public void createFile() throws FileNotFoundException, IOException{

        if(fichero.exists()){
            oos = new MiObjectOutputStream(new FileOutputStream(fichero, true));

        }else{
            System.out.println("creando");
            oos = new ObjectOutputStream(new FileOutputStream(fichero));
        }
        
    }
    
    public void writeAlbum(Album alb) throws IOException{
        oos.writeObject(alb);
        System.out.println(alb + " registrado.");
    }
    
    public void readContains(){
      
        
        System.out.println("*****************************\n"
                         + "**** Albumes existentes *****\n"+
                           "*****************************");
        
        try {
            
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            while (true) {
                albx = (Album)ois.readObject();
                System.out.println(albx.toString());
            }
        } catch (EOFException e) {
            System.out.println("[+] Ya no hay más albumes.");
        } catch(IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void cargarAlbumesData(MisAlbunes mis){
        
        try {
            if(fichero.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
                while (true) {
                    albx = (Album)ois.readObject();
                    mis.addAlbum(albx);
                }
            }
        } catch (EOFException e) {
            System.out.println("[+] No hay albumes por añadir.");
        } catch(IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void updateFile(MisAlbunes albuneS){
        
        try {
            fichero.delete();
            this.createFile();
            
            for (int i = 0; i < albuneS.size(); i++) {
                this.writeAlbum(albuneS.get(i));
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(SerializableOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        SerializableOutputStream o = new SerializableOutputStream();
        
        o.createFile();
        o.readContains();
    }
    
    
    
    
    
}
