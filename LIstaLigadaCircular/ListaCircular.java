
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
                           prev = head; // preve = curr
                           do{
                              prev = prev.siguiente;
                              }while(prev != head);
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
    
    public void InsertarFinal(E dato){
      if(estaVacia())
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
        if(estaVacia())
           StdOut.println("Lista estaVacia!!");
        else
            do{
                StdOut.println(temp.informacion);
                temp = temp.siguiente;
            }while(temp != head);
                   
    }
    
    public boolean estaVacia(){
        if(head == null)
            return true;
        return false;    
    }
    
    public Node Buscar(E dato){
        Node buscado = null;
        Node iterador = head;
        if(dato != null){ // Si es diferente de null se busca, de lo contrario es false
            do{
               if ( iterador.informacion.equals(dato)) 
                   buscado = iterador;
            iterador = iterador.siguiente;
          }while ( buscado == null && iterador != head );
        }
        return buscado;
    }
    
    public Node AntesDe(E x){
        Node temp = null;
        if(Buscar(x) != null){ //Comprobar de lo que vamos a buscar existe
            if(head.informacion.equals(x)) //Caso especial de buscar antes de head, se retorna a tail
                return tail;
             else 
                for(Node i = head; i.siguiente != head; i = i.siguiente)
                    if(i.siguiente.informacion.equals(x))
                        temp = i;
        }
        return temp; 
    }
    
    /** Si solo queremos el nodo que está despues*/
    public Node DespuesDe(E x){
        Node temp = null;
        if(Buscar(x) != null){
              if(tail.informacion.equals(x)) //Caso especial si se busca depues de tail, entonces se retorna a head
                 return head;
              for(Node i = head; i.siguiente != head; i = i.siguiente)
                  if(i.informacion.equals(x))
                     temp = i.siguiente;
        }
        return temp; 
    }
    
    public void Eliminar(E x){
        if(Buscar(x) == null)
            StdOut.println("No está en la lista, no se puede eliminar");
        else{
             if(Buscar(x) == head)
                EliminarInicio();
             if(Buscar(x) == tail)
                eliminarFinal();
              else{    
                  Node temp = AntesDe(x);
                  temp.siguiente = temp.siguiente.siguiente;
                }
        }
    }
    
    public void EliminarInicio(){
        if(!estaVacia()){
            head = head.siguiente;
            tail.siguiente = tail.siguiente.siguiente;
        }
            
    }
    
    public void eliminarFinal(){
        if(!estaVacia()){
            Node temp = AntesDe(getTail().informacion);
            tail = temp;
            temp.siguiente = head;
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
      
   /** Metodo termiando para buscar por alias */
    
    public ListaCircular<E> ListaAliasTal(String alias){
        ListaCircular<E> Lista = new ListaCircular();
        Node i = head;
        if(estaVacia())
            StdOut.println("La lista está estaVacia, se regreso una estaVacia");
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
        if(estaVacia())
            StdOut.println("La lista está estaVacia, se regreso una estaVacia");
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
        if(estaVacia())
            StdOut.println("La lista está estaVacia, se regreso una estaVacia");
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
        if(estaVacia())
            StdOut.println("La lista está estaVacia, se regreso una estaVacia");
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
        if(estaVacia())
            StdOut.println("La lista está estaVacia, se regreso una estaVacia");
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
        if(estaVacia())
            StdOut.println("La lista está estaVacia, se regreso una estaVacia");
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
        if(estaVacia())
            StdOut.println("La lista está estaVacia, se regreso una estaVacia");
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
        if(estaVacia())
            StdOut.println("La lista está estaVacia, se regreso una estaVacia");
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
        if(estaVacia())
            StdOut.println("La lista está estaVacia, se regreso una estaVacia");
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
        if(estaVacia())
            StdOut.println("La lista está estaVacia, se regreso una estaVacia");
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
        if(estaVacia())
            StdOut.println("La lista está estaVacia, se regreso una estaVacia");
        else
            do{    
                for(int j = 0; j < ((SuperHeroe)(i.informacion)).getAñoAparicion().length; j++)
                    if(((SuperHeroe)(i.informacion)).getAñoAparicion()[j] == añoAparicion)
                         Lista.InsertarPrimero(((E)(i.informacion)));
                i = i.siguiente;         
            }while(i != head);
        return Lista;
    }
    
        
    /**
     * Metodos combiandos que generan Lista, apartir de Listas (Filtrado)
     * 
     */
    
    
    /** Metodo terminado para buscar por sexo y poder tal*/
    public ListaCircular<E> ListaSexoYPoderTal(char sexo, String poder){
        ListaCircular<E> Lista = ListaSexoTal(sexo); //Te entrega una Lista de sexo tal 
        return Lista.ListaPoderTal(poder); //Te regresa quienes tienen el poder, sobre esa misma Lista
    }
    
    /** Metodo terminado para buscar por sexo y año tal*/
    public ListaCircular<E> ListaSexoYAñoAparicionTal(char sexo, int añoAparicion){
        ListaCircular<E> Lista = ListaSexoTal(sexo);
        return Lista.ListaAñoAparicionTal(añoAparicion);
    }
    
    /** Metodo terminado para buscar por sexo y autor tal*/
    public ListaCircular<E> ListaSexoYAutorTal(char sexo, String autor){
         ListaCircular<E> Lista = ListaSexoTal(sexo);
         return Lista.ListaAutorTal(autor);
    }
    
    /** Metodo terminado para buscar por sexo y origen tal*/
    public ListaCircular<E> ListaSexoYOrigenTal(char sexo, String origen){
         ListaCircular<E> Lista = ListaSexoTal(sexo);
         return Lista.ListaOrigenTal(origen);
    }
    
    /** Metodo terminado para buscar por sexo y comic tal*/
    public  ListaCircular<E> ListaSexoYComicTal(char sexo, String comic){
         ListaCircular<E> Lista = ListaSexoTal(sexo);
         return Lista.ListaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por sexo y afiliacion tal*/
    public  ListaCircular<E> ListaSexoYAfiliacionTal(char sexo, String afiliacion){
         ListaCircular<E> Lista = ListaSexoTal(sexo);
         return Lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por sexo y raza tal*/
    public  ListaCircular<E> ListaSexoYRazaTal(char sexo, String raza){
         ListaCircular<E> Lista = ListaSexoTal(sexo);
         return Lista.ListaRazaTal(raza);
    }
    
        /** Metodo terminado para buscar por poder y año tal*/
    public ListaCircular<E> ListaPoderYAñoAparicionTal(String poder, int añoAparicion){
        ListaCircular<E> Lista = ListaPoderTal(poder);
        return Lista.ListaAñoAparicionTal(añoAparicion);
    }
    
    /** Metodo terminado para buscar por poder y autor tal*/
    public ListaCircular<E> ListaPoderYAutorTal(String poder, String autor){
         ListaCircular<E> Lista = ListaPoderTal(poder);
         return Lista.ListaAutorTal(autor);
    }
    
    /** Metodo terminado para buscar por poder y origen tal*/
    public ListaCircular<E> ListaPoderYOrigenTal(String poder, String origen){
         ListaCircular<E> Lista = ListaPoderTal(poder);
         return Lista.ListaOrigenTal(origen);
    }
    
    /** Metodo terminado para buscar por poder y comic tal*/
    public  ListaCircular<E> ListaPoderYComicTal(String poder, String comic){
         ListaCircular<E> Lista = ListaPoderTal(poder);
         return Lista.ListaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por poder y afiliacion tal*/
    public  ListaCircular<E> ListaPoderYAfiliacionTal(String poder, String afiliacion){
         ListaCircular<E> Lista = ListaPoderTal(poder);
         return Lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por poder y raza tal*/
    public  ListaCircular<E> ListaPoderYRazaTal(String poder, String raza){
         ListaCircular<E> Lista = ListaPoderTal(poder);
         return Lista.ListaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por año y autor tal*/
    public ListaCircular<E> ListaAñoAparicionYAutorTal(int añoAparicion, String autor){
         ListaCircular<E> Lista = ListaAñoAparicionTal(añoAparicion);
         return Lista.ListaAutorTal(autor);
    }
    
    /** Metodo terminado para buscar por año y origen tal*/
    public ListaCircular<E> ListaAñoAparicionYOrigenTal(int añoAparicion, String origen){
         ListaCircular<E> Lista = ListaAñoAparicionTal(añoAparicion);
         return Lista.ListaOrigenTal(origen);
    }
    
    /** Metodo terminado para buscar por año y comic tal*/
    public  ListaCircular<E> ListaAñoAparicionYComicTal(int añoAparicion, String comic){
         ListaCircular<E> Lista = ListaAñoAparicionTal(añoAparicion);
         return Lista.ListaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por año y afiliacion tal*/
    public  ListaCircular<E> ListaAñoAparicionYAfiliacionTal(int añoAparicion, String afiliacion){
         ListaCircular<E> Lista = ListaAñoAparicionTal(añoAparicion);
         return Lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por año y raza tal*/
    public  ListaCircular<E> ListaAñoAparicionYRazaTal(int añoAparicion, String raza){
         ListaCircular<E> Lista = ListaAñoAparicionTal(añoAparicion);
         return Lista.ListaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por autor y origen tal*/
    public ListaCircular<E> ListaAutorYOrigenTal(String autor, String origen){
         ListaCircular<E> Lista = ListaAutorTal(autor);
         return Lista.ListaOrigenTal(origen);
    }
    
    /** Metodo terminado para buscar por autor y comic tal*/
    public  ListaCircular<E> ListaAutorYComicTal(String autor, String comic){
         ListaCircular<E> Lista = ListaAutorTal(autor);
         return Lista.ListaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por autor y afiliacion tal*/
    public  ListaCircular<E> ListaAutorYAfiliacionTal(String autor, String afiliacion){
         ListaCircular<E> Lista = ListaAutorTal(autor);
         return Lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por autor y raza tal*/
    public  ListaCircular<E> ListaAutorYRazaTal(String autor, String raza){
         ListaCircular<E> Lista = ListaAutorTal(autor);
         return Lista.ListaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por origen y comic tal*/
    public  ListaCircular<E> ListaOrigenYComicTal(String origen, String comic){
         ListaCircular<E> Lista = ListaOrigenTal(origen);
         return Lista.ListaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por origen y afiliacion tal*/
    public  ListaCircular<E> ListaOrigenYAfiliacionTal(String origen, String afiliacion){
         ListaCircular<E> Lista = ListaOrigenTal(origen);
         return Lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por origen y raza tal*/
    public  ListaCircular<E> ListaOrigenYRazaTal(String origen, String raza){
         ListaCircular<E> Lista = ListaOrigenTal(origen);
         return Lista.ListaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por comic y afiliacion tal*/
    public  ListaCircular<E> ListaComicYAfiliacionTal(String comic, String afiliacion){
         ListaCircular<E> Lista = ListaComicTal(comic);
         return Lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por comic y raza tal*/
    public  ListaCircular<E> ListaComicYRazaTal(String comic, String raza){
         ListaCircular<E> Lista = ListaComicTal(comic);
         return Lista.ListaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por afiliacion y raza tal*/
    public  ListaCircular<E> ListaAfiliacionYRazaTal(String afiliacion, String raza){
         ListaCircular<E> Lista = ListaAfiliacionTal(afiliacion);
         return Lista.ListaRazaTal(raza);
    }
    
    //#Agregando eliminar 
    
    /** Metodo termiando para eliminar por alias */
    public void EliminarConAliasTal(String alias){
        Node i = head;
        if(!estaVacia())
            do{    
                String [] temp = ((SuperHeroe)(i.informacion)).getAlias().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(alias)))
                        Eliminar(((E)(i.informacion)));
                i = i.siguiente;
            }while(i != head);
    }
    
    /** Metodo termiando para eliminar por nombre real */
    public void EliminarConNombreRealTal(String nombreReal){
        Node i = head;
        if(!estaVacia())
            do{    
                String [] temp = ((SuperHeroe)(i.informacion)).getNombreReal().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(nombreReal)))
                        Eliminar(((E)(i.informacion)));
                i = i.siguiente;        
            }while(i != head);
    }
    
    /** Metodo termiando para eliminar por poder */
    public void EliminarConPoderTal(String poder){
        Node i = head;
        if(!estaVacia())
            do{    
                String [] temp = ((SuperHeroe)(i.informacion)).getPoder().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(poder)))
                        Eliminar(((E)(i.informacion)));
                i = i.siguiente;        
            }while(i != head);
    }
    
    
    /** Metodo termiando para eliminar por autor*/
    public void EliminarConAutorTal(String autor){
        Node i = head;
        if(!estaVacia())
            do{ 
                String [] temp = ((SuperHeroe)(i.informacion)).getAutor().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(autor)))
                        Eliminar(((E)(i.informacion)));
                i = i.siguiente;        
            }while(i != head);
    }
    
    /** Metodo termiando para eliminar por origen*/
    
    public void EliminarConOrigenTal(String origen){
        Node i = head;
        if(!estaVacia())
            do{ 
                String [] temp = ((SuperHeroe)(i.informacion)).getOrigen().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(origen)))
                        Eliminar(((E)(i.informacion)));
                i = i.siguiente;        
            }while(i != head);
    }
    
    /** Metodo termiando para eliminar por comic*/
    
    public void EliminarConComicTal(String comic){
        Node i = head;
        if(!estaVacia())
            do{ 
                String [] temp = ((SuperHeroe)(i.informacion)).getComic().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(comic)))
                        Eliminar(((E)(i.informacion)));
                i = i.siguiente;        
            }while(i != head);
    }
    
    /** Metodo termiando para eliminar por afiliacion*/
    
    public void EliminarConAfiliacionTal(String afiliacion){
        Node i = head;
        if(!estaVacia())
            do{    
                String [] temp = ((SuperHeroe)(i.informacion)).getAfiliacionActual().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(afiliacion)))
                        Eliminar(((E)(i.informacion)));
                i = i.siguiente;        
            }while(i != head);
    }
    
    /** Metodo termiando para eliminar por raza*/
    
    public void EliminarConRazaTal(String raza){
        Node i = head;
        if(!estaVacia())
            do{    
                String [] temp = ((SuperHeroe)(i.informacion)).getRaza().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(raza)))
                        Eliminar(((E)(i.informacion)));
                i = i.siguiente;        
            }while(i != head);
    }
    
    /** Metodo termiando para eliminar por sexo */
    
    public void EliminarConSexoTal(char sexo){
        Node i = head;
        if(!estaVacia())
            do{    
                if(((SuperHeroe)(i.informacion)).getSexo() == sexo)
                    Eliminar(((E)(i.informacion)));
                i = i.siguiente;
            }while(i != head);
    }
    
    /** Metodo termiando para eliminar por año / años de aparicion*/
    
    public void EliminarConAñoAparicionTal(int añoAparicion){
        Node i = head;
        if(!estaVacia())
            do{    
                for(int j = 0; j < ((SuperHeroe)(i.informacion)).getAñoAparicion().length; j++)
                    if(((SuperHeroe)(i.informacion)).getAñoAparicion()[j] == añoAparicion)
                         Eliminar(((E)(i.informacion)));
                i = i.siguiente;         
            }while(i != head);
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y poder tal*/
    public ListaCircular<E> ListaEliminandoConSexoYPoderTal(ListaCircular listaOriginal,char sexo, String poder){
        ListaCircular<E> lista = listaOriginal; //Clonamos la lista  
        lista.EliminarConSexoTal(sexo);
        lista.EliminarConPoderTal(poder);
        return lista; //Se retorna dicha lista clonada, ya con elementos eliminados
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y año tal*/
    public ListaCircular<E> ListaEliminandoConSexoYAñoAparicionTal(ListaCircular listaOriginal,char sexo, int añoAparicion){
        ListaCircular<E> lista = listaOriginal;
        lista.EliminarConSexoTal(sexo);
        lista.EliminarConAñoAparicionTal(añoAparicion);
        return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y autor tal*/
    public ListaCircular<E> ListaEliminandoConSexoYAutorTal(ListaCircular listaOriginal,char sexo, String autor){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConSexoTal(sexo);
         lista.EliminarConAutorTal(autor);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y origen tal*/
    public ListaCircular<E> ListaEliminandoConSexoYOrigenTal(ListaCircular listaOriginal,char sexo, String origen){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConSexoTal(sexo);
         lista.EliminarConOrigenTal(origen);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y comic tal*/
    public  ListaCircular<E> ListaEliminandoConSexoYComicTal(ListaCircular listaOriginal,char sexo, String comic){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConSexoTal(sexo);
         lista.EliminarConComicTal(comic);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y afiliacion tal*/
    public  ListaCircular<E> ListaEliminandoConSexoYAfiliacionTal(ListaCircular listaOriginal,char sexo, String afiliacion){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConSexoTal(sexo);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y raza tal*/
    public  ListaCircular<E> ListaEliminandoConSexoYRazaTal(ListaCircular listaOriginal,char sexo, String raza){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConSexoTal(sexo);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y año tal*/
    public ListaCircular<E> ListaEliminandoConPoderYAñoAparicionTal(ListaCircular listaOriginal,String poder, int añoAparicion){
        ListaCircular<E> lista = listaOriginal;
        lista.EliminarConPoderTal(poder);
        lista.EliminarConAñoAparicionTal(añoAparicion);
        return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y autor tal*/
    public ListaCircular<E> ListaEliminandoConPoderYAutorTal(ListaCircular listaOriginal,String poder, String autor){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConPoderTal(poder);
         lista.EliminarConAutorTal(autor);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y origen tal*/
    public ListaCircular<E> ListaElimiandoConPoderYOrigenTal(ListaCircular listaOriginal,String poder, String origen){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConPoderTal(poder);
         lista.EliminarConOrigenTal(origen);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y comic tal*/
    public  ListaCircular<E> ListaEliminandConPoderYComicTal(ListaCircular listaOriginal,String poder, String comic){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConPoderTal(poder);
         lista.EliminarConComicTal(comic);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y afiliacion tal*/
    public  ListaCircular<E> ListaEliminandoConPoderYAfiliacionTal(ListaCircular listaOriginal,String poder, String afiliacion){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConPoderTal(poder);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y raza tal*/
    public  ListaCircular<E> ListaEliminandoConPoderYRazaTal(ListaCircular listaOriginal,String poder, String raza){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConPoderTal(poder);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con año y autor tal*/
    public ListaCircular<E> ListaEliminandoConAñoAparicionYAutorTal(ListaCircular listaOriginal,int añoAparicion, String autor){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConAñoAparicionTal(añoAparicion);
         lista.EliminarConAutorTal(autor);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con año y origen tal*/
    public ListaCircular<E> ListaEliminandoConAñoAparicionYOrigenTal(ListaCircular listaOriginal,int añoAparicion, String origen){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConAñoAparicionTal(añoAparicion);
         lista.EliminarConOrigenTal(origen);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con año y comic tal*/
    public  ListaCircular<E> ListaEliminandoConAñoAparicionYComicTal(ListaCircular listaOriginal,int añoAparicion, String comic){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConAñoAparicionTal(añoAparicion);
         lista.EliminarConComicTal(comic);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con año y afiliacion tal*/
    public  ListaCircular<E> ListaEliminandoConAñoAparicionYAfiliacionTal(ListaCircular listaOriginal,int añoAparicion, String afiliacion){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConAñoAparicionTal(añoAparicion);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con año y raza tal*/
    public  ListaCircular<E> listaAñoAparicionYRazaTal(ListaCircular listaOriginal,int añoAparicion, String raza){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConAñoAparicionTal(añoAparicion);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con autor y origen tal*/
    public ListaCircular<E> listaAutorYOrigenTal(ListaCircular listaOriginal,String autor, String origen){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConAutorTal(autor);
         lista.EliminarConOrigenTal(origen);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con autor y comic tal*/
    public  ListaCircular<E> listaAutorYComicTal(ListaCircular listaOriginal,String autor, String comic){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConAutorTal(autor);
         lista.EliminarConComicTal(comic);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con autor y afiliacion tal*/
    public  ListaCircular<E> listaAutorYAfiliacionTal(ListaCircular listaOriginal,String autor, String afiliacion){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConAutorTal(autor);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con autor y raza tal*/
    public  ListaCircular<E> listaAutorYRazaTal(ListaCircular listaOriginal,String autor, String raza){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConAutorTal(autor);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con origen y comic tal*/
    public  ListaCircular<E> listaOrigenYComicTal(ListaCircular listaOriginal,String origen, String comic){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConOrigenTal(origen);
         lista.EliminarConComicTal(comic);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con origen y afiliacion tal*/
    public  ListaCircular<E> listaOrigenYAfiliacionTal(ListaCircular listaOriginal,String origen, String afiliacion){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConOrigenTal(origen);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con origen y raza tal*/
    public  ListaCircular<E> listaOrigenYRazaTal(ListaCircular listaOriginal,String origen, String raza){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConOrigenTal(origen);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con y afiliacion tal*/
    public  ListaCircular<E> listaComicYAfiliacionTal(ListaCircular listaOriginal,String comic, String afiliacion){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConComicTal(comic);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con y raza tal*/
    public  ListaCircular<E> listaComicYRazaTal(ListaCircular listaOriginal,String comic, String raza){
         ListaCircular<E> lista = listaOriginal;
         lista.EliminarConComicTal(comic);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con afiliacion y raza tal*/
    public ListaCircular<E> EliminarAfiliacionYRazaTal(ListaCircular listaOriginal,String afiliacion, String raza){
        ListaCircular<E> lista = new ListaCircular();
        lista.EliminarConAfiliacionTal(afiliacion); 
        lista.EliminarConRazaTal(raza);
        return lista;
    }
}

