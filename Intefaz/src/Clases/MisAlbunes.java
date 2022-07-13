/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import TDAs.ArrayList;
import TDAs.LinkedList;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 *
 * @author VICTOR
 */
public class MisAlbunes {
    
    LinkedList<Album> Albunes;

    public MisAlbunes(){
        this.Albunes = new LinkedList<>();
    }
    
    public MisAlbunes(LinkedList<Album> Albunes) {
        this.Albunes = Albunes;
    }

    private LinkedList<Album> getAlbunes() {
        return Albunes;
    }
    
    public boolean replaceAlbum(Album old, Album new_) throws Exception{
        if(this.getAlbunes().size()==0 || old == null || new_ == null){
            return false;
        }else{
            return this.getAlbunes().replace(old, new_);
        }
    }
    
    public Album getAlbum(String nameAlbum){
        
        Album a = null;
        for (int i = 0; i < this.size(); i++) {
            if(Albunes.get(i).getNombre_Album().compareTo(nameAlbum)==0){
                a = Albunes.get(i);
                break;
            }
        }
        return a;
    }
    
    public Album getAlbum(int index){
        return this.getAlbunes().get(index);
    }
    
    public int size(){
        return this.getAlbunes().size();
    }
    
    public Album get(int index){
        return this.getAlbunes().get(index);
    }
    
    
    public boolean addAlbum(Album alb){
        if(alb==null)return false;
        this.Albunes.addLast(alb);
        return true;
    }
    
    public void showAlbunes() throws Exception{
        for (int i = 0; i < this.Albunes.size(); i++) {
            System.out.println(this.getAlbunes().get(i).toString());
        }
    }
    
    
}
