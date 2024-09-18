package prep2024.leetCode75.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 Given a string s, reverse only all the vowels in the string and return it
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
Example 1:
Input: s = "IceCreAm"
Output: "AceCreIm"
 */
public class ReverseVowelsOfString {

    public static String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList(
                'a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U'));
        char[] result = s.toCharArray();
        int start = 0, end = s.length() - 1;

        while (start < end) {
            if (set.contains(result[start])
                    && set.contains(result[end])) {
                char temp = result[start];
                result[start] = result[end];
                result[end] = temp;
                start++;
                end--;
            } else if (!set.contains(result[start])) {
                start++;
            } else if (!set.contains(result[end])) {
                end--;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String test1 = "hello";
        String test2 = "leetcode";
        String test3 = "aA";

        System.out.println(reverseVowels(test1)); // Output: holle
        System.out.println(reverseVowels(test2)); // Output: leotcede
        System.out.println(reverseVowels(test3)); // Output: Aa
    }
}
