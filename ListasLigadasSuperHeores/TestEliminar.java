
/**
 * Write a description of class TestEliminar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestEliminar
{
    public static void main() throws Exception{
        //Capacidad de regeneración
       LinkedListPlusRecursividadGenerico <SuperHeroe >lista = new LinkedListPlusRecursividadGenerico();
       Archivo.LeerArchivo(lista,"SuperHeroesContenido"); // Mostramos el archivo
       lista.imprimirNormal();
       StdOut.println("\nMostrando la lista eliminando a un hombre con poder Capacidad de regeneración\n");
       lista.ListaEliminandoConSexoYPoderTal('H',"Capacidad de regeneración").imprimirNormal();
    }
}
