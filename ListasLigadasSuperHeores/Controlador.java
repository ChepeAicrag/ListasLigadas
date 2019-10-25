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
         
         SuperHeroe superwoman2  = new SuperHeroe("Superwoman2","Transformar energia,Absorción de Energía Solar,Super Fuerza,Invulnerabilidad,Super Velocidad,Vuelo,Visión de Calor,Visión Aumentada",
        'M',"","Phil Jimenez","Lois Lane,Luma Lynai,Diana (Tierra-3),Kristin Wells,Dana Dearden,Lucy Lane,Lana Lang","Tierra-11",
        "Action Comics,Justice League of America,Miracle Monday,Adventures of Superman,Supergirl,Superwoman","Liga de la Justicia","Superhumana",1943,1962,1964,2009,2016);
        
        
       StdOut.println("\n\" Demon \" está despues de  " 
                        + lista.AntesDeInfo(demon));
       
       StdOut.println("\n\" Superwoman2 \" está despues de  " 
                        + lista.AntesDeInfo(superwoman2));
                        
       StdOut.println("\n\" Demon \" está antes de  " 
                        + lista.DespuesDeInfo(demon));
       
       StdOut.println("\n\" Primero \" es  " 
                        + lista.getInfo(lista.getRaiz()));
                        
       StdOut.println("\n\" Ultimo \" es  " 
                        + lista.getInfo(lista.BuscarUltimo()));
                        
       StdOut.println("\n\" Demon \" aparece en la lista  " 
                        + lista.Buscar(demon));
                        
       StdOut.println("\n\" Null \" aparece en la lista  " 
                        + lista.Buscar(null));
       
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
        lista.listaAfiliacionTal("Liga de la justicia").imprimirNormal();
       
       StdOut.println("\n\" Demonio \" raza de  ");
        lista.listaRazaTal("demonio").imprimirNormal();
       
       StdOut.println("\n\" Demon \" alias de  ");
        lista.listaAliasTal("demon").imprimirNormal();
       
       StdOut.println("\n\" Kristin Wells \" nombre real de  ");
        lista.listaNombreRealTal("kristin wells").imprimirNormal();

   }
}
