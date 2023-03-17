package medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> combination = new ArrayList<>();
            backTrack(target, combination, 0, candidates, ans);
            return ans;
        }

        public void backTrack(int remain, List<Integer> combination,
                int start, int[] candidates, List<List<Integer>> result) {
            // case where you know we have already find the remain
            if (remain == 0) {
                // make a deep copy of the current combination
                result.add(new ArrayList<Integer>(combination));
                return;
            } else if (remain < 0) {
                return;
            }
            // iterate over the candidates from start
            for (int i = start; i < candidates.length; i++) {
                combination.add(candidates[i]);
                backTrack(remain - candidates[i], combination, i, candidates, result);
                combination.remove(combination.size() - 1);
            }
        }
    }
}