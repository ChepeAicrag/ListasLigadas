
/**
 * Clase de una Lista Doblemente Enlazada (LDE)
   */
  
import java.util.*;
import java.text.Normalizer;
import java.io.*;

public class LinkedListPlusRecursividadGenerico<E> implements Lista<E>{
    
    private Nodo raiz;
    
    public void LlenarListaDesdeArchivo(String nom) throws Exception{
        ObjectInputStream flujoObjetoEntrada = null;
        FileInputStream flujoArchivoEntrada = null;
        try{
            File archivoSalida = new File(nom+".obj");     
            flujoArchivoEntrada = new FileInputStream(archivoSalida);
            flujoObjetoEntrada = new ObjectInputStream(flujoArchivoEntrada);
            Object per = flujoObjetoEntrada.readObject();  
            System.out.println("Rellenando la Lista Simple...");
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
    
    public E getInfoNodo(Nodo temp){ 
        if(temp != null)
            return (E)temp.getInformacion();
        return null;
    }
    
    /** Método que retorna el primer nodo de la lista (cabeza) */
    
    public Nodo getCabeza(){
        return raiz;
    }
    
    /** Indica si la Lista está vacia */
    
    public boolean estaVacia(){
        return raiz == null;
    }
    
    /** Si solo queremos el nodo que está antes*/
    
    public Nodo AntesDe(E x){
        Nodo temp = null;
        if(x == null) //Si mandan un null devuelve al ultimo porque el apunta a null
            return getFin();
        if(buscar(x) != null) //Comprobar de lo que vamos a buscar existe
            if(raiz.getInformacion().equals(x)) //Caso especial de buscar antes de raiz
                return raiz;
             else 
                for(Nodo i = raiz; i.getSiguiente() != null; i = i.getSiguiente())
                    if(i.getSiguiente().getInformacion().equals(x))
                        temp = i;
        return temp; 
    }
    
    /** Si queremos la informacion de lo que está antes*/
    
    public E AntesDeInfo(E x){
        if(AntesDe(x) == null) //Si existe o no en la Lista
            return (E) "No está en la Lista";
        if( x == raiz.getInformacion()) //Debemos comprobar que si es raiz, antes no hay nadie, como es un apuntador, se evalua así, no requiere de casting    
            return  (E) "Nadie, eres el primero!!";
        return getInfoNodo(AntesDe(x));    
    }
    
    /** Si solo queremos el nodo que está despues*/
    
    public Nodo DespuesDe(E x){
        Nodo temp = null;
        if(buscar(x) != null)
              for(Nodo i = raiz; i != null; i = i.getSiguiente())
                  if(i.getInformacion().equals(x))
                     temp = i.getSiguiente();
        return temp; 
    }
    
    /** Si queremos la informacion del nodo que está despues */
    
    public E DespuesDeInfo(E x){
            if(!estaVacia())
               if(((SuperHeroe)getFin().getInformacion()).equals(x)) 
                   return (E) "Nadie eres el ultimo!!";        
            if(DespuesDe(x) == null && buscar(x) == null) 
                 return (E) "No está en la Lista";
        return getInfoNodo(DespuesDe(x));   
    }
    
    /** Devuelve una referencia al nodo buscado, si no se encuentra devuelve null */
    
    public Nodo buscar(E x){
       if(x != null) 
         for(Nodo i = raiz; i != null; i = i.getSiguiente())
            if(i.getInformacion().equals(x))
                return i;
        return null; 
    }
    
    
    /** Método que retorna el ultimo nodo de la lista (fin) */
    
    public Nodo getFin(){
        Nodo temp = null;
        for(Nodo i = raiz; i != null; i = i.getSiguiente())
            if(i.getSiguiente() == null)
            temp = i;
        return temp;    
    }
    
    /** Elimina un nodo independientement del lugar en la lista */
    
    public void Eliminar(E x){
        if(buscar(x) == null)
            StdOut.println("No está en la Lista");
        else{
            if(buscar(x) == raiz)
                eliminarInicio();
            else if(buscar(x) == getFin())
                eliminarFinal();
             else{
                 Nodo temp = AntesDe(x); 
                 if(temp!=null)
                 temp.setSiguiente(temp.getSiguiente().getSiguiente());
          }
        }
    }
    
    /** Elimina el nodo del final de la Lista */
    
    public void eliminarFinal(){
        if(!estaVacia()){
            Nodo temp = AntesDe((E)getFin().getInformacion());
            temp.setSiguiente(temp.getSiguiente().getSiguiente());
        }
    }
    
    /** Elimina el nodo del frente de la Lista */
    
    public void eliminarInicio(){
        if(!estaVacia()){
         raiz = DespuesDe((E)raiz.getInformacion());
        }
    }
    
    /** Insertar un nuevo nodo al inicio de la Lista */
    
    public void insertarInicio(E x) {
        Nodo nuevo = new Nodo ();
        nuevo.setInformacion(x);
        nuevo.setSiguiente(raiz);
        raiz       = nuevo;
    }
    
    /** Insertar un nuevo nodo al final de la Lista */
    
    public void insertarFinal(E x){
        Nodo nuevo = new Nodo();
        nuevo.setInformacion(x);
        nuevo.setSiguiente(null);
        getFin().setSiguiente(nuevo);
    }
    
    public String imprimirInversa(Nodo reco) {
        if (reco != null)
            return imprimirInversa(reco.getSiguiente()) + " " + reco.getInformacion();
        return "";    
    }
     
    public String imprimirNormal(Nodo reco) {
        if (reco != null)
            return  reco.getInformacion() + " " + imprimirNormal(reco.getSiguiente());
        return "";    
    }
    
    public void imprimirInversa () {
        if(raiz != null)
            StdOut.println(imprimirInversa(raiz));
        else
            StdOut.println("\t***** Lista Vacia *****");
    }
    
    public void mostrarLista(){
        if(raiz != null)
            StdOut.println(imprimirNormal(raiz));
        else
            StdOut.println("\t***** Lista Vacia *****");
    }

   /** Método para buscar por alias */
   
    public LinkedListPlusRecursividadGenerico<E> ListaAliasTal(String alias){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
        if(estaVacia())
            StdOut.println("Se retornara una lista vacia");
        else    
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAlias().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(alias).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Método para buscar por nombre real */
    
    public LinkedListPlusRecursividadGenerico<E> ListaNombreRealTal(String nombreReal){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
        if(estaVacia())
            StdOut.println("Se retornara una lista vacia");
        else 
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getNombreReal().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(nombreReal).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Método para buscar por poder */
    
    public LinkedListPlusRecursividadGenerico<E> ListaPoderTal(String poder){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
        if(estaVacia())
            StdOut.println("Se retornara una lista vacia");
        else 
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getPoder().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(poder).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Método para buscar por autor */
    
    public LinkedListPlusRecursividadGenerico<E> ListaAutorTal(String autor){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
        if(estaVacia())
            StdOut.println("Se retornara una lista vacia");
        else 
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAutor().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(autor).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Método para buscar por origen */
    
    public LinkedListPlusRecursividadGenerico<E> ListaOrigenTal(String origen){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
        if(estaVacia())
            StdOut.println("Se retornara una lista vacia");
        else 
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getOrigen().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(origen).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Método para buscar por comic */
    
    public LinkedListPlusRecursividadGenerico<E> ListaComicTal(String comic){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
        if(estaVacia())
            StdOut.println("Se retornara una lista vacia");
        else 
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getComic().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(comic).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Método para buscar por afiliacion */
    
    public LinkedListPlusRecursividadGenerico<E> ListaAfiliacionTal(String afiliacion){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
        if(estaVacia())
            StdOut.println("Se retornara una lista vacia");
        else 
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAfiliacionActual().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(afiliacion).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Método para buscar por raza */
    
    public LinkedListPlusRecursividadGenerico<E> ListaRazaTal(String raza){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
        if(estaVacia())
            StdOut.println("Se retornara una lista vacia");
        else 
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getRaza().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(raza).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Metodo para qutar las tildes de un string, para hacer mas eficiente la busqueda */
    
    private static String cleanString(String info) {
        info = Normalizer.normalize(info, Normalizer.Form.NFD);
        info = info.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return info;
    }
    
    /** Método para buscar por sexo */
    
    public LinkedListPlusRecursividadGenerico<E> ListaSexoTal(char sexo){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
        if(estaVacia())
            StdOut.println("Se retornara una lista vacia");
        else 
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                if(((SuperHeroe)(i.getInformacion())).getSexo() == sexo)
                    Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Método para buscar por año / años de aparicion */
    
    public LinkedListPlusRecursividadGenerico<E> ListaAñoAparicionTal(int añoAparicion){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
        if(estaVacia())
            StdOut.println("Se retornara una lista vacia");
        else 
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                for(int j = 0; j < ((SuperHeroe)(i.getInformacion())).getAñoAparicion().length; j++)
                    if(((SuperHeroe)(i.getInformacion())).getAñoAparicion()[j] == añoAparicion)
                         Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    
    /**
     * Metodos combiandos que generan Lista, apartir de Listas (Filtrado)
     * 
     */
    
    
    /** Método para buscar por sexo y poder tal */
    
    public LinkedListPlusRecursividadGenerico<E> ListaSexoYPoderTal(char sexo, String poder){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
        if(!estaVacia()){
            Lista = ListaSexoTal(sexo); //Te entrega una Lista de sexo tal 
            Lista = Lista.ListaPoderTal(poder);
        }else
            StdOut.println("Se retornara una lista vacia");
        return Lista; //Te regresa quienes tienen el poder, sobre esa misma Lista
    }
    
    /** Método para buscar por sexo y año tal */
    
    public LinkedListPlusRecursividadGenerico<E> ListaSexoYAñoAparicionTal(char sexo, int añoAparicion){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
        if(!estaVacia()){
            Lista = ListaSexoTal(sexo);
            Lista = Lista.ListaAñoAparicionTal(añoAparicion);
        }else
            StdOut.println("Se retornara una lista vacia");
        return Lista;
    }
    
    /** Método para buscar por sexo y autor tal */
    
    public LinkedListPlusRecursividadGenerico<E> ListaSexoYAutorTal(char sexo, String autor){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
        if(!estaVacia()){
            Lista = ListaSexoTal(sexo);
            Lista = Lista.ListaAutorTal(autor);
        }else
            StdOut.println("Se retornara una lista vacia");
        return Lista;
    }
    
    /** Método para buscar por sexo y origen tal */
    
    public LinkedListPlusRecursividadGenerico<E> ListaSexoYOrigenTal(char sexo, String origen){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
        if(!estaVacia()){
            Lista = ListaSexoTal(sexo);
            Lista = Lista.ListaOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia");
        return Lista;
    }
    
    /** Método para buscar por sexo y comic tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaSexoYComicTal(char sexo, String comic){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
         if(!estaVacia()){
            Lista = ListaSexoTal(sexo);
            Lista = Lista.ListaComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia");
        return Lista;
    }
    
    /** Método para buscar por sexo y afiliacion tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaSexoYAfiliacionTal(char sexo, String afiliacion){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
        if(!estaVacia()){
            Lista = ListaSexoTal(sexo);
            Lista = Lista.ListaAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia");    
        return Lista; 
    }
    
    /** Método para buscar por sexo y raza tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaSexoYRazaTal(char sexo, String raza){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
        if(!estaVacia()){
            Lista = ListaSexoTal(sexo);
            Lista = Lista.ListaRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia");     
        return Lista;
    }
    
    /** Método para buscar por poder y año tal */
    
    public LinkedListPlusRecursividadGenerico<E> ListaPoderYAñoAparicionTal(String poder, int añoAparicion){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
        if(!estaVacia()){
            Lista = ListaPoderTal(poder);
            Lista = Lista.ListaAñoAparicionTal(añoAparicion);
        }else
            StdOut.println("Se retornara una lista vacia");     
        return Lista;
    }
    
    /** Método para buscar por poder y autor tal */
    
    public LinkedListPlusRecursividadGenerico<E> ListaPoderYAutorTal(String poder, String autor){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
        if(!estaVacia()){
            Lista = ListaPoderTal(poder);
            Lista = Lista.ListaAutorTal(autor);
        }else
            StdOut.println("Se retornara una lista vacia");       
        return Lista;
    }
    
    /** Método para buscar por poder y origen tal */
    
    public LinkedListPlusRecursividadGenerico<E> ListaPoderYOrigenTal(String poder, String origen){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
        if(!estaVacia()){
            Lista = ListaPoderTal(poder);
            Lista = Lista.ListaOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia");    
        return Lista;
    }
    
    /** Método para buscar por poder y comic tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaPoderYComicTal(String poder, String comic){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
        if(!estaVacia()){
            Lista = ListaPoderTal(poder);
            Lista = Lista.ListaComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;
    }
    
    /** Método para buscar por poder y afiliacion tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaPoderYAfiliacionTal(String poder, String afiliacion){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
         if(!estaVacia()){
            Lista = ListaPoderTal(poder);
            Lista = Lista.ListaAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;  
    }
    
    /** Método para buscar por poder y raza tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaPoderYRazaTal(String poder, String raza){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
        if(!estaVacia()){
            Lista = ListaPoderTal(poder);
            Lista = Lista.ListaRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;
    }
    
    /** Método para buscar por año y autor tal */
    
    public LinkedListPlusRecursividadGenerico<E> ListaAñoAparicionYAutorTal(int añoAparicion, String autor){
        LinkedListPlusRecursividadGenerico<E> Lista = ListaAñoAparicionTal(añoAparicion);
        if(!estaVacia()){
            Lista = ListaAñoAparicionTal(añoAparicion);
            Lista = Lista.ListaAutorTal(autor);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;
    }
    
    /** Método para buscar por año y origen tal */
    
    public LinkedListPlusRecursividadGenerico<E> ListaAñoAparicionYOrigenTal(int añoAparicion, String origen){
        LinkedListPlusRecursividadGenerico<E> Lista = ListaAñoAparicionTal(añoAparicion);
        if(!estaVacia()){
            Lista = ListaAñoAparicionTal(añoAparicion);
            Lista = Lista.ListaOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;
    }
    
    /** Método para buscar por año y comic tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaAñoAparicionYComicTal(int añoAparicion, String comic){
        LinkedListPlusRecursividadGenerico<E> Lista = ListaAñoAparicionTal(añoAparicion);
        if(!estaVacia()){
            Lista = ListaAñoAparicionTal(añoAparicion);
            Lista = Lista.ListaComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;  
    }
    
    /** Método para buscar por año y afiliacion tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaAñoAparicionYAfiliacionTal(int añoAparicion, String afiliacion){
        LinkedListPlusRecursividadGenerico<E> Lista = ListaAñoAparicionTal(añoAparicion);
        if(!estaVacia()){
            Lista = ListaAñoAparicionTal(añoAparicion);
            Lista = Lista.ListaAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;  
    }
    
    /** Método para buscar por año y raza tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaAñoAparicionYRazaTal(int añoAparicion, String raza){
        LinkedListPlusRecursividadGenerico<E> Lista = ListaAñoAparicionTal(añoAparicion);
        if(!estaVacia()){
            Lista = ListaAñoAparicionTal(añoAparicion);
            Lista = Lista.ListaRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;  
    }
    
    /** Método para buscar por autor y origen tal */
    
    public LinkedListPlusRecursividadGenerico<E> ListaAutorYOrigenTal(String autor, String origen){
        LinkedListPlusRecursividadGenerico<E> Lista = ListaAutorTal(autor);
        if(!estaVacia()){
            Lista = ListaAutorTal(autor);
            Lista = Lista.ListaOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;
    }
    
    /** Método para buscar por autor y comic tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaAutorYComicTal(String autor, String comic){
        LinkedListPlusRecursividadGenerico<E> Lista = ListaAutorTal(autor);
        if(!estaVacia()){
            Lista = ListaAutorTal(autor);
            Lista = Lista.ListaComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;
    }
    
    /** Método para buscar por autor y afiliacion tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaAutorYAfiliacionTal(String autor, String afiliacion){
        LinkedListPlusRecursividadGenerico<E> Lista = ListaAutorTal(autor);
        if(!estaVacia()){
            Lista = ListaAutorTal(autor);
            Lista = Lista.ListaAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;  
    }
    
    /** Método para buscar por autor y raza tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaAutorYRazaTal(String autor, String raza){
        LinkedListPlusRecursividadGenerico<E> Lista = ListaAutorTal(autor);
        if(!estaVacia()){
            Lista = ListaAutorTal(autor);
            Lista = Lista.ListaRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;
    }
    
    /** Método para buscar por origen y comic tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaOrigenYComicTal(String origen, String comic){
        LinkedListPlusRecursividadGenerico<E> Lista = ListaOrigenTal(origen);
        if(!estaVacia()){
            Lista = ListaOrigenTal(origen);
            Lista = Lista.ListaComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista; 
    }
    
    /** Método para buscar por origen y afiliacion tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaOrigenYAfiliacionTal(String origen, String afiliacion){
        LinkedListPlusRecursividadGenerico<E> Lista = ListaOrigenTal(origen);
        if(!estaVacia()){
            Lista = ListaOrigenTal(origen);
            Lista = Lista.ListaAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista; 
    }
    
    /** Método para buscar por origen y raza tal */
    public  LinkedListPlusRecursividadGenerico<E> ListaOrigenYRazaTal(String origen, String raza){
        LinkedListPlusRecursividadGenerico<E> Lista = ListaOrigenTal(origen);
        if(!estaVacia()){
            Lista = ListaOrigenTal(origen);
            Lista = Lista.ListaRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista; 
    }
    
    /** Método para buscar por comic y afiliacion tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaComicYAfiliacionTal(String comic, String afiliacion){
        LinkedListPlusRecursividadGenerico<E> Lista = ListaComicTal(comic);
        if(!estaVacia()){
            Lista = ListaComicTal(comic);
            Lista = Lista.ListaAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista; 
    }
    
    /** Método para buscar por comic y raza tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaComicYRazaTal(String comic, String raza){
        LinkedListPlusRecursividadGenerico<E> Lista = ListaComicTal(comic);
        if(!estaVacia()){
            Lista = ListaComicTal(comic);
            Lista = Lista.ListaRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;    
    }
    
    /** Método para buscar por afiliacion y raza tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaAfiliacionYRazaTal(String afiliacion, String raza){
        LinkedListPlusRecursividadGenerico<E> Lista = ListaAfiliacionTal(afiliacion);
        if(!estaVacia()){
            Lista = ListaAfiliacionTal(afiliacion);
            Lista = Lista.ListaRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista; 
    }
    
    /**
     * 
     * Metodos para eliminar por cada atributo
     * 
       */
    
    /** Eliminar de la lista por alias tal */
    
    public void EliminarConAliasTal(String alias){
      if(estaVacia())
         StdOut.println("La lista está vacia, no se puede eliminar");
      else  
          for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAlias().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(alias)))
                        Eliminar(((E)(i.getInformacion())));
            }
    }
    
    /** Eliminar de la lista con nombre tal */
    public void EliminarConNombreRealTal(String nombreReal){
      if(estaVacia())
           StdOut.println("La lista está vacia, no se puede eliminar");
      else  
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getNombreReal().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(nombreReal)))
                        Eliminar(((E)(i.getInformacion())));
            }
    }
    
    /** Eliminar de la lista con poder tal */
    
    public void EliminarConPoderTal(String poder){
      if(estaVacia())
          StdOut.println("La lista está vacia, no se puede eliminar");
       else
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getPoder().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(poder)))
                        Eliminar(((E)(i.getInformacion())));
            }
    }  
    
    /** Eliminar de la lista con autor tal */
    
    public void EliminarConAutorTal(String autor){
       if(estaVacia())
           StdOut.println("La lista está vacia, no se puede eliminar");
       else
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAutor().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(autor)))
                        Eliminar(((E)(i.getInformacion())));
            }
    }
    
    /** Eliminar de la lista con origen tal */
    
    public void EliminarConOrigenTal(String origen){
       if(estaVacia())
            StdOut.println("La lista está vacia, no se puede eliminar");
       else
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getOrigen().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(origen)))
                        Eliminar(((E)(i.getInformacion())));
            } 
    }
    
    /** Eliminar de la lista con comic tal */
    
    public void EliminarConComicTal(String comic){
        if(estaVacia())
            StdOut.println("La lista está vacia, no se puede eliminar");
       else
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getComic().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(comic)))
                        Eliminar(((E)(i.getInformacion())));
            }
    }
    
    /** Eliminar de la lista con afiliacion tal */
    
    public void EliminarConAfiliacionTal(String afiliacion){
       if(estaVacia())
            StdOut.println("La lista está vacia, no se puede eliminar");
       else
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAfiliacionActual().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(afiliacion)))
                        Eliminar(((E)(i.getInformacion())));
            }
    }
    
    /** Eliminar de la lista con raza tal */
    
    public void EliminarConRazaTal(String raza){
       if(estaVacia())
            StdOut.println("La lista está vacia, no se puede eliminar");
       else
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getRaza().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(raza)))
                        Eliminar(((E)(i.getInformacion())));
            }
    }
    
    /** Eliminar de la lista con sexo tal */
    
    public void EliminarConSexoTal(char sexo){
       if(estaVacia())
         StdOut.println("La lista está vacia, no se puede eliminar");
       else  
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                    if(((SuperHeroe)(i.getInformacion())).getSexo() == sexo)
                        Eliminar(((E)(i.getInformacion())));
            }
    }
    
    /** Eliminar de la lista con año de aparición tal */
    
    public void EliminarConAñoAparicionTal(int añoAparicion){
        if(estaVacia())
         StdOut.println("La lista está vacia, no se puede eliminar");
        else  
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                for(int j = 0; j < ((SuperHeroe)(i.getInformacion())).getAñoAparicion().length; j++)
                    if(((SuperHeroe)(i.getInformacion())).getAñoAparicion()[j] == añoAparicion)
                         Eliminar(((E)(i.getInformacion())));
            }
    }
    
    /**
     * 
     * Metodos para eliminar por dos diferentes atributos (Filtrado)
     * 
       */
    
    /** Método para obtener lista eliminando con sexo y poder tal */
    
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConSexoYPoderTal(Lista <E>  listaOriginal,char sexo, String poder){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();  
        if(!listaOriginal.estaVacia()){
           lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
           StdOut.printf("Eliminando con sexo \" %c \" y poder \" %s \" \n",sexo,poder);
           lista.EliminarConSexoTal(sexo);
           lista.EliminarConPoderTal(poder);
        }else
            StdOut.println("Se retornara una lista vacia");
        return lista; 
    }
    
    /** Método para obtener lista eliminando con sexo y año tal */
    
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConSexoYAñoAparicionTal(Lista <E>  listaOriginal,char sexo, int añoAparicion){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con sexo \" %c \" y año de aparición \" %d \" \n",sexo,añoAparicion);
            lista.EliminarConSexoTal(sexo);
            lista.EliminarConAñoAparicionTal(añoAparicion);
        }else
            StdOut.println("Se retornara una lista vacia");
        return lista;
    }
    
    /** Método para obtener lista eliminando con sexo y autor tal */
    
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConSexoYAutorTal(Lista <E>  listaOriginal,char sexo, String autor){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con sexo \" %c \" y autor \" %s \" \n",sexo,autor);
            lista.EliminarConSexoTal(sexo);
            lista.EliminarConAutorTal(autor);
        }else
            StdOut.println("Se retornara una lista vacia");
        return lista;
    }
    
    /** Método para obtener lista eliminando con sexo y origen tal */
    
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConSexoYOrigenTal(Lista <E>  listaOriginal,char sexo, String origen){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con sexo \" %c \" y origen \" %s \" \n",sexo,origen);
            lista.EliminarConSexoTal(sexo);
            lista.EliminarConOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia");
        return lista;
    }
    
    /** Método para obtener lista eliminando con sexo y comic tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConSexoYComicTal(Lista <E>  listaOriginal,char sexo, String comic){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con sexo \" %c \" y comic \" %s \" \n",sexo,comic);
            lista.EliminarConSexoTal(sexo);
            lista.EliminarConComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia");    
        return lista;
    }
    
    /** Método para obtener lista eliminando con sexo y afiliacion tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConSexoYAfiliacionTal(Lista <E>  listaOriginal,char sexo, String afiliacion){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con sexo \" %c \" y afiliación \" %s \" \n",sexo,afiliacion);
            lista.EliminarConSexoTal(sexo);
            lista.EliminarConAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return lista;
    }
    
    /** Método para obtener lista eliminando con sexo y raza tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConSexoYRazaTal(Lista <E>  listaOriginal,char sexo, String raza){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con sexo \" %c \" y raza \" %s \" \n",sexo,raza);
            lista.EliminarConSexoTal(sexo);
            lista.EliminarConRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return lista;
    }
    
    /** Método para obtener lista eliminando con poder y año tal */
    
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConPoderYAñoAparicionTal(Lista <E>  listaOriginal,String poder, int añoAparicion){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con poder \" %s \" y año de aparición \" %d \" \n",poder,añoAparicion);
            lista.EliminarConPoderTal(poder);
            lista.EliminarConAñoAparicionTal(añoAparicion);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return lista;
    }
    
    /** Método para obtener lista eliminando con poder y autor tal */
    
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConPoderYAutorTal(Lista <E>  listaOriginal,String poder, String autor){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con poder \" %s \" y autor \" %s \" \n",poder,autor);
            lista.EliminarConPoderTal(poder);
            lista.EliminarConAutorTal(autor);
        }else
            StdOut.println("Se retornara una lista vacia");
         return lista;
    }
    
    /** Método para obtener lista eliminando con poder y origen tal */
    
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConPoderYOrigenTal(Lista <E>  listaOriginal,String poder, String origen){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con poder \" %s \" y origen \" %s \" \n",poder,origen);
            lista.EliminarConPoderTal(poder);
            lista.EliminarConOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia");
         return lista;
    }
    
    /** Método para obtener lista eliminando con poder y comic tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConPoderYComicTal(Lista <E>  listaOriginal,String poder, String comic){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con poder \" %s \" y comic \" %s \" \n",poder,comic);
            lista.EliminarConPoderTal(poder);
            lista.EliminarConComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia");
         return lista;
    }
    
    /** Método para obtener lista eliminando con poder y afiliacion tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConPoderYAfiliacionTal(Lista <E>  listaOriginal,String poder, String afiliacion){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con poder \" %s \" y afiliacion \" %s \" \n",poder,afiliacion);
            lista.EliminarConPoderTal(poder);
            lista.EliminarConAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia");
         return lista;
    }
    
    /** Método para obtener lista eliminando con poder y raza tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConPoderYRazaTal(Lista <E>  listaOriginal,String poder, String raza){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con poder \" %s \" y raza \" %s \" \n",poder,raza);
            lista.EliminarConPoderTal(poder);
            lista.EliminarConRazaTal(raza);
         }else
            StdOut.println("Se retornara una lista vacia");   
         return lista;
    }
    
    /** Método para obtener lista eliminando con año y autor tal */
    
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAñoAparicionYAutorTal(Lista <E>  listaOriginal,int añoAparicion, String autor){
         LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
         if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con año aparicion \" %d \" y autor \" %s \" \n",añoAparicion,autor);
            lista.EliminarConAñoAparicionTal(añoAparicion);
            lista.EliminarConAutorTal(autor);
         }else
            StdOut.println("Se retornara una lista vacia");   
         return lista;
    }
    
    /** Método para obtener lista eliminando con año y origen tal */
    
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAñoAparicionYOrigenTal(Lista <E>  listaOriginal,int añoAparicion, String origen){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con año aparicion \" %d \" y origen \" %s \" \n",añoAparicion,origen);
            lista.EliminarConAñoAparicionTal(añoAparicion);
            lista.EliminarConOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia");   
         return lista;
    }
    
    /** Método para obtener lista eliminando con año y comic tal */
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAñoAparicionYComicTal(Lista <E>  listaOriginal,int añoAparicion, String comic){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con año aparicion \" %d \" y comic \" %s \" \n",añoAparicion,comic);
            lista.EliminarConAñoAparicionTal(añoAparicion);
            lista.EliminarConComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con año y afiliacion tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAñoAparicionYAfiliacionTal(Lista <E>  listaOriginal,int añoAparicion, String afiliacion){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con año aparicion \" %d \" y afiliacion \" %s \" \n",añoAparicion,afiliacion);
            lista.EliminarConAñoAparicionTal(añoAparicion);
            lista.EliminarConAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con año y raza tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAñoAparicionYRazaTal(Lista <E>  listaOriginal,int añoAparicion, String raza){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con año aparicion \" %d \" y raza \" %s \" \n",añoAparicion,raza);
            lista.EliminarConAñoAparicionTal(añoAparicion);
            lista.EliminarConRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con autor y origen tal */
    
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAutorYOrigenTal(Lista <E>  listaOriginal,String autor, String origen){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con autor \" %s \" y origen \" %s \" \n",autor,origen);
            lista.EliminarConAutorTal(autor);
            lista.EliminarConOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con autor y comic tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAutorYComicTal(Lista <E>  listaOriginal,String autor, String comic){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con autor \" %s \" y comic \" %s \" \n",autor,comic);
            lista.EliminarConAutorTal(autor);
            lista.EliminarConComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con autor y afiliacion tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAutorYAfiliacionTal(Lista <E>  listaOriginal,String autor, String afiliacion){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con autor \" %s \" y afiliacion \" %s \" \n",autor,afiliacion);
            lista.EliminarConAutorTal(autor);
            lista.EliminarConAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con autor y raza tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAutorYRazaTal(Lista <E>  listaOriginal,String autor, String raza){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con autor \" %s \" y raza \" %s \" \n",autor,raza);
            lista.EliminarConAutorTal(autor);
            lista.EliminarConRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con origen y comic tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConOrigenYComicTal(Lista <E>  listaOriginal,String origen, String comic){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con origen \" %s \" y comic \" %s \" \n",origen,comic);
            lista.EliminarConOrigenTal(origen);
            lista.EliminarConComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con origen y afiliacion tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConOrigenYAfiliacionTal(Lista <E>  listaOriginal,String origen, String afiliacion){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con origne \" %s \" y afiliacion \" %s \" \n",origen,afiliacion);
            lista.EliminarConOrigenTal(origen);
            lista.EliminarConAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con origen y raza tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConOrigenYRazaTal(Lista <E>  listaOriginal,String origen, String raza){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con origen \" %s \" y raza \" %s \" \n",origen,raza);
            lista.EliminarConOrigenTal(origen);
            lista.EliminarConRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con y afiliacion tal */
    
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConComicYAfiliacionTal(Lista <E>  listaOriginal,String comic, String afiliacion){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con comic \" %s \" y afiliación \" %s \" \n",comic,afiliacion);
            lista.EliminarConComicTal(comic);
            lista.EliminarConAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con y raza tal */
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConComicYRazaTal(Lista <E>  listaOriginal,String comic, String raza){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con comic \" %s \" y raza \" %s \" \n",comic,raza);
            lista.EliminarConComicTal(comic);
            lista.EliminarConRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con afiliacion y raza tal */
    
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAfiliacionYRazaTal(Lista <E>  listaOriginal,String afiliacion, String raza){
       LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
       if(!listaOriginal.estaVacia()){
            lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
            StdOut.printf("Eliminando con afiliación \" %s \" y raza \" %s \" \n",afiliacion,raza);
            lista.EliminarConAfiliacionTal(afiliacion); 
            lista.EliminarConRazaTal(raza);
       }else
            StdOut.println("Se retornara una lista vacia");   
       return lista;
    }
}
