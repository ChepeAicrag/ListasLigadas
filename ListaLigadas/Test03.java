
public class Test03
{
    public static void main(){
     
     LinkedListPlusRecursividadGenerico <String> lista = new LinkedListPlusRecursividadGenerico();
     String agregar = "a b c";
     for(int i = 0; i < agregar.length(); i++)
        lista.insertarPrimero("" + agregar.charAt(i));
     
     StdOut.println("Mostrando lista orginal...");   
     lista.imprimirNormal();
     StdOut.println("\nMostrando lista inversa...");
     lista.imprimirInversa();
     StdOut.println("\nBuscando antes de \"c\" " + lista.getInfo(lista.BuscarAntesDe("c")));
     
     /**Prueba eliminando la raiz actual*/
     
     lista.Eliminar("c");
     
     /**Lista modificada*/
     
     StdOut.println("Mostrando lista orginal...");   
     lista.imprimirNormal();
     StdOut.println("\nMostrando lista inversa...");
     lista.imprimirInversa();
     
    }
}