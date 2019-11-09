/**
 * 
 * Clase utilizada solo para crear a los superheroes
 * 
   */

import java.util.*;
public class CreacionSuperHeroes
{
   public static Vector<SuperHeroe> llenarSuperHeroes(){
       
       /**Vector a retornar, que contiene a todos los superheroes*/
        
       Vector <SuperHeroe> SuperHeroes = new Vector <SuperHeroe>();
       
        SuperHeroe demon       = new SuperHeroe("Demon","Atributos físicos y poderes sensoriales sobrehumanos,Capacidad de regeneración, Poderes mágicos,Precognición,Telepatía,Inmortalidad,Puede lanzar llamas de fuego místico,Vuelo",
                'H',"Jack Kirby","Jason Blood","Gotham City","The Demon","Liga de la Justicia Oscura","Demonio",1972); 
        SuperHeroe demon2       = new SuperHeroe("Demon2","Atributos físicos y poderes sensoriales sobrehumanos,Capacidad de regeneración, Poderes mágicos,Precognición,Telepatía,Inmortalidad,Puede lanzar llamas de fuego místico,Vuelo",
                'H',"Jack Kirby","Jason Blood","Gotham City","The Demon","Liga de la Justicia Oscura","Demonio",1972); 
        SuperHeroe superwoman2  = new SuperHeroe("Superwoman2","Capacidad de regeneración,Transformar energia,Absorción de Energía Solar,Super Fuerza,Invulnerabilidad,Super Velocidad,Vuelo,Visión de Calor,Visión Aumentada",
                'M',"Phil Jimenez","Lois Lane,Luma Lynai,Diana (Tierra-3),Kristin Wells,Dana Dearden,Lucy Lane,Lana Lang","Tierra-11",
                "Action Comics,Justice League of America,Miracle Monday,Adventures of Superman,Supergirl,Superwoman","Liga de la Justicia","Superhumana",1943,1962,1964,2009,2016);
        SuperHeroe deadman     = new SuperHeroe("Deadman","Invisibilidad,Vuelo,Intangibilidad,Puede poseer a cualquier ser vivo y controlarlo completamente",
                'H',"Arnold Drake","Boston Brand","acróbata de circo ","Strange Adventures","Liga de la Justicia Oscura, Circo Haly, Black Lanterns Corps, White Lanterns Corps","Fantasma",1967);
        SuperHeroe adamStrange = new SuperHeroe("Adam Strange","Equipamiento: mochila propulsora espacial que le permite tener vuelo controlado y viajes interestelares; armas energéticas; generador de equipamiento de luz sólida; equipo para visualizar el espectro electromagnético.",
                'H',"Julius Schwartz","Adam Strange","La Tierra","Showcase","Liga de la Justicia,Liga de la Justicia Unida,Los Siete Soldados de la Victoria,R.E.B.E.L.S.","Humano",1958);
        SuperHeroe starfire = new SuperHeroe("Starfire","Fuerza sobrehumana, resistencia y durabilidad, vuelo, proyección de Energía y asimilación lingüística",
                'M',"Marv Wolfman","Koriand'r","Okara","DC Comics Presents","Los Jóvenes Titanes","Tamaraneana",1982);
        SuperHeroe linternaVerde = new SuperHeroe("Linterna verde","Anillo de poder que posee la capacidad de crear manifestaciones de luz sólida mediante la utilización del pensamiento.",
                'H',"Bill Finger,Martin Nodell,John Broome,Gil Kane","  Alan Scott,Hal Jordan,Guy Gardner,John Stewart,Kyle Rayner,Jade,Sinestro,Simon Baz,Jessica Cruz","Tierra-2","All-American Comics","Liga de la Justicia, All Star Squadron, Sociedad de la justicia de América","Humano",1940); 
        SuperHeroe zatanna = new SuperHeroe("Zatanna"," Dominio sobre la magia",'M',"Gardner Fox,Murphy Anderson","Zatanna Zatara","Nueva Tierra","Hawkman","Liga de la Justicia Oscura,Liga de la Justicia",
                "Humana",1964);
        SuperHeroe doctorFate = new SuperHeroe("Doctor Destino","Maestro de la magia manifestada en jeroglíficos egipcios, lanzamiento de hechizos, super-fuerza, invulnerabilidad, telequinesis, telepatía, manipulación del fuego y del rayo. El manipula las fuerzas místicas de la magia, a partir de los poderes del Casco NABU y el talismán del destino genera hechizos, portales y conjuros, así como la habilidad de volar, manipulación mental y creación de todo tipo de conjuros mágicos.",
                'H',"Gardner Fox,Howard Sherman","Kent Nelson,Kent Nelson,Inza Nelson,Eric Strauss,Linda Strauss,Héctor Hall,Kent V. Nelson,Khalid,Khalid Nassour","La Tierra","More Fun Comics","Sociedad de la Justicia de América","Humano",1940);
        SuperHeroe espector = new SuperHeroe("Espíritu de la Venganza,Espíritu redentor,Cólera vengativa de Dios,Guardián Fantasma,El Hombre de las Tinieblas,Ragüel","Dominio sobre la magia,Omnipotencia,Omnipresencia,Omnisciencia, Inmortalidad, Conocimiento de los acontecimientos antes de Crisis on Infinite Earths, Poder de la Vida y la Muerte.",'H'
                ,"Jerry Siegel,Bernard Baily","Aztar","","More Fun Comics,Kingdom Come","Liga de la Justicia Oscura","Cosmico",1940);
        SuperHeroe mera = new SuperHeroe("  Aquawoman, Reina de la atlantida, Habitante de las Profundidades, Antiguamente princesa de Xebel", "Hidroquinesis,Adaptación acuática-anfibia,Vuelo,Factor de curación,Sentidos mejorados,Fuerza, agilidad, destreza, velocidad, resistencia y durabilidad sobrehumanas (incluso en las profundidades aplastantes del océano),Resistencia sobrehumana al frío extremo,Control del agua,Creación y lanzamiento objetos de agua dura"
                ,'M',"Jack Miller","Mera","Aqua", "Aquaman", "Atlantis,Red Lantern Corps de la Justicia Unida,Liga de la Justicia","Atlante",1963);
        SuperHeroe capuchaRoja = new SuperHeroe("Capucha Roja", "Experto en combate, entrenado por Batman.", 'H', " Bill Finger,Judd Winick", "Jason Todd", "Desconocido", "Detective Comics", "Red Hood y Scarlet,Outlaws", "Humano", 1951);
        SuperHeroe canarioNegro = new SuperHeroe("Siu Jerk Jai, Operativa Canary, D.D., Diva Peligrosa, Canario", "Experta en artes marciales,Grito Ultrasónico",'M'
                ,"Robert Knaigher,Carmine Infantino", "Dinah Laurel Lance,Dinah Drake Lance", "Gotham City","Flash Comics","Liga de la Justicia,Sociedad de la Justicia de América,Birds of Prey,Equipo 7", "Humano", 1947);
        SuperHeroe escaranajoAzul = new SuperHeroe("Bluee Beetle", "volar, superfuerza y luminosidad",'H',"Charles Nicholas,Steve Ditko", "Dan Garrett,Ted Kord,Jaime Reyes ","Estados Unidos", "Mystery Men Comics", "Liga de la Justicia","Humano",1939,1966,2006);
        
        /**
         * 
         * Personajes de Superman
         * 
           */
        
        SuperHeroe superman = new SuperHeroe("El hombre de acero, El hombre del mañana, La maravilla de Metrópolis, El último hijo de Krypton, Gangbuster, Superboy, La Mancha (en Smallville)", "Súper fuerza,Súper velocidad,Vuelo.Invulnerabilidad casi total,Súper oído,Visión telescópica y microscópica.Visión de rayos-x,Aliento helado,Visión calorífica,Visión infra roja,Visión espectro magnética,Factor de curación acelerada,Longevidad"
                , 'H', "Jerry Siegel, Joe Shuster", "Kal-El,Clark Joseph Kent", "Tierra,Krypton","Action Comics,", "Liga de la Justicia", "Kryptoniano,Humano", 1938);
        SuperHeroe superwoman  = new SuperHeroe("Superwoman","Capacidad de regeneración,Transformar energia,Absorción de Energía Solar,Super Fuerza,Invulnerabilidad,Super Velocidad,Vuelo,Visión de Calor,Visión Aumentada",
                'M',"Phil Jimenez","Lois Lane,Luma Lynai,Diana (Tierra-3),Kristin Wells,Dana Dearden,Lucy Lane,Lana Lang","Tierra-11",
                "Action Comics,Justice League of America,Miracle Monday,Adventures of Superman,Supergirl,Superwoman","Liga de la Justicia","Superhumana",1943,1962,1964 ,2009 ,2016);
        SuperHeroe superboy = new SuperHeroe("Superboy", "Los poderes de Superman, en menor nivel, tales como: Superfuerza, Super Velocidad, Vuelo, Invulnerabilidad, Factor Curativo, Visión Rayos X, Superoído, Visión Calórica, Aliento gélido, Telequinesia, Reflejos Aumentados", 'M'
                , "Jerry Siegel", "Conner Kent,Kon-El", "Estados Unidos,Krypton", "More Fun Comics", "Justicia joven, Familia Superman, Titanes", "Kriptoniano,Humano",1945,1949);
        SuperHeroe darkseid = new SuperHeroe("Jefe del lado oscuro","Inmortalidad,Atributos físicos sobrehumanos,Intelecto sobrehumano,Efecto Omega y manipulación de la Energía,Omnipotencia,Teletransportación",'H'
                ,"Jack Kirby",""," Apokolips","Superman's Pal Jimmy Olsen","Sociedad Secreta de Súper Villanos","Apokolipniano",1970,1971);
        SuperHeroe lexLuthor = new SuperHeroe("Lex","Extremadamente inteligente, inmensos recursos financieros y armamentísticos, uso ocasional de una armadura robótica",'H'
                ,"Jerome Siegel,Joe Shuster","Alexander Joseph Lex Luthor","Estados Unidos","Action Comics","LexCorp","Humano",1940);
        SuperHeroe krypto = new SuperHeroe("Krypto el Superperro", "Vuelo, super-fuerza, super-visión, super-audición, super-velocidad, invulnerabilidad", 'M', "Otto Binder,Curt Swan", "Krypto", "Tierra,Krypton", "Adventure Comics", "Legión de Super-Mascotas", "Kriptoniano", 1955);
        SuperHeroe brainiac = new SuperHeroe("Milton Fine", "Acceso a avanzada tecnología extraterrestre, altísima inteligencia, telepatía, telekinesis, control mental", 'M', "Otto Binder,Al Plastino", "Vril Dox", "", "Action Comics ", "Legion del Mal", "Humanoide, Android", 1958);
        SuperHeroe powerGirl = new SuperHeroe("Karen Starr, Kara of Atlantis, Power Woman", "Volar, fuerza sobrehumana, visión de rayos X, microscópica, telescópica, calorífica, invulnerabilidad, super velocidad, super oído, super aliento",'M'
                ,"Gerry Conway,Wally Wood","Kara Zor-El", "Krypton, Tierra","All Star Comics","Sociedad de la Justicia de América , Estrellas de la Sociedad de la Justicia de América","Kryptoniano",1976);
        SuperHeroe streaky = new  SuperHeroe("El supergato", "vuelo, super-fuerza,super-visión,super-velocidad,invulnerabilidad", 'H', "Otto Binder,Jim Mooney", "Streaky, the Supercat", "Krypton", "Action Comics ", "Legión de Super-Mascotas", "Felis silvestris catus (gato)",1960);
        SuperHeroe cometa = new SuperHeroe("Biron", "vuelo, super-fuerza,super-visión,super-velocidad,invulnerabilidad", 'H', "Grant Morrison", "Comet", "Krypton", "Adventure Comics ", "Legión de Super-Mascotas", "Caballo", 1962);
        SuperHeroe acero = new SuperHeroe("El Hombre de Acero, Henry Johnson, Acero, Hombre de Acero, Hombre de Hierro.", "Genio ingeniero e inventor,Desarrolla armaduras con capacidades de:fuerza sobrehumana, durabilidad, resistencia y Vuelo,Varios otros armamentos cibernéticos,variedad de matrices de comunicación y sensores,ejerce un mazo aparentemente indestructible", 'H', "Louise Simonsony", "Dr. John Henry Irons", "Estados Unidos", "The Adventures of Superman", "Liga de la justicia,AmerTek Industries,Escuadrón Suicida,Laboratorios S.T.A.R,Infinity Inc", "Huamno", 1993);
        SuperHeroe volcana = new SuperHeroe("Volcana", "Control del fuego,Capacidad de escupir fuego,Generar gran cantidad de calor,Agilidad", 'M',"Bruce Timm", "Claire Selton", "Estados Unidos","Superman: la serie animada", "Sociedad Secreta de Supervillanos", "Humano",1996);
        SuperHeroe generalZod = new SuperHeroe("General Zod","\"Súper fuerza,Súper velocidad,Vuelo.Invulnerabilidad casi total,Súper oído,Visión telescópica y microscópica.Visión de rayos-x,Aliento helado,Visión calorífica,Visión infra roja,Visión espectro magnética,Factor de curación acelerada,Longevidad", 'H', "Robert Bernstein,George Papp", "Dru-Zod Corkript", "Krypton", "Adventure Comics", "", "Kriptoniano", 1961);
        SuperHeroe erradicador = new SuperHeroe("El Erradicador", "Preservar el ideal de la cultura kryptoniana", 'H', " Roger Stern", "David Conner", "Krypton", "Action Comics Annual", "", "Kritpniano", 1989);
        SuperHeroe doomsday = new SuperHeroe("  Doomsday, Juicio Final (en España), Chacal.", " Fuerza, velocidad, resistencia, y durabilidad sobrehumanas; Invulnerabilidad; Longevidad, Factor de Curación, la habilidad de resucitar.", 'H', "Dan Jurgens", "", "Krypton", "Superman: The Man of Steel ", "Sociedad Secreta de Supervillanos, Apokolips,", "Kriptoniano", 1992);
        
        /**
         * 
         * Personajes de Batman
         *  
         */
        
        SuperHeroe batman = new SuperHeroe("Matches Malone​, El caballero de la noche, El caballero oscuro, Zurdo Knox3​", "Habilidades como detective,Intelecto nivel genio.4,Brillante estratega y acróbata experto,Dominio de artes marciales y técnicas de sigilo e intimidación,Escapismo,Uso de equipamiento, dispositivos y armamento de alta tecnología"
                    ,'H',"Bob Kane","Bruce Wayne","Gotham City,Estados Unidos", "Detective Comics", "Liga de la Justicia,The Outsiders","Humano",1939);
        SuperHeroe bluebird = new SuperHeroe("Bluebird", "Es habilir en combate mano a mano,sigilosa", 'M',"Scott Snyder ","Harper Row", "Estados Unidos"," Batman"
                    ,"Batifamilia", "Humano", 2012,2014);
        SuperHeroe batwoman = new SuperHeroe("Katy Kane ,Candy", "nivel intelecto de genio,Pico condición física humana,Altamente calificada artista marcial,Detective altamente cualificado", 'M', "Sheldon Moldoff,Bob Kane,Geoff Johns,Grant Morrison,Greg Rucka,Mark Wade,Ken Lashley", "Katherine Rebecca \"Kate\" Kane", "Gotham City", "Detective Comics ", "Batifamilia,D.E.O,Liga de la Justicia", "Huamana",1956,2006);
        SuperHeroe joker = new SuperHeroe("Príncipe Payaso del Crimen, As de Bandidos, Arlequín del Odio, Capucha Roja, Jack White","agilidad, coeficiente intelectual de genio, experto en armas y navajas, especialista en sustancias tóxicas y explosivos, memoria eidética, extraordinaria resistencia", 'H'
                    ,"Jerry Robinson,Bill Finger,Bob Kane","desconocido","Estados Unidos","Batman,Detective Comics", "Liga de la Injusticia,Escuadrón Suicida", "Humano", 1940);
        SuperHeroe pinguino = new SuperHeroe("El Pingüino", "Intelecto nivel de genio,Variedad de equipo relacionado con aves,Mortales paraguas especializados,Conexiones vastas con el mundo criminal.", 'H', "Bob Kane,Bill Finger"
                    ,"Oswald Chesterfield Cobblepot","Estados Unidos","Detective Comics","Liga de la Injusticia,Escuadrón Suicida,La Sociedad","Huamno",1941);
        SuperHeroe catwoman =  new SuperHeroe("La Gata, Irena Dubrovna", "Gran atleta,Experta ladrona,Agilidad propia de un gato,Utiliza un látigo como arma,Experta en combate mano a mano", 'M', "Bob Kane,Bill Finger", "Selina Kyle", "Gotham City, Estados Unidos", "Batman ", "Liga de la Justicia", "Humano", 1941);
        SuperHeroe harleyQuinn = new SuperHeroe("Harley Quinn, Harley", "Entrenada en el área de la psiquiatría,Gimnasta talentosa,Inmunidad a todos los venenos y toxinas,combatiente impredecible,Dueña de un edificio en Coney Island (recientemente),Resistencia, fuerza y velocidad superiores,IQ superior que el promedio", 'M', "Paul Dini,Bruce Timm", "Harleen Frances Quinzel"
                    ,"Gotham City, Coney Island,Estados Unidos", "Batman", "Sociedad Secreta de Súper Villanos (antes del rebirth),Seis Secretos (solo en los new 52),Escuadrón Suicida,Banda de los Harleys,Gotham City Sirens,Liga de la Justicia", "Humano", 1992);
        SuperHeroe hiedraVenenosa = new SuperHeroe("Dra. Pamela Lillian Isley,Lillian Rose,Penelope Ivy", "Control y manipulación de toda clase de plantas,Clorofila en lugar de sangre,Control absoluto de las feromonas,Genera toxinas naturales,Fuerza sobrehumana", 'M', "Robert Kanigher,Sheldon Moldoff", "Pamela Lilian Isley", "Gotham City, Estados Unidos", "Batman", "Sociedad Secreta de Super Villanos,Escuadrón Suicida,Injustice Gang, Birds of Prey (cómic),Gotham City Sirens", "Humano", 1966);
        SuperHeroe victorFries = new SuperHeroe("Mister Zero,Doctor Zero,Doctor Schimmell", "Intelecto de nivel de genio,La fisiología bajo cero permite la supervivencia en un estado congelado,Refrigerado traje de batalla exoesqueleto otorga fuerza y durabilidad sobrehumanas,Utiliza armamento criogénico", 'H', "Bob Kane", "Víctor Fries","Estados Unidos","Batman","Liga de la Injusticia","Humano",1959);
        SuperHeroe deathstroke = new SuperHeroe("Slade,Deathstroke el Terminator,Terminator,Mayor Slade Wilson","Factor de curación acelerada,Fuerza y sentidos aumentados considerablemente,Gran puntería y habilidad con cualquier arma",'H',"Marv Wolfman,George Pérez","Slade Joseph Wilson","Estados Unidos","The New Teen Titans ","Escuadrón Suicida,Liga de la Justicia","Humano",1980);
        SuperHeroe deadshot = new SuperHeroe("Deadshot","Experto combatiente cuerpo a cuerpo,Excelente habilidad con la espada,Tirador experto sin fallar,Ojo cibernético que le proporciona mayor exactitud, datos de la misión y objetivos adicionales,Control de cada tipo de armas",'H',"Bob Kane,David Vern Reed,Lew Schwartz","Floyd Lawton","Gotham City,Estados Unidos","Batman","Seis Secretos,Escuadrón Suicida,Élite Asesina,Jaquemate,Sociedad Subterránea,Liga de la Justicia","Humano",1950);
        SuperHeroe manBat = new SuperHeroe("Robert Kirk, El Segundo Murciélago", "Vuelo,Elongación,Fuerza extrema,Capacidad de escucha y visión superior a la normal",'H', "Frank Robbins,Neal Adams", "Robert Kirkland \"Kirk\" Langstrom", "Estados Unidos", "Detective Comics", "Sociedad Secreta de Super Villanos", "Humano,Bestia", 1970);
        SuperHeroe bane = new SuperHeroe("El Hombre que quebró al murciélago", "Fuerza,energía sobrehumanas,gran velocidad,Gran inteligencia,Resistencia sobrehumana,reparar partes dañadas en poco tiempo.", 'H', "Chuck Dixon,Graham Nolan","Antonio Diego Dorrance", "Gotham City,Estados Unidos", "Batman,Venganza de Bane","Escuadrón Suicida, Liga de las Sombras, Sociedad Secreta de Supervillanos, Seis Secretos", "Humano",1993);
        SuperHeroe rasalGhul = new SuperHeroe(" La Cabeza del Demonio,El Demonio, Henry Ducard", "Inmortalidad,estratega,genio de la alquimia,esgrimista ", 'H', "Dennis O'Neil,Neal Adams", "Ra's al Ghul,Henry Ducard", "Israel", "Batman", "Liga de Asesinos", "Humano", 1971);
        
        /**
         * 
         * Personajes de flash
         * 
         */
        
        SuperHeroe flash = new SuperHeroe("Barry,FLash", "Inmensa velocidad,agilidad,resistencia sobrehumanas,Viaje en el tiempo", 'H', "Robert Kanigher,Carmine Infantino", "Bartholomew Henry \"Barry\" Allen", "Ciudad Central,Estados Unidos", "Showcase", "Liga de la Justicia,Equipo Flash", "Humano", 1956);
        SuperHeroe flash2 = new SuperHeroe("Flash", "Capacidad para correr a la velocidad de la luz", 'H', "Gardner Fox,Harry Lampert", "Jason Peter \"Jay\" Garrick", "Ciudad Central,Keystone City,Estados Unidos", "Flash Comics", "Sociedad de la Justicia de América", "Humano", 1940);
        SuperHeroe kidFlash = new SuperHeroe("Kid Flash", "Fuerza, rapidez , reflejos sobrehumanos, capacidad para vibra sus moléculas para traspasar o desprenderse un objetos", 'H', "John Broome,Carmine Infantino,Mark Waid,Mike Wieringo,Mark Waid,Brian Augustyn,Paul Pelletier,Van Jensen,Robert Venditti,Ron Frenz,mBrett Booth","Wally West,Iris West,Bart Allen,Wallace West", "Estados Unidos", "The Flash", "Teen Titans,Liga de la Justicia,Equipo Flash,Legión de Super-Héroes,Leyendas Del Mañana", "Humano", 1960,1994,1996,2014);
        SuperHeroe killerFrost = new SuperHeroe("Escarcha", "Manipulación,Generar hielo", 'M', "Gerry Conway,Al Milgrom", "Crystal Frost,Louise Lincoln,Caitlin Snow", "Estados Unidos", "Firestorm,Fury of Firestorm: The Nuclear Man", "Universidad de Hudson,Escuadrón Suicida,Liga de la Injusticia,Sociedad Secreta de Super Villanos,Sociedad Secreta de Super Villanos,Liga de la Justicia de América", "Humano", 1978,1984,2013);
        SuperHeroe capitanBumerang = new SuperHeroe("   Digger, Capitán Boomerang", "bumeranes trucados,crear bumeranes de energía pura", 'H', "John Broome,Carmine Infantino", "George \"Digger\" Harkness", "Estados Unidos", "Flash ", "Sociedad Secreta de Supervillanos,Renegados,Escuadrón Suicida,Banda de la Injusticia,Cuerpo de Linterna Negra", "Humano", 1960);
        SuperHeroe magneta = new SuperHeroe("Magenta,Magneta", "Control del magnetismo y electromagnetismo", 'M', "Marv Wolfman,George Pérez", "Frances \"Francine\" Kane", "Estados Unidos", "New Teen Titans ", "Regados,Liga de la Injusticia,Los Jóvenes Titanes", "MetaHumana", 1982);
        SuperHeroe baronKatana = new SuperHeroe("Baron Katana", "Ingeniería robótica", 'H', "Frank Robbins,Ross Andru", "desconocido", "Japon", "The Flash","Villanos FLash","Humano", 1968);
        SuperHeroe gorillaGrodd = new SuperHeroe("Drew Drowden, William Dawson", "Poderes telepáticos, gran fuerza", 'H', "John Broome,Carmine Infantino ", " original  Grodd", "Ciudad Gorila", "The Flash", "desconocido", "Gorila con superpoderes", 1959);
        SuperHeroe piedPiper = new SuperHeroe("Piper,El flautista de Hamelín,El Flautista", "Experto en tecnología sónica,ecuación anti-vida,Maneja una flauta con poderes hipnóticos", 'H', "  John Broome,Carmine Infantino", "Hartley Rathaway", "Ciudad Central,Estados Unidos", "The Flash", "Los Renegados,FBI", "Humano", 1959,1960);
        SuperHeroe mirrorMaster = new SuperHeroe("Mirror Master", "Posee una pistola de espejos para disparar rayos,Potencias distintas potencias más espejos,capacidad de viajar a través de ellos", 'H', "John Broome,Carmine Infantino,Grant Morrisonm,Chas Truog", "Samuel Joseph Scudder,Digger Harkness,Evan McCulloch", "Keystone City, Estados Unidos", "Flash,Animal Man", "Renegados,Sociedad Secreta de Supervillanos", "Humano", 1959,1989);
        SuperHeroe capitanFrio = new SuperHeroe("Len Snart, El hombre que dominó el cero absoluto , Leonard Wynters , Hombre de Hielo Azul", "Congelar objetos a cero absoluto",'H',"John Broome,Carmine Infantino","Leonard Snart","Estados Unidos","Showcase","Renegados,LexCorp", "Humano",1957);
                
        /**
         * 
         * Personajes Random
         * 
         */
        
        SuperHeroe jonahHex = new SuperHeroe("  Hex", " Armas de fuego", 'H', "Tony DeZuniga,John Albano", "Jonah Woodson Hex", "Estados Unidos", "All-Star Western", "Estados Confederados de América", "Humano", 1972);
        SuperHeroe boosterGold = new SuperHeroe("Supernova I", "volar, proyectiles de poder, campos de fuerza, fuerza mejorada",'H',"Dan Jurgens", "Michael Jon Carter", "Estados Unidos","Booster Gold", "liga de la justicia","Humano",1986);
        SuperHeroe hombreHalcon = new SuperHeroe("Hombre Halcón", "Volar,Habilidades de halcón", 'H', "Gardner Fox,Dennis Neville ", "Carter Hall,Katar Hol", " Nueva York,Estados Unidos","Flash","Sociedad de la Justicia de América","Humano",1940);
        SuperHeroe cyborg = new SuperHeroe("Cyborg", "Intelecto nivel de genio,Tecnopatía,Fuerza sobrehumana", 'H', "Marv Wolfman,George Pérez", "Victor Stone", "Estados Unidos", "DC Comics Presents", "Liga de la Justicia,S.T.A.R. Labs", "Humano", 1980);
        SuperHeroe lobo = new SuperHeroe("El Hombre, El Bo, Maestro Frag, Mister Machete, Arzobispo Lobo", "Superfuerza, resistencia,fortaleza", 'H', "Keith Giffen,Roger Slifer", "Desconocido", "Zarnia", "Omega Men", "La Primera Iglesia Celestial del Triple Dios Pez", "Extraterreste", 1983);
        SuperHeroe doctorManhattan = new SuperHeroe("Dr. Manhattan", "Control absoluto de la materia y la cuántica,manipulación del tiempo y del espacio, genio,omnisciente,omnipresente,omnipotente,crear vida,Teletransportacion,Eternidad", 'H', "Alan Moore,Dave Gibbons", "Dr. Jonathan \"Jon\" Osterman", "Estados Unidos", "Watchmen", "Crimebusters, Watchmen", "Humano", 1986);
        SuperHeroe jamesGordon = new SuperHeroe("Comisario Gordon", "Entrenamiento policial,Formación en criminología", 'H', "Bill Finger,Bob Kane,Lawrence Donovan,Henry Ralston,John Nanovic","James Worthington \"Jim\" Gordon", "Gotham City,Estados Unidos","Detective Comics,Divergence","Departamento de Policía de Gotham City","Humano",1939,2015);
        SuperHeroe shazam = new SuperHeroe("Capitán Trueno, Shazam, Capitán Marvel, Capitán Maravilla", "fuerza sobrehumana,Resistencia de Atlas,El poder de Zeus,volar,Velocidad,teletransportacion", 'H', "Clarence Charles Beck,Bill Parker", "William Joseph \"Billy\" Batson", "Estados Unidos", "Whiz Comics,DC Comics", "Familia Marvel,Liga de la Justicia,Sociedad de la Justicia de América,Escuadrón de la Justicia (Tierra S)", "Humano", 1940,1972);
        SuperHeroe detectiveMarciano = new SuperHeroe(" Detective Marciano,John Jones,Vientosangre,Fantasma de Bronce,Fernus\n,Jonh Johnstone,Marco Xavier,Mrs. Klingman,William Dyer,Dr. Erdel", "Superfuerza,Velocidad sobrehumana,Telepatía,Telekinesis,Regeneración acelerada,Intangibilidad,Invisibilidad,Cambio de forma,Volar,Visión láser,Nueve sentidos aumentados", 'H', "    Joseph Samachson,Joe Certa", "J'onn J'onzz", "Marte", "Detective Comics ", "StormWatch,Liga de la Justicia,Liga de la Justicia Internacional,Liga de la Justicia Task Force,Los Marginales", "Marciano", 1955);
        SuperHeroe flechaVerde = new SuperHeroe("Flecha Verde", "habilidad como arquero,artes marciales", 'H', "Mort Weisinger,George Papp", "Oliver Jonas Queen", "Star City,Estados Unidos", "More Fun Comics", "Liga de la Justicia", "Humano", 1941);
        SuperHeroe aquaman = new SuperHeroe("   Rey de los Siete Mares, Habitante de las Profundidades, As Acuático, Marino Maravilla", "Adaptación acuática-anfibia,Telepatía,Factor de curación,Fuerza, agilidad, destreza, velocidad, resistencia", 'H', "Mort Weisinger,Paul Norris", "Arthur Curry,Orin", "Atlántida,Estados Unidos", "More Fun Comics", "Liga de la Justicia", "Atlante,Humano",1941);
        SuperHeroe rorschach = new SuperHeroe("Rorschach", "fuerza de voluntad", 'H', "Alan Moore,Dave Gibbons", "Walter Joseph Kovacs", " Nueva Jersey,Estados Unidos", "Watchmen", "Ninguna","Humano",1986);
        SuperHeroe johnConstantine = new SuperHeroe("Constantine, constante", " Mago, Nigromancia", 'H', "Alan Moore,Stephen Bissette", "John Constantine", "Reino Unido", "The Saga of the Swamp Thing", "Liga de la Justicia Oscura", "Humano", 1985);
        
        
        /** Agregando a cada SuperHeroe al vector para guardar al archivo .obj*/
                
        SuperHeroes.add(demon);
        SuperHeroes.add(demon2);
        SuperHeroes.add(superwoman);
        SuperHeroes.add(superwoman2);
        SuperHeroes.add(deadman);
        SuperHeroes.add(adamStrange);
        SuperHeroes.add(starfire);
        SuperHeroes.add(linternaVerde);
        SuperHeroes.add(zatanna);
        SuperHeroes.add(doctorFate);
        SuperHeroes.add(espector);
        SuperHeroes.add(mera);
        SuperHeroes.add(capuchaRoja);
        SuperHeroes.add(canarioNegro);
        SuperHeroes.add(escaranajoAzul);
        SuperHeroes.add(superman);   
        SuperHeroes.add(superboy);
        SuperHeroes.add(superwoman);
        SuperHeroes.add(darkseid);
        SuperHeroes.add(lexLuthor);
        SuperHeroes.add(krypto);  
        SuperHeroes.add(brainiac);
        SuperHeroes.add(powerGirl);   
        SuperHeroes.add(streaky); 
        SuperHeroes.add(cometa);
        SuperHeroes.add(acero);
        SuperHeroes.add(volcana); 
        SuperHeroes.add(generalZod);
        SuperHeroes.add(erradicador);
        SuperHeroes.add(doomsday);
        SuperHeroes.add(batman);
        SuperHeroes.add(bluebird);
        SuperHeroes.add(batwoman);
        SuperHeroes.add(joker);
        SuperHeroes.add(pinguino);
        SuperHeroes.add(catwoman);
        SuperHeroes.add(harleyQuinn);
        SuperHeroes.add(victorFries);
        SuperHeroes.add(hiedraVenenosa);
        SuperHeroes.add(deadshot);
        SuperHeroes.add(manBat);
        SuperHeroes.add(bane);
        SuperHeroes.add(rasalGhul);
        SuperHeroes.add(flash);
        SuperHeroes.add(flash2);
        SuperHeroes.add(kidFlash);
        SuperHeroes.add(killerFrost);
        SuperHeroes.add(capitanBumerang);
        SuperHeroes.add(magneta);
        SuperHeroes.add(baronKatana);
        SuperHeroes.add(gorillaGrodd);
        SuperHeroes.add(piedPiper);
        SuperHeroes.add(mirrorMaster);
        SuperHeroes.add(capitanFrio);
        SuperHeroes.add(jonahHex);
        SuperHeroes.add(boosterGold);
        SuperHeroes.add(hombreHalcon);
        SuperHeroes.add(cyborg);
        SuperHeroes.add(lobo);
        SuperHeroes.add(doctorManhattan);
        SuperHeroes.add(jamesGordon);
        SuperHeroes.add(shazam);
        SuperHeroes.add(detectiveMarciano);
        SuperHeroes.add(flechaVerde);
        SuperHeroes.add(aquaman);
        SuperHeroes.add(rorschach);
        SuperHeroes.add(johnConstantine);
        
        return SuperHeroes;
    }  
    
}
