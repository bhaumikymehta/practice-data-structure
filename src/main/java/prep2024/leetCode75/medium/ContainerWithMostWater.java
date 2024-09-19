package prep2024.leetCode75.medium;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int result = 0;
        while (l < r) {
            // left bar is smaller then right
            if (height[l] < height[r]) {
                if (height[l] * (r - l) >= result) {
                    result = height[l] * (r - l);
                }
                l++;
            } else {
                if (height[r] * (r - l) >= result) {
                    result = height[r] * (r - l);
                }
                r--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ContainerWithMostWater container = new ContainerWithMostWater();

        int[] heights1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println("Max area for heights1: " + container.maxArea(heights1));

        int[] heights2 = { 1, 1 };
        System.out.println("Max area for heights2: " + container.maxArea(heights2));

        int[] heights3 = { 4, 3, 2, 1, 4 };
        System.out.println("Max area for heights3: " + container.maxArea(heights3));

        int[] heights4 = { 1, 2, 1 };
        System.out.println("Max area for heights4: " + container.maxArea(heights4));
    }

}
