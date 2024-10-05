package prep2024.meta.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

// 1762. Buildings With an Ocean View
public class BuildingWithOceanView {
    public int[] findBuildings(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (int i = 1; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] >= heights[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);

        }
        List<Integer> result = new ArrayList<>();
        int[] reversedDeque = new int[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            reversedDeque[i] = stack.pop();
        }
        return reversedDeque;
    }

    public static void main(String[] args) {
        BuildingWithOceanView solution = new BuildingWithOceanView();
        int[] heights = { 4, 2, 3, 1 };
        int[] result = solution.findBuildings(heights);
        System.out.println(Arrays.toString(result));
    }
}
