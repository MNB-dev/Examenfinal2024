package Utils;

import implementation.normal.PriorityQueueOriginal;
import implementation.normal.Queue;
import model.IPriorityQueue;
import model.IQueue;

public class PriorityQueueUtils {

    /**
     * Imprime la cola ordenarada por prioridad.
     * @param queue
     */
    public static void print(IPriorityQueue q) {
        IPriorityQueue pq = copyPriorityQueue(q);
        while (!pq.isEmpty()) {
            System.out.println("Valor: " + pq.getFirst() + " Prioridad: " + pq.getPriority());
            pq.remove();
        }
    }

    /**
     * Devuelve la cola.
     * @param queue
     */
    public static IQueue copy(IPriorityQueue queue) {
        IQueue copy = new Queue();
        IPriorityQueue aux = new PriorityQueueOriginal();

        while (!queue.isEmpty()) {
            aux.add(queue.getFirst(), queue.getPriority());
            copy.add(queue.getFirst());
            queue.remove();
        }
        while (!aux.isEmpty()) {
            queue.add(aux.getFirst(), aux.getPriority());
            aux.remove();
        }
        return copy;
    }

    /**
     * Devuelve la cola con prioridad.
     * @param queue
     */
    public static IPriorityQueue copyPriorityQueue(IPriorityQueue queue) {
        IPriorityQueue copy = new PriorityQueueOriginal();
        IPriorityQueue aux = new PriorityQueueOriginal();

        while (!queue.isEmpty()) {
            aux.add(queue.getFirst(), queue.getPriority());
            copy.add(queue.getFirst(), queue.getPriority());
            queue.remove();
        }
        while (!aux.isEmpty()) {
            queue.add(aux.getFirst(), aux.getPriority());
            aux.remove();
        }
        return copy;
    }

    /**
     * Obtener apariciones
     */
    public static int counter(IPriorityQueue queue, int priority) {
        IPriorityQueue copy = copyPriorityQueue(queue);
        int res = 0;

        while(!copy.isEmpty()) {
            int p = copy.getPriority();

            if(p == priority) {
                res++;
            }

            copy.remove();
        }

        return res;
    }

    /**
     * Chequear si existe la prioridad
     * @param queue
     */
    public static boolean checkIfexists(IPriorityQueue queue, int priority) {
        IPriorityQueue copy = copyPriorityQueue(queue);

        while(!copy.isEmpty()) {
            int p = copy.getPriority();

            if(p == priority) return true;
            copy.remove();
        }

        return false;

    }

    /**
     * Chequear si existe la prioridad
     * @param queue
     */
    public static int getImpar(IPriorityQueue queue) {
        IPriorityQueue copy = copyPriorityQueue(queue);

        while (!copy.isEmpty()) {
            int value = copy.getFirst();

            if (value % 2 != 0) {
                return copy.getPriority();
            }
            copy.remove();
        }

        return -1;
    }

}
