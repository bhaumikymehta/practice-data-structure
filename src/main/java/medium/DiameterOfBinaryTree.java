package medium;

/*

https://leetcode.com/problems/diameter-of-binary-tree/description/
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {

    int diameter ;
    public int diameterOfBinaryTree(TreeNode root) {
        // global variable to store the final result
        diameter = 0;
        dfs(root);
        return diameter;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left= dfs(root.left);
        int right= dfs(root.right);
        // upddatig diameter with max of left+right
        diameter = Math.max(diameter, left+right);

        // main logic to add 1 to the max value
        return Math.max(left, right) + 1 ;
    }
}
