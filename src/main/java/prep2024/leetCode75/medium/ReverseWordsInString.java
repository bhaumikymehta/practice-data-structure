package prep2024.leetCode75.medium;

import java.util.Arrays;

public class ReverseWordsInString {
    public static String reverseWords(String s) {
        // first need to trim the String
        // then will split the string in array
        // then will have two pointers to iterate from start and end
        // then swap
        String[] arr = s.replaceAll("\\s+", " ").trim().split(" ");
        int start = 0, end = arr.length - 1;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
        // StringBuilder sb= new StringBuilder();
        // for(String str:arr){
        // sb.append(str);
        // sb.append(" ");
        // }
        String result = new String(Arrays.toString(arr)
                .replaceAll("[,\\[\\]]", ""));
        // return sb.toString().trim();
        return result;
    }

    public static String[] swap(String[] arr, int i, int j) {
        String temp = arr[i].trim();
        arr[i] = arr[j].trim();
        arr[j] = temp;
        return arr;
    }

    public static String reverseWordsSimple(String s) {
        StringBuilder out = new StringBuilder();
        String[] arr = s.trim().split("\\s+");
        for (int i = arr.length - 1; i > 0; i--) {
            out.append(arr[i]);
            out.append(" ");
        }
        return out + arr[0];
    }

    public static void main(String[] args) {
        String test1 = "the sky is blue";
        String test2 = "  hello world  ";
        String test3 = "a good   example";
        System.out.println(reverseWords(test1)); // Output: "blue is sky the"
        System.out.println(reverseWords(test2)); // Output: "world hello"
        System.out.println(reverseWords(test3)); // Output: "example good a"

        System.out.println(reverseWordsSimple(test1)); // Output: "blue is sky the"
        System.out.println(reverseWordsSimple(test2)); // Output: "world hello"
        System.out.println(reverseWordsSimple(test3)); // Output: "example good a"
    }
}
