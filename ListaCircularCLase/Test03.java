
/**
 * Prueba eliminando a un elemento diferente a la cola y la cabeza
 */
public class Test03
{
    public static void main(){
        ListaCircular Lista = new ListaCircular();
        Lista.InsertarPrimero("a");
        Lista.InsertarPrimero("b");
        Lista.InsertarPrimero("c");
        Lista.InsertarPrimero("d");
        Lista.ImprimirLista(Lista.getHead());
        
        StdOut.println("Eliminando al elemento \" b \"");
        
        Lista.ImprimirLista(Lista.eliminar("b"));
    }
}
