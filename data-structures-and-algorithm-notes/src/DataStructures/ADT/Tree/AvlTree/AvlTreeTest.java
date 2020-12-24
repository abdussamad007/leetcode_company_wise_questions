package DataStructures.ADT.Tree.AvlTree;
public class AvlTreeTest {
    public static void main(String[] args) {
        AvlTree<Integer> avlTree = new AvlTree<>();
        for (int i = 1; i <= 10; i++) {
            avlTree.insert(i);
        }
        avlTree.printTree();
        System.out.println("List:" + avlTree.checkBalance());

        avlTree.remove(5);
        avlTree.printTree();
        System.out.println("List:" + avlTree.checkBalance());
    }

}
