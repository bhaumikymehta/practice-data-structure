package prep2024.leetCode75.easy;

/*You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

 

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true

Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // first iterate over an array
        // i f adjacent is 1 then move ahead
        // if not then decrease n and change value for that element to 1
        // check if at end n is zero or minus then return true

        if (n == 0)
            return true;

        for (int i = 0; i < flowerbed.length; i++) {
            // check for value is 0 at current location
            // second check is for previous value is 0
            // third check is for next value is 0
            if (flowerbed[i] == 0
                    && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                n = n - 1;
                flowerbed[i] = 1;
            }
        }

        if (n <= 0)
            return true;

        return false;
    }

    public static void main(String[] args) {
        // Your code here
        CanPlaceFlowers solution = new CanPlaceFlowers();
        int[] flowerbed = { 1, 0, 0, 0, 1 };
        int n = 1;
        boolean result = solution.canPlaceFlowers(flowerbed, n);
        System.out.println(result); // Expected output: true

    }
}