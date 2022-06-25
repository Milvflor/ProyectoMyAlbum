/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import TDAs.CircularDoublyLinkedList;

/**
 *
 * @author VICTOR
 */
class Album {
    private String Description;
    private CircularDoublyLinkedList <Photos> Photos;
    private String Nombre_Album;

    public Album(String Description, CircularDoublyLinkedList<Photos> Photos, String Nombre_Album) {
        this.Description = Description;
        this.Photos = Photos;
        this.Nombre_Album = Nombre_Album;
    }

    public String getDescription() {
        return Description;
    }

    public CircularDoublyLinkedList<Photos> getPhotos() {
        return Photos;
    }

    public String getNombre_Album() {
        return Nombre_Album;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setPhotos(CircularDoublyLinkedList<Photos> Photos) {
        this.Photos = Photos;
    }

    public void setNombre_Album(String Nombre_Album) {
        this.Nombre_Album = Nombre_Album;
    }

    


}
