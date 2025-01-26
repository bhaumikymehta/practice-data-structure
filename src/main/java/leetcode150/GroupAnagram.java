package leetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        // first we will sort the values
        // create a map
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] keyArr = strs[i].toCharArray();
            // sort the character string
            Arrays.sort(keyArr);
            String key = new String(keyArr);
            // if stringh is present add the original value to list
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagram solution = new GroupAnagram();
        
        // Test case 1: Mixed anagrams
        String[] input1 = {"eat","tea","tan","ate","nat","bat"};
        System.out.println("Test 1:");
        System.out.println(solution.groupAnagrams(input1));
        
        // Test case 2: Empty strings
        String[] input2 = {"", "", "a"};
        System.out.println("Test 2:"); 
        System.out.println(solution.groupAnagrams(input2));
        
        // Test case 3: Single element
        String[] input3 = {"hello"};
        System.out.println("Test 3:");
        System.out.println(solution.groupAnagrams(input3));
        
        // Test case 4: Multiple anagram groups
        String[] input4 = {"listen", "silent", "elbow", "below", "state", "taste"};
        System.out.println("Test 4:");
        System.out.println(solution.groupAnagrams(input4));
    }

}
