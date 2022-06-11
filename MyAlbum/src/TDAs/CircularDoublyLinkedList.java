package TDAs;

import TDAs.Nodes.NodeDoubly;

public class CircularDoublyLinkedList<E> {
    
    NodeDoubly<E> last;

    public CircularDoublyLinkedList(E content) {
        
        this.last = new NodeDoubly<>(content);
        this.last.setNext(this.last);
        this.last.setPrevious(this.last);
        
    }
    
    public NodeDoubly<E> get(int index){
        
        if (index<0 || index>this.size()-1) return null;
        
        if (index==this.size()-1) {//getLast
            return this.last;
        }
        if(index==0){//getFirst
            return this.last.getNext();
        }
        int i = 0;
        NodeDoubly<E> e = null;
        for(NodeDoubly<E> v = this.last.getNext(); i <= index; v=v.getNext()){
            if (i==index){
                e = v;
            }
            i++;
        }
        return e;
    }
    
    
    public boolean addLast(E e){
        if (e==null) {
            return false;
        }
        
       NodeDoubly<E> n = new NodeDoubly<>(e);
       n.setPrevious(this.last);
       n.setNext(this.last.getNext());
       this.last.setNext(n);
       this.last = n;
       this.last.getNext().setPrevious(n);      

        
        return true;
    }
    
    public int size(){
        int cont = 1;
        
        for(NodeDoubly<E> v = this.last.getNext(); v!= this.last; v=v.getNext()){
            cont++;
        }
        
        return cont;
    }
    
   
    @Override
    public String toString(){
        
        String s = "";
        
        for (NodeDoubly<E> v = this.last.getNext(); v!= this.last; v=v.getNext()){
            s += v.getContent().toString() + " ";
        }
        s += last.getContent();
        return s;
    }
    
 
    public E remove(int index){
        
        if (index<0 || index>this.size()-1) return null;
        if (index==this.size()-1) {//removeLast
            E e = this.last.getContent();
            this.last.getPrevious().setNext(this.last.getNext());
            this.last.getNext().setPrevious(this.last.getPrevious());
            this.last = this.last.getPrevious();
            return e;
        }
        if(index==0){//removeFirst
            E e = this.last.getNext().getContent();
            this.last.getNext().getNext().setPrevious(this.last);
            this.last.setNext(this.last.getNext().getNext());
            return e;
        }
        int i = 0;
        E e = null;
        for(NodeDoubly<E> v= this.last.getNext(); i <= index; v=v.getNext()){
            if (i==index){
                e = v.getContent();
                v.getPrevious().setNext(v.getNext());
                v.getNext().setPrevious(v.getPrevious());
            }
            i++;
        }
        return e;
    }

}
