
/**
 * 
 * Clase para utilizar el archivo de superheroes
 * 
 * 
   */
import java.io.*;
public class Archivito{
    
  /** Método utilizado para crear y llenar un arhivo .obj con superheroes */
    
  public static void LlenarArchivo(String nom) throws Exception{
      Object superheroe = null; 
      File archivoSalida;
      FileOutputStream flujoArchivoSalida = null;
      ObjectOutputStream flujoObjetoSalida = null;
        try{    
            archivoSalida = new File(nom+".obj");
            flujoArchivoSalida = new FileOutputStream(archivoSalida);
            flujoObjetoSalida = new ObjectOutputStream(flujoArchivoSalida);
            for(int i = 0; i < CreacionSuperHeroes.llenarSuperHeroes().size(); i++){
                superheroe = CreacionSuperHeroes.llenarSuperHeroes().elementAt(i);  
                flujoObjetoSalida.writeObject(superheroe);
            }
      }catch(IOException error){
        System.out.println("Termina la escritura xd");
        }
      finally{
            flujoObjetoSalida.close();
            flujoArchivoSalida.close();
        }  
  }
  
  /** Método utilizado para llenar una lista desde un archivo */
  
  public static void LeerArchivo(Lista lista,String nom) throws Exception{
    ObjectInputStream flujoObjetoEntrada = null;
    FileInputStream flujoArchivoEntrada = null;
    try{
        File archivoSalida = new File(nom+".obj");     
        flujoArchivoEntrada = new FileInputStream(archivoSalida);
        flujoObjetoEntrada = new ObjectInputStream(flujoArchivoEntrada);
        Object per = flujoObjetoEntrada.readObject();   
        //StdOut.println("\n******** MOSTRANDO ARCHIVO *******");
        while(per != null){
             lista.insertarInicio((SuperHeroe)per);
             //System.out.print(((SuperHeroe)per).toString());
             per = flujoObjetoEntrada.readObject();
         }    
       }catch(IOException error){
            //System.out.println("******** FIN DE ARCHIVO *******"); 
    }finally{
            flujoArchivoEntrada.close();
            flujoObjetoEntrada.close();
    }    
  }
}