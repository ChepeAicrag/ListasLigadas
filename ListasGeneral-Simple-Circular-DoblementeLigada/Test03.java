
/**
 * Test de los metodos combinados de sexo y otro tal
 */
public class Test03
{
    public static void main()throws Exception{
        LinkedListPlusRecursividadGenerico <SuperHeroe >Lista = new LinkedListPlusRecursividadGenerico();
        /**Test de los metodos */
        Archivito.LeerArchivo(Lista,"Heroes"); 
         
       StdOut.println("\n\" Son hombre y tiene el poder Capacidad de regeneración\"");
        Lista.ListaSexoYPoderTal('H',"Capacidad de regeneración").mostrarLista();
        
       StdOut.println("\n\" Son mujer y tiene el poder Capacidad de regeneración\"");
        Lista.ListaSexoYPoderTal('M',"Capacidad de regeneración").mostrarLista(); 
        
       StdOut.println("\n\" Son hombre y aparecieron en 1962\"");
        Lista.ListaSexoYAñoAparicionTal('H',1962) .mostrarLista();
       
       StdOut.println("\n\" Son mujer y aparecieron en 1962\"");
        Lista.ListaSexoYAñoAparicionTal('M',1962) .mostrarLista();
       
       StdOut.println("\n\" Son mujer y su creado es Phil Jimenez\"");
        Lista.ListaSexoYAutorTal('M',"phiL jiMenez") .mostrarLista();
       
       StdOut.println("\n\" Son hombre y su creado es Phil Jimenez\"");
        Lista.ListaSexoYAutorTal('H',"phiL jiMenez") .mostrarLista();
        
       StdOut.println("\n\" Son mujer y su origen es Gotham City\"");
        Lista.ListaSexoYOrigenTal('M',"Gotham City") .mostrarLista();
        
       StdOut.println("\n\" Son hombre y su origen es Gotham City\"");
        Lista.ListaSexoYOrigenTal('H',"Gotham City") .mostrarLista();
       
       StdOut.println("\n\" Son mujer y aparecen en el comic Adventures of Superman\"");
        Lista.ListaSexoYComicTal('M',"Adventures of Superman") .mostrarLista();
       
       StdOut.println("\n\" Son hombre y aparecen en el comic Adventures of Superman\"");
        Lista.ListaSexoYComicTal('H',"Adventures of Superman") .mostrarLista();
       
       StdOut.println("\n\" Son mujer y pertenecen a la liga Liga de la Justicia Oscura\"");
        Lista.ListaSexoYAfiliacionTal('M',"Liga de la Justicia Oscura") .mostrarLista();
       
       StdOut.println("\n\" Son hombre y pertenecen a la liga Liga de la Justicia Oscura\"");
        Lista.ListaSexoYAfiliacionTal('H',"Liga de la Justicia Oscura") .mostrarLista();
       
       StdOut.println("\n\" Son mujer y su raza es superhumana\"");
        Lista.ListaSexoYRazaTal('M',"Superhumana") .mostrarLista();
       
       StdOut.println("\n\" Son hombre y su raza es superhumana\"");
        Lista.ListaSexoYRazaTal('H',"Superhumana") .mostrarLista();
        
    }
}
