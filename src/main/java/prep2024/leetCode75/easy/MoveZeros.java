package prep2024.leetCode75.easy;

import java.util.Arrays;

/*
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {

        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        while (j < n) {
            nums[j++] = 0;
        }

    }

    public static void main(String[] args) {
        MoveZeros mz = new MoveZeros();
        int[] nums = { 0, 1, 0, 3, 12 };
        System.out.println("Before: " + Arrays.toString(nums));
        mz.moveZeroes(nums);
        System.out.println("After: " + Arrays.toString(nums));
    }

}
