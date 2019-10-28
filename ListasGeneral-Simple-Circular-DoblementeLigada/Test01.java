
/**
 * Test de buscar, antes de , despues de 
 */
public class Test01
{
  public static void main()throws Exception{
       LinkedListPlusRecursividadGenerico <SuperHeroe >lista = new LinkedListPlusRecursividadGenerico();
       /**Muestra el archivo*/
       Archivito.LeerArchivo(lista,"Heroes"); // Mostramos el archivo
       
         /**Test de los metodos */
        
          SuperHeroe demon       = new SuperHeroe("Demon","Atributos físicos y poderes sensoriales sobrehumanos,Capacidad de regeneración, Poderes mágicos,Precognición,Telepatía,Inmortalidad,Puede lanzar llamas de fuego místico,Vuelo",
        'H',"Jack Kirby","Jason Blood","Gotham City","The Demon","Liga de la Justicia Oscura","Demonio",1972); 
         
         SuperHeroe superwoman2  = new SuperHeroe("Superwoman2","Capacidad de regeneración,Transformar energia,Absorción de Energía Solar,Super Fuerza,Invulnerabilidad,Super Velocidad,Vuelo,Visión de Calor,Visión Aumentada",
        'M',"Phil Jimenez","Lois Lane,Luma Lynai,Diana (Tierra-3),Kristin Wells,Dana Dearden,Lucy Lane,Lana Lang","Tierra-11",
        "Action Comics,Justice League of America,Miracle Monday,Adventures of Superman,Supergirl,Superwoman","Liga de la Justicia","Superhumana",1943,1962,1964,2009,2016);
        
        
       StdOut.println("\n\" Demon \" está despues de  " 
                        + lista.AntesDeInfo(demon));
       
       StdOut.println("\n\" Superwoman2 \" está despues de  " 
                        + lista.AntesDeInfo(superwoman2));
                        
       StdOut.println("\n\" Demon \" está antes de  " 
                        + lista.DespuesDeInfo(demon));
       
       StdOut.println("\n\" Primero \" es  " 
                        + lista.getInfoNodo(lista.getCabeza()));
                        
       StdOut.println("\n\" Ultimo \" es  " 
                        + lista.getInfoNodo(lista.getFin()));
                        
       lista.eliminarInicio();                 
        lista.mostrarLista();

    StdOut.println("\n\" Primero \" es  " 
                        + lista.getInfoNodo(lista.getCabeza()));
                        
       StdOut.println("\n\" Ultimo \" es  " 
                        + lista.getInfoNodo(lista.getFin()));                 
                        
                        
       StdOut.println("\n\" Demon \" aparece en la lista  " 
                        + lista.getInfoNodo(lista.buscar(demon)));
                        
       StdOut.println("\n\" Null \" aparece en la lista  " 
                        + lista.buscar(null));
     }
}
