
/**
 * Test de los metodos combinados de comic y otro tal
 */
public class Test08
{
   public static void main()throws Exception{
       LinkedListPlusRecursividadGenerico <SuperHeroe >lista = new LinkedListPlusRecursividadGenerico();
       CreacionSuperHeroes.llenarSuperHeroes(lista); //A la lista de parametro le agregamos todos los superheroes
       
       /**Muestra el archivo*/
       Archivo.LeerArchivo("SuperHeroesContenido"); // Mostramos el archivo
       
       /**Test de los metodos */
           
       StdOut.println("\n\" aparece en el comic  : Miracle Monday : y afiliado a Liga de la Justicia\"");
        lista.listaComicYAfiliacionTal("Miracle Monday","Liga de la Justicia").imprimirNormal();
       
       StdOut.println("\n\" aparece en el comic  : Miracle Monday : y es un Demonio\"");
        lista.listaComicYRazaTal("Miracle Monday","Demonio").imprimirNormal();
        
   }
}
