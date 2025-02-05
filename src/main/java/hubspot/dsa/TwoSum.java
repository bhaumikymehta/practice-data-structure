package hubspot.dsa;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        if(nums.length == 0){
            return new int[]{};
        }

        for(int i=0;i<nums.length;i++){
            int diff= target-nums[i];
            if(map.containsKey(diff)
                    && map.get(diff)!=i){
                return new int[]{map.get(diff),i};
            }
            map.put(nums[i],i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] input = new int[]{2,7,11,15};
        int[] result = twoSum(input,9);
        System.out.println("Expected result is [0,1] for 9 as target Result : " + result[0]+","+result[1]);

    }

}
