public class ISAA
{
    /** primer nodo de la lista */
    static Node<Animal> nodo;
    
    /** metodo para buscar especificamente un Animal
     *  para poder usar el metodo getNombre() del objeto
     *  Animal (solo conocido en tiempo de ejecucion)
     */
    static private Animal getItem(String item) {
        Node<Animal> n = nodo;
        while (nodo != null) {
            Animal a = nodo.e;
            String s = a.getNombre();
            if (item.equalsIgnoreCase(s))
                return a;
            nodo = nodo.next;
        }
        return null;
    }
    
    public static void main(String[] args) {
        /** objeto lista ligada */
        LinkedListGG<Animal> lla = new LinkedListGG();
        
        /** nodos de la lista ligada */
        lla.add(new Animal("celular"  ,"La cotorra"));
        lla.add(new Animal("brillante","La llama"));
        lla.add(new Animal("filemon"  ,"El burro"));
        lla.add(new Animal("relampago","El caballo"));
        lla.add(new Animal("piquetito","El zancudo"));
        
        /** recorrido de la lista usando un for clasico */
        System.out.println("recorrido de la lista usando un for clasico");
        lla.traverseF();
        System.out.println();
        
        /** recorrido de la lista usando un ciclo while */
        System.out.println("recorrido de la lista usando un ciclo while");
        lla.traverseW();
        System.out.println();
        
        /** recorrido de la lista usando un iterador */
        System.out.println("recorrido de la lista usando un iterador");
        lla.iterador();
        System.out.println();
        
        /** busqueda de animales usando el get(# de nodo) */
        System.out.println("busqueda de animales usando el get(# de nodo)");
        System.out.println("El primer elemento es: " + lla.get(1));
        System.out.println("El quinto elemento es: " + lla.get(5));
        System.out.println("El sexto  elemento es: " + lla.get(6));
        System.out.println();
        
        /** recuperando la direccion del nodo head de la lista */
        nodo = lla.getNode();
        
        /** busqueda de un animal usando getItem("nombre") */
        System.out.println("busqueda de un animal usando getItem(\"nombre\")");
        System.out.println("buscando a filemon -> " + getItem("filemon"));
        System.out.println("buscando a rayito -> " + getItem("rayito"));
    }
}
