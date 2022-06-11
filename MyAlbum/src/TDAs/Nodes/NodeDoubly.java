package TDAs.Nodes;

public class NodeDoubly<E> {
    
    E content;
    NodeDoubly<E> next;
    NodeDoubly<E> previous;

    public NodeDoubly(E content) {
        this.content = content;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public NodeDoubly<E> getNext() {
        return next;
    }

    public void setNext(NodeDoubly<E> next) {
        this.next = next;
    }

    public NodeDoubly<E> getPrevious() {
        return previous;
    }

    public void setPrevious(NodeDoubly<E> previous) {
        this.previous = previous;
    }
    
}
