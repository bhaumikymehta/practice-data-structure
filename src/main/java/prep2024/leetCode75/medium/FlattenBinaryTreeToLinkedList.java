package prep2024.leetCode75.medium;

import java.util.ArrayDeque;
import java.util.Deque;

import apple.laf.JRSUIUtils.Tree;

// Definiton of a binary tree node class
class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class FlattenBinaryTreeToLinkedList {
    static Deque<TreeNode<Integer>> queue = new ArrayDeque<>();

    public static TreeNode<Integer> flattenTree(TreeNode<Integer> root) {

        // lets start with naive approach using the queue data structure
        // we will start doing preorder traversal and add all in queue and then do a
        // deque from the queue and create a linked list in such a way that left is null and right is next node
        queueBuild(root);
        root.left = null;
        root.right = queue.poll();
        
        TreeNode<Integer> tempF = root.right ;
        while (queue.isEmpty()) {
            TreeNode<Integer> temp = queue.poll();
            temp.left = null;
            temp.right = tempF;
            tempF = temp;
            
        }
        return root;
    }

    public static void queueBuild(TreeNode<Integer> node) {
        if (node == null) {
            return;
        }
        queue.add(node);
        if (node.left != null) {
            queueBuild(node.left);
        }
        if (node.right != null) {
            queueBuild(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(5);
        root.left.left = new TreeNode<>(3);
        root.left.right = new TreeNode<>(4);
        root.right.right = new TreeNode<>(6);

        TreeNode<Integer> flattenedRoot = flattenTree(root);

        // Print the flattened linked list
        TreeNode<Integer> current = flattenedRoot;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }

    }

}
