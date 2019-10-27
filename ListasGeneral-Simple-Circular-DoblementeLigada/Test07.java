
/**
 * Test de los metodos combinados de origen y otro tal
 */
public class Test07
{
   public static void main()throws Exception{
       LinkedListPlusRecursividadGenerico <SuperHeroe >Lista = new LinkedListPlusRecursividadGenerico();
       Archivito.LeerArchivo(Lista,"Heroes"); 
        
       
       StdOut.println("\n\" Origen : Tierra-11 : y aparece en el comic Miracle Monday\"");
        Lista.ListaOrigenYComicTal("Tierra-11","Miracle Monday").mostrarLista();
       
       StdOut.println("\n\" Origen : Tierra-11 : y afiliado a Liga de la Justicia Oscura\"");
        Lista.ListaOrigenYAfiliacionTal("Tierra-11","Liga de la Justicia Oscura").mostrarLista();
       
       StdOut.println("\n\" Origen : Tierra-11 : y es un Demonio\"");
        Lista.ListaOrigenYRazaTal("Tierra-11","Demonio").mostrarLista();
        
   }
}
