
/**
 * Eliminar de la lista por atributo
 */
public class Test01
{
   public static void main(String[]args)throws Exception{
       ListaDoblementeEnlazada<SuperHeroe> lista = new ListaDoblementeEnlazada();
       
       /** Rellenamos la lista, aplicando uno de sus metodos*/ 
       lista.LlenarListaDesdeArchivo("SuperHeroes");
       
       /** Eliminamos a todos los hombres de la lista */
       StdOut.println("Eliminando a los hombres de la lista");
       lista.EliminarConSexoTal('H');
       
       /** Mostramos la lista solo con Mujeres*/
       lista.mostrarLista();
       
       /** Eliminamos a todas las mujeres de la lista */
       StdOut.println("\nEliminando a las mujeres de la lista");
       lista.EliminarConSexoTal('M');
       
       /** Mostramos la lista actual, que ahora está vacia*/
       lista.mostrarLista();
       
    }
}
