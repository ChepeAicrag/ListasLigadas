
/**
 * Write a description of class ListaDobleEnlazada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaDobleEnlazada{
    private Nodo cabeza;
    private Nodo fin;
    public class Nodo {
        /** Campos del nodo */
        String informacion;
        Nodo anterior;
        Nodo siguiente;
    }
   
    public ListaDobleEnlazada() {
        cabeza = null;
        fin = null;
    }
    
    public Nodo getAnterior(String x){
        Nodo actual = buscar(x);
        return actual.anterior;
    }
    
    public Nodo buscar(String dato) {
        Nodo buscado = null;
        Nodo iterador = cabeza;
        while ( buscado == null && iterador != null ) {
            if ( iterador.informacion.equals(dato) ) {
                buscado = iterador;
            }
            iterador = iterador.siguiente;
        }
        return buscado;
    }
    
    private boolean estaVacia() {
        boolean vacia = false;
        if ( cabeza == null ) {
            vacia = true;
        }
        return vacia;
    }

    /** enlaza dos nodos mediante enlace doble */
    private void enlazar(Nodo nodoA, Nodo nodoB) {
        nodoA.siguiente = nodoB;
        nodoB.anterior = nodoA;
    }
    
    public void mostrar(Nodo n) {
        Nodo iterador = n;
        boolean flag  = false;
        if (n == cabeza) flag = true;
        while ( iterador != null ) {
            System.out.print( iterador.informacion);
            if (flag) iterador = iterador.siguiente;
            else      iterador = iterador.anterior;
        }
        System.out.println( "null" );
    }
    
    public void mostrarLista(){
        mostrar(cabeza);
    }
    
    public void InvertirLista(String data){
        Nodo left;
        Nodo right;
        left = cabeza;
        right = fin;
        while(left != right && left.anterior != right){
            left.informacion = data;
            right.informacion = data;
            left = left.siguiente;
            right = right.anterior;
        }
    }
    
     public void reverseDLL( ) {
         Nodo left = cabeza; //swap head and tail
         cabeza = fin; // head now points to tail
         fin = left; //tail points to head
         //traverse the list swapping prev and next fields of each node
         Nodo p = cabeza; //create a node and point to head

         while(p!=null) //while p does not equal null  
         { //swap prev and next of current node
             left = p.siguiente; // p.next does that not equal null? confusing.
             p.siguiente = p.anterior; //this line makes sense since you have to reverse the link
             p.anterior = left; //having trouble visualizing this.
             p=p.siguiente;//advance current node which makes sense
            }
 }
    
    /** inserta un nuevo nodo al inicio de la Lista */
    public void insertarInicio(String ndato) {
        Nodo nuevo = new Nodo();
        nuevo.informacion = ndato;
        if ( estaVacia() ) {
            cabeza = nuevo;
            fin = nuevo;
        } else {
            enlazar(nuevo, cabeza);
            cabeza = nuevo;
        }
    }
    public Nodo getFin(){
        return fin;
    }
}
