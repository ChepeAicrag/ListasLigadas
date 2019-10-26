
/**
 * Clase solo para crear a los superheroes
   */

import java.util.*;
public class CreacionSuperHeroes
{
   public static void  llenarSuperHeroes(ListaDoblementeEnlazada superheroes2){
        //LinkedListPlusRecursividadGenerico <SuperHeroe> superheroes = new LinkedListPlusRecursividadGenerico();
        /*
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
        */
       
       /**SuperHeroe(String alias, String poder, char sexo, int añoAparicion, String debilidad, String autor, 
                     String nombreReal, String origen, String comic, String afiliacionActual, String raza){
          */
        SuperHeroe demon       = new SuperHeroe("Demon","Atributos físicos y poderes sensoriales sobrehumanos,Capacidad de regeneración, Poderes mágicos,Precognición,Telepatía,Inmortalidad,Puede lanzar llamas de fuego místico,Vuelo",
        'H',"Convive en un mismo cuerpo","Jack Kirby","Jason Blood","Gotham City","The Demon","Liga de la Justicia Oscura","Demonio",1972); 
        
        SuperHeroe demon2       = new SuperHeroe("Demon2","Atributos físicos y poderes sensoriales sobrehumanos,Capacidad de regeneración, Poderes mágicos,Precognición,Telepatía,Inmortalidad,Puede lanzar llamas de fuego místico,Vuelo",
        'H',"Convive en un mismo cuerpo","Jack Kirby","Jason Blood","Gotham City","The Demon","Liga de la Justicia Oscura","Demonio",1972); 
        
        
        SuperHeroe superwoman  = new SuperHeroe("Superwoman","Capacidad de regeneración,Transformar energia,Absorción de Energía Solar,Super Fuerza,Invulnerabilidad,Super Velocidad,Vuelo,Visión de Calor,Visión Aumentada",
        'M',"","Phil Jimenez","Lois Lane,Luma Lynai,Diana (Tierra-3),Kristin Wells,Dana Dearden,Lucy Lane,Lana Lang","Tierra-11",
        "Action Comics,Justice League of America,Miracle Monday,Adventures of Superman,Supergirl,Superwoman","Liga de la Justicia","Superhumana",1943,1962,1964,2009,2016);
        
        SuperHeroe superwoman2  = new SuperHeroe("Superwoman2","Capacidad de regeneración,Transformar energia,Absorción de Energía Solar,Super Fuerza,Invulnerabilidad,Super Velocidad,Vuelo,Visión de Calor,Visión Aumentada",
        'M',"","Phil Jimenez","Lois Lane,Luma Lynai,Diana (Tierra-3),Kristin Wells,Dana Dearden,Lucy Lane,Lana Lang","Tierra-11",
        "Action Comics,Justice League of America,Miracle Monday,Adventures of Superman,Supergirl,Superwoman","Liga de la Justicia","Superhumana",1943,1962,1964,2009,2016);
        
        superheroes2.insertarInicio(demon);
        superheroes2.insertarInicio(superwoman);
        superheroes2.insertarInicio(superwoman2);
        superheroes2.insertarInicio(demon2);
        
        /**Agregar a los 50 superheroes faltantes*/
        /*
        SuperHeroe deadman     = new SuperHeroe("Deadman","Invisibilidad,Vuelo,Intangibilidad,Puede poseer a cualquier ser vivo y controlarlo completamente",
        'H',1967,"","Arnold Drake","Boston Brand","acróbata de circo ","Strange Adventures","Liga de la Justicia Oscura, Circo Haly, Black Lanterns Corps, White Lanterns Corps","Fantasma");
        
        SuperHeroe adamStrange = new SuperHeroe("Adam Strange","Equipamiento: mochila propulsora espacial que le permite tener vuelo controlado y viajes interestelares; armas energéticas; generador de equipamiento de luz sólida; equipo para visualizar el espectro electromagnético.",
        'H',1958,"","Julius Schwartz","Adam Strange","La Tierra","Showcase","Liga de la Justicia,Liga de la Justicia Unida,Los Siete Soldados de la Victoria,R.E.B.E.L.S.","Humano");
        
        SuperHeroe starfire = new SuperHeroe("Starfire","Fuerza sobrehumana, resistencia y durabilidad, vuelo, proyección de Energía y asimilación lingüística",
        'M',1982,"","Marv Wolfman","Koriand'r","Okara","DC Comics Presents","Los Jóvenes Titanes","Tamaraneana");
        
        SuperHeroe linternaVerde = new SuperHeroe("Linterna verde","Anillo de poder que posee la capacidad de crear manifestaciones de luz sólida mediante la utilización del pensamiento.",
        'H',1940,"","Bill Finger,Martin Nodell,John Broome,Gil Kane","Green Lantern","Tierra-2","All-American Comics","Liga de la Justicia, All Star Squadron, Sociedad de la justicia de América","Humano"); 
        
        SuperHeroe zatanna = new SuperHeroe("Zatanna","	Dominio sobre la magia",'M',1964,"","Gardner Fox,Murphy Anderson","Zatanna Zatara","Nueva Tierra","Hawkman","Liga de la Justicia Oscura,Liga de la Justicia",
        "Humana");
        
        SuperHeroe doctorFate = new SuperHeroe("Doctor Destino","Maestro de la magia manifestada en jeroglíficos egipcios, lanzamiento de hechizos, super-fuerza, invulnerabilidad, telequinesis, telepatía, manipulación del fuego y del rayo. El manipula las fuerzas místicas de la magia, a partir de los poderes del Casco NABU y el talismán del destino genera hechizos, portales y conjuros, así como la habilidad de volar, manipulación mental y creación de todo tipo de conjuros mágicos.",
        'H',1940,"","Gardner Fox,Howard Sherman","Kent Nelson,Kent Nelson,Inza Nelson,Eric Strauss,Linda Strauss,Héctor Hall,Kent V. Nelson,Khalid,Khalid Nassour","La Tierra","More Fun Comics","Sociedad de la Justicia de América","Humano");
        
        */
        
    }  
    
}
