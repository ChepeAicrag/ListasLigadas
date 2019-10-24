
public class Test01
{
    public static void main(){
        LinkedListPlusRecursividadGenerico <SuperHeroe> lista = new LinkedListPlusRecursividadGenerico() ;
        CreacionSuperHeroes.llenarSuperHeroes(lista);
        /**Mostrar la lista*/
        lista.imprimirNormal();
        
        /**Buscando quien está antes de Batman*/
        SuperHeroe batman = new SuperHeroe("Batman", "ser rico",'H');
        StdOut.println("\" Batman \" está despues de \n " 
                        + lista.getInfo(lista.AntesDe(batman)));
        StdOut.println("\" Batman \" está antes de  \n " 
                        + lista.getInfo(lista.DespuesDe(batman)));
        
        SuperHeroe superman       = new SuperHeroe("Spiderman","super fuerza, velocidad",'H');
        
        StdOut.println("\" Superman \" está despues de \n " 
                        + lista.getInfo(lista.AntesDe(superman)));
        StdOut.println("\" Superman \" está antes de  \n " 
                        + lista.getInfo(lista.DespuesDe(superman)));
        
        SuperHeroe atomo = new SuperHeroe("Atomo","reducir su cuerpo",'H');
        
        StdOut.println("Buscando a \" Atomo \" \n " 
                        + lista.Buscar(atomo));
        
        StdOut.println("Buscando a superhores con poder de \" reducir su cuerpo \" \n "); 
        lista.listaPoderTal("reducir su cuerpo").imprimirNormal();
        
        StdOut.println("Buscando a los superheroes \" Hombre \" \n ");
        lista.listaSexoTal('H').imprimirNormal();
        
        StdOut.println("Buscando a los superheroes \" Mujer \" \n ");
        lista.listaSexoTal('M').imprimirNormal();
        
    }
    
    
}