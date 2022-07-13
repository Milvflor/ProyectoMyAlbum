/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author VICTOR
 */
public class Persona implements Comparator<Persona>, Serializable{
    
    static final long serialVersionUID = 1L;
    private String nombre;
    private String apellido;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Persona{" + nombre + " " +apellido + '}';
    }

    @Override
    public int compare(Persona o1, Persona o2) {
        String s1 = o1.getNombre();
        String s2 = o2.getNombre();
        System.out.println(s1);
        System.out.println(s2);
        return s1.compareTo(s2);
    }
    
   
    
}
