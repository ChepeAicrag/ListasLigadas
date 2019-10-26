/**
 * Test de los metodos combinados de autor y otro tal
 */
public class Test06
{
   public static void main()throws Exception{
       LinkedListPlusRecursividadGenerico <SuperHeroe >lista = new LinkedListPlusRecursividadGenerico();
       CreacionSuperHeroes.llenarSuperHeroes(lista); //A la lista de parametro le agregamos todos los superheroes
       
       /**Muestra el archivo*/
       Archivo.LeerArchivo("SuperHeroesContenido"); // Mostramos el archivo
       
       /**Test de los metodos */
           
       StdOut.println("\n\" Creador : Phil Jimenez : y su origen es Gotham City\"");
        lista.listaAutorYOrigenTal("Phil Jimenez","Gotham City").imprimirNormal();
       
       StdOut.println("\n\" Creador : Phil Jimenez : y  aparece en el comic Miracle Monday\"");
        lista.listaAutorYComicTal("Phil Jimenez","Miracle Monday").imprimirNormal();
       
       StdOut.println("\n\" Creador : Phil Jimenez : y  afiliado a Liga de la Justicia Oscura\"");
        lista.listaAutorYAfiliacionTal("Phil Jimenez","Liga de la Justicia Oscura").imprimirNormal();
       
       StdOut.println("\n\" Creador : Phil Jimenez : y  es un Demonio\"");
        lista.listaAutorYRazaTal("Phil Jimenez","Demonio").imprimirNormal();
        
   }
}

