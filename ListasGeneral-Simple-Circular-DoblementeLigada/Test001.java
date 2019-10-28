
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
        'H',"Jack Kirby","Jason Blood","Gotham City","The Demon","Liga de la Justicia Oscura","Demonio",1972); 
         
         SuperHeroe superwoman2  = new SuperHeroe("Superwoman2","Capacidad de regeneración,Transformar energia,Absorción de Energía Solar,Super Fuerza,Invulnerabilidad,Super Velocidad,Vuelo,Visión de Calor,Visión Aumentada",
        'M',"Phil Jimenez","Lois Lane,Luma Lynai,Diana (Tierra-3),Kristin Wells,Dana Dearden,Lucy Lane,Lana Lang","Tierra-11",
        "Action Comics,Justice League of America,Miracle Monday,Adventures of Superman,Supergirl,Superwoman","Liga de la Justicia","Superhumana",1943,1962,1964,2009,2016);
        
       StdOut.println("La cabeza de la lista Circular es " +listaCircular.getCabeza().getInformacion());
       StdOut.println("La cabeza de la lista Simple es " +listaSimple.getCabeza().getInformacion());
       StdOut.println("La cabeza de la lista SimpleDoble " +listaSimpleDoble.getCabeza().getInformacion());
       
    }
}
