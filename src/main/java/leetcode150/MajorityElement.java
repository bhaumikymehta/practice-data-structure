package leetcode150;

import java.util.HashMap;
import java.util.Map;

/*Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3

Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int size = nums.length / 2;
        int max = 0;
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max && entry.getValue() >= size) {
                max = Math.max(max, entry.getValue());
                result = entry.getKey();
            }
        }

        return result;
    }

    // below method is using zero space and linear iteration time=n and space = 1
    public int majorityElementWithLinearZeroSpace(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] nums1 = { 3, 2, 3 };
        int result1 = majorityElement.majorityElement(nums1);
        System.out.println(result1); // Expected output: 3

        int[] nums2 = { 2, 2, 1, 1, 1, 2, 2 };
        int result2 = majorityElement.majorityElement(nums2);
        System.out.println(result2); // Expected output: 2

    }

}
