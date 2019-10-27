

import java.util.*;
import java.text.Normalizer;

public class LinkedListPlusRecursividadGenerico<E>{
    
    private class Nodo {
        E info;
        Nodo sig;
    }
    
    private Nodo raiz;
    
    public E getInfo(Nodo temp){ 
        if(temp != null)
            return (E)temp.info;
        return null;
    }
    
    public Nodo getRaiz(){
        return raiz;
    }
    
    /**Si solo queremos el nodo que está antes*/
    public Nodo AntesDe(E x){
        Nodo temp = null;
        if(x == null) //Si mandan un null devuelve al ultimo porque el apunta a null
            return BuscarUltimo();
        if(Buscar(x) != null) //Comprobar de lo que vamos a buscar existe
            if(raiz.info.equals(x)) //Caso especial de buscar antes de raiz
                return raiz;
             else 
                for(Nodo i = raiz; i.sig != null; i = i.sig)
                    if(i.sig.info.equals(x))
                        temp = i;
        return temp; 
    }
    
    /** Si queremos la informacion de lo que está antes*/
    public E AntesDeInfo(E x){
        if(AntesDe(x) == null) //Si existe o no en la lista
            return (E) "No está en la lista";
        if( x == raiz.info) //Debemos comprobar que si es raiz, antes no hay nadie, como es un apuntador, se evalua así, no requiere de casting    
            return  (E) "Nadie, eres el primero!!";
        return getInfo(AntesDe(x));    
    }
    
    /** Si solo queremos el nodo que está despues*/
    public Nodo DespuesDe(E x){
        Nodo temp = null;
        if(Buscar(x) != null)
              for(Nodo i = raiz; i != null; i = i.sig)
                  if(i.info.equals(x))
                     temp = i.sig;
        return temp; 
    }
    
    /** Si queremos la informacion del nodo que está despues */
    public E DespuesDeInfo(E x){
        if(((SuperHeroe)BuscarUltimo().info).equals(x)) //Busco de que existe en la lista y de que despues de él solo hay null
            return (E) "Nadie eres el ultimo!!";        // Como no hay referencia, se tiene que comparar como objeto, por ello el casting
        if(DespuesDe(x) == null && Buscar(x) == null) //Si no se encuentra y es null, entonces no está en la lista
        return (E) "No está en la lista";
        return getInfo(DespuesDe(x));   
    }
    
    public Nodo Buscar(E x){
       if(x != null) // Si es diferente de null se busca, de lo contrario es false
         for(Nodo i = raiz; i != null; i = i.sig)
            if(i.info.equals(x))
                return i;
        return null; 
    }
    
    public Nodo BuscarUltimo(){
        Nodo temp = null;
        for(Nodo i = raiz; i != null; i = i.sig)
            if(i.sig == null)
            temp = i;
        return temp;    
    }
    
    public void Eliminar(E x){
        if(Buscar(x) == null)
            StdOut.println("No está en la lista");
        if(Buscar(x) == raiz)
            eliminarInicio();
        if(Buscar(x) == BuscarUltimo())
            eliminarFinal();
            
        else{
            Nodo temp = AntesDe(x);
            if(raiz.info.equals(x))
                raiz = raiz.sig; 
            if(temp!=null)
            temp.sig = temp.sig.sig;
        }
    }
    
    public boolean estaVacia(){
        if(raiz == null)
           return true;
        return false;   
    }
    
    public void eliminarFinal(){
        if(!estaVacia()){
        Nodo temp = AntesDe((E)BuscarUltimo().info);
        temp.sig = temp.sig.sig;
      }
   }
    
    public void eliminarInicio(){
        if(!estaVacia()){
         raiz = DespuesDe((E)raiz.info);
        }
    }
    
    public void insertarPrimero(E x) {
        Nodo nuevo = new Nodo ();
        nuevo.info = x;
        nuevo.sig  = raiz;
        raiz       = nuevo;
    }
        
    public String imprimirInversa(Nodo reco) {
        if (reco != null)
            return imprimirInversa(reco.sig) + " " + reco.info;
        return "";    
    }
     
    public String imprimirNormal(Nodo reco) {
        if (reco != null)
            return  reco.info + " " + imprimirNormal(reco.sig);
        return "";    
    }
    
    public void imprimirInversa () {
        if(raiz != null)
        StdOut.println(imprimirInversa(raiz));
        else
        StdOut.println("\t***** Lista Vacia *****");
    }
    
    public void imprimirNormal(){
        if(raiz != null)
        StdOut.println(imprimirNormal(raiz));
        else
        StdOut.println("\t***** Lista Vacia *****");
    }
    //# AQUI VAMOS A MODIFICAR
    
    /** Eliminar de la lista por Alias*/
    
    public void EliminarConAliasTal(String alias){
      for(Nodo i = raiz; i != null; i = i.sig){
                String [] temp = ((SuperHeroe)(i.info)).getAlias().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(alias)))
                        Eliminar(((E)(i.info)));
            }
    }
    
    /** Eliminar de la lista con nombre tal*/
    public void EliminarConNombreTal(String nombreReal){
      for(Nodo i = raiz; i != null; i = i.sig){
                String [] temp = ((SuperHeroe)(i.info)).getNombreReal().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(nombreReal)))
                        Eliminar(((E)(i.info)));
            }
    }
    
    /** Eliminar de la lista con poder tal*/
    public void EliminarConPoderTal(String poder){
      for(Nodo i = raiz; i != null; i = i.sig){
                String [] temp = ((SuperHeroe)(i.info)).getPoder().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(poder)))
                        Eliminar(((E)(i.info)));
            }
    }  
    
    /** Eliminar de la lista con autor tal*/
    public void EliminarConAutorTal(String autor){
       for(Nodo i = raiz; i != null; i = i.sig){
                String [] temp = ((SuperHeroe)(i.info)).getAutor().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(autor)))
                        Eliminar(((E)(i.info)));
            }
    }
    
    public void EliminarConOrigenTal(String origen){
       for(Nodo i = raiz; i != null; i = i.sig){
                String [] temp = ((SuperHeroe)(i.info)).getOrigen().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(origen)))
                        Eliminar(((E)(i.info)));
            } 
    }
    
    public void EliminarConComicTal(String comic){
        for(Nodo i = raiz; i != null; i = i.sig){
                String [] temp = ((SuperHeroe)(i.info)).getComic().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(comic)))
                        Eliminar(((E)(i.info)));
            }
    }
    
    public void EliminarConAfiliacionTal(String afiliacion){
        for(Nodo i = raiz; i != null; i = i.sig){
                String [] temp = ((SuperHeroe)(i.info)).getAfiliacionActual().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(afiliacion)))
                        Eliminar(((E)(i.info)));
            }
    }
    
    public void EliminarConRazaTal(String raza){
        for(Nodo i = raiz; i != null; i = i.sig){
                String [] temp = ((SuperHeroe)(i.info)).getRaza().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(raza)))
                        Eliminar(((E)(i.info)));
            }
    }
    
    /** Eliminar de la lista con sexo tal*/
    public void EliminarConSexoTal(char sexo){
            for(Nodo i = raiz; i != null; i = i.sig){
                    if(((SuperHeroe)(i.info)).getSexo() == sexo)
                        Eliminar(((E)(i.info)));
            }
    }
    
    public void EliminarConAñoAparicionTal(int añoAparicion){
        for(Nodo i = raiz; i != null; i = i.sig){
                for(int j = 0; j < ((SuperHeroe)(i.info)).getAñoAparicion().length; j++)
                    if(((SuperHeroe)(i.info)).getAñoAparicion()[j] == añoAparicion)
                         Eliminar(((E)(i.info)));
            }
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y poder tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConSexoYPoderTal(LinkedListPlusRecursividadGenerico listaOriginal,char sexo, String poder){
        LinkedListPlusRecursividadGenerico<E> lista = listaOriginal; //Clonamos la lista  
        lista.EliminarConSexoTal(sexo);
        lista.EliminarConPoderTal(poder);
        return lista; //Se retorna dicha lista clonada, ya con elementos eliminados
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y año tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConSexoYAñoAparicionTal(LinkedListPlusRecursividadGenerico listaOriginal,char sexo, int añoAparicion){
        LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
        lista.EliminarConSexoTal(sexo);
        lista.EliminarConAñoAparicionTal(añoAparicion);
        return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y autor tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConSexoYAutorTal(LinkedListPlusRecursividadGenerico listaOriginal,char sexo, String autor){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConSexoTal(sexo);
         lista.EliminarConAutorTal(autor);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y origen tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConSexoYOrigenTal(LinkedListPlusRecursividadGenerico listaOriginal,char sexo, String origen){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConSexoTal(sexo);
         lista.EliminarConOrigenTal(origen);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y comic tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConSexoYComicTal(LinkedListPlusRecursividadGenerico listaOriginal,char sexo, String comic){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConSexoTal(sexo);
         lista.EliminarConComicTal(comic);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConSexoYAfiliacionTal(LinkedListPlusRecursividadGenerico listaOriginal,char sexo, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConSexoTal(sexo);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConSexoYRazaTal(LinkedListPlusRecursividadGenerico listaOriginal,char sexo, String raza){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConSexoTal(sexo);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y año tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConPoderYAñoAparicionTal(LinkedListPlusRecursividadGenerico listaOriginal,String poder, int añoAparicion){
        LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
        lista.EliminarConPoderTal(poder);
        lista.EliminarConAñoAparicionTal(añoAparicion);
        return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y autor tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConPoderYAutorTal(LinkedListPlusRecursividadGenerico listaOriginal,String poder, String autor){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConPoderTal(poder);
         lista.EliminarConAutorTal(autor);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y origen tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaElimiandoConPoderYOrigenTal(LinkedListPlusRecursividadGenerico listaOriginal,String poder, String origen){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConPoderTal(poder);
         lista.EliminarConOrigenTal(origen);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y comic tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandConPoderYComicTal(LinkedListPlusRecursividadGenerico listaOriginal,String poder, String comic){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConPoderTal(poder);
         lista.EliminarConComicTal(comic);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConPoderYAfiliacionTal(LinkedListPlusRecursividadGenerico listaOriginal,String poder, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConPoderTal(poder);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConPoderYRazaTal(LinkedListPlusRecursividadGenerico listaOriginal,String poder, String raza){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConPoderTal(poder);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con año y autor tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAñoAparicionYAutorTal(LinkedListPlusRecursividadGenerico listaOriginal,int añoAparicion, String autor){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConAñoAparicionTal(añoAparicion);
         lista.EliminarConAutorTal(autor);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con año y origen tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAñoAparicionYOrigenTal(LinkedListPlusRecursividadGenerico listaOriginal,int añoAparicion, String origen){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConAñoAparicionTal(añoAparicion);
         lista.EliminarConOrigenTal(origen);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con año y comic tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAñoAparicionYComicTal(LinkedListPlusRecursividadGenerico listaOriginal,int añoAparicion, String comic){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConAñoAparicionTal(añoAparicion);
         lista.EliminarConComicTal(comic);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con año y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAñoAparicionYAfiliacionTal(LinkedListPlusRecursividadGenerico listaOriginal,int añoAparicion, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConAñoAparicionTal(añoAparicion);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con año y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaAñoAparicionYRazaTal(LinkedListPlusRecursividadGenerico listaOriginal,int añoAparicion, String raza){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConAñoAparicionTal(añoAparicion);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con autor y origen tal*/
    public LinkedListPlusRecursividadGenerico<E> listaAutorYOrigenTal(LinkedListPlusRecursividadGenerico listaOriginal,String autor, String origen){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConAutorTal(autor);
         lista.EliminarConOrigenTal(origen);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con autor y comic tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaAutorYComicTal(LinkedListPlusRecursividadGenerico listaOriginal,String autor, String comic){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConAutorTal(autor);
         lista.EliminarConComicTal(comic);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con autor y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaAutorYAfiliacionTal(LinkedListPlusRecursividadGenerico listaOriginal,String autor, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConAutorTal(autor);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con autor y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaAutorYRazaTal(LinkedListPlusRecursividadGenerico listaOriginal,String autor, String raza){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConAutorTal(autor);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con origen y comic tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaOrigenYComicTal(LinkedListPlusRecursividadGenerico listaOriginal,String origen, String comic){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConOrigenTal(origen);
         lista.EliminarConComicTal(comic);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con origen y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaOrigenYAfiliacionTal(LinkedListPlusRecursividadGenerico listaOriginal,String origen, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConOrigenTal(origen);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con origen y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaOrigenYRazaTal(LinkedListPlusRecursividadGenerico listaOriginal,String origen, String raza){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConOrigenTal(origen);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaComicYAfiliacionTal(LinkedListPlusRecursividadGenerico listaOriginal,String comic, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConComicTal(comic);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaComicYRazaTal(LinkedListPlusRecursividadGenerico listaOriginal,String comic, String raza){
         LinkedListPlusRecursividadGenerico<E> lista = listaOriginal;
         lista.EliminarConComicTal(comic);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con afiliacion y raza tal*/
    public LinkedListPlusRecursividadGenerico<E> EliminarAfiliacionYRazaTal(LinkedListPlusRecursividadGenerico listaOriginal,String afiliacion, String raza){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
        lista.EliminarConAfiliacionTal(afiliacion); 
        lista.EliminarConRazaTal(raza);
        return lista;
    }
    
    //# AQUI TERMINA LA MODIFICACION
    
    /** Metodo termiando para buscar por alias */
    
    public LinkedListPlusRecursividadGenerico<E> listaAliasTal(String alias){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.sig){
                String [] temp = ((SuperHeroe)(i.info)).getAlias().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(alias)))
                        lista.insertarPrimero(((E)(i.info)));
            }
        return lista;
    }
    
    /** Metodo termiando para buscar por nombre real */
    
    public LinkedListPlusRecursividadGenerico<E> listaNombreRealTal(String nombreReal){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.sig){
                String [] temp = ((SuperHeroe)(i.info)).getNombreReal().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(nombreReal)))
                        lista.insertarPrimero(((E)(i.info)));
            }
        return lista;
    }
    
    /** Metodo termiando para buscar por poder */
    
    public LinkedListPlusRecursividadGenerico<E> listaPoderTal(String poder){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.sig){
                String [] temp = ((SuperHeroe)(i.info)).getPoder().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(poder)))
                        lista.insertarPrimero(((E)(i.info)));
            }
        return lista;
    }
    
    /** Metodo termiando para buscar por autor*/
    
    public LinkedListPlusRecursividadGenerico<E> listaAutorTal(String autor){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.sig){
                String [] temp = ((SuperHeroe)(i.info)).getAutor().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(autor)))
                        lista.insertarPrimero(((E)(i.info)));
            }
        return lista;
    }
    
    /** Metodo termiando para buscar por origen*/
    
    public LinkedListPlusRecursividadGenerico<E> listaOrigenTal(String origen){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.sig){
                String [] temp = ((SuperHeroe)(i.info)).getOrigen().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(origen)))
                        lista.insertarPrimero(((E)(i.info)));
            }
        return lista;
    }
    
    /** Metodo termiando para buscar por comic*/
    
    public LinkedListPlusRecursividadGenerico<E> listaComicTal(String comic){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.sig){
                String [] temp = ((SuperHeroe)(i.info)).getComic().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(comic)))
                        lista.insertarPrimero(((E)(i.info)));
            }
        return lista;
    }
    
    /** Metodo termiando para buscar por afiliacion*/
    
    public LinkedListPlusRecursividadGenerico<E> listaAfiliacionTal(String afiliacion){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.sig){
                String [] temp = ((SuperHeroe)(i.info)).getAfiliacionActual().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(afiliacion)))
                        lista.insertarPrimero(((E)(i.info)));
            }
        return lista;
    }
    
    /** Metodo termiando para buscar por raza*/
    
    public LinkedListPlusRecursividadGenerico<E> listaRazaTal(String raza){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.sig){
                String [] temp = ((SuperHeroe)(i.info)).getRaza().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(raza)))
                        lista.insertarPrimero(((E)(i.info)));
            }
        return lista;
    }
    
    /**Metodo para qutar las tildes de un string, para hacer mas eficiente la busqueda*/
    
    private static String cleanString(String info) {
        info = Normalizer.normalize(info, Normalizer.Form.NFD);
        info = info.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return info;
    }
    
    /** Metodo termiando para buscar por sexo */
    
    public LinkedListPlusRecursividadGenerico<E> listaSexoTal(char sexo){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.sig){
                if(((SuperHeroe)(i.info)).getSexo() == sexo)
                    lista.insertarPrimero(((E)(i.info)));
            }
        return lista;
    }
    
    /** Metodo termiando para buscar por año / años de aparicion*/
    
    public LinkedListPlusRecursividadGenerico<E> listaAñoAparicionTal(int añoAparicion){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.sig){
                for(int j = 0; j < ((SuperHeroe)(i.info)).getAñoAparicion().length; j++)
                    if(((SuperHeroe)(i.info)).getAñoAparicion()[j] == añoAparicion)
                         lista.insertarPrimero(((E)(i.info)));
            }
        return lista;
    }
    
    
    /**
     * Metodos combiandos que generan lista, apartir de listas (Filtrado)
     * 
     */
    
    
    /** Metodo terminado para buscar por sexo y poder tal*/
    public LinkedListPlusRecursividadGenerico<E> listaSexoYPoderTal(char sexo, String poder){
        LinkedListPlusRecursividadGenerico<E> lista = listaSexoTal(sexo); //Te entrega una lista de sexo tal 
        return lista.listaPoderTal(poder); //Te regresa quienes tienen el poder, sobre esa misma lista
    }
    
    /** Metodo terminado para buscar por sexo y año tal*/
    public LinkedListPlusRecursividadGenerico<E> listaSexoYAñoAparicionTal(char sexo, int añoAparicion){
        LinkedListPlusRecursividadGenerico<E> lista = listaSexoTal(sexo);
        return lista.listaAñoAparicionTal(añoAparicion);
    }
    
    /** Metodo terminado para buscar por sexo y autor tal*/
    public LinkedListPlusRecursividadGenerico<E> listaSexoYAutorTal(char sexo, String autor){
         LinkedListPlusRecursividadGenerico<E> lista = listaSexoTal(sexo);
         return lista.listaAutorTal(autor);
    }
    
    /** Metodo terminado para buscar por sexo y origen tal*/
    public LinkedListPlusRecursividadGenerico<E> listaSexoYOrigenTal(char sexo, String origen){
         LinkedListPlusRecursividadGenerico<E> lista = listaSexoTal(sexo);
         return lista.listaOrigenTal(origen);
    }
    
    /** Metodo terminado para buscar por sexo y comic tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaSexoYComicTal(char sexo, String comic){
         LinkedListPlusRecursividadGenerico<E> lista = listaSexoTal(sexo);
         return lista.listaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por sexo y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaSexoYAfiliacionTal(char sexo, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> lista = listaSexoTal(sexo);
         return lista.listaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por sexo y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaSexoYRazaTal(char sexo, String raza){
         LinkedListPlusRecursividadGenerico<E> lista = listaSexoTal(sexo);
         return lista.listaRazaTal(raza);
    }
    
        /** Metodo terminado para buscar por poder y año tal*/
    public LinkedListPlusRecursividadGenerico<E> listaPoderYAñoAparicionTal(String poder, int añoAparicion){
        LinkedListPlusRecursividadGenerico<E> lista = listaPoderTal(poder);
        return lista.listaAñoAparicionTal(añoAparicion);
    }
    
    /** Metodo terminado para buscar por poder y autor tal*/
    public LinkedListPlusRecursividadGenerico<E> listaPoderYAutorTal(String poder, String autor){
         LinkedListPlusRecursividadGenerico<E> lista = listaPoderTal(poder);
         return lista.listaAutorTal(autor);
    }
    
    /** Metodo terminado para buscar por poder y origen tal*/
    public LinkedListPlusRecursividadGenerico<E> listaPoderYOrigenTal(String poder, String origen){
         LinkedListPlusRecursividadGenerico<E> lista = listaPoderTal(poder);
         return lista.listaOrigenTal(origen);
    }
    
    /** Metodo terminado para buscar por poder y comic tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaPoderYComicTal(String poder, String comic){
         LinkedListPlusRecursividadGenerico<E> lista = listaPoderTal(poder);
         return lista.listaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por poder y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaPoderYAfiliacionTal(String poder, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> lista = listaPoderTal(poder);
         return lista.listaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por poder y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaPoderYRazaTal(String poder, String raza){
         LinkedListPlusRecursividadGenerico<E> lista = listaPoderTal(poder);
         return lista.listaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por año y autor tal*/
    public LinkedListPlusRecursividadGenerico<E> listaAñoAparicionYAutorTal(int añoAparicion, String autor){
         LinkedListPlusRecursividadGenerico<E> lista = listaAñoAparicionTal(añoAparicion);
         return lista.listaAutorTal(autor);
    }
    
    /** Metodo terminado para buscar por año y origen tal*/
    public LinkedListPlusRecursividadGenerico<E> listaAñoAparicionYOrigenTal(int añoAparicion, String origen){
         LinkedListPlusRecursividadGenerico<E> lista = listaAñoAparicionTal(añoAparicion);
         return lista.listaOrigenTal(origen);
    }
    
    /** Metodo terminado para buscar por año y comic tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaAñoAparicionYComicTal(int añoAparicion, String comic){
         LinkedListPlusRecursividadGenerico<E> lista = listaAñoAparicionTal(añoAparicion);
         return lista.listaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por año y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaAñoAparicionYAfiliacionTal(int añoAparicion, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> lista = listaAñoAparicionTal(añoAparicion);
         return lista.listaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por año y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaAñoAparicionYRazaTal(int añoAparicion, String raza){
         LinkedListPlusRecursividadGenerico<E> lista = listaAñoAparicionTal(añoAparicion);
         return lista.listaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por autor y origen tal*/
    public LinkedListPlusRecursividadGenerico<E> listaAutorYOrigenTal(String autor, String origen){
         LinkedListPlusRecursividadGenerico<E> lista = listaAutorTal(autor);
         return lista.listaOrigenTal(origen);
    }
    
    /** Metodo terminado para buscar por autor y comic tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaAutorYComicTal(String autor, String comic){
         LinkedListPlusRecursividadGenerico<E> lista = listaAutorTal(autor);
         return lista.listaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por autor y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaAutorYAfiliacionTal(String autor, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> lista = listaAutorTal(autor);
         return lista.listaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por autor y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaAutorYRazaTal(String autor, String raza){
         LinkedListPlusRecursividadGenerico<E> lista = listaAutorTal(autor);
         return lista.listaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por origen y comic tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaOrigenYComicTal(String origen, String comic){
         LinkedListPlusRecursividadGenerico<E> lista = listaOrigenTal(origen);
         return lista.listaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por origen y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaOrigenYAfiliacionTal(String origen, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> lista = listaOrigenTal(origen);
         return lista.listaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por origen y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaOrigenYRazaTal(String origen, String raza){
         LinkedListPlusRecursividadGenerico<E> lista = listaOrigenTal(origen);
         return lista.listaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por comic y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaComicYAfiliacionTal(String comic, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> lista = listaComicTal(comic);
         return lista.listaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por comic y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaComicYRazaTal(String comic, String raza){
         LinkedListPlusRecursividadGenerico<E> lista = listaComicTal(comic);
         return lista.listaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por afiliacion y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> listaAfiliacionYRazaTal(String afiliacion, String raza){
         LinkedListPlusRecursividadGenerico<E> lista = listaAfiliacionTal(afiliacion);
         return lista.listaRazaTal(raza);
    }
}
