package medium;


//https://leetcode.com/problems/maximum-subarray/description/
public class MaxSubarray {
    public int maxSubArray(int[] nums) {
        int maximum = Integer.MIN_VALUE;
        int currentMax = 0;
        for (int i = 0; i < nums.length; i++) {
            currentMax += nums[i];
            maximum = Math.max(maximum, currentMax);
            // thi is very important condition to reset the current max to zero 
            // when it becomes negative
            currentMax = Math.max(currentMax, 0);
        }
        return maximum;
    }
}