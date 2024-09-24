package prep2024.leetCode75.easy;

public class MaximumAvgSubArray {
    public double findMaxAverage(int[] nums, int k) {
        // initialize max value
        // add all four elements in an array and take avg
        // move window till end to find the maximum value

        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i];
        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        MaximumAvgSubArray solution = new MaximumAvgSubArray();

        int[] test1 = { 1, 12, -5, -6, 50, 3 };
        int k1 = 4;
        System.out.println("Maximum average for test1: " + solution.findMaxAverage(test1, k1)); // Output: 12.75

        int[] test2 = { 5, 5, 5, 5 };
        int k2 = 2;
        System.out.println("Maximum average for test2: " + solution.findMaxAverage(test2, k2)); // Output: 5.0

        int[] test3 = { 0, 4, 0, 3, 2 };
        int k3 = 1;
        System.out.println("Maximum average for test3: " + solution.findMaxAverage(test3, k3)); // Output: 4.0
    }

}
