
/**
 * Test de los metodos combinados de afiliacion (Liga) y otro tal
 */
public class Test09
{
   public static void main()throws Exception{
       LinkedListPlusRecursividadGenerico <SuperHeroe >lista = new LinkedListPlusRecursividadGenerico();
       Archivito.LeerArchivo(lista,"Heroes"); 
           
       StdOut.println("\n\" Afiliado a : Liga de la Justicia Oscura : y es un Demonio\"");
        lista.ListaAfiliacionYRazaTal("Liga de la Justicia Oscura","Demonio").mostrarLista();
        
   }
}

