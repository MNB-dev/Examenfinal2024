package model;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface IQueue {

    /**
     * Postcondicion: Acola (coloca en el final de la cola) un valor.
     *
     * @param a valor a acolar.
     */
    void add(int a);

    /**
     * Precondicion: La cola no esta vacia.
     * Postcondicion: Desacola (quita el primer elemento).
     */
    void remove();

    /**
     * @return true si la cola esta vacia, false en otro caso.
     */
    boolean isEmpty();

    /**
     * @return Devuelve el primero.
     */
    int getFirst();

}
