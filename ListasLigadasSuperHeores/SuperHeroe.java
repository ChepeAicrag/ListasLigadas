import java.io.*;
public class SuperHeroe implements Serializable
{
   private String nombre;
   private char sexo;
   private String poder; 
   private int añoAparicion;
   private String debilidad;
   
   public SuperHeroe(String nombre, String poder, char sexo){
       this.nombre = nombre;
       this.poder  = poder;
       this.sexo   = sexo;
    }
    
   public String getNombre(){
       return nombre;
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
   
   public int getAñoAparicion(){
       return añoAparicion;
    } 
    
   public String toString(){
       return " → " + getNombre() + "\n";
    } 
    
   public boolean equals(Object obj){
       SuperHeroe x = (SuperHeroe) obj;
       if(getNombre().equals(x.getNombre()) && getPoder().equals(x.getPoder()) 
          && getSexo()== x.getSexo() )//&& getDebilidad().equals(x.getDebilidad())
          //&& getAñoAparicion() == x.getAñoAparicion())
        return true;
       return false;
    } 
}
