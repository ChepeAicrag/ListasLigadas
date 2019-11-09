
/**
 * Clase de una Lista Circular (LC)
   */

import java.text.Normalizer;
public class ListaCircular<E> implements Lista<E>{
    private Nodo head;
    private Nodo tail;
    
    /** Constructor que crea una LC vacia. */
    
    public ListaCircular(){
        head = null;
    }
    
    /** Método que retorna el primer nodo de la lista (cabeza) */
    
    public Nodo getCabeza(){
        return head;
    }
    
    /** Método que retorna el ultimo nodo de la lista (fin) */
    
    public Nodo getFin(){
        return tail;
    }
    
    /** Método que retorna información de un nodo */
    
    public E getInfoNodo(Nodo x){
        if(x != null)
            return (E)x.getInformacion();
        return null;    
    }
    
    public void LlenarListaDesdeArchivo(String nom)throws Exception{}
    
    /** Insertar un nuevo nodo al inicio de la Lista */
    
    public void insertarInicio(E dato){
      if(estaVacia()){
          head = new Nodo();
          head.setInformacion(dato);
          head.setSiguiente(head);
          tail = head;
       }else{
            Nodo x = new Nodo();
            x.setInformacion(dato);
            x.setSiguiente(head);
            tail.setSiguiente(x);
            head = x;
         }
    }
    
    /** Insertar un nuevo nodo al final de la Lista */
    
    public void insertarFinal(E dato){
      if(estaVacia())
         insertarInicio(dato);
      else{
           Nodo x = new Nodo();
           x.setInformacion(dato);
           x.setSiguiente(head);
           tail.setSiguiente(x);
           tail = x;
        }
    }
    
    /** Método que muestra la lista, comenzando en la cabeza */
    
    public void mostrarLista(){  
        Nodo temp = head;
        if(estaVacia())
           StdOut.println("Lista vacia!!");
        else{
            do{
                StdOut.println(temp.getInformacion());
                temp = temp.getSiguiente();
            }while(temp != head);
        }      
    }
    
    /** Indica si la Lista está vacia */
    
    public boolean estaVacia(){
        return head == null;   
    }
    
    /** Devuelve una referencia al nodo buscado, si no se encuentra devuelve null */
    
    public Nodo buscar(E dato){
        Nodo buscado = null;
        Nodo iterador = head;
        if(dato != null){ 
           do{
              if ( iterador.getInformacion().equals(dato) ) 
                   buscado = iterador;
            iterador = iterador.getSiguiente();
          }while ( buscado == null && iterador != head );
        }
        return buscado;
    }
    
    /** Devuelve el nodo que está antes del que estamos buscando */
    
    public Nodo AntesDe(E x){
        Nodo temp = null;
        if(buscar(x) != null){ 
            if(head.getInformacion().equals(x)) 
                return tail;
             else 
                for(Nodo i = head; i.getSiguiente() != head; i = i.getSiguiente())
                    if(i.getSiguiente().getInformacion().equals(x))
                        temp = i;
        }
        return temp; 
    }
    
    /** Devuelve el nodo que está despues del que estamos buscando */
    
    public Nodo DespuesDe(E x){
        Nodo temp = null;
        if(buscar(x) != null){
              if(tail.getInformacion().equals(x)) 
                 return head;
              for(Nodo i = head; i.getSiguiente() != head; i = i.getSiguiente())
                  if(i.getInformacion().equals(x))
                     temp = i.getSiguiente();
        }
        return temp; 
    }
    
    /** Elimina un nodo independientement del lugar en la lista */
    
    public void Eliminar(E x){
        if(buscar(x) == null)
            StdOut.println("No está en la lista, no se puede eliminar");
        else{
             if(buscar(x) == getCabeza()){
                eliminarInicio();
            }
             else if(buscar(x) == getFin()){
                eliminarFinal();
            }
              else{    
                  Nodo temp = AntesDe(x);
                  temp.setSiguiente ( temp.getSiguiente().getSiguiente());
                }
        }
    }
    
    /** Elimina el nodo del frente de la Lista */
    
    public void eliminarInicio(){
        if(!estaVacia()){
            head = head.getSiguiente();
            tail.setSiguiente(head);
        }
    }
    
    /** Elimina el nodo del final de la Lista */
    
    public void eliminarFinal(){
        if(!estaVacia()){
            Nodo temp = AntesDe((E)getFin().getInformacion());
            temp.setSiguiente(head);
        } 
    }
    
    /**
     * 
     * Metodos para buscar por cada atributo
     * 
       */
    
   /** Método para buscar por alias */
   
    public ListaCircular<E> ListaAliasTal(String alias){
        ListaCircular<E> Lista = new ListaCircular();
        Nodo i = head;
        if(estaVacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{    
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAlias().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(alias).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
                i = i.getSiguiente();
            }while(i != head);
        return Lista;
    }
    
    /** Método para buscar por nombre real */
    
    public ListaCircular<E> ListaNombreRealTal(String nombreReal){
        ListaCircular<E> Lista = new ListaCircular();
        Nodo i = head;
        if(estaVacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{    
                String [] temp = ((SuperHeroe)(i.getInformacion())).getNombreReal().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(nombreReal).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
        return Lista;
    }
    
    /** Método para buscar por poder */
    
    public ListaCircular<E> ListaPoderTal(String poder){
        ListaCircular<E> Lista = new ListaCircular();
        Nodo i = head;
        if(estaVacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{    
                String [] temp = ((SuperHeroe)(i.getInformacion())).getPoder().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(poder).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
        return Lista;
    }
    
    /** Método para buscar por autor */
    
    public ListaCircular<E> ListaAutorTal(String autor){
        ListaCircular<E> Lista = new ListaCircular();
        Nodo i = head;
        if(estaVacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
         else
            do{ 
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAutor().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(autor).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
        return Lista;
    }
    
    /** Método para buscar por origen */
    
    public ListaCircular<E> ListaOrigenTal(String origen){
        ListaCircular<E> Lista = new ListaCircular();
        Nodo i = head;
        if(estaVacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{ 
                String [] temp = ((SuperHeroe)(i.getInformacion())).getOrigen().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(origen).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
        return Lista;
    }
    
    /** Método para buscar por comic */
    
    public ListaCircular<E> ListaComicTal(String comic){
        ListaCircular<E> Lista = new ListaCircular();
        Nodo i = head;
        if(estaVacia())
            StdOut.println("La lista está vacia, se regreso una vacia"); //agregar esto a las demas clases
        else
            do{ 
                String [] temp = ((SuperHeroe)(i.getInformacion())).getComic().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(comic).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
        return Lista;
    }
    
    /** Método para buscar por afiliacion */
    
    public ListaCircular<E> ListaAfiliacionTal(String afiliacion){
        ListaCircular<E> Lista = new ListaCircular();
        Nodo i = head;
        if(estaVacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{    
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAfiliacionActual().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(afiliacion).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
        return Lista;
    }
    
    /** Método para buscar por raza */
    
    public ListaCircular<E> ListaRazaTal(String raza){
        ListaCircular<E> Lista = new ListaCircular();
        Nodo i = head;
        if(estaVacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{    
                String [] temp = ((SuperHeroe)(i.getInformacion())).getRaza().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(raza).trim()))
                        Lista.insertarInicio(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
        return Lista;
    }
    
    /** Metodo para qutar las tildes de un string, para hacer mas eficiente la busqueda */
    
    private static String cleanString(String info) {
        info = Normalizer.normalize(info, Normalizer.Form.NFD);
        info = info.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return info;
    }
    
    /** Método para buscar por sexo */
    
    public ListaCircular<E> ListaSexoTal(char sexo){
        ListaCircular<E> Lista = new ListaCircular();
        Nodo i = head;
        if(estaVacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{    
                if(((SuperHeroe)(i.getInformacion())).getSexo() == sexo)
                    Lista.insertarInicio(((E)(i.getInformacion())));
                i = i.getSiguiente();
            }while(i != head);
        return Lista;
    }
    
    /** Método para buscar por año / años de aparicion */
    
    public ListaCircular<E> ListaAñoAparicionTal(int añoAparicion){
        ListaCircular<E> Lista = new ListaCircular();
        Nodo i = head;
        if(estaVacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{    
                for(int j = 0; j < ((SuperHeroe)(i.getInformacion())).getAñoAparicion().length; j++)
                    if(((SuperHeroe)(i.getInformacion())).getAñoAparicion()[j] == añoAparicion)
                         Lista.insertarInicio(((E)(i.getInformacion())));
                i = i.getSiguiente();         
            }while(i != head);
        return Lista;
    }
    
    /**
     * 
     * Metodos combinados que generan una Lista, apartir de una lista (Filtrado)
     * 
     */
    
    
    /** Método para buscar por sexo y poder tal */
    
    public ListaCircular<E> ListaSexoYPoderTal(char sexo, String poder){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaSexoTal(sexo); //Te entrega una Lista de sexo tal 
            Lista.ListaPoderTal(poder);
        }else
            StdOut.println("Se retornara una lista vacia");
        return Lista; //Te regresa quienes tienen el poder, sobre esa misma Lista
    }
    
    /** Método para buscar por sexo y año tal */
    
    public ListaCircular<E> ListaSexoYAñoAparicionTal(char sexo, int añoAparicion){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaSexoTal(sexo);
            Lista.ListaAñoAparicionTal(añoAparicion);
        }else
            StdOut.println("Se retornara una lista vacia");
        return Lista;
    }
    
    /** Método para buscar por sexo y autor tal */
    
    public ListaCircular<E> ListaSexoYAutorTal(char sexo, String autor){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaSexoTal(sexo);
            Lista.ListaAutorTal(autor);
        }else
            StdOut.println("Se retornara una lista vacia");
        return Lista; 
    }
    
    /** Método para buscar por sexo y origen tal */
    
    public ListaCircular<E> ListaSexoYOrigenTal(char sexo, String origen){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaSexoTal(sexo);
            Lista.ListaOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia");
        return Lista;
    }
    
    /** Método para buscar por sexo y comic tal */
    
    public  ListaCircular<E> ListaSexoYComicTal(char sexo, String comic){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaSexoTal(sexo);
            Lista.ListaComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia");
        return Lista;
    }
    
    /** Método para buscar por sexo y afiliacion tal */
    
    public  ListaCircular<E> ListaSexoYAfiliacionTal(char sexo, String afiliacion){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaSexoTal(sexo);
            Lista.ListaAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia");    
        return Lista; 
    }
    
    /** Método para buscar por sexo y raza tal */
    
    public  ListaCircular<E> ListaSexoYRazaTal(char sexo, String raza){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaSexoTal(sexo);
            Lista.ListaRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia");     
        return Lista;
    }
    
    /** Método para buscar por poder y año tal */
        
    public ListaCircular<E> ListaPoderYAñoAparicionTal(String poder, int añoAparicion){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaPoderTal(poder);
            Lista.ListaAñoAparicionTal(añoAparicion);
        }else
            StdOut.println("Se retornara una lista vacia");     
        return Lista;
    }
    
    /** Método para buscar por poder y autor tal */
    
    public ListaCircular<E> ListaPoderYAutorTal(String poder, String autor){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaPoderTal(poder);
            Lista.ListaAutorTal(autor);
        }else
            StdOut.println("Se retornara una lista vacia");       
        return Lista;
    }
    
    /** Método para buscar por poder y origen tal */
    
    public ListaCircular<E> ListaPoderYOrigenTal(String poder, String origen){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaPoderTal(poder);
            Lista.ListaOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia");    
        return Lista;
    }
    
    /** Método para buscar por poder y comic tal */
    
    public  ListaCircular<E> ListaPoderYComicTal(String poder, String comic){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaPoderTal(poder);
            Lista.ListaComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;
    }
    
    /** Método para buscar por poder y afiliacion tal */
    
    public  ListaCircular<E> ListaPoderYAfiliacionTal(String poder, String afiliacion){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaPoderTal(poder);
            Lista.ListaAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;    
    }
    
    /** Método para buscar por poder y raza tal */
    
    public  ListaCircular<E> ListaPoderYRazaTal(String poder, String raza){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaPoderTal(poder);
            Lista.ListaRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;
    }
    
    /** Método para buscar por año y autor tal */
    
    public ListaCircular<E> ListaAñoAparicionYAutorTal(int añoAparicion, String autor){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaAñoAparicionTal(añoAparicion);
            Lista.ListaAutorTal(autor);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;
    }
    
    /** Método para buscar por año y origen tal */
    
    public ListaCircular<E> ListaAñoAparicionYOrigenTal(int añoAparicion, String origen){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaAñoAparicionTal(añoAparicion);
            Lista.ListaOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;
    }
    
    /** Método para buscar por año y comic tal*/
    public  ListaCircular<E> ListaAñoAparicionYComicTal(int añoAparicion, String comic){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaAñoAparicionTal(añoAparicion);
            Lista.ListaComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;    
    }
    
    /** Método para buscar por año y afiliacion tal */
    
    public  ListaCircular<E> ListaAñoAparicionYAfiliacionTal(int añoAparicion, String afiliacion){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaAñoAparicionTal(añoAparicion);
            Lista.ListaAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;    
    }
    
    /** Método para buscar por año y raza tal */
    
    public  ListaCircular<E> ListaAñoAparicionYRazaTal(int añoAparicion, String raza){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaAñoAparicionTal(añoAparicion);
            Lista.ListaRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;    
    }
    
    /** Método para buscar por autor y origen tal */
    
    public ListaCircular<E> ListaAutorYOrigenTal(String autor, String origen){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaAutorTal(autor);
            Lista.ListaOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;
    }
    
    /** Método para buscar por autor y comic tal */
    
    public  ListaCircular<E> ListaAutorYComicTal(String autor, String comic){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaAutorTal(autor);
            Lista.ListaComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;
    }
    
    /** Método para buscar por autor y afiliacion tal */
    
    public  ListaCircular<E> ListaAutorYAfiliacionTal(String autor, String afiliacion){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaAutorTal(autor);
            Lista.ListaAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;    
    }
    
    /** Método para buscar por autor y raza tal */
    
    public  ListaCircular<E> ListaAutorYRazaTal(String autor, String raza){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaAutorTal(autor);
            Lista.ListaRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;
    }
    
    /** Método para buscar por origen y comic tal */
    
    public  ListaCircular<E> ListaOrigenYComicTal(String origen, String comic){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaOrigenTal(origen);
            Lista.ListaComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;   
    }
    
    /** Método para buscar por origen y afiliacion tal */
    
    public  ListaCircular<E> ListaOrigenYAfiliacionTal(String origen, String afiliacion){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaOrigenTal(origen);
            Lista.ListaAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista; 
    }
    
    /** Método para buscar por origen y raza tal */
    
    public  ListaCircular<E> ListaOrigenYRazaTal(String origen, String raza){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaOrigenTal(origen);
            Lista.ListaRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;    
    }
    
    /** Método para buscar por comic y afiliacion tal */
    
    public  ListaCircular<E> ListaComicYAfiliacionTal(String comic, String afiliacion){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaComicTal(comic);
            Lista.ListaAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista; 
    }
    
    /** Método para buscar por comic y raza tal */
    
    public  ListaCircular<E> ListaComicYRazaTal(String comic, String raza){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaComicTal(comic);
            Lista.ListaRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista;    
    }
    
    /** Método para buscar por afiliacion y raza tal */
    
    public  ListaCircular<E> ListaAfiliacionYRazaTal(String afiliacion, String raza){
        ListaCircular<E> Lista = new ListaCircular();
        if(!estaVacia()){
            Lista = ListaAfiliacionTal(afiliacion);
            Lista.ListaRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return Lista; 
    }
    
    /**
     * 
     * Metodos para eliminar por cada atributo
     * 
       */
    
    /** Método para eliminar por alias */
    
    public void EliminarConAliasTal(String alias){
        Nodo i = head;
        if(!estaVacia())
            do{    
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAlias().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(alias)))
                        Eliminar(((E)(i.getInformacion())));
                i = i.getSiguiente();
            }while(i != head);
        else
            StdOut.println("La lista está vacia, no se puede eliminar");
    }
    
    /** Método para eliminar por nombre real */
    
    public void EliminarConNombreRealTal(String nombreReal){
        Nodo i = head;
        if(!estaVacia())
            do{    
                String [] temp = ((SuperHeroe)(i.getInformacion())).getNombreReal().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(nombreReal)))
                        Eliminar(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
        else
            StdOut.println("La lista está vacia, no se puede eliminar");    
    }
    
    /** Método para eliminar por poder */
    
    public void EliminarConPoderTal(String poder){
        Nodo i = head;
        if(!estaVacia())
            do{    
                String [] temp = ((SuperHeroe)(i.getInformacion())).getPoder().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(poder)))
                        Eliminar(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
        else
            StdOut.println("La lista está vacia, no se puede eliminar");    
    }
    
    
    /** Método para eliminar por autor */
    
    public void EliminarConAutorTal(String autor){
        Nodo i = head;
        if(!estaVacia())
            do{ 
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAutor().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(autor)))
                        Eliminar(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
        else
            StdOut.println("La lista está vacia, no se puede eliminar");    
    }
    
    /** Método para eliminar por origen */
    
    public void EliminarConOrigenTal(String origen){
        Nodo i = head;
        if(!estaVacia())
            do{ 
                String [] temp = ((SuperHeroe)(i.getInformacion())).getOrigen().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(origen)))
                        Eliminar(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
        else
            StdOut.println("La lista está vacia, no se puede eliminar");    
    }
    
    /** Método para eliminar por comic */
    
    public void EliminarConComicTal(String comic){
        Nodo i = head;
        if(!estaVacia())
            do{ 
                String [] temp = ((SuperHeroe)(i.getInformacion())).getComic().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(comic)))
                        Eliminar(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
        else
            StdOut.println("La lista está vacia, no se puede eliminar");    
    }
    
    /** Método para eliminar por afiliacion */
    
    public void EliminarConAfiliacionTal(String afiliacion){
        Nodo i = head;
        if(!estaVacia())
            do{    
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAfiliacionActual().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(afiliacion)))
                        Eliminar(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
        else
            StdOut.println("La lista está vacia, no se puede eliminar");    
    }
    
    /** Método para eliminar por raza */
    
    public void EliminarConRazaTal(String raza){
        Nodo i = head;
        if(!estaVacia())
            do{    
                String [] temp = ((SuperHeroe)(i.getInformacion())).getRaza().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).trim().equalsIgnoreCase(cleanString(raza)))
                        Eliminar(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
        else
            StdOut.println("La lista está vacia, no se puede eliminar");    
    }
    
    /** Método para eliminar por sexo */
    
    public void EliminarConSexoTal(char sexo){
        Nodo i = head;
        if(!estaVacia())
            do{    
                if(((SuperHeroe)(i.getInformacion())).getSexo() == sexo)
                    Eliminar(((E)(i.getInformacion())));
                i = i.getSiguiente();
            }while(i != head);
        else
            StdOut.println("La lista está vacia, no se puede eliminar");    
    }
    
    /** Método para eliminar por año / años de aparicion */
    
    public void EliminarConAñoAparicionTal(int añoAparicion){
        Nodo i = head;
        if(!estaVacia())
            do{    
                for(int j = 0; j < ((SuperHeroe)(i.getInformacion())).getAñoAparicion().length; j++)
                    if(((SuperHeroe)(i.getInformacion())).getAñoAparicion()[j] == añoAparicion)
                         Eliminar(((E)(i.getInformacion())));
                i = i.getSiguiente();         
            }while(i != head);
        else
            StdOut.println("La lista está vacia, no se puede eliminar");    
    }
    
    /**
     * 
     * Metodos para eliminar por dos diferentes atributos (Filtrado)
     * 
       */
    
    /** Método para obtener lista eliminando con sexo y poder tal */
    
    public ListaCircular<E> ListaEliminandoConSexoYPoderTal(Lista <E> listaOriginal,char sexo, String poder){
        ListaCircular<E> lista = new ListaCircular(); 
        if(!listaOriginal.estaVacia()){
           lista = (ListaCircular<E>) listaOriginal;
           StdOut.printf("Eliminando con sexo \" %c \" y poder \" %s \" \n",sexo,poder);
           lista.EliminarConSexoTal(sexo);
           lista.EliminarConPoderTal(poder);
        }else
            StdOut.println("Se retornara una lista vacia");
        return lista; 
    }
    
    /** Método para obtener lista eliminando con sexo y año tal */
    
    public ListaCircular<E> ListaEliminandoConSexoYAñoAparicionTal(Lista <E>  listaOriginal,char sexo, int añoAparicion){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con sexo \" %c \" y año de aparición \" %d \" \n",sexo,añoAparicion);
            lista.EliminarConSexoTal(sexo);
            lista.EliminarConAñoAparicionTal(añoAparicion);
        }else
            StdOut.println("Se retornara una lista vacia");
        return lista;
    }
    
    /** Método para obtener lista eliminando con sexo y autor tal */
    
    public ListaCircular<E> ListaEliminandoConSexoYAutorTal(Lista <E>  listaOriginal,char sexo, String autor){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con sexo \" %c \" y autor \" %s \" \n",sexo,autor);
            lista.EliminarConSexoTal(sexo);
            lista.EliminarConAutorTal(autor);
        }else
            StdOut.println("Se retornara una lista vacia");
        return lista;
    }
    
    /** Método para obtener lista eliminando con sexo y origen tal */
    
    public ListaCircular<E> ListaEliminandoConSexoYOrigenTal(Lista <E>  listaOriginal,char sexo, String origen){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con sexo \" %c \" y origen \" %s \" \n",sexo,origen);
            lista.EliminarConSexoTal(sexo);
            lista.EliminarConOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia");
        return lista;
    }
    
    /** Método para obtener lista eliminando con sexo y comic tal */
    
    public  ListaCircular<E> ListaEliminandoConSexoYComicTal(Lista <E>  listaOriginal,char sexo, String comic){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con sexo \" %c \" y comic \" %s \" \n",sexo,comic);
            lista.EliminarConSexoTal(sexo);
            lista.EliminarConComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia");    
        return lista;
    }
    
    /** Método para obtener lista eliminando con sexo y afiliacion tal */
    
    public  ListaCircular<E> ListaEliminandoConSexoYAfiliacionTal(Lista <E>  listaOriginal,char sexo, String afiliacion){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con sexo \" %c \" y afiliación \" %s \" \n",sexo,afiliacion);
            lista.EliminarConSexoTal(sexo);
            lista.EliminarConAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return lista;
    }
    
    /** Método para obtener lista eliminando con sexo y raza tal */
    
    public  ListaCircular<E> ListaEliminandoConSexoYRazaTal(Lista <E>  listaOriginal,char sexo, String raza){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con sexo \" %c \" y raza \" %s \" \n",sexo,raza);
            lista.EliminarConSexoTal(sexo);
            lista.EliminarConRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return lista;
    }
    
    /** Método para obtener lista eliminando con poder y año tal */
    
    public ListaCircular<E> ListaEliminandoConPoderYAñoAparicionTal(Lista <E>  listaOriginal,String poder, int añoAparicion){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con poder \" %s \" y año de aparición \" %d \" \n",poder,añoAparicion);
            lista.EliminarConPoderTal(poder);
            lista.EliminarConAñoAparicionTal(añoAparicion);
        }else
            StdOut.println("Se retornara una lista vacia"); 
        return lista;
    }
    
    /** Método para obtener lista eliminando con poder y autor tal */
    
    public ListaCircular<E> ListaEliminandoConPoderYAutorTal(Lista <E>  listaOriginal,String poder, String autor){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con poder \" %s \" y autor \" %s \" \n",poder,autor);
            lista.EliminarConPoderTal(poder);
            lista.EliminarConAutorTal(autor);
        }else
            StdOut.println("Se retornara una lista vacia");
         return lista;
    }
    
    /** Método para obtener lista eliminando con poder y origen tal */
    
    public ListaCircular<E> ListaEliminandoConPoderYOrigenTal(Lista <E>  listaOriginal,String poder, String origen){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con poder \" %s \" y origen \" %s \" \n",poder,origen);
            lista.EliminarConPoderTal(poder);
            lista.EliminarConOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia");
         return lista;
    }
    
    /** Método para obtener lista eliminando con poder y comic tal */
    
    public  ListaCircular<E> ListaEliminandoConPoderYComicTal(Lista <E>  listaOriginal,String poder, String comic){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con poder \" %s \" y comic \" %s \" \n",poder,comic);
            lista.EliminarConPoderTal(poder);
            lista.EliminarConComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia");
         return lista;
    }
    
    /** Método para obtener lista eliminando con poder y afiliacion tal */
    
    public  ListaCircular<E> ListaEliminandoConPoderYAfiliacionTal(Lista <E>  listaOriginal,String poder, String afiliacion){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con poder \" %s \" y afiliacion \" %s \" \n",poder,afiliacion);
            lista.EliminarConPoderTal(poder);
            lista.EliminarConAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia");
         return lista;
    }
    
    /** Método para obtener lista eliminando con poder y raza tal */
    
    public  ListaCircular<E> ListaEliminandoConPoderYRazaTal(Lista <E>  listaOriginal,String poder, String raza){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con poder \" %s \" y raza \" %s \" \n",poder,raza);
            lista.EliminarConPoderTal(poder);
            lista.EliminarConRazaTal(raza);
         }else
            StdOut.println("Se retornara una lista vacia");   
         return lista;
    }
    
    /** Método para obtener lista eliminando con año y autor tal */
    
    public ListaCircular<E> ListaEliminandoConAñoAparicionYAutorTal(Lista <E>  listaOriginal,int añoAparicion, String autor){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con año aparicion \" %d \" y autor \" %s \" \n",añoAparicion,autor);
            lista.EliminarConAñoAparicionTal(añoAparicion);
            lista.EliminarConAutorTal(autor);
         }else
            StdOut.println("Se retornara una lista vacia");   
         return lista;
    }
    
    /** Método para obtener lista eliminando con año y origen tal */
    
    public ListaCircular<E> ListaEliminandoConAñoAparicionYOrigenTal(Lista <E>  listaOriginal,int añoAparicion, String origen){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con año aparicion \" %d \" y origen \" %s \" \n",añoAparicion,origen);
            lista.EliminarConAñoAparicionTal(añoAparicion);
            lista.EliminarConOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia");   
         return lista;
    }
    
    /** Método para obtener lista eliminando con año y comic tal */
    
    public  ListaCircular<E> ListaEliminandoConAñoAparicionYComicTal(Lista <E>  listaOriginal,int añoAparicion, String comic){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con año aparicion \" %d \" y comic \" %s \" \n",añoAparicion,comic);
            lista.EliminarConAñoAparicionTal(añoAparicion);
            lista.EliminarConComicTal(comic);
         }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con año y afiliacion tal */
    
    public  ListaCircular<E> ListaEliminandoConAñoAparicionYAfiliacionTal(Lista <E>  listaOriginal,int añoAparicion, String afiliacion){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con año aparicion \" %d \" y afiliacion \" %s \" \n",añoAparicion,afiliacion);
            lista.EliminarConAñoAparicionTal(añoAparicion);
            lista.EliminarConAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con año y raza tal */
    
    public  ListaCircular<E> ListaEliminandoConAñoAparicionYRazaTal(Lista <E>  listaOriginal,int añoAparicion, String raza){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con año aparicion \" %d \" y raza \" %s \" \n",añoAparicion,raza);
            lista.EliminarConAñoAparicionTal(añoAparicion);
            lista.EliminarConRazaTal(raza);
         }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con autor y origen tal */
    
    public ListaCircular<E> ListaEliminandoConAutorYOrigenTal(Lista <E>  listaOriginal,String autor, String origen){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con autor \" %s \" y origen \" %s \" \n",autor,origen);
            lista.EliminarConAutorTal(autor);
            lista.EliminarConOrigenTal(origen);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con autor y comic tal */
    
    public  ListaCircular<E> ListaEliminandoConAutorYComicTal(Lista <E>  listaOriginal,String autor, String comic){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con autor \" %s \" y comic \" %s \" \n",autor,comic);
            lista.EliminarConAutorTal(autor);
            lista.EliminarConComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con autor y afiliacion tal */
    
    public  ListaCircular<E> ListaEliminandoConAutorYAfiliacionTal(Lista <E>  listaOriginal,String autor, String afiliacion){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con autor \" %s \" y afiliacion \" %s \" \n",autor,afiliacion);
            lista.EliminarConAutorTal(autor);
            lista.EliminarConAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con autor y raza tal */
    
    public  ListaCircular<E> ListaEliminandoConAutorYRazaTal(Lista <E>  listaOriginal,String autor, String raza){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con autor \" %s \" y raza \" %s \" \n",autor,raza);
            lista.EliminarConAutorTal(autor);
            lista.EliminarConRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con origen y comic tal */
    
    public  ListaCircular<E> ListaEliminandoConOrigenYComicTal(Lista <E>  listaOriginal,String origen, String comic){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con origen \" %s \" y comic \" %s \" \n",origen,comic);
            lista.EliminarConOrigenTal(origen);
            lista.EliminarConComicTal(comic);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con origen y afiliacion tal */
    
    public  ListaCircular<E> ListaEliminandoConOrigenYAfiliacionTal(Lista <E>  listaOriginal,String origen, String afiliacion){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con origne \" %s \" y afiliacion \" %s \" \n",origen,afiliacion);
            lista.EliminarConOrigenTal(origen);
            lista.EliminarConAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con origen y raza tal */
    
    public  ListaCircular<E> ListaEliminandoConOrigenYRazaTal(Lista <E>  listaOriginal,String origen, String raza){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con origen \" %s \" y raza \" %s \" \n",origen,raza);
            lista.EliminarConOrigenTal(origen);
            lista.EliminarConRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con y afiliacion tal */
    
    public  ListaCircular<E> ListaEliminandoConComicYAfiliacionTal(Lista <E>  listaOriginal,String comic, String afiliacion){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con comic \" %s \" y afiliación \" %s \" \n",comic,afiliacion);
            lista.EliminarConComicTal(comic);
            lista.EliminarConAfiliacionTal(afiliacion);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con y raza tal */
    
    public  ListaCircular<E> ListaEliminandoConComicYRazaTal(Lista <E>  listaOriginal,String comic, String raza){
        ListaCircular<E> lista = new ListaCircular();
        if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con comic \" %s \" y raza \" %s \" \n",comic,raza);
            lista.EliminarConComicTal(comic);
            lista.EliminarConRazaTal(raza);
        }else
            StdOut.println("Se retornara una lista vacia");   
        return lista;
    }
    
    /** Método para obtener lista eliminando con afiliacion y raza tal */
    
    public ListaCircular<E> ListaEliminandoConAfiliacionYRazaTal(Lista <E>  listaOriginal,String afiliacion, String raza){
       ListaCircular<E> lista = new ListaCircular();
       if(!listaOriginal.estaVacia()){
            lista = (ListaCircular<E>) listaOriginal;
            StdOut.printf("Eliminando con afiliación \" %s \" y raza \" %s \" \n",afiliacion,raza);
            lista.EliminarConAfiliacionTal(afiliacion); 
            lista.EliminarConRazaTal(raza);
       }else
            StdOut.println("Se retornara una lista vacia");   
       return lista;
    }
}