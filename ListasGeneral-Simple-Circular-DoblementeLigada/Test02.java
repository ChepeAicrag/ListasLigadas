
/**
 * Test de metodo de buscar por atributo
 */
public class Test02 
{
    public static void main()throws Exception{
       LinkedListPlusRecursividadGenerico <SuperHeroe >Lista = new LinkedListPlusRecursividadGenerico();
       /**Test de los metodos */
        Archivito.LeerArchivo(Lista,"Heroes"); 
       
       
       StdOut.println("\n\" 1962 \" aparecio en ese año  ");
        Lista.ListaAñoAparicionTal(1962).mostrarLista();
        
       StdOut.println("\n\" Telepatía \" poder que tienen   ");
        Lista.ListaPoderTal("Telepatia").mostrarLista();
       
       StdOut.println("\n\" Phil Jimenez \" autor de ");
        Lista.ListaAutorTal("phil jimenez").mostrarLista();
      
       StdOut.println("\n\" Hombre \" sexo de ");
        Lista.ListaSexoTal('H').mostrarLista();
      
       StdOut.println("\n\" Mujer \" sexo de ");
        Lista.ListaSexoTal('M').mostrarLista();
       
       StdOut.println("\n\" Gotham City \" origen de ");
        Lista.ListaOrigenTal("gotham city").mostrarLista();
        
       StdOut.println("\n\" Superwoman \" aperecio en el ");
        Lista.ListaComicTal("Superwoman").mostrarLista();
         
       StdOut.println("\n\"  Liga de la Justicia\" contiene a ");
        Lista.ListaAfiliacionTal("Liga de la justicia").mostrarLista();
       
       StdOut.println("\n\" Demonio \" raza de  ");
        Lista.ListaRazaTal("demonio").mostrarLista();
       
       StdOut.println("\n\" Demon \" alias de  ");
        Lista.ListaAliasTal("demon").mostrarLista();
       
       StdOut.println("\n\" Kristin Wells \" nombre real de  ");
        Lista.ListaNombreRealTal("kristin wells").mostrarLista();


    }
}
