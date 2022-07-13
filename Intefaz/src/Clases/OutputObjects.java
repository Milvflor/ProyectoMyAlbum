/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author milel
 */
public class OutputObjects {
    
    String folder = "./src/resources/";
    
    public void createAlbumOutput(String nombreAl){
        File f = new File(folder);
        File fs = new File(folder+nombreAl);
        if(f.exists()){
            fs.mkdir();
            System.out.println(nombreAl+" carpeta creada!");
        }else{
            System.out.println(folder+" no existe.");
        }
    }
    
    public void addPhotoOutput(String albumPath, String oriPathfoto, String photoName){
        Path ori = FileSystems.getDefault().getPath(oriPathfoto);
        Path to = FileSystems.getDefault().getPath(albumPath+"/"+photoName);
        File photo = new File(oriPathfoto);
        if(photo.exists()){
            try {
                Files.move(ori, to,StandardCopyOption.ATOMIC_MOVE);
            } catch (IOException ex) {
                Logger.getLogger(OutputObjects.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println(photoName+" no existe.");
        }
    }
    
    public void deletePhotoOutput(String photoPath){
        Path ori = FileSystems.getDefault().getPath(photoPath);
        File photo = new File(photoPath);
        if(photo.exists()){
            try {
                Files.delete(ori);
            } catch (IOException ex) {
                Logger.getLogger(OutputObjects.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println(photoPath+" no exitste.");
        }
    }
}
