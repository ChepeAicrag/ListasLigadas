import java.util.*;
import java.io.*;
public class Archivo
{
       public static void LlenarVector(LinkedListPlusRecursividadGenerico lista,String nom) throws Exception{
   Object superheroe=null; 
   try{
       File archivoSalida;
       FileOutputStream flujoArchivoSalida;
       ObjectOutputStream flujoObjetoSalida;    
           archivoSalida=new File(nom+".txt");
           flujoArchivoSalida=new FileOutputStream(archivoSalida);
           flujoObjetoSalida=new ObjectOutputStream(flujoArchivoSalida);
           
           
           for(int i=0;i<lista.formaVector().size();i++){
             superheroe=(Object)lista.formaVector().elementAt(i);  
             flujoObjetoSalida.writeObject(superheroe);
           }
           
           
       flujoObjetoSalida.close();
       flujoArchivoSalida.close();
      }catch(IOException error){ }  
  }
  
public static Vector llenarListaDadoNombre(String nom) throws Exception{
   Object per=null;
   Vector <Object>v=new Vector();
   try{
       File archivoSalida;
       archivoSalida=new File(nom+".txt");     
       FileInputStream flujoArchivoEntrada=new FileInputStream(archivoSalida);
       ObjectInputStream flujoObjetoEntrada=new ObjectInputStream(flujoArchivoEntrada);
       for(int i=0;i<archivoSalida.length();i++){
        per=flujoObjetoEntrada.readObject();
        v.add(per);
        if(v.get(i) instanceof SuperHeroe){
        System.out.println(((SuperHeroe)per).toString());
        }
    } 
       flujoArchivoEntrada.close();
       flujoObjetoEntrada.close();
      }catch(IOException error){}      
    return v;
  }
}
