
/**
 * Test de los metodos combinados de comic y otro tal
 */
public class Test08
{
   public static void main(String[]args)throws Exception{
       LinkedListPlusRecursividadGenerico <SuperHeroe >lista = new LinkedListPlusRecursividadGenerico();
       lista.LlenarListaDesdeArchivo("SuperHeroes"); 
           
       StdOut.println("\n\" aparece en el comic  : Miracle Monday : y afiliado a Liga de la Justicia\"");
        lista.ListaComicYAfiliacionTal("Miracle Monday","Liga de la Justicia").mostrarLista();
       
       StdOut.println("\n\" aparece en el comic  : Miracle Monday : y es un Demonio\"");
        lista.ListaComicYRazaTal("Miracle Monday","Demonio").mostrarLista();
        
   }
}
