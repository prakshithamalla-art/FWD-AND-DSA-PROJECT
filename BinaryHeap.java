import java.util.ArrayList;

public class BinaryHeap {
    private ArrayList<Integer> heap;
    
    public BinaryHeap() {
        heap = new ArrayList<>();
    }
    
    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }
    
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(parent) > heap.get(index)) {
                swap(parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }
    
    public int extractMin() {
        if (isEmpty()) return -1;
        int min = heap.get(0);
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
        
        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }
    
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    
    public int peek() {
        return isEmpty() ? -1 : heap.get(0);
    }
    
    public int size() {
        return heap.size();
    }
    
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    
    public void clear() {
        heap.clear();
    }
}
