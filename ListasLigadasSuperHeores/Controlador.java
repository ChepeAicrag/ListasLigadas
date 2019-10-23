public class Controlador
{
   public static void main() throws Exception{
       Archivo ar = new Archivo();  
       LinkedListPlusRecursividadGenerico <SuperHeroe >lista = new LinkedListPlusRecursividadGenerico();
       CreacionSuperHeroes cre= new CreacionSuperHeroes();   
       lista = lista.llenarListaVector(ar.llenarListaDadoNombre("SuperHeroesContenido"));
       
       lista.imprimirNormal();
       ar.LlenarVector(lista,"SuperHeroesContenido");
   }
    
    
}
