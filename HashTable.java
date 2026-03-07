import java.util.LinkedList;

public class HashTable<K, V> {
    private class Entry {
        K key;
        V value;
        
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private LinkedList<Entry>[] table;
    private int size;
    private int capacity;
    
    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        this.capacity = capacity;
        table = new LinkedList[capacity];
        size = 0;
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }
    
    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }
    
    public void put(K key, V value) {
        int index = hash(key);
        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[index].add(new Entry(key, value));
        size++;
    }
    
    public V get(K key) {
        int index = hash(key);
        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }
    
    public V remove(K key) {
        int index = hash(key);
        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                table[index].remove(entry);
                size--;
                return entry.value;
            }
        }
        return null;
    }
    
    public boolean containsKey(K key) {
        return get(key) != null;
    }
    
    public int size() {
        return size;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public void display() {
        for (int i = 0; i < capacity; i++) {
            if (!table[i].isEmpty()) {
                System.out.print("Bucket " + i + ": ");
                for (Entry entry : table[i]) {
                    System.out.print("[" + entry.key + "] ");
                }
                System.out.println();
            }
        }
        System.out.println("Total entries: " + size);
    }
}