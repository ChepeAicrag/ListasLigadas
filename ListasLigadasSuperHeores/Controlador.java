public class Controlador
{
   /**Prueba de guardar en el archivo*/ 
   public static void main() throws Exception{
       Archivo ar = new Archivo();  
       LinkedListPlusRecursividadGenerico <SuperHeroe >lista = new LinkedListPlusRecursividadGenerico();
       CreacionSuperHeroes.llenarSuperHeroes(lista); //A la lista de parametro le agregamos todos los superheroes
       ar.LlenarArchivo(lista,"SuperHeroesContenido"); // Llena el archivo con vector
       ar.LeerArchivo("SuperHeroesContenido"); //Muestra el archivo
       
       /**Prueba de buscar en la lista*/
       SuperHeroe batman = new SuperHeroe("Batman", "ser rico",'H');
       StdOut.println("\n\" Batman \" está despues de  " 
                        + lista.getInfo(lista.AntesDe(batman)));
       StdOut.println("\n\" Batman \" está antes de  " 
                        + lista.getInfo(lista.DespuesDe(batman)));
       
       /**Insertamos un nuevo superheroe*/
       
       StdOut.println("Agregando a un nuevo superheroe... \n");
       lista.insertarPrimero(new SuperHeroe ("Melvin","Cocinero",'H'));
       
       ar.LlenarArchivo(lista,"SuperHeroesContenido"); // Volvemeos a rellenar el archivo (Actualizar)
       ar.LeerArchivo("SuperHeroesContenido"); // Mostramos el archivo
   }
}
