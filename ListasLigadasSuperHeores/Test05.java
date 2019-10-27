
/**
 * Test de los metodos combinados de año y otro tal
 */
public class Test05
{
    public static void main()throws Exception{
       LinkedListPlusRecursividadGenerico <SuperHeroe >lista = new LinkedListPlusRecursividadGenerico();
       Archivo.LeerArchivo(lista,"SuperHeroesContenido"); // Mostramos el archivo
       
       /**Test de los metodos */
           
       StdOut.println("\n\" Aparecion en el año : 1962 : y su creador es Phil Jimenez\"");
        lista.listaAñoAparicionYAutorTal(1962,"Phil Jimenez").imprimirNormal();
        
       StdOut.println("\n\" Aparecion en el año : 1962 : y su origen es Gotham City\"");
        lista.listaAñoAparicionYOrigenTal(1962,"Gotham City").imprimirNormal();
       
       StdOut.println("\n\" Aparecion en el año : 1962 : y aparece en el comic Miracle Monday\"");
        lista.listaAñoAparicionYComicTal(1962,"Miracle Monday").imprimirNormal();
       
       StdOut.println("\n\" Aparecion en el año : 1974 : y afiliado a Liga de la Justicia Oscura\"");
        lista.listaAñoAparicionYAfiliacionTal(1974,"Liga de la Justicia Oscura").imprimirNormal();
       
       StdOut.println("\n\" Aparecion en el año : 1962 : y es un Demonio\"");
        lista.listaAñoAparicionYRazaTal(1962,"Demonio").imprimirNormal();
        
   }
}
