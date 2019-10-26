
/**
 * Test de metodo de buscar por atributo
 */
public class Test02 
{
    public static void main()throws Exception{
       LinkedListPlusRecursividadGenerico <SuperHeroe >lista = new LinkedListPlusRecursividadGenerico();
       CreacionSuperHeroes.llenarSuperHeroes(lista); //A la lista de parametro le agregamos todos los superheroes
       
       /**Muestra el archivo*/
       Archivo.LeerArchivo("SuperHeroesContenido"); // Mostramos el archivo
       
         /**Test de los metodos */
        
       
       StdOut.println("\n\" 1962 \" aparecio en ese año  ");
        lista.listaAñoAparicionTal(1962).imprimirNormal();
        
       StdOut.println("\n\" Telepatía \" poder que tienen   ");
        lista.listaPoderTal("Telepatia").imprimirNormal();
       
       StdOut.println("\n\" Phil Jimenez \" autor de ");
        lista.listaAutorTal("phil jimenez").imprimirNormal();
      
       StdOut.println("\n\" Hombre \" sexo de ");
        lista.listaSexoTal('H').imprimirNormal();
      
       StdOut.println("\n\" Mujer \" sexo de ");
        lista.listaSexoTal('M').imprimirNormal();
       
       StdOut.println("\n\" Gotham City \" origen de ");
        lista.listaOrigenTal("gotham city").imprimirNormal();
        
       StdOut.println("\n\" Superwoman \" aperecio en el ");
        lista.listaComicTal("Superwoman").imprimirNormal();
         
       StdOut.println("\n\"  Liga de la Justicia\" contiene a ");
        lista.listaAfiliacionTal("Liga de la justicia").imprimirNormal();
       
       StdOut.println("\n\" Demonio \" raza de  ");
        lista.listaRazaTal("demonio").imprimirNormal();
       
       StdOut.println("\n\" Demon \" alias de  ");
        lista.listaAliasTal("demon").imprimirNormal();
       
       StdOut.println("\n\" Kristin Wells \" nombre real de  ");
        lista.listaNombreRealTal("kristin wells").imprimirNormal();


    }
}
