/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import TDAs.ArrayList;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author VICTOR
 */
public class Photo implements Comparator<Photo>, Serializable{
    
    static final long serialVersionUID = 1L;
    
    private String nombre;
    private Date fecha;
    private String Lugar; ///(Direccion//Pais)
    private ArrayList<Persona> Personas;
    private String Description;
    private String PATH;

    public Photo(){
    }
    
    
    public Photo(Date fecha, String Lugar, ArrayList<Persona> Personas, String Description, String PATH) {
    
        this.fecha = fecha;
        this.Lugar = Lugar;
        this.Personas = Personas;
        this.Description = Description;
        this.PATH = PATH;
        this.nombre = Utilities.getNamePath(PATH);
        
    }
    
    public Date getFecha() {
        return fecha;
    }

    public String getNombre(){
        return this.nombre;
    }
    public String getLugar() {
        return Lugar;
    }

    public ArrayList<Persona> getPersonas() {
        return Personas;
    }

    public String getDescription() {
        return Description;
    }

    public String getPATH() {
        return PATH;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setLugar(String Lugar) {
        this.Lugar = Lugar;
    }

    public void setPersonas(ArrayList<Persona> Personas) {
        this.Personas = Personas;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setPATH(String PATH) {
        this.PATH = PATH;
        this.nombre = Utilities.getNamePath(PATH);
    }
    
    
    @Override
    public String toString() {
        return "Photo{" + 
                "nombre=" + nombre + 
                ", fecha=" + fecha + 
                ", Lugar=" + Lugar + 
                ", Personas=" + Personas + 
                ", Description=" + Description +
                ", PATH=" + PATH + "}";
    }

    @Override
    public int compare(Photo o1, Photo o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }

    
    
    
    
}
