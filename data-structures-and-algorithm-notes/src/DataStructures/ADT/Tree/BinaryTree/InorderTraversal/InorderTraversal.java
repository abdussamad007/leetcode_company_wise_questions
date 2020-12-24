package DataStructures.ADT.Tree.BinaryTree.InorderTraversal;

import DataStructures.ADT.Tree.BinaryTree.BinaryNode;

import java.util.Stack;
public class InorderTraversal {

    public void printTreeByInorderTraversal(BinaryNode rootNode) {
        if (rootNode.getLeft() != null) {
            printTreeByInorderTraversal(rootNode.getLeft());
        }
        System.out.print(rootNode.getElement().toString() + " ");
        if (rootNode.getRight() != null) {
            printTreeByInorderTraversal(rootNode.getRight());
        }
    }

    public void printTreeByInorderTraversalStack(BinaryNode rootNode) {
        Stack<BinaryNode> stack = new Stack<>();
        while(rootNode != null || stack.size() > 0) {
            if(rootNode != null) {
                stack.push(rootNode);
                rootNode = rootNode.getLeft();
            } else {
                rootNode = stack.pop();
                System.out.print(rootNode.getElement().toString() + " ");
                rootNode = rootNode.getRight();
            }
        }
    }
}
