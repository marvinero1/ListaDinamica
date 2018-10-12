package Lista;

import java.util.Iterator;
 
public class main {
 
    public static void main(String[] args) {
        
        //Version 1.0
         
        ListaDinamica<Integer> lista = new ListaDinamica<>();
         
        //Añadimos elementos, recordar que devuelve el elemento
        System.out.println("Añadido el elemento "+lista.addPrincipio(1));
        System.out.println("Añadido el elemento "+lista.addPrincipio(2));
        System.out.println("Añadido el elemento "+lista.addPrincipio(3));
        System.out.println("Añadido el elemento "+lista.addPrincipio(4));
        System.out.println("Añadido el elemento "+lista.addFinal_list(9));
        System.out.println("Añadido el elemento "+lista.addPrincipio(5));
        System.out.println("Añadido el elemento "+lista.addPosition(6, 5));
        System.out.println("Añadido el elemento "+lista.addPosition(8, 4));
       
         
        System.out.println("");
        System.out.println("Estado de la lista");
        System.out.println(lista.toString());
         
       
        System.out.println("Elemento de la posicion 1: "+lista.buscador(1));
         
        
        System.out.println("Elemento de la posicion 5: "+lista.buscador(5));
         
        
        System.out.println("Elemento de la primera posicion: "+lista.getElementos());
         
        
        System.out.println("Elemento de la ultima posicion: "+lista.getUltimo());
         
         
        System.out.println("Borrado el primer elemento "+lista.removeFirst());
        System.out.println("Borrado el elemento de la tercera posicion "+lista.remove(2));
        System.out.println("Borrado el primer elemento "+lista.removeFirst());
        System.out.println("Borrado el elemento de la sexta posicion "+lista.remove(5));
        System.out.println("Borrado el elemento "+lista.removeLast());
         
      
        System.out.println("");
        System.out.println("Estado de la lista");
        System.out.println(lista.toString());
         
        
        System.out.println("¿Existe el elemento 2? "+lista.exists(2));
         
        
        System.out.println("¿Existe el elemento 2? "+lista.exists(10));
         
       
        System.out.println("Posicion del elemento 2: "+lista.posicionPuntero(2));
         
        //Posicicon -1, no existe
        System.out.println("Posicion del elemento 10: "+lista.posicionPuntero(10));
         
        //Elemento modificado
        lista.modify(10, 0);
        
        System.out.println("");
        System.out.println("Estado de la lista");
        System.out.println(lista.toString());       
    }
 
}