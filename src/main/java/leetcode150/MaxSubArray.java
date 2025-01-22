package leetcode150;

/**
 * 53. Maximum Subarray
 * Solved
 * Medium
 * Topics
 * Companies
 * 
 * Given an integer array nums, find the
 * subarray
 * with the largest sum, and return its sum.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * 
 * Example 2:
 * 
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * 
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {

        int maxSubArray = nums[0];
        int currentSubArr = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
            // for example here it will become negative by adding nums[i] then we will move
            // forward
            currentSubArr = Math.max(nums[i], currentSubArr + nums[i]);
            maxSubArray = Math.max(maxSubArray, currentSubArr);
        }

        return maxSubArray;

    }

    public int maxSubArrayEasy(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    public int maxSubArrayBruteForce(int[] nums) {

        int maxSubArray = Integer.MIN_VALUE;
        // brute force approach with n2 complexity
        for (int i = 0; i < nums.length; i++) {
            int currentSubArr = 0;
            for (int j = i; j < nums.length; j++) {
                currentSubArr += nums[j];
                maxSubArray = Math.max(maxSubArray, currentSubArr);
            }

        }
        System.out.println(maxSubArray);
        return maxSubArray;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int result1 = maxSubArray.maxSubArray(nums1);
        System.out.println(result1); // Expected output: 6

        int result2 = maxSubArray.maxSubArrayEasy(nums1);
        System.out.println(result2); // Expected output: 6

        int result3 = maxSubArray.maxSubArrayBruteForce(nums1);
        System.out.println(result3); // Expected output: 6

        int[] nums2 = { 1 };
        int result4 = maxSubArray.maxSubArray(nums2);
        System.out.println(result4); // Expected output: 1

        int result5 = maxSubArray.maxSubArrayEasy(nums2);
        System.out.println(result5); // Expected output: 1

        int result6 = maxSubArray.maxSubArrayBruteForce(nums2);
        System.out.println(result6); // Expected output: 1

        int[] nums3 = { 5, 4, -1, 7, 8 };
        int result7 = maxSubArray.maxSubArray(nums3);
        System.out.println(result7); // Expected output: 23

        int result8 = maxSubArray.maxSubArrayEasy(nums3);
        System.out.println(result8); // Expected output: 23

        int result9 = maxSubArray.maxSubArrayBruteForce(nums3);
        System.out.println(result9); // Expected output: 23

    }

}
