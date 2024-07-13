package implementation.normal;

import model.ISet;

import java.util.Arrays;
import java.util.Random;

public class Set implements ISet {

    private static final int MAX = 10000;
    private final int[] array;
    private int count;

    public Set() {
        this.array = new int[MAX];
        this.count = 0;
    }

    @Override
    public void add(int a) { // O(N + C_1 + C_2) ~ O(N)
        if(count == MAX) throw new RuntimeException("Limite de elementos alcanzado");

        // N * C ~ N
        for (int i = 0; i < this.count; i++) { // N
            if (this.array[i] == a) { // C
                return; // C
            }
        }

        this.array[this.count] = a; // C_1
        this.count++; // C_2
    }

    @Override
    public void remove(int a) {
        if (isEmpty()) throw new RuntimeException("Esta vacio.");

        for (int i = 0; i < this.count; i++) {
            if (this.array[i] == a) {
                this.array[i] = this.array[this.count - 1];
                this.count--;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int choose() {
        if (isEmpty()) throw new RuntimeException("Esta vacio.");

        int randomIndex = (new Random()).nextInt(this.count);
        return this.array[randomIndex];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Set set = (Set) o;
        if (count != set.count) return false;

        int[] array1Copy = Arrays.copyOf(array, array.length);
        int[] array2Copy = Arrays.copyOf(set.array, set.array.length);
        Arrays.sort(array1Copy);
        Arrays.sort(array2Copy);

        for (int i = 0; i < count; i++) {
            if (array1Copy[i] != array2Copy[i]) {
                return false;
            }
        }
        return true;
    }
}
