
public class CalandoEliminar
{
    public static void main(){
        ListaCircular lista = new ListaCircular();
        lista.InsertarPrimero("a");
        lista.InsertarPrimero("b");
        lista.InsertarPrimero("c");
        lista.InsertarPrimero("d");
        lista.InsertarPrimero("e");
        lista.RecorrerLista();
        StdOut.println("Ahora la cabeza es : " + lista.getInfoNode(lista.eliminar("e")));
        lista.ImprimirLista();
        StdOut.println("Ahora la cabeza es : " + lista.getInfoNode(lista.eliminar("a")));
        lista.ImprimirLista();
    }
}
