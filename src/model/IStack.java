package model;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface IStack {
    /**
     *
     * @param a el número que quiero apilar
     */
    void add(int a);

    /**
     * Precondición: la pila no está vacia
     * Remueve el último número
     */
    void remove();

    /**
     *
     * @return si la pila está vacia
     */
    boolean isEmpty();

    /**
     *
     * @return el úlitmo número agregado
     */
    int getTop();

}
