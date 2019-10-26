import java.util.*;
import java.text.Normalizer;

/**Falta validad si está o no, para que no siga la busqueda*/
public class LinkedListPlusRecursividadGenerico<E> {
    
    private class Nodo {
        E info;
        Nodo sig;
    }
    /*
    public LinkedListPlusRecursividadGenerico(){
       Archivo.LlenarArchivo(lista,"SuperHeroesContenido"); // Volvemeos a rellenar el archivo (Actualizar)
       Archivo.LeerArchivo("SuperHeroesContenido"); // Mostramos el archivo
       
    }*/
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
    public LinkedListPlusRecursividadGenerico<E> listaSexoYAutorTal(String poder, String autor){
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
