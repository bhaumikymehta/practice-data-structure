package org.example;
import hubspot.dsa.TwoSum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

        @Test
        void testTwoSum() {
            // Test case 1
            int[] nums1 = {2, 7, 11, 15};
            int target1 = 9;
            int[] expected1 = {0, 1};
            assertArrayEquals(expected1, TwoSum.twoSum(nums1, target1));

            // Test case 2
            int[] nums2 = {3, 2, 4};
            int target2 = 6;
            int[] expected2 = {1, 2};
            assertArrayEquals(expected2, TwoSum.twoSum(nums2, target2));

            // Test case 3
            int[] nums3 = {3, 3};
            int target3 = 6;
            int[] expected3 = {0, 1};
            assertArrayEquals(expected3, TwoSum.twoSum(nums3, target3));

            // Test case 4: No solution (empty array)
            int[] nums4 = {};
            int target4 = 5;
            int[] expected4 = {};
            assertArrayEquals(expected4, TwoSum.twoSum(nums4, target4));

            // Test case 5: No solution (no valid pair)
            int[] nums5 = {1, 2, 3};
            int target5 = 7;
            int[] expected5 = {};
            assertArrayEquals(expected5, TwoSum.twoSum(nums5, target5));
        }
    }
