package medium;

import java.util.*;

/*

https://leetcode.com/problems/find-leaves-of-binary-tree/description/?envType=company&envId=linkedin&favoriteSlug=linkedin-thirty-days
Given the root of a binary tree, collect a tree's nodes as if you were doing this:

    Collect all the leaf nodes.
    Remove all the leaf nodes.
    Repeat until the tree is empty.



Example 1:

Input: root = [1,2,3,4,5]
Output: [[4,5,3],[2],[1]]
Explanation:
[[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per each level it does not matter the order on which elements are returned.

 */
public class FindLeavesInBinaryTree {

    List<List<Integer>> result ;
    Map<Integer,List<Integer>> map ;
    public List<List<Integer>> findLeaves(TreeNode root) {
        result= new ArrayList<>();
        dfs(root);

        return result;
    }

    public Integer dfs(TreeNode root){
        if(root == null){
            return -1;
        }
        // we will try to get the height at each level
        int left = dfs(root.left);
        int right = dfs(root.right);
        int level = Math.max(left, right) + 1;


        System.out.println("left: "+left);
        System.out.println("Right :"+ right);
        System.out.println("level: "+ level);
        System.out.println("Root value: "+ root.val);

        // there is no arraylist at the given level
        if(result.size() <= level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        return level;
    }

}
