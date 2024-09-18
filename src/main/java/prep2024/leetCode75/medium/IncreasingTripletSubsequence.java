package prep2024.leetCode75.medium;
// Given an integer array nums,return true if there exists a triple of indices(i,j,k)such that i<j<k and nums[i]<nums[j]<nums[k].If no such indices exists,return false.

// Example 1:

// Input:nums=[1,2,3,4,5]Output:true Explanation:Any triplet where i<j<k is valid.

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int min_1 = Integer.MAX_VALUE;
        int min_2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min_1) {
                min_1 = nums[i];
            } else if (nums[i] <= min_2) {
                min_2 = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence solution = new IncreasingTripletSubsequence();

        int[] test1 = { 1, 2, 3, 4, 5 };
        int[] test2 = { 5, 4, 3, 2, 1 };
        int[] test3 = { 2, 1, 5, 0, 4, 6 };

        System.out.println(solution.increasingTriplet(test1)); // Output: true
        System.out.println(solution.increasingTriplet(test2)); // Output: false
        System.out.println(solution.increasingTriplet(test3)); // Output: true
    }
}
