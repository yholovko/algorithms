package collections;

import java.util.Iterator;

public class StackBasedOnLinkedList<Item> implements Iterable<Item>{
    private Node first = null;
    private int N = 0; //size


    private class Node{
        public Item element;
        public Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.element = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop(){
        Item item = first.element;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
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

        @Override
        public void remove() {}
    }


    public static void main(String[] args) {
        StackBasedOnLinkedList<Integer> stack = new StackBasedOnLinkedList<>();
        stack.push(4);
        stack.push(2);
        stack.push(7);
        stack.push(5);
        stack.push(1);

        Iterator<Integer> it = stack.iterator();
        while (it.hasNext()){
            System.out.print(it.next()+" ");
        }

        System.out.println("\nPop: "+stack.pop());

        it = stack.iterator();
        while (it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
}