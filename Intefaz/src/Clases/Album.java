/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import TDAs.ArrayList;
import TDAs.CircularDoublyLinkedList;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author VICTOR
 */
public class Album implements Comparator<Album>, Serializable {

    static final long serialVersionUID = 1L;

    private String Description;
    private CircularDoublyLinkedList<Photo> Photos;
    private String Nombre_Album;
    private String PATH = "./src/resources/";

    public Album(String Nombre_Album) {
        this.Description = "";
        this.Photos = null;
        this.Nombre_Album = Nombre_Album;
        this.PATH = PATH + this.Nombre_Album.replace(' ', '_');
    }

//    public Album(String Description, CircularDoublyLinkedList<Photo> Photos, String Nombre_Album) {
//        this.Description = Description;
//        this.Photos = Photos;
//        this.Nombre_Album = Nombre_Album;
//        this.PATH += this.Nombre_Album.replace(' ', '_');
//    }
    public MisAlbunes filterXLugar(String valor) {

        CircularDoublyLinkedList<Photo> l = null;

        for (int i = 0; i < this.Photos.size(); i++) {
            Photo p = this.Photos.get(i);

            if (p.getLugar() != null) {
                if (p.getLugar().toLowerCase().compareTo(valor.toLowerCase()) == 0) {
                    if (l == null) {
                        l = new CircularDoublyLinkedList<>(p);
                    } else {
                        l.addLast(p);
                    }

                }
            }
        }
        Album tmpA = new Album("");
        tmpA.setPhotos(l);
        MisAlbunes tmp = new MisAlbunes();
        tmp.addAlbum(tmpA);

        return tmp;
    }

    public MisAlbunes filterXFecha(String valor) {

        Date v = Utilities.toDate(valor);
        CircularDoublyLinkedList<Photo> l = null;

        if (v != null) {
            for (int i = 0; i < this.Photos.size(); i++) {
                Photo p = this.Photos.get(i);

                if (p.getFecha() != null) {
                    if (p.getFecha().compareTo(v) == 0) {
                        if (l == null) {
                            l = new CircularDoublyLinkedList<>(p);
                        } else {
                            l.addLast(p);
                        }
                    }
                }
            }
        }

        Album tmpA = new Album("");
        tmpA.setPhotos(l);
        MisAlbunes tmp = new MisAlbunes();
        tmp.addAlbum(tmpA);

        return tmp;
    }

    public MisAlbunes filterXPersona(String valor) throws Exception {

        ArrayList<Persona> s = Utilities.toPersons(valor);
        CircularDoublyLinkedList<Photo> l = null;

        if (s != null) {
            for (int i = 0; i < s.size(); i++) {
                Persona persona = s.get(i);
                for (int j = 0; j < this.Photos.size(); j++) {
                    Photo p = this.Photos.get(j);

                    if (p.getPersonas() != null) {
                        
                        for (int k = 0; k < p.getPersonas().size(); k++) {
                            Persona pb = p.getPersonas().get(k);
                            if (pb.compare(pb, persona) == 0) {
                                if (l == null) {
                                    l = new CircularDoublyLinkedList<>(p);
                                } else {
                                    l.addLast(p);
                                }
                            }

                        }
                    }
                }
            }
        }

        Album tmpA = new Album("");
        tmpA.setPhotos(l);
        MisAlbunes tmp = new MisAlbunes();
        tmp.addAlbum(tmpA);

        return tmp;
    }
    
    public MisAlbunes filterXPersonaLugar(String valor) throws Exception {

        String[] v = valor.split(",");
        String lugar = v[0];
        String personaS = v[1];
        ArrayList<Persona> s = Utilities.toPersons(personaS);
        
        CircularDoublyLinkedList<Photo> l = null;

        if (s != null) {
            for (int i = 0; i < s.size(); i++) {
                Persona persona = s.get(i);
                for (int j = 0; j < this.Photos.size(); j++) {
                    Photo p = this.Photos.get(j);

                    if (p.getPersonas() != null && p.getLugar()!=null) {
                        
                        for (int k = 0; k < p.getPersonas().size(); k++) {
                            Persona pb = p.getPersonas().get(k);
                            if (pb.compare(pb, persona) == 0 && p.getLugar().compareTo(lugar)==0) {
                                if (l == null) {
                                    l = new CircularDoublyLinkedList<>(p);
                                } else {
                                    l.addLast(p);
                                }
                            }

                        }
                    }
                }
            }
        }

        Album tmpA = new Album("");
        tmpA.setPhotos(l);
        MisAlbunes tmp = new MisAlbunes();
        tmp.addAlbum(tmpA);

        return tmp;
    }
    
    
    

    public MisAlbunes filterXFechaLugar(String valor) {

        String[] v = valor.split(",");
        String lugar = v[0];
        Date d = Utilities.toDate(v[1]);
        CircularDoublyLinkedList<Photo> l = null;

        if (d != null) {
            for (int i = 0; i < this.Photos.size(); i++) {
                Photo p = this.Photos.get(i);
                if (p.getFecha() != null && p.getLugar() != null) {
                    if (p.getFecha().compareTo(d) == 0 && p.getLugar().toLowerCase().compareTo(lugar.toLowerCase()) == 0) {
                        if (l == null) {
                            l = new CircularDoublyLinkedList<>(p);
                        } else {
                            l.addLast(p);
                        }
                    }
                }
            }
        }

        Album tmpA = new Album("");
        tmpA.setPhotos(l);
        MisAlbunes tmp = new MisAlbunes();
        tmp.addAlbum(tmpA);

        return tmp;
    }

    public String getDescription() {
        return Description;
    }

    public CircularDoublyLinkedList<Photo> getPhotos() {
        return this.Photos;
    }

    public void deletePhoto(Photo p) {
        this.getPhotos().removeE(p);
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

    public boolean addPhoto(Photo f) {
        if (f == null) {
            return false;
        }
        if (this.Photos == null) {
            this.Photos = new CircularDoublyLinkedList<>(f);
        } else {
            this.Photos.addLast(f);
        }
        System.out.println("Foto anadida.");
        return true;
    }

    @Override
    public String toString() {
        return "Album{" + " Nombre_Album=" + Nombre_Album + ", Description=" + Description + ", Photos=" + Photos + ", PATH=" + PATH + '}';
    }

    public void showPhotos() {
        if (this.Photos != null) {
            for (int i = 0; i < this.Photos.size(); i++) {
                Photo p = this.Photos.get(i);
                System.out.println(p);
            }
        } else {
            System.out.println("[!] " + this.getNombre_Album() + " vacio.");
        }

    }

    @Override
    public int compare(Album o1, Album o2) {
        return o1.getNombre_Album().compareTo(o2.getNombre_Album());
    }

}
