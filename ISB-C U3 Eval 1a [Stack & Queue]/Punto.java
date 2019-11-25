public class Punto implements Cloneable {
    private int x;
    private int y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Punto() {
        x=0;
        y=0;
    }

    public Punto clone() throws CloneNotSupportedException{
         Punto clonmalefico = (Punto) super.clone();
         return clonmalefico;
    }

    public String toString(){
        String texto="origen: ("+x+", "+y+")";
        return texto;
    }
}
