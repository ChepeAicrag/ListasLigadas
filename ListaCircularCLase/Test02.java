
/**
 * Prueba eliminando la cola
 */
public class Test02
{
    public static void main(){
        ListaCircular Lista = new ListaCircular();
        Lista.InsertarPrimero("a");
        Lista.InsertarPrimero("b");
        Lista.InsertarPrimero("c");
        Lista.InsertarPrimero("d");
        Lista.ImprimirLista(Lista.getHead());
        
        StdOut.println("Eliminando a la cola \" ");
        
        Lista.ImprimirLista(Lista.eliminar(Lista.getInfoNode(Lista.getTail())));
    
    }
}
