import Utils.MultipleDictionaryUtils;
import Utils.PriorityQueueUtils;
import Utils.StackUtils;
import implementation.normal.*;
import model.*;
import model.IDictionary;

public class Main {
    public static void main(String[] args) {
        //Ejercicio1A();
        //Ejercicio2A();
        Ejercicio2B();
        //Ejercicio3B();
    }

    /**
     * Ejercicio 1 A
     */
    public static void Ejercicio1A() {
        IPriorityQueue pq = new PriorityQueue();
        pq.add(2, 22);
        pq.add(3, 33);
        pq.add(7, 77);
        pq.add(1, 11);
        pq.add(4, 444);
        pq.add(41, 1);
        PriorityQueueUtils.print(pq);
    }

    /**
     * Ejercicio 1 B
     * Desarrolo en la implementación
     * Complejidad: O(n)
     */

    /**
     * Ejercicio 2 B
     * Complejidad: O(n log n)
     */
    public static void Ejercicio2B() {
        int[] elementos = new int[]{3, 1, 3, 2, 1, 2, 5, 2, 2, 5};
        IStack stack = new Stack();
        for (int i = 0; i < elementos.length; i++) {
            stack.add(elementos[i]);
        }

        IPriorityQueue pq = new PriorityQueueOriginal();

        while (!stack.isEmpty()) {
            int candidate = stack.getTop();
            pq.add(1, candidate);
            stack.remove();
        }

        IPriorityQueue res = new PriorityQueueOriginal();

        while (!pq.isEmpty()) {
            int currentPriority = pq.getPriority();
            int count = 0;

            while (!pq.isEmpty() && pq.getPriority() == currentPriority) {
                pq.remove();
                count++;
            }

            res.add(count, currentPriority);
        }

        System.out.printf("Valor impar: " + PriorityQueueUtils.getImpar(res));
    }

    /**
     * Ejercicio 3 A
     * La data se guarda en nodos que tienen un solo ítem y una referencia al siguiente nodo.
     * Es basicamente una cadena en la que hay que recorrer entera para llegar al final ya que no se puede saltar
     * del primer nodo al quinto, sin pasar por el segundo, tercero y cuarto.
     * Por este motivo, la diferencia entre almacenar la referencia al tope vs al ultimo, es la eficiencia
     * que tienen los metodos al tratar con uno o con el otro. Trabajar con la referencia al ultimo es más eficiente
     * y rápido.
     */

    /**
     * Ejercicio 3 B
     * Explicación:
     * f() busca los primeros 3, g() ordena.
     * Si primero va f(), entonces g() no depende del tamaño del input por lo que se vuelve constante O(C).
     * De lo contrario, si va a depender del tamaño por lo que será O(N)
     */
    public static void Ejercicio3B() {
        int[] elementos = new int[]{3, 1, 2, 7, 2, 99};
        IStack stack = new Stack();
        for (int i = 0; i < elementos.length; i++) {
            stack.add(elementos[i]);
        }

        IStack fs = f(stack); //O(C)
        g(fs); //O(C) porque el tamaño del input se vuelve constante
        //Resultado: O(C)

        IStack gs = g(stack); //O(N)
        f(gs); //O(C)
        //Resultado: O(N)
    }

    /**
     * Obtener solo los primeros 3 valores
     * @param s
     * @return
     */
    private static IStack f(IStack s) {
        IStack copy = StackUtils.copyOrignal(s);
        IStack stack = new Stack();
        for (int i = 0; i < 3; i++) {
            stack.add(copy.getTop());
            copy.remove();
        }
        return stack;
    }

    /**
     * Ordenar pila
     */
    private static IStack g(IStack s) {
        IStack copy = StackUtils.copyOrignal(s);
        IStack stack = new Stack();
        IPriorityQueue pq = new PriorityQueueOriginal();

        while (!copy.isEmpty()) {
            int candidate = copy.getTop();
            pq.add(candidate, candidate);

            copy.remove();
        }

        while(!pq.isEmpty()) {
            int value = pq.getPriority();
            stack.add(value);
            pq.remove();
        }

        return stack;
    }
}