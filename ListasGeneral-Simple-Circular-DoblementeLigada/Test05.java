
/**
 * Test de los metodos combinados de año y otro tal
 */
public class Test05
{
    public static void main()throws Exception{
       LinkedListPlusRecursividadGenerico <SuperHeroe >Lista = new LinkedListPlusRecursividadGenerico();
       Archivito.LeerArchivo(Lista,"Heroes"); 
        
       /**Test de los metodos */
           
       StdOut.println("\n\" Aparecion en el año : 1962 : y su creador es Phil Jimenez\"");
        Lista.ListaAñoAparicionYAutorTal(1962,"Phil Jimenez").mostrarLista();
        
       StdOut.println("\n\" Aparecion en el año : 1962 : y su origen es Gotham City\"");
        Lista.ListaAñoAparicionYOrigenTal(1962,"Gotham City").mostrarLista();
       
       StdOut.println("\n\" Aparecion en el año : 1962 : y aparece en el comic Miracle Monday\"");
        Lista.ListaAñoAparicionYComicTal(1962,"Miracle Monday").mostrarLista();
       
       StdOut.println("\n\" Aparecion en el año : 1974 : y afiliado a Liga de la Justicia Oscura\"");
        Lista.ListaAñoAparicionYAfiliacionTal(1974,"Liga de la Justicia Oscura").mostrarLista();
       
       StdOut.println("\n\" Aparecion en el año : 1962 : y es un Demonio\"");
        Lista.ListaAñoAparicionYRazaTal(1962,"Demonio").mostrarLista();
        
   }
}
