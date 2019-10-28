
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
        'H',"Jack Kirby","Jason Blood","Gotham City","The Demon","Liga de la Justicia Oscura","Demonio",1972); 
         
         SuperHeroe superwoman2  = new SuperHeroe("Superwoman2","Capacidad de regeneración,Transformar energia,Absorción de Energía Solar,Super Fuerza,Invulnerabilidad,Super Velocidad,Vuelo,Visión de Calor,Visión Aumentada",
        'M',"Phil Jimenez","Lois Lane,Luma Lynai,Diana (Tierra-3),Kristin Wells,Dana Dearden,Lucy Lane,Lana Lang","Tierra-11",
        "Action Comics,Justice League of America,Miracle Monday,Adventures of Superman,Supergirl,Superwoman","Liga de la Justicia","Superhumana",1943,1962,1964,2009,2016);
        
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
