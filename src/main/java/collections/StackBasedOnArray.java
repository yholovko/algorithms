package collections;

/**
 * Dynamic stack (array-based implementation)
 */
public class StackBasedOnArray<Item> {
    private Item[] elements;
    private int N = 0;  //size

    public StackBasedOnArray() {
        this(10);
    }

    public StackBasedOnArray(int cap) {
        elements = (Item[]) new Object[cap];
    }

    private void resize(int newCapacity) {
        System.out.print("; Resizing array. New capacity = " + newCapacity);

        Item[] newElements = (Item[]) new Object[newCapacity];

        System.arraycopy(elements, 0, newElements, 0, N);
        elements = newElements;
    }

    public void push(Item elem) {
        System.out.print("Pushing: " + elem);

        if (N == elements.length) {
            resize(2 * elements.length);
        }

        System.out.println(" ..Done");
        elements[N++] = elem;
    }

    public Item pop() {
        Item item = elements[--N];
        elements[N] = null;             //for garbage collector
        if (N > 0 && N == elements.length / 4) {
            resize(elements.length / 2);
        }

        return item;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int capacity() {
        return elements.length;
    }

    public static void main(String[] args) {
        StackBasedOnArray<Integer> st = new StackBasedOnArray<>(3);
        System.out.println("Size = " + st.size() + "; Capacity = " + st.capacity());

        st.push(4);
        st.push(2);
        st.push(8);

        System.out.println("Size = " + st.size() + "; Capacity = " + st.capacity());

        System.out.println("Pop = " + st.pop());
        System.out.println("Pop = " + st.pop());
        System.out.println("Pop = " + st.pop());

        System.out.println("Size = " + st.size() + "; Capacity = " + st.capacity());

        st.push(4);
        st.push(2);
        st.push(8);
        st.push(6);

        System.out.println("Size = " + st.size() + "; Capacity = " + st.capacity());

        System.out.println("Pop = " + st.pop());
        System.out.println("Pop = " + st.pop());
        System.out.println("\nPop = " + st.pop());

        System.out.println("Size = " + st.size() + "; Capacity = " + st.capacity());
    }
}
