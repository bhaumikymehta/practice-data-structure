package prep2024.leetCode75.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfVowels {
    public int maxVowels(String s, int k) {
        // simple technique for sliding window
        // first create a window till legth defined
        // then subtract previous and add last
        int max = 0;
        Set<Character> vowels = new HashSet<>(Arrays.asList(
                'a', 'e', 'i', 'o', 'u'));
        char[] arr = s.toCharArray();
        int i = 0, j = 0;
        int counter = 0;
        while (j < k) {
            if (vowels.contains(arr[j])) {
                counter++;
            }
            j++;
        }
        max = counter;
        while (j < arr.length) {
            if (vowels.contains(arr[i])) {
                counter--;
            }
            if (vowels.contains(arr[j])) {
                counter++;
            }
            max = Math.max(max, counter);
            i++;
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumNumberOfVowels solution = new MaximumNumberOfVowels();

        String test1 = "abciiidef";
        int k1 = 3;
        System.out.println("Maximum number of vowels in test1: " + solution.maxVowels(test1, k1)); // Output: 3

        String test2 = "aeiou";
        int k2 = 2;
        System.out.println("Maximum number of vowels in test2: " + solution.maxVowels(test2, k2)); // Output: 2

        String test3 = "leetcode";
        int k3 = 3;
        System.out.println("Maximum number of vowels in test3: " + solution.maxVowels(test3, k3)); // Output: 2
    }

}
