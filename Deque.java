import java.util.ArrayList;
import java.util.Iterator;

public class Deque<T> implements Iterable<T> {
    private ArrayList<T> deque;
    
    public Deque() {
        deque = new ArrayList<>();
    }
    
    public void addFront(T item) {
        deque.add(0, item);
    }
    
    public void addRear(T item) {
        deque.add(item);
    }
    
    public T removeFront() {
        if (isEmpty()) return null;
        return deque.remove(0);
    }
    
    public T removeRear() {
        if (isEmpty()) return null;
        return deque.remove(deque.size() - 1);
    }
    
    public T getFront() {
        if (isEmpty()) return null;
        return deque.get(0);
    }
    
    public T getRear() {
        if (isEmpty()) return null;
        return deque.get(deque.size() - 1);
    }
    
    public boolean isEmpty() {
        return deque.isEmpty();
    }
    
    public int size() {
        return deque.size();
    }
    
    @Override
    public Iterator<T> iterator() {
        return deque.iterator();
    }
}