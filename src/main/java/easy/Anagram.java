package easy;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        Map<Character,Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Character c: t.toCharArray()){
            if(map.containsKey(c)){
                if(map.get(c)-1<0){
                    return false;
                }
                map.put(c,map.get(c)-1);
            }else{
                return false;
            }
        }
        return true;
    }
}

class SolutionAnagram{
    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        boolean result=anagram.isAnagram("test","estt");
        System.out.println("Result for valid Anagram :"+result);
    }
}
