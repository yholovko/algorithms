package collections;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

public class CircularBuffer {
    private int N;
    private Object[] storage;
    private boolean full = false;
    private int start = 0;
    private int end = 0;


    public CircularBuffer(int N) {
        this.N = N;
        storage = new Object[N];
    }

    public int count() {
        int size = 0;

        if (end < start) {
            size = N - start + end;
        } else if (end == start) {
            size = (full ? N : 0);
        } else {
            size = end - start;
        }

        return size;
    }

    public int count_Linux(){
        return (start - end) & (N-1);
    }

    public int space() {
        return 0;
    }

    public int count_to_end() {
        return 0;
    }

    public int space_to_end() {
        return 0;
    }

    void put_item(Object item) {
        if (is_full()) {
            get_item();
        }
        if (null == item) {
            throw new NullPointerException();
        }

        if (full) {
            throw new BufferOverflowException();
        }
        storage[end++] = item;
        if (end >= N) {
            end = 0;
        }

        if (end == start) {
            full = true;
        }
    }

    public Object get_item() {
        if (is_empty()) {
            throw new BufferUnderflowException();
        }

        Object element = storage[start];

        if (null != element) {
            storage[start++] = null;

            if (start >= N) {
                start = 0;
            }

            full = false;
        }

        return element;
    }

    public boolean is_empty() {
        return count() == 0;
    }

    public boolean is_full() {
        return count() == N;
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(5);
        cb.put_item(1);
        cb.put_item(2);
        System.out.println(cb.count_Linux());
        cb.put_item(3);
        cb.put_item(4);
        cb.put_item(5);
        cb.put_item(6);
        cb.put_item(7);
        cb.put_item(8);
        cb.put_item(10);
        cb.put_item(11);
        cb.put_item(12);
        System.out.println(cb.count_Linux());
        cb.put_item(13);
        cb.put_item(14);
        cb.put_item(15);
        cb.put_item(16);
        cb.put_item(17);
        cb.put_item(18);
        cb.put_item(19);
    }
}
