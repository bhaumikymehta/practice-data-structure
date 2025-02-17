package easy;

import java.util.Stack;

/*

https://leetcode.com/problems/path-sum/description/
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.
 */
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        // this is the check for root is null
        if (root == null) {
            return false;
        }
        // check for leaf node and target sum is matched then return true
        if(root.left == null &&
                root.right == null &&
                targetSum == root.val){
            return true;
        }
        // pass the next value as targetsum - root value
        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);

        // if thte left and right are true then the result is true
        return (left == true || right == true) ? true : false;
    }

    // below is the iterative code
    public boolean hasPathSumIterative(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int sum=0;
        while(!stack.isEmpty()){

            TreeNode node = stack.pop();
            sum+=node.val;
            System.out.println("Sum:"+sum);
            if(targetSum == sum && node.left == null && node.right == null)     {
                return true;
            }else if(node.left != null){
                stack.add(node.left);
            }else if(node.right != null){
                stack.add(node.right);
            }else if(node.left == null && node.right == null){
                sum-=node.val;
            }

            System.out.println(stack);
        }
        return false;
    }
}
