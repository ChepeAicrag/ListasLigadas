public class Controlador
{
   /**Prueba de guardar en el archivo*/ 
   public static void main() throws Exception{
       LinkedListPlusRecursividadGenerico <SuperHeroe >lista = new LinkedListPlusRecursividadGenerico();
       CreacionSuperHeroes.llenarSuperHeroes(lista); //A la lista de parametro le agregamos todos los superheroes
       
       /**Llena y Muestra el archivo*/
       Archivo.LlenarArchivo(lista,"SuperHeroesContenido"); // Volvemeos a rellenar el archivo (Actualizar)
       Archivo.LeerArchivo("SuperHeroesContenido"); // Mostramos el archivo
       
         /**Test de los metodos */
        
       SuperHeroe demon       = new SuperHeroe("Demon","Atributos físicos y poderes sensoriales sobrehumanos,Capacidad de regeneración, Poderes mágicos,Precognición,Telepatía,Inmortalidad,Puede lanzar llamas de fuego místico,Vuelo",
        'H',"Convive en un mismo cuerpo","Jack Kirby","Jason Blood","Gotham City","The Demon","Liga de la Justicia Oscura","Demonio",1972); 
       
       StdOut.println("\n\" Demon \" está despues de  " 
                        + lista.getInfo(lista.AntesDe(demon)));
       
       StdOut.println("\n\" Demon \" está antes de  " 
                        + lista.getInfo(lista.DespuesDe(demon)));
       
       StdOut.println("\n\" 1962 \" aparecio en ese año  ");
        lista.listaAñoApaircionTal(1962).imprimirNormal();
        
       StdOut.println("\n\" Telepatía \" poder que tienen   ");
        lista.listaPoderTal("Telepatia").imprimirNormal();
       
       StdOut.println("\n\" Phil Jimenez \" autor de ");
        lista.listaAutorTal("phil jimenez").imprimirNormal();
      
       StdOut.println("\n\" Hombre \" sexo de ");
        lista.listaSexoTal('H').imprimirNormal();
      
       StdOut.println("\n\" Mujer \" sexo de ");
        lista.listaSexoTal('M').imprimirNormal();
       
       StdOut.println("\n\" Gotham City \" origen de ");
        lista.listaOrigenTal("gotham city").imprimirNormal();
        
       StdOut.println("\n\" Superwoman \" aperecio en el ");
        lista.listaComicTal("Superwoman").imprimirNormal();
         
       StdOut.println("\n\"  Liga de la Justicia\" contiene a ");
        lista.listaAfiliacioTal("Liga de la justicia").imprimirNormal();
       
       StdOut.println("\n\" Demonio \" raza de  ");
        lista.listaRazaTal("demonio").imprimirNormal();
         
        
       /**Insertamos un nuevo superheroe*/
       
       /*
       StdOut.println("Agregando a un nuevo superheroe... \n");
       lista.insertarPrimero(new SuperHeroe ("Melvin","Cocinero",'M'));
       
       SuperHeroe atomo = new SuperHeroe("Atomo","reducir su cuerpo",'H');
        
       StdOut.println("Buscando a \" Atomo \" \n " 
                        + lista.Buscar(atomo));
        
       StdOut.println("Buscando a superhores con poder de \" reducir su cuerpo \" \n "); 
       lista.listaPoderTal("reducir su cuerpo").imprimirNormal();
        
       StdOut.println("Buscando a los superheroes \" Hombre \" \n ");
       lista.listaSexoTal('H').imprimirNormal();
        
       StdOut.println("Buscando a los superheroes \" Mujer \" \n ");
       lista.listaSexoTal('M').imprimirNormal();
       */

   }
}
