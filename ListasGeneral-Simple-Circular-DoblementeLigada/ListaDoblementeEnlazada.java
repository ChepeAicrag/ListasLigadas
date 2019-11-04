import java.text.Normalizer;
import java.util.*;
import java.io.*;

public class ListaDoblementeEnlazada<E> implements Lista <E>{
    private Nodo cabeza;
    private Nodo fin;
    
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
    
    /** Indica si la Lista está vacia */
    public boolean estaVacia() {
        boolean vacia = false;
        if ( cabeza == null ) {
            vacia = true;
        }
        return vacia;
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
    
   /** Metodo termiando para buscar por alias */
    public ListaDoblementeEnlazada<E> ListaAliasTal(String alias){
        ListaDoblementeEnlazada<E> Lista = new ListaDoblementeEnlazada();
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAlias().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(alias)))
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
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(nombreReal).trim()))
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
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(poder).trim()))
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
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(autor).trim()))
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
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(origen).trim()))
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
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(comic).trim()))
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
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(afiliacion).trim()))
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
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(raza).trim()))
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
   
    //# Agregando Eliminar
    
    /** Metodo termiando para eliminar con alias */
    public void EliminarConAliasTal(String alias){
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAlias().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(alias)))
                        Eliminar(((E)(i.getInformacion())));
            }
    }
    
    /** Metodo termiando para eliminar con nombre real */
    public void EliminarConNombreRealTal(String nombreReal){
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getNombreReal().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(nombreReal)))
                        Eliminar(((E)(i.getInformacion())));
            }
    }
    
    /** Metodo termiando para eliminar con poder */
    public void EliminarConPoderTal(String poder){
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getPoder().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(poder)))
                        Eliminar(((E)(i.getInformacion())));
            }
    }
    
    /** Metodo termiando para eliminar con autor*/
    public void EliminarConAutorTal(String autor){
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAutor().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(autor)))
                        Eliminar(((E)(i.getInformacion())));
            }
    }
    
    /** Metodo termiando para eliminar con origen*/
    public void EliminarConOrigenTal(String origen){
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getOrigen().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(origen)))
                        Eliminar(((E)(i.getInformacion())));
            }
    }
    
    /** Metodo termiando para eliminar con comic*/
    public void EliminarConComicTal(String comic){
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getComic().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(comic)))
                        Eliminar(((E)(i.getInformacion())));
            }
    }
    
    /** Metodo termiando para eliminar con afiliacion*/
    public void EliminarConAfiliacionTal(String afiliacion){
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAfiliacionActual().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(afiliacion)))
                        Eliminar(((E)(i.getInformacion())));
            }
    }
    
    /** Metodo termiando para eliminar con raza*/
    public void EliminarConRazaTal(String raza){
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getRaza().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(raza)))
                        Eliminar(((E)(i.getInformacion())));
            }
    }
    
    /** Metodo termiando para eliminar con sexo */
    public void EliminarConSexoTal(char sexo){
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                if(((SuperHeroe)(i.getInformacion())).getSexo() == sexo)
                    Eliminar(((E)(i.getInformacion())));
            }
    }
    
    /** Metodo termiando para eliminar con año / años de aparicion*/
    public void EliminarConAñoAparicionTal(int añoAparicion){
            for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
                for(int j = 0; j < ((SuperHeroe)(i.getInformacion())).getAñoAparicion().length; j++)
                    if(((SuperHeroe)(i.getInformacion())).getAñoAparicion()[j] == añoAparicion)
                         Eliminar(((E)(i.getInformacion())));
            }
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y poder tal*/
    public ListaDoblementeEnlazada<E> ListaEliminandoConSexoYPoderTal(Lista<E> listaOriginal,char sexo, String poder){
        ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal; //Clonamos la lista  
        lista.EliminarConSexoTal(sexo);
        lista.EliminarConPoderTal(poder);
        return lista; //Se retorna dicha lista clonada, ya con elementos eliminados
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y año tal*/
    public ListaDoblementeEnlazada<E> ListaEliminandoConSexoYAñoAparicionTal(Lista<E> listaOriginal,char sexo, int añoAparicion){
        ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
        lista.EliminarConSexoTal(sexo);
        lista.EliminarConAñoAparicionTal(añoAparicion);
        return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y autor tal*/
    public ListaDoblementeEnlazada<E> ListaEliminandoConSexoYAutorTal(Lista<E> listaOriginal,char sexo, String autor){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConSexoTal(sexo);
         lista.EliminarConAutorTal(autor);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y origen tal*/
    public ListaDoblementeEnlazada<E> ListaEliminandoConSexoYOrigenTal(Lista<E> listaOriginal,char sexo, String origen){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConSexoTal(sexo);
         lista.EliminarConOrigenTal(origen);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y comic tal*/
    public  ListaDoblementeEnlazada<E> ListaEliminandoConSexoYComicTal(Lista<E> listaOriginal,char sexo, String comic){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConSexoTal(sexo);
         lista.EliminarConComicTal(comic);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y afiliacion tal*/
    public  ListaDoblementeEnlazada<E> ListaEliminandoConSexoYAfiliacionTal(Lista<E> listaOriginal,char sexo, String afiliacion){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConSexoTal(sexo);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y raza tal*/
    public  ListaDoblementeEnlazada<E> ListaEliminandoConSexoYRazaTal(Lista<E> listaOriginal,char sexo, String raza){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConSexoTal(sexo);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y año tal*/
    public ListaDoblementeEnlazada<E> ListaEliminandoConPoderYAñoAparicionTal(Lista<E> listaOriginal,String poder, int añoAparicion){
        ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
        lista.EliminarConPoderTal(poder);
        lista.EliminarConAñoAparicionTal(añoAparicion);
        return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y autor tal*/
    public ListaDoblementeEnlazada<E> ListaEliminandoConPoderYAutorTal(Lista<E> listaOriginal,String poder, String autor){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConPoderTal(poder);
         lista.EliminarConAutorTal(autor);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y origen tal*/
    public ListaDoblementeEnlazada<E> ListaEliminandoConPoderYOrigenTal(Lista<E> listaOriginal,String poder, String origen){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConPoderTal(poder);
         lista.EliminarConOrigenTal(origen);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y comic tal*/
    public  ListaDoblementeEnlazada<E> ListaEliminandoConPoderYComicTal(Lista<E> listaOriginal,String poder, String comic){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConPoderTal(poder);
         lista.EliminarConComicTal(comic);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y afiliacion tal*/
    public  ListaDoblementeEnlazada<E> ListaEliminandoConPoderYAfiliacionTal(Lista<E> listaOriginal,String poder, String afiliacion){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConPoderTal(poder);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y raza tal*/
    public  ListaDoblementeEnlazada<E> ListaEliminandoConPoderYRazaTal(Lista<E> listaOriginal,String poder, String raza){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConPoderTal(poder);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con año y autor tal*/
    public ListaDoblementeEnlazada<E> ListaEliminandoConAñoAparicionYAutorTal(Lista<E> listaOriginal,int añoAparicion, String autor){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConAñoAparicionTal(añoAparicion);
         lista.EliminarConAutorTal(autor);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con año y origen tal*/
    public ListaDoblementeEnlazada<E> ListaEliminandoConAñoAparicionYOrigenTal(Lista<E> listaOriginal,int añoAparicion, String origen){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConAñoAparicionTal(añoAparicion);
         lista.EliminarConOrigenTal(origen);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con año y comic tal*/
    public  ListaDoblementeEnlazada<E> ListaEliminandoConAñoAparicionYComicTal(Lista<E> listaOriginal,int añoAparicion, String comic){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConAñoAparicionTal(añoAparicion);
         lista.EliminarConComicTal(comic);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con año y afiliacion tal*/
    public  ListaDoblementeEnlazada<E> ListaEliminandoConAñoAparicionYAfiliacionTal(Lista<E> listaOriginal,int añoAparicion, String afiliacion){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConAñoAparicionTal(añoAparicion);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con año y raza tal*/
    public  ListaDoblementeEnlazada<E> ListaEliminandoConAñoAparicionYRazaTal(Lista<E> listaOriginal,int añoAparicion, String raza){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConAñoAparicionTal(añoAparicion);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con autor y origen tal*/
    public ListaDoblementeEnlazada<E> ListaEliminandoConAutorYOrigenTal(Lista<E> listaOriginal,String autor, String origen){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConAutorTal(autor);
         lista.EliminarConOrigenTal(origen);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con autor y comic tal*/
    public  ListaDoblementeEnlazada<E> ListaEliminandoConAutorYComicTal(Lista<E> listaOriginal,String autor, String comic){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConAutorTal(autor);
         lista.EliminarConComicTal(comic);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con autor y afiliacion tal*/
    public  ListaDoblementeEnlazada<E> ListaEliminandoConAutorYAfiliacionTal(Lista<E> listaOriginal,String autor, String afiliacion){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConAutorTal(autor);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con autor y raza tal*/
    public  ListaDoblementeEnlazada<E> ListaEliminandoConAutorYRazaTal(Lista<E> listaOriginal,String autor, String raza){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConAutorTal(autor);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con origen y comic tal*/
    public  ListaDoblementeEnlazada<E> ListaEliminandoConOrigenYComicTal(Lista<E> listaOriginal,String origen, String comic){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConOrigenTal(origen);
         lista.EliminarConComicTal(comic);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con origen y afiliacion tal*/
    public  ListaDoblementeEnlazada<E> ListaEliminandoConOrigenYAfiliacionTal(Lista<E> listaOriginal,String origen, String afiliacion){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConOrigenTal(origen);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con origen y raza tal*/
    public  ListaDoblementeEnlazada<E> ListaEliminandoConOrigenYRazaTal(Lista<E> listaOriginal,String origen, String raza){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConOrigenTal(origen);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con y afiliacion tal*/
    public  ListaDoblementeEnlazada<E> ListaEliminandoConComicYAfiliacionTal(Lista<E> listaOriginal,String comic, String afiliacion){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConComicTal(comic);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con y raza tal*/
    public  ListaDoblementeEnlazada<E> ListaEliminandoConComicYRazaTal(Lista<E> listaOriginal,String comic, String raza){
         ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
         lista.EliminarConComicTal(comic);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con afiliacion y raza tal*/
    public ListaDoblementeEnlazada<E> ListaEliminandoConAfiliacionYRazaTal(Lista<E> listaOriginal,String afiliacion, String raza){
        ListaDoblementeEnlazada<E> lista = (ListaDoblementeEnlazada<E>)listaOriginal;
        lista.EliminarConAfiliacionTal(afiliacion); 
        lista.EliminarConRazaTal(raza);
        return lista;
    }
}
