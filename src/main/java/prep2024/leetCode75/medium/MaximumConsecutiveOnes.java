package prep2024.leetCode75.medium;

public class MaximumConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {

        // initialize the variables
        int zero = 0, j = 0, size = 0;

        for (int i = 0; i < nums.length; i++) {

            // if value 0 then increment counter
            if (nums[i] == 0) {
                zero++;
            }
            // this for creating window
            while (zero > k) {

                if (nums[j] == 0) {
                    zero--;
                }
                j++;

            }

            size = Math.max(size, i - j + 1);

        }
        return size;
    }

    public static void main(String[] args) {
        MaximumConsecutiveOnes solution = new MaximumConsecutiveOnes();

        int[] test1 = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k1 = 2;
        System.out.println("Maximum consecutive ones for test1: " + solution.longestOnes(test1, k1)); // Output: 6

        int[] test2 = { 0, 0, 1, 1, 1, 0, 0 };
        int k2 = 0;
        System.out.println("Maximum consecutive ones for test2: " + solution.longestOnes(test2, k2)); // Output: 3

        int[] test3 = { 1, 1, 1, 1, 1 };
        int k3 = 2;
        System.out.println("Maximum consecutive ones for test3: " + solution.longestOnes(test3, k3)); // Output: 5
    }
}
