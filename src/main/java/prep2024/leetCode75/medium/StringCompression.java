package prep2024.leetCode75.medium;

/*
 
 Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

    If the group's length is 1, append the character to s.
    Otherwise, append the character followed by the group's length.

The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.
 */
public class StringCompression {
    public int compress(char[] chars) {

        StringBuilder sb = new StringBuilder();

        int counter = 1;
        for (int j = 0; j < chars.length; j++) {
            char current = chars[j];

            while (j < chars.length - 1 && current == chars[j + 1]) {
                counter++;
                j++;
            }
            sb.append(current);
            if (counter > 1) {
                sb.append(counter);
            }
            counter = 1;
        }

        char[] compressedChars = sb.toString().toCharArray();

        for (int i = 0; i < compressedChars.length; i++) {
            chars[i] = compressedChars[i];
        }

        return compressedChars.length;
    }

    public static void main(String[] args) {
        StringCompression solution = new StringCompression();

        char[] test1 = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        char[] test2 = { 'a' };
        char[] test3 = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };

        System.out.println("Compressed length: " + solution.compress(test1)); // Output: 6
        System.out.println("Compressed array: " + new String(test1, 0, solution.compress(test1))); // Output: a2b2c3

        System.out.println("Compressed length: " + solution.compress(test2)); // Output: 1
        System.out.println("Compressed array: " + new String(test2, 0, solution.compress(test2))); // Output: a

        System.out.println("Compressed length: " + solution.compress(test3)); // Output: 4
        System.out.println("Compressed array: " + new String(test3, 0, solution.compress(test3))); // Output: ab12
    }
}
