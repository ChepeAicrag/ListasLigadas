public class LinkedList
{ 
    Node head;
    
    static class Node { 
        Animal  data; 
        Node    next; 

        Node(Animal d) { 
            data = d; 
            next = null; 
        } 
    } 

    private static LinkedList insert(LinkedList list, Animal data) { 
        Node new_node = new Node(data); 
        new_node.next = null; 

        if (list.head == null) { 
            list.head = new_node; 
        } 
        else { 
            Node last = list.head; 
            while (last.next != null) { 
                last = last.next; 
            } 
            last.next = new_node; 
        } 
        return list; 
    } 

    private static void printList(LinkedList list) 
    { 
        System.out.println("\nLinkedList: "); 
        Node currNode = list.head;
        while (currNode != null) { 
            System.out.println(currNode.data); 
            currNode = currNode.next; 
        } 
        System.out.println(); 
    }
    
    /** ************************************************************************ */
    
    /** metodos para buscar un Animal por nombre */
    
    static private Animal getWhile(LinkedList list, String key) {
        Node currNode = list.head;
        
        while (currNode != null) {
            if (currNode.data.getNombre().equalsIgnoreCase(key)) {
                return currNode.data;
            }
            currNode = currNode.next;
        }
        return null;
    }
    
    /** for-each solo aplicable a una estructura iterable 
    static private Animal getForEach(LinkedList list, String key) {
        for (Animal a : list)
            if (a.getNombre().equalsIgnoreCase(key))
                return a;        
        return null;
    }
    */
   
    /** se requiere implementar las interface Iterable e Iterator
    static private Animal getIterator(LinkedList list, String key) {
        Iterator it = list.iterator();
        while (it.hasNext) {
            Animal a = it.next.getNombre();
            if (a.equalsIgnoreCase(key))
                return a;
        }
        return null;
    }
    */
   
    static private Animal getRecursivo(String key, Node nodo) {
        if (nodo == null) return null;
        
        if (nodo.data.getNombre().equalsIgnoreCase(key))
            return nodo.data;
        else
            return getRecursivo(key, nodo.next);
    }
   
    private static LinkedList deleteByKey(LinkedList list, String key) 
    { 
        Node currNode = list.head, prev = null;
        
        /** CASO 1:  si el nodo head es el que se elimina */

        if (currNode != null && currNode.data.getNombre().equalsIgnoreCase(key)) { 
            list.head = currNode.next;
            System.out.println(key + " encontrado y eliminado"); 
            return list; 
        } 

        /** CASO 2: si el nodo a eliminar es cualquier otro */
        
        while (currNode != null && !currNode.data.getNombre().equalsIgnoreCase(key)) { 
            prev     = currNode; 
            currNode = currNode.next; 
        } 

        if (currNode != null) { 
            prev.next = currNode.next; 
            System.out.println(key + " encontrado y eliminado"); 
        } 

        /** CASO 3: el nodo no existe */
        
        if (currNode == null) { 
            System.out.println(key + " no encontrado"); 
        } 
        return list; 
    } 

    private static LinkedList deleteAtPosition(LinkedList list, int index) 
    { 
        Node currNode = list.head, prev = null; 

        /** CASO 1: si el index es 0, se elimina el nodo head */
        
        if (index == 0 && currNode != null) { 
            list.head = currNode.next; 
            System.out.println("nodo " + index + " eliminado"); 
            return list; 
        } 

        /** CASO 2: si el index es > 0 y < que el tamaño de la lista */
        
        int counter = 0; 

        while (currNode != null) { 
            if (counter == index) { 
                prev.next = currNode.next; 
                System.out.println("nodo " + index + " eliminado"); 
                break; 
            } 
            else { 
                prev = currNode; 
                currNode = currNode.next; 
                counter++; 
            } 
        } 

        /** CASO 3: el index > que el tamaño de la liga */
        
        if (currNode == null) { 
            System.out.println("nodo " + index + " no encontrado"); 
        } 
        return list; 
    } 

    public static void main(String[] args) { 
        LinkedList list = new LinkedList(); 

        list = insert(list, new Animal(1,"Leonidos","Leon Melenudo","Nala","h")); 
        list = insert(list, new Animal(2,"Tigroides","Tigre Malasia","Toño","m")); 
        list = insert(list, new Animal(3,"Quelonios","Xicotea","Speedy","m")); 
        list = insert(list, new Animal(4,"Canidos","Perro boxer","Timborin","m")); 
        list = insert(list, new Animal(5,"Equinos","Caballo","Bucefalo","m")); 
        list = insert(list, new Animal(6,"Equinos","Cebra","Rayitas","h")); 
        list = insert(list, new Animal(7,"Aracnidos","Tarantula","Jefa","h")); 
        list = insert(list, new Animal(8,"Aves","Gaviota","Peña","h")); 
        printList(list); 

        System.out.println("Busqueda de un Animal x nombre usando While:");
        System.out.println("Timborin -> " + getWhile(list, "Timborin"));
        System.out.println("Mapacha  -> " + getWhile(list, "Mapacha"));
        System.out.println();
        
        System.out.println("Busqueda de un Animal x nombre recursivamante:");
        System.out.println("Timborin -> " + getRecursivo("Timborin", list.head));
        System.out.println("Mapacha  -> " + getRecursivo("Mapacha",  list.head));
        /**
        deleteByKey(list, "Nala"); 
        printList(list); 

        deleteByKey(list, "Timborin"); 
        printList(list); 

        deleteByKey(list, "Mapacha"); 
        printList(list); 

        deleteAtPosition(list, 0); 
        printList(list); 

        deleteAtPosition(list, 2); 
        printList(list); 

        deleteAtPosition(list, 10); 
        printList(list);
        */
    } 
} 
