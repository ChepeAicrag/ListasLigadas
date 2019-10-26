
public class Test02
{
   public static void main()throws Exception{
       ListaDoblementeEnlazada <SuperHeroe >lista = new ListaDoblementeEnlazada();
       CreacionSuperHeroes.llenarSuperHeroes(lista); //A la lista de parametro le agregamos todos los superheroes
       
       /**Muestra el archivo*/
       Archivito.LeerArchivo("SuperHeroesContenido"); // Mostramos el archivo
       lista.mostrar(lista.getCabeza());
         /**Test de los metodos */
        
       
       StdOut.println("\n\" 1962 \" aparecio en ese año  ");
        lista.ListaAñoAparicionTal(1962).MostrarLista();
 
       StdOut.println("\n\" Telepatía \" poder que tienen   ");
        lista.ListaPoderTal("Telepatia").MostrarLista();
       
       StdOut.println("\n\" Phil Jimenez \" autor de ");
        lista.ListaAutorTal("phil jimenez").MostrarLista();
      
       StdOut.println("\n\" Hombre \" sexo de ");
        lista.ListaSexoTal('H').MostrarLista();
      
       StdOut.println("\n\" Mujer \" sexo de ");
        lista.ListaSexoTal('M').MostrarLista();
       
       StdOut.println("\n\" Gotham City \" origen de ");
        lista.ListaOrigenTal("gotham city").MostrarLista();
        
       StdOut.println("\n\" Superwoman \" aperecio en el ");
        lista.ListaComicTal("Superwoman").MostrarLista();
         
       StdOut.println("\n\"  Liga de la Justicia\" contiene a ");
        lista.ListaAfiliacionTal("Liga de la justicia").MostrarLista();
       
       StdOut.println("\n\" Demonio \" raza de  ");
        lista.ListaRazaTal("demonio").MostrarLista();
       
       StdOut.println("\n\" Demon \" alias de  ");
        lista.ListaAliasTal("demon").MostrarLista();
       
       StdOut.println("\n\" Kristin Wells \" nombre real de  ");
        lista.ListaNombreRealTal("kristin wells").MostrarLista();


    }
}
