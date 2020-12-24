package DataStructures.ADT.Tree.BinaryTree;
public class BinaryNode {
    private Object element;
    private BinaryNode left;
    private BinaryNode right;

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
}
