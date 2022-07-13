/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

/**
 *
 * @author milel
 */
public class Tuple<E,T> {
    
    private E first;
    private T second;

    public Tuple(E first, T second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }
    
    public boolean isNull(){
        if(this.first==null || this.second==null){
            return true;
        }else{
            return false;
        }
    }

    public void setFirst(E first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
    
    
    
    
    
}
