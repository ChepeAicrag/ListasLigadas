
/**
 * Test de los metodos combinados de afiliacion (Liga) y otro tal
 */
public class Test09
{
   public static void main(String[]args)throws Exception{
       LinkedListPlusRecursividadGenerico <SuperHeroe >lista = new LinkedListPlusRecursividadGenerico();
       lista.LlenarListaDesdeArchivo("SuperHeroes");
           
       StdOut.println("\n\" Afiliado a : Liga de la Justicia Oscura : y es un Demonio\"");
        lista.ListaAfiliacionYRazaTal("Liga de la Justicia Oscura","Demonio").mostrarLista();
        
   }
}

