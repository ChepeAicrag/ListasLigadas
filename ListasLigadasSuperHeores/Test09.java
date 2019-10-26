
/**
 * Test de los metodos combinados de afiliacion (Liga) y otro tal
 */
public class Test09
{
   public static void main()throws Exception{
       LinkedListPlusRecursividadGenerico <SuperHeroe >lista = new LinkedListPlusRecursividadGenerico();
       CreacionSuperHeroes.llenarSuperHeroes(lista); //A la lista de parametro le agregamos todos los superheroes
       
       /**Muestra el archivo*/
       Archivo.LeerArchivo("SuperHeroesContenido"); // Mostramos el archivo
       
       /**Test de los metodos */
           
       StdOut.println("\n\" Afiliado a : Liga de la Justicia Oscura : y es un Demonio\"");
        lista.listaAfiliacionYRazaTal("Liga de la Justicia Oscura","Demonio").imprimirNormal();
        
   }
}

