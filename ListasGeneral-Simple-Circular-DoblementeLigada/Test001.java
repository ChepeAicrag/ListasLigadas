
/**
 * Prueba del metodo buscar en las 3 listas
 */
public class Test001
{
   public static void main()throws Exception{
       ListaCircular<SuperHeroe> listaCircular = new ListaCircular();
       ListaDoblementeEnlazada<SuperHeroe> listaSimpleDoble = new ListaDoblementeEnlazada();
       LinkedListPlusRecursividadGenerico<SuperHeroe> listaSimple = new LinkedListPlusRecursividadGenerico();
       Archivito.LlenarArchivo("Heroes");
       Archivito.LeerArchivo(listaCircular,"Heroes");
       Archivito.LeerArchivo(listaSimpleDoble,"Heroes");
       Archivito.LeerArchivo(listaSimple,"Heroes");
       
       SuperHeroe demon       = new SuperHeroe("Demon","Atributos físicos y poderes sensoriales sobrehumanos,Capacidad de regeneración, Poderes mágicos,Precognición,Telepatía,Inmortalidad,Puede lanzar llamas de fuego místico,Vuelo",
       'H',"Convive en un mismo cuerpo","Jack Kirby","Jason Blood","Gotham City","The Demon","Liga de la Justicia Oscura","Demonio",1972); 
        
       StdOut.println("La cabeza de la lista Circular es " +listaCircular.getCabeza().getInformacion());
       StdOut.println("La cabeza de la lista Simple es " +listaSimple.getCabeza().getInformacion());
       StdOut.println("La cabeza de la lista SimpleDoble " +listaSimpleDoble.getCabeza().getInformacion());
       
    }
}
