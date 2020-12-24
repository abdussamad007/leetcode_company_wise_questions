package DataStructures.ADT.Tree.BinarySearchTree;

public class BinarySearchTree<T extends Comparable<? super T>> {

    private static class BinaryNode<T> {

        BinaryNode(T t) {
            this(t, null, null);
        }

        BinaryNode(T t, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = t;
            this.left = left;
            this.right = right;
        }

        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;
    }

    private BinaryNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void makeEmpty() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean contais(T t) {
        return contains(t, root);
    }

    public T findMin() {
        if (isEmpty()) {
            return null;
        }
        return findMin(root).element;
    }
    public T findMax() {
        if (isEmpty()) {
            return null;
        }
        return findMax(root).element;
    }

    public void insert(T t) {
        root = insert(t, root);
    }

    public void remove(T t) {
        root = remove(t, root);
    }

    public void printTree() {
        if (isEmpty()) {
        } else {
            printTree(root);
        }
        System.out.println();
    }


    private void printTree(BinaryNode<T> node) {
        if (node != null) {
            printTree(node.left);
            System.out.println(node.element);
            printTree(node.right);
        }
    }


    private boolean contains(T t, BinaryNode<T> node) {
        if (node == null) {
            return false;
        }
        int compareResult = t.compareTo(node.element);

        if (compareResult < 0) {
            return contains(t, node.left);
        } else if (compareResult > 0) {
            return contains(t, node.right);
        } else {
            return true;
        }
    }

    private BinaryNode<T> findMin(BinaryNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    private BinaryNode<T> findMax(BinaryNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.right == null) {
            return node;
        }
        return findMax(node.right);
    }

    private BinaryNode<T> insert(T t, BinaryNode<T> node) {
        if (node == null) {
            return new BinaryNode<>(t, null, null);
        }

        int compareResult = t.compareTo(node.element);
        if (compareResult < 0) {
            node.left = insert(t, node.left);
        } else if (compareResult > 0) {
            node.right = insert(t, node.right);
        }
        return node;
    }

    private BinaryNode<T> remove(T t, BinaryNode<T> node) {
        if (t == null) {
            return null;
        }
        int compareResult = t.compareTo(node.element);

        if (compareResult < 0) {
            node.left = remove(t, node.left);
        } else if (compareResult > 0) {
            node.right = remove(t, node.right);
        } else if (node.left != null && node.right != null) {
            node.right = removeRightMin(node, node.right);
        } else {
            node = node.left != null ? node.left : node.right;
        }
        return node;
    }

    private BinaryNode<T> removeRightMin(BinaryNode<T> node, BinaryNode<T> rNode) {
        if (rNode.left != null) {
            rNode.left = removeRightMin(node, rNode.left);
        } else {
            node.element = rNode.element;
            rNode = rNode.right;
        }
        return rNode;
    }
}
