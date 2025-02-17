package hubspot.dsa;

import java.util.*;
/*
https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/description/?envType=company&envId=hubspot&favoriteSlug=hubspot-all

Given a string s, return the maximum number of occurrences of any substring under the following rules:

    The number of unique characters in the substring must be less than or equal to maxLetters.
    The substring size must be between minSize and maxSize inclusive.



Example 1:

Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
Output: 2
Explanation: Substring "aab" has 2 occurrences in the original string.
It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).

Example 2:

Input: s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
Output: 2
Explanation: Substring "aaa" occur 2 times in the string. It can overlap.

 */
public class MaximumNumberOfOccurance {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        // this is the sliding window question
        // the window will be of minSize

        // first do a null check
        if(s == null || s.length() == 0)
            return 0;

        // map to maintain the counts for each strings(substring of windos size)
        Map<String,Integer> countMap = new HashMap<>();
        int maxCount = 0;

        // for loop end condition is very important
        for(int i=0;i<s.length() - minSize +1;i++){
            // create a substring from i to i+minSize
            String currentSubstring = s.substring(i,i+minSize);
            if(isValid(currentSubstring,maxLetters)){
                countMap.put(currentSubstring,countMap.getOrDefault(currentSubstring, 0)+1);
                maxCount = Math.max(maxCount, countMap.get(currentSubstring));
            }

        }
        return maxCount;
    }
    public boolean isValid(String s,int maxLetters){
        Set<Character> set = new HashSet<>();
        for(char c:s.toCharArray())
            set.add(c);

        // checking the size of the maxletter in current substring
        return set.size() <= maxLetters;
    }

}

