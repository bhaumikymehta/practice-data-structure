package prep2024.leetCode75.medium;

import java.util.HashMap;
import java.util.Map;

public class MaxNumbersOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // to check if that k-nums[i] present and had some value left or already paired
            if (map.containsKey(k - nums[i])
                    && map.get(k - nums[i]) > 0) {
                count++;
                map.put(k - nums[i], map.get(k - nums[i]) - 1);
            } else {
                // getOrDefault is easy way it directly checks if value is 0 returns 0 where I
                // added 1
                // and if some value is present then it return that value "similar to
                // map.get(i)" and I added 1 on it
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaxNumbersOfKSumPairs solution = new MaxNumbersOfKSumPairs();

        int[] nums1 = { 1, 2, 3, 4 };
        int k1 = 5;
        System.out.println("Test Case 1: " + solution.maxOperations(nums1, k1)); // Expected output: 2

        int[] nums2 = { 3, 1, 3, 4, 3 };
        int k2 = 6;
        System.out.println("Test Case 2: " + solution.maxOperations(nums2, k2)); // Expected output: 1

        int[] nums3 = { 1, 2, 3, 4, 5, 6 };
        int k3 = 7;
        System.out.println("Test Case 3: " + solution.maxOperations(nums3, k3)); // Expected output: 3
    }
}
