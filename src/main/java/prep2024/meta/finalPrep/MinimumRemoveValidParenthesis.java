package prep2024.meta.finalPrep;

import java.util.Stack;

/*
 * Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

    It is the empty string, contains only lowercase characters, or
    It can be written as AB (A concatenated with B), where A and B are valid strings, or
    It can be written as (A), where A is a valid string.

 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"

 */
public class MinimumRemoveValidParenthesis {

    public String minRemoveToMakeValid(String s) {

        // create a stack and we will check
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                // this is the main condition
                // when the stack character is ) and stack isnt empty
                // and peek is closing then only we will remove other wise we will push to the
                // stack
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            } else {
                continue;
            }
        }
        System.out.println(stack);
        // iterating string from the end
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!stack.isEmpty() && (int) stack.peek() == i) {
                stack.pop();
                continue;
            } else {
                sb.append(s.charAt(i));
            }
        }
        System.out.println("result: " + sb.toString());
        return sb.reverse().toString();
    }

    public String minRemoveToMakeValidWithoutStack(String s) {

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
