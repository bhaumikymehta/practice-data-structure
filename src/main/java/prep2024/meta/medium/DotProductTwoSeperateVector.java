package prep2024.meta.medium;

//1570. Dot Product of Two Sparse Vectors

public class DotProductTwoSeperateVector {

}

class SparseVector {
    int[] nums;

    SparseVector(int[] nums) {
        this.nums = nums;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int total = 0;
        for (int i = 0; i < vec.nums.length; i++) {
            int temp = this.nums[i] * vec.nums[i];
            total += temp;
        }
        return total;
    }
}
