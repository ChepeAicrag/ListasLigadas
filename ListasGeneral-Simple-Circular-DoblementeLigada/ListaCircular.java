
import java.text.Normalizer;
public class ListaCircular<E> implements Lista<E>{
    private Nodo head;
    private Nodo tail;
    
    public ListaCircular(){
        head = null;
    }
    
    public Nodo getCabeza(){
        return head;
    }
    
    public Nodo getFin(){
        return tail;
    }
    
    public E getInfoNodo(Nodo x){
        if(x != null)
            return (E)x.getInformacion();
        return null;    
    }
    
    public void LlenarListaDesdeArchivo(String nom)throws Exception{}
    
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
    
    public void insertarFinal(E dato){
      if(estaVacia())
         insertarInicio(dato); //Lo mismo que agregar al inicio
      else{
           Nodo x = new Nodo();
           x.setInformacion(dato);
           x.setSiguiente(head);
           tail.setSiguiente(x);
           tail = x;
        }
    }
    
    public void mostrarLista(){  
        Nodo temp = head;
        if(temp == null)
           StdOut.println("Lista vacia!!");
        else
            do{
                StdOut.println(temp.getInformacion());
                temp = temp.getSiguiente();
            }while(temp != head);
                   
    }
    
    public boolean estaVacia(){
        if(head == null)
            return true;
        return false;    
    }
    
    public Nodo buscar(E dato){
        Nodo buscado = null;
        Nodo iterador = head;
        if(dato != null){ // Si es diferente de null se busca, de lo contrario es null
           do{
              if ( iterador.getInformacion().equals(dato) ) 
                   buscado = iterador;
            iterador = iterador.getSiguiente();
          }while ( buscado == null && iterador != head );
        }
        return buscado;
    }
    
    public Nodo AntesDe(E x){
        Nodo temp = null;
        if(buscar(x) != null){ //Comprobar de lo que vamos a buscar existe
            if(head.getInformacion().equals(x)) //Caso especial de buscar antes de head, se retorna a tail
                return tail;
             else 
                for(Nodo i = head; i.getSiguiente() != head; i = i.getSiguiente())
                    if(i.getSiguiente().getInformacion().equals(x))
                        temp = i;
        }
        return temp; 
    }
    
    /** Si solo queremos el nodo que está despues*/
    public Nodo DespuesDe(E x){
        Nodo temp = null;
        if(buscar(x) != null){
              if(tail.getInformacion().equals(x)) //Caso especial si se busca depues de tail, entonces se retorna a head
                 return head;
              for(Nodo i = head; i.getSiguiente() != head; i = i.getSiguiente())
                  if(i.getInformacion().equals(x))
                     temp = i.getSiguiente();
        }
        return temp; 
    }
    //problema
    
    public void Eliminar(E x){
        if(buscar(x) == null)
            StdOut.println("No está en la lista, no se puede eliminar");
        else{
             if(x == head)
                eliminarInicio();
             if(x == tail)
                eliminarFinal();
              else{    
                  Nodo temp = AntesDe(x);
                  temp.setSiguiente ( temp.getSiguiente().getSiguiente());
                }
        }
    }
    
    public void eliminarInicio(){
        if(!estaVacia()){
            head = head.getSiguiente();
            tail.setSiguiente(tail.getSiguiente().getSiguiente());
        }
    }
    
    public void eliminarFinal(){
        if(!estaVacia()){
            Nodo temp = AntesDe((E)getFin().getInformacion());
            temp.setSiguiente(head);
        } 
    }
    
   /** Metodo termiando para buscar por alias */
    public ListaCircular<E> ListaAliasTal(String alias){
        ListaCircular<E> Lista = new ListaCircular();
        Nodo i = head;
        if(estaVacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{    
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAlias().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(alias)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
                i = i.getSiguiente();
            }while(i != head);
            
        return Lista;
    }
    
    /** Metodo termiando para buscar por nombre real */
    public ListaCircular<E> ListaNombreRealTal(String nombreReal){
        ListaCircular<E> Lista = new ListaCircular();
        Nodo i = head;
        if(estaVacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{    
                String [] temp = ((SuperHeroe)(i.getInformacion())).getNombreReal().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(nombreReal)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
        return Lista;
    }
    
    /** Metodo termiando para buscar por poder */
    public ListaCircular<E> ListaPoderTal(String poder){
        ListaCircular<E> Lista = new ListaCircular();
        Nodo i = head;
        if(estaVacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{    
                String [] temp = ((SuperHeroe)(i.getInformacion())).getPoder().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(poder)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
        return Lista;
    }
    
    /** Metodo termiando para buscar por autor*/
    public ListaCircular<E> ListaAutorTal(String autor){
        ListaCircular<E> Lista = new ListaCircular();
        Nodo i = head;
        if(estaVacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
         else
            do{ 
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAutor().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(autor)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
        return Lista;
    }
    
    /** Metodo termiando para buscar por origen*/
    public ListaCircular<E> ListaOrigenTal(String origen){
        ListaCircular<E> Lista = new ListaCircular();
        Nodo i = head;
        if(estaVacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{ 
                String [] temp = ((SuperHeroe)(i.getInformacion())).getOrigen().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(origen)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
        return Lista;
    }
    
    /** Metodo termiando para buscar por comic*/
    public ListaCircular<E> ListaComicTal(String comic){
        ListaCircular<E> Lista = new ListaCircular();
        Nodo i = head;
        if(estaVacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{ 
                String [] temp = ((SuperHeroe)(i.getInformacion())).getComic().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(comic)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
        return Lista;
    }
    
    /** Metodo termiando para buscar por afiliacion*/
    public ListaCircular<E> ListaAfiliacionTal(String afiliacion){
        ListaCircular<E> Lista = new ListaCircular();
        Nodo i = head;
        if(estaVacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{    
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAfiliacionActual().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(afiliacion)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
        return Lista;
    }
    
    /** Metodo termiando para buscar por raza*/
    public ListaCircular<E> ListaRazaTal(String raza){
        ListaCircular<E> Lista = new ListaCircular();
        Nodo i = head;
        if(estaVacia())
            StdOut.println("La lista está vacia, se regreso una vacia");
        else
            do{    
                String [] temp = ((SuperHeroe)(i.getInformacion())).getRaza().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(raza)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
                i = i.getSiguiente();        
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
    
    /** Metodo termiando para buscar por año / años de aparicion*/
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
        Nodo i = head;
        if(!estaVacia())
            do{    
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAlias().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(alias)))
                        Eliminar(((E)(i.getInformacion())));
                i = i.getSiguiente();
            }while(i != head);
    }
    
    /** Metodo termiando para eliminar por nombre real */
    public void EliminarConNombreRealTal(String nombreReal){
        Nodo i = head;
        if(!estaVacia())
            do{    
                String [] temp = ((SuperHeroe)(i.getInformacion())).getNombreReal().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(nombreReal)))
                        Eliminar(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
    }
    
    /** Metodo termiando para eliminar por poder */
    public void EliminarConPoderTal(String poder){
        Nodo i = head;
        if(!estaVacia())
            do{    
                String [] temp = ((SuperHeroe)(i.getInformacion())).getPoder().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(poder)))
                        Eliminar(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
    }
    
    
    /** Metodo termiando para eliminar por autor*/
    public void EliminarConAutorTal(String autor){
        Nodo i = head;
        if(!estaVacia())
            do{ 
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAutor().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(autor)))
                        Eliminar(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
    }
    
    /** Metodo termiando para eliminar por origen*/
    
    public void EliminarConOrigenTal(String origen){
        Nodo i = head;
        if(!estaVacia())
            do{ 
                String [] temp = ((SuperHeroe)(i.getInformacion())).getOrigen().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(origen)))
                        Eliminar(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
    }
    
    /** Metodo termiando para eliminar por comic*/
    
    public void EliminarConComicTal(String comic){
        Nodo i = head;
        if(!estaVacia())
            do{ 
                String [] temp = ((SuperHeroe)(i.getInformacion())).getComic().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(comic)))
                        Eliminar(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
    }
    
    /** Metodo termiando para eliminar por afiliacion*/
    
    public void EliminarConAfiliacionTal(String afiliacion){
        Nodo i = head;
        if(!estaVacia())
            do{    
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAfiliacionActual().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(afiliacion)))
                        Eliminar(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
    }
    
    /** Metodo termiando para eliminar por raza*/
    
    public void EliminarConRazaTal(String raza){
        Nodo i = head;
        if(!estaVacia())
            do{    
                String [] temp = ((SuperHeroe)(i.getInformacion())).getRaza().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(raza)))
                        Eliminar(((E)(i.getInformacion())));
                i = i.getSiguiente();        
            }while(i != head);
    }
    
    /** Metodo termiando para eliminar por sexo */
    
    public void EliminarConSexoTal(char sexo){
        Nodo i = head;
        if(!estaVacia())
            do{    
                if(((SuperHeroe)(i.getInformacion())).getSexo() == sexo)
                    Eliminar(((E)(i.getInformacion())));
                i = i.getSiguiente();
            }while(i != head);
    }
    
    /** Metodo termiando para eliminar por año / años de aparicion*/
    
    public void EliminarConAñoAparicionTal(int añoAparicion){
        Nodo i = head;
        if(!estaVacia())
            do{    
                for(int j = 0; j < ((SuperHeroe)(i.getInformacion())).getAñoAparicion().length; j++)
                    if(((SuperHeroe)(i.getInformacion())).getAñoAparicion()[j] == añoAparicion)
                         Eliminar(((E)(i.getInformacion())));
                i = i.getSiguiente();         
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