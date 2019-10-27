
/**
 * Test de los metodos combinados de poder y otro tal
 */
public class Test04
{
   public static void main()throws Exception{
       LinkedListPlusRecursividadGenerico <SuperHeroe >Lista = new LinkedListPlusRecursividadGenerico();
       Archivito.LeerArchivo(Lista,"Heroes"); 
        
       /**Test de los metodos */
           
       StdOut.println("\n\" Tiene poder : Capacidad de regeneración :  y aparece en el año 1962\"");
        Lista.ListaPoderYAñoAparicionTal("Capacidad de regeneración",1962).mostrarLista();
        
       StdOut.println("\n\" Tiene poder : Capacidad de regeneración : y su creador es Phil Jimenez\"");
        Lista.ListaPoderYAutorTal("Capacidad de regeneración","Phil Jimenez").mostrarLista();
        
       StdOut.println("\n\" Tiene poder : Capacidad de regeneración :  y es de origen Gotham City\"");
        Lista.ListaPoderYOrigenTal("Capacidad de regeneración","Gotham City").mostrarLista();
       
       StdOut.println("\n\" Tiene poder : Capacidad de regeneración :  y aparece en el comic Miracle Monday\"");
        Lista.ListaPoderYComicTal("Capacidad de regeneración","Miracle Monday").mostrarLista();
       
       StdOut.println("\n\" Tiene poder : Capacidad de regeneración :  y afiliado a Liga de la Justicia Oscura\"");
        Lista.ListaPoderYAfiliacionTal("Capacidad de regeneración","Liga de la Justicia Oscura").mostrarLista();
       
       StdOut.println("\n\" Tiene poder : Capacidad de regeneración :  y es un Demonio\"");
        Lista.ListaPoderYRazaTal("Capacidad de regeneración","Demonio").mostrarLista();
        
   }
}
