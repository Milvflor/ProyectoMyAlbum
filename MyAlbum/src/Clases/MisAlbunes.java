/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import TDAs.ArrayList;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 *
 * @author VICTOR
 */
public class MisAlbunes {
    
    ArrayList<Album> Albunes;

    public MisAlbunes(){
        this.Albunes = new ArrayList<>();
    }
    
    public MisAlbunes(ArrayList<Album> Albunes) {
        this.Albunes = Albunes;
    }

    public ArrayList<Album> getAlbunes() {
        return Albunes;
    }

    private void setAlbunes(ArrayList<Album> Albunes) {
        this.Albunes = Albunes;
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
