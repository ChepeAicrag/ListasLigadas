public class Controlador
{
   /**Prueba de guardar en el archivo*/ 
   public static void main() throws Exception{
       Archivo ar = new Archivo();  
       LinkedListPlusRecursividadGenerico <SuperHeroe >lista = new LinkedListPlusRecursividadGenerico();
       CreacionSuperHeroes cre= new CreacionSuperHeroes();   
       lista = lista.llenarListaVector(cre.arregloSuperHeroes());
       lista.imprimirNormal();
       ar.LlenarVector(lista,"SuperHeroesContenido");
   }
}
