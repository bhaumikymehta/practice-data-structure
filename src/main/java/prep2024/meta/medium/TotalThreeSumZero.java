package prep2024.meta.medium;

public class TotalThreeSumZero {

    public static boolean threeSum(int[] nums) {
        if(nums.length< 3){
            return false;
        }
        int i=0,k=nums.length-1;

        for (i=0;i< nums.length-2 ; i++){
            int j = i+1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0 ){
                    return true;
                }
                j++;
                k--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        boolean result = threeSum(new int[] { 3,-3,0 });
        System.out.println("Result for three sum : " +result);

    }

}
