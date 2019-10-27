
/**
 * Test de los metodos combinados de poder y otro tal
 */
public class Test04
{
   public static void main()throws Exception{
       LinkedListPlusRecursividadGenerico <SuperHeroe >lista = new LinkedListPlusRecursividadGenerico();
       Archivo.LeerArchivo(lista,"SuperHeroesContenido"); // Mostramos el archivo
       
       /**Test de los metodos */
           
       StdOut.println("\n\" Tiene poder : Capacidad de regeneración :  y aparece en el año 1962\"");
        lista.listaPoderYAñoAparicionTal("Capacidad de regeneración",1962).imprimirNormal();
        
       StdOut.println("\n\" Tiene poder : Capacidad de regeneración : y su creador es Phil Jimenez\"");
        lista.listaPoderYAutorTal("Capacidad de regeneración","Phil Jimenez").imprimirNormal();
        
       StdOut.println("\n\" Tiene poder : Capacidad de regeneración :  y es de origen Gotham City\"");
        lista.listaPoderYOrigenTal("Capacidad de regeneración","Gotham City").imprimirNormal();
       
       StdOut.println("\n\" Tiene poder : Capacidad de regeneración :  y aparece en el comic Miracle Monday\"");
        lista.listaPoderYComicTal("Capacidad de regeneración","Miracle Monday").imprimirNormal();
       
       StdOut.println("\n\" Tiene poder : Capacidad de regeneración :  y afiliado a Liga de la Justicia Oscura\"");
        lista.listaPoderYAfiliacionTal("Capacidad de regeneración","Liga de la Justicia Oscura").imprimirNormal();
       
       StdOut.println("\n\" Tiene poder : Capacidad de regeneración :  y es un Demonio\"");
        lista.listaPoderYRazaTal("Capacidad de regeneración","Demonio").imprimirNormal();
        
   }
}
