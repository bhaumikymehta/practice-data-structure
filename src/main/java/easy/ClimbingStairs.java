package easy;

public class ClimbingStairs {
    // public int climbStairs(int n) {
    // // simple fibonnaci solution add all the previous steps back.@interface
    // if(n<=2){ return n;}
    // int[] arr= new int[n+1];
    // arr[0] = 1;
    // arr[1] = 2;

    // for(int i=2;i<n;i++){
    // arr[i] = arr[i-1]+arr[i-2];
    // }
    // return arr[n-1];
    // }
    public int climbStairs(int n) {
        // try to make it recrusive solution
        if (n <= 2) {
            return n;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
