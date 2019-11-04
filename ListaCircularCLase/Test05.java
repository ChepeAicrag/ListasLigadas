
/**
 * Eliminando un elemento que no existe
 */
public class Test05
{
    public static void main(){
        ListaCircular Lista = new ListaCircular();
        Lista.InsertarPrimero("a");
        Lista.InsertarPrimero("b");
        Lista.InsertarPrimero("c");
        Lista.InsertarPrimero("d");
        Lista.ImprimirLista(Lista.getHead());
        
        StdOut.println("Eliminando al elemento \" e \"");
        
        Lista.ImprimirLista(Lista.eliminar("e"));
    }
}
