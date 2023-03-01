package easy;


// the most important part it to remember that mid is always going to be start + end-start/2
public class BinarySearch {

    public int search(int[] nums, int target) {
        // This is going to get solved by binary search

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + (end - start / 2));
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}

class SollutionBinarySearch {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.search(new int[] { 2, 3, 4, 5, 7 }, 5);
        System.out.println("Result for Binary search  - " + result);
    }
}
