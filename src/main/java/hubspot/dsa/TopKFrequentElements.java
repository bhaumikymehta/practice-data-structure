package hubspot.dsa;
import java.util.*;

/*
https://leetcode.com/problems/top-k-frequent-elements/description/?envType=company&envId=hubspot&favoriteSlug=hubspot-all

Given an integer array nums and an integer k, return the k most frequent elements.
You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]

 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        if(nums.length == 0)
            return null;
        // building the frequency map to count all the characters
        Map<Integer,Integer> freqMap = new HashMap<>();
        for( int i: nums){
            freqMap.put(i, freqMap.getOrDefault(i,0)+1);
        }
        // this is important to compare the value part
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(
                (a,b) -> a.getValue() - b.getValue()
        );

        // iterating over the map and maintaining the queue
        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            queue.offer(entry);
            if (queue.size()>k) {
                queue.poll();
            }
        }

        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = queue.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = solution.topKFrequent(nums, k);

        System.out.println("Top " + k + " frequent elements: " + Arrays.toString(result));
    }
}
