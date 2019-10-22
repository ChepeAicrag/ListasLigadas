
public class LinkedListPlusRecursividadGenerico<E> {
    
    private class Nodo {
        E info;
        Nodo sig;
    }
    
    private Nodo raiz;
    
    public E getInfo(Nodo temp){ 
        if(temp != null)
        return temp.info;
        return  null;//return raiz.info;
    }
    
    
    public Nodo getRaiz(){
        return raiz;
    }
    
    public Nodo BuscarAntesDe(E x){
        for(Nodo i = raiz; i.sig != null; i = i.sig){
            /*if(raiz.info.equals(x))
                return raiz;*/
            if(i.sig.info.equals(x))
                return i;
        }
        return null;  //De prueba, debe ser null   
    }
    
    public void Eliminar(E x){
        Nodo temp = BuscarAntesDe(x);
        if(temp!=null)
        temp.sig = temp.sig.sig; //Adelanto 1 posicion para brinca y así el recolector lo elimina
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
