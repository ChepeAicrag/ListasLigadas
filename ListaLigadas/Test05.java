public class Test05
{
     public static void main(){
     
     LinkedListPlusRecursividadGenerico <String> lista = new LinkedListPlusRecursividadGenerico();
     String agregar = "ax b c";
     for(int i = 0; i < agregar.length(); i++)
        lista.insertarPrimero("" + agregar.charAt(i));
     
     StdOut.println("Mostrando lista orginal...");   
     lista.imprimirNormal();
     StdOut.println("\nMostrando lista inversa...");
     lista.imprimirInversa();
     StdOut.println("\nBuscando antes de \"a\" " + lista.getInfo(lista.BuscarAntesDe("a")));
     StdOut.println("\nEliminando al \"a\"...");
     lista.Eliminar("a");
     StdOut.println("Mostrando lista orginal...");   
     lista.imprimirNormal();
     StdOut.println("\nMostrando lista inversa...");
     lista.imprimirInversa();
     
    }
}
