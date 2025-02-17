package medium;


/*

https://leetcode.com/problems/binary-tree-tilt/description/
Given the root of a binary tree, return the sum of every tree node's tilt.

The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right
 subtree node values. If a node does not have a left child, then the sum of the left subtree node values is treated
 as 0. The rule is similar if the node does not have a right child.
 */
public class CalculateTilt {

    int tilt = 0;
    public int findTilt(TreeNode root) {

        dfs(root);
        return tilt;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        // here we are taking abs diff from left and right
        tilt += Math.abs(left-right);

        // we are adding all the value from left right and node value
        return left + right + root.val;
    }
}

