
/**
 * Geenrar una nueva lista, eliminando superheroes de una lista apartir de dos atributos
 */
public class Test05
{
    public static void main()throws Exception{
       ListaDoblementeEnlazada<SuperHeroe> lista = new ListaDoblementeEnlazada();
        
       /** Rellenamos la lista, aplicando uno de sus metodos*/ 
       lista.LlenarListaDesdeArchivo("SuperHeroes");
       
       StdOut.println("\t\t\t***************************************** MOSTRANDO LA PRIMER BUSQUEDA *****************************************\n");
       
       /** Generamos una lista sin todas las mujeres y sin los creados por Bob Kane */
       ListaDoblementeEnlazada<SuperHeroe> listaNueva = new ListaDoblementeEnlazada();
       listaNueva = lista.ListaEliminandoConSexoYAutorTal(lista,'M',"Bob Kane");
       listaNueva.mostrarLista();
       
       StdOut.println("\t\t\t***************************************** MOSTRANDO LA SEGUNDA BUSQUEDA *****************************************\n");
       
       /** Generamos una lista sin todos los Humanos y sin los que aparecieron en  1960 */
       ListaDoblementeEnlazada<SuperHeroe> listaNew = new ListaDoblementeEnlazada();
       listaNew = lista.ListaEliminandoConAñoAparicionYRazaTal(lista,1960,"Humano");
       listaNew.mostrarLista();
       
       /**
        * Así se puede realiar con los distintos atributos pero apartir de 2
        * 
          */
    }
}
