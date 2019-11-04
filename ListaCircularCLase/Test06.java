
/**
 * Prueba eliminando 2 veces al mismo elemento
 */
public class Test06
{
    public static void main(){
        ListaCircular Lista = new ListaCircular();
        Lista.InsertarPrimero("a");
        Lista.InsertarPrimero("b");
        Lista.InsertarPrimero("c");
        Lista.InsertarPrimero("d");
        Lista.ImprimirLista(Lista.getHead());
        
        StdOut.println("Eliminando al elemento \" b \" ");
        Lista.ImprimirLista(Lista.eliminar("b"));
        
         StdOut.println("Voliendo a eliminar al elemento \" b \"");
        Lista.ImprimirLista(Lista.eliminar("b"));
    }
}
