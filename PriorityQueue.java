import java.util.ArrayList;

public class PriorityQueue<T extends Comparable<T>> {
    private ArrayList<T> heap;
    
    public PriorityQueue() {
        heap = new ArrayList<>();
    }
    
    public void insert(T item) {
        heap.add(item);
        heapifyUp(heap.size() - 1);
    }
    
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(parent).compareTo(heap.get(index)) > 0) {
                swap(parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }
    
    public T extractMin() {
        if (isEmpty()) return null;
        T min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        if (!isEmpty()) {
            heapifyDown(0);
        }
        return min;
    }
    
    private void heapifyDown(int index) {
        int smallest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        
        if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }
    
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    
    public T peek() {
        return isEmpty() ? null : heap.get(0);
    }
    
    public int size() {
        return heap.size();
    }
    
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}

