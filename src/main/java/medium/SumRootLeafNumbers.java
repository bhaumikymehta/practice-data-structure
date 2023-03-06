package medium;

//https://leetcode.com/problems/sum-root-to-leaf-numbers/description/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SumRootLeafNumbers {

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        sum = currentNum(root, sum);
        return sum;
    }

    public int currentNum(TreeNode root, int sum) {
        if (root == null)
            return 0;

        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return sum;
        }

        return currentNum(root.left, sum) + currentNum(root.right, sum);
    }
}