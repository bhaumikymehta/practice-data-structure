package medium;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/913461127/
// Two pointer is a easy solution for this question 
public class TwoSumNew {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int[] result = new int[2];
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                result[0] = l + 1;
                result[1] = r + 1;
                break;
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }

        }
        return result;
    }
}