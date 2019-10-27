
/**
 * Test de buscar, antes de , despues de 
 */
public class Test01
{
  public static void main()throws Exception{
       LinkedListPlusRecursividadGenerico <SuperHeroe >lista = new LinkedListPlusRecursividadGenerico();
       Archivo.LeerArchivo(lista,"SuperHeroesContenido"); // Mostramos el archivo
       
         /**Test de los metodos */
        
         SuperHeroe demon       = new SuperHeroe("Demon","Atributos físicos y poderes sensoriales sobrehumanos,Capacidad de regeneración, Poderes mágicos,Precognición,Telepatía,Inmortalidad,Puede lanzar llamas de fuego místico,Vuelo",
        'H',"Convive en un mismo cuerpo","Jack Kirby","Jason Blood","Gotham City","The Demon","Liga de la Justicia Oscura","Demonio",1972); 
         
         SuperHeroe superwoman2  = new SuperHeroe("Superwoman2","Capacidad de regeneración,Transformar energia,Absorción de Energía Solar,Super Fuerza,Invulnerabilidad,Super Velocidad,Vuelo,Visión de Calor,Visión Aumentada",
        'M',"","Phil Jimenez","Lois Lane,Luma Lynai,Diana (Tierra-3),Kristin Wells,Dana Dearden,Lucy Lane,Lana Lang","Tierra-11",
        "Action Comics,Justice League of America,Miracle Monday,Adventures of Superman,Supergirl,Superwoman","Liga de la Justicia","Superhumana",1943,1962,1964,2009,2016);
        
        
       StdOut.println("\n\" Demon \" está despues de  " 
                        + lista.AntesDeInfo(demon));
       
       StdOut.println("\n\" Superwoman2 \" está despues de  " 
                        + lista.AntesDeInfo(superwoman2));
                        
       StdOut.println("\n\" Demon \" está antes de  " 
                        + lista.DespuesDeInfo(demon));
       
       StdOut.println("\n\" Primero \" es  " 
                        + lista.getInfo(lista.getRaiz()));
                        
       StdOut.println("\n\" Ultimo \" es  " 
                        + lista.getInfo(lista.BuscarUltimo()));
                        
       StdOut.println("\n\" Demon \" aparece en la lista  " 
                        + lista.getInfo(lista.Buscar(demon)));
                        
       StdOut.println("\n\" Null \" aparece en la lista  " 
                        + lista.Buscar(null));
     }
}
