
/**
 * Write a description of class Test04 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test04
{
   public static void main()throws Exception{
       LinkedListPlusRecursividadGenerico <SuperHeroe >lista = new LinkedListPlusRecursividadGenerico();
       CreacionSuperHeroes.llenarSuperHeroes(lista); //A la lista de parametro le agregamos todos los superheroes
       
       /**Muestra el archivo*/
       Archivo.LeerArchivo("SuperHeroesContenido"); // Mostramos el archivo
       
       /**Test de los metodos */
           
       StdOut.println("\n\" Son hombre y tiene el poder Capacidad de regeneración\"");
        lista.listaSexoYPoderTal('H',"Capacidad de regeneración").imprimirNormal();
        
       StdOut.println("\n\" Son mujer y tiene el poder Capacidad de regeneración\"");
        lista.listaSexoYPoderTal('M',"Capacidad de regeneración").imprimirNormal(); 
   }
}
