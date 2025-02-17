package datastructure.templates;

import com.sun.source.tree.Tree;
import lombok.Data;

@Data
public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int value, TreeNode left,TreeNode right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
