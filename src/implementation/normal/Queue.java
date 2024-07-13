package implementation.normal;

import model.IQueue;

public class Queue implements IQueue {

    private final int[] array;
    private int count;
    private static final int LENGTH = 1000;

    public Queue() {
        this.array = new int[LENGTH];
        this.count = 0;
    }

    @Override
    public void add(int a) {
        if (this.count == this.LENGTH) throw new RuntimeException("The queue is full.");
        this.array[this.count] = a;
        this.count++;
    }

    @Override
    public void remove() {
        if (this.isEmpty()) throw new RuntimeException("The queue is empty"); //O(C)

        for (int i = 0; i < this.array.length - 1; i++) { //O(n)
            this.array[i] = this.array[i + 1];
        }
        this.count--; //O(C)
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int getFirst() {
        if (this.isEmpty()) throw new RuntimeException("The queue is empty");
        return this.array[0];
    }
}
