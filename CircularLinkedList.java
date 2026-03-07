import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedList<T> implements Iterable<T> {
    private class Node {
        T data;
        Node next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;
    private Node tail;
    private int size;
    
    public CircularLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public void append(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        size++;
    }
    
    public T get(int index) {
        if (index < 0 || index >= size) return null;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    public void display() {
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to head)");
    }
    
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = head;
            private boolean firstPass = true;
            
            @Override
            public boolean hasNext() {
                if (current == null) return false;
                if (current == head && !firstPass) return false;
                return true;
            }
            
            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T data = current.data;
                current = current.next;
                firstPass = false;
                return data;
            }
        };
    }
}
