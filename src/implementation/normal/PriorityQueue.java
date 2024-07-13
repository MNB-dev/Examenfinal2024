package implementation.normal;

import model.IPriorityQueue;

/**
 * Esta implementación no acepta valores repetidos en las prioridades,
 * de lo contrario la busqueda binaria no sería válida
 */
public class PriorityQueue implements IPriorityQueue {

    private Stack values;
    private Queue priorities;
    private int count;

    public PriorityQueue() {
        this.values = new Stack();
        this.priorities = new Queue();
        this.count = 0;
    }

    @Override
    public void add(int a, int priority) {
        if (this.count == 1000) throw new RuntimeException("The queue is full.");

        // Verificar si el elemento ya existe
        Stack tempValues = new Stack();
        Queue tempPriorities = new Queue();
        boolean exists = false;

        while (!this.priorities.isEmpty()) {
            if (this.values.getTop() == a) {
                exists = true;
            }
            tempValues.add(this.values.getTop());
            tempPriorities.add(this.priorities.getFirst());
            this.values.remove();
            this.priorities.remove();
        }

        // Restaurar los elementos a las pilas originales
        while (!tempValues.isEmpty()) {
            this.values.add(tempValues.getTop());
            this.priorities.add(tempPriorities.getFirst());
            tempValues.remove();
            tempPriorities.remove();
        }

        if (exists) {
            throw new RuntimeException("Element already exists in the priority queue.");
        }

        // Inserción ordenada
        tempValues = new Stack();
        tempPriorities = new Queue();
        boolean added = false;

        while (!this.priorities.isEmpty()) {
            if (!added && priority < this.priorities.getFirst()) {
                tempValues.add(a);
                tempPriorities.add(priority);
                added = true;
            } else {
                tempValues.add(this.values.getTop());
                tempPriorities.add(this.priorities.getFirst());
                this.values.remove();
                this.priorities.remove();
            }
        }

        if (!added) {
            tempValues.add(a);
            tempPriorities.add(priority);
        }

        // Restaurar los elementos a las pilas originales
        while (!tempValues.isEmpty()) {
            this.values.add(tempValues.getTop());
            this.priorities.add(tempPriorities.getFirst());
            tempValues.remove();
            tempPriorities.remove();
        }

        this.count++;
    }

    @Override
    public void remove() { //O(n)
        if (this.isEmpty()) throw new RuntimeException("The queue is empty."); //O(C)
        this.values.remove(); // O(C) x3
        this.priorities.remove(); //O(n)
        this.count--; //O(C)
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int getFirst() {
        if (this.isEmpty()) throw new RuntimeException("The queue is empty.");
        return this.values.getTop();
    }

    @Override
    public int getPriority() {
        if (this.isEmpty()) throw new RuntimeException("The queue is empty.");
        return this.priorities.getFirst();
    }
}