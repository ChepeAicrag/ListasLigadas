

public class TestPila
{
    public static void main(){
        Pila pila = new Pila();
        pila.push("a");
        pila.push("b");
        pila.push("c");
        pila.mostrar();
        
        Pila pila2 = new Pila();
        pila2.push2("a");
        pila2.push2("b");
        pila2.push2("c");
        pila2.mostrar();
    }
}
