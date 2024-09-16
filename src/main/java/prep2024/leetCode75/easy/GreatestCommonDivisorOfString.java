package prep2024.leetCode75.easy;

public class GreatestCommonDivisorOfString {

    public static void main(String[] args) {
        GreatestCommonDivisorOfString solution = new GreatestCommonDivisorOfString();

        // Test cases
        String result1 = solution.gcdOfStrings("abc", "pqr");
        System.out.println(result1); // Output: ""

        String result2 = solution.gcdOfStrings("ababab", "abab");
        System.out.println(result2); // Output: "ab"

        String result3 = solution.gcdOfStrings("abcd", "pq");
        System.out.println(result3); // Output: ""

        String result4 = solution.gcdOfStrings("", "pq");
        System.out.println(result4); // Output: ""

        String result5 = solution.gcdOfStrings("abc", "");
        System.out.println(result5); // Output: ""
    }

    public String gcdOfStrings(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty()) {
            return "";
        }
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}