public class Node<E>
{
        public E e;
        public Node<E> next;

        @SuppressWarnings("unused")
        Node(E e, Node<E> n) {
            this.e = e;
            this.next = n;
        }

        Node(E e) {
            this.e = e;
        }
}
