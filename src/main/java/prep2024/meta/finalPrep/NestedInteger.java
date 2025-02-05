package prep2024.meta.finalPrep;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class NestedInteger {

    /*
     * DFS and BFS question
     * You are given a nested list of integers nestedList. Each element is either an
     * integer or a list whose elements may also be integers or other lists.
     * 
     * The depth of an integer is the number of lists that it is inside of. For
     * example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to
     * its depth.
     * 
     * Return the sum of each integer in nestedList multiplied by its depth.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nestedList = [[1,1],2,[1,1]]
     * Output: 10
     * Explanation: Four 1's at depth 2, one 2 at depth 1. 1*2 + 1*2 + 2*1 + 1*2 +
     * 1*2 = 10.
     */

    public int depthSumss(List<NestedInteger> nestedList) {
        Deque<NestedInteger> queue = new ArrayDeque<>();
        // Queue<NestedInteger> queue = new LinkedList<>();
        queue.addAll(nestedList);

        int depth = 1;
        int total = 0;

//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                NestedInteger nested = queue.poll();
//                if (nested.isInteger()) {
//                    total += nested.getInteger() * depth;
//                } else {
//                    queue.addAll(nested.getList());
//                }
//            }
//            depth++;
//        }
        return total;
    }

    // dfs
    public int depthSums(List<NestedInteger> nestedList) {
        int total = dfs(nestedList, 1);
        return total;
    }

    public static int dfs(List<NestedInteger> nestedList, int depth) {
        int totalSum = 0;

//        for (NestedInteger n : nestedList) {
//            if (n.isInteger()) {
//                totalSum += n.getInteger() * depth;
//            } else {
//                totalSum += dfs(n.getList(), depth + 1);
//            }
//        }
        return totalSum;
    }
}
