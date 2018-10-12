package Lista;

import java.util.Iterator;

public class ListaDinamica<T> implements Iterable<T>{

    //Atributos
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int longitud;

    public ListaDinamica() {
        primero = null;
        ultimo = null;
        longitud = 0;
    }

    public boolean listVacia() {
        return longitud == 0;
    }

    public int tamaño() {
        return longitud;
    }

    public T buscador(int index) {

        //si esta vacio o el indice no es correcto, devuelve null
        if (listVacia() || (index < 0 || index >= tamaño())) {
            return null;
        } else if (index == 0) {
            return getElementos(); //Cojo el primero
        } else if (index == tamaño() - 1) {
            return getUltimo(); //Cojo el ultimo
        } else {

            //Uso la funcion getNode para coger el nodo deseado
            Nodo<T> buscado = getNodo(index);

            return buscado.getElemento();
        }
    }

    public T getElementos() {
        //Si esta vacia, no hay primero que coger
        if (listVacia()) {
            return null;
        } else {
            return primero.getElemento();
        }
    }

    public T getUltimo() {
        if (listVacia()) {
            return null;
        } else {
            return ultimo.getElemento();
        }
    }

    private Nodo<T> getNodo(int index) {

        //si esta vacio o el indice no es correcto, devuelve null
        if (listVacia() || (index < 0 || index >= tamaño())) {
            return null;
        } else if (index == 0) {
            return primero; //devuelvo el primero
        } else if (index == tamaño() - 1) {
            return ultimo; //devuelvo el ultimo
        } else {

            Nodo<T> buscado = primero;

            //Busco el nodo deseado con un recorrido
            int contador = 0;
            while (contador < index) {
                contador++;
                buscado = buscado.getSiguiente();
            }
            return buscado;
        }
    }

   
    public T addFinal_list(T elemento) {

        Nodo<T> aux;

        if (listVacia()) {
            return addPrincipio(elemento);
        } else {
            aux = new Nodo<>(elemento, null);

            ultimo.setSiguiente(aux);
            ultimo = aux;
        }
        longitud++;
        return ultimo.getElemento();
    }

    public T addPrincipio(T elemento) {

        Nodo<T> aux;
      
        if (listVacia()) {
            aux = new Nodo<>(elemento, null);
            primero = aux;
            ultimo = aux;
        } else {
            Nodo<T> primeroActual = primero;
            aux = new Nodo<>(elemento, primeroActual);
            primero = aux;
        }
        longitud++;
        return primero.getElemento();

    }

    public T addPosition(T elemento, int index) {

        
        if (index == 0) {
            return addPrincipio(elemento); 
        } else if (index == tamaño()) {
            return addFinal_list(elemento); 
        } else if ((index < 0 || index >= tamaño())) {
            return null;
        } else {

            Nodo<T> buscado_anterior = getNodo(index - 1);

            Nodo<T> buscado_actual = getNodo(index);

            Nodo<T> aux = new Nodo<>(elemento, buscado_actual);
 
            buscado_anterior.setSiguiente(aux);

            longitud++;
            return getNodo(index).getElemento();
        }
    }

    /**
     * Devuelve el estado de la lista
     *
     * @return
     */
    public String toString() {
        
        String contenido = "";
        
        //Si esta vacia, lo indica
        if (listVacia()) {
            contenido = "Lista vacia";
        } else {
            Nodo<T> aux = primero;
            //Recorre la lista, mostrando el contenido
            while (aux != null) {
                contenido += aux.toString();
                aux = aux.getSiguiente();
            }
        }
        return contenido;
    }

    
    public boolean exists(T elemento) {

        //Si esta vacio, devuelve el false
        if (listVacia()) {
            return false;
        } else {
            Nodo<T> aux = primero;
            //Recorremos la lista
            while (aux != null) {
                if (elemento.equals(aux.getElemento())) { //Mejor .equals que ==
                    return true; //Existe
                }
                aux = aux.getSiguiente();
            }
            return false;
        }
    }

    public int posicionPuntero(T elemento) {
        if (listVacia()) {
            return -1;
        } else {

            Nodo<T> aux = primero;

            int posicion = 0;
            while (aux != null) {
                if (elemento.equals(aux.getElemento())) { 
                    return posicion; 
                }
                posicion++;
                aux = aux.getSiguiente();
            }

            return -1;
        }
    }

    public T removeFirst() {

        if (listVacia()) {
            return null;
        } else {

           
            T elemento = primero.getElemento();

            Nodo<T> aux = primero.getSiguiente();
            primero = null; 
            primero = aux; 

            if (tamaño() == 1) {
                ultimo = null;
            }
            longitud--;
            return elemento;
        }
    }

    public T removeLast() {

        if (listVacia()) {
            return null;
        } else {
            T elemento = ultimo.getElemento();

            Nodo<T> aux = getNodo(tamaño() - 2);

            if (aux == null) {

                ultimo = null;
                if (tamaño() == 2) {
                    ultimo = primero;
                } else {
                    primero = null;
                }

            } else {
                ultimo = null;
                ultimo = aux;
                ultimo.setSiguiente(null);
            }
            longitud--;
            return elemento;
        }
    }

    public T remove(int index) {
        if (listVacia() || (index < 0 || index >= tamaño())) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == tamaño() - 1) {
            return removeLast();
        } else {

            Nodo<T> nodo_anterior = getNodo(index - 1);

            Nodo<T> nodo_actual = getNodo(index);

            T elemento = nodo_actual.getElemento();

            Nodo<T> nodo_siguiente = nodo_actual.getSiguiente();

            nodo_actual = null;
            nodo_anterior.setSiguiente(nodo_siguiente);
            longitud--;
            return elemento;

        }
    }

    public T modify(T elemento, int index) {
        if (listVacia() || (index < 0 || index >= tamaño())) {
            return null;
        } else {
            Nodo<T> aux = getNodo(index);
            aux.setElemento(elemento);
            return aux.getElemento();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }
    //Creo la clase interna MyIterator, que implementa la interfaz Iterator
    private class MyIterator<ListaDinamica> implements Iterator<T>{

        //Indica el siguiente elemento que se va a devolver 
        private int siguiente;
        
        //Indica si hay un elemento
        @Override
        public boolean hasNext() {
            return getNodo(siguiente)!=null;
        }

        //Devuelve el elemento actual e incrementa al siguiente
        @Override
        public T next() {
            T elemento = getNodo(siguiente).getElemento();
            siguiente++;
            return elemento;
        }       
    }
}
