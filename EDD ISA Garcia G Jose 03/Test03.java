
/**
 * Generar una lista de superheroes con un atributo en comun
 */
public class Test03
{
    public static void main()throws Exception{
       /** Creamos una LS */
       LinkedListPlusRecursividadGenerico<SuperHeroe> lista = new LinkedListPlusRecursividadGenerico();
       
       /** Rellenamos la lista, aplicando uno de sus metodos*/ 
       lista.LlenarListaDesdeArchivo("SuperHeroes");
       
       StdOut.println("\n\t\t\t***************************************** MOSTRANDO LA PRIMER BUSQUEDA *****************************************\n");
       
       /** Generamos una lista solo con superhereos creados por Bob Kane y mostramos */
       lista.ListaAutorTal("Bob Kane").mostrarLista();
       
       StdOut.println("\n\t\t\t***************************************** MOSTRANDO LA PRIMER BUSQUEDA *****************************************\n");
       
       /** Generamos una lista solo con superhereos de la raza Kriptoniano y mostramos */
       lista.ListaRazaTal("Kriptoniano").mostrarLista();
       
    }
}
