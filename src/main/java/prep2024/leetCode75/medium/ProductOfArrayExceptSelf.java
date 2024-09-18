package prep2024.leetCode75.medium;

/* Need to be solved using prefix and suffix array
  Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
  
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.
Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int suf[] = new int[n];
        pre[0] = 1;
        suf[n - 1] = 1;
        // prefix for all except the current value
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        // suff of all after except the current
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] * nums[i + 1];
        }

        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = pre[i] * suf[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        int[] nums = { 1, 2, 3, 4 };
        int[] result = solution.productExceptSelf(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

}
