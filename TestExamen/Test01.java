
/**
 * Write a description of class Test01 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test01
{
   public static void main(){
       ListaSimple lista = new ListaSimple();
       lista.insertarInicio("a");
       lista.insertarInicio("b");
       lista.insertarInicio("c");
       lista.mostrar();
       
       StdOut.println("\nBuscando a \" d \"");
       StdOut.println(lista.infoNodo(lista.buscar("d")));
       StdOut.println("\nBuscando antes de  \" d \"");
       StdOut.println(lista.infoNodo(lista.antesDe("d")));
       StdOut.println("\nBuscando despues de  \" b \"");
       StdOut.println(lista.infoNodo(lista.despuesDe("b")));
       StdOut.println("\nEliminar a la cabeza");
       lista.eliminarInicio();
       lista.mostrar();
       StdOut.println("\nEliminar al final");
       lista.eliminarFinal();
       lista.mostrar();
       
       ListaSimple lista2 = new ListaSimple();
       StdOut.println("\n\n");
       lista2.insertarFinal("a");
       lista2.insertarFinal("b");
       lista2.insertarFinal("c");
       lista2.mostrar();
       StdOut.println("\nEliminar a la cabeza");
       lista2.eliminar("a");
       lista2.mostrar();
       /*StdOut.println("\nEliminar al final");
       lista2.eliminar("c");
       lista2.mostrar();*/
       StdOut.println("\nEliminar a \" b \"");
       lista2.eliminar("b");
       lista2.mostrar();
       
       
    }
}
