package prep2024.leetCode75.medium;

/*Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

 

Example 1:

Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
 */

public class LongestSubArrayOnes {

    public int longestSubarray(int[] nums) {
        // here j is start and ans is result
        int i = 0, j = 0, zeros = 0, ans = 0;

        for (i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                zeros++;
            }
            while (zeros > 1) {
                zeros = zeros - (nums[j] == 0 ? 1 : 0);
                j++;
            }
            ans = Math.max(ans, i - j);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        LongestSubArrayOnes solution = new LongestSubArrayOnes();

        int[] test1 = { 1, 1, 0, 1, 1, 1 };
        System.out.println("Longest subarray of 1s for test1: " + solution.longestSubarray(test1)); // Output: 5

        int[] test2 = { 0, 1, 1, 1, 0, 1, 1, 0, 1 };
        System.out.println("Longest subarray of 1s for test2: " + solution.longestSubarray(test2)); // Output: 4

        int[] test3 = { 1, 1, 1, 1, 1 };
        System.out.println("Longest subarray of 1s for test3: " + solution.longestSubarray(test3)); // Output: 4

        int[] test4 = { 0, 0, 0 };
        System.out.println("Longest subarray of 1s for test4: " + solution.longestSubarray(test4)); // Output: 0
    }

    
}
