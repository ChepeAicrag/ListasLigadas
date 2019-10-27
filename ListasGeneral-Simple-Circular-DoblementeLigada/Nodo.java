
public class Nodo<E>{
    private E informacion;
    private Nodo siguiente;
    private Nodo anterior;
     public Nodo(){
        this. informacion = null;
        this. siguiente = null;
        this. anterior = null;
    }
    public void setAnterior(Nodo anterior){
        this.anterior = anterior;
    }
    
    public Nodo getAnterior(){
        return anterior;
    }
    
    public void setSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }
    
    public void setInformacion(E informacion){
        this.informacion = informacion;
    }
    
    public E getInformacion(){
        return informacion;
    }
    
    public Nodo getSiguiente(){
        return siguiente;
    }
}

