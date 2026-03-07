import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Iterable<T> {
    private class Node {
        T data;
        Node prev;
        Node next;
        
        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    
    private Node head;
    private Node tail;
    private int size;
    
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public void append(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    public void prepend(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    
    public T get(int index) {
        if (index < 0 || index >= size) return null;
        
        if (index < size / 2) {
            Node current = head;
            for (int i = 0; i < index; i++) current = current.next;
            return current.data;
        } else {
            Node current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
            return current.data;
        }
    }
    
    public T remove(int index) {
        if (index < 0 || index >= size) return null;
        
        Node removed;
        if (index == 0) {
            removed = head;
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else if (index == size - 1) {
            removed = tail;
            tail = tail.prev;
            tail.next = null;
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) current = current.next;
            removed = current;
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
        return removed.data;
    }
    
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    
    // FIXED: This method returns Object[] instead of T[]
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node current = head;
        int i = 0;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = head;
            
            @Override
            public boolean hasNext() {
                return current != null;
            }
            
            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}