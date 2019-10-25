import java.io.*;
import java.util.*;
public class SuperHeroe implements Serializable
{
   private String alias; 
   private String nombreReal;
   private char sexo; //Metodo realizado
   private String poder; //Metodo realizado
   private int[] añoAparicion; //Metodo realizado
   private String debilidad; //Metodo suspendido
   private String autor; //Metodo realizado
   private String origen; // Metodo realiazdo
   private String comic; // Metodo realizado
   private String afiliacionActual;
   private String raza;
   
   public SuperHeroe(String alias, String poder, char sexo, String debilidad, String autor, 
                     String nombreReal, String origen, String comic, String afiliacionActual, String raza, int... añoAparicion){
       this.alias           = alias;
       this.poder            = poder;
       this.sexo             = sexo;
       this.debilidad        = debilidad;
       this.autor            = autor;
       this.nombreReal       = nombreReal;
       this.origen           = origen;
       this.comic            = comic;
       this.afiliacionActual = afiliacionActual;
       this.raza             = raza;
       añosAparicion(añoAparicion);
    }
    
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
   
   public String getDebilidad(){
       return debilidad;
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
          && getSexo()== x.getSexo() )//&& getDebilidad().equals(x.getDebilidad())
          //&& getAñoAparicion() == x.getAñoAparicion())
        return true;
       return false;
    } 
}
