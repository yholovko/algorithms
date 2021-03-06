package collections;

import java.util.Iterator;

/**
 * Queue (LinkedList-based implementation)
 * @param <Item>
 */
public class QueueBasedOnLinkedList<Item> implements Iterable<Item> {
    private Node first = null; //pointer to first node
    private Node last = null; //pointer to last node

    private class Node {
        public Item element;
        public Node next;
    }

    private boolean isEmpty() {
        return first == null;
    }

    /**
     * add a new item to the back of the queue
     */
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.element = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    /**
     * get first element
     */
    public Item dequeue() {
        Item item = first.element;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.element;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        QueueBasedOnLinkedList<Integer> queue = new QueueBasedOnLinkedList<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Iterator it = queue.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("Pop: ");
        System.out.print(queue.dequeue() + " ");
        System.out.println(queue.dequeue());

        it = queue.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}