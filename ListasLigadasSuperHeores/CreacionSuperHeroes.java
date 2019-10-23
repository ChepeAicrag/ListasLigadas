
import java.util.*;
public class CreacionSuperHeroes
{
    /* public static void main(){
        LinkedListPlusRecursividadGenerico <SuperHeroe> lista = new LinkedListPlusRecursividadGenerico();
        
        /**Ejecucion del metodo que llena una lista*/
    /*    LlenarLista(lista,arregloSuperHeroes());
        
        /**Ejecucion del metodo que imprimir la lista al reves*/
    /*    lista.imprimirNormal();    
        
        /**Prueba de buscar quien está antes de batman*/
     /*   StdOut.println(lista.getInfo(lista.BuscarAntesDe(new SuperHeroe("Batman", "ser rico",'H'))));
   
   
   /**Metodos para crear superhores y agregar a la lista*/
   
   public static void LlenarLista(LinkedListPlusRecursividadGenerico lista, Vector<SuperHeroe> s){
       for(int i = 0; i < s.size(); i++) 
       lista.insertarPrimero(s.elementAt(i));
    }
   
   public static Vector<SuperHeroe> arregloSuperHeroes(){
        Vector <SuperHeroe> superheroes = new Vector();
        SuperHeroe superman       = new SuperHeroe("Spiderman","super fuerza, velocidad",'H');
        SuperHeroe batman         = new SuperHeroe("Batman", "ser rico",'H');
        SuperHeroe mujerMaravilla = new SuperHeroe("Mujer maravilla", "lazo de verdad",'M');
        SuperHeroe robbin         = new SuperHeroe("Robbin","ser chalan",'H');
        SuperHeroe flash          = new SuperHeroe("Flash","supervelocidad",'H');
        SuperHeroe linternaVerde  = new SuperHeroe("Linterna Verde","volar",'H');
        SuperHeroe aquaman        = new SuperHeroe("Aquaman","adaptacion acuatica",'H');
        SuperHeroe hombreHalcon   = new SuperHeroe("Hombre Halcon","habilidades de halcon",'H');
        SuperHeroe shazam         = new SuperHeroe("Shazam","invulnerabilidad",'H');
        SuperHeroe capitanAtomo   = new SuperHeroe("Capitan Atomo","descargas atomicas",'H');
        SuperHeroe flechaVerde    = new SuperHeroe("Flecha Verde","super agilidad",'H');
        SuperHeroe detecMarciano  = new SuperHeroe("Detective Marciano","telepatia",'H');
        SuperHeroe rocketRed      = new SuperHeroe("Rocket Red","control de la emocion",'H');
        SuperHeroe misterMiracle  = new SuperHeroe("Mister Miracle","artista del escape",'H');
        SuperHeroe firestorm      = new SuperHeroe("Firestorm","expulsion de fuego",'H');
        SuperHeroe atomo          = new SuperHeroe("Atomo","reducir su cuerpo",'H');
        
        superheroes.add(superman);
        superheroes.add(batman);
        superheroes.add(mujerMaravilla);
        superheroes.add(robbin);
        superheroes.add(flash);
        superheroes.add(linternaVerde);
        superheroes.add(aquaman);
        superheroes.add(hombreHalcon);
        superheroes.add(shazam);
        superheroes.add(capitanAtomo);
        superheroes.add(flechaVerde);
        superheroes.add(detecMarciano);
        superheroes.add(rocketRed);
        superheroes.add(misterMiracle);
        superheroes.add(firestorm);
        superheroes.add(atomo);
        return superheroes;
    }  
    
}
