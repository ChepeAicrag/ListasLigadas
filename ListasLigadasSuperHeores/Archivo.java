import java.util.*;
import java.io.*;
public class Archivo{
  
  public static void LlenarArchivo(LinkedListPlusRecursividadGenerico lista,String nom) throws Exception{
      Object superheroe=null; 
      File archivoSalida;
      FileOutputStream flujoArchivoSalida = null;
      ObjectOutputStream flujoObjetoSalida = null;
        try{    
            archivoSalida = new File(nom+".txt");
            flujoArchivoSalida = new FileOutputStream(archivoSalida);
            flujoObjetoSalida = new ObjectOutputStream(flujoArchivoSalida);
            for(int i=0;i<lista.formaVector().size();i++){
                superheroe=(Object)lista.formaVector().elementAt(i);  
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
  
 public static void LeerArchivo(String nom) throws Exception{
    ObjectInputStream flujoObjetoEntrada = null;
    FileInputStream flujoArchivoEntrada = null;
    try{
        File archivoSalida = new File(nom+".txt");     
        flujoArchivoEntrada = new FileInputStream(archivoSalida);
        flujoObjetoEntrada = new ObjectInputStream(flujoArchivoEntrada);
        Object per = flujoObjetoEntrada.readObject();   
        StdOut.println("\n******** MOSTRANDO ARCHIVO *******");
        while(per != null){
             System.out.print(((SuperHeroe)per).toString());
             per = flujoObjetoEntrada.readObject();
         }    
       }catch(IOException error){
            System.out.println("******** FIN DE ARCHIVO *******"); 
    }finally{
            flujoArchivoEntrada.close();
            flujoObjetoEntrada.close();
    }    
  }
  /*
  public static void LlenarArchivo(LinkedListPlusRecursividadGenerico lista,String nom) throws Exception{
    Object superheroe=null; 
        try{
            File archivoSalida;
            FileOutputStream flujoArchivoSalida;
            ObjectOutputStream flujoObjetoSalida;    
            archivoSalida = new File(nom+".txt");
            flujoArchivoSalida = new FileOutputStream(archivoSalida);
            flujoObjetoSalida = new ObjectOutputStream(flujoArchivoSalida);
            LinkedListPlusRecursividadGenerico listaTemp =  
            while( listaTemp != null){
                flujoObjetoSalida.writeObject(lista.getInfo(listaTemp));
            }
            flujoObjetoSalida.close();
            flujoArchivoSalida.close();
      }catch(IOException error){}
    }*/
}
