/**
 * Abstract class Listas - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public interface Lista <E>{
    public void mostrarLista();
    public E getInfoNodo(Nodo x);
    public boolean estaVacia();
    public void insertarInicio(E x);
    public void insertarFinal(E x);
    public Nodo getCabeza();
    public Nodo getFin();
    public void eliminarInicio();
    public void eliminarFinal();
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
}