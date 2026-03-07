public class Queue<T> {
    private T[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    
    @SuppressWarnings("unchecked")
    public Queue(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public void enqueue(T item) {
        if (size == capacity) {
            resize();
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }
    
    public T dequeue() {
        if (isEmpty()) return null;
        T item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }
    
    public T peek() {
        if (isEmpty()) return null;
        return queue[front];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    @SuppressWarnings("unchecked")
    private void resize() {
        capacity *= 2;
        T[] newQueue = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % (capacity/2)];
        }
        queue = newQueue;
        front = 0;
        rear = size - 1;
    }
}
