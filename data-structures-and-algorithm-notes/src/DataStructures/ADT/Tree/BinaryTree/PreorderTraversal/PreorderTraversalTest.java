package DataStructures.ADT.Tree.BinaryTree.PreorderTraversal;

import DataStructures.ADT.Tree.BinaryTree.BinaryNode;
import DataStructures.ADT.Tree.BinaryTree.BinaryTreeFactory;
public class PreorderTraversalTest {
    public static void main(String[] args) {
        BinaryNode binaryTree = BinaryTreeFactory.createBinaryTree();
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        preorderTraversal.printTreeByPreorderTraversal(binaryTree);
        System.out.println();
        preorderTraversal.printTreeByPreorderTraversalStack(binaryTree);
    }
}
