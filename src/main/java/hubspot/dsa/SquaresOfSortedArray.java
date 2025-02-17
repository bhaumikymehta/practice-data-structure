package hubspot.dsa;

import java.util.Arrays;

/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.



Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

 */
public class SquaresOfSortedArray {

    // below appraoch is using two pointers which solves in O(N)
    public int[] sortedSquares(int[] nums) {
        int s=0;
        int e=nums.length-1;
        int[] result = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            if(Math.abs(nums[s])>Math.abs(nums[e])){
                result[i] = nums[s]*nums[s];
                s++;
            }else{
                result[i] = nums[e]*nums[e];
                e--;
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
    public int[] sortedSquaresWithSorting(int[] nums) {
        for(int i=0;i<nums.length ;i++){
            nums[i] = nums[i]* nums[i];
        }
        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));
        return nums;
    }
}
