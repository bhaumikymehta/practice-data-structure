package easy;

// in balanced binary tree the left and right hieght difference in maximum 1 if it is above 1 it not balanced
public class BalancedBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (findHeight(root) == -1)
            return false;
        return true;
    }
    // create height function which we will call multiple times

    public int findHeight(TreeNode node) {

        // first if the current node is null we will return 0 for leaf node
        if (node == null)
            return 0;

        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        // if any of the height is -1 return -1
        if (leftHeight == -1 || rightHeight == -1)
            return -1;
        // checking the differnece in the height
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        // final return statement for returning the max height
        return Math.max(leftHeight, rightHeight) + 1;

    }
}
