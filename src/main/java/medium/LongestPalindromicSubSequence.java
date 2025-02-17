package medium;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-subsequence/description/?envType=company&envId=linkedin&favoriteSlug=linkedin-thirty-days">...</a>
 *  Longest Palindromic Subsequence
 *  Given a string s, find the longest palindromic subsequence's length in s.*
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 * Example 1:

 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".

 * Example 2:

 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 *
 */


// this solution is without using memotization
public class LongestPalindromicSubSequence {

    public int longestPalindromeSubseq(String s) {
        int n = s.length()-1;
        return lps(s.toCharArray(),0,n);

    }
    public int lps(char[] sArr,int start , int end){
        // edge cases
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 1;
        }
        int answer= 0;
        // when first and last character matches add 2 two the answer and pass the substring
        if( sArr[start] == sArr[end]){
            answer = 2 + lps(sArr , start + 1, end-1 );
        }
        // when the charcter doesnt match pass substring by skipping
        else{
            answer = Math.max(
                    lps(sArr , start , end-1),
                    lps(sArr, start+1, end )
            );
        }
        return answer;
    }
}
