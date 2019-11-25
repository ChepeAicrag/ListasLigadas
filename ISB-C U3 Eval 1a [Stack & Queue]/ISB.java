public class ISB
{
    static Stack<Animal> sA = new Stack<Animal>();
    static Stack<Animal> sC = new Stack<Animal>();
    
    static private Stack<Animal> copiarS() {
        Stack<Animal> sB = new Stack();
        Stack<Animal> sC = new Stack();
        /** crear dos Stack con los datos de la Stack original */
        for (Animal i : sA) {
            sB.push(sA.pop());
        }
        
        /** poner los datos LIFO en los Stack original y copia */
        for (Animal i : sB) {
            Animal a = sB.pop();
            sA.push(a);
            sC.push(a);
        }
        
        return sC;
    }
    
    static private boolean buscarenS(String a) {
        boolean encontrado = false;
        for (Animal i : sC) {
            Animal s = sC.pop();
            if (s.getNombre().equalsIgnoreCase(a)) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }
    
    static private Queue<Animal> Stack2Queue() {
        Queue<Animal> q = new Queue();
        for (Animal a : sC) {
            q.enqueue(sC.pop());
        }
        return q;
    }
    
    public static void main(String[] args) {
        /** llenar la Stack */
        sA.push(new Animal("paquito"));
        sA.push(new Animal("tommy"));
        sA.push(new Animal("barbie"));
        sA.push(new Animal("lencho"));
        
        sC = copiarS();
        System.out.println("sA = " + sA);
        System.out.println("sC = " + sC);
        System.out.println();
        
        System.out.println((buscarenS("barbie")) ? "barbie esta en la pila"
                                                 : "barbie NO ha llegado");
        
        System.out.println((buscarenS("piolin")) ? "piolin esta en la pila"
                                                 : "piolin NO ha llegado");
        System.out.println();
        
        sC = copiarS();
        Queue<Animal> q = Stack2Queue();
        System.out.println("sA = " + sA);
        System.out.println("q  = " + q);
        System.out.println();
    }
}
