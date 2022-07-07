/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import TDAs.CircularDoublyLinkedList;
import java.io.Serializable;

/**
 *
 * @author VICTOR
 */
public class Album implements Serializable{
    private String Description;
    private CircularDoublyLinkedList <Photo> Photos;
    private String Nombre_Album;
    private String PATH = "./src/Resources/";

    
    public Album(String Nombre_Album) {
        this.Description = "";
        this.Photos = null;
        this.Nombre_Album = Nombre_Album;
        this.PATH = PATH + this.Nombre_Album.replace(' ', '_');
    }
    
    
    public Album(String Description, CircularDoublyLinkedList<Photo> Photos, String Nombre_Album) {
        this.Description = Description;
        this.Photos = Photos;
        this.Nombre_Album = Nombre_Album;
        this.PATH += this.Nombre_Album.replace(' ', '_');
    }

    public String getDescription() {
        return Description;
    }

    public CircularDoublyLinkedList<Photo> getPhotos() {
        return this.Photos;
    }

    public String getNombre_Album() {
        return Nombre_Album;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setPhotos(CircularDoublyLinkedList<Photo> Photos) {
        this.Photos = Photos;
    }

    public void setNombre_Album(String Nombre_Album) {
        this.Nombre_Album = Nombre_Album;
    }

    public void setPATH(String PATH) {
        this.PATH = PATH;
    }

    public String getPATH() {
        return PATH;
    }
    
    public boolean addPhoto(Photo f){
        if(f==null) return false;
        if(this.Photos==null){
            this.Photos = new CircularDoublyLinkedList<>(f);
        }else{
            this.Photos.addLast(f);
        }
        return true;
    }

    @Override
    public String toString() {
        return "Album{" + "Description=" + Description + ", Photos=" + Photos + ", Nombre_Album=" + Nombre_Album + ", PATH=" + PATH + '}';
    }
    
}
