import java.util.NoSuchElementException;

//                  linked lists with some methods

/*

                        Created by hussein shamas


 */



public class LinkedList {
    private Node first; // head
    private Node last; // tail

    private class Node {
        private int value;
        private Node next;

        // Node Constructor
        public Node(int value) {
            this.value = value;
        }
    }

    public void addFirst(int item) {
        Node node = new Node(item);

        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
    }

    public void addLast(int item) {
        Node node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }

    }

    private boolean isEmpty() {
        return first == null;
    }

    public int indexOf(int item) {
        int index = 0;
        Node current = first;
        while (current != null) {
            if (current.value == item) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void removeFirst() {

        if (isEmpty()) throw new NullPointerException();

        if (first == last) {
            first = last = null;
            return;
        }
        Node second = first.next;
        first.next = null;
        first = second;
    }

    public void removeLast(int item) {
        if (isEmpty()) throw new NoSuchElementException();

        Node previous = getPrevious(last);
        last = previous;
        last.next = null;
    }

    private Node getPrevious(Node node) {

        Node current = first;
        while (current != null) {
            if (current.next == node) {
                current = current.next;
            }
        }
        return null;
    }
}

