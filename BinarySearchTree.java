public class BinarySearchTree<T extends Comparable<T>> {
    private class Node {
        T data;
        Node left;
        Node right;
        
        Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    
    private Node root;
    private int size;
    
    public BinarySearchTree() {
        root = null;
        size = 0;
    }
    
    public void insert(T data) {
        root = insertRec(root, data);
        size++;
    }
    
    private Node insertRec(Node root, T data) {
        if (root == null) return new Node(data);
        
        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }
    
    public boolean search(T data) {
        return searchRec(root, data);
    }
    
    private boolean searchRec(Node root, T data) {
        if (root == null) return false;
        if (data.compareTo(root.data) == 0) return true;
        
        if (data.compareTo(root.data) < 0) {
            return searchRec(root.left, data);
        } else {
            return searchRec(root.right, data);
        }
    }
    
    public void inOrderTraversal() {
        inOrderRec(root);
        System.out.println();
    }
    
    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }
    
    public int size() {
        return size;
    }
}
