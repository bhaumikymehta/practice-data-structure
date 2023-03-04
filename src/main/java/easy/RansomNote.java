package easy;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (Character c : magazine.toCharArray()) {
            if (magazineMap.containsKey(c)) {
                magazineMap.put(c, magazineMap.get(c) + 1);
            } else {
                magazineMap.put(c, 1);
            }
        }
        for (Character c : ransomNote.toCharArray()) {
            if (!magazineMap.containsKey(c)) {
                return false;
            } else {
                if (magazineMap.get(c) - 1 < 0) {
                    return false;
                }
                magazineMap.put(c, magazineMap.get(c) - 1);
            }
        }
        return true;
    }
}