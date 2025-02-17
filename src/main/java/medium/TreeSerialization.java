package medium;


import datastructure.templates.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
Let's explore serialization and deserialization of binary trees in Java.

What is Serialization and Deserialization?

    Serialization: The process of converting a data structure (like a binary tree) into a linear format (like a string of characters) for storage or transmission. Think of it as flattening the tree into a sequence of data.
    Deserialization: The reverse process of reconstructing the original data structure (the binary tree) from its serialized representation.
 */
public class TreeSerialization {

    public String searialize(TreeNode root){

        if(root == null){
            return "null,";
        }
        return root.getValue() + "," + searialize(root.getLeft()) + searialize(root.getRight() ) ;
    }

    public TreeNode deserialize(String data){
        String[] arr = data.split(",");
        Deque<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(arr));
        return buildTree(queue);
    }
    public TreeNode buildTree(Queue<String> queue){
            String s = queue.remove();
            if(s.equals(null)){
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(s));
            node.setLeft(buildTree(queue));
            node.setRight(buildTree(queue));
            return node;
    }

    public  void test(String args) {
        TreeNode root = new TreeNode(1);
        root.setLeft( new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));


        TreeSerialization ts = new TreeSerialization();
        String serialized = ts.searialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserializedRoot = ts.deserialize(serialized);
        System.out.println("Deserialized root value: " + deserializedRoot.getValue()); // Should print 1

    }
}
