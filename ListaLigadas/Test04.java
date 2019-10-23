public class Test04
{
   public static void main(){
        LinkedListPlusRecursividadGenerico <String> lista = new LinkedListPlusRecursividadGenerico();
        String x = "Prueba de busqueda";
        for(int i = 0; i < x.length() - 1; i++)
            lista.insertarPrimero("" + x.charAt(i));
        
        lista.imprimirNormal();
        lista.imprimirInversa();
        StdOut.println("\nLa cabeza es " + lista.getInfo(lista.getRaiz()));
       
        StdOut.println("\nAntes de \"r\" está : \n" + lista.getInfo(lista.BuscarAntesDe("r")));
        StdOut.println("Antes de \"u\" está : \n" + lista.getInfo(lista.BuscarAntesDe("u")));
        StdOut.println("Antes de \"e\" está : \n" + lista.getInfo(lista.BuscarAntesDe("e")));
        StdOut.println("Antes de \"b\" está : \n" + lista.getInfo(lista.BuscarAntesDe("b")));
        StdOut.println("Antes de \"a\" está : \n" + lista.getInfo(lista.BuscarAntesDe("a")));
        StdOut.println("Antes de \"e\" está : \n" + lista.getInfo(lista.BuscarAntesDe("e")));
        StdOut.println("Antes de \"de\" está : \n" + lista.getInfo(lista.BuscarAntesDe("de")));
        StdOut.println("Antes de \"ba\" está : \n" + lista.getInfo(lista.BuscarAntesDe("ba")));
    }
}
