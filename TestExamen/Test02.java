
/**
 * Write a description of class Test02 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test02
{
    public static void main(String[] args){
        ListaDoble lista2 = new ListaDoble();
        lista2.insertarFinal("a");
        lista2.insertarFinal("b");
        lista2.insertarFinal("c");
        lista2.mostrar();
        StdOut.println("\n\n Eliminando a " + lista2.getCabeza());
        lista2.eliminarIncio();
        lista2.mostrar();
        StdOut.println("\n\n Eliminando a " + lista2.getFin());
        lista2.eliminarFinal();
        lista2.mostrar();
    }
}
