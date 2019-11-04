/**
 * ListaCircular sencilla
 */
public class ListaCircular<E>{
    
    private class Node {
        E informacion;
        Node siguiente;
    }
    
    public ListaCircular(){
        head = null;
    }
    
    private Node head;
    private Node tail;
        
    public Node eliminar(E dato){ 
        if(head == null)
            return head;
        else{    
           Node curr = head;
           Node prev = new Node();
           do{
               if(curr.informacion.equals(dato))
                  if(curr.siguiente == curr){
                    head = null;
                    return head;
                   }else{
                       if(curr == head){
                           //prev = tail
                           for(prev = head; prev.siguiente != head; prev = prev.siguiente){}
                           head = curr.siguiente;
                           prev.siguiente = head;
                        }else if(curr.siguiente == head){
                                prev.siguiente = head;
                        }else{
                            prev.siguiente = curr.siguiente;
                        }   
                    }
               prev = curr;
               curr = curr.siguiente;
            }while( curr != head);
       }
       return head;
    }
    
    public void ImprimirLista(Node first){  
        Node temp = first;
        if(estaVacia())
           StdOut.println(" Lista Vacia!! ");
        else
            do{
                StdOut.println(temp.informacion);
                temp = temp.siguiente;
            }while(temp != head);
                   
    }
    
    public Node getHead(){
        return head;
    }
    
    public Node getTail(){
        return tail;
    }
    
    public E getInfoNode(Node x){
        if(x != null)
            return x.informacion;
        return null;    
    }
    
    public boolean estaVacia(){
        return head == null;    
    }
    
    public void InsertarPrimero(E dato){
      if(estaVacia()){
          head = new Node();
          head.informacion = dato;
          head.siguiente = head;
          tail = head;
       }else{
            Node x = new Node();
            x.informacion = dato;
            x.siguiente = head;
            tail.siguiente = x;
            head = x;
         }
    }
}