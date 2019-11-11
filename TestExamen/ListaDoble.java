
/**
 * Practica para crear una lista ligada simple
 * Agregar elemento al inicio
 * Agregar elemento al final
 * buscar
 * eliminar
 * mostrar
 * isEmpty
 */
public class ListaDoble
{
    private Nodo head;
    private Nodo fin;
    
    private class Nodo{
        Nodo next;
        Nodo prev;
        String info;
    }
    
    public String getCabeza(){
        return infoNodo(head);
    }
    
    public String getFin(){
        return infoNodo(fin);
    }
    
    public String infoNodo(Nodo temp){
        if(temp == null)
            return "Es un null";
        return temp.info;
    }
    
    public void eliminarIncio(){
        if(!isEmpty()){
            Nodo temp = head.next;
            head.next = null;
            temp.prev = null;
            head = temp;
        }
    }
    
    public void eliminarFinal(){
        if(!isEmpty()){
            Nodo temp = fin.prev;
            head.next = null;
            temp.next = null;
            fin = temp;
        }
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void insertarFinal(String info){
        Nodo temp = new Nodo();
        temp.info = info;
        if(isEmpty())
            insertarInicio(info);
        else{
            fin.next = temp;
            temp.prev = fin;
            fin = temp;
        }
    }
    
    public void insertarInicio(String info){
        Nodo temp = new Nodo();
        temp.info = info;
        if(isEmpty()){
            head = temp;
            fin = temp;
        }else{
            fin = head;
            head.prev = temp;
            temp.next = head;
            head = temp;
        }
    }
    
    public void mostrar(){
        Nodo temp = head;
        if(isEmpty())
            StdOut.println("Lista vacia");
        else    
        while(temp != null){
            StdOut.println(temp.info);
            temp = temp.next;
        }
    }
    
    public Nodo buscar(String info){
        Nodo temp = head;
        if(!isEmpty())
            while(temp != null)
                if(temp.info.equals(info))
                    return temp;
            temp = temp.next;
        return null;    
    }
    
    public Nodo antesDe(String info){
        if(!isEmpty())
            return buscar(info).prev;
        return null;    
    }
    
    public Nodo despuesDe(String info){
        if(!isEmpty())
            return buscar(info).next;
        return null;    
    }
}   
