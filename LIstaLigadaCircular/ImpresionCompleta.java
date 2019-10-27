
/**
 * Write a description of class ImpresionCompleta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImpresionCompleta
{
    public static void main()throws Exception{
        ListaCircular <SuperHeroe >lista = new ListaCircular();
       Archivito.LlenarArchivo("SuperHeroesContenido"); //A la lista de parametro le agregamos todos los superheroes
       //lista.LlenarListaDesdeArchivo("SuperHeroesContenido");
       /**Muestra el archivo*/
       Archivito.LeerArchivo(lista,"SuperHeroesContenido"); // Mostramos el archivo
       lista.RecorrerLista(); 
    }
}
