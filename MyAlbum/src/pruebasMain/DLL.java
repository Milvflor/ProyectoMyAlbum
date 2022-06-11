/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasMain;

import TDAs.CircularDoublyLinkedList;
import TDAs.Nodes.NodeDoubly;
import java.util.Iterator;

/**
 *
 * @author milel
 */
public class DLL {
    public static void main(String[] args) {
        CircularDoublyLinkedList<Integer> d = new CircularDoublyLinkedList<>(1);
        d.addLast(2);
        d.addLast(3);
        d.addLast(4);
        d.addLast(5);
        d.addLast(6);
        d.addLast(7);
        d.addLast(7);
        d.addLast(7);
        d.addLast(7);


        System.out.println(d.size());
        System.out.println(d.toString());
        System.out.println(d.remove(0));
        System.out.println(d.toString());
        System.out.println(d.remove(8));
        System.out.println(d.toString());
        System.out.println(d.remove(4));
        System.out.println(d.toString());
        System.out.println(d.remove(2));
        System.out.println(d.toString());
        
        
        

       
        
       
        
    }
}
