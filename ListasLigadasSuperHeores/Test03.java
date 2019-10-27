
/**
 * Test de los metodos combinados de sexo y otro tal
 */
public class Test03
{
    public static void main()throws Exception{
        LinkedListPlusRecursividadGenerico <SuperHeroe >lista = new LinkedListPlusRecursividadGenerico();
        Archivo.LeerArchivo(lista,"SuperHeroesContenido"); // Mostramos el archivo
       
         /**Test de los metodos */
           
       StdOut.println("\n\" Son hombre y tiene el poder Capacidad de regeneración\"");
        lista.listaSexoYPoderTal('H',"Capacidad de regeneración").imprimirNormal();
        
       StdOut.println("\n\" Son mujer y tiene el poder Capacidad de regeneración\"");
        lista.listaSexoYPoderTal('M',"Capacidad de regeneración").imprimirNormal(); 
        
       StdOut.println("\n\" Son hombre y aparecieron en 1962\"");
        lista.listaSexoYAñoAparicionTal('H',1962) .imprimirNormal();
       
       StdOut.println("\n\" Son mujer y aparecieron en 1962\"");
        lista.listaSexoYAñoAparicionTal('M',1962) .imprimirNormal();
       
       StdOut.println("\n\" Son mujer y su creado es Phil Jimenez\"");
        lista.listaSexoYAutorTal('M',"phiL jiMenez") .imprimirNormal();
       
       StdOut.println("\n\" Son hombre y su creado es Phil Jimenez\"");
        lista.listaSexoYAutorTal('H',"phiL jiMenez") .imprimirNormal();
        
       StdOut.println("\n\" Son mujer y su origen es Gotham City\"");
        lista.listaSexoYOrigenTal('M',"Gotham City") .imprimirNormal();
        
       StdOut.println("\n\" Son hombre y su origen es Gotham City\"");
        lista.listaSexoYOrigenTal('H',"Gotham City") .imprimirNormal();
       
       StdOut.println("\n\" Son mujer y aparecen en el comic Adventures of Superman\"");
        lista.listaSexoYComicTal('M',"Adventures of Superman") .imprimirNormal();
       
       StdOut.println("\n\" Son hombre y aparecen en el comic Adventures of Superman\"");
        lista.listaSexoYComicTal('H',"Adventures of Superman") .imprimirNormal();
       
       StdOut.println("\n\" Son mujer y pertenecen a la liga Liga de la Justicia Oscura\"");
        lista.listaSexoYAfiliacionTal('M',"Liga de la Justicia Oscura") .imprimirNormal();
       
       StdOut.println("\n\" Son hombre y pertenecen a la liga Liga de la Justicia Oscura\"");
        lista.listaSexoYAfiliacionTal('H',"Liga de la Justicia Oscura") .imprimirNormal();
       
       StdOut.println("\n\" Son mujer y su raza es superhumana\"");
        lista.listaSexoYRazaTal('M',"Superhumana") .imprimirNormal();
       
       StdOut.println("\n\" Son hombre y su raza es superhumana\"");
        lista.listaSexoYRazaTal('H',"Superhumana") .imprimirNormal();
        
    }
}
