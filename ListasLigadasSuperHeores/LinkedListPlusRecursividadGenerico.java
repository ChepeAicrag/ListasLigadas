import java.util.*;
import java.text.Normalizer;

/**Falta validad si está o no, para que no siga la busqueda*/
public class LinkedListPlusRecursividadGenerico<E> {
    
    private class Nodo {
        E info;
        Nodo sig;
    }
    
    private Nodo raiz;
    
    public E getInfo(Nodo temp){ 
        if(temp != null)
            return temp.info;
        if(temp == getRaiz())    
            return  (E) "Nadie, eres el primero!!";
        return (E) "Nadie, eres el ultimo!!!";
    }
    
    public Nodo getRaiz(){
        return raiz;
    }
    
    public Nodo AntesDe(E x){
        //Arreglar esto 
        if(!Buscar(x)){
            Nodo temp = new Nodo();
            temp.info = (E)"No está en la lista";
            return temp;
        } 
        for(Nodo i = raiz; i.sig != null; i = i.sig)
            if(i.sig.info.equals(x))
                return i;
        return null; 
    }
    
    public Nodo DespuesDe(E x){
         for(Nodo i = raiz; i != null; i = i.sig)
            if(i.info.equals(x))
                return i.sig;
        return null; 
    }
    
    public boolean Buscar(E x){
         for(Nodo i = raiz; i != null; i = i.sig)
            if(i.info.equals(x))
                return true;
        return false; 
    }
    
    public void Eliminar(E x){
        if(!Buscar(x))
            StdOut.println("No está en la lista");
        else{
            Nodo temp = AntesDe(x);
            if(raiz.info.equals(x))
                raiz = raiz.sig; 
            if(temp!=null)
            temp.sig = temp.sig.sig;
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
        StdOut.println(imprimirInversa(raiz));
    }
    
    public void imprimirNormal(){
        StdOut.println(imprimirNormal(raiz));
    }
    
    /**Obtener una lista en forma de vector*/
    
    public Vector<E> formaVector(){
        Vector<E> vecTemp = new Vector <E>();
        Nodo temp = raiz;
        while(temp != null){
            vecTemp.add(temp.info);
            temp = temp.sig;
        }
        return vecTemp;
    }
    
    /**Llenar una lista dado un vector*/
    
    public LinkedListPlusRecursividadGenerico<E> llenarListaVector(Vector <E> vec){
        LinkedListPlusRecursividadGenerico <E> lista = new LinkedListPlusRecursividadGenerico();
        for(int i = 0; i < vec.size(); i++)
            lista.insertarPrimero(vec.elementAt(i));
        return lista;    
    }
    
    /**
     * 
     * Estos metodos no estoy seguro de que vayan aqui
     *  
       */
   
    
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
    
    //#Metodo pendiente (Tal vez no incluirlo)*/
    public LinkedListPlusRecursividadGenerico<E> listaDebilidadTal(String debilidad){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.sig){
                String [] temp = ((SuperHeroe)(i.info)).getDebilidad().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(debilidad)))
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
    
    public LinkedListPlusRecursividadGenerico<E> listaAñoApaircionTal(int añoAparicion){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.sig){
                for(int j = 0; j < ((SuperHeroe)(i.info)).getAñoAparicion().length; j++)
                    if(((SuperHeroe)(i.info)).getAñoAparicion()[j] == añoAparicion)
                         lista.insertarPrimero(((E)(i.info)));
            }
        return lista;
    }
    
}
