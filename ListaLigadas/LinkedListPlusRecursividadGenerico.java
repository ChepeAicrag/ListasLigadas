

/**Lista simplemente ligada de los superhores DC COMICS 
   Recorrer e imprimir
   Decir si está o n
   Decir si está antes de o despues de 
   Posteriormente convertir doblemente ligada
   */

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
    
    public Nodo BuscarAntesDe(E x){
        for(Nodo i = raiz; i.sig != null; i = i.sig)
            if(i.sig.info.equals(x))
                return i;
        return null; 
    }
    
    public void Eliminar(E x){
        Nodo temp = BuscarAntesDe(x);
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
