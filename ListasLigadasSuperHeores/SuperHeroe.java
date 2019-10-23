public class SuperHeroe
{
   private String nombre;
   private char sexo;
   private String poder; 
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
    
   public String toString(){
       return " " + getNombre() + " \t||\t " + getPoder() + "\n";
    } 
    
   public boolean equals(Object obj){
       SuperHeroe x = (SuperHeroe) obj;
       if(getNombre().equals(x.getNombre()) && getPoder().equals(x.getPoder()) && getSexo()== x.getSexo())
        return true;
       return false;
    } 
}
