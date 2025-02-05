package leetcode150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    // below solution we will sort the array first and then check if the previous
    // element is one less or not
    public int longestConsecutiveWithSorting(int[] nums) {
        if (nums.length == 0)
            return 0;

        Arrays.sort(nums);
        int longestSub = 1;
        int currSub = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                // this is the main logic to compare with previous element
                if (nums[i] - 1 == nums[i - 1]) {
                    currSub++;
                    longestSub = Math.max(longestSub, currSub);
                } else {
                    longestSub = Math.max(longestSub, currSub);
                    currSub = 1;
                }

            }
        }
        return longestSub;
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int longest = 0;
        for (int n : nums) {
            // this if statement is used to check weather the previoius ellement exist
            if (!set.contains(n - 1)) {
                int length = 1;
                while (set.contains(n + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
    public static void main(String[] args) {
        
    }
}