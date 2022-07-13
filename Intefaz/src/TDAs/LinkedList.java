package TDAs;

import TDAs.Nodes.List;
import java.io.Serializable;

public class LinkedList<E> implements List<E>, Serializable{

    static final long serialVersionUID = 1L;
    private NodeList<E> first;
    private NodeList<E> last;

    public LinkedList() {
        this.first = null;
        this.last = null;
    }

    public NodeList<E> getFirst() {
        return first;
    }

    public void setFirst(NodeList<E> first) {
        this.first = first;
    }

    public NodeList<E> getLast() {
        return last;
    }

    public void setLast(NodeList<E> last) {
        this.last = last;
    }

    @Override
    public boolean addFirst(E e) {
        if (e == null) {
            return false;
        }
        NodeList<E> nuevo = new NodeList<>(e);
        nuevo.setNext(this.getFirst());
        if (this.isEmpty()) {
            this.setLast(nuevo);
        }
        this.setFirst(nuevo);
        return true;
    }

    @Override
    public boolean addLast(E e) {
        if (e == null) {
            return false;
        }
        NodeList<E> nuevo = new NodeList<>(e);
        if (this.isEmpty()) {
            this.setFirst(nuevo);
        } else {
            this.getLast().setNext(nuevo);
        }
        
        this.setLast(nuevo);
        
        return true;
    }

    @Override
    public E removeFirst() {
        
        if (this.isEmpty()) return null;
        NodeList<E> e = this.first;
        this.first = this.first.getNext();
        
        return e.getContent();
    }

    @Override
    public E removeLast() {
        if (this.isEmpty()) return null;
        
        
        E e = null;
        for (NodeList<E> v = this.first; v != null; v = v.getNext()){
            if (v.getNext()==null) {
                e = v.getContent();
                this.first = null;
                this.last = null;
                
            }
            else if (v.getNext().getNext() == null) {
                e = v.getNext().getContent();
                v.setNext(null);
                this.setLast(v);
                break;
            }
        }
        return e;
    }

    @Override
    public int size() {
        int cont = 0;
        NodeList<E> t;
        for (t = this.getFirst(); t != null; t = t.getNext()) {
            cont++;
        }
        return cont;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null && this.last == null;
    }

    @Override
    public void clear() {
        this.first = null;
        this.last = null;
    }

    @Override
    public void add(int index, E element) {
        if ((this.isEmpty() && index > 0) || index < 0) System.out.println("Indice inválido.");
        else if (this.isEmpty() && index == 0 || index==0) this.addFirst(element);
        else if (index >= this.size()) this.addLast(element);
        else if (index < this.size()) {
            int cont = 0;
            for (NodeList v=this.first; cont<=index; v=v.getNext()){
                if (cont==index-1) {
                    NodeList e = new NodeList<>(element);
                    e.setNext(v.getNext());
                    v.setNext(e);
                }
                cont++;
            }
        }
    }

    @Override
    public E remove(int index) {
        if (index>this.size() || index<0) return null;
        else if (index == 0 ) return this.removeFirst();
        else if (index == this.size()-1) return this.removeLast();
        
        int cont = 0;
        E e = null;
        for (NodeList<E> v = this.first; cont<= index; v=v.getNext()){
            if(cont==index-1){
                NodeList<E> n = v.getNext();
                e = n.getContent();
                v.setNext(v.getNext().getNext());
            }
            cont++;
        }
        return e;
        
    }

    @Override
    public E get(int index) {
        if (index<0 || index>this.size()-1) return null;
        if (index==0) return this.first.getContent();
        if (index==this.size()-1) return this.last.getContent();
        
        int cont = 0;
        E e = null;
        for (NodeList<E> v=this.first; cont<=index; v = v.getNext()){
            if (index==cont) {
                e = v.getContent();
            }
            cont++;
        }
        return e;
    }

    @Override
    public E set(int index, E element) throws Exception{
        if (index<0 || index>this.size()-1 || element == null) {
            throw new Exception("index inválido.");
        }
        E e = null;
        if (index==0) {
            e = this.first.getContent();
            this.first.setContent(element);
            return e;
        }
        if (index==this.size()-1){
            e = this.last.getContent();
            this.last.setContent(element);
            return e;
        }
        
        int cont = 0;
        for (NodeList<E> v=this.first; cont<=index; v = v.getNext()){
            if (index==cont) {
                e = v.getContent();
                v.setContent(element);
            }
            cont++;
        }
        return e;
    }
    
    private int search(E elem){
        
        int index = -1;
        int contador = -1;
        for (NodeList<E> t = this.getFirst(); t != null; t = t.getNext()) {
            contador++;
            if(t.getContent().equals(elem)){
                index = contador;
                break;
            }
        }
       
        return index;
    }
    
    public boolean replace(E old, E new_) throws Exception{
        
        int index = this.search(old);
        if(index==-1){
            return false;
        }else{
            this.set(index, new_);
            return true;
        }
        
    }

    @Override
    public String toString() {
        String s = "";
        NodeList<E> t;
        for (t = this.getFirst(); t != null; t = t.getNext()) {
            s += t.getContent() + " ";
        }
        return s;
    }

    
    public static void main(String[] args) throws Exception {
        
        LinkedList<Integer> A = new LinkedList<>();
        A.addLast(2);
        A.addLast(3);
        A.addLast(8);
        A.addLast(4);
        A.addLast(1);
        
        A.replace(4, 7);
        System.out.println(A);
        
    }

   
}
