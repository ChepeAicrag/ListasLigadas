import java.text.Normalizer;
import java.util.*;
public class ListaDoblementeEnlazada<E> {
    private Nodo cabeza;
    private Nodo fin;
    public class Nodo {
        /** Campos del nodo */
        E informacion;
        Nodo anterior;
        Nodo siguiente;
    
    }
    
    /** constructor que crea una LDE vacia. */
    public ListaDoblementeEnlazada() {
        cabeza = null;
        fin = null;
    }
    
    /**
     * Metodos combiandos que generan lista, apartir de listas (Filtrado)
     * 
     */
    
    
    /** Metodo terminado para buscar por sexo y poder tal*/
    public ListaDoblementeEnlazada<E> listaSexoYPoderTal(char sexo, String poder){
        ListaDoblementeEnlazada<E> lista = ListaSexoTal(sexo); //Te entrega una lista de sexo tal 
        return lista.ListaPoderTal(poder); //Te regresa quienes tienen el poder, sobre esa misma lista
    }
    
    /** Metodo terminado para buscar por sexo y año tal*/
    public ListaDoblementeEnlazada<E> listaSexoYAñoAparicionTal(char sexo, int añoAparicion){
        ListaDoblementeEnlazada<E> lista = ListaSexoTal(sexo);
        return lista.ListaAñoAparicionTal(añoAparicion);
    }
    
    /** Metodo terminado para buscar por sexo y autor tal*/
    public ListaDoblementeEnlazada<E> listaSexoYAutorTal(char sexo, String autor){
         ListaDoblementeEnlazada<E> lista = ListaSexoTal(sexo);
         return lista.ListaAutorTal(autor);
    }
    
    /** Metodo terminado para buscar por sexo y origen tal*/
    public ListaDoblementeEnlazada<E> listaSexoYOrigenTal(char sexo, String origen){
         ListaDoblementeEnlazada<E> lista = ListaSexoTal(sexo);
         return lista.ListaOrigenTal(origen);
    }
    
    /** Metodo terminado para buscar por sexo y comic tal*/
    public  ListaDoblementeEnlazada<E> listaSexoYComicTal(char sexo, String comic){
         ListaDoblementeEnlazada<E> lista = ListaSexoTal(sexo);
         return lista.ListaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por sexo y afiliacion tal*/
    public  ListaDoblementeEnlazada<E> listaSexoYAfiliacionTal(char sexo, String afiliacion){
         ListaDoblementeEnlazada<E> lista = ListaSexoTal(sexo);
         return lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por sexo y raza tal*/
    public  ListaDoblementeEnlazada<E> listaSexoYRazaTal(char sexo, String raza){
         ListaDoblementeEnlazada<E> lista = ListaSexoTal(sexo);
         return lista.ListaRazaTal(raza);
    }
    
        /** Metodo terminado para buscar por poder y año tal*/
    public ListaDoblementeEnlazada<E> listaPoderYAñoAparicionTal(String poder, int añoAparicion){
        ListaDoblementeEnlazada<E> lista = ListaPoderTal(poder);
        return lista.ListaAñoAparicionTal(añoAparicion);
    }
    
    /** Metodo terminado para buscar por poder y autor tal*/
    public ListaDoblementeEnlazada<E> listaPoderYAutorTal(String poder, String autor){
         ListaDoblementeEnlazada<E> lista = ListaPoderTal(poder);
         return lista.ListaAutorTal(autor);
    }
    
    /** Metodo terminado para buscar por poder y origen tal*/
    public ListaDoblementeEnlazada<E> listaPoderYOrigenTal(String poder, String origen){
         ListaDoblementeEnlazada<E> lista = ListaPoderTal(poder);
         return lista.ListaOrigenTal(origen);
    }
    
    /** Metodo terminado para buscar por poder y comic tal*/
    public  ListaDoblementeEnlazada<E> listaPoderYComicTal(String poder, String comic){
         ListaDoblementeEnlazada<E> lista = ListaPoderTal(poder);
         return lista.ListaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por poder y afiliacion tal*/
    public  ListaDoblementeEnlazada<E> listaPoderYAfiliacionTal(String poder, String afiliacion){
         ListaDoblementeEnlazada<E> lista = ListaPoderTal(poder);
         return lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por poder y raza tal*/
    public  ListaDoblementeEnlazada<E> listaPoderYRazaTal(String poder, String raza){
         ListaDoblementeEnlazada<E> lista = ListaPoderTal(poder);
         return lista.ListaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por año y autor tal*/
    public ListaDoblementeEnlazada<E> listaAñoAparicionYAutorTal(int añoAparicion, String autor){
         ListaDoblementeEnlazada<E> lista = ListaAñoAparicionTal(añoAparicion);
         return lista.ListaAutorTal(autor);
    }
    
    /** Metodo terminado para buscar por año y origen tal*/
    public ListaDoblementeEnlazada<E> listaAñoAparicionYOrigenTal(int añoAparicion, String origen){
         ListaDoblementeEnlazada<E> lista = ListaAñoAparicionTal(añoAparicion);
         return lista.ListaOrigenTal(origen);
    }
    
    /** Metodo terminado para buscar por año y comic tal*/
    public  ListaDoblementeEnlazada<E> listaAñoAparicionYComicTal(int añoAparicion, String comic){
         ListaDoblementeEnlazada<E> lista = ListaAñoAparicionTal(añoAparicion);
         return lista.ListaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por año y afiliacion tal*/
    public  ListaDoblementeEnlazada<E> listaAñoAparicionYAfiliacionTal(int añoAparicion, String afiliacion){
         ListaDoblementeEnlazada<E> lista = ListaAñoAparicionTal(añoAparicion);
         return lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por año y raza tal*/
    public  ListaDoblementeEnlazada<E> listaAñoAparicionYRazaTal(int añoAparicion, String raza){
         ListaDoblementeEnlazada<E> lista = ListaAñoAparicionTal(añoAparicion);
         return lista.ListaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por autor y origen tal*/
    public ListaDoblementeEnlazada<E> listaAutorYOrigenTal(String autor, String origen){
         ListaDoblementeEnlazada<E> lista = ListaAutorTal(autor);
         return lista.ListaOrigenTal(origen);
    }
    
    /** Metodo terminado para buscar por autor y comic tal*/
    public  ListaDoblementeEnlazada<E> listaAutorYComicTal(String autor, String comic){
         ListaDoblementeEnlazada<E> lista = ListaAutorTal(autor);
         return lista.ListaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por autor y afiliacion tal*/
    public  ListaDoblementeEnlazada<E> listaAutorYAfiliacionTal(String autor, String afiliacion){
         ListaDoblementeEnlazada<E> lista = ListaAutorTal(autor);
         return lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por autor y raza tal*/
    public  ListaDoblementeEnlazada<E> listaAutorYRazaTal(String autor, String raza){
         ListaDoblementeEnlazada<E> lista = ListaAutorTal(autor);
         return lista.ListaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por origen y comic tal*/
    public  ListaDoblementeEnlazada<E> listaOrigenYComicTal(String origen, String comic){
         ListaDoblementeEnlazada<E> lista = ListaOrigenTal(origen);
         return lista.ListaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por origen y afiliacion tal*/
    public  ListaDoblementeEnlazada<E> listaOrigenYAfiliacionTal(String origen, String afiliacion){
         ListaDoblementeEnlazada<E> lista = ListaOrigenTal(origen);
         return lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por origen y raza tal*/
    public  ListaDoblementeEnlazada<E> listaOrigenYRazaTal(String origen, String raza){
         ListaDoblementeEnlazada<E> lista = ListaOrigenTal(origen);
         return lista.ListaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por comic y afiliacion tal*/
    public  ListaDoblementeEnlazada<E> listaComicYAfiliacionTal(String comic, String afiliacion){
         ListaDoblementeEnlazada<E> lista = ListaComicTal(comic);
         return lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por comic y raza tal*/
    public  ListaDoblementeEnlazada<E> listaComicYRazaTal(String comic, String raza){
         ListaDoblementeEnlazada<E> lista = ListaComicTal(comic);
         return lista.ListaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por afiliacion y raza tal*/
    public  ListaDoblementeEnlazada<E> listaAfiliacionYRazaTal(String afiliacion, String raza){
         ListaDoblementeEnlazada<E> lista = ListaAfiliacionTal(afiliacion);
         return lista.ListaRazaTal(raza);
    }
    
    public void MostrarLista(){
        mostrar(cabeza);
    }
    
    public Nodo getAnterior(E x){
        Nodo actual = buscar(x);
        return actual.anterior;
    }
    
    /**Obtener una Lista en forma de vector*/
    public Vector<E> formaVector(){
        Vector<E> vecTemp = new Vector <E>();
        Nodo temp = cabeza;
        while(temp != null){
            vecTemp.add((E)temp.informacion);
            temp = temp.siguiente;
        }
        return vecTemp;
    }
    
    /**Llenar una Lista dado un vector*/
    
    public ListaDoblementeEnlazada<E> llenarListaVector(Vector <E> vec){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        for(int i = 0; i < vec.size(); i++)
            Lista.insertarInicio(vec.elementAt(i));
        return Lista;    
    }
    /**
     * 
     * Estos metodos no estoy seguro de que vayan aqui
     *  
     */
      
   /** Metodo termiando para buscar por alias */
    
    public ListaDoblementeEnlazada<E> ListaAliasTal(String alias){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
            for(Nodo i = cabeza; i != null; i = i.siguiente){
                String [] temp = ((SuperHeroe)(i.informacion)).getAlias().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(alias)))
                        Lista.insertarInicio(((E)(i.informacion)));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por nombre real */
    
    public ListaDoblementeEnlazada<E> ListaNombreRealTal(String nombreReal){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
            for(Nodo i = cabeza; i != null; i = i.siguiente){
                String [] temp = ((SuperHeroe)(i.informacion)).getNombreReal().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(nombreReal)))
                        Lista.insertarInicio(((E)(i.informacion)));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por poder */
    
    public ListaDoblementeEnlazada<E> ListaPoderTal(String poder){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
            for(Nodo i = cabeza; i != null; i = i.siguiente){
                String [] temp = ((SuperHeroe)(i.informacion)).getPoder().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(poder)))
                        Lista.insertarInicio(((E)(i.informacion)));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por autor*/
    
    public ListaDoblementeEnlazada<E> ListaAutorTal(String autor){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
            for(Nodo i = cabeza; i != null; i = i.siguiente){
                String [] temp = ((SuperHeroe)(i.informacion)).getAutor().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(autor)))
                        Lista.insertarInicio(((E)(i.informacion)));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por origen*/
    
    public ListaDoblementeEnlazada<E> ListaOrigenTal(String origen){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
            for(Nodo i = cabeza; i != null; i = i.siguiente){
                String [] temp = ((SuperHeroe)(i.informacion)).getOrigen().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(origen)))
                        Lista.insertarInicio(((E)(i.informacion)));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por comic*/
    
    public ListaDoblementeEnlazada<E> ListaComicTal(String comic){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
            for(Nodo i = cabeza; i != null; i = i.siguiente){
                String [] temp = ((SuperHeroe)(i.informacion)).getComic().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(comic)))
                        Lista.insertarInicio(((E)(i.informacion)));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por afiliacion*/
    
    public ListaDoblementeEnlazada<E> ListaAfiliacionTal(String afiliacion){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
            for(Nodo i = cabeza; i != null; i = i.siguiente){
                String [] temp = ((SuperHeroe)(i.informacion)).getAfiliacionActual().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(afiliacion)))
                        Lista.insertarInicio(((E)(i.informacion)));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por raza*/
    
    public ListaDoblementeEnlazada<E> ListaRazaTal(String raza){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
            for(Nodo i = cabeza; i != null; i = i.siguiente){
                String [] temp = ((SuperHeroe)(i.informacion)).getRaza().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(raza)))
                        Lista.insertarInicio(((E)(i.informacion)));
            }
        return Lista;
    }
    
    //#Metodo pendiente (Tal vez no incluirlo)*/
    public ListaDoblementeEnlazada<E> ListaDebilidadTal(String debilidad){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
            for(Nodo i = cabeza; i != null; i = i.siguiente){
                String [] temp = ((SuperHeroe)(i.informacion)).getDebilidad().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(debilidad)))
                        Lista.insertarInicio(((E)(i.informacion)));
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
            for(Nodo i = cabeza; i != null; i = i.siguiente){
                if(((SuperHeroe)(i.informacion)).getSexo() == sexo)
                    Lista.insertarInicio(((E)(i.informacion)));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por año / años de aparicion*/
    
    public ListaDoblementeEnlazada<E> ListaAñoAparicionTal(int añoAparicion){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
            for(Nodo i = cabeza; i != null; i = i.siguiente){
                for(int j = 0; j < ((SuperHeroe)(i.informacion)).getAñoAparicion().length; j++)
                    if(((SuperHeroe)(i.informacion)).getAñoAparicion()[j] == añoAparicion)
                         Lista.insertarInicio(((E)(i.informacion)));
            }
        return Lista;
    }
    
    public E getInfo(Nodo temp){ 
        if(temp != null)
            return temp.informacion;
        return null;
    }
    
    public Nodo getCabeza() {
        return cabeza;
    }
    
    public Nodo getFin() {
        return fin;
    }
    
    /** indica si la Lista está vacia */
    private boolean estaVacia() {
        boolean vacia = false;
        if ( cabeza == null ) {
            vacia = true;
        }
        return vacia;
    }

    /** enlaza dos nodos mediante enlace doble */
    private void enlazar(Nodo nodoA, Nodo nodoB) {
        nodoA.siguiente = nodoB;
        nodoB.anterior = nodoA;
    }

    /** inserta un nuevo nodo al inicio de la Lista */
    public void insertarInicio(E ndato) {
        Nodo nuevo = new Nodo();
        nuevo.informacion = ndato;
        if ( estaVacia() ) {
            cabeza = nuevo;
            fin = nuevo;
        } else {
            enlazar(nuevo, cabeza);
            cabeza = nuevo;
        }
    }
    
    /** inserta un nuevo nodo al final de la Lista */
    public void insertarFinal(E ndato) {
        Nodo nuevo = new Nodo();
        nuevo.informacion = ndato;
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
            Nodo primero = cabeza.siguiente;
            if ( primero == null ) {
                cabeza = null;
                fin = null;
            } else {
                primero.anterior = null;
                cabeza = primero;
            }
        }
    }

    /** elimina el nodo del final de la Lista */
    public void eliminarFinal() {
        if ( !estaVacia() ) {
            Nodo ultimo = fin.anterior;
            if ( ultimo == null ) {
                cabeza = null;
                fin = null;
            } else {
                ultimo.siguiente = null;
                fin = ultimo;
            }
        }
    }

    /** devuelve una referencia al nodo buscado, si no se encuentra devuelve null */
    public Nodo buscar(E dato) {
        Nodo buscado = null;
        Nodo iterador = cabeza;
        while ( buscado == null && iterador != null ) {
            if ( iterador.informacion.equals(dato) ) {
                buscado = iterador;
            }
            iterador = iterador.siguiente;
        }
        return buscado;
    }

    /** muestra los valores en la Lista */
    public void mostrar(Nodo n) {
        Nodo iterador = n;
        boolean flag  = false;
        if (n == cabeza) flag = true;
        while ( iterador != null ) {
            System.out.print( iterador.informacion + " -> " );
            if (flag) iterador = iterador.siguiente;
            else      iterador = iterador.anterior;
        }
        System.out.println( "null" );
    }

}
