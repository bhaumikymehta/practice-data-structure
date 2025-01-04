package prep2024.amazon;

public class WinnableArray {

    public static void main(String[] args) {

        int[] nums1 = { 3, 2, 0, 1, 3, 1, 2, 0, 0 };
        int[] nums2 = { 2, 6, 5, 4, 3, 2, 1, 0, 0 };
        System.out.println(isWinnable(nums1)); // Output: true
        System.out.println(isWinnable(nums2)); // Output: false
    }

    public static boolean isWinnable(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length && i <= farthest; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
