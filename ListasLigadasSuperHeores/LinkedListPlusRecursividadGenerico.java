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
        if(Buscar(x)) //Comprobar de lo que vamos a buscar existe
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
        if(Buscar(x))
              for(Nodo i = raiz; i != null; i = i.sig)
                  if(i.info.equals(x))
                     temp = i.sig;
        return temp; 
    }
    
    /** Si queremos la informacion del nodo que está despues */
    public E DespuesDeInfo(E x){
        if(((SuperHeroe)BuscarUltimo().info).equals(x)) //Busco de que existe en la lista y de que despues de él solo hay null
            return (E) "Nadie eres el ultimo!!";        // Como no hay referencia, se tiene que comparar como objeto, por ello el casting
        if(DespuesDe(x) == null && !Buscar(x)) //Si no se encuentra y es null, entonces no está en la lista
        return (E) "No está en la lista";
        return getInfo(DespuesDe(x));   
    }
    
    public boolean Buscar(E x){
       if(x != null) // Si es diferente de null se busca, de lo contrario es false
         for(Nodo i = raiz; i != null; i = i.sig)
            if(i.info.equals(x))
                return true;
        return false; 
    }
    
    public Nodo BuscarUltimo(){
        Nodo temp = null;
        for(Nodo i = raiz; i != null; i = i.sig)
            if(i.sig == null)
            temp = i;
        return temp;    
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
    
    /** Metodo para buscar por sexo y poder tal*/
    public LinkedListPlusRecursividadGenerico<E> listaSexoYPoderTal(char sexo, String poder){
        LinkedListPlusRecursividadGenerico<E> lista = listaSexoTal(sexo); //Te entrega una lista de sexo tal 
        return lista.listaPoderTal(poder); //Te regresa quienes tienen el poder, sobre esa misma lista
    }
}
