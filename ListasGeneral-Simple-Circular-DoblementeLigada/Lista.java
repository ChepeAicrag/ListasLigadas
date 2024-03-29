
/**
 * 
 * Interface, para que todas las listas tengan los métodos y para facilitar el uso al momento de llenar la lista desde archivo.
 * 
   */

public interface Lista <E>{
    public void mostrarLista();
    public boolean estaVacia();
    public void insertarInicio(E x);
    public void insertarFinal(E x);
    public void eliminarInicio();
    public void eliminarFinal();
    public void Eliminar(E x);
    public Nodo getCabeza();
    public Nodo getFin();
    public E getInfoNodo(Nodo x);
    public Nodo buscar(E dato);
    public void LlenarListaDesdeArchivo(String nom)throws Exception;
    public Lista <E> ListaAliasTal(String alias);
    public Lista <E> ListaNombreRealTal(String nombreReal);
    public Lista <E> ListaPoderTal(String poder);
    public Lista <E> ListaAutorTal(String autor);
    public Lista <E> ListaOrigenTal(String origen);
    public Lista <E> ListaComicTal(String comic);
    public Lista <E> ListaAfiliacionTal(String afiliacion);
    public Lista <E> ListaRazaTal(String raza);
    public Lista <E> ListaSexoTal(char sexo);
    public Lista <E> ListaSexoYPoderTal(char sexo, String poder);
    public Lista <E> ListaSexoYAñoAparicionTal(char sexo, int añoAparicion);
    public Lista <E> ListaSexoYAutorTal(char sexo, String autor);
    public Lista <E> ListaSexoYOrigenTal(char sexo, String origen);
    public Lista <E> ListaSexoYComicTal(char sexo, String comic);
    public Lista <E> ListaSexoYAfiliacionTal(char sexo, String afiliacion);
    public Lista <E> ListaSexoYRazaTal(char sexo, String raza);
    public Lista <E> ListaPoderYAñoAparicionTal(String poder, int añoAparicion);
    public Lista <E> ListaPoderYAutorTal(String poder, String autor);
    public Lista <E> ListaPoderYOrigenTal(String poder, String origen);
    public Lista <E> ListaPoderYComicTal(String poder, String comic);
    public Lista <E> ListaPoderYAfiliacionTal(String poder, String afiliacion);
    public Lista <E> ListaPoderYRazaTal(String poder, String raza);
    public Lista <E> ListaAñoAparicionYAutorTal(int añoAparicion, String autor);
    public Lista <E> ListaAñoAparicionYOrigenTal(int añoAparicion, String origen);
    public Lista <E> ListaAñoAparicionYComicTal(int añoAparicion, String comic);
    public Lista <E> ListaAñoAparicionYAfiliacionTal(int añoAparicion, String afiliacion);
    public Lista <E> ListaAñoAparicionYRazaTal(int añoAparicion, String raza);
    public Lista <E> ListaAutorYOrigenTal(String autor, String origen);
    public Lista <E> ListaAutorYComicTal(String autor, String comic);
    public Lista <E> ListaAutorYAfiliacionTal(String autor, String afiliacion);
    public Lista <E> ListaAutorYRazaTal(String autor, String raza);
    public Lista <E> ListaOrigenYComicTal(String origen, String comic);
    public Lista <E> ListaOrigenYAfiliacionTal(String origen, String afiliacion);
    public Lista <E> ListaOrigenYRazaTal(String origen, String raza);
    public Lista <E> ListaComicYAfiliacionTal(String comic, String afiliacion);
    public Lista <E> ListaComicYRazaTal(String comic, String raza);
    public Lista <E> ListaAfiliacionYRazaTal(String afiliacion, String raza);  
    public void EliminarConAliasTal(String alias);
    public void EliminarConNombreRealTal(String nombreReal);
    public void EliminarConPoderTal(String poder);
    public void EliminarConAutorTal(String autor);
    public void EliminarConOrigenTal(String origen);
    public void EliminarConComicTal(String comic);
    public void EliminarConAfiliacionTal(String afiliacion);
    public void EliminarConRazaTal(String raza);
    public void EliminarConSexoTal(char sexo);
    public Lista <E> ListaEliminandoConSexoYPoderTal(Lista <E> listaOriginal,char sexo, String poder);
    public Lista <E> ListaEliminandoConSexoYAñoAparicionTal(Lista <E> listaOriginal,char sexo, int añoAparicion);
    public Lista <E> ListaEliminandoConSexoYAutorTal(Lista <E> listaOriginal,char sexo, String autor);
    public Lista <E> ListaEliminandoConSexoYOrigenTal(Lista <E> listaOriginal,char sexo, String origen);
    public Lista <E> ListaEliminandoConSexoYComicTal(Lista <E> listaOriginal,char sexo, String comic);
    public Lista <E> ListaEliminandoConSexoYAfiliacionTal(Lista <E> listaOriginal,char sexo, String afiliacion);
    public Lista <E> ListaEliminandoConSexoYRazaTal(Lista <E> listaOriginal,char sexo, String raza);
    public Lista <E> ListaEliminandoConPoderYAñoAparicionTal(Lista <E> listaOriginal,String poder, int añoAparicion);
    public Lista <E> ListaEliminandoConPoderYAutorTal(Lista <E> listaOriginal,String poder, String autor);
    public Lista <E> ListaEliminandoConPoderYOrigenTal(Lista <E> listaOriginal,String poder, String origen);
    public Lista <E> ListaEliminandoConPoderYComicTal(Lista <E> listaOriginal,String poder, String comic);
    public Lista <E> ListaEliminandoConPoderYAfiliacionTal(Lista <E> listaOriginal,String poder, String afiliacion);
    public Lista <E> ListaEliminandoConPoderYRazaTal(Lista <E> listaOriginal,String poder, String raza);
    public Lista <E> ListaEliminandoConAñoAparicionYAutorTal(Lista <E> listaOriginal,int añoAparicion, String autor);
    public Lista <E> ListaEliminandoConAñoAparicionYOrigenTal(Lista <E> listaOriginal,int añoAparicion, String origen);
    public Lista <E> ListaEliminandoConAñoAparicionYComicTal(Lista <E> listaOriginal,int añoAparicion, String comic);
    public Lista <E> ListaEliminandoConAñoAparicionYAfiliacionTal(Lista <E> listaOriginal,int añoAparicion, String afiliacion);
    public Lista <E> ListaEliminandoConAñoAparicionYRazaTal(Lista <E> listaOriginal,int añoAparicion, String raza);
    public Lista <E> ListaEliminandoConAutorYOrigenTal(Lista <E> listaOriginal,String autor, String origen);
    public Lista <E> ListaEliminandoConAutorYComicTal(Lista <E> listaOriginal,String autor, String comic);
    public Lista <E> ListaEliminandoConAutorYAfiliacionTal(Lista <E> listaOriginal,String autor, String afiliacion);
    public Lista <E> ListaEliminandoConAutorYRazaTal(Lista <E> listaOriginal,String autor, String raza);
    public Lista <E> ListaEliminandoConOrigenYComicTal(Lista <E> listaOriginal,String origen, String comic);
    public Lista <E> ListaEliminandoConOrigenYAfiliacionTal(Lista <E> listaOriginal,String origen, String afiliacion);
    public Lista <E> ListaEliminandoConOrigenYRazaTal(Lista <E> listaOriginal,String origen, String raza);
    public Lista <E> ListaEliminandoConComicYAfiliacionTal(Lista <E> listaOriginal,String comic, String afiliacion);
    public Lista <E> ListaEliminandoConComicYRazaTal(Lista <E>  listaOriginal,String comic, String raza);
    public Lista <E> ListaEliminandoConAfiliacionYRazaTal(Lista <E>  listaOriginal,String afiliacion, String raza);  
}
