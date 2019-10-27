
/**
 * Write a description of class TestEliminar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestEliminar
{
    public static void main()throws Exception{
    ListaDoblementeEnlazada <SuperHeroe >lista = new ListaDoblementeEnlazada();
       Archivito.LlenarArchivo("SuperHeroesContenido"); //A la lista de parametro le agregamos todos los superheroes
       //lista.LlenarListaDesdeArchivo("SuperHeroesContenido");
       /**Muestra el archivo*/
       Archivito.LeerArchivo(lista,"SuperHeroesContenido"); // Mostramos el archivo
       
         /**Test de los metodos */
        
         SuperHeroe demon       = new SuperHeroe("Demon","Atributos físicos y poderes sensoriales sobrehumanos,Capacidad de regeneración, Poderes mágicos,Precognición,Telepatía,Inmortalidad,Puede lanzar llamas de fuego místico,Vuelo",
        'H',"Convive en un mismo cuerpo","Jack Kirby","Jason Blood","Gotham City","The Demon","Liga de la Justicia Oscura","Demonio",1972); 
         
         SuperHeroe superwoman2  = new SuperHeroe("Superwoman2","Capacidad de regeneración,Transformar energia,Absorción de Energía Solar,Super Fuerza,Invulnerabilidad,Super Velocidad,Vuelo,Visión de Calor,Visión Aumentada",
        'M',"","Phil Jimenez","Lois Lane,Luma Lynai,Diana (Tierra-3),Kristin Wells,Dana Dearden,Lucy Lane,Lana Lang","Tierra-11",
        "Action Comics,Justice League of America,Miracle Monday,Adventures of Superman,Supergirl,Superwoman","Liga de la Justicia","Superhumana",1943,1962,1964,2009,2016);
         
         SuperHeroe demon2       = new SuperHeroe("Demon2","Atributos físicos y poderes sensoriales sobrehumanos,Capacidad de regeneración, Poderes mágicos,Precognición,Telepatía,Inmortalidad,Puede lanzar llamas de fuego místico,Vuelo",
         'H',"Convive en un mismo cuerpo","Jack Kirby","Jason Blood","Gotham City","The Demon","Liga de la Justicia Oscura","Demonio",1972); 
        
        
       StdOut.println("\n\" Primero \" es  " 
                        + lista.getInfo(lista.getCabeza()));
                        
       StdOut.println("\n\" Ultimo \" es  " 
                        + lista.getInfo(lista.getFin()));
       lista.MostrarLista();
       
       lista.Eliminar(demon2);
       StdOut.println("\n Quitando a \" demon2 \" la lista quedan\n");
       lista.MostrarLista();
       
    }
}
