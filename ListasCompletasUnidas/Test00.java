
/**
 * Buscar superheroes apartir de un atributo
 */
public class Test00
{
    public static void main(String[]args) throws Exception{
        
        /** Creamos el archivo que contiene los superheroes */
        Archivito.LlenarArchivo("SuperHeroes");
        
        /** Creamos la lista, y la rellenamos con el archivo anterior */
        ListaCircular<SuperHeroe> lista = new ListaCircular();
        Archivito.LeerArchivo(lista,"SuperHeroes");
        
        StdOut.println("\t\t\t***************************************** MOSTRANDO LA PRIMER BUSQUEDA *****************************************\n");
        
        /** Buscar a todos los superheroes que radican en Gotham City */
        lista.ListaOrigenTal("Gotham City").mostrarLista(); //Retorna una lista y mostramos
        
        StdOut.println("\t\t\t***************************************** MOSTRANDO LA SEGUNDA BUSQUEDA *****************************************\n");
        
        /** Buscar a todos los superheroes que están afiliados a Liga de la Justicia Oscura */
        lista.ListaAfiliacionTal("Liga de la Justicia Oscura").mostrarLista();
        
        
        /**
         * Así se pueden generar listas apartir de otras listas que son filtradas por un atributo
         * 
           */
    }
}
