public class ClonarPunto
{
    public static void main(String[]args){
        Punto punto1 = new Punto(3,4);
        Punto copia=null;
        try {
            copia = punto1.clone();
        } catch(CloneNotSupportedException cnse) {
            System.out.println("No se puede clonar");
        }

        System.out.println(punto1.toString());
        System.out.println(copia.toString());
    }
}
