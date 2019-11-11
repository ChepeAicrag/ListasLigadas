

public class Cola
{
    private Nodo first;
    private Nodo last;
    private class Nodo{
        Nodo next;
        String info;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public void enqueue(String info){
        Nodo temp = new Nodo();
        temp.info = info;
        temp.next = null;
        if(isEmpty()){
            first = temp;
            last = first;
        }else{
            last.next = temp;
            last = temp;
        }
   }
   
   public String dequeue(){
       if(!isEmpty()){
            String s = first.info;
            first = first.next;
            return s;
        } 
       return "No hay datos en la cola";
    }
    
   public void invertir(){
       Pila aux = new Pila();
       while(!isEmpty())
            aux.push(dequeue());
       while(!aux.isEmpty())
            enqueue(aux.pop());
    } 
    
   public Cola clonar(){
       Cola copia = new Cola();
       Cola clon = new Cola();
       while(!isEmpty())
            copia.enqueue(dequeue());
       while(!copia.isEmpty()){
            String s = copia.dequeue();
            enqueue(s);
            clon.enqueue(s);
        }     
       return clon; 
    } 
    
   public void modificar(String viejo, String nuevo){
       Cola aux = new Cola();
       while(!isEmpty()){
           String s = dequeue();
           if(s.equals(viejo))
                s = nuevo;
           aux.enqueue(s);
        }
       while(!aux.isEmpty())
            enqueue(aux.dequeue());
    }
    
    public void mostrar(){
        Nodo temp = first;
        while(temp != null){
            StdOut.println(temp.info);
            temp = temp.next;
        }
            
    }
}
