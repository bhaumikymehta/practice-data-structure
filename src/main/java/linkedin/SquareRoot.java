package linkedin;
/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

    For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.



Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
-----------------------------------
Other question which can be solved using similar approach

Given a positive integer num, return true if num is a perfect square or false otherwise.

A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.

You must not use any built-in library function, such as sqrt.



Example 1:

Input: num = 16
Output: true
Explanation: We return true because 4 * 4 = 16 and 4 is an integer.

 */
public class SquareRoot {
    public static int mySqrt(int x) {
        // its basically  create a int array 1 to x
        // we will solve using binary search
        int i=0;
        int j=x;
        int mid =0;
        while(i <= j){
            mid = i+(j-i)/2;

            if(mid * mid == x){
                return Math.round(mid);
            }
            else if(mid*mid > x){
                j = mid-1;
            }else{
                i = mid +1;
            }
        }
        return Math.round(j);
    }
}
