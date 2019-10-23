import java.util.*;
public class LinkedListPlusRecursividadGenerico<E> {
    
    private class Nodo {
        E info;
        Nodo sig;
    }
    
    private Nodo raiz;
    
    public E getInfo(Nodo temp){ 
        if(temp != null)
            return temp.info;
        return  null;
    }
    
    public Nodo getRaiz(){
        return raiz;
    }
    
    public Nodo AntesDe(E x){
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
        Nodo temp = AntesDe(x);
        if(raiz.info.equals(x))
           raiz = raiz.sig;
        if(temp!=null)
        temp.sig = temp.sig.sig;
        
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
    
    public LinkedListPlusRecursividadGenerico<E> llenarListaVector(Vector <E> vec){
        LinkedListPlusRecursividadGenerico <E> lista = new LinkedListPlusRecursividadGenerico();
        for(int i = 0; i < vec.size(); i++)
            lista.insertarPrimero(vec.elementAt(i));
        return lista;    
    }
    
    /**Estos metodos no estoy seguro de que vayan aqui*/
    
    //Retorna una lista de los que tienen el mismo poder
    public LinkedListPlusRecursividadGenerico<E> listaPoderTal(String poder){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.sig){
                if(((SuperHeroe)(i.info)).getPoder().equals(poder))
                    lista.insertarPrimero(((E)(i.info)));
            }
        return lista;
    }
    
    public LinkedListPlusRecursividadGenerico<E> listaSexoTal(char sexo){
        LinkedListPlusRecursividadGenerico<E> lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.sig){
                if(((SuperHeroe)(i.info)).getSexo() == sexo)
                    lista.insertarPrimero(((E)(i.info)));
            }
        return lista;
    }
}
