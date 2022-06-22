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

    


}
