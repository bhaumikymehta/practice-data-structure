package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ValidParenthesis {
    public boolean isValid(String s) {
        Map<Character,Character> brackets= new HashMap<>();
        brackets.put('}','{');
        brackets.put(']','[');
        brackets.put(')','(');
        brackets.put('>','<');

        List<Character> list= new ArrayList<>();
        for(char c:s.toCharArray()){
            if(brackets.containsKey(c)){
                if(list.isEmpty())
                    return false;
                char value= brackets.get(c);
                if(!list.isEmpty() && value != list.remove(list.size()-1)){
                    return false;
                }
            }else{
                list.add(c);
            }
            // System.out.println(list.size());
        }
        if(!list.isEmpty())
            return false;
        return true;
    }
}

class SollutionValidParenthesis{
    public static void main(String[] args) {
        ValidParenthesis validParenthesis = new ValidParenthesis();
        boolean result=validParenthesis.isValid("[({})]");
        System.out.println("Result for valid parenthesis :"+result);
    }
}