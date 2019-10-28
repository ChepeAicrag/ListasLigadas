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
   
    public String toString(){
       return " → " + getAlias() + "\n";
    } 
    
   public boolean equals(Object obj){
       SuperHeroe x = (SuperHeroe) obj;
       if(getAlias().equals(x.getAlias()) && getPoder().equals(x.getPoder()) 
          && getSexo() == x.getSexo())
        return true;
       return false;
    } 
}
