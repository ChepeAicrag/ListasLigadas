

/**
 * Clase solo para crear a los superheroes
   */

import java.util.*;
public class CreacionSuperHeroes
{
   public static void  llenarSuperHeroes(LinkedListPlusRecursividadGenerico superheroes){
        //LinkedListPlusRecursividadGenerico <SuperHeroe> superheroes = new LinkedListPlusRecursividadGenerico();
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
        SuperHeroe atomo2          = new SuperHeroe("Atomo2","reducir su cuerpo",'H');
        SuperHeroe atomo3          = new SuperHeroe("Atomo3","reducir su cuerpo",'H');
        
        superheroes.insertarPrimero(superman);
        superheroes.insertarPrimero(batman);
        superheroes.insertarPrimero(mujerMaravilla);
        superheroes.insertarPrimero(robbin);
        superheroes.insertarPrimero(flash);
        superheroes.insertarPrimero(linternaVerde);
        superheroes.insertarPrimero(aquaman);
        superheroes.insertarPrimero(hombreHalcon);
        superheroes.insertarPrimero(shazam);
        superheroes.insertarPrimero(capitanAtomo);
        superheroes.insertarPrimero(flechaVerde);
        superheroes.insertarPrimero(detecMarciano);
        superheroes.insertarPrimero(rocketRed);
        superheroes.insertarPrimero(misterMiracle);
        superheroes.insertarPrimero(firestorm);
        superheroes.insertarPrimero(atomo);
        superheroes.insertarPrimero(atomo2);
        superheroes.insertarPrimero(atomo3);
    }  
    
}
