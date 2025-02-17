package datastructure.templates;

public class DfsRecursion {

    // recursive dfs function is written below
    public int dfs(TreeNode node){
        // check if root is null
        if(node == null){
            return 0;
        }
        // this is the check if the node is leaf node when both the left and right is null it will be a leaf node
        if (node.left == null && node.right == null){
            return node.value;
        }

        int left = dfs(node.left);
        int right = dfs(node.right) ;

        // this is the main logic where we will be comparing the left and right subtree
        return left+right+node.value;
    }

}
