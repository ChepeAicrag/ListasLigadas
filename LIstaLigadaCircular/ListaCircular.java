
import java.text.Normalizer;
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
    
    public void InsertarPrimero(E dato){
      if(Vacia()){
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
    
    public void InsertarFinal(E dato){
      if(Vacia())
         InsertarPrimero(dato); //Lo mismo que agregar al inicio
      else{
           Node x = new Node();
           x.informacion = dato;
           x.siguiente = head;
           tail.siguiente = x;
           tail = x;
        }
      
    }
    
    public void ImprimirLista(){  
        Node temp = head;
        if(temp == null)
           StdOut.println("Lista vacia!!");
        else
            do{
                StdOut.println(temp.informacion);
                temp = temp.siguiente;
            }while(temp != head);
                   
    }
    
    public boolean Vacia(){
        if(head == null)
            return true;
        return false;    
    }
    
    public Node Buscar(E dato){
        Node buscado = null;
        Node iterador = head;
        while ( buscado == null && iterador != null ) {
            if ( iterador.informacion.equals(dato) ) {
                buscado = iterador;
            }
            iterador = iterador.siguiente;
        }
        return buscado;
    }
    
    public Node AntesDe(E x){
        Node temp = null;
        if(Buscar(x) != null) //Comprobar de lo que vamos a buscar existe
            if(head.informacion.equals(x)) //Caso especial de buscar antes de head, se retorna a tail
                return tail;
             else 
                for(Node i = head; i.siguiente != head; i = i.siguiente)
                    if(i.siguiente.informacion.equals(x))
                        temp = i;
        return temp; 
    }
    
    /** Si solo queremos el nodo que está despues*/
    public Node DespuesDe(E x){
        Node temp = null;
        if(Buscar(x) != null)
              if(tail.informacion.equals(x)) //Caso especial si se busca depues de tail, entonces se retorna a head
                 return head;
              for(Node i = head; i.siguiente != head; i = i.siguiente)
                  if(i.informacion.equals(x))
                     temp = i.siguiente;
        return temp; 
    }
    
    public void EliminarInicio(){
        if(!Vacia()){
            head = head.siguiente;
            tail.siguiente = tail.siguiente.siguiente;
        }
            
    }
    
    /**Es mejor recorrerla así, está completa*/
    public void RecorrerLista(){
        Node temp = head;
        do{
            StdOut.println(temp.informacion);
            temp = temp.siguiente;
        }while(temp != head);
    }
    
    
        /**
     * 
     * Estos metodos no estoy seguro de que vayan aqui
     *  
     */
      
   /** Metodo termiando para buscar por alias */
    
    public ListaCircular<E> ListaAliasTal(String alias){
        ListaCircular<E> Lista = new ListaCircular();
        Node i = head;
        if(Vacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{    
                String [] temp = ((SuperHeroe)(i.informacion)).getAlias().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(alias)))
                        Lista.InsertarPrimero(((E)(i.informacion)));
                i = i.siguiente;
            }while(i != head);
            
        return Lista;
    }
    
    /** Metodo termiando para buscar por nombre real */
    
    public ListaCircular<E> ListaNombreRealTal(String nombreReal){
        ListaCircular<E> Lista = new ListaCircular();
        Node i = head;
        if(Vacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{    
                String [] temp = ((SuperHeroe)(i.informacion)).getNombreReal().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(nombreReal)))
                        Lista.InsertarPrimero(((E)(i.informacion)));
                i = i.siguiente;        
            }while(i != head);
        return Lista;
    }
    
    /** Metodo termiando para buscar por poder */
    
    public ListaCircular<E> ListaPoderTal(String poder){
        ListaCircular<E> Lista = new ListaCircular();
        Node i = head;
        if(Vacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{    
                String [] temp = ((SuperHeroe)(i.informacion)).getPoder().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(poder)))
                        Lista.InsertarPrimero(((E)(i.informacion)));
                i = i.siguiente;        
            }while(i != head);
        return Lista;
    }
    
    /** Metodo termiando para buscar por autor*/
    
    public ListaCircular<E> ListaAutorTal(String autor){
        ListaCircular<E> Lista = new ListaCircular();
        Node i = head;
        if(Vacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
         else
            do{ 
                String [] temp = ((SuperHeroe)(i.informacion)).getAutor().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(autor)))
                        Lista.InsertarPrimero(((E)(i.informacion)));
                i = i.siguiente;        
            }while(i != head);
        return Lista;
    }
    
    /** Metodo termiando para buscar por origen*/
    
    public ListaCircular<E> ListaOrigenTal(String origen){
        ListaCircular<E> Lista = new ListaCircular();
        Node i = head;
        if(Vacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{ 
                String [] temp = ((SuperHeroe)(i.informacion)).getOrigen().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(origen)))
                        Lista.InsertarPrimero(((E)(i.informacion)));
                i = i.siguiente;        
            }while(i != head);
        return Lista;
    }
    
    /** Metodo termiando para buscar por comic*/
    
    public ListaCircular<E> ListaComicTal(String comic){
        ListaCircular<E> Lista = new ListaCircular();
        Node i = head;
        if(Vacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{ 
                String [] temp = ((SuperHeroe)(i.informacion)).getComic().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(comic)))
                        Lista.InsertarPrimero(((E)(i.informacion)));
                i = i.siguiente;        
            }while(i != head);
        return Lista;
    }
    
    /** Metodo termiando para buscar por afiliacion*/
    
    public ListaCircular<E> ListaAfiliacionTal(String afiliacion){
        ListaCircular<E> Lista = new ListaCircular();
        Node i = head;
        if(Vacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{    
                String [] temp = ((SuperHeroe)(i.informacion)).getAfiliacionActual().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(afiliacion)))
                        Lista.InsertarPrimero(((E)(i.informacion)));
                i = i.siguiente;        
            }while(i != head);
        return Lista;
    }
    
    /** Metodo termiando para buscar por raza*/
    
    public ListaCircular<E> ListaRazaTal(String raza){
        ListaCircular<E> Lista = new ListaCircular();
        Node i = head;
        if(Vacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{    
                String [] temp = ((SuperHeroe)(i.informacion)).getRaza().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(raza)))
                        Lista.InsertarPrimero(((E)(i.informacion)));
                i = i.siguiente;        
            }while(i != head);
        return Lista;
    }
    
    //#Metodo pendiente (Tal vez no incluirlo)*/
    public ListaCircular<E> ListaDebilidadTal(String debilidad){
        ListaCircular<E> Lista = new ListaCircular();
        Node i = head;
        if(Vacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{    
                String [] temp = ((SuperHeroe)(i.informacion)).getDebilidad().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(debilidad)))
                        Lista.InsertarPrimero(((E)(i.informacion)));
                i = i.siguiente;        
            }while(i != head);
        return Lista;
    }
    
    /**Metodo para qutar las tildes de un string, para hacer mas eficiente la busqueda*/
    
    private static String cleanString(String info) {
        info = Normalizer.normalize(info, Normalizer.Form.NFD);
        info = info.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return info;
    }
    
    /** Metodo termiando para buscar por sexo */
    
    public ListaCircular<E> ListaSexoTal(char sexo){
        ListaCircular<E> Lista = new ListaCircular();
        Node i = head;
        if(Vacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{    
                if(((SuperHeroe)(i.informacion)).getSexo() == sexo)
                    Lista.InsertarPrimero(((E)(i.informacion)));
                i = i.siguiente;
            }while(i != head);
        return Lista;
    }
    
    /** Metodo termiando para buscar por año / años de aparicion*/
    
    public ListaCircular<E> ListaAñoAparicionTal(int añoAparicion){
        ListaCircular<E> Lista = new ListaCircular();
        Node i = head;
        if(Vacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{    
                for(int j = 0; j < ((SuperHeroe)(i.informacion)).getAñoAparicion().length; j++)
                    if(((SuperHeroe)(i.informacion)).getAñoAparicion()[j] == añoAparicion)
                         Lista.InsertarPrimero(((E)(i.informacion)));
                i = i.siguiente;         
            }while(i != head);
        return Lista;
    }
}

