import java.text.Normalizer;
import java.util.*;
import java.io.*;
public class ListaDoblementeEnlazada<E> implements Lista <E>{
    private Nodo cabeza;
    private Nodo fin;
    /*public class Nodo {
        E informacion;
        Nodo anterior;
        Nodo siguiente;
    
    }  
    /** constructor que crea una LDE vacia. */
    public ListaDoblementeEnlazada() {
        cabeza = null;
        fin = null;
    }
    
    public E getInfoNodo(Nodo temp){ 
        if(temp != null)
            return (E)temp.getInformacion();
        return null;
    }
    
    public Nodo getCabeza() {
        return cabeza;
    }
    
    public Nodo getFin() {
        return fin;
    }
    
    public void mostrarLista(){
        mostrar(cabeza);
    }
    
    public Nodo getAnterior(E x){
        Nodo actual = buscar(x);
        return actual.getAnterior();
    }
    
    /** indica si la Lista está vacia */
    public boolean estaVacia() {
        boolean vacia = false;
        if ( cabeza == null ) {
            vacia = true;
        }
        return vacia;
    }

    /** enlaza dos nodos mediante enlace doble */
    private void enlazar(Nodo nodoA, Nodo nodoB) {
        nodoA.setSiguiente(nodoB);
        nodoB.setAnterior(nodoA);
    }

    /** inserta un nuevo nodo al inicio de la Lista */
    public void insertarInicio(E x) {
        Nodo nuevo = new Nodo();
        nuevo.setInformacion(x);
        if ( estaVacia() ) {
            cabeza = nuevo;
            fin = nuevo;
        } else {
            enlazar(nuevo, cabeza);
            cabeza = nuevo;
        }
    }
    
    /** inserta un nuevo nodo al final de la Lista */
    public void insertarFinal(E x) {
        Nodo nuevo = new Nodo();
        nuevo.setInformacion(x);
        if ( estaVacia() ) {
            cabeza = nuevo;
            fin = nuevo;
        } else {
            enlazar(fin, nuevo);
            fin = nuevo;
        }
    }

    /** elimina el nodo del frente de la Lista */
    public void eliminarInicio() {
        if ( !estaVacia() ) {
            Nodo primero = cabeza.getSiguiente();
            if ( primero == null ) {
                cabeza = null;
                fin = null;
            } else {
                primero.setAnterior(null);
                cabeza = primero;
            }
        }
    }

    /** elimina el nodo del final de la Lista */
    public void eliminarFinal() {
        if ( !estaVacia() ) {
            Nodo ultimo = fin.getAnterior();
            if ( ultimo == null ) {
                cabeza = null;
                fin = null;
            } else {
                ultimo.setSiguiente(null);
                fin = ultimo;
            }
        }
    }

    /** devuelve una referencia al nodo buscado, si no se encuentra devuelve null */
    public Nodo buscar(E dato) {
        Nodo buscado = null;
        Nodo iterador = cabeza;
        while ( buscado == null && iterador != null ) {
            if(dato == null){
                buscado = new Nodo();
                buscado.setInformacion("No se encuentra null");
                break;}
            if ( iterador.getInformacion().equals(dato) ) {
                buscado = iterador;
            }
            iterador = iterador.getSiguiente();
        }
        return buscado;
    }

    /** muestra los valores en la Lista */
    public void mostrar(Nodo n) {
        Nodo iterador = n;
        boolean flag  = false;
        if (n == cabeza) flag = true;
        while ( iterador != null ) {
            System.out.print( iterador.getInformacion() + " -> " );
            if (flag) iterador = iterador.getSiguiente();
            else      iterador = iterador.getAnterior();
        }
        System.out.println( "null" );
    }
    /**Llenar una Lista desde archivo*/
    
    public void LlenarListaDesdeArchivo(String nom) throws Exception{
        ObjectInputStream flujoObjetoEntrada = null;
        FileInputStream flujoArchivoEntrada = null;
        try{
            File archivoSalida = new File(nom+".txt");     
            flujoArchivoEntrada = new FileInputStream(archivoSalida);
            flujoObjetoEntrada = new ObjectInputStream(flujoArchivoEntrada);
            Object per = flujoObjetoEntrada.readObject();  
            System.out.println("Rellenando la Lista Simple Doblemente Enlaza...");
           while(per != null){
             insertarInicio((E)per);
             per = flujoObjetoEntrada.readObject();
           }    
       }catch(IOException error){
            System.out.println("******** Lista Rellenada *******"); 
     }finally{
             flujoArchivoEntrada.close();
             flujoObjetoEntrada.close();
      }  
   }
   
    /**
     * 
     * Metodos combiandos que generan Lista, apartir de Listas (Filtrado)
     * 
     */
    
    /** Metodo terminado para buscar por sexo y poder tal*/
    public ListaDoblementeEnlazada<E> ListaSexoYPoderTal(char sexo, String poder){
        ListaDoblementeEnlazada<E> Lista = ListaSexoTal(sexo); //Te entrega una Lista de sexo tal 
        return Lista.ListaPoderTal(poder); //Te regresa quienes tienen el poder, sobre esa misma Lista
    }
    
    /** Metodo terminado para buscar por sexo y año tal*/
    public ListaDoblementeEnlazada<E> ListaSexoYAñoAparicionTal(char sexo, int añoAparicion){
        ListaDoblementeEnlazada<E> Lista = ListaSexoTal(sexo);
        return Lista.ListaAñoAparicionTal(añoAparicion);
    }
    
    /** Metodo terminado para buscar por sexo y autor tal*/
    public ListaDoblementeEnlazada<E> ListaSexoYAutorTal(char sexo, String autor){
         ListaDoblementeEnlazada<E> Lista = ListaSexoTal(sexo);
         return Lista.ListaAutorTal(autor);
    }
    
    /** Metodo terminado para buscar por sexo y origen tal*/
    public ListaDoblementeEnlazada<E> ListaSexoYOrigenTal(char sexo, String origen){
         ListaDoblementeEnlazada<E> Lista = ListaSexoTal(sexo);
         return Lista.ListaOrigenTal(origen);
    }
    
    /** Metodo terminado para buscar por sexo y comic tal*/
    public  ListaDoblementeEnlazada<E> ListaSexoYComicTal(char sexo, String comic){
         ListaDoblementeEnlazada<E> Lista = ListaSexoTal(sexo);
         return Lista.ListaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por sexo y afiliacion tal*/
    public  ListaDoblementeEnlazada<E> ListaSexoYAfiliacionTal(char sexo, String afiliacion){
         ListaDoblementeEnlazada<E> Lista = ListaSexoTal(sexo);
         return Lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por sexo y raza tal*/
    public  ListaDoblementeEnlazada<E> ListaSexoYRazaTal(char sexo, String raza){
         ListaDoblementeEnlazada<E> Lista = ListaSexoTal(sexo);
         return Lista.ListaRazaTal(raza);
    }
    
        /** Metodo terminado para buscar por poder y año tal*/
    public ListaDoblementeEnlazada<E> ListaPoderYAñoAparicionTal(String poder, int añoAparicion){
        ListaDoblementeEnlazada<E> Lista = ListaPoderTal(poder);
        return Lista.ListaAñoAparicionTal(añoAparicion);
    }
    
    /** Metodo terminado para buscar por poder y autor tal*/
    public ListaDoblementeEnlazada<E> ListaPoderYAutorTal(String poder, String autor){
         ListaDoblementeEnlazada<E> Lista = ListaPoderTal(poder);
         return Lista.ListaAutorTal(autor);
    }
    
    /** Metodo terminado para buscar por poder y origen tal*/
    public ListaDoblementeEnlazada<E> ListaPoderYOrigenTal(String poder, String origen){
         ListaDoblementeEnlazada<E> Lista = ListaPoderTal(poder);
         return Lista.ListaOrigenTal(origen);
    }
    
    /** Metodo terminado para buscar por poder y comic tal*/
    public  ListaDoblementeEnlazada<E> ListaPoderYComicTal(String poder, String comic){
         ListaDoblementeEnlazada<E> Lista = ListaPoderTal(poder);
         return Lista.ListaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por poder y afiliacion tal*/
    public  ListaDoblementeEnlazada<E> ListaPoderYAfiliacionTal(String poder, String afiliacion){
         ListaDoblementeEnlazada<E> Lista = ListaPoderTal(poder);
         return Lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por poder y raza tal*/
    public  ListaDoblementeEnlazada<E> ListaPoderYRazaTal(String poder, String raza){
         ListaDoblementeEnlazada<E> Lista = ListaPoderTal(poder);
         return Lista.ListaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por año y autor tal*/
    public ListaDoblementeEnlazada<E> ListaAñoAparicionYAutorTal(int añoAparicion, String autor){
         ListaDoblementeEnlazada<E> Lista = ListaAñoAparicionTal(añoAparicion);
         return Lista.ListaAutorTal(autor);
    }
    
    /** Metodo terminado para buscar por año y origen tal*/
    public ListaDoblementeEnlazada<E> ListaAñoAparicionYOrigenTal(int añoAparicion, String origen){
         ListaDoblementeEnlazada<E> Lista = ListaAñoAparicionTal(añoAparicion);
         return Lista.ListaOrigenTal(origen);
    }
    
    /** Metodo terminado para buscar por año y comic tal*/
    public  ListaDoblementeEnlazada<E> ListaAñoAparicionYComicTal(int añoAparicion, String comic){
         ListaDoblementeEnlazada<E> Lista = ListaAñoAparicionTal(añoAparicion);
         return Lista.ListaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por año y afiliacion tal*/
    public  ListaDoblementeEnlazada<E> ListaAñoAparicionYAfiliacionTal(int añoAparicion, String afiliacion){
         ListaDoblementeEnlazada<E> Lista = ListaAñoAparicionTal(añoAparicion);
         return Lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por año y raza tal*/
    public  ListaDoblementeEnlazada<E> ListaAñoAparicionYRazaTal(int añoAparicion, String raza){
         ListaDoblementeEnlazada<E> Lista = ListaAñoAparicionTal(añoAparicion);
         return Lista.ListaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por autor y origen tal*/
    public ListaDoblementeEnlazada<E> ListaAutorYOrigenTal(String autor, String origen){
         ListaDoblementeEnlazada<E> Lista = ListaAutorTal(autor);
         return Lista.ListaOrigenTal(origen);
    }
    
    /** Metodo terminado para buscar por autor y comic tal*/
    public  ListaDoblementeEnlazada<E> ListaAutorYComicTal(String autor, String comic){
         ListaDoblementeEnlazada<E> Lista = ListaAutorTal(autor);
         return Lista.ListaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por autor y afiliacion tal*/
    public  ListaDoblementeEnlazada<E> ListaAutorYAfiliacionTal(String autor, String afiliacion){
         ListaDoblementeEnlazada<E> Lista = ListaAutorTal(autor);
         return Lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por autor y raza tal*/
    public  ListaDoblementeEnlazada<E> ListaAutorYRazaTal(String autor, String raza){
         ListaDoblementeEnlazada<E> Lista = ListaAutorTal(autor);
         return Lista.ListaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por origen y comic tal*/
    public  ListaDoblementeEnlazada<E> ListaOrigenYComicTal(String origen, String comic){
         ListaDoblementeEnlazada<E> Lista = ListaOrigenTal(origen);
         return Lista.ListaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por origen y afiliacion tal*/
    public  ListaDoblementeEnlazada<E> ListaOrigenYAfiliacionTal(String origen, String afiliacion){
         ListaDoblementeEnlazada<E> Lista = ListaOrigenTal(origen);
         return Lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por origen y raza tal*/
    public  ListaDoblementeEnlazada<E> ListaOrigenYRazaTal(String origen, String raza){
         ListaDoblementeEnlazada<E> Lista = ListaOrigenTal(origen);
         return Lista.ListaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por comic y afiliacion tal*/
    public  ListaDoblementeEnlazada<E> ListaComicYAfiliacionTal(String comic, String afiliacion){
         ListaDoblementeEnlazada<E> Lista = ListaComicTal(comic);
         return Lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por comic y raza tal*/
    public  ListaDoblementeEnlazada<E> ListaComicYRazaTal(String comic, String raza){
         ListaDoblementeEnlazada<E> Lista = ListaComicTal(comic);
         return Lista.ListaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por afiliacion y raza tal*/
    public  ListaDoblementeEnlazada<E> ListaAfiliacionYRazaTal(String afiliacion, String raza){
         ListaDoblementeEnlazada<E> Lista = ListaAfiliacionTal(afiliacion);
         return Lista.ListaRazaTal(raza);
    }
   
    /** Metodo termiando para buscar por alias */
    
    public ListaDoblementeEnlazada<E> ListaAliasTal(String alias){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAlias().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(alias)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por nombre real */
    
    public ListaDoblementeEnlazada<E> ListaNombreRealTal(String nombreReal){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getNombreReal().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(nombreReal)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por poder */
    
    public ListaDoblementeEnlazada<E> ListaPoderTal(String poder){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getPoder().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(poder)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por autor*/
    
    public ListaDoblementeEnlazada<E> ListaAutorTal(String autor){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAutor().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(autor)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por origen*/
    
    public ListaDoblementeEnlazada<E> ListaOrigenTal(String origen){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getOrigen().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(origen)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por comic*/
    
    public ListaDoblementeEnlazada<E> ListaComicTal(String comic){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getComic().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(comic)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por afiliacion*/
    
    public ListaDoblementeEnlazada<E> ListaAfiliacionTal(String afiliacion){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAfiliacionActual().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(afiliacion)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por raza*/
    
    public ListaDoblementeEnlazada<E> ListaRazaTal(String raza){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getRaza().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(raza)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /**Metodo para qutar las tildes de un string, para hacer mas eficiente la busqueda*/
    
    private static String cleanString(String info) {
        info = Normalizer.normalize(info, Normalizer.Form.NFD);
        info = info.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return info;
    }
    
    /** Metodo termiando para buscar por sexo */
    
    public ListaDoblementeEnlazada<E> ListaSexoTal(char sexo){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                if(((SuperHeroe)(i.getInformacion())).getSexo() == sexo)
                    Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por año / años de aparicion*/
    
    public ListaDoblementeEnlazada<E> ListaAñoAparicionTal(int añoAparicion){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                for(int j = 0; j < ((SuperHeroe)(i.getInformacion())).getAñoAparicion().length; j++)
                    if(((SuperHeroe)(i.getInformacion())).getAñoAparicion()[j] == añoAparicion)
                         Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
}
