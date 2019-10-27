
/**
 * Write a description of class Test01 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test01
{
    public static void main()throws Exception{
        ListaCircular lista = new ListaCircular();
        Archivito.LlenarArchivo("superheroes");
        Archivito.LeerArchivo(lista,"superheroes");
        StdOut.println("\nLa cabeza es " + lista.getInfoNode(lista.getHead()));
        StdOut.println("La cola es " + lista.getInfoNode(lista.getTail()));
        
        SuperHeroe demon       = new SuperHeroe("Demon","Atributos físicos y poderes sensoriales sobrehumanos,Capacidad de regeneración, Poderes mágicos,Precognición,Telepatía,Inmortalidad,Puede lanzar llamas de fuego místico,Vuelo",
        'H',"Convive en un mismo cuerpo","Jack Kirby","Jason Blood","Gotham City","The Demon","Liga de la Justicia Oscura","Demonio",1972); 
        
        lista.ImprimirLista();
        lista.EliminarInicio();
        StdOut.println("Lista despues de eliminar al primero...\n");
        lista.ImprimirLista();
        StdOut.println("Demon está despues de " + lista.getInfoNode(lista.AntesDe(demon))); 
    }
}
