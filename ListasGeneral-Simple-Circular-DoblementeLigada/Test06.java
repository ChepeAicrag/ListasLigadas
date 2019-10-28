/**
 * Test de los metodos combinados de autor y otro tal
 */
public class Test06
{
   public static void main()throws Exception{
       LinkedListPlusRecursividadGenerico <SuperHeroe >Lista = new LinkedListPlusRecursividadGenerico();
       Archivito.LeerArchivo(Lista,"Heroes"); 
       Lista.mostrarLista();     
       StdOut.println("\n\n\" Creador : Phil Jimenez : y su origen es Gotham City\"");
        Lista.ListaAutorYOrigenTal("Phil Jimenez","Gotham City").mostrarLista();
       
       StdOut.println("\n\" Creador : Phil Jimenez : y  aparece en el comic Miracle Monday\"");
        Lista.ListaAutorYComicTal("Phil Jimenez","Miracle Monday").mostrarLista();
       
       StdOut.println("\n\" Creador : Phil Jimenez : y  afiliado a Liga de la Justicia Oscura\"");
        Lista.ListaAutorYAfiliacionTal("Phil Jimenez","Liga de la Justicia Oscura").mostrarLista();
       
       StdOut.println("\n\" Creador : Phil Jimenez : y  es un Demonio\"");
        Lista.ListaAutorYRazaTal("Phil Jimenez","Demonio").mostrarLista();
        
   }
}

