import java.util.*;
import java.text.Normalizer;
import java.io.*;

public class LinkedListPlusRecursividadGenerico<E> implements Lista<E>{
    
    private Nodo raiz;
    
    public void LlenarListaDesdeArchivo(String nom) throws Exception{
        ObjectInputStream flujoObjetoEntrada = null;
        FileInputStream flujoArchivoEntrada = null;
        try{
            File archivoSalida = new File(nom+".txt");     
            flujoArchivoEntrada = new FileInputStream(archivoSalida);
            flujoObjetoEntrada = new ObjectInputStream(flujoArchivoEntrada);
            Object per = flujoObjetoEntrada.readObject();  
            System.out.println("Rellenando la Lista Simple...");
           while(per != null){
             insertarInicio((E)per);
             per = flujoObjetoEntrada.readObject();
           }    
       }catch(IOException error){
            System.out.println("******** Lista Rellenada *******"); 
     }finally{
             flujoArchivoEntrada.close();
             flujoObjetoEntrada.close();
      }  
   }
    
    public E getInfoNodo(Nodo temp){ 
        if(temp != null)
            return (E)temp.getInformacion();
        return null;
    }
    
    public Nodo getCabeza(){
        return raiz;
    }
    
    public boolean estaVacia(){
        if(raiz == null)
            return true;
        return false;    
    }
    
    /** Si solo queremos el nodo que está antes*/
    public Nodo AntesDe(E x){
        Nodo temp = null;
        if(x == null) //Si mandan un null devuelve al ultimo porque el apunta a null
            return getFin();
        if(buscar(x) != null) //Comprobar de lo que vamos a buscar existe
            if(raiz.getInformacion().equals(x)) //Caso especial de buscar antes de raiz
                return raiz;
             else 
                for(Nodo i = raiz; i.getSiguiente() != null; i = i.getSiguiente())
                    if(i.getSiguiente().getInformacion().equals(x))
                        temp = i;
        return temp; 
    }
    
    /** Si queremos la informacion de lo que está antes*/
    public E AntesDeInfo(E x){
        if(AntesDe(x) == null) //Si existe o no en la Lista
            return (E) "No está en la Lista";
        if( x == raiz.getInformacion()) //Debemos comprobar que si es raiz, antes no hay nadie, como es un apuntador, se evalua así, no requiere de casting    
            return  (E) "Nadie, eres el primero!!";
        return getInfoNodo(AntesDe(x));    
    }
    
    /** Si solo queremos el nodo que está despues*/
    public Nodo DespuesDe(E x){
        Nodo temp = null;
        if(buscar(x) != null)
              for(Nodo i = raiz; i != null; i = i.getSiguiente())
                  if(i.getInformacion().equals(x))
                     temp = i.getSiguiente();
        return temp; 
    }
    
    /** Si queremos la informacion del nodo que está despues */
    public E DespuesDeInfo(E x){
            if(!estaVacia())
               if(((SuperHeroe)getFin().getInformacion()).equals(x)) //Busco de que existe en la Lista y de que despues de él solo hay null
                   return (E) "Nadie eres el ultimo!!";        // Como no hay referencia, se tiene que comparar como objeto, por ello el casting
            if(DespuesDe(x) == null && buscar(x) == null) //Si no se encuentra y es null, entonces no está en la Lista
                 return (E) "No está en la Lista";
        return getInfoNodo(DespuesDe(x));   
    }
    
    public Nodo buscar(E x){
       if(x != null) // Si es diferente de null se busca, de lo contrario es false
         for(Nodo i = raiz; i != null; i = i.getSiguiente())
            if(i.getInformacion().equals(x))
                return i;
        return null; 
    }
    
    
    public Nodo getFin(){
        Nodo temp = null;
        for(Nodo i = raiz; i != null; i = i.getSiguiente())
            if(i.getSiguiente() == null)
            temp = i;
        return temp;    
    }
    
    public void Eliminar(E x){
        if(buscar(x) == null)
            StdOut.println("No está en la Lista");
        else{
            if(buscar(x) == raiz)
                eliminarInicio();
            if(buscar(x) == getFin())
                eliminarFinal();
             else{
                 Nodo temp = AntesDe(x); 
                 if(temp!=null)
                 temp.setSiguiente(temp.getSiguiente().getSiguiente());
          }
        }
    }
    
    public void eliminarFinal(){
        if(!estaVacia()){
        Nodo temp = AntesDe((E)getFin().getInformacion());
        temp.setSiguiente(temp.getSiguiente().getSiguiente());
      }
   }
    
    public void eliminarInicio(){
        if(!estaVacia()){
         raiz = DespuesDe((E)raiz.getInformacion());
        }
    }
    
    public void insertarInicio(E x) {
        Nodo nuevo = new Nodo ();
        nuevo.setInformacion(x);
        nuevo.setSiguiente(raiz);
        raiz       = nuevo;
    }
    
    public void insertarFinal(E x){
        Nodo nuevo = new Nodo();
        nuevo.setInformacion(x);
        nuevo.setSiguiente(null);
        getFin().setSiguiente(nuevo);
    }
    
    public String imprimirInversa(Nodo reco) {
        if (reco != null)
            return imprimirInversa(reco.getSiguiente()) + " " + reco.getInformacion();
        return "";    
    }
     
    public String imprimirNormal(Nodo reco) {
        if (reco != null)
            return  reco.getInformacion() + " " + imprimirNormal(reco.getSiguiente());
        return "";    
    }
    
    public void imprimirInversa () {
        if(raiz != null)
        StdOut.println(imprimirInversa(raiz));
        else
        StdOut.println("\t***** Lista Vacia *****");
    }
    
    public void mostrarLista(){
        if(raiz != null)
        StdOut.println(imprimirNormal(raiz));
        else
        StdOut.println("\t***** Lista Vacia *****");
    }

   /** Metodo termiando para buscar por alias */
    public LinkedListPlusRecursividadGenerico<E> ListaAliasTal(String alias){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAlias().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(alias)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por nombre real */
    public LinkedListPlusRecursividadGenerico<E> ListaNombreRealTal(String nombreReal){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getNombreReal().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(nombreReal)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por poder */
    public LinkedListPlusRecursividadGenerico<E> ListaPoderTal(String poder){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getPoder().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(poder)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por autor*/
    public LinkedListPlusRecursividadGenerico<E> ListaAutorTal(String autor){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAutor().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(autor)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por origen*/
    public LinkedListPlusRecursividadGenerico<E> ListaOrigenTal(String origen){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getOrigen().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(origen)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por comic*/
    public LinkedListPlusRecursividadGenerico<E> ListaComicTal(String comic){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getComic().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(comic)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por afiliacion*/
    public LinkedListPlusRecursividadGenerico<E> ListaAfiliacionTal(String afiliacion){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAfiliacionActual().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(afiliacion)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por raza */
    public LinkedListPlusRecursividadGenerico<E> ListaRazaTal(String raza){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getRaza().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(raza)))
                        Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Metodo para qutar las tildes de un string, para hacer mas eficiente la busqueda */
    private static String cleanString(String info) {
        info = Normalizer.normalize(info, Normalizer.Form.NFD);
        info = info.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return info;
    }
    
    /** Metodo termiando para buscar por sexo */
    public LinkedListPlusRecursividadGenerico<E> ListaSexoTal(char sexo){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                if(((SuperHeroe)(i.getInformacion())).getSexo() == sexo)
                    Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    /** Metodo termiando para buscar por año / años de aparicion*/
    public LinkedListPlusRecursividadGenerico<E> ListaAñoAparicionTal(int añoAparicion){
        LinkedListPlusRecursividadGenerico<E> Lista = new LinkedListPlusRecursividadGenerico();
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                for(int j = 0; j < ((SuperHeroe)(i.getInformacion())).getAñoAparicion().length; j++)
                    if(((SuperHeroe)(i.getInformacion())).getAñoAparicion()[j] == añoAparicion)
                         Lista.insertarInicio(((E)(i.getInformacion())));
            }
        return Lista;
    }
    
    
    /**
     * Metodos combiandos que generan Lista, apartir de Listas (Filtrado)
     * 
     */
    
    
    /** Metodo terminado para buscar por sexo y poder tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaSexoYPoderTal(char sexo, String poder){
        LinkedListPlusRecursividadGenerico<E> Lista = ListaSexoTal(sexo); //Te entrega una Lista de sexo tal 
        return Lista.ListaPoderTal(poder); //Te regresa quienes tienen el poder, sobre esa misma Lista
    }
    
    /** Metodo terminado para buscar por sexo y año tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaSexoYAñoAparicionTal(char sexo, int añoAparicion){
        LinkedListPlusRecursividadGenerico<E> Lista = ListaSexoTal(sexo);
        return Lista.ListaAñoAparicionTal(añoAparicion);
    }
    
    /** Metodo terminado para buscar por sexo y autor tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaSexoYAutorTal(char sexo, String autor){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaSexoTal(sexo);
         return Lista.ListaAutorTal(autor);
    }
    
    /** Metodo terminado para buscar por sexo y origen tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaSexoYOrigenTal(char sexo, String origen){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaSexoTal(sexo);
         return Lista.ListaOrigenTal(origen);
    }
    
    /** Metodo terminado para buscar por sexo y comic tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaSexoYComicTal(char sexo, String comic){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaSexoTal(sexo);
         return Lista.ListaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por sexo y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaSexoYAfiliacionTal(char sexo, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaSexoTal(sexo);
         return Lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por sexo y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaSexoYRazaTal(char sexo, String raza){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaSexoTal(sexo);
         return Lista.ListaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por poder y año tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaPoderYAñoAparicionTal(String poder, int añoAparicion){
        LinkedListPlusRecursividadGenerico<E> Lista = ListaPoderTal(poder);
        return Lista.ListaAñoAparicionTal(añoAparicion);
    }
    
    /** Metodo terminado para buscar por poder y autor tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaPoderYAutorTal(String poder, String autor){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaPoderTal(poder);
         return Lista.ListaAutorTal(autor);
    }
    
    /** Metodo terminado para buscar por poder y origen tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaPoderYOrigenTal(String poder, String origen){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaPoderTal(poder);
         return Lista.ListaOrigenTal(origen);
    }
    
    /** Metodo terminado para buscar por poder y comic tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaPoderYComicTal(String poder, String comic){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaPoderTal(poder);
         return Lista.ListaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por poder y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaPoderYAfiliacionTal(String poder, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaPoderTal(poder);
         return Lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por poder y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaPoderYRazaTal(String poder, String raza){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaPoderTal(poder);
         return Lista.ListaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por año y autor tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaAñoAparicionYAutorTal(int añoAparicion, String autor){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaAñoAparicionTal(añoAparicion);
         return Lista.ListaAutorTal(autor);
    }
    
    /** Metodo terminado para buscar por año y origen tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaAñoAparicionYOrigenTal(int añoAparicion, String origen){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaAñoAparicionTal(añoAparicion);
         return Lista.ListaOrigenTal(origen);
    }
    
    /** Metodo terminado para buscar por año y comic tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaAñoAparicionYComicTal(int añoAparicion, String comic){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaAñoAparicionTal(añoAparicion);
         return Lista.ListaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por año y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaAñoAparicionYAfiliacionTal(int añoAparicion, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaAñoAparicionTal(añoAparicion);
         return Lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por año y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaAñoAparicionYRazaTal(int añoAparicion, String raza){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaAñoAparicionTal(añoAparicion);
         return Lista.ListaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por autor y origen tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaAutorYOrigenTal(String autor, String origen){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaAutorTal(autor);
         return Lista.ListaOrigenTal(origen);
    }
    
    /** Metodo terminado para buscar por autor y comic tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaAutorYComicTal(String autor, String comic){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaAutorTal(autor);
         return Lista.ListaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por autor y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaAutorYAfiliacionTal(String autor, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaAutorTal(autor);
         return Lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por autor y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaAutorYRazaTal(String autor, String raza){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaAutorTal(autor);
         return Lista.ListaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por origen y comic tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaOrigenYComicTal(String origen, String comic){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaOrigenTal(origen);
         return Lista.ListaComicTal(comic);
    }
    
    /** Metodo terminado para buscar por origen y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaOrigenYAfiliacionTal(String origen, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaOrigenTal(origen);
         return Lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por origen y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaOrigenYRazaTal(String origen, String raza){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaOrigenTal(origen);
         return Lista.ListaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por comic y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaComicYAfiliacionTal(String comic, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaComicTal(comic);
         return Lista.ListaAfiliacionTal(afiliacion);
    }
    
    /** Metodo terminado para buscar por comic y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaComicYRazaTal(String comic, String raza){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaComicTal(comic);
         return Lista.ListaRazaTal(raza);
    }
    
    /** Metodo terminado para buscar por afiliacion y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaAfiliacionYRazaTal(String afiliacion, String raza){
         LinkedListPlusRecursividadGenerico<E> Lista = ListaAfiliacionTal(afiliacion);
         return Lista.ListaRazaTal(raza);
    }
    
        //# AQUI VAMOS A MODIFICAR AGREGNDO METODOS ELIMINAR
    
    /** Eliminar de la lista por Alias*/
    public void EliminarConAliasTal(String alias){
      for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAlias().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(alias)))
                        Eliminar(((E)(i.getInformacion())));
            }
    }
    
    /** Eliminar de la lista con nombre tal*/
    public void EliminarConNombreRealTal(String nombreReal){
      for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getNombreReal().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(nombreReal)))
                        Eliminar(((E)(i.getInformacion())));
            }
    }
    
    /** Eliminar de la lista con poder tal*/
    public void EliminarConPoderTal(String poder){
      for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getPoder().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(poder)))
                        Eliminar(((E)(i.getInformacion())));
            }
    }  
    
    /** Eliminar de la lista con autor tal*/
    public void EliminarConAutorTal(String autor){
       for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAutor().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(autor)))
                        Eliminar(((E)(i.getInformacion())));
            }
    }
    
    public void EliminarConOrigenTal(String origen){
       for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getOrigen().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(origen)))
                        Eliminar(((E)(i.getInformacion())));
            } 
    }
    
    public void EliminarConComicTal(String comic){
        for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getComic().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(comic)))
                        Eliminar(((E)(i.getInformacion())));
            }
    }
    
    public void EliminarConAfiliacionTal(String afiliacion){
        for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getAfiliacionActual().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(afiliacion)))
                        Eliminar(((E)(i.getInformacion())));
            }
    }
    
    public void EliminarConRazaTal(String raza){
        for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                String [] temp = ((SuperHeroe)(i.getInformacion())).getRaza().split(","); 
                for(int j = 0; j < temp.length; j++)
                    if(cleanString(temp[j]).equalsIgnoreCase(cleanString(raza)))
                        Eliminar(((E)(i.getInformacion())));
            }
    }
    
    /** Eliminar de la lista con sexo tal*/
    public void EliminarConSexoTal(char sexo){
            for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                    if(((SuperHeroe)(i.getInformacion())).getSexo() == sexo)
                        Eliminar(((E)(i.getInformacion())));
            }
    }
    
    public void EliminarConAñoAparicionTal(int añoAparicion){
        for(Nodo i = raiz; i != null; i = i.getSiguiente()){
                for(int j = 0; j < ((SuperHeroe)(i.getInformacion())).getAñoAparicion().length; j++)
                    if(((SuperHeroe)(i.getInformacion())).getAñoAparicion()[j] == añoAparicion)
                         Eliminar(((E)(i.getInformacion())));
            }
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y poder tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConSexoYPoderTal(Lista <E>  listaOriginal,char sexo, String poder){
        LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal; //Clonamos la lista  
        lista.EliminarConSexoTal(sexo);
        lista.EliminarConPoderTal(poder);
        return lista; //Se retorna dicha lista clonada, ya con elementos eliminados
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y año tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConSexoYAñoAparicionTal(Lista <E>  listaOriginal,char sexo, int añoAparicion){
        LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
        lista.EliminarConSexoTal(sexo);
        lista.EliminarConAñoAparicionTal(añoAparicion);
        return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y autor tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConSexoYAutorTal(Lista <E>  listaOriginal,char sexo, String autor){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConSexoTal(sexo);
         lista.EliminarConAutorTal(autor);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y origen tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConSexoYOrigenTal(Lista <E>  listaOriginal,char sexo, String origen){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConSexoTal(sexo);
         lista.EliminarConOrigenTal(origen);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y comic tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConSexoYComicTal(Lista <E>  listaOriginal,char sexo, String comic){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConSexoTal(sexo);
         lista.EliminarConComicTal(comic);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConSexoYAfiliacionTal(Lista <E>  listaOriginal,char sexo, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConSexoTal(sexo);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con sexo y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConSexoYRazaTal(Lista <E>  listaOriginal,char sexo, String raza){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConSexoTal(sexo);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y año tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConPoderYAñoAparicionTal(Lista <E>  listaOriginal,String poder, int añoAparicion){
        LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
        lista.EliminarConPoderTal(poder);
        lista.EliminarConAñoAparicionTal(añoAparicion);
        return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y autor tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConPoderYAutorTal(Lista <E>  listaOriginal,String poder, String autor){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConPoderTal(poder);
         lista.EliminarConAutorTal(autor);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y origen tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConPoderYOrigenTal(Lista <E>  listaOriginal,String poder, String origen){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConPoderTal(poder);
         lista.EliminarConOrigenTal(origen);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y comic tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConPoderYComicTal(Lista <E>  listaOriginal,String poder, String comic){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConPoderTal(poder);
         lista.EliminarConComicTal(comic);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConPoderYAfiliacionTal(Lista <E>  listaOriginal,String poder, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConPoderTal(poder);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con poder y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConPoderYRazaTal(Lista <E>  listaOriginal,String poder, String raza){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConPoderTal(poder);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con año y autor tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAñoAparicionYAutorTal(Lista <E>  listaOriginal,int añoAparicion, String autor){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConAñoAparicionTal(añoAparicion);
         lista.EliminarConAutorTal(autor);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con año y origen tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAñoAparicionYOrigenTal(Lista <E>  listaOriginal,int añoAparicion, String origen){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConAñoAparicionTal(añoAparicion);
         lista.EliminarConOrigenTal(origen);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con año y comic tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAñoAparicionYComicTal(Lista <E>  listaOriginal,int añoAparicion, String comic){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConAñoAparicionTal(añoAparicion);
         lista.EliminarConComicTal(comic);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con año y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAñoAparicionYAfiliacionTal(Lista <E>  listaOriginal,int añoAparicion, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConAñoAparicionTal(añoAparicion);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con año y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAñoAparicionYRazaTal(Lista <E>  listaOriginal,int añoAparicion, String raza){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConAñoAparicionTal(añoAparicion);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con autor y origen tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAutorYOrigenTal(Lista <E>  listaOriginal,String autor, String origen){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConAutorTal(autor);
         lista.EliminarConOrigenTal(origen);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con autor y comic tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAutorYComicTal(Lista <E>  listaOriginal,String autor, String comic){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConAutorTal(autor);
         lista.EliminarConComicTal(comic);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con autor y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAutorYAfiliacionTal(Lista <E>  listaOriginal,String autor, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConAutorTal(autor);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con autor y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAutorYRazaTal(Lista <E>  listaOriginal,String autor, String raza){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConAutorTal(autor);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con origen y comic tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConOrigenYComicTal(Lista <E>  listaOriginal,String origen, String comic){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConOrigenTal(origen);
         lista.EliminarConComicTal(comic);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con origen y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConOrigenYAfiliacionTal(Lista <E>  listaOriginal,String origen, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConOrigenTal(origen);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con origen y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConOrigenYRazaTal(Lista <E>  listaOriginal,String origen, String raza){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConOrigenTal(origen);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con y afiliacion tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConComicYAfiliacionTal(Lista <E>  listaOriginal,String comic, String afiliacion){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConComicTal(comic);
         lista.EliminarConAfiliacionTal(afiliacion);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con y raza tal*/
    public  LinkedListPlusRecursividadGenerico<E> ListaEliminandoConComicYRazaTal(Lista <E>  listaOriginal,String comic, String raza){
         LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
         lista.EliminarConComicTal(comic);
         lista.EliminarConRazaTal(raza);
         return lista;
    }
    
    /** Metodo terminado para obtener lista eliminando con afiliacion y raza tal*/
    public LinkedListPlusRecursividadGenerico<E> ListaEliminandoConAfiliacionYRazaTal(Lista <E>  listaOriginal,String afiliacion, String raza){
        LinkedListPlusRecursividadGenerico<E> lista = (LinkedListPlusRecursividadGenerico<E>) listaOriginal;
        lista.EliminarConAfiliacionTal(afiliacion); 
        lista.EliminarConRazaTal(raza);
        return lista;
    }
    
    //# AQUI TERMINA LA MODIFICACION
}
