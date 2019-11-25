import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListG<E> implements Iterable<E>
{
    Node<E> head;
    int     size;

    LinkedListG() {
        head = null;
        size = 0;
    }

    LinkedListG(E e) {
        head = new Node<E>(e);
        size = 1;
    }

    void add(E e) {
        if (head == null) {
            head = new Node<E>(e);
        } else {
            Node<E> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<E>(e);
        }
        size++;
    }

    E get(int n) {
        if (n > size) {
            return null;
        }
        Node<E> current = head;
        for (int i = 1; i < n; i++) {
            current = current.next;
        }
        return current.e;
    }

    void traverseF()
    {
        for (Node<E> i = head; i != null; i = i.next)
            System.out.println(i.e);
    }
    
    void traverseW() {
        Node i = head;
        while (i != null) {
            System.out.println(i.e);
            i = i.next;
        }
    }
    
    public Iterator<E> iterator()  { return new ListIterator(); }
    
    private class ListIterator implements Iterator<E> {
        private Node current = head;
        
        public boolean hasNext()  { return current != null; }
        public void    remove()   { throw new UnsupportedOperationException(); }

        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E item = (E) current.e;
            current = current.next; 
            return item;
        }
    }
    
    void iterador() {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    
    static private class Node<E> {
        private E e;
        private Node<E> next;

        @SuppressWarnings("unused")
        Node(E e, Node<E> n) {
            this.e = e;
            this.next = n;
        }

        Node(E e) {
            this.e = e;
        }
    }
}
