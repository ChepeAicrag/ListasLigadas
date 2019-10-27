
/**
 * Test de los metodos combinados de comic y otro tal
 */
public class Test08
{
   public static void main()throws Exception{
       LinkedListPlusRecursividadGenerico <SuperHeroe >lista = new LinkedListPlusRecursividadGenerico();
        Archivito.LeerArchivo(lista,"Heroes"); 
           
       StdOut.println("\n\" aparece en el comic  : Miracle Monday : y afiliado a Liga de la Justicia\"");
        lista.ListaComicYAfiliacionTal("Miracle Monday","Liga de la Justicia").mostrarLista();
       
       StdOut.println("\n\" aparece en el comic  : Miracle Monday : y es un Demonio\"");
        lista.ListaComicYRazaTal("Miracle Monday","Demonio").mostrarLista();
        
   }
}
