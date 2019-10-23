
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
}
