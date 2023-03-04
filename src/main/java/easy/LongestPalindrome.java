package easy;

import java.util.HashMap;
import java.util.Map;

// The main logic for longest palindrome is 
// first we will count  all the characters and there occurances 
// if the occurance for the character is odd we will increment the odd counter
// or we will decrement the odd counter
// then the longest palindrome will be string length - odd counter and 
// we need add 1 since we are allowed one odd character in middle 
public class LongestPalindrome {
    
public int longestPalindrome(String s) {

        int oddCount = 0;
        Map<Character,Integer > map = new HashMap<>();
        for(Character c: s.toCharArray()){
            // putting all the Character in map
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.get(c) % 2 == 1){
                oddCount ++;
            }
            else
            {
                oddCount--;
            }
        }
        if(oddCount>1){
            return s.length() - oddCount +1;
        }
        return s.length();
    }
}
