package datastructure.templates;
import java.util.HashMap;
import java.util.Map;

/*

    Finding the largest substring without repeating characters in a given string (variable-length).
    Finding the largest substring containing a single character that can be made by replacing at most k characters in a given string (variable-length).
    Finding the largest sum of a subarray of size k without duplicate elements in a given array (fixed-length).

 */

public class VariableLengthSlidingWindow {

        public int variableLengthSlidingWindow(int nums[]) {
            // Choose appropriate data structure for the "state"
            // Example: HashMap to store counts of elements (if needed)
            Map<Integer, Integer> state = new HashMap<>();

            int start = 0;
            int maxLen = 0;

            for (int end = 0; end < nums.length; end++) {
                // Extend window: Add nums[end] to the state (O(1) time)
                int currentNum = nums[end];
                state.put(currentNum, state.getOrDefault(currentNum, 0) + 1);

                // Check if the state is invalid and contract the window until it's valid
                while (!isValid(state)) { // Replace isValid with your actual validation logic
                    // Contract window: Remove nums[start] from the state (O(1) time)
                    int numToRemove = nums[start];
                    state.put(numToRemove, state.get(numToRemove) - 1);
                    if (state.get(numToRemove) == 0) {
                        state.remove(numToRemove); // Clean up if count becomes 0
                    }
                    start++;
                }

                // INVARIANT: state of current window is valid here.
                maxLen = Math.max(maxLen, end - start + 1);
            }

            return maxLen;
        }

        // Example isValid function (replace with your actual validation logic)
        private boolean isValid(Map<Integer, Integer> state) {
            // Example: Check if all elements have a count less than or equal to 2
            for (int count: state.values()) {
                if (count > 2) {
                    return false;
                }
            }
            return true;
        }


        public static void main(String args) {
            VariableLengthSlidingWindow solution = new VariableLengthSlidingWindow();
            int[] nums = new int[]{1, 2, 3, 1, 2, 1, 2, 3, 4};  // Example input
            int result = solution.variableLengthSlidingWindow(nums);
            System.out.println("Max Length: " + result); // Output will vary depending on your isValid()
        }
    }