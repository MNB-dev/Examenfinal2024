package Utils;

import implementation.normal.Stack;
import model.IStack;

public class StackUtils {

    public static void print(IStack stack) {
        IStack copy = copy(stack);
        while (!copy.isEmpty()) {
            System.out.println(copy.getTop());
            copy.remove();
        }
    }


    /**
     * Copia y devuelve original
     *
     * @param stack
     * @return devuelve la pila invertida
     */
    public static IStack copyOrignal(IStack stack) {
        IStack copy = new Stack();
        IStack aux = new Stack();

        while (!stack.isEmpty()) {
            copy.add(stack.getTop());
            aux.add(stack.getTop());
            stack.remove();
        }

        while (!copy.isEmpty()) {
            stack.add(copy.getTop());
            copy.remove();
        }
        return aux;
    }

    /**
     * Devuelve copia invertida a la ingresada originalmente en Main.
     *
     * @param stack
     * @return devuelve la pila invertida
     */
    public static IStack copy(IStack stack) {
        IStack copy = new Stack();
        IStack aux = new Stack();

        while (!stack.isEmpty()) {
            copy.add(stack.getTop());
            aux.add(stack.getTop());
            stack.remove();
        }

        while (!copy.isEmpty()) {
            stack.add(copy.getTop());
            copy.remove();
        }

        while (!aux.isEmpty()) {
            copy.add(aux.getTop());
            aux.remove();
        }

        return copy;
    }

    /**
     *
     * @param stack
     * @return pila original
     */
    public static IStack copyAndEmptyOriginal(IStack stack) {
        IStack aux = new Stack();

        while (!stack.isEmpty()) {
            aux.add(stack.getTop());
            stack.remove();
        }

        return aux;
    }

}
