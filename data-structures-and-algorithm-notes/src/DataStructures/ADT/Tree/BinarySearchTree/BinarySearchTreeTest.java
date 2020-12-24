package DataStructures.ADT.Tree.BinarySearchTree;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(10);
        binarySearchTree.insert(5);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(8);
        binarySearchTree.insert(6);
        binarySearchTree.insert(9);
        binarySearchTree.insert(7);
        binarySearchTree.insert(17);
        binarySearchTree.insert(16);
        binarySearchTree.insert(18);
        binarySearchTree.printTree();

        binarySearchTree.remove(5);
        binarySearchTree.printTree();

        System.out.println(binarySearchTree.isEmpty());

        System.out.println( binarySearchTree.contais(16));
        System.out.println( + binarySearchTree.contais(100));

        System.out.println( + binarySearchTree.findMin());
        System.out.println( + binarySearchTree.findMax());

        binarySearchTree.makeEmpty();
        System.out.println( + binarySearchTree.isEmpty());

    }
}
