package hubspot.dsa;

import java.util.Arrays;

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.



Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

 */
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // we will start with two ptr
        int ptr1 = m-1;
        int ptr2 = n-1;

        // we will add the element at the end of the nums1
        for (int i= m+n-1;i>=0; i--){
            if(ptr2<0)
                break;
            // when last value of nums1 is small then nums2 we will insert nums2 to the end of array
            if(ptr1 >= 0 && nums1[ptr1] > nums2[ptr2]){
                nums1[i] = nums2[ptr1--];
                //ptr1--;
            }else{
                nums1[i] = nums1[ptr2--];
                //ptr2--;
            }
        }

        for(int i : nums1){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        merge(arr1,3,arr2,3);
    }
}