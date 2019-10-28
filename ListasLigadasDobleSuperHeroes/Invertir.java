
/**
 * Write a description of class Invertir here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Invertir
{
    public static void main(){
        ListaDobleEnlazada lista = new ListaDobleEnlazada();
        lista.insertarInicio("1");
        lista.insertarInicio("2");
        lista.insertarInicio("3");
        lista.insertarInicio("4");
        lista.insertarInicio("5");
        lista.mostrarLista();
        lista.reverseDLL();
        lista.mostrarLista();
   }
}
