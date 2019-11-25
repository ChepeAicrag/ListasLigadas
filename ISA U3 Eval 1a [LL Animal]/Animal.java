public class Animal
{
    private int    clave;
    private String especie;
    private String raza;
    private String nombre;
    private String sexo;

    public Animal(int c, String e, String r, String n, String s) {
        clave   = c;
        especie = e;
        raza    = r;
        nombre  = n;
        sexo    = s.toUpperCase();
    }

    public String getNombre() {
        return nombre;
    }
    
    public String toString() {
        return String.format("%3d %-15s %-15s %-15s %1s",clave,especie,raza,nombre,sexo);
    }
}
