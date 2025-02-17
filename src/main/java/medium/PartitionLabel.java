package medium;
import java.util.*;


/**
 * https://leetcode.com/problems/partition-labels/description/?envType=company&envId=linkedin&favoriteSlug=linkedin-thirty-days
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
 *
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 *
 * Return a list of integers representing the size of these parts.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 *
 * Example 2:
 *
 * Input: s = "eccbbbbdec"
 * Output: [10]
 */
public class PartitionLabel {


    public List<Integer> partitionLabels(String s) {
        Map<Character , Integer> map = new HashMap<>();
        // we are storing all the characters last index
        for(int i=0;i <s.length();i++){
            map.put(s.charAt(i), i);
        }

        int startIndex = 0;
        List<Integer> result = new ArrayList<>();
        // while loop to interate over the string
        while(startIndex<s.length()){
            int lastIndex = startIndex;
            int maxLastIndex = 0;
            for(int k=startIndex;k<s.length();k++){
                // finding the max last index value
                maxLastIndex = Math.max(maxLastIndex, map.get(s.charAt(k)));
                // terminate condition for inner loop when k is maxLastIndex
                if(k==maxLastIndex){
                    lastIndex = k;
                    break;
                }
            }
            result.add(lastIndex - startIndex +1);
            // update the startIndex
            startIndex = lastIndex + 1;
        }

        return result;
    }
}
