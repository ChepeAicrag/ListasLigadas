public class ISC
{
    static Queue<Animal> qA = new Queue<Animal>();
    static Queue<Animal> qC = new Queue<Animal>();
    
    static private Queue<Animal> copiarQ() {
        Queue<Animal> qB = new Queue();
        Queue<Animal> qC = new Queue();
        /** crear dos Queue con los datos de la Queue original */
        for (Animal i : qA) {
            Animal a = qA.dequeue();
            qB.enqueue(a);
            qC.enqueue(a);
        }
        
        /** regresar los datos a la Queue original */
        for (Animal i : qB) {
            qA.enqueue(qB.dequeue());
        }
        
        return qC;
    }
    
    static private boolean buscarenQ(String a) {
        boolean encontrado = false;
        for (Animal i : qC) {
            Animal s = qC.dequeue();
            if (s.getNombre().equalsIgnoreCase(a)) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }
    
    static private Stack<Animal> queue2stack() {
        Stack<Animal> s = new Stack();
        for (Animal a : qC) {
            s.push(qC.dequeue());
        }
        return s;
    }
    
    public static void main(String[] args) {
        /** llenar la Queue */
        qA.enqueue(new Animal("paquito"));
        qA.enqueue(new Animal("tommy"));
        qA.enqueue(new Animal("barbie"));
        qA.enqueue(new Animal("lencho"));
        
        qC = copiarQ();
        System.out.println("qA = " + qA);
        System.out.println("qC = " + qC);
        System.out.println();
        
        System.out.println((buscarenQ("barbie")) ? "barbie esta en la cola"
                                                 : "barbie NO ha llegado");
        
        System.out.println((buscarenQ("piolin")) ? "piolin esta en la cola"
                                                 : "piolin NO ha llegado");
        System.out.println();
        
        qC = copiarQ();
        Stack<Animal> s = queue2stack();
        System.out.println("qA = " + qA);
        System.out.println("s  = " + s);
        System.out.println();
    }
}
