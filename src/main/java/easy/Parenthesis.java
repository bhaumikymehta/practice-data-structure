package easy;

import java.util.Stack;

public class Parenthesis {

    // String s="()(){}[";
    public static boolean isValidParenthesis(String input) {
        
        Stack<Character> stack = new Stack<>();

        for (Character c : input.toCharArray()) {
        
                if (c == '}' ) {
                    if (!stack.isEmpty() && '{' == stack.peek()) {
                        stack.pop();
                    }
                } else if (!stack.isEmpty() && c == '>') {
                    if ('<' == stack.peek()) {
                        stack.pop();
                    }
                }
                else if (!stack.isEmpty() && c == ']') {
                    if ('[' == stack.peek()) {
                        stack.pop();
                    }
                }
                else if ( !stack.isEmpty() && c == ')') {
                    if ('(' == stack.peek()) {
                        stack.pop();
                    }
                }else{
                    stack.push(c);
                }
            }
            return stack.isEmpty();
        }
    
        public static void main(String[] args) {
            System.out.println(isValidParenthesis("(){}"));
        }
    }

