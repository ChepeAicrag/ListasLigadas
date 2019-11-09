
/**
 * Write a description of class Testadasdas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Testadasdas
{
    public static void main()throws Exception{
        ListaCircular <SuperHeroe> lista = new ListaCircular();
        Archivito.LlenarArchivo("HeroesTest");
        Archivito.LeerArchivo(lista,"HeroesTest");
        //lista.mostrarLista();
         ListaCircular <SuperHeroe> listaNueva = lista.ListaEliminandoConSexoYPoderTal(lista,'H',"Capacidad de regeneración");
        listaNueva.mostrarLista();
        
    }
}
