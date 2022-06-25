/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import TDAs.ArrayList;
import java.util.Date;

/**
 *
 * @author VICTOR
 */
class Photos {
    private Date fecha;
    private String Lugar; ///(Direccion//Pais)
    private ArrayList<Persona> Personas;
    private String Description;
    private String PATH;

    public Photos(Date fecha, String Lugar, ArrayList<Persona> Personas, String Description, String PATH) {
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

    @Override
    public String toString() {
        return "Dicha photo fue tomada en "+ this.Lugar +"el" +this.fecha.toString();
    }
    
    
}
