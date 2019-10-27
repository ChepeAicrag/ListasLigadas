
/**
 * Write a description of class Test02 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test02
{
   public static void main()throws Exception{
       ListaCircular <SuperHeroe >lista = new ListaCircular();
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
        
        StdOut.println("\n\" Demon \" está despues de  " 
                        + lista.getInfoNode(lista.AntesDe(demon)));
       
       StdOut.println("\n\" Superwoman2 \" está despues de  " 
                        + lista.getInfoNode(lista.AntesDe(superwoman2)));
                                          
       StdOut.println("\n\" Demon \" está antes de  " 
            + lista.getInfoNode(lista.DespuesDe(demon)));
       
       StdOut.println("\n\" Primero \" es  " 
                        + lista.getInfoNode(lista.getHead()));
                        
       StdOut.println("\n\" Ultimo \" es  " 
                        + lista.getInfoNode(lista.getTail()));
                        
       StdOut.println("\n\" Demon \" aparece en la lista  " 
                        + ((lista.Buscar(demon) != null) ? "Si aparece": "No se encuentra"));
                        
       StdOut.println("\n\" Superwoman2 \" aparece en la lista  " 
                        + ((lista.Buscar(superwoman2) != null) ? "Si aparece": "No se encuentra"));
       
       SuperHeroe demon2       = new SuperHeroe("Demon2","Atributos físicos y poderes sensoriales sobrehumanos,Capacidad de regeneración, Poderes mágicos,Precognición,Telepatía,Inmortalidad,Puede lanzar llamas de fuego místico,Vuelo",
        'H',"Convive en un mismo cuerpo","Jack Kirby","Jason Blood","Gotham City","The Demon","Liga de la Justicia Oscura","Demonio",1972); 
                         
       StdOut.println("\n\" demon2 \" aparece en la lista  " 
                        + ((lista.Buscar(demon2) != null) ? "Si aparece": "No se encuentra"));
                        
   }
}
