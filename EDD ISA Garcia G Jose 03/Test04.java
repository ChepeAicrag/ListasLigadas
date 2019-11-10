

/**
 * Generar lista con la busqueda de superheroes con dos atributos
   */
public class Test04
{
    public static void main(String []args)throws Exception{
        /** Creamos la lista, y la rellenamos con el archivo anterior */
        ListaCircular<SuperHeroe> lista = new ListaCircular();
        Archivito.LeerArchivo(lista,"SuperHeroes");
        
        StdOut.println("\t\t\t***************************************** MOSTRANDO LA PRIMER BUSQUEDA *****************************************\n");
        
        /** Buscar a todos los super que radican en Gotham City y son mujers */
        lista.ListaSexoYOrigenTal('M',"Gotham City").mostrarLista();
        
        StdOut.println("\t\t\t***************************************** MOSTRANDO LA SEGUNDA BUSQUEDA *****************************************\n");
        
        /** Buscar a todos los superheroes que fueron creados por Bill Finger y aparecen en el comic Action Comics */
        lista.ListaAutorYComicTal("Bill Finger","Action Comics").mostrarLista();
        
        StdOut.println("\t\t\t***************************************** MOSTRANDO LA TERCERA BUSQUEDA *****************************************\n");
        
        /** Buscar a todos los superheroes de sexo M y que son Kriptonianos */
        lista.ListaSexoYRazaTal('H',"Kriptoniano").mostrarLista();
        
    }
}
