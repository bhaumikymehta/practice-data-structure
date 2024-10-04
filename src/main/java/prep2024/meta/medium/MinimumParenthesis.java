package prep2024.meta.medium;

public class MinimumParenthesis {
    class Solution {
        public String minRemoveToMakeValid(String s) {

            StringBuilder result = new StringBuilder();
            StringBuilder sb = new StringBuilder();

            int n = s.length();
            int op = 0;
            // this is simple Solution
            // first loop will iterate in straight
            for (int i = 0; i < n; i++) {
                // open bracket then increment
                if (s.charAt(i) == '(') {
                    op++;
                }
                // close bracket and open counter is 0 then skip appending in final string or
                // else decrement op counter since we found close bracket
                if (s.charAt(i) == ')') {
                    if (op == 0)
                        continue;
                    op--;
                }
                sb.append(s.charAt(i));
            }
            // sb is result from above
            // iterate over it from last

            for (int i = sb.length() - 1; i >= 0; i--) {
                // if open and op>0 then decrement op and skip adding in result since its extra
                // bracket
                if (sb.charAt(i) == '(' && op > 0) {
                    op--;
                    continue;
                }
                result.append(sb.charAt(i));
            }
            return result.reverse().toString();

        }
    }

    public static void main(String[] args) {
        Solution solution = new MinimumParenthesis().new Solution();
        String input = "lee(t(c)o)de)";
        String output = solution.minRemoveToMakeValid(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }
    
}
