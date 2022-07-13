package TDAs;

import TDAs.Nodes.NodeDoubly;
import java.io.Serializable;

public class CircularDoublyLinkedList<E> implements Serializable {

    static final long serialVersionUID = 1L;
    NodeDoubly<E> last;

//    public CircularDoublyLinkedList() {
//        
//        this.last = new NodeDoubly<>(null);
//        this.last.setNext(this.last);
//        this.last.setPrevious(this.last);
//        
//    }
    public CircularDoublyLinkedList(E content) {

        this.last = new NodeDoubly<>(content);
        this.last.setNext(this.last);
        this.last.setPrevious(this.last);

    }

    private NodeDoubly<E> getX(int index) {

        if (index < 0 || index > this.size() - 1) {
            return null;
        }

        if (index == this.size() - 1) {//getLast
            return this.last;
        }
        if (index == 0) {//getFirst
            return this.last.getNext();
        }
        int i = 0;
        NodeDoubly<E> e = null;
        for (NodeDoubly<E> v = this.last.getNext(); i <= index; v = v.getNext()) {
            if (i == index) {
                e = v;
            }
            i++;
        }
        return e;
    }

    public E get(int index) {

        if (index < 0 || index > this.size() - 1) {
            return null;
        }

        if (index == this.size() - 1) {//getLast
            return this.last.getContent();
        }
        if (index == 0) {//getFirst
            return this.last.getNext().getContent();
        }
        int i = 0;
        E ee = null;
        NodeDoubly<E> e = null;
        for (NodeDoubly<E> v = this.last.getNext(); i <= index; v = v.getNext()) {
            if (i == index) {
                e = v;
                ee = v.getContent();
            }
            i++;
        }
        return ee;
    }

    public boolean addLast(E e) {
        if (e == null) {
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

    public int size() {
        int cont = 1;

        for (NodeDoubly<E> v = this.last.getNext(); v != this.last; v = v.getNext()) {
            cont++;
        }

        return cont;
    }

    @Override
    public String toString() {

        String s = "";

        for (NodeDoubly<E> v = this.last.getNext(); v != this.last; v = v.getNext()) {
            s += v.getContent().toString() + " ";
        }
        s += last.getContent();
        return s;
    }

    public E remove(int index) {

        if (index < 0 || index > this.size() - 1) {
            return null;
        }
        if (index == this.size() - 1) {//removeLast
            E e = this.last.getContent();
            this.last.getPrevious().setNext(this.last.getNext());
            this.last.getNext().setPrevious(this.last.getPrevious());
            this.last = this.last.getPrevious();
            return e;
        }
        if (index == 0) {//removeFirst
            E e = this.last.getNext().getContent();
            this.last.getNext().getNext().setPrevious(this.last);
            this.last.setNext(this.last.getNext().getNext());
            return e;
        }
        int i = 0;
        E e = null;
        for (NodeDoubly<E> v = this.last.getNext(); i <= index; v = v.getNext()) {
            if (i == index) {
                e = v.getContent();
                v.getPrevious().setNext(v.getNext());
                v.getNext().setPrevious(v.getPrevious());
            }
            i++;
        }
        return e;
    }

    public boolean removeE(E e) {
        if (e == null || this == null) {
            return false;
        }

        NodeDoubly<E> n = null;
        int i = 1;
        for (NodeDoubly<E> v = this.last.getNext(); i <= this.size(); v = v.getNext()) {
            if (v.getContent().equals(e)) {
                if (i < this.size()) {
                    v.getPrevious().setNext(v.getNext());
                    v.getNext().setPrevious(v.getPrevious());
                }else if(i==this.size()){
                    this.remove(this.size()-1);
                }

            }
            i++;
        }
        return true;
    }

    public E getNext(E e) {
        NodeDoubly<E> n = null;
        int i = 0;

        for (NodeDoubly<E> v = this.last.getNext(); i <= this.size() - 1; v = v.getNext()) {
            if (v.getContent().equals(e)) {
                n = v.getNext();
            }
            i++;
        }
        return n.getContent();

    }

    public E getPrevious(E e) {
        NodeDoubly<E> n = null;
        int i = 0;

        for (NodeDoubly<E> v = this.last.getNext(); i <= this.size() - 1; v = v.getNext()) {
            if (v.getContent().equals(e)) {
                n = v.getPrevious();
            }
            i++;
        }
        return n.getContent();

    }

//    public static void main(String[] args) {
//        CircularDoublyLinkedList<Integer> i = new CircularDoublyLinkedList<>(1);
//        i.addLast(2);
//        i.addLast(3);
//        i.addLast(8);
//        i.addLast(5);
//
//        System.out.println(i.removeE(1));
//        System.out.println(i.removeE(2));
//
//
//        System.out.println(i);
//    }

}
