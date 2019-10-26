
import java.io.*;
public class Archivito
{
    public static void LlenarArchivo(ListaDoblementeEnlazada lista,String nom) throws Exception{
      Object superheroe=null; 
      File archivoSalida;
      FileOutputStream flujoArchivoSalida = null;
      ObjectOutputStream flujoObjetoSalida = null;
        try{    
            archivoSalida = new File(nom+".txt");
            flujoArchivoSalida = new FileOutputStream(archivoSalida);
            flujoObjetoSalida = new ObjectOutputStream(flujoArchivoSalida);
           // if(lista instanceof LinkedListPlusRecursividadGenerico ){
            for(int i=0;i<lista.formaVector().size();i++){
                superheroe = lista.formaVector().elementAt(i);  
                flujoObjetoSalida.writeObject(superheroe);
            }//}
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
}