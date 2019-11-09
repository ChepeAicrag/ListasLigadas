
/**
 * Clase de una Lista Doblemente Enlazada (LDE)
   */

import java.text.Normalizer;
import java.util.*;
import java.io.*;

public class ListaDoblementeEnlazada<E> implements Lista <E>{
    private Nodo cabeza;
    private Nodo fin;
    
    /** Constructor que crea una LDE vacia. */
    
    public ListaDoblementeEnlazada() {
        cabeza = null;
        fin = null;
    }
    
    /** Método que retorna información de un nodo */
    
    public E getInfoNodo(Nodo temp){ 
        if(temp != null)
            return (E)temp.getInformacion();
        return null;
    }
    
    /** Método que retorna el primer nodo de la lista (cabeza) */
    
    public Nodo getCabeza() {
        return cabeza;
    }
    
    /** Método que retorna el ultimo nodo de la lista (fin) */
    
    public Nodo getFin() {
        return fin;
    }
    
    /** Método que muestra la lista, comenzando en la cabeza */
    
    public void mostrarLista(){
        mostrar(cabeza);
    }
    
    /** Método que retorna el nodo anterior al que estamos buscando */
    
    public Nodo getAnterior(E x){
        Nodo actual = buscar(x);
        return actual.getAnterior();
    }
    
    /** Indica si la Lista está vacia */
    
    public boolean estaVacia() {
        return cabeza == null;
    }

    /** Enlaza dos nodos mediante enlace doble */
    
    private void enlazar(Nodo nodoA, Nodo nodoB) {
        nodoA.setSiguiente(nodoB);
        nodoB.setAnterior(nodoA);
    }

    /** Insertar un nuevo nodo al inicio de la Lista */
    
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
    
    /** Insertar un nuevo nodo al final de la Lista */
    
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

    /** Elimina el nodo del frente de la Lista */
    
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

    /** Elimina el nodo del final de la Lista */
    
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
    
    /** Elimina un nodo independientement del lugar en la lista */
    
    public void Eliminar(E x){
        if(buscar(x) == null )
            StdOut.println("No está en la lista");
        else{
           if(buscar(x) == fin)
                eliminarFinal();
           if(buscar(x) == cabeza)
                eliminarInicio();
           else{
               Nodo temp = buscar(x).getAnterior();
               Nodo temp2 = buscar(x).getSiguiente();
               temp.setSiguiente(temp2);
               temp2.setAnterior(temp);
            }     
         }
    }
    
    /** Devuelve una referencia al nodo buscado, si no se encuentra devuelve null */
    
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

    /** Muestra los valores en la Lista */
    
    private void mostrar(Nodo n) {
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
    
    /** Llenar una Lista desde archivo */
    
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
     * Metodos para buscar por cada atributo
     * 
       */
    
   /** Metodo para buscar por alias */
   
    public ListaDoblementeEnlazada<E> ListaAliasTal(String alias){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia())
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAlias().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(alias)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        else
            StdOut.println("Se retornara una lista vacia");
        return Lista;
    }
    
    /** Método para buscar por nombre real */
    
    public ListaDoblementeEnlazada<E> ListaNombreRealTal(String nombreReal){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia())
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getNombreReal().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(nombreReal).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        else
            StdOut.println("Se retornara una lista vacia");    
        return Lista;
    }
    
    /** Método para buscar por poder */
    
    public ListaDoblementeEnlazada<E> ListaPoderTal(String poder){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia())
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getPoder().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(poder).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        else
            StdOut.println("Se retornara una lista vacia");    
        return Lista;
    }
    
    /** Método para buscar por autor*/
    
    public ListaDoblementeEnlazada<E> ListaAutorTal(String autor){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia())
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAutor().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(autor).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        else
            StdOut.println("Se retornara una lista vacia");    
        return Lista;
    }
    
    /** Método para buscar por origen*/
    
    public ListaDoblementeEnlazada<E> ListaOrigenTal(String origen){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia())
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getOrigen().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(origen).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        else
            StdOut.println("Se retornara una lista vacia");    
        return Lista;
    }
    
    /** Método para buscar por comic*/
    
    public ListaDoblementeEnlazada<E> ListaComicTal(String comic){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia())
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getComic().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(comic).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        else
            StdOut.println("Se retornara una lista vacia");    
        return Lista;
    }
    
    /** Método para buscar por afiliacion*/
    
    public ListaDoblementeEnlazada<E> ListaAfiliacionTal(String afiliacion){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia())
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAfiliacionActual().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(afiliacion).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        else
            StdOut.println("Se retornara una lista vacia");    
        return Lista;
    }
    
    /** Método para buscar por raza*/
    
    public ListaDoblementeEnlazada<E> ListaRazaTal(String raza){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia())
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getRaza().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(raza).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        else
            StdOut.println("Se retornara una lista vacia");    
        return Lista;
    }
    
    /**Metodo para qutar las tildes de un string, para hacer mas eficiente la busqueda*/
    
    private static String cleanString(String info) {
        info = Normalizer.normalize(info, Normalizer.Form.NFD);
        info = info.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return info;
    }
    
    /** Método para buscar por sexo */
    
    public ListaDoblementeEnlazada<E> ListaSexoTal(char sexo){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia())
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                if(((SuperHeroe)(i.getInformacion())).getSexo() == sexo)
                    Lista.insertarInicio(((E)(i.getInformacion())));
            }
        else
            StdOut.println("Se retornara una lista vacia");    
        return Lista;
    }
    
    /** Método para buscar por año / años de aparicion*/
    
    public ListaDoblementeEnlazada<E> ListaAñoAparicionTal(int añoAparicion){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia())
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                for(int j = 0; j < ((SuperHeroe)(i.getInformacion())).getAñoAparicion().length; j++)
                    if(((SuperHeroe)(i.getInformacion())).getAñoAparicion()[j] == añoAparicion)
                         Lista.insertarInicio(((E)(i.getInformacion())));
            }
        else
            StdOut.println("Se retornara una lista vacia");    
        return Lista;
    }
    
    /**
     * 
     * Metodos combinados que generan una Lista, apartir de una lista (Filtrado)
     * 
     */
    
    /** Método para buscar por sexo y poder tal*/
    
    public ListaDoblementeEnlazada<E> ListaSexoYPoderTal(char sexo, String poder){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia()){
            Lista = ListaSexoTal(sexo); //Te entrega una Lista de sexo tal 
            Lista.ListaPoderTal(poder); //Te regresa quienes tienen el poder, sobre esa misma Lista
        }else
            StdOut.println("Se retornara una lista vacia");  
        return Lista;    
    }
    
    /** Método para buscar por sexo y año tal*/
    
    public ListaDoblementeEnlazada<E> ListaSexoYAñoAparicionTal(char sexo, int añoAparicion){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia()){
            Lista = ListaSexoTal(sexo);
            Lista.ListaAñoAparicionTal(añoAparicion);
        }else
            StdOut.println("Se retornara una lista vacia");
        return Lista;
    }
    
    /** Método para buscar por sexo y autor tal*/
    
    public ListaDoblementeEnlazada<E> ListaSexoYAutorTal(char sexo, String autor){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia()){
            Lista = ListaSexoTal(sexo);
            Lista.ListaAutorTal(autor);
        }else
            StdOut.println("Se retornara una lista vacia");
        return Lista; 
    }
    
    /** Método para buscar por sexo y origen tal*/
    
    public ListaDoblementeEnlazada<E> ListaSexoYOrigenTal(char sexo, String origen){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia()){
            Lista = ListaSexoTal(sexo);
            Lista.ListaOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia");
        return Lista;
    }
    
    /** Método para buscar por sexo y comic tal*/
    
    public  ListaDoblementeEnlazada<E> ListaSexoYComicTal(char sexo, String comic){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia()){
            Lista = ListaSexoTal(sexo);
            Lista.ListaComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia");
        return Lista;
    }
    
    /** Método para buscar por sexo y afiliacion tal*/
    
    public  ListaDoblementeEnlazada<E> ListaSexoYAfiliacionTal(char sexo, String afiliacion){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia()){
            Lista = ListaSexoTal(sexo);
            Lista.ListaAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia");    
        return Lista; 
    }
    
    /** Método para buscar por sexo y raza tal*/
    
    public  ListaDoblementeEnlazada<E> ListaSexoYRazaTal(char sexo, String raza){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia()){
            Lista = ListaSexoTal(sexo);
            Lista.ListaRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia");     
        return Lista;
    }
    
    /** Método para buscar por poder y año tal*/
    
    public ListaDoblementeEnlazada<E> ListaPoderYAñoAparicionTal(String poder, int añoAparicion){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia()){
            Lista = ListaPoderTal(poder);
            Lista.ListaAñoAparicionTal(añoAparicion);
        }else
            StdOut.println("Se retornara una lista vacia");     
        return Lista;
    }
    
    /** Método para buscar por poder y autor tal*/
    
    public ListaDoblementeEnlazada<E> ListaPoderYAutorTal(String poder, String autor){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia()){
            Lista = ListaPoderTal(poder);
            Lista.ListaAutorTal(autor);
        }else
            StdOut.println("Se retornara una lista vacia");       
        return Lista;
    }
    
    /** Método para buscar por poder y origen tal*/
    
    public ListaDoblementeEnlazada<E> ListaPoderYOrigenTal(String poder, String origen){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia()){
            Lista = ListaPoderTal(poder);
            Lista.ListaOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia");    
        return Lista;
    }
    
    /** Método para buscar por poder y comic tal*/
    
    public  ListaDoblementeEnlazada<E> ListaPoderYComicTal(String poder, String comic){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia()){
            Lista = ListaPoderTal(poder);
            Lista.ListaComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;
    }
    
    /** Método para buscar por poder y afiliacion tal*/
    
    public  ListaDoblementeEnlazada<E> ListaPoderYAfiliacionTal(String poder, String afiliacion){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia()){
            Lista = ListaPoderTal(poder);
            Lista.ListaAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;    
    }
    
    /** Método para buscar por poder y raza tal*/
    
    public  ListaDoblementeEnlazada<E> ListaPoderYRazaTal(String poder, String raza){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia()){
            Lista = ListaPoderTal(poder);
            Lista.ListaRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;
    }
    
    /** Método para buscar por año y autor tal*/
    
    public ListaDoblementeEnlazada<E> ListaAñoAparicionYAutorTal(int añoAparicion, String autor){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia()){
            Lista = ListaAñoAparicionTal(añoAparicion);
            Lista.ListaAutorTal(autor);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;
    }
    
    /** Método para buscar por año y origen tal*/
    
    public ListaDoblementeEnlazada<E> ListaAñoAparicionYOrigenTal(int añoAparicion, String origen){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia()){
            Lista = ListaAñoAparicionTal(añoAparicion);
            Lista.ListaOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;
    }
    
    /** Método para buscar por año y comic tal*/
    
    public  ListaDoblementeEnlazada<E> ListaAñoAparicionYComicTal(int añoAparicion, String comic){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia()){
            Lista = ListaAñoAparicionTal(añoAparicion);
            Lista.ListaComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista; 
    }
    
    /** Método para buscar por año y afiliacion tal*/
    
    public  ListaDoblementeEnlazada<E> ListaAñoAparicionYAfiliacionTal(int añoAparicion, String afiliacion){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia()){
            Lista = ListaAñoAparicionTal(añoAparicion);
            Lista.ListaAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;  
    }
    
    /** Método para buscar por año y raza tal*/
    
    public  ListaDoblementeEnlazada<E> ListaAñoAparicionYRazaTal(int añoAparicion, String raza){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia()){
            Lista = ListaAñoAparicionTal(añoAparicion);
            Lista.ListaRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista; 
    }
    
    /** Método para buscar por autor y origen tal*/
    
    public ListaDoblementeEnlazada<E> ListaAutorYOrigenTal(String autor, String origen){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia()){
            Lista = ListaAutorTal(autor);
            Lista.ListaOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;
    }
    
    /** Método para buscar por autor y comic tal*/
    
    public  ListaDoblementeEnlazada<E> ListaAutorYComicTal(String autor, String comic){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia()){
            Lista = ListaAutorTal(autor);
            Lista.ListaComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;
    }
    
    /** Método para buscar por autor y afiliacion tal*/
    
    public  ListaDoblementeEnlazada<E> ListaAutorYAfiliacionTal(String autor, String afiliacion){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
        if(!estaVacia()){
            Lista = ListaAutorTal(autor);
            Lista.ListaAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista; 
    }
    
    /** Método para buscar por autor y raza tal*/
    
    public  ListaDoblementeEnlazada<E> ListaAutorYRazaTal(String autor, String raza){
        ListaDoblementeEnlazada<E> Lista = ListaAutorTal(autor);
        if(!estaVacia()){
            Lista = ListaAutorTal(autor);
            Lista.ListaRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista; 
    }
    
    /** Método para buscar por origen y comic tal*/
    
    public  ListaDoblementeEnlazada<E> ListaOrigenYComicTal(String origen, String comic){
        ListaDoblementeEnlazada<E> Lista = ListaOrigenTal(origen);
        if(!estaVacia()){
            Lista = ListaOrigenTal(origen);
            Lista.ListaComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista; 
    }
    
    /** Método para buscar por origen y afiliacion tal*/
    
    public  ListaDoblementeEnlazada<E> ListaOrigenYAfiliacionTal(String origen, String afiliacion){
        ListaDoblementeEnlazada<E> Lista = ListaOrigenTal(origen);
        if(!estaVacia()){
            Lista = ListaOrigenTal(origen);
            Lista.ListaAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;
    }
    
    /** Método para buscar por origen y raza tal*/
    
    public  ListaDoblementeEnlazada<E> ListaOrigenYRazaTal(String origen, String raza){
        ListaDoblementeEnlazada<E> Lista = ListaOrigenTal(origen);
        if(!estaVacia()){
            Lista = ListaOrigenTal(origen);
            Lista.ListaRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista; 
    }
    
    /** Método para buscar por comic y afiliacion tal*/
    
    public  ListaDoblementeEnlazada<E> ListaComicYAfiliacionTal(String comic, String afiliacion){
        ListaDoblementeEnlazada<E> Lista = ListaComicTal(comic);
        if(!estaVacia()){
            Lista = ListaComicTal(comic);
            Lista.ListaAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista; 
    }
    
    /** Método para buscar por comic y raza tal*/
    
    public  ListaDoblementeEnlazada<E> ListaComicYRazaTal(String comic, String raza){
        ListaDoblementeEnlazada<E> Lista = ListaComicTal(comic);
        if(!estaVacia()){
            Lista = ListaComicTal(comic);
            Lista.ListaRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;
    }
    
    /** Método para buscar por afiliacion y raza tal*/
    
    public  ListaDoblementeEnlazada<E> ListaAfiliacionYRazaTal(String afiliacion, String raza){
        ListaDoblementeEnlazada<E> Lista = ListaAfiliacionTal(afiliacion);
        if(!estaVacia()){
            Lista = ListaAfiliacionTal(afiliacion);
            Lista.ListaRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista; 
    }
   
    /**
     * 
     * Metodos para eliminar por cada atributo
     * 
       */
    
    /** Método para eliminar con alias */
    
    public void EliminarConAliasTal(String alias){
        if(!estaVacia())
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAlias().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(alias)))
                        Eliminar(((E)(i.getInformacion())));
            }
        else
            StdOut.println("La lista está vacia, no se puede eliminar");
    }
    
    /** Método para eliminar con nombre real */
    
    public void EliminarConNombreRealTal(String nombreReal){
        if(!estaVacia())
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getNombreReal().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(nombreReal)))
                        Eliminar(((E)(i.getInformacion())));
            }
        else
            StdOut.println("La lista está vacia, no se puede eliminar");    
    }
    
    /** Método para eliminar con poder */
    
    public void EliminarConPoderTal(String poder){
        if(!estaVacia())
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getPoder().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(poder)))
                        Eliminar(((E)(i.getInformacion())));
            }
        else
            StdOut.println("La lista está vacia, no se puede eliminar");    
    }
    
    /** Método para eliminar con autor */
    
    public void EliminarConAutorTal(String autor){
        if(!estaVacia())
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAutor().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(autor)))
                        Eliminar(((E)(i.getInformacion())));
            }
        else
            StdOut.println("La lista está vacia, no se puede eliminar");    
    }
    
    /** Método para eliminar con origen */
    
    public void EliminarConOrigenTal(String origen){
        if(!estaVacia())
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getOrigen().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(origen)))
                        Eliminar(((E)(i.getInformacion())));
            }
        else
            StdOut.println("La lista está vacia, no se puede eliminar");    
    }
    
    /** Método para eliminar con comic */
    
    public void EliminarConComicTal(String comic){
        if(!estaVacia())
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getComic().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(comic)))
                        Eliminar(((E)(i.getInformacion())));
            }
        else
            StdOut.println("La lista está vacia, no se puede eliminar");    
    }
    
    /** Método para eliminar con afiliacion */
    
    public void EliminarConAfiliacionTal(String afiliacion){
        if(!estaVacia())
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAfiliacionActual().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(afiliacion)))
                        Eliminar(((E)(i.getInformacion())));
            }
        else
            StdOut.println("La lista está vacia, no se puede eliminar");    
    }
    
    /** Método para eliminar con raza */
    
    public void EliminarConRazaTal(String raza){
        if(!estaVacia())
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getRaza().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(raza)))
                        Eliminar(((E)(i.getInformacion())));
            }
        else
            StdOut.println("La lista está vacia, no se puede eliminar");    
    }
    
    /** Método para eliminar con sexo */
    
    public void EliminarConSexoTal(char sexo){
        if(!estaVacia())
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                if(((SuperHeroe)(i.getInformacion())).getSexo() == sexo)
                    Eliminar(((E)(i.getInformacion())));
            }
        else
            StdOut.println("La lista está vacia, no se puede eliminar");    
    }
    
    /** Método para eliminar con año / años de aparicion */
    
    public void EliminarConAñoAparicionTal(int añoAparicion){
        if(!estaVacia())
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                for(int j = 0; j < ((SuperHeroe)(i.getInformacion())).getAñoAparicion().length; j++)
                    if(((SuperHeroe)(i.getInformacion())).getAñoAparicion()[j] == añoAparicion)
                         Eliminar(((E)(i.getInformacion())));
            }
        else
            StdOut.println("La lista está vacia, no se puede eliminar");    
    }
    
    /**
     * 
     * Metodos para eliminar por dos diferentes atributos (Filtrado)
     * 
       */
    
    /** Método para obtener una lista eliminando con sexo y poder tal */
    
    public ListaDoblementeEnlazada<E> ListaEliminandoConSexoYPoderTal(Lista<E> listaOriginal,char sexo, String poder){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada(); //Clonamos la lista  
        if(!listaOriginal.estaVacia()){
           lista = (ListaDoblementeEnlazada<E>) listaOriginal;
           StdOut.printf("Eliminando con sexo \" %c \" y poder \" %s \" \n",sexo,poder);
           lista.EliminarConSexoTal(sexo);
           lista.EliminarConPoderTal(poder);
        }else
            StdOut.println("Se retornara una lista vacia");
        return lista;
    }
    
    /** Método para obtener una lista eliminando con sexo y año tal */
    
    public ListaDoblementeEnlazada<E> ListaEliminandoConSexoYAñoAparicionTal(Lista<E> listaOriginal,char sexo, int añoAparicion){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con sexo \" %c \" y año de aparición \" %d \" \n",sexo,añoAparicion);
            lista.EliminarConSexoTal(sexo);
            lista.EliminarConAñoAparicionTal(añoAparicion);
        }else
            StdOut.println("Se retornara una lista vacia");
        return lista;
    }
    
    /** Método para obtener una lista eliminando con sexo y autor tal */
    
    public ListaDoblementeEnlazada<E> ListaEliminandoConSexoYAutorTal(Lista<E> listaOriginal,char sexo, String autor){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con sexo \" %c \" y autor \" %s \" \n",sexo,autor);
            lista.EliminarConSexoTal(sexo);
            lista.EliminarConAutorTal(autor);
         }else
            StdOut.println("Se retornara una lista vacia");
        return lista;
    }
    
    /** Método para obtener una lista eliminando con sexo y origen tal */
    
    public ListaDoblementeEnlazada<E> ListaEliminandoConSexoYOrigenTal(Lista<E> listaOriginal,char sexo, String origen){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con sexo \" %c \" y origen \" %s \" \n",sexo,origen);
            lista.EliminarConSexoTal(sexo);
            lista.EliminarConOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia");
        return lista;
    }
    
    /** Método para obtener una lista eliminando con sexo y comic tal */
    
    public  ListaDoblementeEnlazada<E> ListaEliminandoConSexoYComicTal(Lista<E> listaOriginal,char sexo, String comic){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con sexo \" %c \" y comic \" %s \" \n",sexo,comic);
            lista.EliminarConSexoTal(sexo);
            lista.EliminarConComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia");    
        return lista;
    }
    
    /** Método para obtener una lista eliminando con sexo y afiliacion tal */
    
    public  ListaDoblementeEnlazada<E> ListaEliminandoConSexoYAfiliacionTal(Lista<E> listaOriginal,char sexo, String afiliacion){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con sexo \" %c \" y afiliación \" %s \" \n",sexo,afiliacion);
            lista.EliminarConSexoTal(sexo);
            lista.EliminarConAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return lista;
    }
    
    /** Método para obtener una lista eliminando con sexo y raza tal */
    
    public  ListaDoblementeEnlazada<E> ListaEliminandoConSexoYRazaTal(Lista<E> listaOriginal,char sexo, String raza){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con sexo \" %c \" y raza \" %s \" \n",sexo,raza);
            lista.EliminarConSexoTal(sexo);
            lista.EliminarConRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return lista;
    }
    
    /** Método para obtener una lista eliminando con poder y año tal */
    
    public ListaDoblementeEnlazada<E> ListaEliminandoConPoderYAñoAparicionTal(Lista<E> listaOriginal,String poder, int añoAparicion){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con poder \" %s \" y año de aparición \" %d \" \n",poder,añoAparicion);
            lista.EliminarConPoderTal(poder);
            lista.EliminarConAñoAparicionTal(añoAparicion);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return lista;
    }
    
    /** Método para obtener una lista eliminando con poder y autor tal */
    
    public ListaDoblementeEnlazada<E> ListaEliminandoConPoderYAutorTal(Lista<E> listaOriginal,String poder, String autor){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con poder \" %s \" y autor \" %s \" \n",poder,autor);
            lista.EliminarConPoderTal(poder);
            lista.EliminarConAutorTal(autor);
        }else
            StdOut.println("Se retornara una lista vacia");
         return lista;
    }
    
    /** Método para obtener una lista eliminando con poder y origen tal */
    
    public ListaDoblementeEnlazada<E> ListaEliminandoConPoderYOrigenTal(Lista<E> listaOriginal,String poder, String origen){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con poder \" %s \" y origen \" %s \" \n",poder,origen);
            lista.EliminarConPoderTal(poder);
            lista.EliminarConOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia");
         return lista;
    }
    
    /** Método para obtener una lista eliminando con poder y comic tal */
    
    public  ListaDoblementeEnlazada<E> ListaEliminandoConPoderYComicTal(Lista<E> listaOriginal,String poder, String comic){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con poder \" %s \" y comic \" %s \" \n",poder,comic);
            lista.EliminarConPoderTal(poder);
            lista.EliminarConComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia");
         return lista;
    }
    
    /** Método para obtener una lista eliminando con poder y afiliacion tal */
    
    public  ListaDoblementeEnlazada<E> ListaEliminandoConPoderYAfiliacionTal(Lista<E> listaOriginal,String poder, String afiliacion){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con poder \" %s \" y afiliacion \" %s \" \n",poder,afiliacion);
            lista.EliminarConPoderTal(poder);
            lista.EliminarConAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia");
         return lista;
    }
    
    /** Método para obtener una lista eliminando con poder y raza tal */
    
    public  ListaDoblementeEnlazada<E> ListaEliminandoConPoderYRazaTal(Lista<E> listaOriginal,String poder, String raza){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con poder \" %s \" y raza \" %s \" \n",poder,raza);
            lista.EliminarConPoderTal(poder);
            lista.EliminarConRazaTal(raza);
         }else
            StdOut.println("Se retornara una lista vacia");   
         return lista;
    }
    
    /** Método para obtener una lista eliminando con año y autor tal */
    
    public ListaDoblementeEnlazada<E> ListaEliminandoConAñoAparicionYAutorTal(Lista<E> listaOriginal,int añoAparicion, String autor){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con año aparicion \" %d \" y autor \" %s \" \n",añoAparicion,autor);
            lista.EliminarConAñoAparicionTal(añoAparicion);
            lista.EliminarConAutorTal(autor);
         }else
            StdOut.println("Se retornara una lista vacia");   
         return lista;
    }
    
    /** Método para obtener una lista eliminando con año y origen tal */
    
    public ListaDoblementeEnlazada<E> ListaEliminandoConAñoAparicionYOrigenTal(Lista<E> listaOriginal,int añoAparicion, String origen){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con año aparicion \" %d \" y origen \" %s \" \n",añoAparicion,origen);
            lista.EliminarConAñoAparicionTal(añoAparicion);
            lista.EliminarConOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia");   
         return lista;
    }
    
    /** Método para obtener una lista eliminando con año y comic tal */
    
    public  ListaDoblementeEnlazada<E> ListaEliminandoConAñoAparicionYComicTal(Lista<E> listaOriginal,int añoAparicion, String comic){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con año aparicion \" %d \" y comic \" %s \" \n",añoAparicion,comic);
            lista.EliminarConAñoAparicionTal(añoAparicion);
            lista.EliminarConComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener una lista eliminando con año y afiliacion tal */
    
    public  ListaDoblementeEnlazada<E> ListaEliminandoConAñoAparicionYAfiliacionTal(Lista<E> listaOriginal,int añoAparicion, String afiliacion){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con año aparicion \" %d \" y afiliacion \" %s \" \n",añoAparicion,afiliacion);
            lista.EliminarConAñoAparicionTal(añoAparicion);
            lista.EliminarConAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener una lista eliminando con año y raza tal */
    
    public  ListaDoblementeEnlazada<E> ListaEliminandoConAñoAparicionYRazaTal(Lista<E> listaOriginal,int añoAparicion, String raza){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con año aparicion \" %d \" y raza \" %s \" \n",añoAparicion,raza);
            lista.EliminarConAñoAparicionTal(añoAparicion);
            lista.EliminarConRazaTal(raza);
         }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener una lista eliminando con autor y origen tal */
    
    public ListaDoblementeEnlazada<E> ListaEliminandoConAutorYOrigenTal(Lista<E> listaOriginal,String autor, String origen){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con autor \" %s \" y origen \" %s \" \n",autor,origen);
            lista.EliminarConAutorTal(autor);
            lista.EliminarConOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener una lista eliminando con autor y comic tal */
    
    public  ListaDoblementeEnlazada<E> ListaEliminandoConAutorYComicTal(Lista<E> listaOriginal,String autor, String comic){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con autor \" %s \" y comic \" %s \" \n",autor,comic);
            lista.EliminarConAutorTal(autor);
            lista.EliminarConComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener una lista eliminando con autor y afiliacion tal */
    
    public  ListaDoblementeEnlazada<E> ListaEliminandoConAutorYAfiliacionTal(Lista<E> listaOriginal,String autor, String afiliacion){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con autor \" %s \" y afiliacion \" %s \" \n",autor,afiliacion);
            lista.EliminarConAutorTal(autor);
            lista.EliminarConAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener una lista eliminando con autor y raza tal */
    
    public  ListaDoblementeEnlazada<E> ListaEliminandoConAutorYRazaTal(Lista<E> listaOriginal,String autor, String raza){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con autor \" %s \" y raza \" %s \" \n",autor,raza);
            lista.EliminarConAutorTal(autor);
            lista.EliminarConRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener una lista eliminando con origen y comic tal */
    
    public  ListaDoblementeEnlazada<E> ListaEliminandoConOrigenYComicTal(Lista<E> listaOriginal,String origen, String comic){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con origen \" %s \" y comic \" %s \" \n",origen,comic);
            lista.EliminarConOrigenTal(origen);
            lista.EliminarConComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener una lista eliminando con origen y afiliacion tal */
    
    public  ListaDoblementeEnlazada<E> ListaEliminandoConOrigenYAfiliacionTal(Lista<E> listaOriginal,String origen, String afiliacion){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con origne \" %s \" y afiliacion \" %s \" \n",origen,afiliacion);
            lista.EliminarConOrigenTal(origen);
            lista.EliminarConAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener una lista eliminando con origen y raza tal */
    
    public  ListaDoblementeEnlazada<E> ListaEliminandoConOrigenYRazaTal(Lista<E> listaOriginal,String origen, String raza){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con origen \" %s \" y raza \" %s \" \n",origen,raza);
            lista.EliminarConOrigenTal(origen);
            lista.EliminarConRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener una lista eliminando con y afiliacion tal */
    
    public  ListaDoblementeEnlazada<E> ListaEliminandoConComicYAfiliacionTal(Lista<E> listaOriginal,String comic, String afiliacion){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con comic \" %s \" y afiliación \" %s \" \n",comic,afiliacion);
            lista.EliminarConComicTal(comic);
            lista.EliminarConAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener una lista eliminando con y raza tal */
    
    public  ListaDoblementeEnlazada<E> ListaEliminandoConComicYRazaTal(Lista<E> listaOriginal,String comic, String raza){
        ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
        if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con comic \" %s \" y raza \" %s \" \n",comic,raza);
            lista.EliminarConComicTal(comic);
            lista.EliminarConRazaTal(raza);
        }else
             StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener una lista eliminando con afiliacion y raza tal */
    
    public ListaDoblementeEnlazada<E> ListaEliminandoConAfiliacionYRazaTal(Lista<E> listaOriginal,String afiliacion, String raza){
       ListaDoblementeEnlazada<E> lista = new ListaDoblementeEnlazada();
       if(!listaOriginal.estaVacia()){
            lista = (ListaDoblementeEnlazada<E>) listaOriginal;
            StdOut.printf("Eliminando con afiliación \" %s \" y raza \" %s \" \n",afiliacion,raza);
            lista.EliminarConAfiliacionTal(afiliacion); 
            lista.EliminarConRazaTal(raza);
       }else
            StdOut.println("Se retornara una lista vacia");   
       return lista;
    }
}
