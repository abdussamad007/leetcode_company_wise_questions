package DataStructures.ADT.Tree.BinaryTree.PostorderTraversal;

import DataStructures.ADT.Tree.BinaryTree.BinaryNode;

import java.util.Stack;
public class PostorderTraversal {

    public void printTreeByPostorderTraversal(BinaryNode rootNode) {
        if (rootNode.getLeft() != null) {
            printTreeByPostorderTraversal(rootNode.getLeft());
        }
        if (rootNode.getRight() != null) {
            printTreeByPostorderTraversal(rootNode.getRight());
        }
        System.out.print(rootNode.getElement().toString() + " ");
    }

    public void printTreeByPostorderTraversalWith2Stacks(BinaryNode rootNode) {
        Stack<BinaryNode> stack = new Stack<>();
        Stack<BinaryNode> output = new Stack<>();
        while (rootNode != null || stack.size() > 0) {
            if (rootNode != null) {
                stack.push(rootNode);
                output.push(rootNode);
                rootNode = rootNode.getRight();
            } else {
                rootNode = stack.pop();
                rootNode = rootNode.getLeft();
            }
        }
        while (output.size() > 0) {
            System.out.print(output.pop().getElement().toString() + " ");
        }
    }
}
