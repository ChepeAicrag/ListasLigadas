
/**
 * Write a description of class TestEliminar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestEliminar
{
   public static void main()throws Exception{
        LinkedListPlusRecursividadGenerico<SuperHeroe> lista = new LinkedListPlusRecursividadGenerico();
        Archivito.LlenarArchivo("HeroesTest");
        Archivito.LeerArchivo(lista,"HeroesTest");
        lista.EliminarConSexoTal('H');
        //lista.EliminarConAfiliacionTal("xd");
        //lista.EliminarConAliasTal("hola");
        //lista.EliminarConAñoAparicionTal(190);
        //lista.EliminarConComicTal("hola");
        //lista.EliminarConNombreRealTal("xd");
        //lista.EliminarConRazaTal("perro");
        //lista.EliminarConOrigenTal("china");
        //lista.EliminarConAutorTal("pedro");
    }
}
