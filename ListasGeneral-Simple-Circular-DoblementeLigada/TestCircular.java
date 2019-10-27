
/**
 * Write a description of class TestCircular here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCircular
{
     public static void main()throws Exception{
        ListaCircular lista = new ListaCircular();
        Archivito.LlenarArchivo("superheroes");
        Archivito.LeerArchivo(lista,"superheroes");
        StdOut.println("\nLa cabeza es " + lista.getInfoNodo(lista.getCabeza()));
        StdOut.println("La cola es " + lista.getInfoNodo(lista.getFin()));
        
        SuperHeroe demon       = new SuperHeroe("Demon","Atributos físicos y poderes sensoriales sobrehumanos,Capacidad de regeneración, Poderes mágicos,Precognición,Telepatía,Inmortalidad,Puede lanzar llamas de fuego místico,Vuelo",
        'H',"Convive en un mismo cuerpo","Jack Kirby","Jason Blood","Gotham City","The Demon","Liga de la Justicia Oscura","Demonio",1972); 
        
        lista.mostrarLista();
        lista.Eliminar(demon);
        StdOut.println("Lista despues de eliminar a demon...\n");
        lista.mostrarLista();
        //lista.Eliminar(demon);
        StdOut.println("\nLa cabeza es " + lista.getInfoNodo(lista.getCabeza()));
        StdOut.println("La cola es " + lista.getInfoNodo(lista.getFin()));
        StdOut.println("Demon está despues de " + lista.getInfoNodo(lista.AntesDe(demon))); 
    }
}
