public class Stack<T> {
    private T[] stack;
    private int top;
    private int capacity;
    
    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        this.capacity = capacity;
        stack = (T[]) new Object[capacity];
        top = -1;
    }
    
    public void push(T item) {
        if (top == capacity - 1) {
            resize();
        }
        stack[++top] = item;
    }
    
    public T pop() {
        if (isEmpty()) return null;
        return stack[top--];
    }
    
    public T peek() {
        if (isEmpty()) return null;
        return stack[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public int size() {
        return top + 1;
    }
    
    @SuppressWarnings("unchecked")
    private void resize() {
        capacity *= 2;
        T[] newStack = (T[]) new Object[capacity];
        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }
}