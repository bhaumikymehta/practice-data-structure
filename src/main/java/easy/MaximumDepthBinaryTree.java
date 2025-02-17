package easy;

/*

https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.



Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:

Input: root = [1,null,2]
Output: 2

 */
public class MaximumDepthBinaryTree {

    public int maxDepth(TreeNode root) {
        // base case to check when the root is null we return 0
        if(root == null){
            return 0;
        }
        // getting left and right values
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // this is the main part
        // we get the left node and add 1 to the max so from bottom up for each level it will add 1
        return Math.max(left, right) + 1;
    }

}
