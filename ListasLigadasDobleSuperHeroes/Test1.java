
/***
 * Test de el metodo impresion y busqueda, 
 * 
 */
public class Test1
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
        
        StdOut.println("\n\" Demon \" está despues de  " 
                        + lista.getInfo(lista.buscar(demon).anterior));
       
       StdOut.println("\n\" Superwoman2 \" está despues de  " 
                        + lista.getInfo(lista.buscar(superwoman2).anterior));
                        
       StdOut.println("\n\" Demon \" está antes de  " 
                        + lista.getInfo(lista.buscar(demon).siguiente));
       
       StdOut.println("\n\" Primero \" es  " 
                        + lista.getInfo(lista.getCabeza()));
                        
       StdOut.println("\n\" Ultimo \" es  " 
                        + lista.getInfo(lista.getFin()));
                        
       StdOut.println("\n\" Demon \" aparece en la lista  " 
                        + ((lista.buscar(demon) != null) ? "Si aparece": "No se encuentra"));
                        
       StdOut.println("\n\" Null \" aparece en la lista  " 
                        + ((lista.buscar(superwoman2) != null) ? "Si aparece": "No se encuentra"));
   }
}
