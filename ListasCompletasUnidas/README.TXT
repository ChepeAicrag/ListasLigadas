------------------------------------------------------------------------
Estructura de Datos
Unidad III : Estructuras Dinamicas
------------------------------------------------------------------------

PROJECT TITLE: PRACTICA 1
PURPOSE OF PROJECT: Realizar un proyecto con superheroes, implementando la estructrua dinamica lista.
VERSION or DATE: 09/11/2019
HOW TO START THIS PROJECT: 1.0
AUTHORS: García García José Ángel 


    *** El programa que realice basicamente realiza busquedas y elimina superheroes de la lista, algunos métodos retornan una nueva lista ya modificada, en otros casos modifica a la misma
        lista sin retornar nada. 
        Apliqué el conocimiento adquirido a lo largo de este curso, como es el uso de elipsis,la implementacion del TDA String y el uso de Interface.
       
    *** Para hacer herencia de las listas, utilice una interface,para así llenar las listas desde la clase archivito. Por lo tanto, todas las listas tienen la mayoria de metodos iguales,
        lo que cambia es la implementación de esta, tambien decidí usarlo para aprender más sobre este tipo de herencia. 
        
    *** Están algunos test en el proyecto, en cada una de las clases se explica que hace cada una, son test sencillos para no hacer complicado el analisis de las funciones, además creo que 
        son bastantes claras las funciones.
    
    *** Las clases de las listas, tienen comentado lo que realiza cada método que se encuentra en ella, por lo que será entendible analizar las funciones de la lista.
    
    *** La clase CreacionSuperHeroes como su nombre lo dice, solo funciona para crear a los superhereos y así poder guardarlos en el archivo, hace una pequeña clasificación de los comic de DC
        al que pertenecen, para crearlos tuve que investigar sobre los mismos y al observar que eran muchos, decidí escoger a los mas importantes o más conocidos.
     
    *** La clase SuperHeroe si está algo cargado de atributos, pero los vi necesarios para representar a un superheroe, aquí es donde aplique elipsis
        al momento de establecer los n años en los que aparece el superheroe.
   
    *** La clase de la lista circular, fue creada por mí, desde 0, ya que no nos proporciono esta lista, la otras listas fueron tomadas de las que 
        usted nos dio, posteriormente les agregue los métodos de busqueda y de eliminar.
    
    *** Por ultimo, la clase nodo, es de forma general, ya que la utilizo en las tres listas, no tiene nada de especial pero es de mucha ayuda para poder trabajar con las listas.    
        

    ***     // NOTA IMPORTANTE //  ***
   
    *** Para probar el programar, primero debe ejecutar el Test00, ya que ahí se crea el archivo formato .obj que contiene a todos los superheroes, que es el archivo principal de donde se 
        basan las demas listas, tambien esto permite hacer la ejecucción de los demas test sin problemas.