package prep2024.meta.finalPrep;

/*
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.

 

Example 1:

Input: s = "aba"
Output: true

Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Example 3:

Input: s = "abc"
Output: false


 */
public class Palindrome2 {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return isPalin(s, i, j - 1) || isPalin(s, i + 1, j);
            }
        }

        return true;
    }

    public boolean isPalin(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // write test
        System.out.println(new Palindrome2().validPalindrome("abc"));
        System.out.println(new Palindrome2().validPalindrome("abca"));
        System.out.println(new Palindrome2().validPalindrome("aba"));
    }

}
