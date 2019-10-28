
/**
 * Write a description of class MostrarLista here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MostrarLista
{
    public static void main()throws Exception{
        ListaCircular lista = new ListaCircular();
        Archivito.LlenarArchivo("superheroes");
        Archivito.LeerArchivo(lista,"superheroes");
        lista.mostrarLista();
    }
}
