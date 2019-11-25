public class ISA
{
    public static void main(String[] args) {
        LinkedListG<Animal> lla = new LinkedListG();
        
        lla.add(new Animal("celular"  ,"La cotorra"));
        lla.add(new Animal("brillante","La llama"));
        lla.add(new Animal("filemon"  ,"El burro"));
        lla.add(new Animal("relampago","El caballo"));
        lla.add(new Animal("piquetito","El zancudo"));
        
        lla.traverseF();
        
        lla.traverseW();
        
        lla.iterador();
        
        System.out.println("El primer elemento es: " + lla.get(0));
        System.out.println("El quinto elemento es: " + lla.get(5));
        System.out.println("El sexto  elemento es: " + lla.get(6));
    }
}
