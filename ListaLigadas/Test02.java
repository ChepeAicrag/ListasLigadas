
/**
 * Write a description of class Test02 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test02
{
   public static void main(){
     LinkedListPlusRecursividadGenerico <String> lista = new LinkedListPlusRecursividadGenerico();
     String agregar = "Hola...Esto es una prueba";
     for(int i = 0; i < agregar.length(); i++)
        lista.insertarPrimero("" + agregar.charAt(i));
     
     StdOut.println("Mostrando lista orginal...");   
     lista.imprimirNormal();
     StdOut.println("\nMostrando lista inversa...");
     lista.imprimirInversa();
     StdOut.println("\nEliminando la letra H...");
     lista.Eliminar("H");
     StdOut.println("\nMostrando lista orginal nueva...");
     lista.imprimirNormal();
     StdOut.println("\nMostrando lista inversa nueva...");
     lista.imprimirInversa();
     
    }
}
