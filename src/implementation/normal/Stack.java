package implementation.normal;

import model.IStack;

public class Stack implements IStack {

    private int[] stack;

    private int count = 0;

    private static final int LENGTH = 1000;

    public Stack () {
        this.stack = new int[LENGTH]; //aplicacion estática sobre el uso de la memoria.
    }

    @Override
    public void add(int a) {
        if(this.count == this.LENGTH) throw new RuntimeException("The stack is full.");
        this.stack[this.count] = a;
        this.count++;
    }

    @Override
    public void remove() {
        if(this.isEmpty()) throw new RuntimeException("The stack is empty"); //O(C)
        this.stack[count - 1] = 0; //O(C)
        this.count--; //O(C)
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int getTop() {
        if(this.isEmpty()) throw new RuntimeException("The stack is empty");
        return this.stack[this.count - 1];
    }

}
