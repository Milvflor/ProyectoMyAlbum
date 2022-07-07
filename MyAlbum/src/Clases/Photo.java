/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import TDAs.ArrayList;
import java.util.Date;

/**
 *
 * @author VICTOR
 */
public class Photo {
    private String nombre;
    private Date fecha;
    private String Lugar; ///(Direccion//Pais)
    private ArrayList<Persona> Personas;
    private String Description;
    private String PATH;

    public Photo(){
    }
    
    
    public Photo(String nombre,Date fecha, String Lugar, ArrayList<Persona> Personas, String Description, String PATH) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.Lugar = Lugar;
        this.Personas = Personas;
        this.Description = Description;
        this.PATH = PATH;
    }
    
    public Date getFecha() {
        return fecha;
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
    }
    
    

    @Override
    public String toString() {
        return this.nombre + " => Tomada en "+ this.Lugar +" el " +this.fecha.toString() +"\n";
    }
    
    
}
