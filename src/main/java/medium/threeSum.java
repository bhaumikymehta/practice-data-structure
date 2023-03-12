package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/3sum/submissions/913469020/
public class threeSum {
    // three sum is basically triplet sum where we return all the triplets which
    // gives above sum we will first use two pointer solution for this question
    public List<List<Integer>> threeSumTest(int[] nums) {
        int target = 0;
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                // if we found sum add the values to hashset
                if (sum == target) {
                    set.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        result.addAll(set);
        return result;

    }
}