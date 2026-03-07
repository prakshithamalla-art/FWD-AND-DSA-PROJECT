public class CircularQueue<T> {
    private T[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    
    @SuppressWarnings("unchecked")
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }
    
    public void enqueue(T item) {
        if (isFull()) {
            dequeue();
        }
        
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }
    
    public T dequeue() {
        if (isEmpty()) return null;
        T item = queue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
        return item;
    }
    
    public T getFront() {
        return isEmpty() ? null : queue[front];
    }
    
    public T getRear() {
        return isEmpty() ? null : queue[rear];
    }
    
    public boolean isEmpty() {
        return front == -1;
    }
    
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
    
    public int size() {
        return size;
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        System.out.print("Circular Queue: ");
        int i = front;
        while (i != rear) {
            System.out.print(queue[i] + " ");
            i = (i + 1) % capacity;
        }
        System.out.println(queue[rear]);
    }
}