import java.io.*;
import java.util.*;
public class SuperHeroe implements Serializable
{
   private String alias; //Metodo realizado
   private String nombreReal; //Metodo realiazdo
   private char sexo; //Metodo realizado
   private String poder; //Metodo realizado
   private int[] añoAparicion; //Metodo realizado
   private String autor; //Metodo realizado
   private String origen; // Metodo realiazdo
   private String comic; // Metodo realizado
   private String afiliacionActual; //Metodo realizado
   private String raza; //Metodo realizado
   
   public SuperHeroe(String alias, String poder, char sexo, String autor, 
                     String nombreReal, String origen, String comic, String afiliacionActual, String raza, int... añoAparicion){
       this.alias            = alias;
       this.poder            = poder;
       this.sexo             = sexo;
       this.autor            = autor;
       this.nombreReal       = nombreReal;
       this.origen           = origen;
       this.comic            = comic;
       this.afiliacionActual = afiliacionActual;
       this.raza             = raza;
       añosAparicion(añoAparicion);
    }
    /** Metodo para guardar los años */
   private void añosAparicion(int...añoAparicion){
       int x = 0;
       this.añoAparicion = new int[añoAparicion.length];
       for(int i : añoAparicion){
           this.añoAparicion[x] = i;
           x++;
       }
    } 
    
   public String getAlias(){
       return alias;
    }
    
   public char getSexo(){
       return sexo;
    }
    
   public String getPoder(){
       return poder;
    } 
   
   public int[] getAñoAparicion(){
       return añoAparicion;
    } 
    
   public String getAutor(){
       return autor;
    } 
   
   public String getNombreReal(){
       return nombreReal;
    } 
   
   public String getOrigen(){
       return origen;
    } 
    
   public String getComic(){
       return comic;
    }
    
   public String getAfiliacionActual(){
       return afiliacionActual;
    } 
   
   public String getRaza(){
        return raza;
    }
   
   private String años(){
      String s = "";
       for(int i = 0; i < getAñoAparicion().length ; i++)
            s += String.valueOf(getAñoAparicion()[i]) + ",";
      return s.substring(0,s.length()-1);      
    } 
    
   /** Método para comprobar los años */ 
   
   private boolean añosIgual(int[] años){
       int temp[] = getAñoAparicion();
       if(años.length == temp.length){
           Arrays.sort(temp);
           Arrays.sort(años);
           int cont = 0;
           for(int i = 0; i < temp.length; i++)
               if(años[i] == temp[i])
                  cont++;
           if(cont == temp.length)
               return true;
        }
       return false; 
    }
   
   /** Método para comprobar los poderes */ 
   
   private boolean poderIgual(String poderes){
       String[] temp = getPoder().split(",");
       String[] temp2 = poderes.split(",");
       if(temp2.length == temp.length){
           Arrays.sort(temp);
           Arrays.sort(temp2);
           int cont = 0;
           for(int i = 0; i < temp.length; i++)
                if(temp[i].equalsIgnoreCase(temp2[i]))
                    cont++;
           if(cont == temp.length)
              return true;
      }
      return false;
   }
    
   public String toString(){
       return "\r → ALIAS |" + getAlias() + "| \n NOMBRE REAL |" + getNombreReal() + "| \n CREADOR |" + getAutor() + "| \n ORIGEN |" + getOrigen() + "| \n SEXO |" + getSexo() + 
               "| \n AÑOS DE APARICION |" + años() + "| \n COMICS |" + getComic() + "| \n AFILIACIONES |" + getAfiliacionActual() + "| \n RAZA |" + getRaza() + "| \n PODERES |" + getPoder() + "|\n" ;
    } 
    
   public boolean equals(Object obj){
       SuperHeroe x = (SuperHeroe) obj;
       if(getAlias().equalsIgnoreCase(x.getAlias()) && poderIgual(x.getPoder()) 
          && getSexo() == x.getSexo() && añosIgual(x.getAñoAparicion()) && getOrigen().equalsIgnoreCase(x.getOrigen()) && 
          getAfiliacionActual().equalsIgnoreCase(x.getAfiliacionActual()) && getAutor().equals(x.getAutor()) && getRaza().equals(x.getRaza()))
        return true;
       return false;
    } 
    
}
