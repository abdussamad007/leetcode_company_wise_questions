package DataStructures.ADT.Tree.BinaryTree.InorderTraversal;

import DataStructures.ADT.Tree.BinaryTree.BinaryNode;
import DataStructures.ADT.Tree.BinaryTree.BinaryTreeFactory;
import DataStructures.ADT.Tree.BinaryTree.PostorderTraversal.PostorderTraversal;
public class InorderTraversalTest {
    public static void main(String[] args) {
        BinaryNode binaryTree = BinaryTreeFactory.createBinaryTree();
        InorderTraversal inorderTraversal = new InorderTraversal();
        inorderTraversal.printTreeByInorderTraversal(binaryTree);
        System.out.println();
        inorderTraversal.printTreeByInorderTraversalStack(binaryTree);
    }
}
