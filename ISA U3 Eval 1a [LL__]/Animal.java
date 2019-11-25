public class Animal
{
    private String nombre;
    private String especie;

    public Animal(String n, String e) {
        nombre  = n;
        especie = e;
    }

    public String toString() {
        return especie + " \"" + nombre + "\"";
    }
    
    public String getNombre() {
        return nombre;
    }
}
