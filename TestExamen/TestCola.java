
/**
 * Write a description of class TestCola here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCola
{
    public static void main(){
        Cola cola = new Cola();
        cola.enqueue("a");
        cola.enqueue("b");
        cola.enqueue("c");
        cola.enqueue("d");
        cola.mostrar();
        StdOut.println("Clonando la cola");
        Cola clon = cola.clonar();
        clon.mostrar();
        StdOut.println("Cambiando a \" a \" por \" b \"");
        cola.modificar("a","b");
        cola.mostrar();
        StdOut.println("Inviertiendo la cola");
        cola.invertir();
        cola.mostrar();
    }
}
