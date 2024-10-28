package prep2024.meta.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    public int value;
    private List<TreeNode> children;

    TreeNode(int value) {
        this.value = value;
        children = new ArrayList<>();
    }

    void setChildren(TreeNode child) {
        if (children.isEmpty()) {
            List<TreeNode> childrenList = new ArrayList<>();
            childrenList.add(child);
            this.children = childrenList;
        } else {
            this.children.add(child);
        }
    }

    List<TreeNode> getChildren() {
        return this.children;
    }

}

public class MinimumSumTree {
    public static int findMinSum(TreeNode root) {
        int sum = 0;
        int minSum = Integer.MAX_VALUE;
        if (root.getChildren().isEmpty()) {
            return root.value;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sum = 0;
            sum += node.value;
            if (node.getChildren().isEmpty()) {
                minSum = Math.min(minSum, sum);
            } else {
                for (int i = 0; i < node.getChildren().size(); i++) {
                    // Add children to the stack, each starting with the current node's value
                    TreeNode child = node.getChildren().get(i);
                    child.value += node.value; // Update child's value to include parent's
                    stack.add(child);
                }
            }

        }
        return minSum;
    }

    public static int findMinSumRecursive(TreeNode root) {

        return dfs(root, 0);
    }

    public static int dfs(TreeNode node, int currentSum) {
        currentSum += node.value; // Add the current node's value

        if (node.getChildren().isEmpty()) {
            return currentSum; // Leaf node, return the path sum
        }

        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < node.getChildren().size(); i++) {
            // Recursively explore each child with the updated currentSum
            minSum = Math.min(minSum, dfs(node.getChildren().get(i), currentSum));
        }

        return minSum;
    }

    public static void main(String[] args) {
        // 1 //1
        // 2 4 // 2 4
        // 3. 6 8 9// 3 6 4
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);
        four.setChildren(eight);
        four.setChildren(nine);
        two.setChildren(three);
        two.setChildren(six);
        root.setChildren(two);
        root.setChildren(four);

        int result = findMinSum(root);

        System.out.println("Minimum sum: " + result);
        int result2 = findMinSumRecursive(root);

        System.out.println("Minimum sum with recursion: " + result2);
    }

}
