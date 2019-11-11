
/**
 * Practica para crear una lista ligada simple
 * Agregar elemento al inicio
 * Agregar elemento al final
 * buscar
 * eliminar
 * antes de 
 * despues
 * mostrar
 * isEmpty
 */
public class ListaSimple
{
    private Nodo head;
    private Nodo fin;
    
    private class Nodo{
        Nodo next;
        String info;
    }
    
    public void eliminar(String info){
        Nodo temp = buscar(info);
        if(!isEmpty() && temp != null){
            if(temp == head)
                eliminarInicio();
            else if (temp == fin)
                    eliminarFinal();
                else{
                    Nodo aux = antesDe(info);
                    aux.next = aux.next.next;
                   }
        }
    }
    
    public void eliminarInicio(){
        if(!isEmpty()){
            Nodo temp = head.next;
            head.next = null;
            head = temp;
        }
    }
    
    public void eliminarFinal(){
        if(!isEmpty()){
            Nodo temp = antesDe(fin.info);
            temp.next = null;
            fin = temp;
         }
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void insertarInicio(String info){
        Nodo temp = new Nodo();
        temp.info = info;
            
        if(isEmpty()){
            head = temp;
            fin = temp;
        }else{
            temp.next = head;
            head = temp;
        }
    }
    
    public void insertarFinal(String info){
        if(isEmpty()){
            insertarInicio(info);
        }else{
            Nodo temp = new Nodo();
            temp.info = info;
            temp.next = null;
            fin.next = temp;
            fin = temp;
        }
    }   
    
    public Nodo buscar(String info){
        Nodo temp = head;
        if(!isEmpty())
            while(temp != null){
                if(temp.info.equals(info))
                    return temp;
            temp = temp.next;    
           }
        return null;
    }
    
    public Nodo antesDe(String info){
        Nodo temp = head;
        if(!isEmpty() && buscar(info) != null)
            if(head.info.equals(info))
                return null;
            else   
            while(temp != null){
                if(temp.next.info.equals(info))
                    return temp;
                temp = temp.next;
            }    
        return null;      
    }
    
    public Nodo despuesDe(String info){
        if(!isEmpty())
            return buscar(info).next;
        return null;    
        }
    
    /*
    public Nodo despuesDe(String info){
        Nodo temp = head;
        if(!isEmpty())
            while(temp != null){
                if(temp.info.equals(info))
                    return temp.next;
                temp = temp.next;
           }
        return null;            
    }*/
    
    public String infoNodo(Nodo temp){
        if(temp != null)
            return temp.info;
        return "Es un null";    
    }
    
    public void mostrar(){
        Nodo temp = head;
        while(temp != null){
            StdOut.println(temp.info);
            temp = temp.next;
        }
    }
    
}
