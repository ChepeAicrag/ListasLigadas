
/**
 * Verificar que las listas trabajan con el mismo archivo
 */
public class Test06
{
    public static void main()throws Exception{
       ListaCircular<SuperHeroe> listaCircular = new ListaCircular();
       ListaDoblementeEnlazada<SuperHeroe> listaSimpleDoble = new ListaDoblementeEnlazada();
       LinkedListPlusRecursividadGenerico<SuperHeroe> listaSimple = new LinkedListPlusRecursividadGenerico();
       Archivito.LeerArchivo(listaCircular,"SuperHeroes");
       listaSimpleDoble.LlenarListaDesdeArchivo("SuperHeroes");
       listaSimple.LlenarListaDesdeArchivo("SuperHeroes");
       
       StdOut.println("\n\nLa cabeza de la lista Circular es " +listaCircular.getCabeza().getInformacion());
       StdOut.println("\n\nLa cabeza de la lista Simple es " +listaSimple.getCabeza().getInformacion());
       StdOut.println("\n\nLa cabeza de la lista SimpleDoble " +listaSimpleDoble.getCabeza().getInformacion());
    }
}