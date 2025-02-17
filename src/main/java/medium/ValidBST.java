package medium;

/*
https://leetcode.com/problems/validate-binary-search-tree/description/
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

    The left
    subtree
    of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.


 */

public class ValidBST {

    public boolean isValidBST(TreeNode root) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        return dfsWithParam(root, min, max);

    }

    public boolean dfsWithParam(TreeNode root, int min, int max){
        if(root == null){
            return true;
        }

        // if the root value is less then the min or greater then max then its not binary search tree
        if(root.val <= min || root.val >= max){
            return false;
        }

        // main logic is on left subtree pass min and current root value
        boolean left= dfsWithParam(root.left,min,root.val);
        // on right sub tree pass current value and max
        boolean right= dfsWithParam(root.right,root.val,max);

        return (left == true && right == true) ? true:false;
    }
}
