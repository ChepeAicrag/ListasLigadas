
public class Pila 
{
    private Nodo first;
    private int tam;
    private class Nodo{
        Nodo next;
        String info;
    }
    
    public void push(String info){
        Nodo temp = first;
        first = new Nodo();
        first.info = info;
        first.next = temp;
        tam++;
    }
    
    public void push2(String info){
        Nodo temp = new Nodo();
        temp.info = info;
        temp.next = first;
        first = temp;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public String pop(){
        String info = "";
        if(!isEmpty()){
            info = first.info;
            first = first.next;
        }
        return info;
    }
    
    public String peek(){
        if(!isEmpty())
            return first.info;
        return "No hay elementos";    
    }
    
    public void mostrar(){
        Nodo temp = first;
        while(temp != null){
            StdOut.println(temp.info + " ");
            temp = temp.next;
        }
    }
    
    public Pila clonar(){
        Pila aux = new Pila();
        Pila clon = new Pila();
        while(!isEmpty())
            aux.push(pop());
        while(!aux.isEmpty()){
            String s = aux.pop();
            clon.push(s);
            push(s);
        }    
        return clon;
    }
    
    public void cambiar(String viejo,String nuevo){
        Pila aux = new Pila();
        while(!isEmpty()){
            String s = pop();
            if(s.equals(viejo))
                s = nuevo;
            aux.push(s);    
        }while(!aux.isEmpty())
            push(aux.pop());
        
    }
}
