
/**
 * Prueba eliminando la cabeza
 */
public class Test01
{
    public static void main(){
        ListaCircular Lista = new ListaCircular();
        Lista.InsertarPrimero("a");
        Lista.InsertarPrimero("b");
        Lista.InsertarPrimero("c");
        Lista.InsertarPrimero("d");
        Lista.ImprimirLista(Lista.getHead());
        
        StdOut.println("Eliminando a la cabeza " + Lista.getInfoNode(Lista.getHead()));
        
        Lista.ImprimirLista(Lista.eliminar("d"));
    }
}
