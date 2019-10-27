
/**
 * Write a description of class Test02 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test03
{
    public static void main()throws Exception{
       ListaCircular <SuperHeroe >lista = new ListaCircular();
       Archivito.LlenarArchivo("SuperHeroesContenido"); //A la lista de parametro le agregamos todos los superheroes
       //lista.LlenarListaDesdeArchivo("SuperHeroesContenido");
       /**Muestra el archivo*/
       Archivito.LeerArchivo(lista,"SuperHeroesContenido"); // Mostramos el archivo
       lista.ImprimirLista();
         /**Test de los metodos */
        
       
       StdOut.println("\n\" 1962 \" aparecio en ese año  ");
        lista.ListaAñoAparicionTal(1962).ImprimirLista();
 
       StdOut.println("\n\" Telepatía \" poder que tienen   ");
        lista.ListaPoderTal("Telepatia").ImprimirLista();
       
       StdOut.println("\n\" Phil Jimenez \" autor de ");
        lista.ListaAutorTal("phil jimenez").ImprimirLista();
      
       StdOut.println("\n\" Hombre \" sexo de ");
        lista.ListaSexoTal('H').ImprimirLista();
      
       StdOut.println("\n\" Mujer \" sexo de ");
        lista.ListaSexoTal('M').ImprimirLista();
       
       StdOut.println("\n\" Gotham City \" origen de ");
        lista.ListaOrigenTal("gotham city").ImprimirLista();
        
       StdOut.println("\n\" Superwoman \" aperecio en el ");
        lista.ListaComicTal("Superwoman").ImprimirLista();
         
       StdOut.println("\n\"  Liga de la Justicia\" contiene a ");
        lista.ListaAfiliacionTal("Liga de la justicia").ImprimirLista();
       
       StdOut.println("\n\" Demonio \" raza de  ");
        lista.ListaRazaTal("demonio").ImprimirLista();
       
       StdOut.println("\n\" Demon \" alias de  ");
        lista.ListaAliasTal("demon").ImprimirLista();
       
       StdOut.println("\n\" Kristin Wells \" nombre real de  ");
        lista.ListaNombreRealTal("kristin wells").ImprimirLista();


    }
}
