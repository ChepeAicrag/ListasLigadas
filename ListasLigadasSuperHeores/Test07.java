
/**
 * Test de los metodos combinados de origen y otro tal
 */
public class Test07
{
   public static void main()throws Exception{
       LinkedListPlusRecursividadGenerico <SuperHeroe >lista = new LinkedListPlusRecursividadGenerico();
       CreacionSuperHeroes.llenarSuperHeroes(lista); //A la lista de parametro le agregamos todos los superheroes
       
       /**Muestra el archivo*/
       Archivo.LeerArchivo("SuperHeroesContenido"); // Mostramos el archivo
       
       /**Test de los metodos */
           
       StdOut.println("\n\" Origen : Tierra-11 : y aparece en el comic Miracle Monday\"");
        lista.listaOrigenYComicTal("Tierra-11","Miracle Monday").imprimirNormal();
       
       StdOut.println("\n\" Origen : Tierra-11 : y afiliado a Liga de la Justicia Oscura\"");
        lista.listaOrigenYAfiliacionTal("Tierra-11","Liga de la Justicia Oscura").imprimirNormal();
       
       StdOut.println("\n\" Origen : Tierra-11 : y es un Demonio\"");
        lista.listaOrigenYRazaTal("Tierra-11","Demonio").imprimirNormal();
        
   }
}
