package leetcode150;

public class MergeSortedArray {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // the strategy here is start with one pointer pointing at m and second ptr at n

        int ptr1 = m - 1;
        int ptr2 = n - 1;

        for (int i = nums1.length - 1; i >= 0; i--) {
            if (ptr2 < 0)
                break;
            if (ptr1 > 0 && nums1[ptr1] > nums2[ptr2]) {
                nums1[i] = nums1[ptr1--];
                // ptr1--;
            } else {
                nums1[i] = nums2[ptr2--];
                // ptr2--;
            }

        }
    }
    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        mergeSortedArray.merge(nums1, 3, nums2, 3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
}


