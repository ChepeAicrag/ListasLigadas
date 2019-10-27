
/**
 * Write a description of class Test03 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test03
{
    public static void main()throws Exception{
       ListaDoblementeEnlazada <SuperHeroe >Lista = new ListaDoblementeEnlazada();
       Archivito.LlenarArchivo("SuperHeroesContenido"); //A la lista de parametro le agregamos todos los superheroes
       //Lista.LlenarListaDesdeArchivo("SuperHeroesContenido");
       /**Muestra el archivo*/
       Archivito.LeerArchivo(Lista,"SuperHeroesContenido"); // Mostramos el archivo
       
         /**Test de los metodos */
           
       StdOut.println("\n\" Son hombre y tiene el poder Capacidad de regeneración\"");
        Lista.listaSexoYPoderTal('H',"Capacidad de regeneración").MostrarLista();
        
       StdOut.println("\n\" Son mujer y tiene el poder Capacidad de regeneración\"");
        Lista.listaSexoYPoderTal('M',"Capacidad de regeneración").MostrarLista(); 
        
       StdOut.println("\n\" Son hombre y aparecieron en 1962\"");
        Lista.listaSexoYAñoAparicionTal('H',1962) .MostrarLista();
       
       StdOut.println("\n\" Son mujer y aparecieron en 1962\"");
        Lista.listaSexoYAñoAparicionTal('M',1962) .MostrarLista();
       
       StdOut.println("\n\" Son mujer y su creado es Phil Jimenez\"");
        Lista.listaSexoYAutorTal('M',"phiL jiMenez") .MostrarLista();
       
       StdOut.println("\n\" Son hombre y su creado es Phil Jimenez\"");
        Lista.listaSexoYAutorTal('H',"phiL jiMenez") .MostrarLista();
        
       StdOut.println("\n\" Son mujer y su origen es Gotham City\"");
        Lista.listaSexoYOrigenTal('M',"Gotham City") .MostrarLista();
        
       StdOut.println("\n\" Son hombre y su origen es Gotham City\"");
        Lista.listaSexoYOrigenTal('H',"Gotham City") .MostrarLista();
       
       StdOut.println("\n\" Son mujer y aparecen en el comic Adventures of Superman\"");
        Lista.listaSexoYComicTal('M',"Adventures of Superman") .MostrarLista();
       
       StdOut.println("\n\" Son hombre y aparecen en el comic Adventures of Superman\"");
        Lista.listaSexoYComicTal('H',"Adventures of Superman") .MostrarLista();
       
       StdOut.println("\n\" Son mujer y pertenecen a la liga Liga de la Justicia Oscura\"");
        Lista.listaSexoYAfiliacionTal('M',"Liga de la Justicia Oscura") .MostrarLista();
       
       StdOut.println("\n\" Son hombre y pertenecen a la liga Liga de la Justicia Oscura\"");
        Lista.listaSexoYAfiliacionTal('H',"Liga de la Justicia Oscura") .MostrarLista();
       
       StdOut.println("\n\" Son mujer y su raza es superhumana\"");
        Lista.listaSexoYRazaTal('M',"Superhumana") .MostrarLista();
       
       StdOut.println("\n\" Son hombre y su raza es superhumana\"");
        Lista.listaSexoYRazaTal('H',"Superhumana") .MostrarLista();
        
    }
}
