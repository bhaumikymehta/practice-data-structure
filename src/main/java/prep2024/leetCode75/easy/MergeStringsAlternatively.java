package prep2024.leetCode75.easy;

class Solution {

    // mysolution
    public String mergeAlternately(String word1, String word2) {
        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();
        StringBuilder result = new StringBuilder();

        int i = 0, j = 0;
        while (i < word1Arr.length && j < word2Arr.length) {
            result.append(word1Arr[i]);
            result.append(word2Arr[j]);
            i++;
            j++;
        }
        if (i < word1Arr.length)
            result.append(word1.substring(i));
        if (j < word2Arr.length)
            result.append(word2.substring(j));

        return result.toString();
    }

    // Optimized solution with ai
    public String mergeAlternatelyOptimized(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int maxLength = Math.max(word1.length(), word2.length());

        for (int i = 0; i < maxLength; i++) {
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String result1 = solution.mergeAlternately("abc", "pqr");
        System.out.println(result1); // Output: "apbqcr"

        String result2 = solution.mergeAlternately("ab", "pqrs");
        System.out.println(result2); // Output: "apbqrs"

        String result3 = solution.mergeAlternately("abcd", "pq");
        System.out.println(result3); // Output: "apbqcd"

        String result4 = solution.mergeAlternately("", "pq");
        System.out.println(result4); // Output: "pq"

        String result5 = solution.mergeAlternately("abc", "");
        System.out.println(result5); // Output: "abc"

        // Test cases
        String result6 = solution.mergeAlternatelyOptimized("abc", "pqr");
        System.out.println(result6);

        // Below is test case running with memory and time measurement for my code
        String word1 = "abc";
        String word2 = "pqr";

        // Measure execution time and memory usage
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Run garbage collector to get a more accurate memory usage

        long startTime = System.nanoTime();
        long startMemory = runtime.totalMemory() - runtime.freeMemory();

        String result = solution.mergeAlternately(word1, word2);

        long endTime = System.nanoTime();
        long endMemory = runtime.totalMemory() - runtime.freeMemory();

        long elapsedTime = endTime - startTime;
        long memoryUsed = endMemory - startMemory;

        double elapsedTimeMillis = elapsedTime / 1_000_000.0;

        System.out.println("Result: " + result);
        System.out.println("Execution time (nanoseconds): " + elapsedTimeMillis);
        System.out.println("Memory used (bytes): " + memoryUsed);

        // Below is test case running with memory and time measurement for Optimized
        // code

        // Measure execution time and memory usage
        runtime.gc(); // Run garbage collector to get a more accurate memory usage

        startTime = System.nanoTime();
        startMemory = runtime.totalMemory() - runtime.freeMemory();

        String result7 = solution.mergeAlternately(word1, word2);

        endTime = System.nanoTime();
        endMemory = runtime.totalMemory() - runtime.freeMemory();

        elapsedTime = endTime - startTime;
        memoryUsed = endMemory - startMemory;

        elapsedTimeMillis = elapsedTime / 1_000_000.0;

        System.out.println("Result: " + result7);
        System.out.println("Execution time (nanoseconds): " + elapsedTimeMillis);
        System.out.println("Memory used (bytes): " + memoryUsed);

    }
}