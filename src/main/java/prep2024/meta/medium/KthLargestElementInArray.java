package prep2024.meta.medium;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int n : nums) {
            heap.add(n);
            // main logic is here when the heap grows we remove the smallest element to
            // maintain k largest element
            if (heap.size() > k) {
                heap.remove();
            }
        }
        return heap.peek();
    }
    public static void main(String[] args) {
        KthLargestElementInArray solution = new KthLargestElementInArray();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = solution.findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is " + result);
    }

}
