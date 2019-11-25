------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE:
PURPOSE OF PROJECT:
VERSION or DATE:
HOW TO START THIS PROJECT:
AUTHORS:
USER INSTRUCTIONS:

Con respecto a la interface Clonable:

Primero que nada, tener cuidado al utilizar la interface Cloneable,
puesto que se considera técnicamente rota y que provee más problemas
que beneficios, tal como lo explica Joshua Bloch, uno de los
diseñadores del lenguaje Java, en su libro Effective Java.

Hay algunos problemas de diseño, siendo el más grande que la interface
Cloneable no tiene un método clone. Y eso significa que simplemente no
funciona: haciendo algo Cloneable no dice nada sobre qué puedes hacer
con ello. En su lugar, dice algo sobre lo que puede hacer internamente.

(...)

El método clone de la clase Object es muy tramposo. Se basa en copiar
campos, y es "extra-lingüístico". Crea un objeto sin llamar a un
constructor. No hay garantía de que preserve los invariantes establecidos
por los constructores. (...) El clon generalmente comparte estado con
el objeto que es clonado. Si ese estado es mutable, no tienes dos objetos
independientes. Si modificas uno, el otro cambia también.

(...)

Es una lástima que Cloneable esté roto, pero sucede. Las APIs originales
de Java fueron hechas muy rápidamente bajo una fecha de plazo muy estrecha
para alcanzar un intervalo próximo de mercado. (...) Cloneable es un
punto débil, y pienso que las personas deben ser conscientes de sus
limitaciones.

Por ende, el uso de la interface Cloneable debe ser evitado en su mayoría
de veces.

para mayor referencia: https://es.stackoverflow.com/questions/8495/duplicacion-de-objetos-en-java
