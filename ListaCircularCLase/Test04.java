
/**
 * Prueba eliminado a otro de en medio
 */
public class Test04
{
    public static void main(){
        ListaCircular Lista = new ListaCircular();
        Lista.InsertarPrimero("a");
        Lista.InsertarPrimero("b");
        Lista.InsertarPrimero("c");
        Lista.InsertarPrimero("d");
        Lista.ImprimirLista(Lista.getHead());
        
        StdOut.println("Eliminando al elemento \" c \"");
        
        Lista.ImprimirLista(Lista.eliminar("c"));
    }
}
